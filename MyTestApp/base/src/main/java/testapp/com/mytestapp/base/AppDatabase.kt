package testapp.com.mytestapp.base

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase

@Database(entities = [Data::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    companion object {
        const val APP_DATABASE_NAME = "my_app_database"
//        private val databaseInstance: AppDatabase? = null
//
//        fun getInstance(context: Context) = databaseInstance ?: Room.databaseBuilder(context, AppDatabase::class.java, APP_DATABASE_NAME).build()
    }

    abstract fun dataDao(): DataDao
}