package basic;

/**
 * Created by hemant on 16/10/15.
 */
public class BITB17FractionalDecimalToBinaryString {
    public static void main(String[] args) {
        double num = .125;
        System.out.println(printBinary(num));
    }

    public static String printBinary(double num) {
        if (num >= 1 || num <= 0) {
            return "ERROR";
        }

        StringBuilder binary = new StringBuilder();
        binary.append("."); // start the string with decimal
        while (num > 0) {
			/* Setting a limit on length: 32 characters */
            if (binary.length() > 32) {
                return "ERROR";
            }
            double r = num * 2;
            if (r >= 1) {
                binary.append(1);
                num = r - 1;
            } else {
                binary.append(0);
                num = r;
            }
        }
        return binary.toString();
    }

}
