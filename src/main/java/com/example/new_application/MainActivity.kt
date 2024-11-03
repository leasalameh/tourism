
package com.example.new_application

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set up the DrawerLayout
        drawerLayout = findViewById(R.id.drawer_layout)

        // Reference to the ImageView that will display the background
        val backgroundImageView: ImageView = findViewById(R.id.backgroundImageView)

        // Array of drawable resource IDs for the wallpapers
        val wallpapers = listOf(
            R.drawable.dubai1,
            R.drawable.paris,
            R.drawable.wander6,
            R.drawable.wander5,
            R.drawable.wander4,
            R.drawable.barcelona1,
            R.drawable.lisbon
        )

        // Select a random wallpaper from the list
        val randomWallpaper = wallpapers[Random.nextInt(wallpapers.size)]

        // Set the randomly selected image as the background
        backgroundImageView.setImageResource(randomWallpaper)
    }
}
