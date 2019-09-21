package com.med.androiddev.login.activity

import android.content.Intent
import com.med.androiddev.App
import com.med.androiddev.R
import com.med.androiddev.base.BaseActivity
import com.med.androiddev.login.activity.di.component.DaggerLoginActivityComponent
import com.med.androiddev.main.MainActivity

class LoginActivity : BaseActivity<LoginActivityPresenter>(), LoginActivityView {

    // Present tarafından View ilk oluşturma durumunda tetiklenir.
    override fun initialiseView() {}

    // View'ın hangi layouttan oluşacağını belirler.
    override fun getLayout(): Int = R.layout.activity_login


    // View'ı Component'e inject eder.
    override fun initInjector() {
        DaggerLoginActivityComponent.builder()
            .appComponent((application as App).applicationComponent)
            .build()
            .inject(this)
    }

    // MainActivity yonlendirme.
    override fun openMainActivity() {
        Intent(this, MainActivity::class.java).apply {
            startActivity(this)
            finish()
        }
    }

}