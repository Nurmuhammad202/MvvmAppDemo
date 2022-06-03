package uz.personal.mvvmappdemo.foundation.sideeffects.intents.plugin

import android.content.Context
import uz.personal.mvvmappdemo.foundation.sideeffects.SideEffectMediator
import uz.personal.mvvmappdemo.foundation.sideeffects.SideEffectPlugin
import uz.personal.mvvmappdemo.foundation.sideeffects.intents.Intents

/**
 * Plugin for launching system activities from view-models.
 * Allows adding [Intents] interface to the view-model constructor.
 */
class IntentsPlugin : SideEffectPlugin<Intents, Nothing> {

    override val mediatorClass: Class<Intents>
        get() = Intents::class.java

    override fun createMediator(applicationContext: Context): SideEffectMediator<Nothing> {
        return IntentsSideEffectMediator(applicationContext)
    }

}