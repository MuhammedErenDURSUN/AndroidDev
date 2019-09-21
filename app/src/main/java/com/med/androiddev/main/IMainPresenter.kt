package com.med.androiddev.main

interface IMainPresenter {

    // Cikis butonu tiklanma durumunda tetiklenir.
    fun logoutButtonClick()

    // Cikis islemi basarili ise tetiklenir.
    fun logoutSuccessful()
}