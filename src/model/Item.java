package model;

public class Item {

    private String name;
    private int price;
    private TimeStamp date;

    public Item(String name, int price, TimeStamp date){
        this.name = name;
        this.price = price;
        this.date = date;
        int ok = 0;

    }

    private String getName(){
        return this.name;
    }

    private int getPrice(){
        return this.price;

    }

    private TimeStamp getDate(){
        return this.date;
    }

}

