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
        LinkedList<Integer> list = new LinkedList<>();
        Scanner scan = new Scanner(new FileInputStream("input.txt"));
        while(scan.hasNextLine())
        {
            String nextLine = scan.nextLine();
            
            list.clear();
            if(!nextLine.equals(""))
            {
                String[] tab = nextLine.split("\\s+");
                list.add(Integer.parseInt(tab[1]));
                list.add(Integer.parseInt(tab[2]));
                list.add(Integer.parseInt(tab[3]));
                list.sort(new Comp());
                if(list.get(0) + list.get(1) > list.get(2))counter++;
            }
        }
        
        return counter;
    }
    
}
