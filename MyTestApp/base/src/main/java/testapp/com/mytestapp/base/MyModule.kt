package testapp.com.mytestapp.base

import android.arch.persistence.room.Room
import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MyModule(val context: Context) {

    @Provides
    @Singleton
    fun providesContext() = context

    @Provides
    @Singleton
    fun providesAppDatabase(context: Context) = Room.databaseBuilder(context, AppDatabase::class.java, AppDatabase.APP_DATABASE_NAME).build()

}