/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package day4;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

/**
 *
 * @author lukasz
 */
public class Name
{
    public String[] singleNames;
    public int id;
    public String checksum;
    
    
    public Name(String input)
    {
        String[] in = input.split("-");
        singleNames = new String[in.length-1];
        int i = 0;
        for(;i<in.length-1;i++)
        {
            singleNames[i] = in[i];
        }
        String last = in[i];
        String[] spl = last.split("\\[");
        id = Integer.parseInt(spl[0]);
        checksum = spl[1].substring(0, spl[1].length()-1);
    }
    
    public boolean isValid()
    {
        return fiveMostUsed().equals(checksum);
    }
    
    public int value()
    {
        if(isValid())return id;
        else return 0;
    }
    
    /*@Override
    public String toString()
    {
        String out = "[";
        for(String s : singleNames)
        {
            out += s + ",";
        }
        out+="]";
        return out + " " + id + " " + checksum;
    }*/
    
    @Override 
    public String toString()
    {
        String out = "";
        for(String s : singleNames)
        {
            for(char c : s.toCharArray())
            {
                AlphabetChar ch = new AlphabetChar(c);
                ch.shift(id);
                out+=ch.character;
            }
            out+=" ";
        }
        return out + "(" +id + ")" + "\n";
    }
    
    public String fiveMostUsed()
    {
        String input = "";
        for(String s : singleNames)input+=s;
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(char c : input.toCharArray())
        {
            if(map.containsKey(c))map.put(c, map.get(c)+1);
            else map.put(c, 1);
        }
        
        LinkedList<Pair> list = new LinkedList<>();
        for(char c : map.keySet()) list.add(new Pair(c,map.get(c)));
        
        list.sort(new Comparator()
        {
            @Override
            public int compare(Object a, Object b)
            {
                Pair p1 = (Pair) a;
                Pair p2 = (Pair) b;
                
                if(p2.count==p1.count)return p1.character-p2.character;
                return p2.count - p1.count;
            }
        });
        
        //System.out.println(list.toString());
        
        
        int max = list.get(0).count;
        String out = "";
        for(int i = max; i>=0;i--)
        {
            for(Pair p : list)
            {
                if(p.count==i)out+=p.character;
            }
        }
        
        String RESULT = out.substring(0,5);
        return RESULT;
    }
    
    public String alphabeticalOrder(String s)
    {
        char[] tab = s.toCharArray();
        LinkedList<Character> list = new LinkedList<>();
        for(char c : tab)
        {
            list.add(c);
        }
        list.sort(new Comparator()
        {
            @Override
            public int compare(Object a, Object b)
            {
                char c1 = (char) a;
                char c2 = (char) b;
                if(c1>c2)return 1;
                else return -1;
            }
        });
        String out = "";
        for(char c : list)out+=c;
        return out;
    }
    
    
}
