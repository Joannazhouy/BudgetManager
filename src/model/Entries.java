package model;

import java.util.ArrayList;
import java.util.List;

public class Entries {

    private List<Entry> data;
    private int budget;

    public Entries(){
        data = new ArrayList<Entry>();
    }

    public Entry getEntry(int index){
        return data.get(index);
    }

    public int getSize(){
        return this.getSize();
    }

    public void addEntry(Entry newEntry){
        data.add(newEntry);
    }

    public String entriesToString(){
        StringBuilder sb = new StringBuilder();
        int i = 1;
        for (Entry temp : data){
            sb.append(i + "." + temp.entryToString());
            i++;
        }
        return sb.toString();

    }

    public void setBudget(int budget){
        this.budget = budget;
    }

    public int calcTotalByCat(Categories type){
        int total = 0;
        for (Entry temp : data){
            if (temp.getCat() == type) {
                total += temp.getAmount();
            }
        }
        return total;
    }

    public int calcTotal(){
        int total = 0;
        for (Entry entry : data){
            total += entry.getAmount();
        }
        return total;
    }


}
