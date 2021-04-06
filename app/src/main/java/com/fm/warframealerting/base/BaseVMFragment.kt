package com.fm.warframealerting.base

import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import java.lang.reflect.ParameterizedType

/**
 * author：BFM
 * date： 2021/1/7
 * desc：
 */
abstract class BaseVMFragment<VM : BaseViewModel, DB : ViewDataBinding>(
    @LayoutRes private val layoutRes: Int
) : BaseFragment<DB>(layoutRes) {

    val viewModel: VM by lazy {
        ViewModelProvider(this, defaultViewModelProviderFactory).get(getVMCls(this))
    }
}

/**
 * 获取当前类绑定的ViewModel
 * Create by Robbin at 2020/7/1
 */
@Suppress("UNCHECKED_CAST")
fun <VM> getVMCls(cls: Any): VM {
    return (cls.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0] as VM
}