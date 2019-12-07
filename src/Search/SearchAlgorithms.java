package Search;

public class SearchAlgorithms {

    public void binarySearch(int[] array, int key, int left, int right){
        int mid = (right - left )/ 2 + left;
        if (array[mid] == key) {
            System.out.println("index: " + mid + " | value: " + key);
            return;
        }
        if (array[mid] > key)
            binarySearch(array, key, left, mid);
        else
            binarySearch(array, key, mid+1, right);
    }
}
