package uz.personal.mvvmappdemo.foundation.sideeffects.intents

import uz.personal.mvvmappdemo.foundation.sideeffects.intents.plugin.IntentsPlugin

/**
 * Side-effects interface for launching some system activities.
 * You need to add [IntentsPlugin] to your activity before using this feature.
 */
interface Intents {

    /**
     * Open system settings for this application.
     */
    fun openAppSettings()

}