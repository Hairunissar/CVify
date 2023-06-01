package org.d3if3058.cvify.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import org.d3if3058.cvify.model.CV

import kotlin.jvm.Volatile;

@Database(entities = [CV::class], version = 1)
abstract class CVDatabase : RoomDatabase() {
    abstract fun cvDao(): CVDao

    companion object {
        @Volatile
        private var INSTANCE: CVDatabase? = null

        fun getDatabase(context: Context): CVDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CVDatabase::class.java,
                    "cv_database"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}
