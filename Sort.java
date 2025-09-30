import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        // int[] a = {5, 2, 9, 1, 5, 6};
        // int[] sorted = mergeSort(a);
        // System.out.println(Arrays.toString(sorted));



        int[] array = new int[]{34,41,68,32,62,79,60,39,60,31,76,31,10,82,32,81,68,50,40,98,76,52,11,91,78,44,50,36,85,91,27,81,85,49,81,99,13,15,95,64,51,33,44,18,53,19,70,15,89};
        array = insertionSort(array);

        for (int i : array) {
            System.out.print(i + ",");
        }
        System.out.println("\n");

        int[] a1 = {20, 5, 15, 8};
        System.out.println("Girdi:  " + Arrays.toString(a1));
        long costA = insertionSortFluction(a1);
        System.out.println("Çıktı:  " + Arrays.toString(a1));
        System.out.println("Maliyet: " + costA);  // beklenen: 39

        System.out.println();

        int[] b = {5, 2, 9, 1, 5, 6};
        System.out.println("Girdi:  " + Arrays.toString(b));
        long costB = insertionSortFluction(b);
        System.out.println("Çıktı:  " + Arrays.toString(b));
        System.out.println("Maliyet: " + costB);
    }

    public static int[] merge(int[] arL , int[] arR){
        int[] arr=new int[arL.length+arR.length];
        int index=0;
        int i=0;
        int j=0;

        while( i< arL.length && j<arR.length){
            if(arL[i] < arR[j]){
                arr[index]=arL[i];
                index++;
                i++;
            }
            else{
                arr[index]=arR[j];
                index++;
                j++;
            }
        }
        while(i<arL.length){
            arr[index]=arL[i];
            index++;
            i++;
        }

        while(j<arR.length){
            arr[index]=arR[j];
            index++;
            j++;
        }

        return arr;

    }

    public static int[] mergeSort(int[] array){
        if(array.length<=1) return array;
        int midIndex = array.length/2;
        int[] left= mergeSort(Arrays.copyOfRange(array, 0, midIndex));
        int[] right= mergeSort(Arrays.copyOfRange(array, midIndex, array.length));

        return merge(left, right);
    }

    
    public static int[] insertionSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int j=i-1;
            int key=arr[i];

            while(j>-1 && key<arr[j]){
                arr[j+1]=arr[j];
                j--;
            }
            arr[j+1]=key;
        }return arr;
    }

    public static int[] insertionsort(int[] a){
        for (int i = 0; i < a.length; i++) {
            int j= i-1;
            int key= a[i];

            while(j>-1&& key<a[j]){
                a[j+1]=a[j];
                j--;
            }
            a[j+1]=key;
        }return a;
    }

    public static  int[] insert(int[]b){
        for(int i=0;i<b.length;i++){
            int j=i-1;
            int key =b[i];

            while(j>-1 && key<b[j]){
                b[j+1]=b[j];
                j--;
            }
            b[j+1]=key;
        }return b;
    }


    public static void mergesub(int[] array , int left, int right, int mid){
        int[] sorted =new int[right-left+1];
        int rightIndex=mid+1;
        int leftIndex=left;

        for(int i=0; i<array.length;i++){
            if((rightIndex>right)||(leftIndex<=mid && array[leftIndex]<array[rightIndex])){
                sorted[i]=array[leftIndex];
                leftIndex++;
            }else{
                sorted[i]=array[rightIndex];
                rightIndex++;
            }
        }
        for(int i=0; i<sorted.length;i++){
            array[left+i]=sorted[i];
        }
    }

    public static void insertionSortDesc(int[] a){
        for (int i = 0; i < a.length; i++) {
            int key=a[i];
            int j=i-1;

            while(j>-1 && key>a[j]){
                a[j+1]=a[j];
                j--;
            }
            a[j+1]=key;
        }
    }

    public static int insertionSortFluction(int[] arr){
        int totalCost=0;
        for (int i = 1; i < arr.length; i++) {
            int j=i-1;
            int key=arr[i];

            while(j>-1 && key<arr[j]){
                totalCost += arr[j]-key;
                arr[j+1]=arr[j];
                j--;
            }

            arr[j+1]=key;
            
        } 
        
        return totalCost;
        
    }


    
    public static long fluctuationCost(int[] arr) {
        // arr üzerinde yerinde sıralama + maliyet hesabı
        return mergeSort(arr, 0, arr.length - 1);
    }

    private static long mergeSort(int[] a, int l, int r) {
        if (l >= r) return 0L;
        int m = (l + r) / 2;
        long cost = 0L;
        cost += mergeSort(a, l, m);
        cost += mergeSort(a, m + 1, r);
        cost += mergeAndCount(a, l, m, r);
        return cost;
    }

    // Merge sırasında "sağdaki küçük eleman" L[i..end]'in önüne geçtiğinde
    // sum(L[i..end]) - count(L[i..end]) * R[j] kadar maliyet ekleriz.
    private static long mergeAndCount(int[] a, int l, int m, int r) {
        int n1 = m - l + 1, n2 = r - m;
        int[] L = new int[n1];
        int[] R = new int[n2];
        System.arraycopy(a, l, L, 0, n1);
        System.arraycopy(a, m + 1, R, 0, n2);

        // L için prefix sum -> suffix sum'ları hızlı hesaplamak için
        long[] pref = new long[n1 + 1];
        for (int i = 0; i < n1; i++) pref[i + 1] = pref[i] + L[i];

        long cost = 0L;
        int i = 0, j = 0, k = l;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                a[k++] = L[i++];
            } else {
                int remaining = n1 - i;                  // L[i..end] eleman sayısı
                long sumSuffix = pref[n1] - pref[i];     // sum(L[i..end])
                cost += sumSuffix - (long) remaining * R[j];
                a[k++] = R[j++];
            }
        }
        while (i < n1) a[k++] = L[i++];
        while (j < n2) a[k++] = R[j++];

        return cost;
    }

}