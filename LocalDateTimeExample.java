package Coding;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeExample {

	public static void main(String[] args) {
		
		int curtime = 15;
		String greet;
		LocalDateTime now = LocalDateTime.now();
		System.out.println("Before Formatting:" + now);
		DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
		 String formatDateTime = now.format(format);
		 System.out.println("After Formatting:" + formatDateTime);
		 if (curtime < 12)
		 {
			 greet = "Good Morning";
			
		 }
		 else if (curtime >= 12 && curtime <16)
		 {
			 greet = "Good afternoon";
			
		 }
		 else if (curtime >= 16 && curtime <=19)
		 {
			 greet = "Good evening";
			
		 }
		 else
		 {
			 greet = "Good Night";
		 }
		 System.out.println(LocalTime.now().getHour() +greet);
		 System.out.println("Expecting" + greet + "in the happening");
		 
		

	}

}
