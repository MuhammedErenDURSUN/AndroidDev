package com.med.domain.base

import com.med.domain.internal.rx.EmptyCompletableObserver
import io.reactivex.Completable
import io.reactivex.Scheduler
import io.reactivex.observers.DisposableCompletableObserver

abstract class CompletableUseCase<in Params>(
    threadExecutor: Scheduler,
    postExecutionThread: Scheduler
) : BaseUseCase(threadExecutor, postExecutionThread) {

    /**
     * Builds a [Completable] which will be used when executing the current [CompletableUseCase].
     */
    abstract fun buildUseCaseCompletable(params: Params? = null): Completable

    /**
     * Executes the current use case.
     *
     * @param observer [DisposableCompletableObserver] which will be listening to the observer build
     * by [buildUseCaseCompletable] method.
     * @param params Parameters (Optional) used to build/execute this use case.
     */
    fun execute(observer: DisposableCompletableObserver = EmptyCompletableObserver(), params: Params? = null) {
        val completable = buildUseCaseCompletableWithSchedulers(params)
        addDisposable(completable.subscribeWith(observer))
    }

    /**
     * Builds a [Completable] which will be used when executing the current [CompletableUseCase].
     * With provided Schedulers
     */
    private fun buildUseCaseCompletableWithSchedulers(params: Params?): Completable {
        return buildUseCaseCompletable(params)
            .subscribeOn(threadExecutorScheduler)
            .observeOn(postExecutionThreadScheduler)
    }
}