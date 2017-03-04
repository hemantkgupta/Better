import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ghemant on 10/16/16.
 */
public class The_Boyfriend_Problems {
    public static void main(String args[] ) throws Exception {

        //Scanner s = new Scanner(System.in);
        //int N = s.nextInt();

        int N =5;
        List<Long[]> data = new ArrayList<Long[]>(N);

            Long[] data1 = {5l, 2l, 3l, 1l, 4l};
            for (int j = 0; j < data1.length; j++) {
                Arrays.sort(data1);
            }
        data.add(data1);
        String out = Arrays.toString(data.get(0));
        out = out.replace("[", "");
        out = out.replace("]", "");
        out = out.replaceAll(",", "");
        System.out.println(out);
    }
}
