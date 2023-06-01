package org.d3if3058.cvify.ui.adapter


//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.RecyclerView
//import org.d3if3058.cvify.databinding.ItemPreviewCvBinding
//import org.d3if3058.cvify.model.CV
//
//class CVPreviewAdapter(private val cvList: List<CV>) : RecyclerView.Adapter<CVPreviewAdapter.CVPreviewViewHolder>() {
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CVPreviewViewHolder {
//        val inflater = LayoutInflater.from(parent.context)
//        val binding = ItemPreviewCvBinding.inflate(inflater, parent, false)
//        return CVPreviewViewHolder(binding)
//    }
//
//    override fun onBindViewHolder(holder: CVPreviewViewHolder, position: Int) {
//        val cv = cvList[position]
//        holder.bind(cv)
//    }
//
//    override fun getItemCount(): Int = cvList.size
//
//    inner class CVPreviewViewHolder(private val binding: ItemPreviewCvBinding) : RecyclerView.ViewHolder(binding.root) {
//        fun bind(cv: CV) {
//            val personal = cv.personal
//            val education = cv.education
//            val skills = cv.skills
//            val experience = cv.experience
//
//            binding.firstName.text = personal.firstName
//            binding.lastName.text = personal.lastName
//            binding.jobTitle.text = personal.jobTitle
//            binding.phoneNumber.text = personal.phoneNumber
//            binding.email.text = personal.email
//            binding.address.text = personal.address
//            binding.aboutMe.text = personal.aboutMe
//            binding.date.text = education.date
//            binding.universityName.text = education.universityName
//            binding.major.text = education.major
//            binding.skill1.text = skills.skill1
//            binding.skill2.text = skills.skill2
//            binding.skill3.text = skills.skill3
//            binding.skill4.text = skills.skill4
//            binding.jobName.text = experience.jobName
//            binding.jobPosition.text = experience.jobPosition
//            binding.jobDescription.text = experience.jobDescription
//        }
//    }
//}
