/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author lukasz
 */
public class ConsoleInterface
{
    public LinkedConsole current;
    
    public ConsoleInterface()
    {
        current = new LinkedConsole("7");
        
        LinkedConsole b1 = new LinkedConsole("1");
        LinkedConsole b2 = new LinkedConsole("2");
        LinkedConsole b3 = new LinkedConsole("3");
        LinkedConsole b4 = new LinkedConsole("4");
        LinkedConsole b5 = new LinkedConsole("5");
        LinkedConsole b6 = new LinkedConsole("6");
        LinkedConsole b8 = new LinkedConsole("8");
        LinkedConsole b9 = new LinkedConsole("9");
        LinkedConsole bA = new LinkedConsole("A");
        LinkedConsole bB = new LinkedConsole("B");
        LinkedConsole bC = new LinkedConsole("C");
        LinkedConsole bD = new LinkedConsole("D");
        
        current.left = b6;
        current.down = bB;
        current.up = b3;
        current.right = b8;
        b1.down = b3;
        b2.down = b6;
        b2.right = b3;
        b3.up = b1;
        b3.left = b2;
        b3.down = current;
        b3.right = b4;
        b4.left = b3;
        b4.down = b8;
        b5.right = b6;
        b6.left = b5;
        b6.up = b2;
        b6.right = current;
        b6.down = bA;
        b8.up = b4;
        b8.down = bC;
        b8.left = current;
        b8.right = b9;
        b9.left = b8;
        bA.up = b6;
        bA.right = bB;
        bB.left = bA;
        bB.up = current;
        bB.right = bC;
        bB.down = bD;
        bC.up = b8;
        bC.left = bB;
        bD.up = bB;
    }
    
    public String returnDigit(String line)
    {
        for(char c : line.toCharArray())
        {
            current = current.go(c);
        }
        return current.value;
    }
    
    public String calculate() throws FileNotFoundException
    {
        String out = "";
        Scanner scan = new Scanner(new FileInputStream("input.txt"));
        while(scan.hasNextLine())
        {
            String temp = scan.nextLine();
            System.out.println(out);
            out += returnDigit(temp);
        }
        
        return out;
    }
}
