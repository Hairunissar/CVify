package org.d3if3058.cvify.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.d3if3058.cvify.databinding.ActivityFirstPageBinding

class FirstPageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFirstPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstPageBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.continueButton.setOnClickListener {
            val intent = Intent(this, SecondPageActivity::class.java)
            startActivity(intent)
        }
    }
}
