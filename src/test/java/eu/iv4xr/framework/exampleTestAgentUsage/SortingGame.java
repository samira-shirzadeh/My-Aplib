package eu.iv4xr.framework.exampleTestAgentUsage;

import java.util.*;
import java.util.stream.IntStream;

public class SortingGame {
    int[] myArray;
    int pointerToElementOfArray = 0;
    private boolean flag;

    /*
    * Create an instance of the game.
    * */

    public SortingGame(){
        /*Create random array with a rang and unique value*/
        // generate set of sequential values from 0 ... desiredSize * 3
        myArray = new int[5];
        myArray = IntStream.range(1, 6).toArray();
        Random rand = new Random();

        for (int i = 0; i < myArray.length; i++) {
            int randomIndexToSwap = rand.nextInt(myArray.length);
            int temp = myArray[randomIndexToSwap];
            myArray[randomIndexToSwap] = myArray[i];
            myArray[i] = temp;
        }

        /*Create random array with a rang but repeat value*/
       /* Random r = new Random();
        int Low = 1;
        int High = 5;
        myArray = new int[5];
        for(int i = 0; i < myArray .length; i++){
            myArray [i]  = r.nextInt(High-Low) + Low;
        }*/
        /*Create random array without a rang*/
        /*Random rnd = new Random() ;
        myArray = new int[5];
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = rnd.nextInt();
        }*/
    }
    /*
    * Getter function for getting array
    * */
    public int[] getMyArray()
    {
        return myArray;
    }

    /*
    * Swap function for changing the place of two element of array
    * */

    public void swap(int i, int[] indexOfArray){
        int temp = myArray[i];
        int nextElementForSwap = i;
        pointer(i);
        nextElementForSwap = nextElementForSwap+1 < myArray.length  ? nextElementForSwap+1 : 0;
        if( !(isEmpty(indexOfArray)) && (Arrays.binarySearch(indexOfArray, nextElementForSwap) >= 0)){
            nextElementForSwap = nextElementForSwap+1;
            while(Arrays.binarySearch(indexOfArray, nextElementForSwap) >= 0){
                nextElementForSwap = nextElementForSwap+1;
            }
        }else{
            nextElementForSwap = i+1;
        }
        int j = nextElementForSwap < myArray.length  ? nextElementForSwap : 0;
        myArray[i] = myArray[j];
        myArray[j] = temp;
    }

    /*Set pointer to the next element*/
    public int pointer(int i){
        if(i >= myArray.length-1){
            return pointerToElementOfArray = 0;
        }
        else{
            pointerToElementOfArray = i+1;
            return pointerToElementOfArray;
        }
    }

    /*Check the array is empty*/
    public boolean isEmpty(int[] arr){
        boolean empty = false;
       System.out.println(Arrays.toString(arr));
        if (arr == null) {
            empty = true;
        }
        return empty;
    }

    /*Add the number in to array*/
    public int[] add(int[] arr, int x){
        int len = arr.length;
        arr = Arrays.copyOf(arr,len+1);
        arr[len++] = x;
        return arr;
    }

    /* The win function calculate that the array is sorted or not
    * */
    public boolean win(){
        for (int i=0; i< myArray.length ; i++){
            System.out.println("for");
            System.out.println(i);
            int j = i+1 < myArray.length  ? i+1 : i;
            System.out.println(j);
            if (myArray[i] > myArray[j]) {
                System.out.println(myArray[i]);
                System.out.println(myArray[j]);
                return flag = false;
            }
        }
        return flag = true;
    }

}
