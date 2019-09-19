package com.med.domain.base

import io.reactivex.Scheduler
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable


abstract class BaseUseCase(
    threadExecutor: Scheduler,
    postExecutionThread: Scheduler
) {
    protected val threadExecutorScheduler: Scheduler = threadExecutor

    protected val postExecutionThreadScheduler: Scheduler = postExecutionThread

    private val disposables = CompositeDisposable()

    open fun dispose() {
        if (!disposables.isDisposed) {
            disposables.dispose()
        }
    }

    protected fun addDisposable(disposable: Disposable) {
        disposables.add(disposable)
    }
}