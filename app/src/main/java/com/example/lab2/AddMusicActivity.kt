package com.example.lab2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lab2.databinding.ActivityAddMusicBinding
import com.example.lab2.recyclerview.Music

class AddMusicActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddMusicBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddMusicBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.save.setOnClickListener {
            val name = binding.edtName.text.toString()
            val singer = binding.edtSinger.text.toString()

            val music = Music(name, singer)

            MainActivity.Musics.add(music)


            finish()
        }
    }
}
