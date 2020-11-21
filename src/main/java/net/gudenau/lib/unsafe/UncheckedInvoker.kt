package net.gudenau.lib.unsafe

@Suppress("IfThenToElvis")
fun throwThrowable(throwable: Throwable?): RuntimeException {
    throw if (throwable == null) {
        NullPointerException()
    } else {
        throwable
    }
}
