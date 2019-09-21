package com.med.domain.preferences.login


import com.med.data.preferences.login.model.User
import com.med.data.preferences.login.repository.PreferenceRepository
import com.med.domain.base.CompletableUseCase
import com.med.domain.preferences.login.model.UserDto
import io.reactivex.Completable
import io.reactivex.Scheduler
import javax.inject.Inject

// Kullanici bilgilerinin kaydedilmesi isteği sonucunda tetiklenir.
class EditPreferenceUseCase @Inject constructor(
    private val preferenceRepository: PreferenceRepository,
    subscribeScheduler: Scheduler,
    postExecutionScheduler: Scheduler
) : CompletableUseCase<UserDto>(subscribeScheduler, postExecutionScheduler) {
    override fun buildUseCaseCompletable(params: UserDto?): Completable {
        return preferenceRepository.saveUser( params.let {
            User(userName = it?.userName , userPassword = it?.userPassword)
        })
    }
}