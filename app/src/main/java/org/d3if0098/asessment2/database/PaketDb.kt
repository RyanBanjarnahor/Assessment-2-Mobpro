package org.d3if0098.asessment2.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import org.d3if0098.asessment2.model.Paket

@Database(entities = [Paket::class], version = 1, exportSchema = false)
abstract class PaketDb : RoomDatabase() {

    abstract val dao: PaketDao

    companion object {

        @Volatile
        private var INSTANCE: PaketDb? = null

        fun getInstance(context: Context): PaketDb {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        PaketDb::class.java,
                        "catatan.db"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}