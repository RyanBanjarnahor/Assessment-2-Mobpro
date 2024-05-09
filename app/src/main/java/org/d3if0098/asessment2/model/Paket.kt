package org.d3if0098.asessment2.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "paket")
data class Paket(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val nama: String,
    val paket: String,
    val alamat: String,
    val tanggal: String
)
