/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day3;

import java.util.Comparator;

/**
 *
 * @author lukasz
 */
public class Comp implements Comparator
{

    @Override
    public int compare(Object o1, Object o2)
    {
        int i1 = (int) o1;
        int i2 = (int) o2;
        
        return i1-i2;
    }
    
}
