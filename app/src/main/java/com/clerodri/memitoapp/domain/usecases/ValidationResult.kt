package com.clerodri.memitoapp.domain.usecases

data class ValidationResult(
    val successful : Boolean,
    val errorMessage : String? =null
)
