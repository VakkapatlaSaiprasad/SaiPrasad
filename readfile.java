package Coding;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.runtime.SwitchBootstraps;
import java.util.Scanner;

public class readfile {

	public static void main(String[] args) throws FileNotFoundException {
		
		File myFile = new File("C://Users//Administrator//Desktop/sai.txt");
		
		System.out.println(myFile.exists());
		Scanner myScanner = new Scanner (myFile);
		
		while (myScanner.hasNextLine()) {
			String line = myScanner.nextLine();
			System.out.println(line);
			
			String[] USERDETAILS = line.split(",");
			
			for (int i=0;i <  USERDETAILS.length; i++)
				
				{
					switch (i)
					{
						case 0:
						{
							System.out.println("username:"+  USERDETAILS[i]);
							break;
						}
						case 1:
						{
							System.out.println("password:"+  USERDETAILS[i]);
							break;
						}
						
					}
				    }
		 }
	 }
}
				
						

