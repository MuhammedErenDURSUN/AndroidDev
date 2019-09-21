package com.med.androiddev.login.fragment

import android.app.AlertDialog
import android.view.View
import com.med.androiddev.App
import com.med.androiddev.R
import com.med.androiddev.base.BaseFragment
import com.med.androiddev.login.activity.LoginActivityView
import com.med.androiddev.login.fragment.di.component.DaggerLoginFragmentComponent
import com.med.domain.preferences.login.model.UserDto
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : BaseFragment<LoginFragmentPresenter>(), LoginFragmentView {

    private val TAG = "LOGIN"

    private lateinit var fragmentCallback: LoginActivityView

    // View'ın hangi layouttan oluşacağını belirler.
    override fun getLayout(): Int = R.layout.fragment_login

    // View'ı Component'e inject eder.
    override fun initInjector() {
        DaggerLoginFragmentComponent.builder()
            .appComponent((context!!.applicationContext as App).applicationComponent)
            .build()
            .inject(this)
    }

    // Present tarafından View ilk oluşturulma durumunda tetiklenir.
    override fun initialiseView() {
        fragmentCallback = context as LoginActivityView

        loginButton.apply {
            this.setOnClickListener {
                presenter.loginButtonClick(
                    userDto = UserDto(
                        userName = userName.text.toString(),
                        userPassword = userPassword.text.toString()
                    ), rememberMe = rememberMe.isChecked
                )
            }
        }
    }

    override fun showAlert(messageId: Int) {

        showProgressBar(View.INVISIBLE, View.VISIBLE)

        AlertDialog.Builder(context).let {
            it.setTitle(context?.getString(R.string.app_name))
            it.setMessage(context?.getString(messageId))
            it.setNegativeButton(getString(R.string.alert_ok)) { _, _ -> }
            it.show()
        }
    }

    // Yukleniyor simgesini gosterir veya gizler.
    override fun showProgressBar(progressVisibility: Int, buttonVisibility: Int) {
        loginProgressBar.apply {
            this.visibility = progressVisibility
        }
        loginButton.apply {
            this.visibility = buttonVisibility
        }
    }

    // Giris basarili ise Main Activity'e yonlendirilir
    override fun loginSuccess() {
        fragmentCallback.openMainActivity()
    }

}