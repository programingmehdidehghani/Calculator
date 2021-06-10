package com.example.calcutator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    lateinit var editText: EditText
    lateinit var btn_ac:Button
    lateinit var btn_plus_mines:Button
    lateinit var btn_divider:Button
    lateinit var btn_multiolay:Button
    lateinit var btn7:Button
    lateinit var btn8:Button
    lateinit var btn9:Button
    lateinit var btn_percent:Button
    lateinit var btn4:Button
    lateinit var btn5:Button
    lateinit var btn6:Button
    lateinit var btn_plus:Button
    lateinit var btn1:Button
    lateinit var btn2:Button
    lateinit var btn3:Button
    lateinit var btn_minus:Button
    lateinit var btn0:Button
    lateinit var btn_dot:Button
    lateinit var btn_equles:Button
    var isNewOp=true
    var oldNumber=""
    var op="+"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        SetupViews();
    }

    private fun SetupViews() {
        editText=findViewById(R.id.edt)
        btn_ac=findViewById(R.id.btn_ac)
        btn_plus_mines=findViewById(R.id.btn_plus_mines)
        btn_divider=findViewById(R.id.btn_divider)
        btn_multiolay=findViewById(R.id.btn_multiolay)
        btn7=findViewById(R.id.btn7)
        btn8=findViewById(R.id.btn8)
        btn9=findViewById(R.id.btn9)
        btn_percent=findViewById(R.id.btn_percent)
        btn4=findViewById(R.id.btn4)
        btn5=findViewById(R.id.btn5)
        btn6=findViewById(R.id.btn6)
        btn_plus=findViewById(R.id.btn_plus)
        btn1=findViewById(R.id.btn1)
        btn2=findViewById(R.id.btn2)
        btn3=findViewById(R.id.btn3)
        btn_minus=findViewById(R.id.btn_minus)
        btn0=findViewById(R.id.btn0)
        btn_dot=findViewById(R.id.btn_dot)
        btn_equles=findViewById(R.id.btn_equles)

    }

    fun numberEvent(view: View) {
        if (isNewOp)
            editText.setText("")
        isNewOp=false
        var buClick:String=editText.text.toString()
        var buSelect:Button=view as Button
        when(buSelect.id){
            btn1.id->{buClick += "1"}
            btn2.id->{buClick += "2"}
            btn3.id->{buClick += "3"}
            btn4.id->{buClick += "4"}
            btn5.id->{buClick += "5"}
            btn6.id->{buClick += "6"}
            btn7.id->{buClick += "7"}
            btn8.id->{buClick += "8"}
            btn9.id->{buClick += "9"}
            btn0.id->{buClick += "0"}
            btn_dot.id->{buClick += "."}
            btn_plus_mines.id->{buClick = "-$buClick"}

        }
        editText.setText(buClick)
    }

    fun operatorEvent(view: View) {
        isNewOp=true
        oldNumber=editText.text.toString()
        var buSelect=view as Button
        when(buSelect.id){
            btn_multiolay.id->{op = "*"}
            btn_plus.id->{op = "+"}
            btn_minus.id->{op = "-"}
            btn_divider.id->{op = "/"}
        }
    }

    fun equlesEvent(view: View) {
        var newNumber:String=editText.text.toString()
        var result=0.0
        when(op){
            "+"->{result = oldNumber.toDouble() + newNumber.toDouble()}
            "*"->{result = oldNumber.toDouble() * newNumber.toDouble()}
            "/"->{result = oldNumber.toDouble() / newNumber.toDouble()}
            "-"->{result = oldNumber.toDouble() - newNumber.toDouble()}
        }
        editText.setText(result.toString())
    }

    fun acEvent(view: View) {
        editText.setText("0")
        isNewOp=true
    }

    fun percentEvent(view: View) {
        var no=editText.text.toString().toDouble()/100
        editText.setText(no.toString())
        isNewOp=true

    }
}