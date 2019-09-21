package com.med.androiddev.main

import android.app.AlertDialog
import android.content.Intent
import android.view.View
import com.med.androiddev.App
import com.med.androiddev.R
import com.med.androiddev.base.BaseActivity
import com.med.androiddev.login.activity.LoginActivity
import com.med.androiddev.main.di.component.DaggerMainComponent
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainPresenter>(), MainView {

    private val TAG = "MAIN"

    // Present tarafından View ilk oluşturma durumunda tetiklenir.
    override fun initialiseView() {

        mainAppbar.isActivated = true

        logoutButton.apply {
            this.setOnClickListener {
                showAlert(R.string.logout_message)
            }
        }
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

    // LoginActivity yonlendirme.
    override fun openLoginActivity() {
        Intent(this, LoginActivity::class.java).apply {
            startActivity(this)
            finish()
        }
    }

    fun showAlert(messageId: Int) {
        AlertDialog.Builder(this).let {
            it.setTitle(getString(R.string.app_name))
            it.setMessage(getString(messageId))
            it.setNegativeButton(getString(R.string.alert_no)) { _, _ -> }
            it.setPositiveButton(getString(R.string.alert_yes)) { _, _ ->   presenter.logoutButtonClick()}
            it.show()
        }
    }

}