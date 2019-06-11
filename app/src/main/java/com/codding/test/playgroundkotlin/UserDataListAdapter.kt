package com.codding.test.playgroundkotlin

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserDataListAdapter(userDiffCallBack: UserDiffCallBack) :
    androidx.recyclerview.widget.ListAdapter<UserData, UserDataViewHolderListAdapter>(userDiffCallBack) {

    var userDatas = mutableListOf<UserData>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserDataViewHolderListAdapter {
        return UserDataViewHolderListAdapter(LayoutInflater.from(parent.context).inflate(R.layout.recy_item, parent, false))
    }

    override fun onBindViewHolder(holder: UserDataViewHolderListAdapter, position: Int) {
        Log.d(Constant.LOG_STRING, "onBindViewHolder at: $position")
        var userData = getItem(position)
        with(userData) {
            holder.mainTitle.text = firstName
            holder.subTitle.text = lastName
        }
    }

}

class UserDataViewHolderListAdapter(itemView : View) : RecyclerView.ViewHolder(itemView) {
    var mainTitle : TextView = itemView.findViewById(R.id.txtMain)
    var subTitle : TextView = itemView.findViewById(R.id.txtSub)

}