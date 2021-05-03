package net.gudenau.lib.unsafe;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.annotation.Testable;

@SuppressWarnings("StringEquality")
@Testable
public class UnsafeTest {
    @Test
    public void allocateInstance() {
        assert Unsafe.allocateInstance(UnsafeTest.class) != null;
    }

    @Test
    public void throwable() {
        String message = "Throwable message";

        try {
            Unsafe.throwException(new Throwable(message));
        } catch (Throwable throwable) {
            if (throwable.getClass() == Throwable.class && throwable.getMessage() == message) {
                return;
            }
        }

        throw new AssertionError();
    }

    @Test
    public void memory() {
        long address = Unsafe.allocateMemory(24);
        Object[] box = {new Object() {}};

        Unsafe.setMemory(address, 24, (byte) 123);
        Unsafe.putAddress(address + 12, 8L * Unsafe.getInt(box, Unsafe.ARRAY_OBJECT_BASE_OFFSET));

        assert Unsafe.getUncompressedObject(address + 12) == box[0];
    }
}
