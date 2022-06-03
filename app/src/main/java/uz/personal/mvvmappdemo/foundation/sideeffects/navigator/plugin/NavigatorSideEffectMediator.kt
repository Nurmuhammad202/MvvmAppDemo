package uz.personal.mvvmappdemo.foundation.sideeffects.navigator.plugin

import uz.personal.mvvmappdemo.foundation.sideeffects.SideEffectMediator
import uz.personal.mvvmappdemo.foundation.sideeffects.navigator.Navigator
import uz.personal.mvvmappdemo.foundation.views.BaseScreen

class NavigatorSideEffectMediator : SideEffectMediator<Navigator>(), Navigator {

    override fun launch(screen: BaseScreen) = target {
        it.launch(screen)
    }

    override fun goBack(result: Any?) = target {
        it.goBack(result)
    }

}