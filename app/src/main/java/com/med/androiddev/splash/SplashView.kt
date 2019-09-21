package com.med.androiddev.splash

interface SplashView {

    // Present tarafından View ilk oluşturma durumunda tetiklenir.
    fun initialiseView()

    // Present tarafından auto login aktif degil ise tetiklenir.
    fun openLoginActivity()


    // Present tarafından auto login aktif ise tetiklenir.
    fun openMainActivity()
}