package com.htc.fundamentals;



public class DateDifference {

	// To store number of days in all months from January to Dec.
	 public static int monthDays[] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	

	// This function counts number of leap years before the
	// given date
	public static int countLeapYears(int day,int mon,int year)
	{
	 
	    // Check if the current year needs to be considered
	    // for the count of leap years or not
	    if (mon <= 2)
	        year--;
	 
	    // An year is a leap year if it is a multiple of 4,
	    // multiple of 400 and not a multiple of 100.
	    return (year / 4) - (year / 100) + (year / 400);
	}
	 
	
	// This function returns number of days between two given
	// dates
	public static int getDifference( int day1,int mon1,int year1, int day2,int mon2,int year2)
	{
	    // COUNT TOTAL NUMBER OF DAYS BEFORE FIRST DATE  
	 
	    // initialize count using years and day
	    int n1 = year1*365 + day1;
	 
	    // Add days for months in given date
	    for (int i=0; i<mon1 - 1; i++)
	        n1 += monthDays[i];
	 
	    // Since every leap year is of 366 days,
	    // Add a day for every leap year
	    n1 += countLeapYears(day1,mon1,year1);
	    System.out.println(countLeapYears(day1,mon1,year1));
	 
	    // SIMILARLY, COUNT TOTAL NUMBER OF DAYS BEFORE 'dt2'
	 
	    int  n2 = year2*365 + day2;
	    for (int i=0; i<mon2 - 1; i++)
	        n2 += monthDays[i];
	    n2 += countLeapYears(day2,mon2,year2);
	 System.out.println(countLeapYears(day2,mon2,year2));
	    // return difference between two counts
	    return (n2 - n1);
	}
	
	public boolean Isleap(int year) {
		boolean leapYearFlag = false;
		if (((year % 4) == 0 && (year % 100) != 0) || (year % 400 == 0)) {
			leapYearFlag = true;
		}
		return leapYearFlag;
	}

	public static void main(String[] args) {
		
		int noOfDays=getDifference(1, 2, 2001,1, 3, 2001);
		System.out.println("Date Difference: "+noOfDays);

	}

}
