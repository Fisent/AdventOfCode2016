package day13;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lukasz
 */
public class Room
{
    boolean[][] matrix;
    int size;
    
    int xPos;
    int yPos;
    
    public Room(int size)
    {
        matrix = new boolean[size][size];
        for(int i = 0; i<size; i++)
        {
            for(int j = 0; j<size; j++)
            {
                matrix[i][j] = false;
            }
        }
        this.size = size;
        xPos = 1;
        yPos = 1;
    }
    
    @Override
    public String toString()
    {
        String out = "";
        for(int x = 0; x<size; x++)
        {
            for(int y = 0; y< size; y++)
            {
                if(matrix[y][x])out+='#';
                else out+='.';
            }
            out += "\n";
        }
        return out;
    }
    
    public void generate(int favouriteNumber)
    {
        int number = 0;
        int counter = 0;
        for(int x = 0; x<size; x++)
        {
            for(int y = 0; y<size; y++)
            {
                number = x*x + 3*x + 2*x*y + y + y*y;
                number += favouriteNumber;
                String binaryString = Integer.toBinaryString(number);
                counter = 0;
                for(int i = 0; i<binaryString.length(); i++)
                {
                    if(binaryString.charAt(i) == '1')counter++;
                }
                
                if(counter%2 == 1) matrix[x][y] = true;
                else matrix[x][y] = false;
            }
        }
    }
    
    
}
