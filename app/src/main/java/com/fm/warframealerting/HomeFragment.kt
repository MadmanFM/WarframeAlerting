package com.fm.warframealerting

import androidx.lifecycle.lifecycleScope
import com.fm.warframealerting.base.BaseVMFragment
import com.fm.warframealerting.databinding.FragmentHomeBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * author：BFM
 * date： 2021/1/7
 * desc：
 */
class HomeFragment : BaseVMFragment<HomeViewModel, FragmentHomeBinding>(R.layout.fragment_home) {

    override fun initView() {
        binding.pagee = this
    }

    override fun initEventAndData() {

    }

    val TAG = javaClass.simpleName;

    fun actionText() {
        lifecycleScope.launch {
            request().onEmpty {
                emit("kjkk")
            }.flowOn(Dispatchers.IO)
                .collect {
                    println("it is $it")
                }
        }
    }

    private fun requestInt(value: Int) = flow {
        require(value % 2 != 0) { "参数错误" }
        println("request Int ${Thread.currentThread().name}")
        delay(1000)
        emit("$value")
    }


    private fun request() = flow {
        delay(1500)
        println("request ${Thread.currentThread().name}")
        emit("")
    }
}