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

        popularSearchList.add("오페라의 유령")
        popularSearchList.add("캣츠")
        popularSearchList.add("오백에 삼십")
        popularSearchList.add("쉬어 매드니스")
        popularSearchList.add("브로드웨이 42번가")
        popularSearchList.add("렌트")

        defaultSearchList.add("돈 조반니")
        defaultSearchList.add("라스트 세션")
        defaultSearchList.add("라인의 황금")
        defaultSearchList.add("레미제라블")
        defaultSearchList.add("렌트")
        defaultSearchList.add("마리퀴리")
        defaultSearchList.add("마우스피스")
        defaultSearchList.add("브로드웨이 42번가")
        defaultSearchList.add("쉬어매드니스")
        defaultSearchList.add("썸씽로튼")
        defaultSearchList.add("오페라의 유령")
        defaultSearchList.add("제이미")
        defaultSearchList.add("캣츠")
        defaultSearchList.add("킹키부츠")
        defaultSearchList.add("파우스트")
        defaultSearchList.add("라흐마니노프")
        defaultSearchList.add("행오버")


    }

}