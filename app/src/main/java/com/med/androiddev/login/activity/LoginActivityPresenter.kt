package com.med.androiddev.login.activity

import com.med.androiddev.base.BasePresenter

class LoginActivityPresenter : BasePresenter<LoginActivityView>() {

    override fun initialise() {
        getView()?.initialiseView()
    }

    override fun disposeSubscriptions() {}

}