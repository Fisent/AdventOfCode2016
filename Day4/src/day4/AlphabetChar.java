/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day4;

/**
 *
 * @author lukasz
 */
public class AlphabetChar
{
    public char character;
    
    public AlphabetChar(char c)
    {
        character = c;
    }
    
    public void shift(int offset)
    {
        for(int i = 0 ; i<offset; i++)shiftByOne();
    }
    
    public void shiftByOne()
    {
        if(character == 'z')character = 'a';
        else character++;
    }
    
    @Override
    public String toString()
    {
        return character + "";
    }
}
