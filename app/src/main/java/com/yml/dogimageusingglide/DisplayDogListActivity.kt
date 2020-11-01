package com.yml.dogimageusingglide

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_display_dog_list.*

class DisplayDogListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_dog_list)

        rv_dog_images.layoutManager = LinearLayoutManager(this)

        val viewModel = DogViewModel()
        viewModel.randomDogDataList(object : DogListCallbackService {
            override fun onResponse(data: List<String>) {
                rv_dog_images.adapter = AdapterClass(this@DisplayDogListActivity, data)
            }

            override fun onFailure(throwable: Throwable) {
                Toast.makeText(
                    this@DisplayDogListActivity,
                    throwable.toString(),
                    Toast.LENGTH_SHORT
                )
                    .show()
            }

        })

        back_button.setOnClickListener {
            startActivity(Intent(this@DisplayDogListActivity, DogImageActivity::class.java))
        }
    }
}