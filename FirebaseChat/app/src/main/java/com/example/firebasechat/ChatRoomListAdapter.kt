package com.example.firebasechat

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.firebasechat.databinding.ItemMsgListBinding
import com.example.firebasechat.model.Room

class ChatRoomListAdapter(val roomList: MutableList<Room>): RecyclerView.Adapter<ChatRoomListAdapter.Holder>() {
    private lateinit var binding: ItemMsgListBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(android.R.layout.simple_list_item_1, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int {
        return roomList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val room = roomList.get(position)
        holder.setRoom(room)
    }
    class Holder(itemView: View): RecyclerView.ViewHolder(itemView){
        lateinit var mRoom: Room
        init {
            itemView.setOnClickListener {
                val intent = Intent(itemView.context, ChatRoomActivity::class.java)
                intent.putExtra("roomId", mRoom.id)
                intent.putExtra("roomTitle", mRoom.title)
                itemView.context.startActivity(intent)
            }
        }
        fun setRoom(room: Room){
            this.mRoom = room
            itemView.findViewById<TextView>(android.R.id.text1).setText(room.title)
        }

    }
}
