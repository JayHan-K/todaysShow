package com.example.todaysshow

import android.app.Application

class TodayShowApplication : Application() {

    companion object {
        lateinit var instance : TodayShowApplication
        private set
    }

    public var popularSearchList : ArrayList<String> = arrayListOf()
    public var defaultSearchList : ArrayList<String> = arrayListOf()

    override fun onCreate() {
        super.onCreate()

        instance = this

        popularSearchList.add("The Phantom of the Opera")
        popularSearchList.add("CATS")
        popularSearchList.add("오백에 삼십")
        popularSearchList.add("쉬어 매드니스")
        popularSearchList.add("42nd Street")
        popularSearchList.add("RENT")

        defaultSearchList.add("show1")
        defaultSearchList.add("show2")
        defaultSearchList.add("show3")
        defaultSearchList.add("show4")
        defaultSearchList.add("show5")
        defaultSearchList.add("show6")
        defaultSearchList.add("show7")
        defaultSearchList.add("show8")


    }

}