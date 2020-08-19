package com.example.todaysshow.object;

public class Journal {

    private String journalStr = "";
    private int imageResource;

    public Journal(String journalStr, int imageResource){
        this.journalStr = journalStr;
        this.imageResource = imageResource;
    }

    public String getJournalStr(){return this.journalStr;}
    public int getImageResource(){return this.imageResource;}


}
