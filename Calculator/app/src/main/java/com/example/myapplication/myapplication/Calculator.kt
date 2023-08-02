package com.example.myapplication.main

 class Calculator (val operate1: AbstractOperation)  {
     fun operation(a: Double, b : Double) : Double {
         return operate1.operate(a,b)
     }
}