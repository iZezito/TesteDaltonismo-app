package com.example.daltonismo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.databinding.DataBindingUtil
import com.example.daltonismo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var testeDaltonismo = TesteDaltonismo("","","")

    lateinit var binding:ActivityMainBinding
    val setResposta1Launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            result ->

        if(result.resultCode == RESULT_OK){
            testeDaltonismo.resp1 = result.data!!.getStringExtra("resposta").toString()

        }

    }
    val setResposta2Launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            result ->
        if(result.resultCode == RESULT_OK){
            testeDaltonismo.resp2 = result.data!!.getStringExtra("resposta").toString()

        }

    }
    val setResposta3Launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            result ->
        if(result.resultCode == RESULT_OK){
            testeDaltonismo.resp3 = result.data!!.getStringExtra("resposta").toString()

        }

    }





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)


        binding.buttonTeste1.setOnClickListener{

            val intent = Intent(this, MainActivity2::class.java)
            val b = Bundle()
            b.putInt("teste",1)
            intent.putExtras(b)
            setResposta1Launcher.launch(intent)
        }
        binding.buttonTeste2.setOnClickListener{

            val intent = Intent(this, MainActivity2::class.java)
            val b = Bundle()
            b.putInt("teste",2)
            intent.putExtras(b)
            setResposta2Launcher.launch(intent)
        }
        binding.buttonTeste3.setOnClickListener{

            val intent = Intent(this, MainActivity2::class.java)
            val b = Bundle()
            b.putInt("teste",3)
            intent.putExtras(b)
            setResposta3Launcher.launch(intent)
        }

        binding.button4.setOnClickListener {
            var acertos = 0
            if(testeDaltonismo.resp1.equals("") || testeDaltonismo.resp2.equals("") || testeDaltonismo.resp3.equals("")){
                Toast.makeText(this, "Faça primeiro todos os testes", Toast.LENGTH_SHORT).show()
            }else{
                if(testeDaltonismo.resp1.equals("29")) acertos++
                if (testeDaltonismo.resp2.equals("74")) acertos++
                if(testeDaltonismo.resp3.equals("2")) acertos++

                if(acertos < 3){
                    binding.textViewResultado.text = "Procure um oftamologista!"
                }else{
                    binding.textViewResultado.text="Você não possui daltonismo!"
                }
            }
        }

    }

    override fun onResume() {
        super.onResume()
        binding.testeDaltonismo = testeDaltonismo
    }
}