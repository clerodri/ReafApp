package com.clerodri.memitoapp.util

object FormateValue {
    fun validateAndFormatNumber(input: String): String {
        val parts = input.trim().split(".")

        return when (parts.size) {
            1 -> {
                // If there's no decimal part, add ".00" to the whole part
                "${parts[0]}.00"
            }
            2 -> {
                // If there is a decimal part and it's longer than 2 digits, truncate it to 2 digits
                val decimalPart = if (parts[1].length > 2) parts[1].substring(0, 2) else parts[1]
                // Ensure the decimal part has exactly two digits
                "${parts[0]}.${decimalPart.padEnd(2, '0')}"
            }
            else -> ""
        } // Invalid input format
    }
}