package net.gudenau.lib.unsafe;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

@SuppressWarnings("FieldCanBeLocal")
@Testable
public class UnsafeTest {
    @Test
    public void throwableTest() throws Throwable {
        try {
            Unsafe.throwException(new Throwable());
        } catch (final RuntimeException exception) {
            System.out.println("failure");

            System.exit(1);
        }

        System.out.println("success");
    }
}
