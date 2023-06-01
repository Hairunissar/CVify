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
import org.d3if3058.cvify.databinding.FragmentSkillBinding
import org.d3if3058.cvify.model.CV
import org.d3if3058.cvify.model.CVRepository
import org.d3if3058.cvify.model.Skill
import org.d3if3058.cvify.ui.activities.CreateCVActivity
import org.d3if3058.cvify.ui.viewModel.CVViewModel

class SkillFragment : Fragment() {
    private lateinit var binding: FragmentSkillBinding
    private lateinit var cvRepository: CVRepository
    private lateinit var cvViewModel: CVViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSkillBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val cvDao = CVDatabase.getDatabase(requireContext()).cvDao()
        cvRepository = CVRepository(cvDao)

        cvViewModel = ViewModelProvider(requireActivity()).get(CVViewModel::class.java)

        binding.skillsInputEditText.addTextChangedListener { validateForm() }
        binding.skillsInputEditText2.addTextChangedListener { validateForm() }
        binding.skillsInputEditText3.addTextChangedListener { validateForm() }
        binding.skillsInputEditText4.addTextChangedListener { validateForm() }

        binding.saveButton2.setOnClickListener {
            saveSkills()
        }

        binding.saveButton2.isEnabled = false

        binding.backButton.setOnClickListener {
            val intent = Intent(requireActivity(), CreateCVActivity::class.java)
            startActivity(intent)
        }
    }

    private fun validateForm() {
        val skill1 = binding.skillsInputEditText.text.toString()
        val skill2 = binding.skillsInputEditText2.text.toString()
        val skill3 = binding.skillsInputEditText3.text.toString()
        val skill4 = binding.skillsInputEditText4.text.toString()

        val isFormValid =
            skill1.isNotEmpty() &&
                    skill2.isNotEmpty() &&
                    skill3.isNotEmpty() &&
                    skill4.isNotEmpty()

        binding.saveButton2.isEnabled = isFormValid
    }

    private fun saveSkills() {
        val skill1 = binding.skillsInputEditText.text.toString()
        val skill2 = binding.skillsInputEditText2.text.toString()
        val skill3 = binding.skillsInputEditText3.text.toString()
        val skill4 = binding.skillsInputEditText4.text.toString()

        val skill = Skill(
            skill1,
            skill2,
            skill3,
            skill4
        )

        val cv = CV(emptyList(), listOf(skill), emptyList(), emptyList())

        cvViewModel.insertCV(cv)
    }
}
