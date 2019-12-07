package sort;

import java.util.Arrays;

public class SortAlgorithms {

    public int[] bubbleSort(int[] arr){
        for (int i = 0; i < arr.length; i++){
            for (int j = i + 1; j < arr.length; j++){
                if(arr[i] > arr[j])
                    swap(arr, i, j);
            }
        }
        return arr;
    }

    public int[] insertionSort(int[] arr){
        for (int i = 1; i < arr.length; i++){
            int key = arr[i];
            int j = i - 1;
            while (j > -1 && arr[j] > key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
        return arr;
    }

    public int[] selectionSort(int[] arr){
        for (int i = 0; i < arr.length; i++){
            int min = arr[i];
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++){
                if (arr[j] < min) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
        return arr;
    }

    public int[] shellSort(int[] arr){
        int n = arr.length;
        for (int gap = n/2; gap > 0; gap /= 2){
            for (int i = gap; i < n; i++){
                int temp = arr[i];
                int j;
                for (j = i; j >= gap && arr[j - gap] > temp; j -= gap)
                    arr[j] = arr[j - gap];
                arr[j] = temp;
            }
        }
        return arr;
    }

    public int[] countingSort(int[] arr){
        int max = getMax(arr);
        int[] count = new int[max + 1];
        for (int val:arr)
            count[val] += 1;
        for (int i = 0; i < count.length - 1; i++)
            count[i + 1] = count[i] + count[i + 1];
        int[] sorted = new int[arr.length];
        for (int i = 0; i < arr.length; i++){
            sorted[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }
        return sorted;
    }

    public int getMax(int[] arr){
        int max = Integer.MIN_VALUE;
        for (int val:arr){
            if (max < val)
                max = val;
        }
        return max;
    }


    private void swap(int[] arr, int index1, int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
