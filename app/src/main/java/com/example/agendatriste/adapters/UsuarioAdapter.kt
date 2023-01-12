package com.example.agendatriste.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.agenda2030.model.Usuario
import com.example.agendatriste.R
import com.example.agendatriste.holders.ViewHolderUsuario

class UsuarioAdapter(context: Context, listaUsuarios:List<Usuario>): RecyclerView.Adapter<ViewHolderUsuario>() {

    private val inflater = LayoutInflater.from(context)
    private var items:List<Usuario> = listaUsuarios

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderUsuario {
        return ViewHolderUsuario(inflater.inflate(R.layout.fragment_itemusuario, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolderUsuario, position: Int) {
        val item = items[position]
        holder.render(item)
    }

    override fun getItemCount(): Int {
        return items.size
    }


}