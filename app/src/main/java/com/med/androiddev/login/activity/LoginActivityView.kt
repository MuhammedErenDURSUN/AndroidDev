package com.med.androiddev.login.activity

interface LoginActivityView {

    // Present tarafından View ilk oluşturma durumunda tetiklenir.
    fun initialiseView()

    // Login Fragment tarafından giris basarili ise tetiklenir.
    fun openMainActivity()

}