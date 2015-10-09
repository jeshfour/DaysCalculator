package com.calculator.days;

import java.text.ParseException;
import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

public class Application {

    public static void main(final String[] args) {

        final Scanner scanner = new Scanner(in);

        out.println("Please enter the start date: (dd/MM/yyyy) ");
        final String startDateStr = scanner.next();

        out.println("Please enter the end date: (dd/MM/yyyy) ");
        final String endDateStr = scanner.next();
        try {
            final DaysCalculator calculator = new DaysCalculator(startDateStr, endDateStr);
            out.println(startDateStr + " - " + endDateStr + ": " + calculator.getDays() + " days");
        } catch (final ParseException e) {
            System.err.println("Please enter dates in the format dd/MM/yyyy (01/01/2015)");
        }
    }

}
