package co.edu.uniandes.appsleep

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ListarAlarmasActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_listar_alarmas)

        val svgButton: ImageView = findViewById(R.id.imageViewReportes)
        svgButton.setOnClickListener {
            showDialog()
        }
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.listar_alarmas)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun showDialog() {
        val dialogView = layoutInflater.inflate(R.layout.dialog_report_type, null)

        val dialog = AlertDialog.Builder(this)
            .setView(dialogView)
            .setCancelable(true)
            .create()

        val activityLink = dialogView.findViewById<TextView>(R.id.activityLink)
        val circadianRhythmLink = dialogView.findViewById<TextView>(R.id.circadianRhythmLink)

        activityLink.setOnClickListener {
            // Inicia la Activity para la actividad nocturna
            val intent = Intent(this, NocturnalActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Actividad Nocturna seleccionada", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }

        circadianRhythmLink.setOnClickListener {
            // Inicia la Activity para el ritmo circadiano
            val intent = Intent(this, CircadianRhythmActivity::class.java)
            startActivity(intent)
            Toast.makeText(this, "Ritmo Circadiano seleccionado", Toast.LENGTH_SHORT).show()
            dialog.dismiss()
        }

        dialog.show()
    }
}