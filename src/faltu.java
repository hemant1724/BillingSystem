
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hp
 */
public class faltu {
  public static void main(String[] args) 
    { 
        int arr[] = {50,40,30,20,10} ;
       
  
        // The last parameter specifies the comparator method 
        // used for sorting. 
        int result = Arrays.binarySearch(arr, 50); 
  
        System.out.println("Found at index " + result); 
    } 
}
