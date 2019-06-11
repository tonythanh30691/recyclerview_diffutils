package com.codding.test.playgroundkotlin

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class UserDataAdapterUsingAsyncDiff : RecyclerView.Adapter<UserDataViewHolderAsync>() {

    var userDatas = mutableListOf<UserData>()
    var ayncListDiffer = AsyncListDiffer(this, UserDiffCallBack())


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserDataViewHolderAsync {
        return UserDataViewHolderAsync(LayoutInflater.from(parent.context).inflate(R.layout.recy_item, parent, false))
    }

    override fun getItemCount(): Int {
        return ayncListDiffer.currentList.size
    }

    fun setData(newData : List<UserData>) {
        return ayncListDiffer.submitList(newData)
    }

    override fun onBindViewHolder(holder: UserDataViewHolderAsync, position: Int) {
        Log.d(Constant.LOG_STRING, "onBindViewHolder at: $position")

        var userData = ayncListDiffer.currentList.get(position)
        with(userData) {
            holder.mainTitle.text = firstName
            holder.subTitle.text = lastName
        }
    }

}

class UserDataViewHolderAsync(itemView : View) : RecyclerView.ViewHolder(itemView) {
    var mainTitle : TextView = itemView.findViewById(R.id.txtMain)
    var subTitle : TextView = itemView.findViewById(R.id.txtSub)

}