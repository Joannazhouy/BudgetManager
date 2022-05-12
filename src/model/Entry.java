package model;

public class Entry {

    private String name;
    private int amount;
    private TimeStamp date;
    private Categories type;

    public Entry(String name, int price, TimeStamp date, Categories type){
        this.name = name;
        this.amount = price;
        this.date = date;
        this.type = type;

        int ok = 0;

    }

    public String getName(){
        return this.name;
    }

    public int getAmount(){
        return this.amount;

    }

    public TimeStamp getDate(){
        return this.date;
    }

    public Categories getCat(){
        return this.type;
    }

    public String entryToString(){
        return name + " " + "$" + Integer.toString(amount) + " " + date.timeStampToString() + "\r\n";
    }


}


