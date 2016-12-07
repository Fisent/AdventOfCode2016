/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day7;

import static day7.Day7.checkFourChars;
import java.util.ArrayList;
import java.util.HashSet;

/**
 *
 * @author lukasz
 */
public class SLLChecker
{
    
    public ArrayList<String> getOutsideBraces(String input)
    {
        String s = input.replaceAll("]", "[");
        String[] in = s.split("\\[");
        ArrayList<String> out = new ArrayList<String>(); 
        for(int i = 0; i<in.length;i++)
        {
            if(i%2==0) out.add(in[i]);
                
        }
        return out;
    }
    
    public ArrayList<String> getInsideBraces(String input)
    {
        String s = input.replaceAll("]", "[");
        String[] in = s.split("\\[");
        ArrayList<String> out = new ArrayList<String>(); 
        for(int i = 0; i<in.length;i++)
        {
            if(i%2==1) out.add(in[i]);
                
        }
        return out;
    }
    
    
    public boolean checkThreeChars(String input)
    {
        char[] tab = input.toCharArray();
        return tab[0] == tab[2] && tab[0] != tab[1];
    }
    
    
    public String translate(String threeChars)
    {
        if(checkThreeChars(threeChars))
        {
            char[] tab = threeChars.toCharArray();
            return "" + tab[1] + tab[0] + tab[1]; 
        }
        
        else 
        {
            //System.out.println("translate error");
            return "";
        }
    }
    
    public boolean checkLine(String line)
    {
        ArrayList<String> outside = getOutsideBraces(line);
        ArrayList<String> inside = getInsideBraces(line);
        
        HashSet<String> inSet = new HashSet<>();
        HashSet<String> outSet = new HashSet<>();
        
        for(String s : inside)
        {
            for(int i = 0; i<s.length()-2; i++)
            {
                inSet.add(s.substring(i,i+3));
            }
        }
        for(String s : outside)
        {
            for(int i = 0; i<s.length()-2; i++)
            {
                outSet.add(s.substring(i,i+3));
            }
        }
        
        //System.out.println(inSet);
        //System.out.println(outSet);
        
        boolean flag = false;
        
        for(String s1 : inSet)
        {
            for(String s2 : outSet)
            {
                if(translate(s1).equals(s2))return true;
            }
        }
        return false;
    }
}
