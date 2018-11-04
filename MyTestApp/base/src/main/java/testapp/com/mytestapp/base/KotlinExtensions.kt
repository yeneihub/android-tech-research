package testapp.com.mytestapp.base

import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope

suspend fun <T> startBackground(func: () -> T, onCompleted: (T) -> Unit) =
    coroutineScope {
        val def = async { func() }

        onCompleted(def.await())
    }