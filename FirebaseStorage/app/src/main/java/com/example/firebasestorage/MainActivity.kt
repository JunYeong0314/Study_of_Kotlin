package com.example.firebasestorage

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage

class MainActivity : AppCompatActivity() {
    val storage = Firebase.storage("gs://studyoffirebase-27c2f.appspot.com")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val galleryLauncher = registerForActivityResult(ActivityResultContracts.GetContent()){uri->
            uploadImage(uri!!)
        }
        val permissionLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()){isGranted->
            if(isGranted){
                galleryLauncher.launch("image/*")
            }else{
                Toast.makeText(baseContext, "외부 저장소 읽기권한을 승인해야 사용가능", Toast.LENGTH_SHORT).show()
            }

        }
    }

    fun uploadImage(uri: Uri){
        val fullPath = makeFilePath("images", "temp", uri)
        val imageRef = storage.getReference(fullPath)
        val uploadTask = imageRef.putFile(uri)

        uploadTask.addOnFailureListener {
            Log.d("Storage", "실패=>{$fullPath}")
        }.addOnSuccessListener {
            Log.d("Storage", "성공 주소=>{$fullPath}")
        }
    }

    fun makeFilePath(path: String, userId: String, uri: Uri): String{
        val mimeType = contentResolver.getType(uri) ?: "/none" // 마임타입 (ex. images/jpeg)
        val ext = mimeType.split("/")[1] // 확장자 (ex.jpeg)
        val timeSuffix = System.currentTimeMillis()
        val filename = "${path}/${userId}_${timeSuffix}.${ext}"
        return filename
    }
}