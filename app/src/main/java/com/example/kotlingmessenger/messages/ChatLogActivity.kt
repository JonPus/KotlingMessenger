package com.example.kotlingmessenger.messages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlingmessenger.R
import com.example.kotlingmessenger.models.User
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item
import kotlinx.android.synthetic.main.activity_chat_log.*
import kotlinx.android.synthetic.main.chat_from_row.view.*
import kotlinx.android.synthetic.main.chat_to_row.view.*

class ChatLogActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_log)

        //supportActionBar?.title = "Chat Log"

        //val username = intent.getStringExtra(NewMessageActivity.USER_KEY)

        val user = intent.getParcelableExtra<User>(NewMessageActivity.USER_KEY)

        val adapter = GroupAdapter<GroupieViewHolder>()
        supportActionBar?.title = user.username

        setupDummyData()
    }

    private fun setupDummyData() {

        val adapter=  GroupAdapter<GroupieViewHolder>()

        adapter.add(ChatFromItem("From  Message"))
        adapter.add(ChatToItem("To Message"))

        recyclerview_chat_log.adapter = adapter
    }
}

class ChatFromItem(val text: String): Item<GroupieViewHolder>(){
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.textview_from_row.text =text

    }

    override fun getLayout(): Int {
        return R.layout.chat_from_row
    }
}

class ChatToItem(val text: String): Item<GroupieViewHolder>(){
    override fun bind(viewHolder: GroupieViewHolder, position: Int) {
        viewHolder.itemView.textView_to_row.text = text
    }

    override fun getLayout(): Int {
        return R.layout.chat_to_row
    }
}