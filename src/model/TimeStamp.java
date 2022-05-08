package model;

public class TimeStamp {
    private int day;
    private int year;
    private int month;

    public TimeStamp(int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay(){
        return this.day;
    }

    public int getMonth(){
        return this.month;

    }

    public int getYear(){
        return this.year;
    }

}
