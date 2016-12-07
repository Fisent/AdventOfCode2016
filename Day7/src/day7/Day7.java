/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day7;

/**
 *
 * @author lukzi_000
 */
public class Day7
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        System.out.println(check("ioxxo"));
    }
    
    //checks string of four character
    public static boolean checkFourChars(String input)
    {
        char[] tab = input.toCharArray();
        System.out.println(input);
        return tab[0] == tab[3] && tab[1] == tab[2] && tab[0] != tab[1];
    }
    //checks string of any length
    public static boolean check(String input)
    {
        for(int i = 0; i<input.length()-3; i++)
        {
            if(checkFourChars(input.substring(i, i+4)))return true;
        }
        return false;
    }
    
}
