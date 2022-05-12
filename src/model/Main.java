package model;

public class Main {
    public static void main(String[] args) {
        Entries entries = new Entries();
        entries.addEntry(new Entry("cookie", 20, new TimeStamp(10, 03,2022), Categories.FOOD));
        entries.addEntry(new Entry("candles", 40, new TimeStamp(01,04,2022),Categories.PERSONAL));
        System.out.println(entries.entriesToString());
    }
}
