package ru.netology

import kotlin.math.max

const val LIMIT_DAY = 150_000
const val LIMIT_MONTH = 600_000
const val LIMIT_MASTERCARD_MONTH = 75_000
const val ERROR_LIMIT = -1
const val ERROR_TYPE = -2

fun main() {
    print(commission("MasterCard", 76000))
}

fun commission(typeCard: String = "Mir", amount: Int, amountOfMonth: Int = 0): Int {
    if (amount > LIMIT_DAY || amount + amountOfMonth > LIMIT_MONTH) return ERROR_LIMIT
    return when (typeCard) {
        "MasterCard" -> if (amount + amountOfMonth <= LIMIT_MASTERCARD_MONTH) 0
        else ((amount + amountOfMonth - LIMIT_MASTERCARD_MONTH) * 0.006).toInt() + 20

        "Visa" -> max(35, (amount * 0.0075).toInt())
        "Mir" -> 0
        else -> ERROR_TYPE
    }
}