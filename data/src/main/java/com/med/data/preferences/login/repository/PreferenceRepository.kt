package com.med.data.preferences.login.repository

import android.content.Context
import android.content.SharedPreferences
import com.med.data.preferences.PreferenceHelper
import com.med.data.preferences.login.model.User
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.subjects.BehaviorSubject
import javax.inject.Inject

class PreferenceRepository @Inject constructor(context: Context) : PreferenceHelper {

    // Kullanici bilgilerinin kaydedilmesi isteği sonucunda tetiklenir.
    override fun saveUser(user: User): Completable {
        return prefSubject
                .firstOrError()
                .editSharedPreferences {
                    putString(KEY_USERNAME, user.userName)
                    putString(KEY_PASSWORD, user.userPassword)
                }
    }

    // Kullanici bilgilerinin getirilmesi isteği sonucunda tetiklenir.
    override fun getUser(): Observable<User> = prefSubject
        .map { User(userName = it.getString(KEY_USERNAME, ""), userPassword = it.getString(KEY_PASSWORD, ""))  }

    val preferences: SharedPreferences =
        context.getSharedPreferences("RxPrefs", Context.MODE_PRIVATE)

    private val prefSubject = BehaviorSubject.createDefault(preferences)

    private val prefChangeListener =
        SharedPreferences.OnSharedPreferenceChangeListener { sharedPreferences, _ ->
            prefSubject.onNext(sharedPreferences)
        }

    companion object {
        private const val KEY_USERNAME = "username_key"
        private const val KEY_PASSWORD = "password_key"
    }

    init {
        preferences.registerOnSharedPreferenceChangeListener(prefChangeListener)
    }

    // Kullanici bilgilerinin temizleme isteği sonucunda tetiklenir.
    override fun clear(): Completable {
        return prefSubject.firstOrError()
            .clearSharedPreferences {
                remove(KEY_USERNAME)
                remove(KEY_PASSWORD)
            }
    }

    private fun Single<SharedPreferences>.editSharedPreferences(batch: SharedPreferences.Editor.() -> Unit): Completable =
        flatMapCompletable {
            Completable.fromAction {
                it.edit().also(batch).apply()
            }
        }

    private fun Single<SharedPreferences>.clearSharedPreferences(batch: SharedPreferences.Editor.() -> Unit): Completable =
        flatMapCompletable {
            Completable.fromAction {
                it.edit().also(batch).apply()
            }
        }

}