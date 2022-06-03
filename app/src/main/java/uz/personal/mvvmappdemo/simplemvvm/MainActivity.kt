package uz.personal.mvvmappdemo.simplemvvm

import android.os.Bundle
import uz.personal.mvvmappdemo.foundation.sideeffects.navigator.plugin.StackFragmentNavigator
import uz.personal.mvvmappdemo.foundation.sideeffects.navigator.plugin.NavigatorPlugin
import uz.personal.mvvmappdemo.foundation.sideeffects.SideEffectPluginsManager
import uz.personal.mvvmappdemo.foundation.sideeffects.dialogs.plugin.DialogsPlugin
import uz.personal.mvvmappdemo.foundation.sideeffects.intents.plugin.IntentsPlugin
import uz.personal.mvvmappdemo.foundation.sideeffects.permissions.plugin.PermissionsPlugin
import uz.personal.mvvmappdemo.foundation.sideeffects.resources.plugin.ResourcesPlugin
import uz.personal.mvvmappdemo.foundation.sideeffects.toasts.plugin.ToastsPlugin
import uz.personal.mvvmappdemo.foundation.views.activity.BaseActivity
import uz.personal.mvvmappdemo.simplemvvm.views.currentcolor.CurrentColorFragment
import uz.personal.mvvmappdemo.R

/**
 * This application is a single-activity app. MainActivity is a container
 * for all screens.
 */
class MainActivity : BaseActivity() {

    override fun registerPlugins(manager: SideEffectPluginsManager) = with (manager) {
        val navigator = createNavigator()
        register(ToastsPlugin())
        register(ResourcesPlugin())
        register(NavigatorPlugin(navigator))
        register(PermissionsPlugin())
        register(DialogsPlugin())
        register(IntentsPlugin())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Initializer.initDependencies()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun createNavigator() = StackFragmentNavigator(
            containerId = R.id.fragmentContainer,
            defaultTitle = getString(R.string.app_name),
            animations = StackFragmentNavigator.Animations(
                enterAnim = R.anim.enter,
                exitAnim = R.anim.exit,
                popEnterAnim = R.anim.pop_enter,
                popExitAnim = R.anim.pop_exit
            ),
            initialScreenCreator = { CurrentColorFragment.Screen() }
        )

}