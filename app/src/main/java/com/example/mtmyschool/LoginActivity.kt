package com.example.mtmyschool
import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.widget.Button
import android.widget.Toast
import com.example.mtmyschool.databinding.ActivityloginBinding
import com.example.mtmyschool.databinding.ActivityregistroBinding


class LoginActivity: AppCompatActivity(){

    lateinit var binding:ActivityloginBinding
    lateinit var handler: Handler
    lateinit var registrobutton:Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityloginBinding.inflate(layoutInflater)
        //setContentView(R.layout.activitylogin)
        setContentView(binding.root)
        binding.ButtonLogin.setOnClickListener { Validar()}
        binding.BtnRegistro.setOnClickListener { enviarRegistrar()}
        registrobutton=findViewById(R.id.BtnRegistro)

    }

    fun Validar(){
        val Usuario :String=binding.TxtUser.text.toString();
        val Pass :String=binding.TxtPassword.text.toString();
        val correo:String=binding.TxtUser.text.toString()

        val pref=getSharedPreferences(Usuario,Context.MODE_PRIVATE)
        val correoE=pref.getString("Email","")
        val contrasenaE=pref.getString("clave","")
        val nombre=pref.getString("Nombre","")

        //Validaciones
        if(Usuario.isEmpty()){
            //si el usuario esta vacio
            binding.TxtUser.setHint("Ingrese el usuario")
            binding.TxtUser.setHintTextColor(Color.RED)
            Toast.makeText(this,"Ingrese su usuario", Toast.LENGTH_LONG).show()
        }   else if (Pass .isEmpty()){
                    //si el usuario esta vacio
                    binding.TxtPassword.setHint("Ingrese el Password")
                    binding.TxtPassword.setHintTextColor(Color.RED)
                    Toast.makeText(this,"Ingrese su password", Toast.LENGTH_LONG).show()
                }   //validar ingreso de prueba
                    else if (Usuario==correoE)
                            if  (Pass==contrasenaE) {
                                Toast.makeText(this,"Bienvenido.$nombre", Toast.LENGTH_LONG).show()
                                startActivity(Intent(this, HomeActivity::class.java))
                            } else {
                                        Toast.makeText(this,"Password..........", Toast.LENGTH_LONG).show()
                            }
            else{
                Toast.makeText(this,"Usuario no Existente", Toast.LENGTH_LONG).show()
            }
    }

    fun enviarRegistrar(){
        startActivity(Intent(this, RegistroActivity::class.java))





        }


}