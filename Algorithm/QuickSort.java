public class QuickSort {

    public static void main(String[] args) {
        int[] array = {10, 8, 6, 9, 20, 5, 3};
        print("before", array);
        execSort(array, 0, array.length - 1);
        print("after", array);
    }

    private static void execSort(int[] args, int left, int right) {
        if (left > right) {
            return;
        }
        // ピボット値導出
        int pivot = args[(left+right)/2];
        int leftIndex = left;
        int rightIndex = right;
        while (leftIndex <= rightIndex) {
            // ピボット値より小さい値は左側要素のまま
            while (args[leftIndex] < pivot) {
                leftIndex++;
            }
            // ピボット値より大きい値は右側要素のまま
            while (args[rightIndex] > pivot) {
                rightIndex--;
            }
            if (leftIndex <= rightIndex) {
                // 値の入れ替え
                int temp = args[leftIndex];
                args[leftIndex] = args[rightIndex];
                args[rightIndex] = temp;
                leftIndex++;
                rightIndex--;
            }
            execSort(args, left, rightIndex);
            execSort(args, leftIndex, right);
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