package org.d3if3058.cvify.ui.fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelProvider
import org.d3if3058.cvify.data.CVDatabase
import org.d3if3058.cvify.databinding.FragmentExperienceBinding
import org.d3if3058.cvify.model.CV
import org.d3if3058.cvify.model.CVRepository
import org.d3if3058.cvify.model.Experience
import org.d3if3058.cvify.ui.activities.CreateCVActivity
import org.d3if3058.cvify.ui.viewModel.CVViewModel

class ExperienceFragment : Fragment() {
    private lateinit var binding: FragmentExperienceBinding
    private lateinit var cvRepository: CVRepository
    private lateinit var cvViewModel: CVViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentExperienceBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cvDao = CVDatabase.getDatabase(requireContext()).cvDao()
        cvRepository = CVRepository(cvDao)

        cvViewModel = ViewModelProvider(requireActivity()).get(CVViewModel::class.java)

        binding.jobNameEditText.addTextChangedListener { validateForm() }
        binding.jobPositionInputEditText.addTextChangedListener { validateForm() }
        binding.jobDescriptionInputEditText.addTextChangedListener { validateForm() }

        binding.backButton.setOnClickListener {
            val intent = Intent(requireActivity(), CreateCVActivity::class.java)
            startActivity(intent)
        }

        binding.saveButton.setOnClickListener {
            saveExperience()
        }

        binding.saveButton.isEnabled = false
    }

    private fun validateForm() {
        val jobName = binding.jobNameEditText.text.toString()
        val jobPosition = binding.jobPositionInputEditText.text.toString()
        val jobDescription = binding.jobDescriptionInputEditText.text.toString()

        val isFormValid =
            jobName.isNotEmpty() &&
                    jobPosition.isNotEmpty() &&
                    jobDescription.isNotEmpty()

        binding.saveButton.isEnabled = isFormValid
    }

    private fun saveExperience() {
        val jobName = binding.jobNameEditText.text.toString()
        val jobPosition = binding.jobPositionInputEditText.text.toString()
        val jobDescription = binding.jobDescriptionInputEditText.text.toString()

        val experience = Experience(
            jobName,
            jobPosition,
            jobDescription
        )

        val cv = CV(emptyList(), emptyList(), emptyList(), listOf(experience))

        // Save CV to the database
        cvViewModel.insertCV(cv)
    }
}
