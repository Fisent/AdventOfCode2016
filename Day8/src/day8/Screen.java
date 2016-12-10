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
    public final int height = 6;
    
    
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
        boolean[] tab = new boolean[width];
        int j = y;
        for(int i = 0; i<width; i++)
        {
            tab[i] = matrix[i][j];
        }
        boolean[] temp = tab.clone();
        for(int i = 0; i<tab.length-1; i++)
        {
            tab[i+1] = temp[i];
        }
        tab[0] = temp[tab.length-1];
        for(int i = 0; i<width; i++)
        {
            matrix[i][j] = tab[i];
        }
    }
    
    public void rotateRow(int y, int count)
    {
        for(int i = 0; i<count; i++)
        {
            rotateRow(y);
        }
    }
    
    
    public void readLine(String line)
    {
        String[] in = line.split("\\s+");
        if(in[0].equals("rect"))
        {
            String[] sizes = in[1].split("x");
            int x = Integer.parseInt(sizes[0]);
            int y = Integer.parseInt(sizes[1]);
            rectangle(x,y);
        }
        else if(in[1].equals("row"))
        {
            String[] s = in[2].split("=");
            int y = Integer.parseInt(s[1]);
            int by = Integer.parseInt(in[4]);
            rotateRow(y,by);
            
        }
        else if(in[1].equals("column"))
        {
            String[] s = in[2].split("=");
            int x = Integer.parseInt(s[1]);
            int by = Integer.parseInt(in[4]);
            rotateColumn(x,by);
        }
    }
    
    public String toString()
    {
        String out = "Ilosc zapalonych: " + howManyLit() + "\n";
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
    
    public String howManyLit()
    {
        int counter = 0;
        for(int i = 0; i<width; i++)
        {
            for(int j = 0; j<height; j++)
            {
                if(matrix[i][j])counter++;
            }
        }
        return counter + "";
    }
}
