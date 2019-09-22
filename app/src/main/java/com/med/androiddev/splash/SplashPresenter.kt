package com.med.androiddev.splash

import android.util.Log
import com.med.androiddev.R
import com.med.androiddev.base.BasePresenter
import com.med.domain.preferences.login.ClearPreferenceUseCase
import com.med.domain.preferences.login.GetPreferenceUseCase
import com.med.domain.preferences.login.model.UserDto
import javax.inject.Inject

class SplashPresenter @Inject constructor(
    private val getPreferenceUseCase: GetPreferenceUseCase,
    private val clearPreferenceUseCase: ClearPreferenceUseCase
) :
    BasePresenter<SplashView>(), ISplashPresenter {

    // Kullanici bilgilerinin temizlenmesi için atılan istek.
    override fun clearUserData() {
        clearPreferenceUseCase.execute(ClearUserObserver(this), "")
    }

    // Cikis istegi sonucunda tetiklenir.
    override fun logoutResponse() {
        getView()?.openLoginActivity()
    }

    override fun initialise() {

        getView()?.initialiseView()

        // Kullanici bilgilerinin getirilmesi için atılan istek.
        getPreferenceUseCase.execute(GetUserObserver(this), "")
    }

    override fun disposeSubscriptions() {}

    // Kullanici bilgilerinin getirilmesi isteği basarili ve veri var ise tetiklenir.
    override fun autoLoginControl(userDto: UserDto,state:Boolean) {
        Log.i("Splash", "autoLoginControl")
        userDto.let {

            // Kullanici bilgilerinin dolu olarak gelmesine gore activity yonlendirilmesi.
            if (it.userName!!.isNotEmpty() && it.userPassword!!.isNotEmpty()) {
                // Isleyis: Auto Login icin kullanici bilgileri servise gonderilir. Kullanici kayit olduktan sonra baska platformdan bilgilerini degistirme durumu icin servis kontrolu
                loginResponse(userDto)
            } else {
                getView()?.openLoginActivity()
            }
        }
    }

    // Isleyis: Servis tarafindan gelen yanit
    fun loginResponse(userDto: UserDto) {
        Log.i("Splash", "loginResponse")

        userDto.let {

            // Isleyis: Servis tarafindan sorgulanan kullanici var ise
            if (it.userName?.trim() == "kariyer" && it.userPassword?.trim() == "2019ADev") {
                Log.i("Splash", "Kullanici kayitli")
                getView()?.openMainActivity()
            } else {
                Log.i("Splash", "Kullanici bilgileri degistirilmis")
                // Kullanici bilgilerinin temizlenmesi için atılan istek.
                getView()?.showAlert(R.string.autologin_message)
            }
        }
    }
}