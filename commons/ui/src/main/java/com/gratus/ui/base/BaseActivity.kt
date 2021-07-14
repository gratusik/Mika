package com.gratus.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.google.android.material.snackbar.Snackbar

abstract class BaseActivity<B : ViewBinding> : AppCompatActivity() {
    private var snackBar: Snackbar? = null
    private var initial: Boolean = false

    lateinit var binding: B

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getViewBinding()
        setContentView(binding.root)
        onInitDependencyInjection()
        onInitViewBinding()
    }

    abstract fun onInitDependencyInjection()
    abstract fun getViewBinding(): B
    abstract fun onInitViewBinding()
}
