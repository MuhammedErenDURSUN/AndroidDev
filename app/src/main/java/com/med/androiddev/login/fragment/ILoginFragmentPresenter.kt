package com.med.androiddev.login.fragment

import com.med.domain.preferences.login.model.UserDto

interface ILoginFragmentPresenter {

    // Giris butonu tiklanma durumunda tetiklenir.
    fun loginButtonClick(userDto: UserDto, rememberMe: Boolean)


    // Kullanici bilgilerinin kaydedilmesi islemi tamamlandi ise tetiklenir.
    fun editUserComplete()
}