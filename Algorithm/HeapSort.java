/**
 * ヒープソート.
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] array = {10, 8, 6, 9, 20, 5, 3};
        print("before", array);
        execSort(array);
        print("after", array);
    }

    private static void execSort(int[] args) {
        upHeap(args);
    }

    /**
     * アップヒープ.
     * ルートが最大値となる
     * 
     * @param args 数値配列
     */
    private static void upHeap(int[] args) {
        for (int i = 0; i < args.length; i++) {

            // ノード位置を切り出す
            int j = i;

            // ノードがRootでない場合に繰り返し
            while (j > 0) {
                // 親要素より値が大きい場合、親要素と値を入れ替える
                if (args[j] > args[getParentIndex(j)]) {
                    int temp = args[j];
                    args[j] = args[(getParentIndex(j))];
                    args[getParentIndex(j)] = temp;
                    // ノードの位置を親の位置へ変更
                    j = getParentIndex(j);
                } else {
                    break;
                }
            }
        }
    }

    /**
     * 親ノードのインデックスを取得する.
     * 
     * @param index 子ノードのインデックス
     * @return 親ノードのインデックス
     */
    public static int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    /**
     * 数値配列の標準出力.
     * 
     * @param str 接頭辞
     * @param args 数値配列
     */
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