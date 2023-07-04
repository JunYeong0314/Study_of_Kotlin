package com.example.firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.firebase.databinding.ActivityMainBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {
    val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    val database = Firebase.database("https://studyoffirebase-27c2f-default-rtdb.asia-southeast1.firebasedatabase.app/")
    val myRef = database.getReference("users")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        with(binding){
            btnPost.setOnClickListener {
                val name = etName.text.toString()
                val password = etAge.text.toString()
                val user = User(name, password)
                addItem(user)
            }
        }

        myRef.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                binding.tvList.setText("")
                for(item in snapshot.children){
                    //getValue로 꺼낸 User데이터는 아직 코틀린 클래스가 아니기 때문에 변환작업 수행
                    item.getValue(User::class.java)?.let { user->
                        binding.tvList.append("${user.name} : ${user.password} \n")
                    }
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })
    }

    fun addItem(user: User){
        val id = myRef.push().key!!
        user.id = id
        myRef.child(id).setValue(user)
    }
}

class User{
    var id: String = ""
    var name: String = ""
    var password: String = ""

    constructor()

    constructor(name: String, password: String){
        this.name = name
        this.password = password
    }
}