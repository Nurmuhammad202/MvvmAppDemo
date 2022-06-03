package uz.personal.mvvmappdemo.foundation.sideeffects.resources.plugin

import android.content.Context
import uz.personal.mvvmappdemo.foundation.sideeffects.SideEffectMediator
import uz.personal.mvvmappdemo.foundation.sideeffects.SideEffectPlugin
import uz.personal.mvvmappdemo.foundation.sideeffects.resources.Resources

/**
 * Plugin for accessing app resources from view-models.
 * Allows adding [Resources] interface to the view-model constructor.
 */
class ResourcesPlugin : SideEffectPlugin<ResourcesSideEffectMediator, Nothing> {

    override val mediatorClass: Class<ResourcesSideEffectMediator>
        get() = ResourcesSideEffectMediator::class.java

    override fun createMediator(applicationContext: Context): SideEffectMediator<Nothing> {
        return ResourcesSideEffectMediator(applicationContext)
    }

}