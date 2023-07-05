package com.example.firebasechat

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.firebasechat.databinding.ItemMsgListBinding
import com.example.firebasechat.model.Message

class MsgListAdapter(val msgList: MutableList<Message>): RecyclerView.Adapter<MsgListAdapter.Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding = ItemMsgListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun getItemCount(): Int {
        return msgList.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val msg = msgList.get(position)
        holder.setMsg(msg)
    }
    class Holder(val binding: ItemMsgListBinding): RecyclerView.ViewHolder(binding.root){
        fun setMsg(msg: Message){
            with(binding){
                tvTextName.setText(msg.userName)
                tvTextMsg.setText(msg.msg)
                tvTextDate.setText("${msg.timeStamp}")
            }
        }

    }
}