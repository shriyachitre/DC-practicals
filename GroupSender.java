import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class GroupSender {
    public static void main(String[] args) throws IOException {
      
        MulticastSocket socket = new MulticastSocket();
        InetAddress address = InetAddress.getByName("230.0.0.1");
        int port = 5000;
        String message = "Hello, group!";
        byte[] data = message.getBytes();
        DatagramPacket packet = new DatagramPacket(data, data.length, address, port);
        socket.send(packet);
        socket.close();
    }
}