import java.util.*;

public class Date{
	private int year;
	private int month;
	private int day;
	private int dayOfWeekIndex;
	private static final int MonthPerYear = 12;
	private static final int EndOfWeek = 6;
	private static final int BeginningDayOfWeek = 0;
	String [] daysInWeek = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};
	
	//If initial values of values are given, go though conditions and assign if the value is within the condition.
	public Date(int year, int month, int day){
		if (year < 0 || month < 0 || month > 12 || day < 0 || day > 31){
			throw new IllegalArgumentException();
		}
		this.year = year;
		this.month = month;
		this.day = day;
	}
	//If no initial values are set, calculate the today's date.
	public Date(){
		int dayCount = 0;
		while (dayCount < this.daysSinceEpoch()){
			this.nextDay();
			++dayCount;
		}
	}
		
	//getDay() returns day
	public int getDay(){
		return this.day;
	}
	
	//getMonth() returns month
	public int getMonth(){
		return this.month;
	}
	
	//getYear() returns year
	public int getYear(){
		return this.year;
	}

	
	//getdayOfWeek() returns day of week
    public String getDayOfWeek(){
            return this.daysInWeek[this.dayOfWeekIndex];
    }

	
	//isLeapYear() returns whether year is leap year or not
	public boolean isLeapYear(){
		if ((this.year % 4 == 0) && (this.year % 100 != 0) || (this.year % 400 == 0)){
			return true;
		}
		else{
			return false;
		}
	}
	
	//nextDay() returns next day
	public void nextDay(){
		if (this.getDay() < this.daysInMonth() ){
			++this.day;
		}
		else if (this.getDay() == this.daysInMonth() && this.getMonth() < MonthPerYear){
			++this.month;
			this.day = 1;
		}
		else if (this.getMonth() == MonthPerYear){
			++this.year;
			this.month = 1;
			this.day = 1;
		}	
		
		if (this.dayOfWeekIndex == EndOfWeek){
			this.dayOfWeekIndex = BeginningDayOfWeek;
		}
		++this.dayOfWeekIndex;
	
		
	}
	
	//toString() converts date to string and returns the value
	public String toString(){
		return this.year + "/" + this.month + "/" + this.day;
	}
	
	//equals() compares to objects, 
	public boolean equals (Object o){
		if (o instanceof Date){
			Date others = (Date) o;
			//Return whether the attributes are the same for each. 
			return this.year == others.year && this.month == others.month && this.day == others.day; 
		}
		else { 
			return false;
		}
		
	}
	
	//A method that returns the days in a month
	public int daysInMonth(){		
		int [] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		if (this.isLeapYear()){
			months[1] = 29;
		}
		if (this.month == 1){
			return months[0];
		}
		else{
			return months[this.month - 1];
		}
		
	}

	public int daysSinceEpoch(){
		return (int) ((System.currentTimeMillis() + TimeZone.getDefault().getRawOffset()) / 1000 / 60 / 60 / 24);
	}
}
