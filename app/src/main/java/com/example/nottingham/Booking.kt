package com.example.nottingham

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Button
import android.widget.Toast
import com.example.nottingham.databinding.ActivityMainBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class Booking : AppCompatActivity() {

        private lateinit var single:EditText
        private lateinit var day:EditText
        private lateinit var season:EditText
        private lateinit var singlebtn:Button
        private lateinit var daybtn:Button
        private lateinit var seasonbtn:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_booking)

        single = findViewById(R.id.edt_ticket)
        day = findViewById(R.id.edt_dayticket)
        season = findViewById(R.id.edt_seasonticket)
        singlebtn = findViewById(R.id.singlebtn)
        daybtn = findViewById(R.id.day_btn)
        seasonbtn = findViewById(R.id.season_btn)

        
        singlebtn.setOnClickListener {
            savesingleticket()
        }
        daybtn.setOnClickListener { 
            savesdayticket()
        }
        seasonbtn.setOnClickListener { 
            saveseasonticket()
        }

    }
    private fun savesdayticket(){
        val ticket = day.text.toString().trim()

        if(ticket.isEmpty()){
            day.error="Please the number of ticket required"
            return
        }

        val ref = FirebaseDatabase.getInstance().reference

        // val ticketid = ref.push().key
        val daytkt = dayticket(ticket)

        ref.child(ticket).setValue(daytkt).addOnCompleteListener{
            Toast.makeText(applicationContext,"Ticket has been Booked",Toast.LENGTH_SHORT).show()
        }
    }
    private fun savesingleticket(){
        val ticket = single.text.toString().trim()

        if(ticket.isEmpty()){
            single.error="Please the number of ticket required"
            return
        }

        val ref = FirebaseDatabase.getInstance().reference

       // val ticketid = ref.push().key
        val singletkt = singleticket(ticket)

      ref.child(ticket).setValue(singletkt).addOnCompleteListener{
            Toast.makeText(applicationContext,"Ticket has been Booked",Toast.LENGTH_SHORT).show()
        }
    }
    private fun saveseasonticket(){
        val ticket = season.text.toString().trim()

        if(ticket.isEmpty()){
            season.error="Please the number of ticket required"
            return
        }

        val ref = FirebaseDatabase.getInstance().reference

        // val ticketid = ref.push().key
        val seasontkt = dayticket(ticket)

        ref.child(ticket).setValue(seasontkt).addOnCompleteListener{
            Toast.makeText(applicationContext,"Ticket has been Booked",Toast.LENGTH_SHORT).show()
        }
    }
}

