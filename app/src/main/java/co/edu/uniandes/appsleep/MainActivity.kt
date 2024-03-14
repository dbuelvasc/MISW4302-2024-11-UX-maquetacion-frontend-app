package co.edu.uniandes.appsleep

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }


    fun cambiarContrasenaActivity(view: View) {
        val intent = Intent(this, changekey::class.java)
        startActivity(intent)
    }

    fun olvidoSuclaveActivity(view: View) {
        val intent = Intent(this, recoverkey::class.java)
        startActivity(intent)
    }

    fun openListarAlarmasActivity(view: View) {
        val intent = Intent(this, ListarAlarmasActivity::class.java)
        startActivity(intent)
    }

    fun abrirRegistrarActivity(view: View) {
        val intent = Intent(this, registrar::class.java)
        startActivity(intent)
    }
}