/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day10;

/**
 *
 * @author lukasz
 */
public class Bot
{
    Integer lower;
    Integer higher;
    
    public Bot()
    {
        lower = null;
        higher = null;
    }
    
    public boolean isEmpty()
    {
        return (lower == null && higher == null);
    }
    
    public boolean isFull()
    {
        return lower != null && higher != null;
    }
    
    public void addValue(int value)
    {
        if(isEmpty()) lower = value;
        else if(isFull()) throw new RuntimeException("pelny");
        else if(value>lower)higher = value;
        else 
        {
            higher = lower;
            lower = value;
        }
    }
    
    public String toString()
    {
        return "|" + lower + "|_('')-|" + higher + "|\n";
    }
    
    public int giveLow()
    {
        int out = lower;
        lower = higher;
        higher = null;
        return out;
    }
    
    public int giveHigh()
    {
        int out = higher;
        higher = null;
        return out;
    }
}
