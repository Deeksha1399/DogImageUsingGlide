package com.yml.dogimageusingglide

interface DogListCallbackService {
    fun onResponse(responseObject: List<String>)
    fun onFailure(t: Throwable)
}