package com.yml.dogimageusingglide

interface RandomDogCallbackService {
    fun onResponse(responseObject: String)
    fun onFailure(t: Throwable)
}