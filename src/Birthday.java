/**
 Namho An
 2/11/2015
 COSI12b
 PA02
 */

import java.util.*;

public class Birthday{
	public static void main(String [] args ){
		
		//Prompt for birth year, month, day 
		Scanner scan = new Scanner(System.in);
		System.out.print("What month, day, and year were you born?  ");
		
		//Scanning scan
		int month = scan.nextInt();
		int day = scan.nextInt();
		int year = scan.nextInt();
	
		//Instantiating date and today TeacherDate objects
		TeacherDate date = new TeacherDate(year, month, day);
		TeacherDate today = new TeacherDate();
	
		//Print out the date and the day that user's born.
		System.out.println("You were born on " + date.toString() + ", which was a " + date.getDayOfWeek() + ".");
		
		//Print message with age if today is the birthday entered, .
		if (date.getDay() == today.getDay() && date.getMonth() == today.getMonth()){
			System.out.println("Happy Birthday!! You are now " + getAge(date, today) + " years old");
		}
		//If it is a leap year, print the birthday occurred on a leap year.
		else if (date.isLeapYear()){
			System.out.println(date.getYear() + " was a leap year.");
		}
	  
		//Print out how many days it is until birthday only if today is not your birthday.
		if (dayCounter(date, today) % 365 == 0){
			System.out.println("It will be your birthday in " + daysTilBirthday(date, today) + " days.");
		}
		//Print user's age.
		System.out.println("You are " + dayCounter(date, today) + " days old.");
		
	}
	
	//getAge Calculates age.
	public static int getAge( TeacherDate date, TeacherDate today ){
		return (today.getYear() - date.getYear());
	}
	
	public static int dayCounter(TeacherDate date, TeacherDate today){
		double daysOld = 0;
		TeacherDate dayCounter = new TeacherDate(date.getYear(), date.getMonth(), date.getDay());
		while (dayCounter.equals(today) == false) {	
			++daysOld;
			dayCounter.nextDay();		
		}
		
		return (int) daysOld;
	}

	//daysUntilBirthday calculates daysUntilBirthday
	public static int daysTilBirthday(TeacherDate date, TeacherDate today){
		int x = 0;
		while (today.getDay() != date.getDay() || today.getMonth() != date.getMonth()) {
		x++;
		today.nextDay();
	}
		return x;
	}
	
}