package uz.personal.mvvmappdemo.foundation.sideeffects

import uz.personal.mvvmappdemo.foundation.ActivityScopeViewModel
import uz.personal.mvvmappdemo.foundation.utils.MainThreadExecutor
import uz.personal.mvvmappdemo.foundation.utils.ResourceActions
import java.util.concurrent.Executor

/**
 * Base class for all side-effect mediators.
 * These mediators live in [ActivityScopeViewModel].
 * Mediator should delegate all UI-related logic to the implementations via [target] field.
 */
open class SideEffectMediator<Implementation>(
    executor: Executor = MainThreadExecutor()
) {

    protected val target = ResourceActions<Implementation>(executor)

    /**
     * Assign/unassign the target implementation for this mediator.
     */
    fun setTarget(target: Implementation?) {
        this.target.resource = target
    }

    fun clear() {
        target.clear()
    }

}