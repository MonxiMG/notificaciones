package es.ua.eps.notificaciones

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar

class Ej2SnackbarActivity : AppCompatActivity() {
    private val tareas = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ej2_snackbar)

        val root = findViewById<androidx.coordinatorlayout.widget.CoordinatorLayout>(R.id.root)
        val edtTarea = findViewById<EditText>(R.id.edtTarea)
        val btnAgregar = findViewById<Button>(R.id.btnAgregar)
        val txtLista = findViewById<TextView>(R.id.txtLista)
        val btnSiguiente = findViewById<Button>(R.id.btnSiguiente2)

        btnAgregar.setOnClickListener {
            val texto = edtTarea.text.toString().trim()
            if (texto.isEmpty()) {
                Snackbar.make(root, getString(R.string.escribe_un_texto), Snackbar.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            tareas.add(texto)
            txtLista.append("$texto\n")
            edtTarea.text?.clear()

            val snack = Snackbar.make(root, getString(R.string.tarea_anadida), Snackbar.LENGTH_LONG)
            snack.setAction(getString(R.string.deshacer)) {
                if (tareas.isNotEmpty()) {
                    tareas.removeLast()
                    txtLista.text = tareas.joinToString("\n")
                }
            }
            snack.show()
        }

        btnSiguiente.setOnClickListener {
            startActivity(android.content.Intent(this, Ej3DialogosActivity::class.java))
        }
    }
}
