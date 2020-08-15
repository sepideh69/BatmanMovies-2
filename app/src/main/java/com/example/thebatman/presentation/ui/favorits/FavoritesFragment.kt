package com.example.thebatman.presentation.ui.favorits

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.thebatman.R
import com.example.thebatman.presentation.common.BaseFragment

class FavoritesFragment : BaseFragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        bind()
        return inflater.inflate(R.layout.fragment_favorites, container, false)
    }

 fun bind(){
     mainViewModel.setToolbarTitle("Favorite Movies")
 }
}