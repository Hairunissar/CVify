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
import org.d3if3058.cvify.databinding.FragmentEducationBinding
import org.d3if3058.cvify.model.CV
import org.d3if3058.cvify.model.CVRepository
import org.d3if3058.cvify.model.Education
import org.d3if3058.cvify.ui.activities.CreateCVActivity
import org.d3if3058.cvify.ui.viewModel.CVViewModel

class EducationFragment : Fragment() {

    private lateinit var binding: FragmentEducationBinding
    private lateinit var cvRepository: CVRepository
    private lateinit var cvViewModel: CVViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentEducationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cvDao = CVDatabase.getDatabase(requireContext()).cvDao()
        cvRepository = CVRepository(cvDao)

        cvViewModel = ViewModelProvider(requireActivity()).get(CVViewModel::class.java)

        binding.entryYearInputEditText.addTextChangedListener { validateForm() }
        binding.universityNameInputEditText.addTextChangedListener { validateForm() }
        binding.majorInputEditText.addTextChangedListener { validateForm() }

        binding.backButton.setOnClickListener {
            val intent = Intent(requireActivity(), CreateCVActivity::class.java)
            startActivity(intent)
        }

        binding.saveButton.setOnClickListener {
            saveEducation()
        }

        binding.saveButton.isEnabled = false
    }

    private fun validateForm() {
        val entryYear = binding.entryYearInputEditText.text.toString()
        val universityName = binding.universityNameInputEditText.text.toString()
        val major = binding.majorInputEditText.text.toString()

        val isFormValid = entryYear.isNotEmpty() && universityName.isNotEmpty() && major.isNotEmpty()

        binding.saveButton.isEnabled = isFormValid
    }

    private fun saveEducation() {
        val entryYear = binding.entryYearInputEditText.text.toString()
        val universityName = binding.universityNameInputEditText.text.toString()
        val major = binding.majorInputEditText.text.toString()

        val education = Education(entryYear, universityName, major)

        val cv = CV(emptyList(), emptyList(), listOf(education), emptyList())

        cvViewModel.insertCV(cv)
    }
}
