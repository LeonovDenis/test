import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Random;

public class client {

    public static void main(String args[]) throws Exception {
        while (true) {
            System.out.println("Введите то что вы хотите отправить на сервер");
           // BufferedReader inFromUser =
           //         new BufferedReader(new InputStreamReader(System.in));
            DatagramSocket clientSocket = new DatagramSocket();
            InetAddress IPAddress = InetAddress.getByName("localhost");
            byte[] sendData = new byte[1024];
            byte[] receiveData = new byte[1024];
           // String sentence = inFromUser.readLine();
           // sendData = sentence.getBytes();
            final Random random = new Random();
            for (int i = 0; i <1000 ; i++) {
                sendData[i] =(byte) (random.nextInt(100));
            }

           // sendData = sentence.getBytes();
            Thread.sleep(10000);


            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 55555);
            clientSocket.send(sendPacket);

        }
    }


    //clientSocket.close();
}


