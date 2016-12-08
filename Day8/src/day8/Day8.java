/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day8;

/**
 *
 * @author lukasz
 */
public class Day8
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Screen s = new Screen();
        s.rectangle(3, 3);
        s.rotateRow(0);
        System.out.println(s);
    }
    
}
