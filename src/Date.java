/**
 * This is the date class where the current date is.
 * There are methods which also help to decide whether an input date is valid or not.
 * @author Jaison Prajapati, Jacob Cobb
 */

import java.util.Calendar;
public class Date implements Comparable<Date> {
    private int year;
    private int month;
    private int day;

    /**
     * This is the date method which sets today's date.
     */
    public Date() {
        Calendar todayDate = Calendar.getInstance();
        day = todayDate.get(Calendar.DAY_OF_MONTH);
        month = todayDate.get(Calendar.MONTH) + 1;
        year = todayDate.get(Calendar.YEAR);
    } //create an object with today’s date (see Calendar class)

    /**
     * This is to make a date object.
     * @param date The user string is passed in to make the date object.
     */
    public Date(String date) {
        String[] inputDate = date.split("/");
        month = Integer.parseInt(inputDate[0]);
        day = Integer.parseInt(inputDate[1]);
        year = Integer.parseInt(inputDate[2]);

    }


    /**
     * This method checks if the date is valid.
     * @return Returns a true value if the date is valid and false if the date is invalid.
     */
    public boolean isValid() {
        if((month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) && (day < 1 || day > 31)){
            return false;
        }
        if((month == 4|| month == 6 || month == 9 || month == 11) && (day < 1 || day > 30)){
            return false;
        }
        if(month < 1 || month > 12){
            return false;
        }
        if (year < 1900)
        {
            return false;
        }
        if(leapYear() == true){
            if(month == 2 && (day < 1 || day > 29)) {
                return false;
            }
        }
        if(leapYear() == false){
            if(month == 2 && (day < 1 || day > 28)) {
                return false;
            }
        }
        return true;
    } //check if a date is a valid calendar date

    /**
     * This method checks the age of a student and makes sure they are older than 16.
     * @param student This is the passed in date of birth of a student.
     * @return Returns true if the student is 16 or older and false if the student is not 16.
     */
    public boolean age(Date student) {
        Date today = new Date();
        if(today.getYear() - student.getYear() < 16){
            return false;
        }else if(today.getYear() - student.getYear() == 16 && today.getMonth() - student.getMonth() < 0){
            return false;
        }else if(today.getYear() - student.getYear() == 16 && today.getDay() - student.getDay() < 0){
            return false;
        }else{
            return true;
        }
    }

    /**
     * This method tells you if it is a leap year.
     * @return Returns true if it is a leap year and false if it isn't a leap year.
     */
    public boolean leapYear(){
        if(year % 4 == 0){
            if(year % 100 == 0){
                if(year % 400 == 0){
                    return true;
                }else{
                    return false;
                }
            }else{
                return true;
            }
        }else{
            return false;
        }
    }

    /**
     * Getter for year
     * @return the current year
     */
    public int getYear(){
        return year;
    }

    /**
     * Getter for month
     * @return the current month
     */
    public int getMonth(){
        return month;
    }

    /**
     * Getter for day
     * @return the current day
     */
    public int getDay(){
        return day;
    }

    /**
     * Setter for year
     * @param year which is set
     */
    public void setYear(int year){
        this.year = year;
    }

    /**
     * Setter for month
     * @param month which is set
     */
    public void setMonth(int month){
        this.month = month;
    }

    /**
     * Setter for day
     * @param day which is set
     */
    public void setDay(int day){
        this.day = day;
    }

    /**]
     * This overrides the toString method for the date.
     * @return Returns a string of the date.
     */
    @Override
    public String toString(){
        return Integer.toString(month) + '/' + Integer.toString(day) + '/' + Integer.toString(year);
    }

    /**
     * This overrides the equals method for the date
     * @param date This is passed in to see if it equals the date.
     * @return Returns true if the dates are equal and false if they aren't.
     */
    @Override
    public boolean equals(Object oDate){
        if (oDate instanceof Date date){
            boolean oYear = this.year == date.year;
            boolean oMonth = this.month == date.month;
            boolean oDay = this.day == date.day;
            return oYear && oMonth && oDay;

        }
        return false;
    }

    /**
     * This overrides the compareTo method for the date.
     * @param date the object to be compared.
     * @return Returns 0 if they are the same and difference between day,month, and year  if they are not the same.
     */
    @Override
    public int compareTo(Date date){

        if (this.year != date.year) {
            return this.year - date.year;
        }
        if (this.month != date.month) {
            return this.month - date.month;
        }
        return this.day - date.day;
    }

    /**
     * Helper method for testMain to compare two boolean values
     * @param expected boolean value 1
     * @param actual boolean value 2
     */

    public static void testResult(Date date, boolean expected, boolean actual){
        if (expected == actual){
            System.out.println("\n passed");
        }
        else{
            System.out.println("\n failed");
        }
    }

    public static void main(String[] args){
        Date date = new Date("2/29/2011");
        boolean expectedOutput = false;
        boolean actualOutput = date.isValid();
        System.out.print("** Test case #1: a date in a non leap year has only 28 days in feb");
        testResult(date, expectedOutput, actualOutput);

        date = new Date("2/29/2020");
        expectedOutput = true;
        actualOutput = date.isValid();
        System.out.print("** Test case #2: a date in a leap year has only 29 days in feb");
        testResult(date, expectedOutput, actualOutput);

        date = new Date("14/21/2020");
        expectedOutput = false;
        actualOutput = date.isValid();
        System.out.print("** Test case #3: months must be less than or equal to 12");
        testResult(date, expectedOutput, actualOutput);

        date = new Date("1/1/1");
        expectedOutput = false;
        actualOutput = date.isValid();
        System.out.print("** Test case #4: year must be at least 1900");
        testResult(date, expectedOutput, actualOutput);
    }

}