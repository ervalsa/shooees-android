package com.sepatu.shooees.utils

import java.text.NumberFormat
import java.util.*

fun String.withCurrencyFormat(): String {
    val rupiahExchangeRate = 123495.95
    val euroExchangeRate = 0.88

    var priceOnDollar = this.toDouble() / rupiahExchangeRate

    var mCurrencyFormat = NumberFormat.getCurrencyInstance()
    val deviceLocale = Locale.getDefault().country

    when {
        deviceLocale.equals("ES") -> {
            priceOnDollar *= rupiahExchangeRate
        }

        deviceLocale.equals("ID") -> {
            priceOnDollar *= rupiahExchangeRate
        }

        else -> {
            mCurrencyFormat = NumberFormat.getCurrencyInstance(Locale.US)
        }
    }

    return mCurrencyFormat.format(priceOnDollar)
}