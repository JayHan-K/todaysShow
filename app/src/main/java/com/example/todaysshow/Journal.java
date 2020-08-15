package com.example.todaysshow;

public class Journal {

    private String journalStr = "";
    private int imageResource;

    Journal(String journalStr, int imageResource){
        this.journalStr = journalStr;
        this.imageResource = imageResource;
    }

    public String getJournalStr(){return this.journalStr;}
    public int getImageResource(){return this.imageResource;}


}
