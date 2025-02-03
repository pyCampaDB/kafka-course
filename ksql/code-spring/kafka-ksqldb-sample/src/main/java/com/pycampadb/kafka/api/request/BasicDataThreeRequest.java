package com.pycampadb.kafka.api.request;

public class BasicDataThreeRequest {
    private static final String MONTH = ", month=";
    private static final String DATE = ", date=";
    private Date myDate;
    private Time myTime;
    private DateTime myDateTime;
    private DateTimeWithTimezone myDateTimeWithTimezone;

    public Date getMyDate() {
        return myDate;
    }

    public void setMyDate(Date myDate) {
        this.myDate = myDate;
    }

    public Time getMyTime() {
        return myTime;
    }

    public void setMyTime(Time myTime) {
        this.myTime = myTime;
    }

    public DateTime getMyDateTime() {
        return myDateTime;
    }

    public void setMyDateTime(DateTime myDateTime) {
        this.myDateTime = myDateTime;
    }

    public DateTimeWithTimezone getMyDateTimeWithTimezone() {
        return myDateTimeWithTimezone;
    }

    public void setMyDateTimeWithTimezone(DateTimeWithTimezone myDateTimeWithTimezone) {
        this.myDateTimeWithTimezone = myDateTimeWithTimezone;
    }

    @Override
    public String toString() {
        return "BasicDataThreeRequest{" +
                "myDate=" + myDate +
                ", myTime=" + myTime +
                ", myDateTime=" + myDateTime +
                ", myDateTimeWithTimezone=" + myDateTimeWithTimezone +
                '}';
    }

    public static class Date {
        private int year;
        private int month;
        private int date;

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public int getMonth() {
            return month;
        }

        public void setMonth(int month) {
            this.month = month;
        }

        public int getDate() {
            return date;
        }

        public void setDate(int date) {
            this.date = date;
        }

        @Override
        public String toString() {
            return "Date{" +
                    "year=" + year +
                    MONTH + month +
                    DATE + date +
                    '}';
        }
    }

    public static class DateTime {
        private int year;
        private int month;
        private int date;
        private int hour;
        private int minute;
        private int second;

        public int getYear() {
            return year;
        }

        public void setYear(int year) {
            this.year = year;
        }

        public int getMonth() {
            return month;
        }

        public void setMonth(int month) {
            this.month = month;
        }

        public int getDate() {
            return date;
        }

        public void setDate(int date) {
            this.date = date;
        }

        public int getHour() {
            return hour;
        }

        public void setHour(int hour) {
            this.hour = hour;
        }

        public int getMinute() {
            return minute;
        }

        public void setMinute(int minute) {
            this.minute = minute;
        }

        public int getSecond() {
            return second;
        }

        public void setSecond(int second) {
            this.second = second;
        }

        @Override
        public String toString() {
            return "DateTime{" +
                    "year=" + year +
                    MONTH + month +
                    DATE + date +
                    ", hour=" + hour +
                    ", minute=" + minute +
                    ", second=" + second +
                    '}';
        }
    }

    public static class Time {
        private int hour;
        private int minute;
        private int second;

        public int getHour() {
            return hour;
        }

        public void setHour(int hour) {
            this.hour = hour;
        }

        public int getMinute() {
            return minute;
        }

        public void setMinute(int minute) {
            this.minute = minute;
        }

        public int getSecond() {
            return second;
        }

        public void setSecond(int second) {
            this.second = second;
        }

        @Override
        public String toString() {
            return "Time{" +
                    "hour=" + hour +
                    ", minute=" + minute +
                    ", second=" + second +
                    '}';
        }
    }

    public static class DateTimeWithTimezone extends DateTime {
        private String timezone;

        public String getTimezone() {
            return timezone;
        }

        public void setTimezone(String timezone) {
            this.timezone = timezone;
        }

        @Override
        public String toString() {
            return "DateTimeWithTimezone{" +
                    "timeZone='" + timezone + '\'' +
                    ", year=" + getYear() +
                    ", month=" + getMonth() +
                    ", date=" + getDate() +
                    ", hour=" + getHour() +
                    ", minute=" + getMinute() +
                    ", second=" + getSecond() +
                    '}';
        }
    }

}
