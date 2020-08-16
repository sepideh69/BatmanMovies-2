package com.example.thebatman.presentation.ui.favorits

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.thebatman.R
import com.example.thebatman.databinding.FragmentFavoritesBinding
import com.example.thebatman.presentation.common.BaseFragment
import com.example.thebatman.presentation.common.ViewModelFactory
import com.example.thebatman.presentation.ui.movies.MoviesAdapter
import javax.inject.Inject

class FavoritesFragment : BaseFragment() {

    @Inject
    lateinit var factory: ViewModelFactory
    lateinit var favoritesViewModel: FavoritesViewModel

    lateinit var binding: FragmentFavoritesBinding

    lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bind(inflater)
        return binding.root
    }

    private fun bind(layoutInflater: LayoutInflater){
        mainViewModel.setToolbarTitle("favorites list")
        favoritesViewModel=ViewModelProvider(this,factory).get(FavoritesViewModel::class.java)

        binding= FragmentFavoritesBinding.inflate(layoutInflater)
        binding.lifecycleOwner=this
        binding.viewModel=favoritesViewModel

        recyclerView=binding.rcvFavoritesRecycler
        recyclerView.adapter=MoviesAdapter(MoviesAdapter.CreateOnClickListener{
            findNavController().navigate(FavoritesFragmentDirections.actionFavoriteListFragmentToDetailFragment(it.imdbID))
        })
    }
}