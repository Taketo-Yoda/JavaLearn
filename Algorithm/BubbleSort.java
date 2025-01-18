public class BubbleSort {
    public static void main(String[] args) {
        int[] array = {10, 8, 6, 9, 20, 5, 3};
        print("before", array);
        execSort(array);
        print("after", array);
    }

    public static void execSort(int[] args) {
        // 要素の数
        int elemCnt = args.length;
        for (int i = 0; i < elemCnt - 1; i++) {
            // 要素の右端Index算出
            int right = elemCnt - (i + 1);
            for (int j = 0; j < right; j++) {
                if (args[j] > args[j + 1]) {
                    int temp = args[j + 1];
                    args[j + 1] = args[j];
                    args[j] = temp;
                }
            }
        }
    }

    private static void print(String str, int[] args) {
        System.out.print(str + ":");
        for (int i = 0; i < args.length; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(Integer.toString(args[i]));
        }
        System.err.println("");
    }
}
