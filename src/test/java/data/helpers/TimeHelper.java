package data.helpers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static data.helpers.SQLHelper.*;

public class TimeHelper {
    public static Date getDbTimeInDateFormatPaymentEntity() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dbTime = getPaymentEntity().getCreated();
        Date dbTimeInDateFormat = formatter.parse(dbTime);

        return dbTimeInDateFormat;
    }

    public static long getDurationOfTimeForPaymentEntity() throws ParseException {
        Date timeNow = new Date();
        long duration;
        long dbTimeInLongFormat = getDbTimeInDateFormatPaymentEntity().getTime();
        long timeNowInLongFormat = timeNow.getTime();

        if (timeNowInLongFormat >= dbTimeInLongFormat) {
            duration = timeNowInLongFormat - dbTimeInLongFormat;
        } else {
            duration = dbTimeInLongFormat - timeNowInLongFormat;
        }

        return duration;
    }

    public static Date getDbTimeInDateFormatCreditEntity() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dbTime = getCreditEntity().getCreated();
        Date dbTimeInDateFormat = formatter.parse(dbTime);

        return dbTimeInDateFormat;
    }

    public static long getDurationOfTimeForCreditEntity() throws ParseException {
        Date timeNow = new Date();
        long duration;
        long dbTimeInLongFormat = getDbTimeInDateFormatCreditEntity().getTime();
        long timeNowInLongFormat = timeNow.getTime();

        if (timeNowInLongFormat >= dbTimeInLongFormat) {
            duration = timeNowInLongFormat - dbTimeInLongFormat;
        } else {
            duration = dbTimeInLongFormat - timeNowInLongFormat;
        }

        return duration;
    }

    public static Date getDbTimeInDateFormatOrderEntity() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dbTime = getOrderEntity().getCreated();
        Date dbTimeInDateFormat = formatter.parse(dbTime);

        return dbTimeInDateFormat;
    }

    public static long getDurationOfTimeForOrderEntity() throws ParseException {
        Date timeNow = new Date();
        long duration;
        long dbTimeInLongFormat = getDbTimeInDateFormatOrderEntity().getTime();
        long timeNowInLongFormat = timeNow.getTime();

        if (timeNowInLongFormat >= dbTimeInLongFormat) {
            duration = timeNowInLongFormat - dbTimeInLongFormat;
        } else {
            duration = dbTimeInLongFormat - timeNowInLongFormat;
        }

        return duration;
    }

    public static long getTimeDurationBetweenOrderAndPayment() throws ParseException {
        long duration;
        long dbTimeOrder = getDbTimeInDateFormatOrderEntity().getTime();
        long dbTimePayment = getDbTimeInDateFormatPaymentEntity().getTime();

        if (dbTimeOrder >= dbTimePayment) {
            duration = dbTimeOrder - dbTimePayment;
        } else {
            duration = dbTimePayment - dbTimeOrder;
        }

        return duration;

    }

    public static long getTimeDurationBetweenOrderAndCredit() throws ParseException {
        long duration;
        long dbTimeOrder = getDbTimeInDateFormatOrderEntity().getTime();
        long dbTimeCredit = getDbTimeInDateFormatCreditEntity().getTime();

        if (dbTimeOrder >= dbTimeCredit) {
            duration = dbTimeOrder - dbTimeCredit;
        } else {
            duration = dbTimeCredit - dbTimeOrder;
        }

        return duration;

    }


    public static Date getDbTimeInDateFormatPaymentEntityMySQL() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dbTime = getPaymentEntityMySQL().getCreated();
        Date dbTimeInDateFormat = formatter.parse(dbTime);

        return dbTimeInDateFormat;
    }

    public static long getDurationOfTimeForPaymentEntityMySQL() throws ParseException {
        Date timeNow = new Date();
        long duration;
        long dbTimeInLongFormat = getDbTimeInDateFormatPaymentEntityMySQL().getTime();
        long timeNowInLongFormat = timeNow.getTime();

        if (timeNowInLongFormat >= dbTimeInLongFormat) {
            duration = timeNowInLongFormat - dbTimeInLongFormat;
        } else {
            duration = dbTimeInLongFormat - timeNowInLongFormat;
        }

        return duration;
    }

    public static Date getDbTimeInDateFormatCreditEntityMySQL() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dbTime = getCreditEntityMySQL().getCreated();
        Date dbTimeInDateFormat = formatter.parse(dbTime);

        return dbTimeInDateFormat;
    }

    public static long getDurationOfTimeForCreditEntityMySQL() throws ParseException {
        Date timeNow = new Date();
        long duration;
        long dbTimeInLongFormat = getDbTimeInDateFormatCreditEntityMySQL().getTime();
        long timeNowInLongFormat = timeNow.getTime();

        if (timeNowInLongFormat >= dbTimeInLongFormat) {
            duration = timeNowInLongFormat - dbTimeInLongFormat;
        } else {
            duration = dbTimeInLongFormat - timeNowInLongFormat;
        }

        return duration;
    }

    public static Date getDbTimeInDateFormatOrderEntityMySQL() throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dbTime = getOrderEntityMySQL().getCreated();
        Date dbTimeInDateFormat = formatter.parse(dbTime);

        return dbTimeInDateFormat;
    }

    public static long getDurationOfTimeForOrderEntityMySQL() throws ParseException {
        Date timeNow = new Date();
        long duration;
        long dbTimeInLongFormat = getDbTimeInDateFormatOrderEntityMySQL().getTime();
        long timeNowInLongFormat = timeNow.getTime();

        if (timeNowInLongFormat >= dbTimeInLongFormat) {
            duration = timeNowInLongFormat - dbTimeInLongFormat;
        } else {
            duration = dbTimeInLongFormat - timeNowInLongFormat;
        }

        return duration;
    }

    public static long getTimeDurationBetweenOrderAndPaymentMySQL() throws ParseException {
        long duration;
        long dbTimeOrder = getDbTimeInDateFormatOrderEntityMySQL().getTime();
        long dbTimePayment = getDbTimeInDateFormatPaymentEntityMySQL().getTime();

        if (dbTimeOrder >= dbTimePayment) {
            duration = dbTimeOrder - dbTimePayment;
        } else {
            duration = dbTimePayment - dbTimeOrder;
        }

        return duration;

    }

    public static long getTimeDurationBetweenOrderAndCreditMySQL() throws ParseException {
        long duration;
        long dbTimeOrder = getDbTimeInDateFormatOrderEntityMySQL().getTime();
        long dbTimeCredit = getDbTimeInDateFormatCreditEntityMySQL().getTime();

        if (dbTimeOrder >= dbTimeCredit) {
            duration = dbTimeOrder - dbTimeCredit;
        } else {
            duration = dbTimeCredit - dbTimeOrder;
        }

        return duration;

    }
}
