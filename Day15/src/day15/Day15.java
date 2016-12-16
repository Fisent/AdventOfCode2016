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
public class Day15
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        DiscMachine dm = new DiscMachine();
        dm.addDisc(new Disc(5,4));
        dm.addDisc(new Disc(2,1));
        System.out.println(dm.fall());
    }
    
}
