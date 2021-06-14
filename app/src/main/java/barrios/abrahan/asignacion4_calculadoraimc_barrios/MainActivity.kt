package barrios.abrahan.asignacion4_calculadoraimc_barrios

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var peso= 0.0
    var altura= 0.0
    var imc= 0.0
    var range: String? =null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtPeso: EditText = findViewById(R.id.weight)
        val txtAltura: EditText = findViewById(R.id.height)
        val btnCalcular: Button = findViewById(R.id.btnCalcular)
        val txtImc: TextView = findViewById(R.id.txtImc)
        val txtRange: TextView = findViewById(R.id.txtRange)

        btnCalcular.setOnClickListener {
            var temp: String = txtPeso.text.toString();
            if(!temp.equals("")){
                peso= temp.toDouble()

                temp= txtAltura.text.toString()
                if(!temp.equals("")){
                    altura= temp.toDouble()

                    imc=calcularImc()
                    txtImc.setText(imc.toString().substring(0,8))

                    range=calcularRange()
                    txtRange.setText(range.toString())

                    when(range){
                        "Bajo Peso" -> txtRange.setBackgroundResource(R.color.colorGreen)
                        "Normal" -> txtRange.setBackgroundResource(R.color.colorGreenish)
                        "Sobrepeso" -> txtRange.setBackgroundResource(R.color.colorYellow)
                        "Obesidad grado 1" -> txtRange.setBackgroundResource(R.color.colorOrange)
                        "Obesidad grado 2" -> txtRange.setBackgroundResource(R.color.colorRed)
                        "Obesidad grado 3" -> txtRange.setBackgroundResource(R.color.colorBrown)
                    }
                }else{
                    print("No se ha ingresado altura")
                }
            }else{
                print("No se ha ingresado peso")
            }




        }

    }

    fun calcularImc(): Double {

        var a: Double= altura/100
        var b:Double=a*a
        var c: Double= peso/b

        return c
    }

    fun calcularRange():String? {
        var i: Double = calcularImc()

        var r: String?=null

        if (i < 18.5) {
            r = "Bajo Peso"
        } else if (i >= 18.5 && i < 24.9) {
            r = "Normal"
        } else if (i >= 25 && i < 29.9) {
            r = "Sobrepeso"
        } else if (i >= 30 && i < 34.9) {
            r = "Obesidad grado 1"
        } else if (i >= 35 && i < 39.9) {
            r = "Obesidad grado 2"
        } else if (i >= 40) {
            r = "Obesidad grado 3"
        }

           return r
        }
}