package com.example.lab2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.lab2.databinding.ActivityMainBinding
import com.example.lab2.recyclerview.Music
import com.example.lab2.recyclerview.MusicAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.listMusics.run {
            layoutManager = LinearLayoutManager(this@MainActivity)
            setHasFixedSize(true)
            adapter = MusicAdapter(Musics)
        }

        binding.fabAdd.setOnClickListener {
            val intent = Intent(this@MainActivity, AddMusicActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        // binding.listMusics.adapter = MusicAdapter(Musics)
        binding.listMusics.adapter?.notifyDataSetChanged()
    }

    companion object {
        val Musics = mutableListOf<Music>()
    }
}
