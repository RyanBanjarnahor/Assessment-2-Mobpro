package org.d3if0098.asessment2.ui.theme.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.d3if0098.asessment2.database.PaketDao
import org.d3if0098.asessment2.model.Paket
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class DetailViewModel(private val dao: PaketDao) : ViewModel() {

    private val formatter = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US)

    fun insert(nama: String, isi: String, alamat: String) {
        val paket = Paket (
            tanggal = formatter.format(Date()),
            nama = nama,
            paket = isi,
            alamat = alamat
        )

        viewModelScope.launch(Dispatchers.IO) {
            dao.insert(paket)
        }
    }

    suspend fun getPaket(id: Long): Paket? {
        return dao.getPaketById(id)
    }

    fun update(id: Long, nama: String, isi: String, alamat: String) {
        val paket = Paket(
            id = id,
            tanggal = formatter.format(Date()),
            nama = nama,
            paket = isi,
            alamat = alamat
        )

        viewModelScope.launch(Dispatchers.IO) {
            dao.update(paket)
        }
    }

    fun delete(id: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            dao.deleteById(id)
        }
    }

}