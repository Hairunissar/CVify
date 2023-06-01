package org.d3if3058.cvify.data

import androidx.lifecycle.LiveData
import androidx.room.*
import org.d3if3058.cvify.model.CV

@Dao
interface CVDao {
    @Query("SELECT * FROM cv_table")
    fun getAllCVs(): LiveData<List<CV>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCV(cv: CV)

    @Update
    suspend fun updateCV(cv: CV)

    @Delete
    suspend fun deleteCV(cv: CV)
}
