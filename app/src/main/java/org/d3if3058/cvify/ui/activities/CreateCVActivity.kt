package org.d3if3058.cvify.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import org.d3if3058.cvify.databinding.ActivityCreateCvBinding
import org.d3if3058.cvify.ui.fragment.EducationFragment
import org.d3if3058.cvify.ui.fragment.ExperienceFragment
import org.d3if3058.cvify.ui.fragment.PersonalFragment
import org.d3if3058.cvify.ui.fragment.SkillFragment


class CreateCVActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCreateCvBinding
    private var isPersonalFormFilled = false
    private var isEducationFormFilled = false
    private var isSkillsFormFilled = false
    private var isExperienceFormFilled = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateCvBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.personal.setOnClickListener {
            val intent = Intent(this, PersonalFragment::class.java)
            startActivity(intent)
        }

        binding.education.setOnClickListener {
            val intent = Intent(this, EducationFragment::class.java)
            startActivity(intent)
        }

        binding.skills.setOnClickListener {
            val intent = Intent(this, SkillFragment::class.java)
            startActivity(intent)
        }

        binding.experience.setOnClickListener {
            val intent = Intent(this, ExperienceFragment::class.java)
            startActivity(intent)
        }

        binding.printCVButoon.setOnClickListener {
            // Check if all forms are filled
            if (isPersonalFormFilled && isEducationFormFilled && isSkillsFormFilled && isExperienceFormFilled) {
                // Proceed to print CV
                printCV()
            } else {
                // Show error message or prompt the user to fill all forms
            }
        }
    }

    fun updateFormStatus(formType: String, isFilled: Boolean) {
        when (formType) {
            "personal" -> isPersonalFormFilled = isFilled
            "education" -> isEducationFormFilled = isFilled
            "skills" -> isSkillsFormFilled = isFilled
            "experience" -> isExperienceFormFilled = isFilled
        }
        updatePrintCVButtonStatus()
    }

    private fun updatePrintCVButtonStatus() {
        val isAllFormsFilled =
            isPersonalFormFilled && isEducationFormFilled && isSkillsFormFilled && isExperienceFormFilled
        binding.printCVButoon.isEnabled = isAllFormsFilled
    }

    private fun printCV() {
        val intent = Intent(this, FinalCVActivity::class.java)
        startActivity(intent)
    }

}
