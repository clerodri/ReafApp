package com.clerodri.memitoapp

import dagger.hilt.android.testing.CustomTestApplication

@CustomTestApplication(AbstractApplication::class)
interface CustomTestApplicationForHilt {
}