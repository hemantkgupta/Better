import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by ghemant on 3/2/17.
 */
public class Test2 {

    public static void main(String[] args) {

        int[] input2 = {10,20,10};
        int[] input3 = {10,20,11};

        test(3, input2, input3, 20);

    }

    public static  void  test(int input1, int[] input2, int[] input3, int input4){

        List<RatioIndex> ratios = new ArrayList<RatioIndex>();
        for (int i = 0; i <input1 ; i++) {
            float ratio = (float) input3[i]/ (float) input2[i];
            RatioIndex ratioIndex = new RatioIndex(i, ratio);
            ratios.add(ratioIndex);
        }

        Collections.sort(ratios, new Comparator<RatioIndex>() {
            @Override
            public int compare(RatioIndex o1, RatioIndex o2) {
                return Float.compare(o2.getRatio(), o1.getRatio());
            }
        });

        System.out.println(ratios);

        int currentEffort = input4;
        int currentBenifit = 0;
        for (int i = 0; i <ratios.size() ; i++) {

            int index = ratios.get(i).getIndex();
            int effort = input2[index];
            int benifit = input3[index];
            System.out.println("the index is "+ index);
            System.out.println("the benifit is "+ benifit);
            System.out.println("the effort is "+ effort);

            if (currentEffort >= effort){
                currentEffort -=  effort;
                currentBenifit += benifit;
            }
            System.out.println("the currentBenifit is "+ currentBenifit);
            System.out.println("the currentEffort is "+ currentEffort);
            if (currentEffort == 0){
                break;
            }
        }
        System.out.println("the currentBenifit is : "+ currentBenifit);
    }

    static class RatioIndex{

        int index;
        float ratio;

        public RatioIndex(int index, float ratio) {
            this.index = index;
            this.ratio = ratio;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public float getRatio() {
            return ratio;
        }

        public void setRatio(float ratio) {
            this.ratio = ratio;
        }

        @Override
        public String toString() {
            return "RatioIndex{" +
                    "index=" + index +
                    ", ratio=" + ratio +
                    '}';
        }
    }

}
