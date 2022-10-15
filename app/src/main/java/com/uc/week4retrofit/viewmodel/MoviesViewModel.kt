package com.uc.week4retrofit.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.uc.week4retrofit.repository.MoviesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import android.util.Log
import androidx.lifecycle.viewModelScope
import com.uc.week4retrofit.model.MovieDetails
import kotlinx.coroutines.launch
import com.uc.week4retrofit.model.Result
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(private val repository: MoviesRepository):ViewModel(){
//get nowplaying data
  val  _nowPlaying: MutableLiveData<ArrayList<Result>> by lazy {
   MutableLiveData<ArrayList<Result>>()
  }
  val nowPlaying: LiveData<ArrayList<Result>>
   get() = _nowPlaying

  fun getNowPlaying(apiKey: String ,language: String,page: Int) =
      viewModelScope.launch{
   repository.getNowPlayingResult(apiKey,language,page).let{
     response ->
    if(response.isSuccessful){
     _nowPlaying.postValue(response.body()?.results as ArrayList<Result>?)
    }else{
     Log.e("Get Data" ,"Failed!")
    }
   }

  }
//getmoviedetails
    val  _movieDetails: MutableLiveData<MovieDetails>by lazy {
        MutableLiveData<MovieDetails>()
    }
    val movieDetails: LiveData<MovieDetails> get()=_movieDetails


    fun getMovieDetail(apiKey: String ,movieId:Int) =
        viewModelScope.launch{
            repository.getNowMovieDetailResult(apiKey,movieId).let{
                    response ->
                if(response.isSuccessful){
                    _movieDetails.postValue(response.body() as MovieDetails)
                }else{
                    Log.e("Get Movie Details Data" ,"Failed!")
                }
            }

        }

}