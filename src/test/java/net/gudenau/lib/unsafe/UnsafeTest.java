package net.gudenau.lib.unsafe;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

@SuppressWarnings("FieldCanBeLocal")
@Testable
public class UnsafeTest {
    @Test
    public void throwableTest() throws Throwable {
        try {
            final Object object = Unsafe.throwException(new Throwable());
        } catch (final Throwable throwable) {
            if (throwable.getClass() == Throwable.class) {
                System.out.println("success");

                System.exit(0);
            }
        }

        System.out.println("failure");

        System.exit(1);
    }

    @Test
    public void thhrow(final Throwable throwable) throws Throwable {
        throw throwable;
    }
}
