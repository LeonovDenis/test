import org.apache.commons.codec.binary.Hex;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Random;

public class client {

    public static void main(String[] args) throws Exception {
        Short k = 0;
        int j = 0;
        while (true) {
            System.out.println("Введите то что вы хотите отправить на сервер");
            // BufferedReader inFromUser =
            //         new BufferedReader(new InputStreamReader(System.in));
            DatagramSocket clientSocket = new DatagramSocket();
            InetAddress IPAddress = InetAddress.getByName("localhost");
            byte[] sendData = new byte[1168];
            byte[] receiveData = new byte[1168];
            String sentence = "3FFF";
            byte[] sendDataFirst = Hex.decodeHex(sentence);
            System.out.println(sendDataFirst.length);
            for (int i = 0; i < 2; i++) {
                sendData[i] = sendDataFirst[i];
            }
            byte[] num = toBytes(++k);
            for (int i = 2; i < 4; i++) {

                sendData[i] = num[i - 2];
            }

            final Random random = new Random();
            for (int i = 8; i < 584; i++) {
                sendData[i] = (byte) (random.nextInt(100));
            }
            j = 0;
            for (int i = 584; i < 586; i++) {
                sendData[i] = sendDataFirst[j++];
            }
            num = toBytes(++k);
            j = 0;
            for (int i = 586; i < 588; i++) {

                sendData[i] = num[j++];
            }

            for (int i = 592; i < sendData.length; i++) {
                sendData[i] = (byte) (random.nextInt(100));
            }


            // sendData = sentence.getBytes();
            Thread.sleep(1000);
            for (int i = 0; i < 2; i++) {
                System.out.println((i + 1) + ":" + (int) sendData[i]);
            }
            for (int i = 584; i < 586; i++) {
                System.out.println((i + 1) + ":" + (int) sendData[i]);
            }


            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 55555);
            clientSocket.send(sendPacket);

        }
    }


    //clientSocket.close();

    public static byte[] toBytes(short s) {
        return new byte[]{(byte)(s & 0x00FF),(byte)((s & 0xFF00)>>8)};
    }
}

