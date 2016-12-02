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
public class Console
{
    public int[][] keypad;
    public int curX;
    public int curY;
    
    public Console()
    {
        curX = 1;
        curY = 1;
        keypad = new int[3][3];
        keypad[0][0] = 7;
        keypad[0][1] = 8;
        keypad[0][2] = 9;
        keypad[1][0] = 4;
        keypad[1][1] = 5;
        keypad[1][2] = 6;
        keypad[2][0] = 1;
        keypad[2][1] = 2;
        keypad[2][2] = 3;
    }
    
    public int calculateLine(String line)
    {
        for(char c : line.toCharArray())
        {
            if(c == 'U')
            {
                if(curX<2)curX++;
            }
            if(c == 'D') if(curX>0)curX--;
            if(c == 'L') if(curY>0)curY--;
            if(c == 'R') if(curY<2)curY++;
        }
        return keypad[curX][curY];
    }
    
    public String calculateAll() throws FileNotFoundException
    {
        String out = "";
        Scanner scan = new Scanner(new FileInputStream("input.txt"));
        while(scan.hasNextLine())
        {
            String temp = scan.nextLine();
            System.out.println(out);
            out += calculateLine(temp);
        }
        
        return out;
    }
}
