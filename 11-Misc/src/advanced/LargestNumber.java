package advanced;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by ghemant on 3/3/17.
 */
public class LargestNumber {
    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>();
        input.add(3);
        input.add(30);
        input.add(34);
        input.add(5);
        input.add(9);

        System.out.println(largestNumber(input));

    }

    public static String largestNumber(final List<Integer> a) {

        List<NumberString> values = new ArrayList<>();


        for (int i = 0; i < a.size(); i++) {
            values.add(new NumberString(Integer.toString(a.get(i))));
        }

        Collections.sort(values, new Comparator<NumberString>() {
            @Override
            public int compare(NumberString o1, NumberString o2) {

                return o2.getValue().compareTo(o1.getValue());

            }
        });

        StringBuilder s = new StringBuilder();
        for (int i = 0; i < values.size(); i++) {
            s.append(values.get(i).getValue());
        }

        return s.toString();

    }

    static class NumberString{
        private String value;

        public NumberString(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "NumberString{" +
                    "value='" + value + '\'' +
                    '}';
        }
    }
}
