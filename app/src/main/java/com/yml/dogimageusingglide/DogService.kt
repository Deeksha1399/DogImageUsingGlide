package com.yml.dogimageusingglide

import retrofit2.Call
import retrofit2.http.GET

interface DogService {

    @GET("random")
    fun getRandomDogImage(): Call<RandomDogData>

    @GET("random/30")
    fun getDogList(): Call<ListDogData>
}