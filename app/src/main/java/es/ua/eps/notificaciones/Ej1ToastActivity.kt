package es.ua.eps.notificaciones

import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class Ej1ToastActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ej1_toast)

        val edtTexto = findViewById<EditText>(R.id.edtTexto)
        val btnEnviar = findViewById<Button>(R.id.btnEnviar)
        val btnSiguiente = findViewById<Button>(R.id.btnSiguiente1)

        btnEnviar.setOnClickListener {
            val texto = edtTexto.text.toString().trim()
            val msg = if (texto.isEmpty()) getString(R.string.escribe_un_texto) else texto

            val toast = Toast(this)
            val view = layoutInflater.inflate(R.layout.toast_custom, null)
            view.findViewById<TextView>(R.id.txtToast).text = msg
            toast.view = view
            toast.duration = Toast.LENGTH_SHORT
            toast.setGravity(Gravity.CENTER, 0, 0)
            toast.show()

            edtTexto.text?.clear()
        }

        btnSiguiente.setOnClickListener {
            startActivity(android.content.Intent(this, Ej2SnackbarActivity::class.java))
        }
    }
}
