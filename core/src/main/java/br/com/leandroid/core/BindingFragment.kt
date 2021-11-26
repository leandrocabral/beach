package br.com.leandroid.core

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BindingFragment<T : ViewDataBinding> : Fragment() {

    @LayoutRes
    abstract fun getLayoutId(): Int

    lateinit var binding: T


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        DataBindingUtil.inflate<T>(inflater, getLayoutId(), container, false).run {
            binding = this
        }
        return binding.root
    }
}