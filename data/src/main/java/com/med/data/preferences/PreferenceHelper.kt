package com.med.data.preferences

import com.med.data.preferences.login.model.User
import io.reactivex.Completable
import io.reactivex.Observable

interface PreferenceHelper {

    // Kullanici bilgilerinin kaydedilmesi isteği sonucunda tetiklenir.
    fun saveUser(user: User): Completable

    // Kullanici bilgilerinin getirilmesi isteği sonucunda tetiklenir.
    fun getUser(): Observable<User>

    // Kullanici bilgilerinin temizleme isteği sonucunda tetiklenir.
    fun clear(): Completable

}