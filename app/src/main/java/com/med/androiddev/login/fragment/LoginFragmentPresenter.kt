package com.med.androiddev.login.fragment

import android.util.Log
import android.view.View
import com.med.androiddev.R
import com.med.androiddev.base.BasePresenter
import com.med.domain.preferences.login.EditPreferenceUseCase
import com.med.domain.preferences.login.model.UserDto
import javax.inject.Inject

class LoginFragmentPresenter @Inject constructor(
    private val editPreferenceUseCase: EditPreferenceUseCase
) : BasePresenter<LoginFragmentView>(), ILoginFragmentPresenter {

    // Beni Hatirla.
    var rememberMe: Boolean = false

    override fun initialise() {
        Log.i("Login", "initialise")
        getView()?.initialiseView()
    }

    override fun disposeSubscriptions() {}

    // Giris butonu tiklanma durumunda tetiklenir.
    override fun loginButtonClick(userDto: UserDto, rememberMe: Boolean) {
        Log.i("Login", "loginButton")
        getView()?.showProgressBar(View.VISIBLE, View.INVISIBLE)
        this.rememberMe = rememberMe
        loginControl(userDto)
    }

    private fun loginControl(userDto: UserDto) {
        Log.i("Login", "loginControl")
        userDto.let {
            if (it.userName.isNullOrBlank() || it.userPassword.isNullOrBlank()) {
                getView()?.showAlert(R.string.empty_message)
            } else {

                // Isleyis: Giris icin kullanici bilgileri servise gonderilir
                loginResponse(userDto)
            }
        }
    }

    // Isleyis: Servis tarafindan gelen yanit
    fun loginResponse(userDto: UserDto) {
        Log.i("Login", "loginResponse $userDto")

        userDto.let {

            // Isleyis: Servis tarafindan sorgulanan kullanici var ise
            if (it.userName?.trim() == "kariyer" && it.userPassword?.trim() == "2019ADev") {

                // Beni Hatirla secildi ise Kullanici bilgilerinin kaydedilmesi icin atilan istek.
                if (rememberMe) {
                    editPreferenceUseCase.execute(EditUserObserver(this), userDto)
                } else {

                    // Beni Hatirla secilmedi ise direkt olarak MainActivity'e yonlendirilir
                    getView()?.loginSuccess()
                }
            } else {
                getView()?.showAlert(R.string.incorrect_message)
            }
        }
    }

    // Kullanici bilgilerinin kaydedilmesi basarili ise tetkilenir
    override fun editUserComplete() {

        // MainActivity'e yonlendirilir
        getView()?.loginSuccess()
    }

}