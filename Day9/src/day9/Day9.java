/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day9;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Scanner;

/**
 *
 * @author lukasz
 */
public class Day9
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException
    {
        read();
    }
    
    
    public static void read() throws FileNotFoundException, IOException
    {
        Reader scan = new InputStreamReader(new FileInputStream("input.txt"));
        String output = "";
        while(scan.ready())
        {
            char c =(char) scan.read();
            //System.out.println(c);
            if(c=='(')
            {
                char ch =(char) scan.read();
                String s ="";
                while(ch!=')')
                {
                    s+=ch;
                    ch  = (char) scan.read();
                }
                String[] tab = s.split("x");
                int x = Integer.parseInt(tab[0]);
                int y = Integer.parseInt(tab[1]);
                String toRepeat = "";
                for(int i = 0; i<x; i++)
                {
                    toRepeat += (char) scan.read();
                }
                for(int i = 0; i< y; i++)
                {
                    output += toRepeat;
                }
            }
            else output+=c;
        }
        System.out.println(output.length());
    }
    
}
