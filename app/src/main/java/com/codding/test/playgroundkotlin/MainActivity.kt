package com.codding.test.playgroundkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView : RecyclerView
    private lateinit var adapter : UserDataAdapter
    private lateinit var adapterAsync : UserDataAdapterUsingAsyncDiff
    private lateinit var adapterList: UserDataListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        adapter = UserDataAdapter()
        recyclerView.adapter = adapter
        adapter.setData(getFirstDummyData())

//        adapterAsync = UserDataAdapterUsingAsyncDiff()
//        recyclerView.adapter = adapterAsync
//        adapterAsync.setData(getFirstDummyData())

//        adapterList = UserDataListAdapter(UserDiffCallBack())
//        recyclerView.adapter = adapterList
//        adapterList.submitList(getFirstDummyData())
    }

    fun replaceAllData(view : View) {
         adapter.setData(getSecondDummyData())
        //adapterAsync.setData(getSecondDummyData())
       // adapterList.submitList(getSecondDummyData())
    }

    fun getFirstDummyData() : List<UserData> {
        var list = mutableListOf<UserData>()
        list.add(UserData("1", "Test", "Test1"))
        list.add(UserData("2", "Test", "Test1"))
        list.add(UserData("3", "Test", "Test1"))
        list.add(UserData("4", "Test", "Test1"))
        list.add(UserData("5", "Test", "Test1"))
        list.add(UserData("6", "Test", "Test2"))
        list.add(UserData("7", "Test", "Test1"))
        list.add(UserData("8", "Test", "Test1"))
        list.add(UserData("9", "Test", "Test1"))
        list.add(UserData("10", "Test", "Test1"))
        list.add(UserData("11", "Test", "Test1"))
        list.add(UserData("12", "Test", "Test1"))
        list.add(UserData("13", "Test", "Test1"))
        list.add(UserData("14", "Test", "Test1"))
        list.add(UserData("15", "Test", "Test1"))
        list.add(UserData("16", "Test1", "Test3"))
        list.add(UserData("17", "Test1", "Test1"))
        list.add(UserData("18", "Test", "Test1"))
        list.add(UserData("19", "Test", "Test1"))
        list.add(UserData("20", "Test", "Test1"))
        list.add(UserData("21", "Test", "Test1"))
        list.add(UserData("22", "Test", "Test1"))
        list.add(UserData("23", "Test", "Test1"))
        list.add(UserData("24", "Test", "Test1"))
        list.add(UserData("25", "Test", "Test1"))
        return list
    }

    fun getSecondDummyData() : List<UserData> {
        var list = mutableListOf<UserData>()
        list.add(UserData("1", "Test", "Test1"))
        list.add(UserData("2", "Test", "Test1"))
        list.add(UserData("3", "Test", "Test2"))
        list.add(UserData("4", "Test", "Test1"))
        list.add(UserData("5", "Test", "Test1"))
        list.add(UserData("6", "Test1", "Test2"))
        list.add(UserData("7", "Test", "Test1"))
        list.add(UserData("8", "Test", "Test1"))
        list.add(UserData("9", "Test1", "Test5"))
        list.add(UserData("10", "Test", "Test1"))
        list.add(UserData("11", "Test", "Test1"))
        list.add(UserData("12", "Test", "Test1"))
        list.add(UserData("13", "Test", "Test1"))
        list.add(UserData("14", "Test", "Test1"))
        list.add(UserData("15", "Test5", "Test7"))
        list.add(UserData("16", "Test1", "Test3"))
        list.add(UserData("17", "Test1", "Test1"))
        list.add(UserData("18", "Test", "Test1"))
        list.add(UserData("19", "Test", "Test1"))
        list.add(UserData("20", "Test", "Test1"))
        list.add(UserData("21", "Test", "Test1"))
        list.add(UserData("22", "Test", "Test1"))
        list.add(UserData("23", "Test", "Test1"))
        list.add(UserData("24", "Test", "Test1"))
        list.add(UserData("25", "Test", "Test1"))
        return list
    }
}
