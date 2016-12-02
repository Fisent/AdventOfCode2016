/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day2;

/**
 *
 * @author lukasz
 */
public class LinkedConsole
{
    public final String value;
    
    public LinkedConsole left;
    public LinkedConsole right;
    public LinkedConsole up;
    public LinkedConsole down;
    
    public LinkedConsole(String value)
    {
        this.value = value;
    }
    
    public LinkedConsole go(char direction)
    {
        if(direction=='D')if(down!=null)return down;
        if(direction=='U')if(up!=null)return up;
        if(direction=='L')if(left!=null)return left;
        if(direction=='R')if(right!=null)return right;
        return this;
    }
}
