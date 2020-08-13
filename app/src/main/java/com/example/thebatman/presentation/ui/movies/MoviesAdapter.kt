package com.example.thebatman.presentation.ui.movies


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.thebatman.databinding.MovieItemBinding
import com.example.thebatman.domain.entities.MovieEntity

class MoviesAdapter (val onMovieClick: CreateOnClickListener) :
    ListAdapter<MovieEntity, MoviesAdapter.MyHolder>(SearchCallBack()) {

    class MyHolder(val binding: MovieItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: MovieEntity) {

            binding.apply {
                movie = item
                executePendingBindings() }

        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHolder {
        val binding = MovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyHolder(binding)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {

        holder.apply {
            bind(getItem(position))
            itemView.setOnClickListener { onMovieClick.onClick(getItem(position)) }
        }


    }

    class SearchCallBack : DiffUtil.ItemCallback<MovieEntity>() {
        override fun areItemsTheSame(
            oldItem: MovieEntity,
            newItem: MovieEntity
        ): Boolean {
            return oldItem.imdbID == newItem.imdbID
        }

        override fun areContentsTheSame(
            oldItem: MovieEntity,
            newItem: MovieEntity
        ): Boolean {
            return oldItem == newItem
        }
    }

    class CreateOnClickListener(val clickListener: (MovieEntity) -> Unit) {
        fun onClick(movie: MovieEntity) = clickListener(movie)
    }



}