package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.ui.inicio.ProveedoresActivity
import com.example.myapplication.ui.galeria.GaleriaActivity
import com.example.myapplication.ui.musica.MusicaActivity
import com.example.myapplication.ui.cliente.ClienteActivity

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.appBarMain.toolbar)

        // Guardar datos en SharedPreferences cuando se presiona el FAB
        binding.appBarMain.fab.setOnClickListener { view ->
            val sharedPref = getSharedPreferences("MiPreferencia", Context.MODE_PRIVATE)
            val editor = sharedPref.edit()
            editor.putString("nombre", "UsuarioEjemplo")  // Guardar un valor simple
            editor.putBoolean("isLoggedIn", true)         // Guardar un booleano
            editor.apply()  // Aplicar cambios

            // Mostrar un mensaje confirmando que se guardó la preferencia
            Snackbar.make(view, "Datos guardados en SharedPreferences", Snackbar.LENGTH_LONG)
                .setAction("Ver Datos") {
                    // Recuperar los datos guardados cuando se presione "Ver Datos"
                    val nombreGuardado = sharedPref.getString("nombre", "N/A")
                    val estadoSesion = sharedPref.getBoolean("isLoggedIn", false)

                    // Mostrar los datos recuperados en otro Snackbar
                    Snackbar.make(view, "Nombre: $nombreGuardado, Sesión: $estadoSesion", Snackbar.LENGTH_LONG).show()
                }.show()
        }

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView
        val navController = findNavController(R.id.nav_host_fragment_content_main)

        // Configuración de destinos principales, incluidos "Proveedores", "Galería", "Música", y "Cliente"
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_inicio, R.id.nav_galeria, R.id.nav_musica, R.id.nav_cliente, R.id.nav_proveedores
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        // Manejar la selección de elementos del NavigationView
        navView.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.nav_proveedores -> {
                    // Iniciar la nueva Activity para "Proveedores"
                    startActivity(Intent(this, ProveedoresActivity::class.java))
                    true
                }
                R.id.nav_galeria -> {
                    // Iniciar la nueva Activity para "Galería"
                    startActivity(Intent(this, GaleriaActivity::class.java))
                    true
                }
                R.id.nav_musica -> {
                    // Iniciar la nueva Activity para "Música"
                    startActivity(Intent(this, MusicaActivity::class.java))
                    true
                }
                R.id.nav_cliente -> {
                    // Iniciar la nueva Activity para "Cliente"
                    startActivity(Intent(this, ClienteActivity::class.java))
                    true
                }
                else -> false
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflar el menú; esto agrega ítems a la barra de acción si está presente.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}
