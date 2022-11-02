package com.example.mtmyschool
import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mtmyschool.databinding.ActivityregistroBinding

class RegistroActivity: AppCompatActivity(){
    lateinit var binding: ActivityregistroBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityregistroBinding.inflate(layoutInflater)
        binding.BtnRegistrar.setOnClickListener { guardarusuario() }
        setContentView(binding.root)
    }

    public final fun guardarusuario(){

        val nombre:String=binding.NombreEstudiante.text.toString()
        val identificacion:String=binding.Identificacion.text.toString()
        val correo:String=binding.Correo.text.toString()
        val curso:String=binding.Curso.text.toString()
        val clave:String=binding.clave.text.toString()
        val genero:Int=binding.genero.id



        val acu_nombre:String=binding.nombreAcudiente.text.toString()
        val acu_telefono:String=binding.telefonoAcudiente.text.toString()
        val acu_correo:String=binding.correoAcudiente.text.toString()
        val acu_direccion:String=binding.direccion.text.toString()

        val pref=getSharedPreferences(correo,Context.MODE_PRIVATE)
        val editar=pref.edit()
        editar.putString("Email",correo)
        editar.putString("nombre",nombre)
        editar.putString("Identificación",identificacion)
        editar.putString("clave",clave)
        editar.putString("curso",curso)
        editar.putString("genero",curso)

        if (genero==0){
            editar.putString("Genero", "Hombre")
        }else{editar.putString("Genero", "  Mujer")}
        editar.putString("Nombre Acudiente",acu_nombre)
        editar.putString("Telefono Acudiente",acu_telefono)
        editar.putString("Correo Acudiente",acu_correo)
        editar.putString("Direccion Acudiente",acu_direccion)

        editar.commit()
        Toast.makeText(this,"Usuario registrado exitosamente", Toast.LENGTH_LONG).show()
        startActivity(Intent(this, LoginActivity::class.java))


    }
}