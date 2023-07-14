package com.example.seoulparkinfoex

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.seoulparkinfoex.databinding.ItemParkinfoBinding
import com.example.seoulparkinfoex.seoulParkApi.Row
import java.text.SimpleDateFormat
import java.util.Locale


class SeoulParkAdapter: ListAdapter<Row, SeoulParkAdapter.SeoulParkViewHolder>(DiffCallback) {
    class SeoulParkViewHolder(private val binding: ItemParkinfoBinding):
        RecyclerView.ViewHolder(binding.root){

        fun bind(item: Row){
            with(binding){
                tvTitle.text = item.pARKINGNAME
                tvParkType.text = item.pARKINGTYPE
                tvParkTell.text = item.tEL ?: "번호정보 없음"
                tvParkStartTime.text = "${convertTimeFormat(item.wEEKDAYBEGINTIME.toString())}"
                tvParkEndTime.text = "${convertTimeFormat(item.wEEKENDENDTIME.toString())}"
            }
        }
        fun convertTimeFormat(time: String): String{
            val inputTime = SimpleDateFormat("HHmm", Locale.getDefault())
            val outputTime = SimpleDateFormat("HH:mm", Locale.getDefault())

            val parsedTime = inputTime.parse(time)
            return outputTime.format(parsedTime)
        }
    }

    companion object{
        private val DiffCallback = object : DiffUtil.ItemCallback<Row>(){
            override fun areItemsTheSame(oldItem: Row, newItem: Row): Boolean {
                return oldItem.hashCode() == newItem.hashCode()
            }

            override fun areContentsTheSame(oldItem: Row, newItem: Row): Boolean {
                return oldItem == newItem
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SeoulParkViewHolder {
        val binding = ItemParkinfoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SeoulParkViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SeoulParkViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

}