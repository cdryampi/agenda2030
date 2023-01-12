package com.example.agenda2030.providers

import android.content.Context
import com.example.agenda2030.controllers.SQLController
import com.example.agenda2030.model.Usuario

class UsuarioProvider(context: Context) {

    companion object {

        val colection_usuarios = listOf<Usuario>(
            Usuario("Juan", "Perez@juan.com", "2222333"),
            Usuario("Maria", "Sevilla@maria.com", "2222333"),
            Usuario("Pedro", "Gomez@pedro.com", "2222333"),
            Usuario("Sara", "sara@rodriguez.com", "2222333"),
            Usuario("Marc", "Marc@perez.com", "2222333"),
            Usuario("Bea", "Bea@fernandez.com", "2222333"),
        )
    }
}