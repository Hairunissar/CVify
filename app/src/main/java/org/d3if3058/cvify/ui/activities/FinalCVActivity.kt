package org.d3if3058.cvify.ui.activities

//import android.content.Intent
//import android.os.Bundle
//import androidx.appcompat.app.AppCompatActivity
//import androidx.lifecycle.Observer
//import androidx.lifecycle.ViewModelProvider
//import org.d3if3058.cvify.data.CVDatabase
//import org.d3if3058.cvify.databinding.ActivityFinalCvBinding
//import org.d3if3058.cvify.model.CV
//import org.d3if3058.cvify.model.CVRepository
//import org.d3if3058.cvify.ui.viewModel.CVViewModel
//
//class FinalCVActivity : AppCompatActivity() {
//    private lateinit var binding: ActivityFinalCvBinding
//    private lateinit var cvViewModel: CVViewModel
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = ActivityFinalCvBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        val cvRepository = CVRepository(CVDatabase.getDatabase(application).cvDao())
//        cvViewModel = ViewModelProvider(this, CVViewModel.Factory(cvRepository)).get(CVViewModel::class.java)
//
//        cvViewModel.allCVs.observe(this, Observer { cvList ->
//            if (cvList.isNotEmpty()) {
//                val cv = cvList[0] // Assuming there is only one CV in the database
//                displayCV(cv)
//            }
//        })
//
//        binding.bagikanButton.setOnClickListener {
//            shareCV()
//        }
//    }
//
//    private fun displayCV(cv: CV) {
//        val personal = cv.personal
//        val education = cv.education
//        val skills = cv.skills
//        val experience = cv.experience
////NAPA ERROR SIHH
//        binding.firstName.text = personal.firstName
//        binding.lastName.text = personal.lastName
//        binding.jobTitle.text = personal.jobTitle
//        binding.phoneNumber.text = personal.phoneNumber
//        binding.email.text = personal.email
//        binding.address.text = personal.address
//        binding.aboutMe.text = personal.aboutMe
//        binding.date.text = education.date
//        binding.universityName.text = education.universityName
//        binding.major.text = education.major
//        binding.skill1.text = skills.skill1
//        binding.skill2.text = skills.skill2
//        binding.skill3.text = skills.skill3
//        binding.skill4.text = skills.skill4
//        binding.jobName.text = experience.jobName
//        binding.jobPosition.text = experience.jobPosition
//        binding.jobDescription.text = experience.jobDescription
//    }
//
//    private fun shareCV() {
//        // Open a pop-up or dialog to share the CV with other applications
//        val shareIntent = Intent().apply {
//            // Set the appropriate action and type for sharing the CV
//            action = Intent.ACTION_SEND
//            type = "text/plain"
//            putExtra(Intent.EXTRA_TEXT, "Share the CV content here")
//        }
//        startActivity(Intent.createChooser(shareIntent, "Share CV"))
//    }
//}
