package org.d3if0098.asessment2.navigation

import org.d3if0098.asessment2.ui.theme.screen.KEY_ID_PAKET

sealed class Screen(val route: String) {
    data object Home: Screen("mainScreen")
    data object FormBaru: Screen("detailScreen")
    data object FormUbah: Screen("detailScreen/{$KEY_ID_PAKET}") {
        fun withId(id: Long) = "detailScreen/$id"
    }
}