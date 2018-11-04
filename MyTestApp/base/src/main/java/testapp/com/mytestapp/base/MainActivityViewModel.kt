package testapp.com.mytestapp.base

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainActivityViewModel constructor(private val database: AppDatabase): ViewModel() {
    val data = MutableLiveData<List<Data?>>()

    fun addData(data: Data, onComplete: () -> Unit) {
        GlobalScope.launch {
            database.dataDao().insertAll(data)
            onComplete()
        }
    }

    fun getDataList() {
        GlobalScope.launch {
            val result = database.dataDao().getAllData()
            withContext(Dispatchers.Main) {
                data.value = result
            }
        }
    }
}

@Suppress("UNCHECKED_CAST")
class MainActivityViewModelFactory @Inject constructor(private val database: AppDatabase): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T = MainActivityViewModel(database) as T

}