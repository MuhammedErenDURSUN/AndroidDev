package com.med.androiddev.login.fragment

import io.reactivex.observers.DisposableCompletableObserver

// Kullanici bilgilerinin kaydedilmesi isteği sonucunda tetiklenir.
class EditUserObserver (private val presenter: LoginFragmentPresenter) : DisposableCompletableObserver() {

    // Kullanici bilgilerinin kaydedilmesi islemi tamamlandi ise tetiklenir.
    override fun onComplete() {

        //Present tarafinda kaydetme tamamlandi tetiklenir.
        presenter.editUserComplete()

    }

    // Kullanici bilgilerinin kaydedilmesi isteği basarisiz ise tetiklenir.
    override fun onError(e: Throwable) {
        e.printStackTrace()
    }

}