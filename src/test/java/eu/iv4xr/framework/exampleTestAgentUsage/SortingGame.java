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
    * Setter function for setting array
    * */
    /*public int[] setMyArray(int[] array)
    {
        return myArray = array;
    }*/
    /*
    * Swap function for changing the place of two element of array
    * */

    public void swap(int i){
        final int temp = myArray[i];
        int j = i+1 < myArray.length  ? i+1 : 0;
        myArray[i] = myArray[j];
        myArray[j] = temp;
        pointer(i);
    }

    public int pointer(int i){
        /*System.out.println("pointer to ele in pointer in the bigining");
        System.out.println(i);*/
        //System.out.println( myArray.length);
        if(i >= myArray.length-1){
            //System.out.println("pointer to ele in pointer in else");
            return pointerToElementOfArray = 0;
        }
        else{
            pointerToElementOfArray = i+1;
            /*System.out.println("pointer to ele in pointer in if");
            System.out.println(pointerToElementOfArray);*/
            return pointerToElementOfArray;

        }
    }

    /*
    * Sort the array
    * */
   /* public int[] sortingArray(){
        //Arrays.sort(myArray);
        for (int i=0 ; i< myArray.length ; i++){
            int j = i+1 < myArray.length  ? i+1 : i;
            if(myArray[i] > myArray[j]){
                this.swap(i,j);
            }
        }
        return myArray;
    }*/
    /*

    * The win function calculate that the array is sorted or not
    * */
    public boolean win(){
        firstLoop:
        for (int i=0; i< myArray.length ; i++){
            secondLoop:
            for (int j = i+1; j < myArray.length; j++) {
                if (myArray[i] > myArray[j]) {
                    flag = false;
                    break firstLoop;
                } else {
                    flag = true;
                }
            }
        }
        return flag;
    }

   public static void main(String args[]){
        SortingGame sortingClass = new SortingGame();

        System.out.println("initial array");
        System.out.println(Arrays.toString(sortingClass.getMyArray())) ;
        //System.out.println(sortingClass.pointer(2)) ;

        //Call swap function to change the place
        for (int i=0 ; i< sortingClass.myArray.length ; i++){
            int j = i+1 < sortingClass.myArray.length  ? i+1 : i;
            if(sortingClass.myArray[i] > sortingClass.myArray[j]){
                sortingClass.swap(i);
            }
        }
        System.out.println(Arrays.toString(sortingClass.getMyArray())) ;

       //Call win class
        //System.out.println(sortingClass.win());

        //Call the test function for testing
        //System.out.println(sortingClass.testSorting());

        //Print the random array
        //System.out.println("array after swap");
        //System.out.println(Arrays.toString(sortingClass.getMyArray())) ;
        //Print the sort of array
        //System.out.println("sorted array");
        //System.out.println(Arrays.toString(sortingClass.sortingArray())) ;
    }


    /*public boolean testSorting(){
        int[] data={2,5,10};
       // this.setMyArray(data);
        return this.win(); 
    }*/

}
