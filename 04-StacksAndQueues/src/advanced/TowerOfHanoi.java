package advanced;

import java.util.Stack;

/**
 * Created by root on 19/12/15.
 */
public class TowerOfHanoi {
    public static void main(String[] args) {
        int n = 3;
        Tower[] towers = new  Tower[n];
        for (int i = 0; i < n; i++) {
            towers[i] =  new Tower(i);
        }
        for (int i = n-1; i >= 0 ; i--) {
            towers[0].add(i);
        }
        towers[0].moveDisks(n, towers[2],towers[1]);
    }
    static class Tower{

        private Stack<Integer> disks;
        private int index;

        public Tower(int i){
            this.disks = new Stack<>();
            this.index = i;
        }

        public void add(int d){
            if(!disks.isEmpty() && disks.peek() <= d){
                System.out.println("Error placing disk"+d);
            }else {
                disks.push(d);
            }
        }

        public void moveTopTo(Tower tower){
            int disk = disks.pop();
            tower.add(disk);
            System.out.println("Moved disk " + disk + " from "+ index + " to "+ tower.index);
        }

        public void  moveDisks(int n, Tower destination, Tower buffer){
            if (n > 0){
                moveDisks(n-1, buffer, destination);
                moveTopTo(destination);
                buffer.moveDisks(n-1,destination,this);
            }
        }

    }
}
