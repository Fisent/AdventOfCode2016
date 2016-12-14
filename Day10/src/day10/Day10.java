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
public class Day10
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Bot bot1 = new Bot();
        bot1.addValue(4);
        bot1.addValue(1);
        bot1.giveLow();
        System.out.println(bot1);
        
    }
    
}
