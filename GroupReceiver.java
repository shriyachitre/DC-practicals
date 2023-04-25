import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class GroupReceiver {
    public static void main(String[] args) throws IOException {
        
        MulticastSocket socket = new MulticastSocket(5000);

        InetAddress address = InetAddress.getByName("230.0.0.1");
        socket.joinGroup(address);

        while (true) {
            byte[] data = new byte[1024];
            DatagramPacket packet = new DatagramPacket(data, data.length);
            socket.receive(packet);
            String message = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Received message: " + message);
        }
        
    }
}