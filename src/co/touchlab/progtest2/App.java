package co.touchlab.progtest2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class App 
{
	private static String filename;
	private static int loopback;
    private static int[] charList = new int[256];
    
    public static void main( String[] args )
    {
    	readInput(); 
    	readText();
    }
    
    private static void readText()
    {
        BufferedReader br = null;
        FileReader fr = null;
        
        try {
     	   fr = new FileReader("src\\\\"+filename);
     	   br = new BufferedReader(fr);
     	   
     	   // Assume text file has 1 line with the string on it.
     	   String line = br.readLine();
     	   // Because char are ASCII, they can be converted to int
     	   char[] s = line.toCharArray();
     	   
     	   // Since each char is a integer, we can track how many times 
     	   // the char appears in the string by keeping an array of 
     	   // size 256 and counting the number of times each position
     	   // was incremented.
     	   for (int c=0;c<s.length;c++)
     		   charList[s[c]] ++;
     	   
     	   
     	   // Now we simply print the charList as result
     	   for (int c=0;c<charList.length;c++)
     	   {
     		   if (charList[c] > 0)
     		   {
     			   System.out.println((char) c + "-" + charList[c]);
     		   }
     	   }
     	   
        }catch (IOException e)
        {
     	   System.out.println("Error reading textfile of actors, program exiting...");
     	   e.printStackTrace();
     	   System.exit(0);
        }
    }
    
    // Reads in file name and loopback
    private static void readInput()
    {
        try{
            Scanner reader = new Scanner(System.in);
            System.out.println("Please enter the filename, and make sure it is in src folder and ends with .txt: ");
            filename = reader.next();
     	    System.out.println("Please enter the number of loopback spots: ");
            loopback = reader.nextInt();
        }catch (Exception e){
     	   System.out.println("Error reading user input, program exiting...");
     	   e.printStackTrace();
     	   System.exit(0);
        }
    }
}
