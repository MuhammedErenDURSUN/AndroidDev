package com.med.androiddev.main

import com.med.androiddev.base.BasePresenter
import com.med.domain.preferences.login.ClearPreferenceUseCase
import javax.inject.Inject

class MainPresenter @Inject constructor(private val clearPreferenceUseCase: ClearPreferenceUseCase) :
    BasePresenter<MainView>(), IMainPresenter {

    // Cikis islemi basarili ise tetiklenir.
    override fun logoutSuccessful() {

        // LoginActivity yonlendirme.
        getView()?.openLoginActivity()
    }

    // Cikis butonu tiklanma durumunda tetiklenir.
    override fun logoutButtonClick() {

        // Kullanici bilgilerinin temizlenmesi için atılan istek.
        clearPreferenceUseCase.execute(ClearUserObserver(this), "")
    }

    override fun initialise() {

        getView()?.initialiseView()

    }

    override fun disposeSubscriptions() { }

}
