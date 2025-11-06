package es.ua.eps.notificaciones

import android.Manifest
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Button
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat

class Ej4NotifActivity : AppCompatActivity() {
    private val NOTIF_ID = 1001
    private var tareas = 0
    private val CHANNEL_ID by lazy { getString(R.string.canal_id) }

    private val requestNotifPerm = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ) { }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ej4_notif)

        val btnIniciar = findViewById<Button>(R.id.btnIniciar)
        val btnDetener = findViewById<Button>(R.id.btnDetener)
        val btnVolver = findViewById<Button>(R.id.btnVolver)

        crearCanal()

        btnIniciar.setOnClickListener {
            pedirPermisoSiHaceFalta()
            tareas++
            mostrarNotificacion()
        }

        btnDetener.setOnClickListener {
            if (tareas > 0) tareas--
            if (tareas == 0) NotificationManagerCompat.from(this).cancel(NOTIF_ID)
            else mostrarNotificacion()
        }

        btnVolver.setOnClickListener {
            startActivity(android.content.Intent(this, MainActivity::class.java))
            finish()
        }
    }

    private fun pedirPermisoSiHaceFalta() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            val ok = ContextCompat.checkSelfPermission(
                this, Manifest.permission.POST_NOTIFICATIONS
            ) == PackageManager.PERMISSION_GRANTED
            if (!ok) requestNotifPerm.launch(Manifest.permission.POST_NOTIFICATIONS)
        }
    }

    private fun crearCanal() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val canal = NotificationChannel(
                CHANNEL_ID,
                getString(R.string.canal_nombre),
                NotificationManager.IMPORTANCE_HIGH
            )
            val nm = getSystemService(NotificationManager::class.java)
            nm.createNotificationChannel(canal)
        }
    }

    private fun mostrarNotificacion() {
        val texto = "Tareas iniciadas: $tareas"
        val intent = android.content.Intent(this, MainActivity::class.java)
        val pending = PendingIntent.getActivity(
            this, 0, intent,
            PendingIntent.FLAG_UPDATE_CURRENT or
                    (if (Build.VERSION.SDK_INT >= 23) PendingIntent.FLAG_IMMUTABLE else 0)
        )

        val notif = NotificationCompat.Builder(this, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_info)
            .setContentTitle(getString(R.string.notif_titulo))
            .setContentText(texto)
            .setContentIntent(pending)
            .setOngoing(true)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .build()

        NotificationManagerCompat.from(this).notify(NOTIF_ID, notif)
    }
}
