/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day8;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author lukasz
 */
public class Day8
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException
    {
        execute();
    }
    
    public static void execute() throws FileNotFoundException
    {
        Scanner scan = new Scanner(new FileInputStream("input.txt"));
        Screen s = new Screen();
        while(scan.hasNextLine())
        {
            s.readLine(scan.nextLine());
        }
        System.out.println(s);
    }
    
}
