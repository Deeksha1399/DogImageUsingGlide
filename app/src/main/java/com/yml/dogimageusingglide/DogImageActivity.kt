package com.yml.dogimageusingglide

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_dog_image.*

class DogImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dog_image)

        val viewModel = DogViewModel()
        random_button.setOnClickListener {
            viewModel.getRandomDogImage(object : RandomDogCallbackService {
                override fun onResponse(data: String) {
                    Glide.with(this@DogImageActivity)
                        .load(data)
                        .into(iv_dog)
                }

                override fun onFailure(throwable: Throwable) {
                    Toast.makeText(this@DogImageActivity, throwable.toString(), Toast.LENGTH_SHORT)
                        .show()
                }
            })
        }

        display_button.setOnClickListener{
            startActivity(Intent(this@DogImageActivity, DisplayDogListActivity::class.java))
        }
    }
}