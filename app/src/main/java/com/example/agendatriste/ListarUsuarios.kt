package com.example.agendatriste

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.agenda2030.controllers.SQLController
import com.example.agenda2030.providers.UsuarioProvider
import com.example.agendatriste.adapters.UsuarioAdapter
import com.example.agendatriste.databinding.ActivityListarUsuariosBinding

class ListarUsuarios : AppCompatActivity() {
    lateinit var binding: ActivityListarUsuariosBinding
    lateinit var sqlController: SQLController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListarUsuariosBinding.inflate(layoutInflater)
        sqlController = SQLController(this)

        initRecyclerView()

        binding.volver.setOnClickListener {
            println("volver")
            val intent = intent
            intent.setClass(this, MainActivity::class.java)
            startActivity(intent)
        }




        setContentView(binding.root)
    }

    private fun initRecyclerView(){
        val recyclerView = binding.recyclerView
        var usuarios = sqlController.selectData()
        val adapter = UsuarioAdapter(this, usuarios)
        adapter.notifyItemRemoved(usuarios.size)
        recyclerView.adapter = adapter
        recyclerView.scrollToPosition(usuarios.size)
        recyclerView.layoutManager = LinearLayoutManager(this)
    }
}