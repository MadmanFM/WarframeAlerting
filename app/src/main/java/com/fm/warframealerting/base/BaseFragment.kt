package com.fm.warframealerting.base

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

/**
 * author：BFM
 * date： 2021/1/6
 * desc：
 */
abstract class BaseFragment<DB : ViewDataBinding>(
    @LayoutRes private val layoutRes: Int
) : Fragment() {

    lateinit var mActivity: FragmentActivity

    lateinit var binding: DB

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mActivity = context as FragmentActivity
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, layoutRes, container, false)
        binding.lifecycleOwner = this
        initView()
        initEventAndData()
        return binding.root
    }

    protected abstract fun initView()

    protected abstract fun initEventAndData()

}