package com.calculator.days;

import org.junit.Test;

import java.text.ParseException;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class DaysCalculatorTest {

    @Test
    public void shouldCalculateDaysBetweenStartAndEndDates() throws Exception {

        //CASE 1
        String startDate = "01/01/1983";
        String endDate = "02/01/1983";
        DaysCalculator daysCalculator = new DaysCalculator(startDate, endDate);
        assertThat(daysCalculator.getDays(), is(0l));

        //CASE 2
        startDate = "02/06/1983";
        endDate = "22/06/1983";
        daysCalculator = new DaysCalculator(startDate, endDate);
        assertThat(daysCalculator.getDays(), is(19l));

        //CASE 3
        startDate = "30/10/2015";
        endDate = "01/11/2015";
        daysCalculator = new DaysCalculator(startDate, endDate);
        assertThat(daysCalculator.getDays(), is(1l));

        //CASE 4
        startDate = "27/02/2015";
        endDate = "01/03/2015";
        daysCalculator = new DaysCalculator(startDate, endDate);
        assertThat(daysCalculator.getDays(), is(1l));

        //CASE 5
        startDate = "09/03/2015";
        endDate = "09/03/2015";
        daysCalculator = new DaysCalculator(startDate, endDate);
        assertThat(daysCalculator.getDays(), is(0l));

        //CASE 6
        startDate = "04/07/1984";
        endDate = "25/12/1984";
        daysCalculator = new DaysCalculator(startDate, endDate);
        assertThat(daysCalculator.getDays(), is(173l));

        //CASE 7
        startDate = "03/01/1989";
        endDate = "03/08/1983";
        daysCalculator = new DaysCalculator(startDate, endDate);
        assertThat(daysCalculator.getDays(), is(1979l));

        //CASE 8
        startDate = "01/01/1901";
        endDate = "31/12/1999";
        daysCalculator = new DaysCalculator(startDate, endDate);
        assertThat(daysCalculator.getDays(), is(36157L));

        //CASE 9
        startDate = "01/01/1901";
        endDate = "31/12/2999";
        daysCalculator = new DaysCalculator(startDate, endDate);
        assertThat(daysCalculator.getDays(), is(401400L));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionIfStartDateIsNull() throws Exception {
        final String endDate = "02/01/1983";
        for (final String startDate : asList(null, "", " ")) {
            final DaysCalculator daysCalculator = new DaysCalculator(startDate, endDate);
            daysCalculator.getDays();
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionIfEndDateIsNull() throws Exception {
        final String startDate = "02/01/1983";
        for (final String endDate : asList(null, "", " ")) {
            final DaysCalculator daysCalculator = new DaysCalculator(startDate, endDate);
            daysCalculator.getDays();
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentExceptionIfBothDatesAreNull() throws Exception {
        for (final String startDate : asList(null, "", " ")) {
            for (final String endDate : asList(null, "", " ")) {
                final DaysCalculator daysCalculator = new DaysCalculator(startDate, endDate);
                daysCalculator.getDays();
            }
        }
    }

    @Test(expected = ParseException.class)
    public void shouldThrowParseExceptionIfStartDateIsInvalid() throws Exception {
        final String endDate = "02/03/1983";
        for (final String startDate : asList("02//1983", "234234234", "sdfer34324234/34234/dsad")) {
            final DaysCalculator daysCalculator = new DaysCalculator(startDate, endDate);
            daysCalculator.getDays();
        }
    }

    @Test(expected = ParseException.class)
    public void shouldThrowParseExceptionIfEndDateIsInvalid() throws Exception {
        final String startDate = "02/03/1983";
        for (final String endDate : asList("02//1983", "234234234", "sdfer34324234/34234/dsad")) {
            final DaysCalculator daysCalculator = new DaysCalculator(startDate, endDate);
            daysCalculator.getDays();
        }
    }

    @Test(expected = ParseException.class)
    public void shouldThrowParseExceptionIfBothDatesAreInvalid() throws Exception {
        for (final String startDate : asList("02//1983", "234234234", "sdfer34324234/34234/dsad")) {
            for (final String endDate : asList("02//1983", "234234234", "sdfer34324234/34234/dsad")) {
                final DaysCalculator daysCalculator = new DaysCalculator(startDate, endDate);
                daysCalculator.getDays();
            }
        }
    }
}