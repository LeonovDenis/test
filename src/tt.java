public class tt {

    public static void main(String[] args) {

        byte[] b = {(byte) 0xC, (byte) 0x4D};
                            //3149 0000 1100   0100 1101
       Short shorts = Short.valueOf((short) (256 * ((byte) (b[0] & (byte) 0x7f)) + b[0 + 1]));
      //  System.out.println(shorts);
        System.out.println("hh");
    }

    public Short[] byt(byte[] b) {
        Short[] x = new Short[b.length / 2];
        int k = 0;
        for (int i = 0; i < b.length; i += 2) {
            x[k++] = Short.valueOf((short) (128 * ((byte) (b[i] & (byte) 0x7f)) + b[i + 1]));

        }

        return x;
    }

}
