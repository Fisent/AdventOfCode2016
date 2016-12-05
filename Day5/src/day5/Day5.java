/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day5;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author lukzi_000
 */
public class Day5
{

    int index = 0;
    String input = "abc";
    
    public static void main(String[] args) throws NoSuchAlgorithmException
    {
        Day5 d = new Day5();
        String password = "________";
        
        while(password.contains("_"))
        {
            String next = MD5(d.findNext());
            
            if(Character.isDigit(next.charAt(5)))
            {
                int index = Integer.parseInt(next.charAt(5) + "");
                if(index>=0 && index<8 && password.charAt(index) == '_')
                {
                    password = replace(password, Integer.parseInt(next.charAt(5) + ""), next.charAt(6) + "");
                }
            }
            
            
            d.index++;
            System.out.println(password);
        }
        System.out.println(password);
    }
    
    public static String MD5(String input) throws NoSuchAlgorithmException
    {
        String plaintext = input;
        MessageDigest m = MessageDigest.getInstance("MD5");
        m.reset();
        m.update(plaintext.getBytes());
        byte[] digest = m.digest();
        BigInteger bigInt = new BigInteger(1,digest);
        String hashtext = bigInt.toString(16);
        // Now we need to zero pad it if you actually want the full 32 chars.
        while(hashtext.length() < 32 ){
          hashtext = "0"+hashtext;
        }
        
        return hashtext;
    }
    
    public String findNext() throws NoSuchAlgorithmException
    {
        String buffer = input + index;
        while(!hasFiveZeros(buffer))
        {
            //System.out.println(buffer);
            index++;
            buffer = input+index;
        }
        System.out.println(buffer);
        System.out.println(MD5(buffer));
        return buffer; 
    }
    
    public boolean hasFiveZeros(String s) throws NoSuchAlgorithmException
    {
        String hashed = MD5(s);
        return (hashed.charAt(0) == '0') && (hashed.charAt(1) == '0') && (hashed.charAt(2) == '0') && (hashed.charAt(3) == '0') && (hashed.charAt(4) == '0');
    }
    
    
    public static String replace(String s, int index, String character)
    {
        String out = "";
        for(int i = 0; i< s.length(); i++)
        {
            if(i == index)
            {
                out+=character;
            }
            else out += s.charAt(i);
        }
        
        return out;
    }
    
}
