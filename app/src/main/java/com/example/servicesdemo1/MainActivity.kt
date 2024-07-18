package com.example.servicesdemo1

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.servicesdemo1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        activityMainBinding.btnStartService.setOnClickListener {
            val intent = Intent(this, MediaPlayerService::class.java)
            intent.putExtra("file_path", activityMainBinding.edtPath.text.toString())
            startService(intent)
        }

        activityMainBinding.btnStopService.setOnClickListener {
            val intent = Intent(this, MediaPlayerService::class.java)
            stopService(intent)
        }
    }
}
