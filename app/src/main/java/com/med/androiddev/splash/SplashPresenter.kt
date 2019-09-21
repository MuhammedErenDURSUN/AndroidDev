package com.med.androiddev.splash

import com.med.androiddev.base.BasePresenter
import com.med.domain.preferences.login.GetPreferenceUseCase
import com.med.domain.preferences.login.model.UserDto
import javax.inject.Inject

class SplashPresenter @Inject constructor(private val getPreferenceUseCase: GetPreferenceUseCase) :
    BasePresenter<SplashView>(), ISplashPresenter {

    // Kullanici bilgilerinin getirilmesi isteği basarili ve veri var ise tetiklenir.
    override fun autoLoginControl(userDto: UserDto) {
        userDto.let {

            // Kullanici bilgilerinin dolu olarak gelmesine gore activity yonlendirilmesi.
            if (it.userName!!.isNotEmpty() && it.userPassword!!.isNotEmpty()) {
                getView()?.openMainActivity()
            } else {
                getView()?.openLoginActivity()
            }
        }
    }

    override fun initialise() {

        getView()?.initialiseView()

        // Kullanici bilgilerinin getirilmesi için atılan istek.
        getPreferenceUseCase.execute(GetUserObserver(this), "")
    }

    override fun disposeSubscriptions() {}

}