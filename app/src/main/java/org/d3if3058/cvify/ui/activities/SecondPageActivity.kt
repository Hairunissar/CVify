package org.d3if3058.cvify.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.d3if3058.cvify.databinding.ActivitySecondPageBinding

class SecondPageActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondPageBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.getStartedButton.setOnClickListener {
            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }
    }
}
