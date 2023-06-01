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
import org.d3if3058.cvify.databinding.FragmentPersonalBinding
import org.d3if3058.cvify.model.CV
import org.d3if3058.cvify.model.CVRepository
import org.d3if3058.cvify.model.Personal
import org.d3if3058.cvify.ui.activities.CreateCVActivity
import org.d3if3058.cvify.ui.viewModel.CVViewModel

class PersonalFragment : Fragment() {

    private lateinit var binding: FragmentPersonalBinding
    private lateinit var cvRepository: CVRepository
    private lateinit var cvViewModel: CVViewModel
    private lateinit var createCVActivity: CreateCVActivity


    //    View Binding diaktifkan
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPersonalBinding.inflate(inflater, container, false)
        return binding.root

        createCVActivity = requireActivity() as CreateCVActivity

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        Membuat objek CVRepository yang akan digunakan untuk berinteraksi dengan database.
        val cvDao = CVDatabase.getDatabase(requireContext()).cvDao()
        cvRepository = CVRepository(cvDao)

        cvViewModel = ViewModelProvider(requireActivity()).get(CVViewModel::class.java)

//        Mengaitkan fungsi addTextChangedListener ke setiap EditText untuk memantau perubahan pada input pengguna dan memanggil validateForm() setiap kali terjadi perubahan.
        binding.firstNameInputEditText.addTextChangedListener { validateForm() }
        binding.lastNameInputEditText.addTextChangedListener { validateForm() }
        binding.jobTitleInputEditText.addTextChangedListener { validateForm() }
        binding.aboutMeInputEditText.addTextChangedListener { validateForm() }
        binding.phoneNumberInputEditText.addTextChangedListener { validateForm() }
        binding.emailInputEditText.addTextChangedListener { validateForm() }
        binding.adressInputEditText.addTextChangedListener { validateForm() }

        binding.backButton.setOnClickListener {
            val intent = Intent(requireActivity(), CreateCVActivity::class.java)
            startActivity(intent)
        }

        binding.saveButton.setOnClickListener {
            savePersonalInformation()
            createCVActivity.updateFormStatus("personal", true)

        }

        binding.saveButton.isEnabled = false

    }

    private fun validateForm() {
        val firstName = binding.firstNameInputEditText.text.toString()
        val lastName = binding.lastNameInputEditText.text.toString()
        val jobTitle = binding.jobTitleInputEditText.text.toString()
        val aboutMe = binding.aboutMeInputEditText.text.toString()
        val phoneNumber = binding.phoneNumberInputEditText.text.toString()
        val email = binding.emailInputEditText.text.toString()
        val address = binding.adressInputEditText.text.toString()

        val isFormValid =
            firstName.isNotEmpty() &&
                lastName.isNotEmpty() &&
                jobTitle.isNotEmpty() &&
                aboutMe.isNotEmpty() &&
                phoneNumber.isNotEmpty() &&
                email.isNotEmpty() &&
                address.isNotEmpty()

        binding.saveButton.isEnabled = isFormValid
    }

    private fun savePersonalInformation() {
        val firstName = binding.firstNameInputEditText.text.toString()
        val lastName = binding.lastNameInputEditText.text.toString()
        val jobTitle = binding.jobTitleInputEditText.text.toString()
        val aboutMe = binding.aboutMeInputEditText.text.toString()
        val phoneNumber = binding.phoneNumberInputEditText.text.toString()
        val email = binding.emailInputEditText.text.toString()
        val address = binding.adressInputEditText.text.toString()

        val personal = Personal(
            firstName,
            lastName,
            jobTitle,
            aboutMe,
            phoneNumber,
            email,
            address
        )

        val cv = CV(listOf(personal), emptyList(), emptyList(), emptyList())

        // Save CV to the database
        cvViewModel.insertCV(cv)


    }
}













