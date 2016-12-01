package day1;

import java.util.HashMap;
import java.util.HashSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lukasz
 */
public class Santa
{
    public static String N = "north";
    public static String S = "south";
    public static String E = "east";
    public static String W = "west";
    
    
    private int x;
    private int y;
    private String direction;
    HashSet<Tuple> set = new HashSet<>();
    
    public Santa()
    {
        x=0;
        y=0;
        direction = N;
    }
    
    public boolean doInstruction(String instr)
    {
        int oldX = x;
        int oldY = y;
        
        
        if(instr.charAt(0) == 'L')
        {
            if(direction.equals(N))direction = W;
            else if(direction.equals(W))direction = S;
            else if(direction.equals(S))direction = E;
            else if(direction.equals(E))direction = N;
        }
        else if(instr.charAt(0) == 'R')
        {
            if(direction.equals(N))direction = E;
            else if(direction.equals(E))direction = S;
            else if(direction.equals(S))direction = W;
            else if(direction.equals(W))direction = N;
        }
        String lenStr = instr.substring(1);
        int len = Integer.parseInt(lenStr);
        
        
        if(move(direction, len))return true;
        else return false;
    }
    
    public boolean move(String dir, int dis)
    {
        for(int i = 0; i<dis; i++)
        {
            if(step(dir))return true;
        }
        return false;
    }
    
    public boolean step(String dir)
    {
        if(dir.equals(N))x++;
        if(dir.equals(S))x--;
        if(dir.equals(E))y++;
        if(dir.equals(W))y--;
        if(set.contains(new Tuple(x,y))) return true;
        else
        {
            set.add(new Tuple(x, y));
            return false;
        }
    }
    
    public String toString()
    {
        return "x: " + x + ", y: " + y + ", dir: " + direction;
    }
    
    public int getDistance()
    {
        return Math.abs(x) + Math.abs(y);
    }
}
