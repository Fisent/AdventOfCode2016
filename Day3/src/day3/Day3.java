/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 *
 * @author lukasz
 */
public class Day3
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException
    {
        System.out.println(howManyTraingles());
    }
    
    public static int howManyTraingles() throws FileNotFoundException
    {
        int counter = 0;
        LinkedList<Integer> list1 = new LinkedList<>();
        LinkedList<Integer> list2 = new LinkedList<>();
        LinkedList<Integer> list3 = new LinkedList<>();
        Scanner scan = new Scanner(new FileInputStream("input.txt"));
        while(scan.hasNextLine())
        {
            String nextLine1 = scan.nextLine();
            String nextLine2 = scan.nextLine();
            String nextLine3 = scan.nextLine();
            
            list1.clear();
            list2.clear();
            list3.clear();
            if(true)
            {
                String[] tab1 = nextLine1.split("\\s+");
                String[] tab2 = nextLine2.split("\\s+");
                String[] tab3 = nextLine3.split("\\s+");
                list1.add(Integer.parseInt(tab1[1]));
                list1.add(Integer.parseInt(tab2[1]));
                list1.add(Integer.parseInt(tab3[1]));
                
                list2.add(Integer.parseInt(tab1[2]));
                list2.add(Integer.parseInt(tab2[2]));
                list2.add(Integer.parseInt(tab3[2]));
                
                list3.add(Integer.parseInt(tab1[3]));
                list3.add(Integer.parseInt(tab2[3]));
                list3.add(Integer.parseInt(tab3[3]));
                list1.sort(new Comp());
                list2.sort(new Comp());
                list3.sort(new Comp());
                if(list1.get(0) + list1.get(1) > list1.get(2))counter++;
                if(list2.get(0) + list2.get(1) > list2.get(2))counter++;
                if(list3.get(0) + list3.get(1) > list3.get(2))counter++;
            }
        }
        
        return counter;
    }
    
}
