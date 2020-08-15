package com.example.thebatman.presentation.ui.movies

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.thebatman.R
import com.example.thebatman.databinding.FragmentMoviesBinding
import com.example.thebatman.presentation.common.BaseFragment
import com.example.thebatman.presentation.common.ViewModelFactory
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_movies.*
import javax.inject.Inject


class MoviesFragment : BaseFragment() {

    @Inject
    lateinit var factory:ViewModelFactory
    lateinit var moviesViewModel: MoviesViewModel

    lateinit var binding : FragmentMoviesBinding

    lateinit var recyclerView: RecyclerView



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        bind(inflater)
        return binding.root
    }


    fun bind(inflater: LayoutInflater){

        mainViewModel.setToolbarTitle("Batman Movies")
        binding= FragmentMoviesBinding.inflate(inflater)
        binding.lifecycleOwner=this


        moviesViewModel=ViewModelProvider(this,factory).get(MoviesViewModel::class.java)
        binding.viewmodel=moviesViewModel

        recyclerView=binding.rcvMoviesList
        recyclerView.adapter=MoviesAdapter(
            MoviesAdapter.CreateOnClickListener{

                findNavController().navigate(MoviesFragmentDirections.actionMoviesFragmentToDetailFragment(it.imdbID))
            }
        )
    }

}