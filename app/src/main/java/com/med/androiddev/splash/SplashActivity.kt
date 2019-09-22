package com.med.androiddev.splash

import android.app.AlertDialog
import android.content.Intent
import com.med.androiddev.App
import com.med.androiddev.R
import com.med.androiddev.base.BaseActivity
import com.med.androiddev.login.activity.LoginActivity
import com.med.androiddev.main.MainActivity
import com.med.androiddev.splash.di.component.DaggerSplashComponent

class SplashActivity : BaseActivity<SplashPresenter>(), SplashView {

    // Present tarafından View ilk oluşturma durumunda tetiklenir.
    override fun initialiseView() {}

    // View'ın hangi layouttan oluşacağını belirler.
    override fun getLayout(): Int = R.layout.activity_splash


    // View'ı Component'e inject eder.
    override fun initInjector() {
        DaggerSplashComponent.builder()
            .appComponent((application as App).applicationComponent)
            .build()
            .inject(this)
    }

    // LoginActivity yonlendirme.
    override fun openLoginActivity() {
        Intent(this, LoginActivity::class.java).apply {
            startActivity(this)
            finish()
        }
    }

    // MainActivity yonlendirme.
    override fun openMainActivity() {
        Intent(this, MainActivity::class.java).apply {
            startActivity(this)
            finish()
        }
    }

    override fun showAlert(messageId: Int) {
        AlertDialog.Builder(this).let {
            it.setTitle(getString(R.string.app_name))
            it.setMessage(getString(messageId))
            it.setPositiveButton(getString(R.string.alert_ok)) { _, _ -> presenter.clearUserData() }
            it.show()

        }
    }

}