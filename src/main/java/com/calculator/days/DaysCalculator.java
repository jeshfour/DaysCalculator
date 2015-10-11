package com.calculator.days;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static java.util.TimeZone.getTimeZone;

public class DaysCalculator {
    private static final int DAY_IN_MILLIS = 1000 * 24 * 60 * 60;
    private String startDateStr;
    private String endDateStr;

    public DaysCalculator(final String startDateStr, final String endDateStr) {
        this.startDateStr = startDateStr;
        this.endDateStr = endDateStr;
    }

    public long getDays() throws ParseException {
        if (startDateStr == null || endDateStr == null) {
            throw new IllegalArgumentException("Input is not valid: " + startDateStr + ", " + endDateStr);
        }
        final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        simpleDateFormat.setTimeZone(getTimeZone("UTC"));// its important to calculate days between dates fall in dst and non dst times
        final Date startDate = simpleDateFormat.parse(this.startDateStr);
        final Date endDate = simpleDateFormat.parse(this.endDateStr);
        if (startDate.equals(endDate)) {
            return 0;
        }
        if (startDate.compareTo(endDate) < 0) {
            return (endDate.getTime() - startDate.getTime() - DAY_IN_MILLIS) / DAY_IN_MILLIS;
        }
        return (startDate.getTime() - endDate.getTime() - DAY_IN_MILLIS) / DAY_IN_MILLIS;
    }
}
