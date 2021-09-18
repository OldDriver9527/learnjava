package org.olddriver.learnnetwork;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {

    public static void main(String[] args) throws IOException {
        //创建欢迎socket，欢迎socket绑定到指定ip，端口
        //欢迎socket开始等待客户端tcp连接请求
        ServerSocket serverSocket = new ServerSocket(6666);
        //当客户端请求建立连接，监听socket会创建连接socket，与客户端通信

        Socket connectionSocket = serverSocket.accept();
        OutputStream outputStream = connectionSocket.getOutputStream();
        InputStream inputStream = connectionSocket.getInputStream();
        byte[] bytes = new byte[1024];

        int length = length = inputStream.read(bytes);
        System.out.println(new String(bytes,0,length));


        outputStream.write("hello".getBytes());


        //            InputStream in = linkSocket.getInputStream();
//
//            byte[] bytes = new byte[1024];
//            int read = in.read(bytes);
//            System.out.println(new String(bytes,0,read));
//            OutputStream out = linkSocket.getOutputStream();
//
//            out.write("hello client".getBytes());
//            linkSocket.close();

    }
}
