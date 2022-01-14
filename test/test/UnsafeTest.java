package test;

import lombok.val;
import net.gudenau.lib.unsafe.Unsafe;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

@SuppressWarnings("StringEquality")
@Testable
public class UnsafeTest {
    @Test
    public void allocateInstance() {
        assert Unsafe.allocateInstance(UnsafeTest.class).getClass() == UnsafeTest.class;
    }

    @Test
    public void throwable() {
        val message = "Throwable message";

        try {
            Unsafe.throwException(new Throwable(message));

            throw new AssertionError();
        } catch (Throwable throwable) {
            assert throwable.getClass() == Throwable.class && throwable.getMessage() == message;
        }
    }
}
