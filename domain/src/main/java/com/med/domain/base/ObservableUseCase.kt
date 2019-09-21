package com.med.domain.base

import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.observers.DisposableObserver

abstract class ObservableUseCase<Results, in Params>(threadExecutor: Scheduler,
                                                     postExecutionThread: Scheduler
) : BaseUseCase(threadExecutor, postExecutionThread) {

    /**
     * Builds an [Observable] which will be used when executing the current [ObservableUseCase].
     */
    abstract fun buildUseCaseObservable(params: Params? = null): Observable<Results>

    /**
     * Executes the current use case.
     *
     * @param observer [DisposableObserver] which will be listening to the observer build
     * by [buildUseCaseObservable] method.
     * @param params   Parameters (Optional) used to build/execute this use case.
     */
    fun execute(observer: DisposableObserver<Results>, params: Params? = null) {
        val observable = buildUseCaseObservableWithSchedulers(params)
        addDisposable(observable.subscribeWith(observer))
    }

    private fun buildUseCaseObservableWithSchedulers(params: Params?): Observable<Results> {
        return buildUseCaseObservable(params)
            .subscribeOn(threadExecutorScheduler)
            .observeOn(postExecutionThreadScheduler)
    }
}