/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day7;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author lukzi_000
 */
public class Day7
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException
    {
        int i = 0;
        System.out.println(checkLine("ioxxoj[asdfgh]zxcvbn"));
        Scanner scan = new Scanner(new FileInputStream("input.txt"));
        while(scan.hasNextLine())
        {
            if(checkLine(scan.nextLine()))i++;
        }
        System.out.println(i);
    }
    
    //checks string of four character
    public static boolean checkFourChars(String input)
    {
        char[] tab = input.toCharArray();
        return tab[0] == tab[3] && tab[1] == tab[2] && tab[0] != tab[1];
    }
    //checks string of any length
    public static boolean check(String input)
    {
        for(int i = 0; i<input.length()-3; i++)
        {
            if(checkFourChars(input.substring(i, i+4)))return true;
        }
        return false;
    }
    
    public static ArrayList<String> getOutsideBraces(String input)
    {
        String s = input.replaceAll("]", "[");
        String[] in = s.split("\\[");
        ArrayList<String> out = new ArrayList<String>(); 
        for(int i = 0; i<in.length;i++)
        {
            if(i%2==0) out.add(in[i]);
                
        }
        return out;
    }
    
    public static ArrayList<String> getInsideBraces(String input)
    {
        String s = input.replaceAll("]", "[");
        String[] in = s.split("\\[");
        ArrayList<String> out = new ArrayList<String>(); 
        for(int i = 0; i<in.length;i++)
        {
            if(i%2==1) out.add(in[i]);
                
        }
        return out;
    }
    
    public static boolean checkLine(String line)
    {
        ArrayList<String> outside = getOutsideBraces(line);
        ArrayList<String> inside = getInsideBraces(line);
        
        boolean flag = false;
        
        for(String s : outside)
        {
            if(check(s)) flag = true;
        }
        for(String s : inside)
        {
            if(check(s))return false;
        }
        
        return flag;
    }
    
}
