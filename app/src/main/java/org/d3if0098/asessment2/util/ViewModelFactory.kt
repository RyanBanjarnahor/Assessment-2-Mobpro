package org.d3if0098.asessment2.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.d3if0098.asessment2.database.PaketDao
import org.d3if0098.asessment2.ui.theme.screen.DetailViewModel
import org.d3if0098.asessment2.ui.theme.screen.MainViewModel

class ViewModelFactory(
    private val dao: PaketDao
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T: ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(dao) as T
        } else if ( modelClass.isAssignableFrom(DetailViewModel::class.java) ) {
            return DetailViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}