/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day13;

/**
 *
 * @author lukasz
 */
public class Day13
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        Room r = new Room(80);
        r.generate(1358);
        System.out.println(r);
    }
    
}
