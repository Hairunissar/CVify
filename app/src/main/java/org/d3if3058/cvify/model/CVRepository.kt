package org.d3if3058.cvify.model

import androidx.lifecycle.LiveData
import org.d3if3058.cvify.data.CVDao

class CVRepository(private val cvDao: CVDao) {

    val allCVs: LiveData<List<CV>> = cvDao.getAllCVs()

    suspend fun insertCV(cv: CV) {
        cvDao.insertCV(cv)
    }

    suspend fun updateCV(cv: CV) {
        cvDao.updateCV(cv)
    }

    suspend fun deleteCV(cv: CV) {
        cvDao.deleteCV(cv)
    }
}
