package test;

import net.gudenau.lib.unsafe.Unsafe;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

@SuppressWarnings("StringEquality")
@Testable
public class UnsafeTest extends Unsafe {
    @Test void allocateInstanceTest() {
        assert allocateInstance(UnsafeTest.class).getClass() == UnsafeTest.class;
    }

    @Test void throwable() {
        var message = "Throwable message";

        try {
            throwException(new Throwable(message));

            throw new AssertionError();
        } catch (Throwable throwable) {
            assert throwable.getClass() == Throwable.class && throwable.getMessage() == message;
        }
    }
}
