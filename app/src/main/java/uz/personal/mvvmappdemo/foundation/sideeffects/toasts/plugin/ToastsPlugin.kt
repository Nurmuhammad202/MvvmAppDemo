package uz.personal.mvvmappdemo.foundation.sideeffects.toasts.plugin

import android.content.Context
import uz.personal.mvvmappdemo.foundation.sideeffects.SideEffectMediator
import uz.personal.mvvmappdemo.foundation.sideeffects.SideEffectPlugin
import uz.personal.mvvmappdemo.foundation.sideeffects.toasts.Toasts

/**
 * Plugin for displaying toast messages from view-models.
 * Allows adding [Toasts] interface to the view-model constructor.
 */
class ToastsPlugin : SideEffectPlugin<Toasts, Nothing> {

    override val mediatorClass: Class<Toasts>
        get() = Toasts::class.java

    override fun createMediator(applicationContext: Context): SideEffectMediator<Nothing> {
        return ToastsSideEffectMediator(applicationContext)
    }

}