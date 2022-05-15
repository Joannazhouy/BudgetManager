package model;

public class Entry {

    private String name;
    private double amount;
    private TimeStamp date;
    private Categories type;

    public Entry(String name, double price, TimeStamp date, Categories type){
        this.name = name;
        this.amount = price;
        this.date = date;
        this.type = type;

        int ok = 0;

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

    public Categories getCat(){
        return this.type;
    }

    public String entryToString(){
        return name + " " + type.toString() + " " + "$" + Double.toString(amount) + " " + date.timeStampToString() + "\r\n";
    }


}


