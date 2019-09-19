package com.med.androiddev.main

import com.med.androiddev.App
import com.med.androiddev.R
import com.med.androiddev.base.BaseActivity
import com.med.androiddev.main.di.component.DaggerMainComponent

class MainActivity : BaseActivity<MainPresenter>(), MainView {

    // Present tarafından View ilk oluşturma durumunda tetiklenir.

    override fun initialiseView() {

    }

    // View'ın hangi layouttan oluşacağını belirler.

    override fun getLayout(): Int = R.layout.activity_main


    // View'ı Component'e inject eder.

    override fun initInjector() {
        DaggerMainComponent.builder()
            .appComponent((application as App).applicationComponent)
            .build()
            .inject(this)
    }


}