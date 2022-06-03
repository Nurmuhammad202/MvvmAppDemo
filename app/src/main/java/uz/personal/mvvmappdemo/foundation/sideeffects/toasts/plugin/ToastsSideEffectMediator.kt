package uz.personal.mvvmappdemo.foundation.sideeffects.toasts.plugin

import android.content.Context
import android.widget.Toast
import uz.personal.mvvmappdemo.foundation.utils.MainThreadExecutor
import uz.personal.mvvmappdemo.foundation.sideeffects.SideEffectMediator
import uz.personal.mvvmappdemo.foundation.sideeffects.toasts.Toasts

/**
 * Android implementation of [Toasts]. Displaying simple toast message and getting string from resources.
 */
class ToastsSideEffectMediator(
    private val appContext: Context
) : SideEffectMediator<Nothing>(), Toasts {

    private val executor = MainThreadExecutor()

    override fun toast(message: String) {
        executor.execute {
            Toast.makeText(appContext, message, Toast.LENGTH_SHORT).show()
        }
    }

}