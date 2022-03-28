package com.maltmannapp.photopicker

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.color.DynamicColors

const val REQUEST_CODE_PHOTO_PICKER = 100

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Enable dynamic color
        DynamicColors.applyIfAvailable(this)

        val button = findViewById<Button>(R.id.button)

        button.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_PICK_IMAGES)
            startActivityForResult(intent, REQUEST_CODE_PHOTO_PICKER)
        } // onClickerListener
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val imageView: ImageView = findViewById(R.id.imageView)
        if (resultCode != Activity.RESULT_OK)
            return
        when (requestCode) {
            REQUEST_CODE_PHOTO_PICKER -> if (data != null) {
                imageView.setImageURI(data.data)
            }
        }
    }

}
