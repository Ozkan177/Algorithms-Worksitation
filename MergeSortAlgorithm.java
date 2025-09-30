public class MergeSortAlgorithm {

    public static void main(String[] args) {
        int[] array = new int[]{34,41,68,32,62,79,60,39,60,31,76,31,10,82,32,81,68,50,40,98,76,52,11,91,78,44,50,36,85,91,27,81,85,49,81,99,13,15,95,64,51,33,44,18,53,19,70,15,89};
        mergeSort(array, 0, array.length-1);

        for (int i : array) {
            System.out.print(i + ",");
        }
        //randomizer();
    }
    public static void mergeSort(int[] array, int left, int right){
        if(left == right){
            return;
        }
        int middle = (left + right) / 2;
        mergeSort(array, left, middle);
        mergeSort(array, middle + 1, right);
        mergeSubArrays(array,left,middle, right);
    }
    public static void mergeSubArrays(int[] array, int left, int middle, int right){
        int[] sorted = new int[right - left + 1];
        int leftIndex = left;
        int rightIndex = middle+1;

        for(int i = 0; i < sorted.length ; i++){
            if((rightIndex > right) || (leftIndex <= middle &&array[leftIndex] < array[rightIndex] )){
                sorted[i] = array[leftIndex];
                leftIndex++;
            }else {
                sorted[i] = array[rightIndex];
                rightIndex++;
            }
        }
        for(int i = 0; i< sorted.length; i++){
            array[left + i] = sorted[i];
        }


    }
    public static void randomizer(){
        for(int i = 0; i < 50; i++){
            System.out.print(Math.round(Math.random()* 100));
            System.out.print(",");
        }
    }



}