/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day15;

import java.util.ArrayList;

/**
 *
 * @author lukasz
 */
public class DiscMachine
{
    int time;
    
    private ArrayList<Disc> discs;
    private int ballPosition;
    private boolean falling;

    
    public DiscMachine()
    {
        discs = new ArrayList<>();
        time = 0;
        this.ballPosition = -1;
        this.falling = false;
    }
    
    
    public void tickDiscs()
    {
        for(Disc d : discs)
        {
            d.tick();
        }
        time++;
        if(falling)ballPosition++;
                System.out.println(this);

    }
    
    public void addDisc(Disc d)
    {
        discs.add(d);
    }
    
    @Override
    public String toString()
    {
        String out = "Time: " + time + "\n" + "ballPosition: " + ballPosition + "\n" + "Discs:\n";
        for(Disc d: discs)
        {
            out += d.toString() + "\n";
        }
        return out;
    }
    
    public boolean fall()
    {
        boolean result = true;
        falling = true;
        for(int i = 0; i < discs.size(); i++)
        {
            if(!discs.get(i).isPassable()) result = false;
            this.tickDiscs();
        }
        return result;
    }
    
    public static DiscMachine prepareMachine(int time)
    {
        DiscMachine dm = new DiscMachine();
        dm.addDisc(new Disc(17,15));
        dm.addDisc(new Disc(3,2));
        dm.addDisc(new Disc(19,4));
        dm.addDisc(new Disc(13,2));
        dm.addDisc(new Disc(7,2));
        dm.addDisc(new Disc(5,0));
        for(int i = 0; i< time; i++)
        {
            dm.tickDiscs();
        }
        return dm;
    }
}
