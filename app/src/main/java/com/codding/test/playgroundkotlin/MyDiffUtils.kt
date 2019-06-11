package com.codding.test.playgroundkotlin

import android.os.Bundle
import androidx.recyclerview.widget.DiffUtil

class MyDiffUtils(var oldList : List<UserData>, var newList : List<UserData>) : DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        var oldItem = oldList[oldItemPosition]
        var newItem = newList[newItemPosition]

        var isSameName = oldItem.firstName == newItem.firstName
        var isSameSub = oldItem.lastName == newItem.lastName

        return isSameName && isSameSub
    }

    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        var oldItem = oldList[oldItemPosition]
        var newItem = newList[newItemPosition]

        var bundle = Bundle()
        if (oldItem.firstName != newItem.firstName) {
            bundle.putBoolean(Constant.PAY_LOAD_FIRST_NAME, true)
        }

        if (oldItem.lastName != newItem.lastName) {
            bundle.putBoolean(Constant.PAY_LOAD_LAST_NAME, true)
        }

        return bundle
    }

}