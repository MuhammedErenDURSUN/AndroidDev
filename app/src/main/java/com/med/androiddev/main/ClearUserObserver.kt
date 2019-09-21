package com.med.androiddev.main

import io.reactivex.observers.DisposableCompletableObserver

// Kullanici bilgilerinin temizlenmesi isteği sonucunda tetiklenir.
class ClearUserObserver (private val presenter: MainPresenter) : DisposableCompletableObserver() {

    // Kullanici bilgilerinin temizleme islemi tamamlandi ise tetiklenir.
    override fun onComplete() {

        //Present tarafinda cikis islemi icin tetiklenir.
        presenter.logoutSuccessful()
    }

    // Kullanici bilgilerinin temizleme isteği basarisiz ise tetiklenir.
    override fun onError(e: Throwable) {
        e.printStackTrace()

    }
}