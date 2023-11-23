package com.example.project1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.example.project1.databinding.ActivityListItemBinding
import com.example.project1.databinding.ActivityListItemNoBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.firestore

class ListItemNo : AppCompatActivity() {

    lateinit var binding: ActivityListItemNoBinding
    private val db: FirebaseFirestore = Firebase.firestore
    private lateinit var auth: FirebaseAuth
    private val itemsCollectionRef = db.collection("Item") // items는 Collection ID
    private val usersCollectionRef = db.collection("user").document("user")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityListItemNoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = Firebase.auth //authentication

        val docid =intent.getStringExtra("DocId")


        Log.d("DocumentCheck",docid.toString())

        val title = intent.getStringExtra("listTitle")
        val content = intent.getStringExtra("listContents")
        val price = intent.getStringExtra("listPrice")



        binding.detailTitle.text=title
        binding.price.text=price +"원"
        binding.detailContent.text=content
        binding.SellerNameTv.text= auth.currentUser?.email



        binding.backButton.setOnClickListener {
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }



    }


}