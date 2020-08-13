package com.example.thebatman.presentation.common

import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.thebatman.R
import com.example.thebatman.domain.entities.MovieEntity
import com.example.thebatman.presentation.ui.movies.MoviesAdapter
import com.example.thebatman.utils.showToast

@BindingAdapter("setMoviesList")
fun bindMoviesList(recyclerView: RecyclerView, movies : List<MovieEntity>?){

    //customAnimation(recyclerView, duration = 2000, animation = Techniques.BounceInRight)
    val adapter = recyclerView.adapter as MoviesAdapter
    adapter.submitList(movies)
}

@BindingAdapter("requestStatus")
fun setRequestStatus(progressBar : ProgressBar, status: Result.Status ?){
    val context : Context =progressBar.context
    when (status) {
        Result.Status.LOADING -> {
            progressBar.visibility= View.VISIBLE

        }
        Result.Status.SUCCESS->{
            progressBar.visibility= View.GONE
        }
        Result.Status.ERROR ->{
            progressBar.visibility= View.GONE
            context.showToast(context.getString(R.string.error_get_data))
        }
//        Result.Status.NOTREFRESH->{
//            progressBar.visibility= View.GONE
//            context.showToast(context.getString(R.string.error_refresh_data))
//        }
    }

}


@BindingAdapter("moviePoster")
fun bindImage(imgView: ImageView, imgUrl: String?) {
    imgUrl?.let {

        Glide.with(imgView.context)
            .load(imgUrl)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.batman)
                    .error(R.drawable.batman)
            )
            .into(imgView)
    }

}



@BindingAdapter("setFavoriteState")
fun bindFavoriteState(imageView: ImageView , check : Boolean ?){

    check?.let {
        when(it){
            true->imageView.setImageDrawable(ContextCompat.getDrawable(imageView.context,R.drawable.ic_filled_favorite))
            false->imageView.setImageDrawable(ContextCompat.getDrawable(imageView.context,R.drawable.ic_favorite_border))

        }
    }
}
