package com.example.daltonismo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var teste: Int? = intent.extras?.getInt("teste",0)
        var resposta = findViewById<EditText>(R.id.editTextResposta)
        var imagem = findViewById<ImageView>(R.id.imageView)
        var botaoOk = findViewById<Button>(R.id.buttonOk)
        var botaoCancelar = findViewById<Button>(R.id.buttonCancelar)

        when(teste){
            1 -> imagem.setImageResource(R.drawable.img)
            2 -> imagem.setImageResource(R.drawable.img_1)
            3 -> imagem.setImageResource(R.drawable.img_2)
        }

        botaoOk.setOnClickListener{
            val intent = Intent()
            val bundle = Bundle()

            bundle.putString("resposta", resposta.text.toString())
            intent.putExtras(bundle)
            setResult(RESULT_OK, intent)
            finish()
        }
        botaoCancelar.setOnClickListener {
            setResult(RESULT_CANCELED)
            finish()
        }




    }
}