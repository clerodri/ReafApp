package com.clerodri.memitoapp.domain.usecases

class ValidateValueTodo {

    fun execute(value: String): ValidationResult {
        if (value.isBlank()) {
            return ValidationResult(
                successful = false,
                errorMessage = "The QUANTITY can't be blank"
            )
        }
        val parts = value.trim().split(".")
        // Validate the whole part
        if (parts[0].length > 3) return ValidationResult(
            successful = false,
            errorMessage = "The QUANTITY needs to consist max 3 digits "
        )

        return ValidationResult(
            successful = true
        )
    }


}




