public class MergeSort {
    
    public static void main(String[] args) {
        int[] array = {10, 8, 6, 9, 20, 5, 3};
        print("before", array);
        int[] afterArr = execSort(array);
        print("after", afterArr);
    }

    private static int[] execSort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        int mid = arr.length / 2;
        int[] leftArr = new int[mid];
        int[] rightArr = new int [arr.length - mid];
        // 左側配列生成
        System.arraycopy(arr, 0, leftArr, 0, mid);
        // 右側配列生成
        for (int i = 0; i < rightArr.length; i++) {
            rightArr[i] = arr[i + mid];
        }
        // 再帰呼び出し
        int[] sortedLeft = execSort(leftArr);
        int[] sortedRight = execSort(rightArr);

        // ソート・マージ
        int leftIndex = 0;
        int rightIndex = 0;
        int[] sortedArr = new int[arr.length];
        while (leftIndex < sortedLeft.length || rightIndex < sortedRight.length) {
            // Indexが範囲外の場合は範囲内の要素を優先
            if (leftIndex >= sortedLeft.length) {
                sortedArr[leftIndex + rightIndex] = sortedRight[rightIndex];
                rightIndex++;
            }
            else if (rightIndex >= sortedRight.length) {
                sortedArr[leftIndex + rightIndex] = sortedLeft[leftIndex];
                leftIndex++;
            }
            else if (sortedLeft[leftIndex] <= sortedRight[rightIndex]) {
                sortedArr[leftIndex + rightIndex] = sortedLeft[leftIndex];
                leftIndex++;
            } else {
                sortedArr[leftIndex + rightIndex] = sortedRight[rightIndex];
                rightIndex++;
            }
        }
        return sortedArr;

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