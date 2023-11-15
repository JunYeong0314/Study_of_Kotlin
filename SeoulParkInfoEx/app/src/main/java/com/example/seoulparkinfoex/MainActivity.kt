package com.example.seoulparkinfoex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.seoulparkinfoex.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.InputStreamReader
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity: AppCompatActivity() {

    @Inject
    lateinit var chatService: ChatService

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnMain.setOnClickListener {
            val request = ChatRequest("11월행사 추천해줘")
            lifecycleScope.launch {
                val response = chatService.getChat(request)
                val statusCode = response.code()

                if(response.isSuccessful){
                    val body = response.body()

                    body?.let {
                        val stream = it.byteStream()
                        val reader = BufferedReader(InputStreamReader(stream))

                        withContext(Dispatchers.Main){
                            val stringBuilder = StringBuilder()
                            var char: Int

                            while (reader.read().also { char = it } != -1) {
                                stringBuilder.append(char.toChar())
                                binding.tvChat.text = stringBuilder.toString()
                            }
                        }
                    }
                }
            }
        }

    }

}