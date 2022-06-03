package uz.personal.mvvmappdemo.foundation.utils

import java.util.concurrent.Executor

typealias ResourceAction<T> = (T) -> Unit

/**
 * Actions queue, where actions are executed only if resource exists. If it doesn't then
 * action is added to queue and waits until resource becomes available.
 */
class ResourceActions<T>(
    private val executor: Executor
) {

    var resource: T? = null
        set(newValue) {
            field = newValue
            if (newValue != null) {
                actions.forEach { action ->
                    executor.execute {
                        action(newValue)
                    }
                }
                actions.clear()
            }
        }

    private val actions = mutableListOf<ResourceAction<T>>()

    /**
     * Invoke the action only when [resource] exists (not null). Otherwise
     * the action is postponed until some non-null value is assigned to [resource]
     */
    operator fun invoke(action: ResourceAction<T>) {
        val resource = this.resource
        if (resource == null) {
            actions += action
        } else {
            executor.execute {
                action(resource)
            }
        }
    }

    fun clear() {
        actions.clear()
    }
}