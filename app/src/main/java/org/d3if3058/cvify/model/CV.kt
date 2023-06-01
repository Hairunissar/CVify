package org.d3if3058.cvify.model

import androidx.room.Entity

@Entity(tableName = "cv_table")
data class CV(
    val personal: List<Personal>,
    val skills: List<Skill>,
    val education: List<Education>,
    val experience: List<Experience>
)

data class Personal(
    val firstName: String,
    val lastName: String,
    val jobTitle: String,
    val aboutMe: String,
    val phoneNumber: String,
    val email: String,
    val address: String
)

data class Skill(
    val skill1: String,
    val skill2: String,
    val skill3: String,
    val skill4: String,

)

data class Education(
    val date: String,
    val universityName: String,
    val major: String
)

data class Experience(
    val jobName: String,
    val jobPosition: String,
    val jobDescription: String
)
