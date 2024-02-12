package com.clerodri.memitoapp.domain.usecases

import android.util.Log

class ValidateTodoName {

    fun execute(todoName:String):ValidationResult{

        if(todoName.isBlank()){
            Log.d("VALIDATION", "NOMBRE VACIO")
            return ValidationResult(
                    successful = false,
                    errorMessage = "The name cant be blank"
                )
        }
        if(todoName.length > 8) {
            return ValidationResult(
                successful = false,
                errorMessage = "The name needs to consist only 8 characters"
            )
        }
        return ValidationResult(
            successful = true,
            errorMessage = null
        )

    }



}