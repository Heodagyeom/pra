package com.example.myapplication.main.MainKt

import com.example.myapplication.main.AddOperation
import com.example.myapplication.main.Calculator
import com.example.myapplication.main.DivideOperation
import com.example.myapplication.main.MultiplyOperation
import com.example.myapplication.main.SubstractOperation
import java.util.Calendar
import kotlin.reflect.typeOf

fun main() {
    println("++++++++++++++++++++++++++++++++++++++++")
    println("+           계산기를 시작합니다            +")
    println("++++++++++++++++++++++++++++++++++++++++")
    while (true) {
        var a : Double
        while(true) {
            try {print("첫 번 째 숫자를 입력해주세요   ")
                a = readLine()!!.toDouble()
                break
            } catch(a:java.lang.NumberFormatException) {
                println("  숫 자 만 입 력 해 주 세 요  ")

            }
        }

        print("연 산 기 호 를  입력해주세요  ")
        var operator = readLine().toString()
        var b  : Double
        while(true) {
            try {print("두 번 째 숫자를 입력해주세요   ")
                b = readLine()!!.toDouble()
                break
            } catch(a:java.lang.NumberFormatException) {
                println("  숫 자 만 입 력 해 주 세 요  ")

            }
        }

        when (operator) {
            "+" -> {
                val addCalc = Calculator(AddOperation()).operation(a, b)
                println("${a} + ${b} = ${addCalc}")
            }

            "-" -> {
               val divCalc = Calculator(DivideOperation()).operation(a, b)
                println("${a} + ${b} = ${divCalc}")
            }

            "*" -> {
                val mulCalc = Calculator(MultiplyOperation()).operation(a, b)
                println("${a} + ${b} = ${mulCalc}")
            }

            "/" -> {
                val subCalc = Calculator(SubstractOperation()).operation(a, b)
                println("${a} + ${b} = ${subCalc}")
            }

            else -> {
                println("입력값이 올바르지 않습니다. 다시 입력 해주세요")
                continue
            }
        }

//        if (operator == "+"){
//            println("${a} + ${b} = ${AddOperation().operate(a, b)}")
//        } else if (operator == "-") {
//            println("${a} - ${b} = ${DivideOperation().operate(a, b)}")
//        } else if (operator == "*") {
//            println("${a} * ${b} = ${MultiplyOperation().operate(a, b)}")
//        } else if (operator == "/") {
//            println("${a} / ${b} = ${SubstractOperation().operate(a, b)}")
//        }

        println("계산기를 그만 종료하시겠습니까? 아무버튼 = 계속, 2 = 종료")
        var e = readLine()!!.toInt()
        if (e == 2) {
            println("종료합니다")
            break
        } else continue
    }
}




