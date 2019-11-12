package advanced;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by ghemant on 3/7/17.
 */
public class STRB09CompareObjects {

    public String name;
    public int score;

    public STRB09CompareObjects(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        STRB09CompareObjects[] player = new STRB09CompareObjects[n];
        Checker checker = new Checker();

        for(int i = 0; i < n; i++){
            player[i] = new STRB09CompareObjects(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }

    static  class  Checker implements Comparator<STRB09CompareObjects> {

        @Override
        public int compare(STRB09CompareObjects o1, STRB09CompareObjects o2) {
           int firstResult = Integer.compare(o2.getScore(), o1.getScore());
            if(firstResult != 0){
                return firstResult;
            } else {
                return o1.getName().compareTo(o2.getName());
            }
        }
    }


}
