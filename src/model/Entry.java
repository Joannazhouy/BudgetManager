package model;

public class Entry {

    private String name;
    private double amount;
    private TimeStamp date;

    public Entry(String name, double price, TimeStamp date){
        this.name = name;
        this.amount = price;
        this.date = date;


    }

    public String getName(){
        return this.name;
    }

    public double getAmount(){
        return this.amount;

    }

    public TimeStamp getDate(){
        return this.date;
    }


    public String entryToString(){
        return name + " " + " " + "$" + Double.toString(amount) + " " + date.timeStampToString() + "\r\n";
    }


}


