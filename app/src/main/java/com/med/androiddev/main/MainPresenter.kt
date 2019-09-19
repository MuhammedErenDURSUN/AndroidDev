package com.med.androiddev.main

import com.med.androiddev.base.BasePresenter

class MainPresenter : BasePresenter<MainView>() {

    override fun initialise() {
        getView()?.initialiseView()
    }

    override fun disposeSubscriptions() {

    }

}
