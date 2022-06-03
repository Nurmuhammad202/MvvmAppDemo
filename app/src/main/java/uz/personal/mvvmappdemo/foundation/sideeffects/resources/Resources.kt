package uz.personal.mvvmappdemo.foundation.sideeffects.resources

import androidx.annotation.StringRes
import uz.personal.mvvmappdemo.foundation.sideeffects.resources.plugin.ResourcesPlugin

/**
 * Interface for accessing resources from view-models.
 * You need to add [ResourcesPlugin] to your activity before using this feature.
 */
interface Resources {

    fun getString(@StringRes resId: Int, vararg args: Any): String

}