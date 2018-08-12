package com.htc.fundamentals;

class DateDiff {
	// to find the given year is leap year or not
	public static boolean isleap(int year) {
		boolean leapYearFlag = false;
		// refer the below link for formula explanation
		//https://www.wwu.edu/skywise/leapyear.html
		if (((year % 4) == 0 && (year % 100) != 0) || (year % 400 == 0)) {
			leapYearFlag = true;
		}
		return leapYearFlag;
	}
	public static void main(String args[]) {

		// start date as day1, mon1, year1
		int day1 = 1;

		int mon1 = 2;

		int year1 = 2000;

		//end date as day2, mon2, year2
		int day2 = 1;

		int mon2 = 2;

		int year2 = 2004;

		int yearDif, noOfDays = 0;
		
		// integer array holds the month wise number of days for leap and non leap year
		int leapYearDays[] = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		int nonLeapYearDays[] = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		
		yearDif = year2 - year1;

		
		for (int i = 0; i < yearDif; i++) {   // loop for number of years between start & end date
			for (int j = mon2 - 1; j >= 0; j--) {    //loop to calculate number of days between start and end date year
				
				if (isleap(year2)) {
					System.out.println("1111 leap "+isleap(year2));
					System.out.println("j: "+j+" j-1:"+leapYearDays[j]);
					noOfDays = noOfDays + leapYearDays[j];
				}
					
				else {
					System.out.println("1111 nonLeap"+isleap(year2));
					System.out.println("j: "+j+" j-1:"+nonLeapYearDays[j]);
					
					noOfDays = noOfDays + nonLeapYearDays[j];
				}
			}
			// changing mon2 value to 12 for other years except end date year
			mon2 = 12;
		}
		// loop to round off the month difference between start and end date
		for (int i = mon2 - 1; i >= mon1; i--) {
			
			if (isleap(year1)) {
				System.out.println("2222 leap"+isleap(year1));
				System.out.println("i: "+i+" i-1:"+leapYearDays[i-1]);
				noOfDays = noOfDays + leapYearDays[i-1];
			}else {
				System.out.println("2222 nonLeap"+isleap(year1));
				System.out.println("i: "+i+" i-1:"+nonLeapYearDays[i-1]);
				noOfDays = noOfDays + nonLeapYearDays[i-1];
			}
				
		}
		noOfDays += (day2 - day1);
		System.out.println("number of days elapsed between two dates=" + noOfDays);
	}
}

/**
 * Links for reference
 * https://www.timeanddate.com/date/durationresult.html?d1=1&m1=2&y1=2000&d2=1&m2=2&y2=2004&ti=on
 * https://www.wwu.edu/skywise/leapyear.html
 * simple logic: https://www.geeksforgeeks.org/find-number-of-days-between-two-given-dates/
 * /
 */