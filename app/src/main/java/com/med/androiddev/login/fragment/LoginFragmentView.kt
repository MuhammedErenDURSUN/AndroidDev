package com.med.androiddev.login.fragment

interface LoginFragmentView {

    fun initialiseView()

    // Kullaniciya uyari gosterilmesi durumunda tetiklenir.
    fun showAlert(messageId: Int)

    // Giris islemlerinden yanit beklenirken tetiklenir.
    fun showProgressBar(progressVisibility: Int, buttonVisibility: Int)

    // Giris islemi basarili ise tetiklenir.
    fun loginSuccess()

}