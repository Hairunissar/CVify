package org.d3if3058.cvify.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.d3if3058.cvify.model.CV
import org.d3if3058.cvify.model.CVRepository

class CVViewModel(private val cvRepository: CVRepository) : ViewModel() {

    val allCVs: LiveData<List<CV>> = cvRepository.allCVs

    fun insertCV(cv: CV) {
        viewModelScope.launch {
            cvRepository.insertCV(cv)
        }
    }

    fun updateCV(cv: CV) {
        viewModelScope.launch {
            cvRepository.updateCV(cv)
        }
    }

    fun deleteCV(cv: CV) {
        viewModelScope.launch {
            cvRepository.deleteCV(cv)
        }
    }
}
