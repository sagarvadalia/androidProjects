package com.example.mvctipcalculator

class TipCalculator(total: Double, tipPercent: Double) {
    var total: Double = 0.0
        set(value){
            field = value
            totalTip = total * tipPercent
            finalTotal = total + totalTip
        }
    var tipPercent: Double = 0.0
        set(value){
            field = value
            totalTip = total * tipPercent
            finalTotal = total + totalTip
        }

    var finalTotal: Double = 0.0
    var totalTip: Double = 0.0


}