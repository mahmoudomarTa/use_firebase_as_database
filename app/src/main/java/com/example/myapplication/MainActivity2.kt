package com.example.myapplication

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main2.*


class MainActivity2 : AppCompatActivity() {
    var db = FirebaseFirestore.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        btnSave.setOnClickListener {
            var d = ProgressDialog(this)
            d.show()
            var i = Info(edName.text.toString(),edAddress.text.toString(),edPhone.text.toString(),System.currentTimeMillis().toString())
        db.collection("information").document("${i.id}").set(i)
            .addOnFailureListener {
            d.hide()
                Toast.makeText(applicationContext,"${it.message.toString()}",Toast.LENGTH_SHORT).show()
            }.addOnSuccessListener {
                d.hide()
                edName.setText("")
                edAddress.setText("")
                edPhone.setText("")
                Toast.makeText(applicationContext,"success",Toast.LENGTH_SHORT).show()
            }
            }


    }
}