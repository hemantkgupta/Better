package basic;

public class STRB06FirstRepeatingAndNonRepeatingChar {

	public static void main(String[] args) {
		System.out.println(firstRepeatingChar("abcaaccc"));
		System.out.println(firstNonRepeatingChar("abcaaccc"));
	}

	public static char firstRepeatingChar(String str) {
		int len = str.length();
		char result = '\u0000';
		boolean[] data = new boolean [256];

		for (int i = 0; i < len; i++) {
			char val = str.charAt(i);
            System.out.println("Current char is "+ val);
            int pos = (int) val - 'a';
			if (data[pos] == false) {
				data[pos] = true;
			} else {
                result = val;
                break;
			}
		}
        return result;

	}


    public static char firstNonRepeatingChar(String str) {
        int len = str.length();
        char result = '\u0000';
        CountAndIndex[] data = new CountAndIndex[256];

        for (int i = 0; i < len; i++) {
            char val = str.charAt(i);
            int pos = (int) val - 'a';
            if (data[pos] == null) {
                data[pos] = new CountAndIndex(1, i);
            } else {
                data[pos].incrementCount();
            }
        }

        for (int i = 0; i < data.length; i++) {
            if (data[i] != null && data[i].count == 1) {
                result = str.charAt(data[i].index);
                break;
            }
        }
        return result;
    }

    static  class CountAndIndex {
        int count;
        int index;

        public CountAndIndex(int count, int index) {
            this.count = count;
            this.index = index;
        }

        public void incrementCount() {
            this.count++;
        }

    }

}

