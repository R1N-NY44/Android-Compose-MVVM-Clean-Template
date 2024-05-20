package R1N.NY44.mvvm.system.utils

import R1N.NY44.mvvm.system.database.SystemViewModel
import R1N.NY44.mvvm.system.database.dao.RoomDatabase
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ViewModelFactory(private val dao: RoomDatabase) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SystemViewModel::class.java)) {
            return SystemViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}