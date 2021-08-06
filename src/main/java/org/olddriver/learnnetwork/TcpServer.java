package org.olddriver.learnnetwork;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {

    public static void main(String[] args) throws IOException {
        //创建监听socket，监听socket绑定到指定ip，端口
        //监听socket开始监听端口
        ServerSocket serverSocket1 = new ServerSocket(6666);
        ServerSocket serverSocket2 = new ServerSocket(7777);
        //当客户端请求建立连接，监听socket会创建连接socket，与客户端通信

        Socket linkSocket1 = serverSocket1.accept();
        Socket linkSocket2 = serverSocket2.accept();




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
