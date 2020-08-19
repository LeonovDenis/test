import javax.xml.bind.DatatypeConverter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Server {
    public static void main(String args[]) throws Exception
    {
        DatagramSocket serverSocket = new DatagramSocket(55556);
        byte[] receiveData = new byte[256];

        System.out.println("Добро пожаловать на Серверную чаcть");
        while(true)
        {
            byte[] sendData = new byte[256];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            String sentence = new String( receivePacket.getData());
            System.out.println("RECEIVED: " + sentence);

            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();
            sendData = receivePacket.getData();
            for (int i = 0; i <receiveData.length ; i++) {
                System.out.println("bytes: "+i+"// " +receiveData[i]);
            }
            System.out.println("port:"+receivePacket.getPort());

            DatagramPacket sendPacket =
                    new DatagramPacket(sendData, sendData.length, IPAddress, port);
            serverSocket.send(sendPacket);

        }
    }
}
