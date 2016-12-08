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
public class Screen
{
    public final int width = 50;
    public final int height = 8;
    
    
    public boolean[][] matrix = new boolean[width][height];
    
    public void rectangle(int x, int y)
    {
        for(int i = 0; i < x; i++)
        {
            for(int j = 0; j<y; j++)
            {
                matrix[i][j] = true;
            }
        }
    }
    
    public void rotateColumn(int x)
    {
        boolean[] tab = new boolean[height];
        int i = x;
        for(int j = 0; j<height; j++)
        {
            tab[j] = matrix[i][j];
        }
        //for(boolean b : tab)if(b)System.out.println("#");else System.out.println(".");
        boolean[] temp = tab.clone();
        for(int j = 0; j<tab.length-1; j++)
        {
            tab[j+1] = temp[j];
        }
        tab[0] = temp[tab.length-1];
        for(int j = 0; j<height; j++)
        {
            matrix[i][j] = tab[j];
        }
    }
    public void rotateColumn(int x, int count)
    {
        for(int i = 0; i<count; i++)
        {
            rotateColumn(x);
        }
    }
    public void rotateRow(int y)
    {
        boolean[] tab = new boolean[height];
        int j = y;
        for(int i = 0; i<height; i++)
        {
            tab[j] = matrix[i][j];
        }
        for(boolean b : tab)if(b)System.out.println("#");else System.out.println(".");
        boolean[] temp = tab.clone();
        for(int i = 0; i<tab.length-1; i++)
        {
            tab[i+1] = temp[i];
        }
        tab[0] = temp[tab.length-1];
        for(int i = 0; i<height; i++)
        {
            matrix[i][j] = tab[j];
        }
    }
    
    
    public String toString()
    {
        String out = "";
        for(int i = 0; i<height; i++)
        {
            for(int j = 0; j<width ;j++)
            {
                if(matrix[j][i])out+='#';
                else out+='.';
            }
            out+="\n";
        }
     return out;   
    }
}
