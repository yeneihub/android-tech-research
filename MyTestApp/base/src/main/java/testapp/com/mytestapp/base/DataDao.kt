package testapp.com.mytestapp.base

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query

@Dao
interface DataDao {
    @Query("SELECT * FROM data")
    fun getAllData(): List<Data>

    @Insert
    fun insertAll(vararg data: Data)
}