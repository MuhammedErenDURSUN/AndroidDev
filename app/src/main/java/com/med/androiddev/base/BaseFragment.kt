package com.med.androiddev.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import javax.inject.Inject

abstract class BaseFragment<P : BasePresenter<Any>> : Fragment() {

    @Inject
    lateinit var presenter: P

    protected abstract fun getLayout(): Int
    protected abstract fun initInjector()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(getLayout(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initInjector()
        initPresenter()
    }

    private fun initPresenter() {
        presenter.attachView(this)
        presenter.initialise()
    }

    override fun onDetach() {
        presenter.disposeSubscriptions()
        presenter.detachView()
        super.onDetach()
    }
}