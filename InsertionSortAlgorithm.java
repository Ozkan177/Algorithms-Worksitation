import java.util.ArrayList;

public class InsertionSortAlgorithm {
    public static void main(String[] args) {
        int[] array = new int[]{34,41,68,32,62,79,60,39,60,31,76,31,10,82,32,81,68,50,40,98,76,52,11,91,78,44,50,36,85,91,27,81,85,49,81,99,13,15,95,64,51,33,44,18,53,19,70,15,89};
        array = insertionSort(array);

        for (int i : array) {
            System.out.print(i + ",");
        }
    }

    public static int[] insertionSort(int[] array){
        int[] sortedArray = new int[array.length];
        sortedArray[0] = array[0];

        for(int i = 1; i < array.length; i++) {
            for(int j = 0; j < i; j++){
                if(array[i] < sortedArray[j]){
                    for(int k = array.length -2 ; k >= j; k -- ){
                        sortedArray[k+1] = sortedArray[k];
                    }
                    sortedArray[j] = array[i];
                    break;
                }else if(j+1 == i){
                    sortedArray[i] = array[i];
                    break;
                }
                
            }
            
            
        }
        return sortedArray;
    }
    
    
}
