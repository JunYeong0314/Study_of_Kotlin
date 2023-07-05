package com.example.firebasechat

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firebasechat.databinding.ActivityChatRoomBinding
import com.example.firebasechat.model.Message
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class ChatRoomActivity: AppCompatActivity() {
    val binding: ActivityChatRoomBinding by lazy { ActivityChatRoomBinding.inflate(layoutInflater) }
    val database = Firebase.database("https://studyoffirebase-27c2f-default-rtdb.asia-southeast1.firebasedatabase.app/")
    lateinit var msgRef: DatabaseReference

    var roomId: String = ""
    var roomTitle: String = ""

    val msgList = mutableListOf<Message>()
    lateinit var adapter: MsgListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        roomId = intent.getStringExtra("roomId") ?: "none"
        roomTitle = intent.getStringExtra("roomTitle") ?: "없음"

        msgRef = database.getReference("rooms").child(roomId).child("message")
        adapter = MsgListAdapter(msgList)

        with(binding){
            rvChatRoom.adapter = adapter
            rvChatRoom.layoutManager = LinearLayoutManager(baseContext)

            tvTitle.setText(roomTitle)
            ibtnBack.setOnClickListener { finish() }
            ibtnSend.setOnClickListener { sendMsg() }
        }

        loadMsg()
    }

    fun loadMsg(){
        msgRef.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                msgList.clear()
                for(item in snapshot.children){
                    item.getValue(Message::class.java)?.let {msg->
                        msgList.add(msg)
                    }
                }
                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                print(error.message)
            }

        })
    }

    fun sendMsg(){
        with(binding){
            if(etMsg.text.isNotEmpty()){
                val message = Message(etMsg.text.toString(), ChatListActivity.userName)
                val msgId = msgRef.push().key!!
                message.id = msgId
                msgRef.child(msgId).setValue(message)
                etMsg.setText("")
            }
        }
    }
}