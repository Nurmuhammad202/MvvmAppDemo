package uz.personal.mvvmappdemo.foundation.model.coroutines

import kotlinx.coroutines.CancellableContinuation
import uz.personal.mvvmappdemo.foundation.model.ErrorResult
import uz.personal.mvvmappdemo.foundation.model.FinalResult
import uz.personal.mvvmappdemo.foundation.model.SuccessResult
import java.util.concurrent.atomic.AtomicBoolean
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

/**
 * Convert coroutine [CancellableContinuation] instance into simpler [Emitter] instance.
 */
fun <T> CancellableContinuation<T>.toEmitter(): Emitter<T> {

    return object : Emitter<T> {

        var done = AtomicBoolean(false)

        override fun emit(finalResult: FinalResult<T>) {
            if (done.compareAndSet(false, true)) {
                when (finalResult) {
                    is SuccessResult -> resume(finalResult.data)
                    is ErrorResult -> resumeWithException(finalResult.exception)
                }
            }
        }

        override fun setCancelListener(cancelListener: CancelListener) {
            invokeOnCancellation { cancelListener() }
        }
    }

}
