/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author lukasz
 */
public class Day4
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException
    {      
        System.out.println(getList());
    }
    
    public static int calculate() throws FileNotFoundException
    {
        int out = 0;
        Scanner scan = new Scanner(new FileInputStream("input.txt"));
        while(scan.hasNextLine())
        {
            out += (new Name(scan.nextLine())).value();
        }
        return out;
    }
    
    public static List<Name> getList() throws FileNotFoundException
    {
        List<Name> out = new LinkedList<>();
        Scanner scan = new Scanner(new FileInputStream("input.txt"));
        while(scan.hasNextLine())
        {
            Name n = new Name(scan.nextLine());
            if(n.isValid())out.add(n);
        }
        return out;
    }
    
}
