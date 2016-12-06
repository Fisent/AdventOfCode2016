/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day6;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author lukzi_000
 */
public class Day6
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException
    {
        String out = "";
        for(int i = 0; i<8; i++)
        {
            out += getLetter(i);
            System.out.println(out);
        }
        System.out.println("Wynik: " + out);
    }
    
    public static String getLetter(int index) throws FileNotFoundException
    {
        HashMap<Character, Integer> map = new HashMap<>();
        Scanner scan = new Scanner(new FileInputStream("input.txt"));
        String line = "";
        
        while(scan.hasNextLine())
        {
            line = scan.nextLine();
            char c  = line.charAt(index);
            int value = 1;
            if(map.containsKey(c))
            {
                value = map.get(c);
                value++;
                map.remove(c);
                map.put(c, value);
                value = 1;
            }
            else
            {
                map.put(c, 1);
            }
        }
        System.out.println(map.toString());
        return min(map) + "";
        
        
    }
    
    
    public static char max(HashMap<Character, Integer> map)
    {
        char out = ' ';
        for(char c : map.keySet())
        {
            if(out == ' ' || map.get(out) < map.get(c))
            {
                out = c;
            }
        }
        return out;
    }
    
    public static char min(HashMap<Character, Integer> map)
    {
        char out = ' ';
        for(char c : map.keySet())
        {
            if(out == ' ' || map.get(out) > map.get(c))
            {
                out = c;
            }
        }
        return out;
    }
    
}
