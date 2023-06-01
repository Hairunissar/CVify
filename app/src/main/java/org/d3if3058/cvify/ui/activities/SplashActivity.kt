package org.d3if3058.cvify.ui.activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import org.d3if3058.cvify.databinding.ActivitySplashBinding


class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // Delay untuk splash screen
        val splashDelay = 3000 // Mengatur delay dalam milidetik (3 detik dalam contoh ini)
        Handler().postDelayed({
            // Intent untuk membuka FirstPageActivity setelah splashDelay
            val intent = Intent(this, FirstPageActivity::class.java)
            startActivity(intent)
            finish() // Menutup SplashActivity setelah membuka FirstPageActivity
        }, splashDelay.toLong())
    }
}

