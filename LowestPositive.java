/*
Good morning! Here's your coding interview problem for today.

This problem was asked by Stripe.

Given an array of integers, find the first missing positive integer in linear time and constant space. In other words, find the lowest positive integer that does not exist in the array. The array can contain duplicates and negative numbers as well.

For example, the input [3, 4, -1, 1] should give 2. The input [1, 2, 0] should give 3.


*/

import java.util.HashSet;

public class LowestPositive {

    public static void main(String[] args) {
        
        HashSet<Integer> set = new HashSet<Integer>();
        
        set.add(3);
        set.add(4);
        set.add(-1);
        set.add(1);
        
        //set.add(1);
        //set.add(2);
        //set.add(0);
        
        int lowestPositive = 0;
        int min = 999;
        
        for (int i : set) {
            if(i > 0 && i < min)                 
                min = i;            
        }
        lowestPositive = ++min;    
        
        while(set.contains(lowestPositive))
            lowestPositive++;
        
        System.out.println(lowestPositive);
    }
}
