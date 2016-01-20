package advanced;

/**
 * Created by hemant on 16/10/15.
 */
public class B014MinMaxWithoutBranching {

    public static void main(String[] args) {
        System.out.println(min(2,7));
        System.out.println(max(2,7));
    }

    public static int min(int x, int y) {
        return y + ((x - y) & ((x - y) >> 31));
    }

    public static int max(int x, int y) {
        return x - ((x - y) & ((x - y) >> 31));
    }


}
