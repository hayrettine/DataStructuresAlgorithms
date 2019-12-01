package Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

public class ArrayApp {
    public static void main(String[] args) {
        int[] arr = {7, 3, 8, 1, 2, 4, 6};
        System.out.println(findMiss(arr));

        int[] arr1 = {16, 19, 21, 25, 1, 2, 3, 5, 8, 10};
        System.out.println(findSUbSortNumber(arr1, 1));
        System.out.println(findSubSortMin(arr1));

        int array[] = new int[]{20, 40, 50, 75, 50, 20, 30, 30, 50, 20, 40, 40, 20};
        System.out.println(oddTimes(array));
        System.out.println(getOddTimesElement(array));
        int arr2[] = new int[]{2, 1, 2, 3, 1, 2, 3, 4, 4};
        System.out.println(getOddTimesElement(arr2));
        System.out.println();
        System.out.println("==================================================================================================================================================");
        System.out.println();
        MinimumPlatform platform = new MinimumPlatform();
        System.out.println(Arrays.toString(platform.minPaltform()));
        int[] arr3 = new int[]{-2, 5, 23, -12, 3, -4, 7};
        closestZero(arr3);
        System.out.println(Arrays.toString(seperateEvenOdd(arr1)));
        int[] arr4 = {4, 3, 2, 2, 3, 4, 4, 5};
        freq(arr4);
        subArrays(arr4, 5);
        leader(array);
        int[] biArray = new int[]{0,0,0,0,0,1,1,1,1,1};
        System.out.println(numberOfOnes(0, biArray.length-1, biArray));
        System.out.println(firsRepeating(array));
        int[] consArray = new int[]{12, 20, 15, 19, 17, 13, 16, 14, 18};
        System.out.println(isConsecutive(consArray));
        System.out.println(isConsecutive(arr3));
        System.out.println(Arrays.toString(rotate(consArray, 15)));
        maxDifference(consArray);
        maxDifference(arr3);
        int[][] sortedMatrix =
                {
                        { 1, 6, 10, 12, 20 },
                        { 4, 8, 15, 22, 25 },
                        { 5, 20, 35, 37, 40 },
                        { 10, 28, 38, 45, 55 }
                };
        findMatrix(sortedMatrix, 28);
        System.out.println(maxSubset(arr3));
        findSubsetSum(arr, 11);
        findSubsetSum(arr1, 28);
        String[] strArr={"java2blog","javaworld","javabean","javatemp"};
        System.out.println(preFix(strArr));
        String[] strArr1={"sqlblog","sql2world","sqlquery","sqlproc"};
        System.out.println(preFix(strArr1));
        System.out.println(1<<3);
        int[] sub = new int[]{1,2,3};
        subSets(sub);

    }

    static int findMiss(int[] arr){
        int n = arr.length + 1;
        int sum = (n * (n + 1)) / 2;
        int arrSum = 0;
        for (int value : arr)
            arrSum += value;
        return sum - arrSum;
    }

    static int findSUbSortNumber(int[] arr, int value){
        int low = 0;
        int high = arr.length - 1;
        int mid;
        int index = 0;
        while(arr[index] != value){
            mid = low + ((high - low) / 2);
            index = mid;
            if (arr[index] == value)
                break;
            if (arr[mid] < arr[high]){
                if (arr[mid] < value && arr[high] >= value)
                    low = mid + 1;
                else
                    high = mid - 1;
            }
            else{
                if (arr[mid] > value && arr[low] <= value)
                    high = mid -1;
                else
                    low = mid + 1;
            }
        }
        return index;
    }

    static int findSubSortMin(int[] arr){
        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        while(low < high){
            mid = low + ((high - low) / 2);

            if (arr[mid] > arr[high])
                low = mid + 1;
            else
                high = mid;
        }
        return arr[low];
    }

