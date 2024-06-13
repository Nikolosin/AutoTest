package ru.netology

import org.junit.Test

import org.junit.Assert.*


class MainKtTest {

    @Test
    fun commission_LimitDay() {
        val amount = 200_000
        val result = commission(amount = amount)
        assertEquals(-1, result)
    }

    @Test
    fun commission_LimitMonth() {
        val amount = 100_000
        val amountOfMonth = 550_000
        val result = commission(amount = amount, amountOfMonth = amountOfMonth)
        assertEquals(-1, result)
    }

    @Test
    fun commission_Mir() {
        val amount = 100_000
        val result = commission(amount = amount)
        assertEquals(0, result)
    }

    @Test
    fun commission_Visa() {
        val type = "Visa"
        val amount = 100_000
        val result = commission(typeCard = type, amount = amount)
        assertEquals(750, result)
    }

    @Test
    fun commission_MasterCard() {
        val type = "MasterCard"
        val amount = 100_000
        val result = commission(typeCard = type, amount = amount)
        assertEquals(170, result)
    }

    @Test
    fun commission_MasterCard_lowLimit() {
        val type = "MasterCard"
        val amount = 70_000
        val result = commission(typeCard = type, amount = amount)
        assertEquals(0, result)
    }

    @Test
    fun commission_Maestro() {
        val type = "Maestro"
        val amount = 100_000
        val result = commission(typeCard = type, amount = amount)
        assertEquals(-2, result)
    }


}