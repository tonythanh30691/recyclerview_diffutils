package com.codding.test.playgroundkotlin

import androidx.recyclerview.widget.DiffUtil

class UserDiffCallBack : DiffUtil.ItemCallback<UserData>() {
    override fun areItemsTheSame(oldItem: UserData, newItem: UserData): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: UserData, newItem: UserData): Boolean {
        return oldItem.firstName == newItem.firstName && oldItem.lastName == newItem.lastName
    }

}