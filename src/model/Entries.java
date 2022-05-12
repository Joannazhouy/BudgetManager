package model;

import java.util.ArrayList;
import java.util.List;

public class Entries {

    private List<Entry> data;

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








}
