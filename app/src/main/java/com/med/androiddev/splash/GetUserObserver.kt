package com.med.androiddev.splash

import com.med.domain.preferences.login.model.UserDto
import io.reactivex.observers.DisposableObserver

// Kullanici bilgilerinin getirilmesi isteği sonucunda tetiklenir.
class GetUserObserver(private val presenter: SplashPresenter) : DisposableObserver<UserDto>() {

    // Kullanici bilgilerinin getirilmesi islemi tamamlandi ise tetiklenir.
    override fun onComplete() {}

    // Kullanici bilgilerinin getirilmesi isteği basarili ve veri var ise tetiklenir.
    override fun onNext(t: UserDto) {

        // Present tarafina kullanici bilgileri gonderilir.
        presenter.autoLoginControl(t,state=true)
    }

    // Kullanici bilgilerinin getirilmesi isteği basarisiz ise tetiklenir.
    override fun onError(e: Throwable) {
        e.printStackTrace()
    }
}
