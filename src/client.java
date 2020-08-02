import org.apache.commons.codec.binary.Hex;

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
            byte[] sendData = new byte[1154];
            byte[] receiveData = new byte[1154];
            String sentence="3FFF";
            byte[] sendDataFirst = Hex.decodeHex(sentence);
            System.out.println(sendDataFirst.length);
            for (int i = 0; i < 2; i++) {
                sendData[i]= sendDataFirst[i];
            }

            final Random random = new Random();
            for (int i = 2; i <1154 ; i++) {
                sendData[i] =(byte) (random.nextInt(100));
            }

           // sendData = sentence.getBytes();
            Thread.sleep(1000);
            for (int i = 0; i < 2; i++) {
                System.out.println((i+1)+":"+(int)sendData[i]);
            }

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 55555);
            clientSocket.send(sendPacket);

        }
    }


    //clientSocket.close();
}


