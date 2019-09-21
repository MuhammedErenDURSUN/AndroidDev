package com.med.domain.preferences.login

import com.med.data.preferences.login.repository.PreferenceRepository
import com.med.domain.base.CompletableUseCase
import io.reactivex.Completable
import io.reactivex.Scheduler
import javax.inject.Inject

// Kullanici bilgilerinin temizleme isteği sonucunda tetiklenir.
class ClearPreferenceUseCase @Inject constructor(
    private val preferenceRepository: PreferenceRepository,
    subscribeScheduler: Scheduler,
    postExecutionScheduler: Scheduler
) : CompletableUseCase<String>(subscribeScheduler, postExecutionScheduler) {
    override fun buildUseCaseCompletable(params: String?): Completable {
        return preferenceRepository.clear()
    }
}