/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day16;

/**
 *
 * @author lukasz
 */
public class Day16
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        String expanded = dragonCurve("10111011111001111", 35651584);
        System.out.println(checksum(expanded));
        
    }
    
    public static String dragonCurveStep(String input)
    {
        String a = input;
        String b = new String(input);
        
        b = new StringBuilder(b).reverse().toString();
        
        String newB = "";
        for(char c : b.toCharArray())
        {
            if(c == '1')newB+="0";
            else newB+="1";
        }
        b = newB;
        return a + "0" + b;
    }
    
    public static String dragonCurve(String input ,int length)
    {
        while(input.length()!=length)
        {
            System.out.println(input.length());
            if(input.length()>length)
            {
                input = input.substring(0, length);
            }
            else
            {
                input = dragonCurveStep(input);
            }
        }
        return input;
    }
    
    public static String checksumStep(String input)
    {
        String out = "";
        for(int i = 0; i<input.length(); i+=2)
        {
            if(input.charAt(i) == input.charAt(i+1))
            {
                out += "1";
            }
            else out += "0";
        }
        return out;
    }
    
    public static String checksum(String input)
    {
        while(input.length()%2 == 0)
        {
            input = checksumStep(input);
        }
        return input;
    }
}