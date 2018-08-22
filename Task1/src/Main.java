public class Main {

    public static void main(String[] args) {
        int[] input = new int[50];
        difficult_O_1(input);
        difficult_O_long_n(input, 0, 50, 8);
        difficult_O_N(input);
        difficult_O_N_2(input);
        difficult_O_n_long(input);
    }

    /**
     * Возврат первого элемента массива.
     */
    public static int difficult_O_1(int[] input){
        if (input.length!=0) return input[0];
        return 0;
    }

    /**
     * Перебор колллекции.
     */
    public static void difficult_O_N(int[] input){
        int sum = 0;
        for (int i = 0; i < input.length; i++) {
            sum += input[i];
        }
    }

    /**
     * Бинарнный поиск.
     */
    public static int difficult_O_long_n(int[] a, int fromIndex, int toIndex, int key){
        int low = fromIndex;
        int high = toIndex - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = a[mid];

            if (midVal < key)
                low = mid + 1;
            else if (midVal > key)
                high = mid - 1;
            else
                return mid; // key found
        }
        return -(low + 1);  // key not found.
    }

    /**
     * Сортировка кучей.
     */
    public static void difficult_O_n_long(int[] input){
        HeapSort.sort(input);
    }

    /**
     * Сортировка массива (bubble sort)
     * @param input
     */
    public static void difficult_O_N_2(int[] input){
        int j;
        boolean flag = true;
        int temp;

        while (flag) {
            flag = false;
            for (j = 0; j < input.length - 1; j++) {
                if (input[j] < input[j + 1]) {
                    temp = input[j];
                    input[j] = input[j + 1];
                    input[j + 1] = temp;
                    flag = true;
                }
            }
        }
    }

}
