package com.example.servicesdemo1

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.net.Uri
import android.os.IBinder
import android.widget.Toast

class MediaPlayerService : Service (){
    lateinit var mediaPlayer: MediaPlayer
    lateinit var uri : Uri

    override fun onCreate() {
        super.onCreate()

        makeText("onCrearte called")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {


        makeText("onCommand Called -- $startId")

            var path = intent!!.getStringExtra("file_path")
        if(path == null){
            makeText("No file path found")
            stopSelf()
            return START_NOT_STICKY
        }
            uri = Uri.parse(path)

        mediaPlayer = MediaPlayer.create(this,uri)
        mediaPlayer.isLooping = true
        mediaPlayer.start()
        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        TODO("Not yet implemented")

        makeText("onBind Called")
        return null
    }

    override fun onDestroy() {
        super.onDestroy()

        makeText("onDestroy called")
        mediaPlayer.stop()
    }

    fun makeText(text: String){
        Toast.makeText(this,text,Toast.LENGTH_LONG).show()
    }
}