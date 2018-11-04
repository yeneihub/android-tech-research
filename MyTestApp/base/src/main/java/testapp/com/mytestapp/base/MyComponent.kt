package testapp.com.mytestapp.base

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [MyModule::class])
interface MyComponent {
    fun inject(mainActivity: MainActivity)
}