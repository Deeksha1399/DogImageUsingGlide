package com.yml.dogimageusingglide

class DogViewModel {
    private val dogRepository = DogRepository()

    fun getRandomDogImage(randomDogCallbackService: RandomDogCallbackService) {
        dogRepository.getRandomDogImage(object : RandomDogCallbackService {
            override fun onResponse(data: String) {
                randomDogCallbackService.onResponse(data)
            }

            override fun onFailure(throwable: Throwable) {
                randomDogCallbackService.onFailure(throwable)
            }

        })
    }

    fun randomDogDataList(dogListCallbackService: DogListCallbackService) {
        dogRepository.getDogDataList(object : DogListCallbackService {
            override fun onResponse(data: List<String>) {
                dogListCallbackService.onResponse(data)
            }

            override fun onFailure(throwable: Throwable) {
                dogListCallbackService.onFailure(throwable)
            }

        })
    }
}