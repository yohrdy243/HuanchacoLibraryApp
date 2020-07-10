package upn.edu.pe.huanchacolibraryapp.controllers

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import upn.edu.pe.huanchacolibraryapp.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        val context: Context = this
        //no borrar
        val intent = Intent(context,MenuSlideActivity::class.java)
        startActivity(intent)
        //no borrar


    }


}