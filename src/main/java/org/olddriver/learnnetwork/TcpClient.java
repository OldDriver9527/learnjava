package org.olddriver.learnnetwork;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TcpClient {

    public static void main(String[] args) throws IOException {

        //创建连接socket，请求服务器建立连接
        Socket connectionSocket = new Socket("127.0.0.1", 6666);

        OutputStream out = connectionSocket.getOutputStream();
        out.write("hello".getBytes());
        InputStream in = connectionSocket.getInputStream();
        byte[] bytes = new byte[1024];

        int length = length = in.read(bytes);
        System.out.println(new String(bytes, 0, length));

        connectionSocket.close();
    }
}
