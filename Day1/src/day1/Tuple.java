/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day1;

/**
 *
 * @author lukasz
 */
public class Tuple
{
    public int x;
    public int y;
    
    public Tuple(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    
    @Override
    public boolean equals(Object o)
    {
        if(o == null || !o.getClass().equals(this.getClass())) return false;
        
        Tuple tup = (Tuple) o;
        return (tup.x == x && tup.y == y);
    }
    
    @Override
    public int hashCode()
    {
        return x ^ y;
    }
}
