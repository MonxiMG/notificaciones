package es.ua.eps.notificaciones

import android.graphics.Color
import android.os.Bundle
import android.util.TypedValue
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class Ej3DialogosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ej3_dialogos)

        val btnColor = findViewById<Button>(R.id.btnColor)
        val btnTamano = findViewById<Button>(R.id.btnTamano)
        val txtContenido = findViewById<TextView>(R.id.txtContenido)
        val btnSiguiente = findViewById<Button>(R.id.btnSiguiente3)

        btnColor.setOnClickListener {
            val opciones = resources.getStringArray(R.array.opciones_color)
            AlertDialog.Builder(this)
                .setTitle(getString(R.string.btn_color))
                .setItems(opciones) { _, which ->
                    when (which) {
                        0 -> { txtContenido.setBackgroundColor(Color.WHITE); txtContenido.setTextColor(Color.BLACK) }
                        1 -> { txtContenido.setBackgroundColor(Color.BLACK); txtContenido.setTextColor(Color.WHITE) }
                        2 -> { txtContenido.setBackgroundColor(Color.BLACK); txtContenido.setTextColor(Color.GREEN) }
                    }
                }.show()
        }

        btnTamano.setOnClickListener {
            val opciones = resources.getStringArray(R.array.opciones_tamano)
            AlertDialog.Builder(this)
                .setTitle(getString(R.string.btn_tamano))
                .setItems(opciones) { _, which ->
                    val sp = when (which) { 0 -> 8f; 1 -> 12f; else -> 20f }
                    txtContenido.setTextSize(TypedValue.COMPLEX_UNIT_SP, sp)
                }.show()
        }

        btnSiguiente.setOnClickListener {
            startActivity(android.content.Intent(this, Ej4NotifActivity::class.java))
        }
    }
}
