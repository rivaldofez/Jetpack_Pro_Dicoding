package com.rivaldofez.moviers.ui.detail.movie

import androidx.lifecycle.ViewModel
import com.rivaldofez.moviers.entity.MovieEntity
import com.rivaldofez.moviers.entity.TvShowEntity
import com.rivaldofez.moviers.utils.DataDummy

class DetailMovieViewModel : ViewModel(){
    private lateinit var movieId: String

    fun setCurrentMovie(movieId: Int){
        this.movieId = movieId.toString()
    }

    fun getMovie(): MovieEntity {
        lateinit var movie: MovieEntity
        val movies = DataDummy.generateDummyMovies()

        for(iMovie in movies){
            if (movieId == iMovie.id.toString()){
                movie = iMovie
                break
            }
        }
        return movie
    }
}