package net.gudenau.lib.unsafe;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

@SuppressWarnings({"FieldCanBeLocal", "StringEquality"})
@Testable
public class UnsafeTest {
    @Test
    public void genericCast() {
        assert Unsafe.allocateInstance(UnsafeTest.class) != null;
    }

    @Test
    public void throwableTest() {
        String message = "Throwable message";

        try {
            Object exception = Unsafe.throwException(new Throwable(message));
        } catch (Throwable throwable) {
            throwable.printStackTrace(System.out);

            if (throwable.getClass() == Throwable.class && throwable.getMessage() == message) {
                System.out.println("success");

                return;
            }
        }

        System.out.println("failure");

        System.exit(1);
    }
}
