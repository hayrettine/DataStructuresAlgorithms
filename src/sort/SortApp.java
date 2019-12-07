package sort;

import java.util.Arrays;

public class SortApp {
    public static void main(String[] args) {
        int[] array = new int[]{12, 4, 18, 22, 11, 2, 5, 20};
        System.out.println(Arrays.toString(array));
        SortAlgorithms sort = new SortAlgorithms();
        int[] sortedArray = sort.bubbleSort(array);
        System.out.println(Arrays.toString(sortedArray));

        array = new int[]{12, 4, 18, 22, 11, 2, 5, 20};
        sortedArray = sort.insertionSort(array);
        System.out.println(Arrays.toString(sortedArray));

        array = new int[]{12, 4, 18, 22, 11, 2, 5, 20};
        sortedArray = sort.selectionSort(array);
        System.out.println(Arrays.toString(sortedArray));

        array = new int[]{12, 4, 18, 22, 11, 2, 5, 20};
        sortedArray = sort.shellSort(array);
        System.out.println(Arrays.toString(sortedArray));

        array = new int[]{12, 4, 18, 22, 11, 2, 5, 20};
        sortedArray = sort.countingSort(array);
        System.out.println(Arrays.toString(sortedArray));
    }
}
