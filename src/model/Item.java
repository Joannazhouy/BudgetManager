package model;

public class Item {

    private String name;
    private int price;
    private TimeStamp date;

    public Item(String name, int price, TimeStamp date){
        this.name = name;
        this.price = price;
        this.date = date;

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

