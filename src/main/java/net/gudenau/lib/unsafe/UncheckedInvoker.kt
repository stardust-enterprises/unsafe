package net.gudenau.lib.unsafe

@Suppress("IfThenToElvis")
fun rethrow(throwable: Throwable?): RuntimeException {
    throw if (throwable == null) {
        NullPointerException()
    } else {
        throwable
    }
}
