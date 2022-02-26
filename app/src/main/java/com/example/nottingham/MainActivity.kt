package com.example.nottingham

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

     private lateinit var toggle: ActionBarDrawerToggle

    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawerLayout)
        val navView: NavigationView = findViewById(R.id.nav_view)

        toggle = ActionBarDrawerToggle(this,drawerLayout, R.string.open,R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDefaultDisplayHomeAsUpEnabled(true)

        navView.setNavigationItemSelectedListener {

            when(it.itemId){
                R.id.nav_home -> {

                    Toast.makeText(applicationContext,"Clicked Home",Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@MainActivity, MainActivity::class.java)
                    startActivity(intent)

                }
                R.id.nav_booking -> {

                    Toast.makeText(applicationContext,"Clicked Booking",Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@MainActivity, Booking::class.java)
                    startActivity(intent)
                }
                R.id.nav_ticket -> Toast.makeText(applicationContext,"Clicked Ticket",Toast.LENGTH_SHORT).show()

                R.id.nav_map -> {
                    Toast.makeText(applicationContext,"Clicked Map",Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@MainActivity, MapsActivity::class.java)
                    startActivity(intent)
                }
                R.id.nav_contact -> {
                    Toast.makeText(applicationContext, "Contact", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@MainActivity, Contact::class.java)
                    startActivity(intent)
                }
                R.id.nav_logout -> {
                    Toast.makeText(applicationContext,"Logged Out",Toast.LENGTH_SHORT).show()
                    val intent = Intent(this@MainActivity, Login::class.java)
                    startActivity(intent)
                    finish();
                }
            }
        true

        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }

        return super.onOptionsItemSelected(item)
    }
}