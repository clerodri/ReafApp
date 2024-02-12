package com.clerodri.memitoapp.domain.usecases

class ValidateValueTodo {

    fun execute(value:String):ValidationResult{
        if(value.length > 6){
                return ValidationResult(
                    successful = false,
                    errorMessage = "The value needs to consist max 6 digits "
                )
        }
        val containsDigits = value.any{ it.isDigit() }
        if(!containsDigits){
            return ValidationResult(
                successful = false,
                errorMessage = "The value needs to contain only numbers"
            )
        }
        return ValidationResult(
            successful = true
        )

    }



}