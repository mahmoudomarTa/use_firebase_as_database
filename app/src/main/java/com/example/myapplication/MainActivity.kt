package com.example.myapplication


import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    var db = FirebaseFirestore.getInstance()
    var informations = ArrayList<Info>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mFloatingActionButton.setOnClickListener {
            startActivity(Intent(applicationContext,MainActivity2::class.java))
        }

        var d = ProgressDialog(this)
        d.show()

        db.collection("information")
            .get()
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    for (document in task.result!!) {
                        var name = document["name"].toString()
                        var address = document["address"].toString()
                        var phone = document["mobile"].toString()
                        var id = document["id"].toString()
                        informations.add(Info(name,address,phone,id))
                    }

                    mRecyclerView.layoutManager=LinearLayoutManager(applicationContext)
                    mRecyclerView.adapter=MyAdapter(informations)
                    d.hide()
                } else {
                    Toast.makeText(applicationContext,"${task.exception!!.message.toString()}", Toast.LENGTH_SHORT).show()
                    d.hide()
                }
            }


    }

    override fun onRestart() {
        super.onRestart()
        recreate()
    }



}
