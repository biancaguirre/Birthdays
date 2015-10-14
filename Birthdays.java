/*
Name: Bianca Aguirre
Date created: 3/31/15
HW#: 2
Program Description: Program that asks the user for two birthdays and the current date and 
reports which birthday is sooner.
*/


import java.time.DayOfWeek;
import java.util.*;
import javax.swing.JOptionPane;

public class Birthdays {

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        getInfo(console);
    }

    public static void getInfo(Scanner console) {
        //get today's date as a string
        //seperate each token,
        //figure out the integer value for the month and day and year and store them in the following varable
        //
        //Integer.parseInt() takes the String and changes it into an int
        int month = 0;
        int day = 0;
        int year = 0;

        System.out.println("What is your name?");
        String name = console.next();
        System.out.println("Hi " + name + " enter today's date in the format month/day/year:");
        String dayOfYear = console.next();

        int slash = dayOfYear.indexOf("/");
        String mo = dayOfYear.substring(0, slash);
        int slash2 = dayOfYear.substring(slash + 1).indexOf("/") + (slash + 1);
        String d = dayOfYear.substring(slash + 1, slash2);
        String yr = dayOfYear.substring(slash2 + 1);
        month = Integer.parseInt(mo);
        day = Integer.parseInt(d);
        year = Integer.parseInt(yr);

        intro(month, day, year);
        int today = dayOfYear(month, day);

        System.out.println("How many times do you want to use this app:");
        int count = console.nextInt();
        console.nextLine();

        for (int i = 0; i < count; i++) {
            //get the name of the person and store it in the name1
            System.out.println("Enter the name of your first sibling:");
            String name1 = console.next();

            int days1 = processPerson(console, today, 1, year, name1);
            //get the name of the second person and store it in the name2
            System.out.println("Enter the name of your second sibling:");
            String name2 = console.next();


            int days2 = processPerson(console, today, 2, year, name2);
            results(days1, days2, name1, name2);

        }
        System.out.println("Have a good day");
    }

	/*This method prints the description of the
    program and also prints the information about the todays date*/

    public static void intro(int month, int day, int year) {
        //output the program description
        Scanner console = new Scanner(System.in);
        int today = dayOfYear(month, day);
        String m = monthName(month);

        System.out.println("This program compares two birthdays and displays which one is sooner.");
        System.out.println("Today is " + m + "/" + day + "/" + year + ", day #" + today + " of the year. ");
        //output the information about todays date
        //return today;
    }

    //
    public static int processPerson(Scanner console, int today, int num, int year, String name) {

        //ask the user the date of birth in the format m/d as a string
        //seperate the tokens to day and month
        //convert each token to its integer value and store them in month and day variables
        int month = 0;
        int day = 0;

        System.out.print("What month and day was " + name + " born, m/day?");
        String bday = console.next();

        int slash3 = bday.indexOf("/");
        String mon = bday.substring(0, slash3);
        String dy = bday.substring(slash3 + 1);
        month = Integer.parseInt(mon);
        day = Integer.parseInt(dy);


        int birthday = dayOfYear(month, day);
        String m = monthName(month);
        //output the inforamtion about the person's birthday
        System.out.println(m + "/" + day + "/2015 falls on day #" + birthday + " of 365.");

        int days = daysTillBday(birthday, today);
        if (days == 0) {
            System.out.println("Oh my god it is your birthday, Happy birthday!!!!!!!!");
        } else {
            System.out.println(name + " birthday is in " + days + " day(s).");
            double percentage = 100.0 * days / 366;
            System.out.printf("That is %.1f percent of a year away.\n", percentage);
        }
        System.out.println();
        return days;
    }

    //calculate the number of days from the begining of the year to the given month and day
    //dayOfYear accepts the month and day as int and uses a switch case and cumulative sum to determine which day of the year the date is
    public static int dayOfYear(int month, int day) {
        int dayOfYear = 0;
        for(int i = 1; i < month; i++) {
            dayOfYear += daysInMonth(i);
        }

           /* switch (i) {
                case 1:
                    dayOfYear += 31;
                    break;
                case 2:
                    dayOfYear += 28;
                    break;
                case 3:
                    dayOfYear += 31;
                    break;
                case 4:
                    dayOfYear += 30;
                    break;
                case 5:
                    dayOfYear += 31;
                    break;
                case 6:
                    dayOfYear += 30;
                    break;
                case 7:
                    dayOfYear += 31;
                    break;
                case 8:
                    dayOfYear += 31;
                    break;
                case 9:
                    dayOfYear += 30;
                    break;
                case 10:
                    dayOfYear += 31;
                    break;
                case 11:
                    dayOfYear += 30;
                    break;
                case 12:
                    dayOfYear += 31;
                    break;
                default:
                    System.out.println("Invalid month");
                    break;*/

            //}
        //}
        dayOfYear += day;

        return dayOfYear;
    }

    //returns the number of days in the given month
    //daysInMonth accepts the month as and int and return how many days are in the month
    public static int daysInMonth(int month) {
        int days = 0;
        if(month == 2) {
            days = 28;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            days = 30;
        } else {
            days = 31;
        }

        return days;
    }

    //calculates the number of days until the next birthday.
    public static int daysTillBday(int birthday, int today) {
        int days = 0;
        if(birthday < today) {
            days = (365 + birthday) - today;
        } else if (birthday > today) {
            days = birthday - today;
        }

        return days;

    }

    //output the result by comparing days1 and days2, you need to use JOptionPane dialog boxes
    public static void results(int days1, int days2, String name1, String name2) {
        Scanner kb = new Scanner(System.in);
        name1 = (name1.charAt(0) + "").toUpperCase() + name1.substring(1);
        name2 = (name2.charAt(0) + "").toUpperCase() + name2.substring(1);
        if (days1 < days2) {
            //your code
        } else if (days1 > days2) {
            //your code
        } else {
            //your code
        }

        JOptionPane.showMessageDialog(null, name2 + "Birthday is sooner");
        String pNum = JOptionPane.showInputDialog(null, "Please enter " + name2 + " phone number.");
        JOptionPane.showMessageDialog(null, " a text message will be send to " + name2 + "in" + days2 + " days.");
    }

    //this method returns the name of the month assosiated with the number of the month.
    //Must use switch for this problem.
    //switch case takes the int month and assigns it to a string naming the month
    public static String monthName(int month) {
        String name = "";
        switch (month) {
            case 1:
                name = "January";
                break;
            case 2:
                name = "February";
                break;
            case 3:
                name = "March";
                break;
            case 4:
                name = "April";
                break;
            case 5:
                name = "May";
                break;
            case 6:
                name = "June";
                break;
            case 7:
                name = "July";
                break;
            case 8:
                name = "August";
                break;
            case 9:
                name = "September";
                break;
            case 10:
                name = "October";
                break;
            case 11:
                name = "November";
                break;
            case 12:
                name = "December";
                break;
            default:
                name = "unknown";
                break;

        }
        return name;

    }

}