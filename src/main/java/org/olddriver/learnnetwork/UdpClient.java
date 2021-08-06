package org.olddriver.learnnetwork;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpClient {
    public static void main(String[] args) throws IOException {
        byte[] bytes = "hello server".getBytes();
        InetAddress address = InetAddress.getByName("localhost");
        DatagramPacket packet = new DatagramPacket(bytes,bytes.length,address,6666);

        DatagramSocket socket = new DatagramSocket();


        socket.send(packet);
    }
}
