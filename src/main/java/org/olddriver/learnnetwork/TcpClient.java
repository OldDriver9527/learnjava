package org.olddriver.learnnetwork;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpClient {

    public static void main(String[] args) throws IOException {


        //创建监听socket，监听socket绑定到指定ip，端口
        //监听socket开始监听端口
        ServerSocket serverSocket = new ServerSocket(6666);
        while (true){
            //当客户端请求建立连接，监听socket会创建连接socket，与客户端通信
            Socket linkSocket = serverSocket.accept();
            InputStream in = linkSocket.getInputStream();

            byte[] bytes = new byte[1024];
            int read = in.read(bytes);
            System.out.println(new String(bytes,0,read));
            OutputStream out = linkSocket.getOutputStream();

            out.write("hello client".getBytes());
            linkSocket.close();
        }
//        System.out.println(args.length);
//
//        //创建连接socket，请求服务器建立连接
//        Socket socket = new Socket("127.0.0.1",6666);
//
//        OutputStream out = socket.getOutputStream();
//        out.write("hello server".getBytes());
//        InputStream in = socket.getInputStream();
//        byte[] bytes = new byte[1024];
//        int read = in.read(bytes);
//        System.out.println(new String(bytes,0,read));
//
//        socket.close();
    }
}
