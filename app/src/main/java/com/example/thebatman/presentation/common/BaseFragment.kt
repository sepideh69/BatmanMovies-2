package com.example.thebatman.presentation.common

import android.view.ActionProvider
import androidx.fragment.app.activityViewModels
import com.example.thebatman.presentation.ui.main.MainViewModel
import dagger.android.support.DaggerFragment

open class BaseFragment : DaggerFragment() {
     val mainViewModel:MainViewModel by activityViewModels()
}