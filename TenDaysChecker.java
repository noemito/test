import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import Data.Customers;

public class Main {
	
	public static Scanner myScanner = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method 
		
		System.out.print("FirstName: ");
		String firstName = myScanner.next();
		System.out.print("LastName: ");
		String lastName = myScanner.next();
        
		Customers customer = new Customers(firstName,lastName);
		
		System.out.println(customer.getName());
		
		DateTimeFormatter dateFormater = DateTimeFormatter.ofPattern("MMM-dd-yyyy");
		
		System.out.println("SignUp Date: " + customer.getDateSignUp().format(dateFormater));
		LocalDate date = DueDate(customer.getDateSignUp().getMonthValue(), customer.getDateSignUp().getDayOfMonth());
		System.out.println("Due date: " + date.format(dateFormater));   
		
		
    }
	
	public static LocalDate DueDate(int month, int day) {
		// System.out.println("test!");
		
		int increment = 0;
		
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
        
        
        
        
        LocalDate dateNow = LocalDate.now();
        
        int defDate = finalDate.compareTo(dateNow);
        	
        
        if (defDate <= 0) 
        	System.out.println("Date Exceeded!!!!");
        else 
        	System.out.println("Days left: " + defDate + " days");
        
        
        return finalDate;
        
        //String formatDueDate = finalDate.format(dateFormater);
        
        //System.out.println("Due Date: " + formatDueDate);
        
        //TODO: CHECK THE REMAINING DAYS ON THE TIME THAT THEY SIGN UP
        
        
        
	}
}

