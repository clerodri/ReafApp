package com.clerodri.memitoapp.domain.usecases

import android.util.Log
import androidx.core.text.isDigitsOnly

class ValidateTodoName {

    fun execute(todoName:String):ValidationResult{

        if(todoName.isBlank()){
            Log.d("VALIDATION", "NOMBRE VACIO")
            return ValidationResult(
                    successful = false,
                    errorMessage = "The NAME can't be blank"
                )
        }
        val hasDigits = todoName.any { it.isDigit() }
        if(hasDigits){
            return ValidationResult(
                successful = false,
                errorMessage = "The NAME can't contains Numbers"
            )
        }
        if(todoName.length > 8) {
            return ValidationResult(
                successful = false,
                errorMessage = "The NAME needs to consist only 8 characters"
            )
        }
        return ValidationResult(
            successful = true,
            errorMessage = null
        )

    }



}