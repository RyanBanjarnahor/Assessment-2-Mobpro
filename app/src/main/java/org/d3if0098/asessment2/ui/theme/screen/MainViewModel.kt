package org.d3if0098.asessment2.ui.theme.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import org.d3if0098.asessment2.database.PaketDao
import org.d3if0098.asessment2.model.Paket

class MainViewModel(dao: PaketDao) : ViewModel() {

    val data: StateFlow<List<Paket>> = dao.getPaket().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000L),
        initialValue = emptyList()
    )

}