package com.example.firebasechat

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firebasechat.databinding.ActivityChatListBinding
import com.example.firebasechat.model.Room
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class ChatListActivity: AppCompatActivity() {
    val binding: ActivityChatListBinding by lazy { ActivityChatListBinding.inflate(layoutInflater) }
    val database = Firebase.database("https://studyoffirebase-27c2f-default-rtdb.asia-southeast1.firebasedatabase.app/")
    val roomsRef = database.getReference("rooms")

    companion object{
        var userId: String = ""
        var userName: String = ""
    }

    val roomList = mutableListOf<Room>()
    lateinit var adapter: ChatRoomListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        userId = intent.getStringExtra("userId") ?: "none"
        userName = intent.getStringExtra("userName") ?: "Anonymous"

        binding.btnCreate.setOnClickListener { openCreateRoom() }

        adapter = ChatRoomListAdapter(roomList)
        with(binding){
            rvRoom.adapter = adapter
            rvRoom.layoutManager= LinearLayoutManager(baseContext)
        }

        loadRooms()
    }

    fun loadRooms(){
        roomsRef.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                roomList.clear()
                for(item in snapshot.children){
                    item.getValue(Room::class.java)?.let { room->
                        roomList.add(room)
                    }
                }
                //어댑터 갱신
                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                print(error.message)
            }

        })
    }

    fun openCreateRoom(){
        val editTitle = EditText(this)
        val dialog = AlertDialog.Builder(this)
            .setTitle("방 이름")
            .setView(editTitle)
            .setPositiveButton("만들기"){_, _->
                creatRoom(editTitle.text.toString())
            }
            .setNegativeButton("취소"){_,_-> }
        dialog.show()
    }

    fun creatRoom(title: String){
        val room = Room(title, userName)
        val roomId = roomsRef.push().key!!
        room.id = roomId
        roomsRef.child(roomId).setValue(room)
    }
}