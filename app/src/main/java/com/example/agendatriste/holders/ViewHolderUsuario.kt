package com.example.agendatriste.holders

import android.app.AlertDialog
import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.agenda2030.controllers.SQLController
import com.example.agenda2030.model.Usuario
import com.example.agendatriste.MainActivity


class ViewHolderUsuario(inflate: View):RecyclerView.ViewHolder(inflate) {

    private val binding = com.example.agendatriste.databinding.FragmentItemusuarioBinding.bind(inflate)
    private val sqlController = SQLController(inflate.context)
    private val intent = Intent(inflate.context, MainActivity::class.java)

    fun render(item:Usuario) {
        binding.nombre.text = item.nombre
        binding.email.text = item.email
        binding.telefono.text = item.telf

        binding.cartaResultado.setOnClickListener {
            val builder = AlertDialog.Builder(binding.root.context)
            builder.setTitle("Usuario ${item.nombre}")
            builder.setMessage("¿Que le quieres hacer al usuario?")
            builder.setPositiveButton("Eliminar") { dialog, which ->
                sqlController.deleteData(item)
                Toast.makeText(binding.root.context, "Usuario eliminado", Toast.LENGTH_LONG).show()
            }
            builder.setNegativeButton("Editar") { dialog, which ->
                intent.setClass(binding.root.context, MainActivity::class.java)

                intent.putExtra("nombre", item.nombre)
                intent.putExtra("email", item.email)
                intent.putExtra("telf", item.telf)
                binding.root.context.startActivity(intent)
            }
            builder.setNeutralButton("Salir") { dialog, which ->
                // no hacer nada
            }
            builder.show()
        }
    }
}
