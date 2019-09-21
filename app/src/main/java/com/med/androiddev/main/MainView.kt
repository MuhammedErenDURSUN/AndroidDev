package com.med.androiddev.main

interface MainView {

    // Present tarafından View ilk oluşturma durumunda tetiklenir.
    fun initialiseView()

    // Present tarafından cikis basarili ise tetiklenir.
    fun openLoginActivity()
}