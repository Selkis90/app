package com.example.myapplication

import android.content.Context
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
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_inicio, R.id.nav_galeria, R.id.nav_musica, R.id.nav_cliente
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}
