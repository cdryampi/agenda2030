package com.example.agendatriste

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.agenda2030.controllers.SQLController
import com.example.agenda2030.model.Usuario
import com.example.agendatriste.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var sqlController: SQLController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        sqlController = SQLController(this)


        if (intent.hasExtra("nombre") && intent.hasExtra("email") && intent.hasExtra("telf")) {
            val usuario = intent.getStringExtra("nombre")
            val email = intent.getStringExtra("email")
            val telf = intent.getStringExtra("telf")
            binding.inputEmail.setText(email)
            binding.nameInput.setText(usuario)
            binding.inputTelf.setText(telf)
            binding.registrar.text = "Actualizar"
        }else{
            println("No hay extras")
        }

        binding.registrar.setOnClickListener {
            if (binding.nameInput.text.toString().isNotBlank() && binding.inputEmail.text.toString()
                    .isNotBlank() && binding.inputTelf.text.toString().isNotBlank()
            ) {
                val usuario = Usuario(
                    binding.nameInput.text.toString(),
                    binding.inputEmail.text.toString(),
                    binding.inputTelf.text.toString()
                )
                // insertar el objeto en la base de datos
                if (binding.registrar.text == "Registrar") {
                    sqlController.insertData(usuario)
                    Toast.makeText(this, "Usuario registrado", Toast.LENGTH_SHORT).show()
                } else {
                    var userNuevo = intent.getStringExtra("nombre")?.let { it1 ->
                        Usuario(
                            it1,
                            intent.getStringExtra("email")!!,
                            intent.getStringExtra("telf")!!

                        )
                    }
                    sqlController.editarData(userNuevo!!,usuario)
                    Toast.makeText(this, "Usuario actualizado", Toast.LENGTH_SHORT).show()
                }

                binding.nameInput.setText("")
                binding.inputEmail.setText("")
                binding.inputTelf.setText("")

            }
        }

        binding.listar.setOnClickListener {
            val intent = intent
            intent.setClass(this, ListarUsuarios::class.java)
            startActivity(intent)
        }
    }
}