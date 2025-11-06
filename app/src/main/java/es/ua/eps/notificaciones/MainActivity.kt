package es.ua.eps.notificaciones

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnEj1).setOnClickListener {
            startActivity(Intent(this, Ej1ToastActivity::class.java))
        }
        findViewById<Button>(R.id.btnEj2).setOnClickListener {
            startActivity(Intent(this, Ej2SnackbarActivity::class.java))
        }
        findViewById<Button>(R.id.btnEj3).setOnClickListener {
            startActivity(Intent(this, Ej3DialogosActivity::class.java))
        }
        findViewById<Button>(R.id.btnEj4).setOnClickListener {
            startActivity(Intent(this, Ej4NotifActivity::class.java))
        }
    }
}
