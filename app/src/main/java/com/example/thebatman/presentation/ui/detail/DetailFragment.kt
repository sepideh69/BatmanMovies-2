package com.example.thebatman.presentation.ui.detail

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.thebatman.R
import com.example.thebatman.databinding.FragmentDetailBinding
import com.example.thebatman.presentation.common.ViewModelFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class DetailFragment : DaggerFragment() {

    @Inject
    lateinit var factory: DetailVMFactory
    lateinit var detailViewModel: DetailViewModel
    lateinit var binding: FragmentDetailBinding

    lateinit var imdbId: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        bind(inflater)
        return binding.root
    }


    private fun bind(inflater: LayoutInflater) {

        binding = FragmentDetailBinding.inflate(inflater)
        binding.lifecycleOwner=this

        arguments?.takeIf {
            it.containsKey("movieId")

        }?.apply {

            imdbId = arguments?.get("movieId") as String

        }

        factory.movieId = imdbId
        detailViewModel = ViewModelProvider(this, factory).get(DetailViewModel::class.java)

        binding.viewmodel=detailViewModel

        binding.imgFavorit.setOnClickListener {

           // detailViewModel.favoriteButtonClicked()
        }
    }


}
