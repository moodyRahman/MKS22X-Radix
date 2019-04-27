import java.io.*;
import java.util.*;

public class Radix{


static void countSort(int arr[], int n, int exp) {
        int output[] = new int[n]; // output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count,0);

        // store occurences
        for (i = 0; i < n; i++)
                count[ (arr[i]/exp)%10 ]++;

        // count[i] now has locations
        for (i = 1; i < 10; i++)
                count[i] += count[i - 1];

        // out array
        for (i = n - 1; i >= 0; i--) {
                output[count[ (arr[i]/exp)%10 ] - 1] = arr[i];
                count[ (arr[i]/exp)%10 ]--;
        }

        // Copy output array contains sorted numbers according to curent digit
        for (i = 0; i < n; i++){
                arr[i] = output[i];
        }
}


public static void main(String[] args) {
        int[] t = {4, 5, 6};

        countSort(t, 0, 0);
}
}
