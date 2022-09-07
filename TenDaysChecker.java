import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int increment = 0;
		
		
		Scanner myScanner = new Scanner(System.in);
		
		System.out.println("Please Enter The Month:");
		int month = myScanner.nextInt();
		System.out.println("Please Enter The Day:");
		int day = myScanner.nextInt();
		
        boolean ifNotTenDays = true;
        
        int TenDays = 10;
        // Date Sign Up
        
        LocalDate finalDate = null;
        
        LocalDate signUpDate = LocalDate.of(2022, month, day);
        
        while (ifNotTenDays) {
            
        	increment++;
            
            LocalDate dueDate = signUpDate.plusDays(increment); 
            
            DayOfWeek dayOfWeek =  dueDate.getDayOfWeek();
            
            
            if(dayOfWeek.getValue() == 6 || dayOfWeek.getValue() == 7) {
            	
            }
            
            else TenDays--;
            
            if(TenDays == 0) {
            	ifNotTenDays = false;
            	finalDate = dueDate;
            }
          
        }
        
        DateTimeFormatter dateFormater = DateTimeFormatter.ofPattern("MMM-dd-yyyy");
        
        String formatDueDate = finalDate.format(dateFormater);
        
        System.out.println("Due Date: " + formatDueDate);
        
        //TODO: CHECK THE REMAINING DAYS ON THE TIME THAT THEY SIGN UP
        
        LocalDate dateNow = LocalDate.now();
        
        int defDate = finalDate.compareTo(dateNow);
        
        
        if (defDate <= 0) 
        	System.out.println("Date Exceeded!!!!");
        else 
        	System.out.println("Days left berfore Due: " + defDate+ "days!");
     
        
        
        
    }
}

