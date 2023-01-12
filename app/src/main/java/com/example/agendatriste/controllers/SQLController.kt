package com.example.agenda2030.controllers

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.agenda2030.model.Usuario

class SQLController(context: Context): SQLiteOpenHelper(context,"agenda.db",null,1) {

    fun insertData(usuario: Usuario){
        val db = writableDatabase
        val query = "INSERT INTO contacto (nombre, email, telf) VALUES ('${usuario.nombre}','${usuario.email}','${usuario.telf}')"
        db.execSQL(query)
    }

    fun deleteData(usuario: Usuario){
        val db = writableDatabase
        val query = "DELETE FROM contacto WHERE nombre = '${usuario.nombre}' AND email = '${usuario.email}' AND telf = '${usuario.telf}'"
        db.execSQL(query)
    }
    fun editarData(usuarioAntiguo: Usuario, usuarioNuevo: Usuario){
        val db = writableDatabase
        println( "UsuarioAntiguo: ${usuarioAntiguo}")
        println( "UsuarioNuevo: ${usuarioNuevo}")
        val query = "UPDATE contacto SET nombre = '${usuarioNuevo.nombre}', email = '${usuarioNuevo.email}', telf = '${usuarioNuevo.telf}' WHERE nombre = '${usuarioAntiguo.nombre}' AND email = '${usuarioAntiguo.email}' AND telf = '${usuarioAntiguo.telf}'"
        db.execSQL(query)
    }

    fun selectData():ArrayList<Usuario>{
        val db = readableDatabase
        val query = "SELECT * FROM contacto"
        val cursor = db.rawQuery(query, null)
        val list = ArrayList<Usuario>()
        while (cursor.moveToNext()){
            val name = cursor.getString(1)
            val email = cursor.getString(2)
            val telf = cursor.getString(3)

            list.add(Usuario(name, email, telf))
        }
        return list
    }


    override fun onCreate(p0: SQLiteDatabase?) {
        var sql = "CREATE TABLE contacto (id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT, email TEXT, telf TEXT)"
        p0?.execSQL(sql)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        var sql = "DROP TABLE IF EXISTS usuario"
        p0?.execSQL(sql)
        onCreate(p0)
    }
}