package testapp.com.mytestapp.base

import android.app.Application

class MyApplication: Application() {

    lateinit var myComponent: MyComponent

    override fun onCreate() {
        super.onCreate()
        myComponent = createComponent()
    }

    private fun createComponent() =
        DaggerMyComponent
            .builder()
            .myModule(MyModule(this))
            .build()
}