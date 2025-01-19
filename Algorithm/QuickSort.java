public class QuickSort {

    public static void main(String[] args) {
        int[] array = {10, 8, 6, 9, 20, 5, 3};
        print("before", array);
        execSort(array, 0, array.length - 1);
        print("after", array);
        int idx = binarySearchFullMatch(6, array);
        System.out.println("Full match search result : " + idx);
        int maxVal = binarySearchMax(4, array);
        System.out.println("Max value search result : " + maxVal);
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

    /**
     * 探索木完全一致検索.
     * 一致する値が存在しない場合は"-1"を返す<br/>
     * 
     * @param kei 検索する値
     * @param array 検索対象の配列
     * @return 値が存在するインデックス
     */
    private static int binarySearchFullMatch(int key, int[] array) {
        int fromIndex = 0;
        int toIndex = array.length - 1;
        do {
            // 中間インデックスを取得
            int mid = (fromIndex + toIndex) / 2;
            if (array[mid] == key) {
                return mid;
            } else if (array[mid] < key) {
                fromIndex = mid + 1;
            } else {
                toIndex = mid - 1;
            }
        } while (fromIndex <= toIndex);
        // 一致する値が存在しない場合
        return -1;
    }

    /**
     * 探索木検索.
     * 指定のキーより小さい値の中から最大値を返す
     */
    private static int binarySearchMax(int key, int[] array) {
        int maxVal = 0;
        int fromIndex = 0;
        int toIndex = array.length - 1;
        do {
            // 中間インデックスを取得
            int mid = (fromIndex + toIndex) / 2;
            if (array[mid] == key) {
                return array[mid];
            } else if (array[mid] < key) {
                fromIndex = mid + 1;
                if (fromIndex >= array.length) {
                    return array[array.length - 1];
                }
            } else {
                toIndex = mid - 1;
                if (toIndex < 0) {
                    return 0;
                } else {
                    maxVal = array[toIndex];
                }
            }
        } while (fromIndex <= toIndex);
        return maxVal;
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