    static int oddTimes(int[] arr){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int value : arr){
            map.merge(value, 1, Integer::sum);
        }
        for (Entry<Integer, Integer> entry : map.entrySet()){
            if (entry.getValue() % 2 == 1)
                return entry.getKey();
        }
        return -1;
    }
    //abi çok iyi!
    static int getOddTimesElement(int ar[]) {
        int i;
        int result = 0;
        for (i = 0; i < ar.length; i++) {
            // XOR operation
            result = result ^ ar[i];
        }
        return result;

    }
    static void closestZero(int[] arr){
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        int[] closest = new int[]{Integer.MAX_VALUE, arr[right], arr[left]};
        while(left < right){
            int sum = arr[left] + arr[right];
            if (closest[0] > Math.abs(sum)){
                closest[0] = Math.abs(sum);
                closest[1] = arr[right];
                closest[2] = arr[left];
            }
            if (sum > 0)
                right--;
            else if (sum < 0)
                left ++;
        }
        System.out.println("Closest elements are: " + closest[1] + " and " + closest[2] + " | Distance: " + closest[0]);
    }

    static int[] seperateEvenOdd(int[] arr){
        int left = 0;
        int rigth = arr.length - 1;
        for (int value : arr) {
            while (arr[left] % 2 == 0)
                left++;
            while (arr[rigth] % 2 == 1)
                rigth--;
            if (left < rigth){
                int temp = arr[left];
                arr[left] = arr[rigth];
                arr[rigth] = temp;
            }
            else
                break;
        }
        return arr;
    }

    static void freq(int[] arr){
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int val : arr){
            map.merge(val, 1, Integer::sum);
        }
        map.forEach((key, value) -> System.out.println("Element: " + key + " | Frequency: " + value));
    }

    static void subArrays(int[] arr, int value){
        int start, end;
        start = end = 0;
        int sum = 0;
        while(start < arr.length && end <= arr.length) {
            if (sum == value) {
                System.out.println("start: " + start + " | end: " + (end-1));
                if (end <= arr.length - 1)
                    sum += arr[end];
                end++;
            } else {

                if (sum > value) {
                    sum -= arr[start];
                    start++;
                } else {
                    if (end <= arr.length - 1)
                        sum += arr[end];
                    end++;
                }
            }
        }
    }

    static void leader(int[] arr){
        int max = Integer.MIN_VALUE;
        int rightest = arr.length - 1;
        for (int i = rightest ; i > -1 ; i--){
            if (max < arr[i]){
                max = arr[i];
                System.out.println("Leaders: " + max);
            }

        }
    }

    static int numberOfOnes(int start, int end, int[] arr){
        if (arr[start] == 1)
            return end - start + 1;
        if (arr[end] == 0)
            return 0;

        int mid = (end - start)/2;
        int leftSide = numberOfOnes(start, mid, arr);
        int rightSide = numberOfOnes(mid + 1, end, arr);

        return leftSide + rightSide;
    }

    static int firsRepeating(int[] arr){
        int repeatIndex = -1;
        HashSet<Integer> set = new HashSet<>();
        int rghtest = arr.length -1;
        for (int i = rghtest; i > -1; i--){
            if (set.contains(arr[i]))
                repeatIndex = i;
            else
                set.add(arr[i]);
        }
        return arr[repeatIndex];
    }

    static boolean isConsecutive(int[] arr){

        int max = getMax(arr);
        int min = getMin(arr);

        if (max - min + 1 == arr.length) {
            boolean[] visited = new boolean[arr.length];

            for (int value : arr) {
                if (visited[value - min])
                    return false;
                else
                    visited[value - min] = true;
            }
        }else
            return false;
        return true;
    }

    static int getMax(int[] arr){
        int max = Integer.MIN_VALUE;
        for (int value : arr)
            if (max < value)
                max = value;
        return max;
    }

    static int getMin(int[] arr){
        int min = Integer.MAX_VALUE;
        for (int val : arr)
            if (min > val)
                min = val;
        return min;
    }

    static int[] rotate(int[] arr, int rotate){
        int n = arr.length;
        if (rotate > n)
            rotate = rotate % n;
        arr = reverse(arr, 0, n-1);
        arr = reverse(arr, 0, rotate-1);
        arr = reverse(arr, rotate, n-1);
        return arr;
    }

    static int[] reverse(int[] arr, int start, int end){
        while (start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
        return arr;
    }

    static void maxDifference(int[] arr){
        int minelement = arr[0];
        int maxDifference = Integer.MIN_VALUE;
        for (int val : arr){
            int difference = 0;
            if (minelement < val) {
                difference = val - minelement;
                if (difference > maxDifference)
                    maxDifference = difference;
            }else{
                minelement = val;
            }
        }
        System.out.println("Max difference is: " + maxDifference);
    }

    static void findMatrix(int[][] matrix, int element){
        int R = matrix.length;
        int C = matrix[0].length;
        int r = 0, c = C - 1;
        while (r < R && c >= 0){
            if (matrix[r][c] == element)
                System.out.println("R: " + r + " | C: " + c);
            if (element < matrix[r][c])
                c--;
            else
                r++;
        }
    }

    static int maxSubset(int[] arr){
        int[] result = new int[arr.length];
        result[0] = arr[0];
        for (int i = 1; i < arr.length; i++)
            result[i] = Math.max(result[i-1]+arr[i], arr[i]);
        int max = result[0];
        for (int val : result)
            if (max < val)
                max = val;
        return max;
    }
    static void findSubsetSum(int[] arr, int value){
        int start = 0;
        int end = 0;
        int sum = arr[0];
        while(sum != value && start <= end){
            if (sum < value){
                end++;
                sum += arr[end];
            }else {
                sum -= arr[start];
                start++;
                if (end < start){
                    end++;
                    if (end > arr.length - 1)
                        return;
                    sum += arr[end];
                }
            }
        }
        if (end <= arr.length) {
            for (int i = start; i <= end; i++)
                System.out.print(i + " ");
            System.out.println("Sum: " + sum);
        }else
            System.out.println("There is no!");
    }

    static String preFix(String[] arr){
        String prefix =  getMinWord(arr);
        for (int i = 0; i < arr.length; i++){
            for (int j = 0; j < prefix.length(); j++){
                if (arr[i].charAt(j) != prefix.charAt(j)) {
                    prefix = prefix.substring(0, j);
                    break;
                }
            }
        }
        return prefix;
    }

    static String getMinWord(String[] arr){
        int min = Integer.MAX_VALUE;
        String minWord = "";
        for (String s : arr){
            if (min > s.length()) {
                min = s.length();
                minWord = s;
            }
        }
        return minWord;
    }

    static void subSets(int[] arr){

        int n = arr.length;

        for (int i = 0; i < 1 << n; i++){
            System.out.print("{ ");
            for (int j = 0; j < n; j++)
                if ((i & (1<<j)) > 0)
                    System.out.print(arr[j] + " ");
            System.out.println("}");
        }
    }
}
