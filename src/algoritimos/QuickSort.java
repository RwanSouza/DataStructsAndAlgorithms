package algoritimos;

import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] v) {
        quickSort(v, 0, v.length - 1);
    }

    public static void quickSort(int[] v, int start_pos, int end_pos) {
        int pivot = v[start_pos];
        int l = start_pos;
        int r = end_pos;

        while(l <= r) {

            while(v[l] < pivot) l++;
            while(v[r] > pivot) r--;

            if(l <= r) {
                int swap = v[r];
                v[r]= v[l];
                v[l] = swap;
                l++;
                r--;
            }
        }

        if(start_pos < r) quickSort(v, start_pos, r);
        if(l < end_pos) quickSort(v, l, end_pos);
    }

      public static void main(String[] args) {
        int[] v = new int[] {4, 2, 8, 7, 1, 5, 3, 6};
        QuickSort.quickSort(v);
        Arrays.stream(v).forEach(i -> System.out.print(i + " "));

    }
}
