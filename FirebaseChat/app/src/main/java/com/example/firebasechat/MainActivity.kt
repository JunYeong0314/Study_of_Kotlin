package com.example.firebasechat

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.firebasechat.databinding.ActivityMainBinding
import com.example.firebasechat.model.Room
import com.example.firebasechat.model.User
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    val binding: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    val database = Firebase.database("https://studyoffirebase-27c2f-default-rtdb.asia-southeast1.firebasedatabase.app/")
    val usersRef = database.getReference("users")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnSignin.setOnClickListener { signIn() }
        binding.btnSignup.setOnClickListener { signUp() }
    }

    fun signUp(){
        with(binding){
            val id = etId.text.toString()
            val password = etPassword.text.toString()
            val name = etName.text.toString()

            if(id.isNotEmpty() && password.isNotEmpty() && name.isNotEmpty()){
                usersRef.child(id).get().addOnSuccessListener {
                    if(it.exists()){
                        Toast.makeText(baseContext, "아이디가 이미 존재합니다.", Toast.LENGTH_SHORT).show()
                    }else{
                        val user = User(id, password, name)
                        usersRef.child(id).setValue(user)
                        signIn()
                    }
                }
            }else{
                Toast.makeText(baseContext, "아이디, 비밀번호, 별명을 모두 입력해야합니다", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun signIn(){
        with(binding){
            val id = etId.text.toString()
            val password = etPassword.text.toString()

            if(id.isNotEmpty() && password.isNotEmpty()){
                usersRef.child(id).get().addOnSuccessListener {
                    if(it.exists()){
                        it.getValue(User::class.java)?.let { user->
                            if(user.password == password){
                                goChatroomList(user.id, user.name)
                            }else{
                                Toast.makeText(baseContext, "비밀번호가 다릅니다", Toast.LENGTH_SHORT).show()
                            }
                        }
                    }else{
                        Toast.makeText(baseContext, "아이디가 없습니다", Toast.LENGTH_SHORT).show()
                    }
                }
            }else{
                Toast.makeText(baseContext, "아이디와 비밀번호 모두 입력해야합니다", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun goChatroomList(userId: String, userName: String){
        val intent = Intent(this, ChatListActivity::class.java)
        intent.putExtra("userId", userId)
        intent.putExtra("userName", userName)

        startActivity(intent)
    }
}