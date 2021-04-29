package com.example.myapplication


import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import android.widget.Toast
import net.objecthunter.exp4j.Expression
import net.objecthunter.exp4j.ExpressionBuilder
import org.w3c.dom.Text
import java.lang.Exception

class MainActivity : Activity() {




    private var math:TextView?=null
    private var result:TextView?=null


    val myArray = arrayOf("-","+","*","/")
    val myArray2 = arrayOf("-","+","*","/","(",")")
    val myArray3 = arrayOf("-","+","*","/","(")
    val chisla =arrayOf("0","1","2","3","4","5","6","7","8","9")
    val chisla2 =arrayOf("0","1","2","3","4","5","6","7","8","9",".","s","i","n","c","o")





    private var isNewOp = true
    var dot = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var math2 = math
        math2 = findViewById(R.id.math_Operation)

        var result2 = result
        result2 = findViewById(R.id.result)

        var button1:TextView?=null
        button1= findViewById(R.id.number_1)
        button1.setOnClickListener{
            setText("1")
        }
        var button0:TextView?=null
        button0= findViewById(R.id.number_0)
        button0.setOnClickListener{
            val str = math2.text.toString()
            setText("0")

        }
        var button2:TextView?=null
        button2= findViewById(R.id.number_2)
        button2.setOnClickListener{
            setText("2")
        }
        var button3:TextView?=null
        button3= findViewById(R.id.number_3)
        button3.setOnClickListener{
            setText("3")
        }
        var button4:TextView?=null
        button4= findViewById(R.id.number_4)
        button4.setOnClickListener{
            setText("4")
        }
        var button5:TextView?=null
        button5= findViewById(R.id.number_5)
        button5.setOnClickListener{
            setText("5")
        }
        var button6:TextView?=null
        button6= findViewById(R.id.number_6)
        button6.setOnClickListener{
            setText("6")
        }
        var button7:TextView?=null
        button7= findViewById(R.id.number_7)
        button7.setOnClickListener{
            setText("7")
        }
        var button8:TextView?=null
        button8= findViewById(R.id.number_8)
        button8.setOnClickListener{
            setText("8")
        }
        var button9:TextView?=null
        button9= findViewById(R.id.number_9)
        button9.setOnClickListener{
            setText("9")
        }
        var buttonRavno:TextView?=null
        buttonRavno= findViewById(R.id.Ravno)
        buttonRavno.setOnClickListener{
            try {
                val str = math2?.text.toString()
                val ex = ExpressionBuilder(math2.text.toString()).build()
                val result3 = ex.evaluate()

                val longRes = result3.toLong()
                if(result3==longRes.toDouble())
                    result2.text = longRes.toString()
                else
                    result2.text = result3.toString()
            }catch (e:Exception){
                Log.d("Ошибка", "сообщение:${e.message}")

                Toast.makeText(this,"Не не не ?",Toast.LENGTH_SHORT).show()

            }



        }
        var buttonYmn:TextView?=null
        buttonYmn= findViewById(R.id.Ymn)
        buttonYmn.setOnClickListener{
                setText("*")
        }
        var buttonDel:TextView?=null
        buttonDel= findViewById(R.id.Del)
        buttonDel.setOnClickListener{
            setText("/")
        }
        var buttonMinus:TextView?=null
        buttonMinus= findViewById(R.id.Minus)
        buttonMinus.setOnClickListener{
            setText("-")
        }
        var buttonPlus:TextView?=null
        buttonPlus= findViewById(R.id.Plus)
        buttonPlus.setOnClickListener{
            setText("+")
        }
        var buttonLefttScobka:TextView?=null
        buttonLefttScobka= findViewById(R.id.LeftScobka)
        buttonLefttScobka.setOnClickListener{
            setText("(")
        }
        var buttonRightScobka:TextView?=null
        buttonRightScobka= findViewById(R.id.RightScobka)
        buttonRightScobka.setOnClickListener{
            val str = math2?.text.toString()
            var n: Int = 0
            var i: Int = 0
            var go = emptyArray<String>()
            while (n in 0..str.length) {
                var skobka: String = str.substring(0, str.length - n)
                if (skobka.isNotEmpty()){
                    if (chisla2.contains(skobka.last().toString())||myArray.contains(skobka.last().toString())){
                        n++
                    }
                    else{
                        if(skobka.last().toString() == "("){
                            i++
                            n++
                        }
                        else{
                            if(skobka.last().toString() == ")"){
                                i--
                                n++
                            }
                        }
                    }

                }
                else break
            }
            if(i>0) {
                go += "true"
            }
            else go+= "false"
            if (str.isNotEmpty() && myArray3.contains(str.last().toString())){
                go+= "false"
            }
            if (go.contains("false")){
                setText("")
            }
            else setText(")")
        }
        var buttonGoBack:TextView?=null
        buttonGoBack= findViewById(R.id.GoBack)
        buttonGoBack.setOnClickListener{
            val str = math2.text.toString()
            if(str.isNotEmpty()){
                math2.text = str.substring(0, str.length-1)
                result2.text = ""
            }
        }
        var buttonAC:TextView?=null
        buttonAC= findViewById(R.id.AC)
        buttonAC.setOnClickListener{
            math2.text = ""
            result2.text = ""

        }
        var  buttonTochka:TextView?=null
        buttonTochka= findViewById(R.id.Tochka)
        buttonTochka.setOnClickListener{
            val str = math2?.text.toString()
            var proverka = emptyArray<String>()
            var n:Int = 0
            var i:Int = 0
            while (n in 0..str.length){
                var tochka:String =str.substring(0, str.length - n)
                if (tochka.isNotEmpty()) {
                    if (chisla.contains(tochka.last().toString())) {
                        proverka += "true"
                        n++
                        i++
                    } else {
                        if (myArray2.contains(tochka.last().toString()) && i > 0) {
                            proverka += "true"
                            break
                        } else {
                            if (tochka.last().toString() == ".") {
                                proverka += "false"
                                break
                            }
                            else{
                                proverka +="false"
                                break
                            }
                        }
                    }
                }
                else{
                    if(i==0){
                        proverka += "false"
                        break
                    }
                    else{
                        proverka += "true"
                        break
                    }
                }
            }
            if (proverka.contains("false")){
                setText("")
            }
            else{
                setText(".")
            }
        }


    }

    fun setText(str : String){
        var math1 = math
        math1 = findViewById(R.id.math_Operation)
        math1.append(str)
    }

}