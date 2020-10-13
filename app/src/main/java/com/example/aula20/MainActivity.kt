package com.example.aula20


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val TAG: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Instanciando a toolbar
        setSupportActionBar(toolbar)

        //Evento Click navigationIcon
        toolbar.setNavigationOnClickListener{
            Log.i(TAG, "Clicando no navigationIcon")
        }

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_home, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var itemView = item.itemId

        when(itemView){
            R.id.menu_add->showToast("Adicionando")
            R.id.menu_notification->showSnackbar( "Notificação")
        }
        return false
    }

    fun showToast(msg: String){
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }

    fun showSnackbar(msg: String){
        var snack = Snackbar.make(snack_layout, msg, Snackbar.LENGTH_SHORT)
        snack.setAction("OK", View.OnClickListener {
            Log.i(TAG, "Clicando em ok")
        })
        snack.show()
    }

}