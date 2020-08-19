package com.example.todaysshow.`object`

class HomeShow(imageSource: Int, showName: String) {
    private var imageSource : Int = imageSource
    private var showName : String = showName

    fun getImageResource() : Int{
        return this.imageSource
    }

    fun getShowName(): String{
        return this.showName
    }

}