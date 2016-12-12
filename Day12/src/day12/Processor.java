/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author lukasz
 */
public class Processor
{
    private HashMap<String, Integer> registers = new HashMap<>();
    int pc;
    ArrayList<String> program;
    
    public Processor()
    {
        pc = 0;
        registers.put("a", 0);
        registers.put("b", 0);
        registers.put("c", 0);
        registers.put("d", 0);
    }
    
    public void execute()
    {
        while(pc<program.size())
        {
            nextClock();
        }
    }
    
    public void nextClock()
    {
        System.out.println("pc: " + pc);
        String instruction = program.get(pc++);
        String[] tab = instruction.split("\\s+");
        
        if(tab[0].equals("cpy"))
        {
            copy(Integer.parseInt(tab[1]), tab[2]);
        }
        else if(tab[0].equals("inc")) increase(tab[1]);
        else if(tab[0].equals("dec")) decrease(tab[1]);
        else if(tab[0].equals("jnz")) jumpIfNotZero(tab[1], Integer.parseInt(tab[2]));
    }
    
    public void copy(int a0, String register)
    {
        registers.put(register, a0);
    }
    
    public void copy(String register0, String register1)
    {
        int a0 = registers.get(register0);
        System.out.println(a0);
        registers.put(register1, a0);
    }
    
    public void increase(String reg)
    {
        registers.put(reg, registers.get(reg) + 1);
    }
    
    public void decrease(String reg)
    {
        registers.put(reg, registers.get(reg) - 1);
    }
    
    public void jumpIfNotZero(String register, int howManySteps)
    {
        if(registers.get(register) != 0)
        {
            pc += howManySteps;
        }
    }
    
    public void loadProgram() throws FileNotFoundException
    {
        program = new ArrayList<>();
        
        Scanner scan = new Scanner(new FileInputStream("input.txt"));
        while(scan.hasNextLine())
        {
            program.add(scan.nextLine());
        }
    }
    
    @Override
    public String toString()
    {
        return registers.toString();
    }
}
