package com.clerodri.memitoapp.domain.usecases

import android.util.Log

class ValidateValueTodo {

    fun execute(value:String):ValidationResult{
        if(value.isBlank()){
            return ValidationResult(
                successful = false,
                errorMessage = "The value cant be blank"
            )
        }
        val parts = value.trim().split(".")
        // Validate the whole part
        if (parts[0].length > 3) return ValidationResult(
            successful = false,
            errorMessage = "The value needs to consist max 3 digits "
        )

        return ValidationResult(
            successful = true
        )
    }


    }




