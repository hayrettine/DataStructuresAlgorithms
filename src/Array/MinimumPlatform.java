package Array;

public class MinimumPlatform {
    //arrival[] = {1:00, 1:40, 1:50, 2:00, 2:15, 4:00}
    //departure[] = {1:10, 3:00, 2:20, 2:30, 3:15, 6:00}

    private final double arrival[] = new double[]{1.0, 1.4, 1.5, 2.0, 2.15, 4.0};
    private final double departure[] = new double[]{1.1, 3.0, 2.2, 2.3, 3.15, 6.0};


    public int[] minPaltform(){
        int arr[] = new int[]{0,0,0,0,0,0};

        for (int i = 0; i < arrival.length; i++){
            for (int j = i; j < arrival.length; j++){
                if (arrival[j] < departure[i])
                    arr[i]++;
            }
        }
        return arr;
    }
}
