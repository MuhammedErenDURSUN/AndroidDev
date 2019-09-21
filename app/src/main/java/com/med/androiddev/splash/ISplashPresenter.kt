package com.med.androiddev.splash

import com.med.domain.preferences.login.model.UserDto

interface ISplashPresenter {

    // Kullanici bilgilerinin getirilmesi isteği basarili ve veri var ise tetiklenir.
    fun autoLoginControl(userDto: UserDto)

}