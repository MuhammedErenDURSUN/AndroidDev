package com.med.domain.preferences.login

import com.med.data.preferences.login.repository.PreferenceRepository
import com.med.domain.base.ObservableUseCase
import com.med.domain.preferences.login.model.UserDto
import io.reactivex.Observable
import io.reactivex.Scheduler
import javax.inject.Inject

// Kullanici bilgilerinin getirilmesi isteği sonucunda tetiklenir.
class GetPreferenceUseCase @Inject constructor(
    private val preferenceRepository: PreferenceRepository,
    subscribeScheduler: Scheduler,
    postExecutionScheduler: Scheduler
) : ObservableUseCase<UserDto, String>(subscribeScheduler, postExecutionScheduler) {

    override fun buildUseCaseObservable(params: String?): Observable<UserDto> {
        return preferenceRepository.getUser().map {
            UserDto(userName = it.userName,userPassword = it.userPassword)
         }
    }
}