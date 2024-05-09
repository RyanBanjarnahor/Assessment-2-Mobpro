package org.d3if0098.asessment2.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import org.d3if0098.asessment2.model.Paket

@Dao
interface PaketDao {

    @Insert
    suspend fun insert(paket: Paket)

    @Update
    suspend fun update(paket: Paket)

    @Query("SELECT * FROM paket ORDER BY tanggal DESC")
    fun getPaket(): Flow<List<Paket>>

    @Query("SELECT * FROM paket WHERE id = :id")
    suspend fun getPaketById(id: Long): Paket?
    @Query("DELETE FROM paket WHERE id = :id")
    suspend fun deleteById(id: Long)


}