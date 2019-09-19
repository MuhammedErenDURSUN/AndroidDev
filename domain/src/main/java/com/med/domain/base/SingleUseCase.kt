package com.med.domain.base

import com.med.domain.internal.rx.EmptySingleObserver
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.observers.DisposableSingleObserver

abstract class SingleUseCase<Results, in Params>(
    threadExecutor: Scheduler,
    postExecutionThread: Scheduler
) : BaseUseCase(threadExecutor, postExecutionThread) {

    abstract fun buildUseCaseSingle(params: Params? = null): Single<Results>

    fun execute(
        observer: DisposableSingleObserver<Results> = EmptySingleObserver(),
        params: Params? = null
    ) {
        val single = buildUseCaseSingleWithSchedulers(params)
        addDisposable(single.subscribeWith(observer))
    }

    private fun buildUseCaseSingleWithSchedulers(params: Params?): Single<Results> {
        return buildUseCaseSingle(params)
            .subscribeOn(threadExecutorScheduler)
            .observeOn(postExecutionThreadScheduler)
    }
}