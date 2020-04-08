package com.Tests;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Rough {

	public static void main(String[] args) {
		
		
		ArrayList<String> listOne = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "f"));
        
        ArrayList<String> listTwo = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e","I"));
        ArrayList<String> listThree = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e","z","i"));
         
        listOne.addAll(listTwo);    //Merge both lists
        listOne.addAll(listThree);
        System.out.println(listOne);
        
        Set set = new HashSet(listOne);
        System.out.println(set);

	}

}
