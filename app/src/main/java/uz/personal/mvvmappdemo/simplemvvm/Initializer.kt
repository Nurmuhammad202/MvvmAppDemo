package uz.personal.mvvmappdemo.simplemvvm

import uz.personal.mvvmappdemo.foundation.SingletonScopeDependencies
import uz.personal.mvvmappdemo.foundation.model.coroutines.IoDispatcher
import uz.personal.mvvmappdemo.foundation.model.coroutines.WorkerDispatcher
import uz.personal.mvvmappdemo.simplemvvm.model.colors.InMemoryColorsRepository

object Initializer {

    // Place your singleton scope dependencies here
    fun initDependencies() = SingletonScopeDependencies.init { applicationContext ->
        // this block of code is executed only once upon the first request

        // holder classes are used because we have 2 dispatchers of the same type
        val ioDispatcher = IoDispatcher() // for IO operations
        val workerDispatcher = WorkerDispatcher() // for CPU-intensive operations

        return@init listOf(
            ioDispatcher,
            workerDispatcher,

            InMemoryColorsRepository(ioDispatcher)
        )
    }


}