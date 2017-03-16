package basic;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by ghemant on 3/7/17.
 */
public class S08CompareObjects {

    public String name;
    public int score;

    public S08CompareObjects(String name, int score) {
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

        S08CompareObjects[] player = new S08CompareObjects[n];
        Checker checker = new Checker();

        for(int i = 0; i < n; i++){
            player[i] = new S08CompareObjects(scan.next(), scan.nextInt());
        }
        scan.close();

        Arrays.sort(player, checker);
        for(int i = 0; i < player.length; i++){
            System.out.printf("%s %s\n", player[i].name, player[i].score);
        }
    }

    static  class  Checker implements Comparator<S08CompareObjects> {

        @Override
        public int compare(S08CompareObjects o1, S08CompareObjects o2) {
           int firstResult = Integer.compare(o2.getScore(), o1.getScore());
            if(firstResult != 0){
                return firstResult;
            } else {
                return o1.getName().compareTo(o2.getName());
            }
        }
    }


}
