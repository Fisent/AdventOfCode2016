/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day4;

/**
 *
 * @author lukasz
 */
public class Pair
{
    char character;
    int count;
    
    public Pair(char c, int i)
    {
        character = c;
        count = i; 
    }
    
    @Override
    public boolean equals(Object o)
    {
        Pair p = (Pair) o;
        
        return character==p.character;
    }
    
    @Override
    public int hashCode()
    {
        return count * character;
    }
    
    @Override
    public String toString()
    {
        return "<" + character + "," + count + ">";
    }
}
