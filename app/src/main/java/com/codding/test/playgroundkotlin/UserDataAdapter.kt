package com.codding.test.playgroundkotlin

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

class UserDataAdapter : RecyclerView.Adapter<UserDataViewHolder>() {

    var userDatas = mutableListOf<UserData>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserDataViewHolder {
        return UserDataViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recy_item, parent, false))
    }

    override fun getItemCount(): Int {
        return userDatas.size
    }

    fun setData(newData : List<UserData>) {
        if (userDatas.size == 0) {
            userDatas.addAll(newData)
            notifyItemRangeInserted(0, newData.size)
        } else {

            var diffCallBack = MyDiffUtils(userDatas, newData)
            var diffResult = DiffUtil.calculateDiff(diffCallBack)
            diffResult.dispatchUpdatesTo(this)

            userDatas.clear()
            userDatas.addAll(newData)

        }
    }

    override fun onBindViewHolder(holder: UserDataViewHolder, position: Int) {
        Log.d(Constant.LOG_STRING, "onBindViewHolder at: $position")

        var userData = userDatas[position]
        holder.mainTitle.text = userData.firstName
        holder.subTitle.text = userData.lastName
    }

    override fun onBindViewHolder(holder: UserDataViewHolder, position: Int, payloads: MutableList<Any>) {
        Log.d(Constant.LOG_STRING, "onBindViewHolder payloads at: $position")
        if (payloads.isEmpty()) {
            super.onBindViewHolder(holder, position, payloads)
            return
        }

        var bundle = payloads[0] as Bundle
        var currentData = userDatas[position]

        if (bundle.getBoolean(Constant.PAY_LOAD_FIRST_NAME)) {
            Log.d(Constant.LOG_STRING, "PAY_LOAD_FIRST_NAME: ${currentData.firstName}")
            holder.mainTitle.text = currentData.firstName
        }

        if (bundle.getBoolean(Constant.PAY_LOAD_LAST_NAME)) {
            Log.d(Constant.LOG_STRING, "PAY_LOAD_LAST_NAME: ${currentData.lastName}")
            holder.subTitle.text = currentData.lastName
        }
    }

}


class UserDataViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
    var mainTitle : TextView = itemView.findViewById(R.id.txtMain)
    var subTitle : TextView = itemView.findViewById(R.id.txtSub)

}