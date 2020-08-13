package com.example.thebatman.data.api

import com.example.thebatman.data.entities.MovieData
import com.google.gson.annotations.SerializedName

class MovieListNetworkResult(@SerializedName("Search") var movieList : List<MovieData>,
                             var  totalResults : String,
                             var Response:String)