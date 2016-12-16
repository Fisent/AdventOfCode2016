/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day15;

/**
 *
 * @author lukasz
 */
public class Disc
{
    private int size;
    private int position;
    
    public Disc(int size, int position)
    {
        this.size = size;
        this.position = position;
    }
    
    public void tick()
    {
        if(position==size-1)position = 0;
        else position++;
    }
    
    public boolean isPassable()
    {
        return position ==0;
    }
    
    @Override
    public String toString()
    {
        return "<size: "+ size + ", pos: " + position + ">"; 
    }
}
