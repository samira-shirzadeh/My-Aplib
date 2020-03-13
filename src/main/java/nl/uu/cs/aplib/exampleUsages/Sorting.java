package nl.uu.cs.aplib.exampleUsages;

import java.util.Arrays;
import java.util.Random;

public class Sorting {
    private int[] myArray;
    private boolean flag;
    /*
    * Set random array
    * */
    public Sorting(){
        Random rnd = new Random() ;
        myArray = new int[5];
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = rnd.nextInt();
        }
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
    public int[] setMyArray(int[] array)
    {
        return myArray = array;
    }
    /*
    * Swap function for changing the place of two element of array
    * */

    public void swap(int i,int j){
        final int temp = myArray[i];
        myArray[i] = myArray[j];
        myArray[j] = temp;
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
        Sorting sortingClass = new Sorting ();

        System.out.println("initial array");
        System.out.println(Arrays.toString(sortingClass.getMyArray())) ;

        /* Call swap function to change the place*/
        for (int i=0 ; i< sortingClass.myArray.length ; i++){
            int j = i+1 < sortingClass.myArray.length  ? i+1 : i;
            if(sortingClass.myArray[i] > sortingClass.myArray[j]){
                sortingClass.swap(i,j);
            }
        }
        /*Call win class*/
        //System.out.println(sortingClass.win());

        /*Call the test function for testing*/
        //System.out.println(sortingClass.testSorting());

        /*Print the random array*/
        System.out.println("array after swap");
        System.out.println(Arrays.toString(sortingClass.getMyArray())) ;
        /*Print the sort of array*/
        /*System.out.println("sorted array");
        System.out.println(Arrays.toString(sortingClass.sortingArray())) ;*/
    }


    public boolean testSorting(){
        int[] data={2,5,10};
        this.setMyArray(data);
        return this.win(); 
    }

}
