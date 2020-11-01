package com.yml.dogimageusingglide

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DogRepository {

    private val retrofit = RetrofitInitializer.getRetrofitInstance().create(DogService::class.java)

    fun getRandomDogImage(randomDogCallbackService: RandomDogCallbackService) {
        val dogImage = retrofit.getRandomDogImage()
        dogImage.enqueue(object : Callback<RandomDogData> {
            override fun onResponse(call: Call<RandomDogData>, response: Response<RandomDogData>) {
                randomDogCallbackService.onResponse(response.body()!!.message)
            }

            override fun onFailure(call: Call<RandomDogData>, t: Throwable) {
                randomDogCallbackService.onFailure(t)
            }
        })
    }

    fun getDogDataList(dogListCallbackService: DogListCallbackService) {
        val dogData = retrofit.getDogList()
        dogData.enqueue(object : Callback<ListDogData> {
            override fun onResponse(call: Call<ListDogData>, response: Response<ListDogData>) {
                dogListCallbackService.onResponse(response.body()!!.message)
            }

            override fun onFailure(call: Call<ListDogData>, t: Throwable) {
                dogListCallbackService.onFailure(t)
            }
        })
    }
}