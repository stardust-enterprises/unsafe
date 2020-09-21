package net.gudenau.lib.unsafe;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.nio.ByteBuffer;
import java.security.ProtectionDomain;

@SuppressWarnings({"unchecked", "unused", "RedundantSuppression"})
public class Unsafe {
    public static final MethodHandles.Lookup trustedLookup;
    public static final Class<?> Unsafe;
    public static final Object theUnsafe;

    private static final MethodHandle getObjectInt;
    private static final MethodHandle putObjectInt;
    private static final MethodHandle getObjectObject;
    private static final MethodHandle putObjectObject;
    private static final MethodHandle getObjectBoolean;
    private static final MethodHandle putObjectBoolean;
    private static final MethodHandle getObjectByte;
    private static final MethodHandle putObjectByte;
    private static final MethodHandle getObjectShort;
    private static final MethodHandle putObjectShort;
    private static final MethodHandle getObjectChar;
    private static final MethodHandle putObjectChar;
    private static final MethodHandle getObjectLong;
    private static final MethodHandle putObjectLong;
    private static final MethodHandle getObjectFloat;
    private static final MethodHandle putObjectFloat;
    private static final MethodHandle getObjectDouble;
    private static final MethodHandle putObjectDouble;
    private static final MethodHandle getByte;
    private static final MethodHandle putByte;
    private static final MethodHandle getShort;
    private static final MethodHandle putShort;
    private static final MethodHandle getChar;
    private static final MethodHandle putChar;
    private static final MethodHandle getInt;
    private static final MethodHandle putInt;
    private static final MethodHandle getLong;
    private static final MethodHandle putLong;
    private static final MethodHandle getFloat;
    private static final MethodHandle putFloat;
    private static final MethodHandle getDouble;
    private static final MethodHandle putDouble;
    private static final MethodHandle getAddress;
    private static final MethodHandle putAddress;
    private static final MethodHandle allocateMemory;
    private static final MethodHandle reallocateMemory;
    private static final MethodHandle setObjectMemory;
    private static final MethodHandle setMemory;
    private static final MethodHandle copyObjectMemory;
    private static final MethodHandle copyMemory;
    private static final MethodHandle freeMemory;
    private static final MethodHandle objectFieldOffset;
    private static final MethodHandle staticFieldOffset;
    private static final MethodHandle staticFieldBase;
    private static final MethodHandle shouldBeInitialized;
    private static final MethodHandle ensureClassInitialized;
    private static final MethodHandle arrayBaseOffset;
    private static final MethodHandle arrayIndexScale;
    private static final MethodHandle addressSize;
    private static final MethodHandle pageSize;
    private static final MethodHandle defineClass;
    private static final MethodHandle defineAnonymousClass;
    private static final MethodHandle allocateInstance;
    private static final MethodHandle throwException;
    private static final MethodHandle compareAndSwapObject;
    private static final MethodHandle compareAndSwapInt;
    private static final MethodHandle compareAndSwapLong;
    private static final MethodHandle getObjectVolatile;
    private static final MethodHandle putObjectVolatile;
    private static final MethodHandle getIntVolatile;
    private static final MethodHandle putIntVolatile;
    private static final MethodHandle getBooleanVolatile;
    private static final MethodHandle putBooleanVolatile;
    private static final MethodHandle getByteVolatile;
    private static final MethodHandle putByteVolatile;
    private static final MethodHandle getShortVolatile;
    private static final MethodHandle putShortVolatile;
    private static final MethodHandle getCharVolatile;
    private static final MethodHandle putCharVolatile;
    private static final MethodHandle getLongVolatile;
    private static final MethodHandle putLongVolatile;
    private static final MethodHandle getFloatVolatile;
    private static final MethodHandle putFloatVolatile;
    private static final MethodHandle getDoubleVolatile;
    private static final MethodHandle putDoubleVolatile;
    private static final MethodHandle putOrderedObject;
    private static final MethodHandle putOrderedInt;
    private static final MethodHandle putOrderedLong;
    private static final MethodHandle unpark;
    private static final MethodHandle park;
    private static final MethodHandle getLoadAverage;
    private static final MethodHandle getAndAddInt;
    private static final MethodHandle getAndAddLong;
    private static final MethodHandle getAndSetInt;
    private static final MethodHandle getAndSetLong;
    private static final MethodHandle getAndSetObject;
    private static final MethodHandle loadFence;
    private static final MethodHandle storeFence;
    private static final MethodHandle fullFence;
    private static final MethodHandle invokeCleaner;

    public static final int ARRAY_BOOLEAN_BASE_OFFSET;
    public static final int ARRAY_BYTE_BASE_OFFSET;
    public static final int ARRAY_SHORT_BASE_OFFSET;
    public static final int ARRAY_CHAR_BASE_OFFSET;
    public static final int ARRAY_INT_BASE_OFFSET;
    public static final int ARRAY_LONG_BASE_OFFSET;
    public static final int ARRAY_FLOAT_BASE_OFFSET;
    public static final int ARRAY_DOUBLE_BASE_OFFSET;
    public static final int ARRAY_OBJECT_BASE_OFFSET;

    public static final int ARRAY_BOOLEAN_INDEX_SCALE;
    public static final int ARRAY_BYTE_INDEX_SCALE;
    public static final int ARRAY_SHORT_INDEX_SCALE;
    public static final int ARRAY_CHAR_INDEX_SCALE;
    public static final int ARRAY_INT_INDEX_SCALE;
    public static final int ARRAY_LONG_INDEX_SCALE;
    public static final int ARRAY_FLOAT_INDEX_SCALE;
    public static final int ARRAY_DOUBLE_INDEX_SCALE;
    public static final int ARRAY_OBJECT_INDEX_SCALE;

    public static final int ADDRESS_SIZE;

    public static final int INVALID_FIELD_OFFSET = -1;

    public static void main(final String[] args) {

    }

    public static int getInt(Object o, long offset) {
        try {
            return (int) getObjectInt.invokeExact(o, offset);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static void putInt(Object o, long offset, int x) {
        try {
            putObjectInt.invokeExact(o, offset, x);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static Object getObject(Object o, long offset) {
        try {
            return getObjectObject.invokeExact(o, offset);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static void putObject(Object o, long offset, Object x) {
        try {
            putObjectObject.invokeExact(o, offset, x);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static boolean getBoolean(Object o, long offset) {
        try {
            return (boolean) getObjectBoolean.invokeExact(o, offset);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static void putBoolean(Object o, long offset, boolean x) {
        try {
            putObjectBoolean.invokeExact(o, offset, x);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static byte getByte(Object o, long offset) {
        try {
            return (byte) getObjectByte.invokeExact(o, offset);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static void putByte(Object o, long offset, byte x) {
        try {
            putObjectByte.invokeExact(o, offset, x);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static short getShort(Object o, long offset) {
        try {
            return (short) getObjectShort.invokeExact(o, offset);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static void putShort(Object o, long offset, short x) {
        try {
            putObjectShort.invokeExact(o, offset, x);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static char getChar(Object o, long offset) {
        try {
            return (char) getObjectChar.invokeExact(o, offset);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static void putChar(Object o, long offset, char x) {
        try {
            putObjectChar.invokeExact(o, offset, x);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static long getLong(Object o, long offset) {
        try {
            return (long) getObjectLong.invokeExact(o, offset);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static void putLong(Object o, long offset, long x) {
        try {
            putObjectLong.invokeExact(o, offset, x);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static float getFloat(Object o, long offset) {
        try {
            return (float) getObjectFloat.invokeExact(o, offset);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static void putFloat(Object o, long offset, float x) {
        try {
            putObjectFloat.invokeExact(o, offset, x);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static double getDouble(Object o, long offset) {
        try {
            return (double) getObjectDouble.invokeExact(o, offset);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static void putDouble(Object o, long offset, double x) {
        try {
            putObjectDouble.invokeExact(o, offset, x);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static byte getByte(long address) {
        try {
            return (byte) getByte.invokeExact(address);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static void putByte(long address, byte x) {
        try {
            putByte.invokeExact(address, x);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static short getShort(long address) {
        try {
            return (short) getShort.invokeExact(address);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static void putShort(long address, short x) {
        try {
            putShort.invokeExact(address, x);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static char getChar(long address) {
        try {
            return (char) getChar.invokeExact(address);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static void putChar(long address, char x) {
        try {
            putChar.invokeExact(address, x);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static int getInt(long address) {
        try {
            return (int) getInt.invokeExact(address);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static void putInt(long address, int x) {
        try {
            putInt.invokeExact(address, x);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static long getLong(long address) {
        try {
            return (long) getLong.invokeExact(address);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static void putLong(long address, long x) {
        try {
            putLong.invokeExact(address, x);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static float getFloat(long address) {
        try {
            return (float) getFloat.invokeExact(address);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static void putFloat(long address, float x) {
        try {
            putFloat.invokeExact(address, x);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static double getDouble(long address) {
        try {
            return (double) getDouble.invokeExact(address);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static void putDouble(long address, double x) {
        try {
            putDouble.invokeExact(address, x);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static long getAddress(long address) {
        try {
            return (long) getAddress.invokeExact(address);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static void putAddress(long address, long x) {
        try {
            putAddress.invokeExact(address, x);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static long allocateMemory(long bytes) {
        try {
            return (long) allocateMemory.invokeExact(bytes);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static long reallocateMemory(long address, long bytes) {
        try {
            return (long) reallocateMemory.invokeExact(address, bytes);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static void setMemory(Object o, long offset, long bytes, byte value) {
        try {
            setObjectMemory.invokeExact(o, offset, bytes, value);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static void setMemory(long address, long bytes, byte value) {
        try {
            setMemory.invokeExact(address, bytes, value);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static void copyMemory(Object srcBase, long srcOffset, Object destBase, long destOffset, long bytes) {
        try {
            copyObjectMemory.invokeExact(srcBase, srcOffset, destBase, destOffset, bytes);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static void copyMemory(long srcAddress, long destAddress, long bytes) {
        try {
            copyMemory.invokeExact(srcAddress, destAddress, bytes);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static void freeMemory(long address) {
        try {
            freeMemory.invokeExact(address);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static long objectFieldOffset(Field f) {
        try {
            return (long) objectFieldOffset.invokeExact(f);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static long staticFieldOffset(final Field f) {
        try {
            return (long) staticFieldOffset.invokeExact(f);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static Object staticFieldBase(final Field f) {
        try {
            return (Object) staticFieldBase.invokeExact(f);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static boolean shouldBeInitialized(final Class<?> klass) {
        try {
            return (boolean) shouldBeInitialized.invokeExact(klass);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static void ensureClassInitialized(Class<?> c) {
        try {
            ensureClassInitialized.invokeExact(c);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static int arrayBaseOffset(Class<?> arrayClass) {
        try {
            return (int) arrayBaseOffset.invokeExact(arrayClass);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static <T> int arrayIndexScale(Class<T> arrayClass) {
        try {
            return (int) arrayIndexScale.invokeExact(arrayClass);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static int addressSize() {
        try {
            return (int) addressSize.invokeExact();
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static int pageSize() {
        try {
            return (int) pageSize.invokeExact();
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static <A> Class<A> defineAnonymousClass(Class<?> hostClass, byte[] data, Object[] cpPatches) {
        try {
            return (Class<A>) defineAnonymousClass.invokeExact(hostClass, data, cpPatches);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static <T> Class<T> defineClass(final String name, final byte[] bytecode, final int offset, final int length, final ClassLoader classLoader, final ProtectionDomain protectionDomain) {
        try {
            return (Class<T>) defineClass.invokeExact(name, bytecode, offset, length, classLoader, protectionDomain);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static <T> T allocateInstance(Class<T> cls) {
        try {
            return (T) (Object) allocateInstance.invokeExact(cls);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static void throwException(Throwable ee) {
        try {
            throwException.invokeExact(ee);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static boolean compareAndSwapObject(Object o, long offset, Object expected, Object x) {
        try {
            return (boolean) compareAndSwapObject.invokeExact(o, offset, expected, x);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static boolean compareAndSwapInt(Object o, long offset, int expected, int x) {
        try {
            return (boolean) compareAndSwapInt.invokeExact(o, offset, expected, x);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static boolean compareAndSwapLong(Object o, long offset, long expected, long x) {
        try {
            return (boolean) compareAndSwapLong.invokeExact(o, offset, expected, x);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static Object getObjectVolatile(Object o, long offset) {
        try {
            return (Object) getObjectVolatile.invokeExact(o, offset);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static void putObjectVolatile(Object o, long offset, Object x) {
        try {
            putObjectVolatile.invokeExact(o, offset, x);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static int getIntVolatile(Object o, long offset) {
        try {
            return (int) getIntVolatile.invokeExact(o, offset);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static void putIntVolatile(Object o, long offset, int x) {
        try {
            putIntVolatile.invokeExact(o, offset, x);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static boolean getBooleanVolatile(Object o, long offset) {
        try {
            return (boolean) getBooleanVolatile.invokeExact(o, offset);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static void putBooleanVolatile(Object o, long offset, boolean x) {
        try {
            putBooleanVolatile.invokeExact(o, offset, x);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static byte getByteVolatile(Object o, long offset) {
        try {
            return (byte) getByteVolatile.invokeExact(o, offset);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static void putByteVolatile(Object o, long offset, byte x) {
        try {
            putByteVolatile.invokeExact(o, offset, x);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static short getShortVolatile(Object o, long offset) {
        try {
            return (short) getShortVolatile.invokeExact(o, offset);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static void putShortVolatile(Object o, long offset, short x) {
        try {
            putShortVolatile.invokeExact(o, offset, x);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static char getCharVolatile(Object o, long offset) {
        try {
            return (char) getCharVolatile.invokeExact(o, offset);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static void putCharVolatile(Object o, long offset, char x) {
        try {
            putCharVolatile.invokeExact(o, offset, x);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static long getLongVolatile(Object o, long offset) {
        try {
            return (long) getLongVolatile.invokeExact(o, offset);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static void putLongVolatile(Object o, long offset, long x) {
        try {
            putLongVolatile.invokeExact(o, offset, x);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static float getFloatVolatile(Object o, long offset) {
        try {
            return (float) getFloatVolatile.invokeExact(o, offset);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static void putFloatVolatile(Object o, long offset, float x) {
        try {
            putFloatVolatile.invokeExact(o, offset, x);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static double getDoubleVolatile(Object o, long offset) {
        try {
            return (double) getDoubleVolatile.invokeExact(o, offset);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static void putDoubleVolatile(Object o, long offset, double x) {
        try {
            putDoubleVolatile.invokeExact(o, offset, x);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static void putOrderedObject(Object o, long offset, Object x) {
        try {
            putOrderedObject.invokeExact(o, offset, x);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static void putOrderedInt(Object o, long offset, int x) {
        try {
            putOrderedInt.invokeExact(o, offset, x);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static void putOrderedLong(Object o, long offset, long x) {
        try {
            putOrderedLong.invokeExact(o, offset, x);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static void unpark(Object thread) {
        try {
            unpark.invokeExact(thread);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static void park(boolean isAbsolute, long time) {
        try {
            park.invokeExact(isAbsolute, time);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static int getLoadAverage(double[] loadavg, int nelems) {
        try {
            return (int) getLoadAverage.invokeExact(loadavg, nelems);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static int getAndAddInt(Object o, long offset, int delta) {
        try {
            return (int) getAndAddInt.invokeExact(o, offset, delta);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static long getAndAddLong(Object o, long offset, long delta) {
        try {
            return (long) getAndAddLong.invokeExact(o, offset, delta);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static int getAndSetInt(Object o, long offset, int newValue) {
        try {
            return (int) getAndSetInt.invokeExact(o, offset, newValue);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static long getAndSetLong(Object o, long offset, long newValue) {
        try {
            return (long) getAndSetLong.invokeExact(o, offset, newValue);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static <T> T getAndSetObject(Object o, long offset, T newValue) {
        try {
            return (T) (Object) getAndSetObject.invokeExact(o, offset, (Object) newValue);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static void loadFence() {
        try {
            loadFence.invokeExact();
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static void storeFence() {
        try {
            storeFence.invokeExact();
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static void fullFence() {
        try {
            fullFence.invokeExact();
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    public static void invokeCleaner(ByteBuffer directBuffer) {
        try {
            invokeCleaner.invokeExact(directBuffer);
        } catch (final Throwable throwable) {
            throw new RuntimeException(throwable);
        }
    }

    static {
        try {
            final String version = System.getProperty("java.version");
            Class<?> klass = Class.forName("sun.misc.Unsafe");
            Object temporaryUnsafe = null;

            for (final Field field : klass.getDeclaredFields()) {
                if (field.getModifiers() == (Modifier.PRIVATE | Modifier.STATIC | Modifier.FINAL) && field.getType() == klass) {
                    field.setAccessible(true);

                    temporaryUnsafe = field.get(null);

                    if (temporaryUnsafe != null) {
                        break;
                    }
                }
            }

            assert temporaryUnsafe != null;

            final MethodHandles.Lookup lookup = MethodHandles.lookup();
            trustedLookup = (MethodHandles.Lookup) (Object) lookup.bind(temporaryUnsafe, "getObject", MethodType.methodType(Object.class, Object.class, long.class))
                                                                  .invokeExact((Object) MethodHandles.Lookup.class, (long) lookup.bind(temporaryUnsafe, "staticFieldOffset", MethodType.methodType(long.class, Field.class))
                                                                                                                                 .invokeExact(MethodHandles.Lookup.class.getDeclaredField("IMPL_LOOKUP")));

            final boolean java9 = version.indexOf('.') != 1 || version.charAt(2) == '9';

            if (java9) {
                klass = Class.forName("jdk.internal.misc.Unsafe");
                temporaryUnsafe = trustedLookup.findStatic(klass, "getUnsafe", MethodType.methodType(klass)).invoke();
            }

            Unsafe = klass;
            theUnsafe = temporaryUnsafe;

            getObjectInt = trustedLookup.bind(theUnsafe, "getInt", MethodType.methodType(int.class, Object.class, long.class));
            getObjectObject = trustedLookup.bind(theUnsafe, "getObject", MethodType.methodType(Object.class, Object.class, long.class));
            getObjectBoolean = trustedLookup.bind(theUnsafe, "getBoolean", MethodType.methodType(boolean.class, Object.class, long.class));
            getObjectByte = trustedLookup.bind(theUnsafe, "getByte", MethodType.methodType(byte.class, Object.class, long.class));
            getObjectShort = trustedLookup.bind(theUnsafe, "getShort", MethodType.methodType(short.class, Object.class, long.class));
            getObjectChar = trustedLookup.bind(theUnsafe, "getChar", MethodType.methodType(char.class, Object.class, long.class));
            getObjectLong = trustedLookup.bind(theUnsafe, "getLong", MethodType.methodType(long.class, Object.class, long.class));
            getObjectFloat = trustedLookup.bind(theUnsafe, "getFloat", MethodType.methodType(float.class, Object.class, long.class));
            getObjectDouble = trustedLookup.bind(theUnsafe, "getDouble", MethodType.methodType(double.class, Object.class, long.class));

            putObjectInt = trustedLookup.bind(theUnsafe, "putInt", MethodType.methodType(void.class, Object.class, long.class, int.class));
            putObjectObject = trustedLookup.bind(theUnsafe, "putObject", MethodType.methodType(void.class, Object.class, long.class, Object.class));
            putObjectBoolean = trustedLookup.bind(theUnsafe, "putBoolean", MethodType.methodType(void.class, Object.class, long.class, boolean.class));
            putObjectByte = trustedLookup.bind(theUnsafe, "putByte", MethodType.methodType(void.class, Object.class, long.class, byte.class));
            putObjectShort = trustedLookup.bind(theUnsafe, "putShort", MethodType.methodType(void.class, Object.class, long.class, short.class));
            putObjectChar = trustedLookup.bind(theUnsafe, "putChar", MethodType.methodType(void.class, Object.class, long.class, char.class));
            putObjectLong = trustedLookup.bind(theUnsafe, "putLong", MethodType.methodType(void.class, Object.class, long.class, long.class));
            putObjectFloat = trustedLookup.bind(theUnsafe, "putFloat", MethodType.methodType(void.class, Object.class, long.class, float.class));
            putObjectDouble = trustedLookup.bind(theUnsafe, "putDouble", MethodType.methodType(void.class, Object.class, long.class, double.class));

            getByte = trustedLookup.bind(theUnsafe, "getByte", MethodType.methodType(byte.class, long.class));
            getShort = trustedLookup.bind(theUnsafe, "getShort", MethodType.methodType(short.class, long.class));
            getChar = trustedLookup.bind(theUnsafe, "getChar", MethodType.methodType(char.class, long.class));
            getInt = trustedLookup.bind(theUnsafe, "getInt", MethodType.methodType(int.class, long.class));
            getLong = trustedLookup.bind(theUnsafe, "getLong", MethodType.methodType(long.class, long.class));
            getFloat = trustedLookup.bind(theUnsafe, "getFloat", MethodType.methodType(float.class, long.class));
            getDouble = trustedLookup.bind(theUnsafe, "getDouble", MethodType.methodType(double.class, long.class));
            getAddress = trustedLookup.bind(theUnsafe, "getAddress", MethodType.methodType(long.class, long.class));

            putByte = trustedLookup.bind(theUnsafe, "putByte", MethodType.methodType(void.class, long.class, byte.class));
            putShort = trustedLookup.bind(theUnsafe, "putShort", MethodType.methodType(void.class, long.class, short.class));
            putChar = trustedLookup.bind(theUnsafe, "putChar", MethodType.methodType(void.class, long.class, char.class));
            putInt = trustedLookup.bind(theUnsafe, "putInt", MethodType.methodType(void.class, long.class, int.class));
            putLong = trustedLookup.bind(theUnsafe, "putLong", MethodType.methodType(void.class, long.class, long.class));
            putFloat = trustedLookup.bind(theUnsafe, "putFloat", MethodType.methodType(void.class, long.class, float.class));
            putDouble = trustedLookup.bind(theUnsafe, "putDouble", MethodType.methodType(void.class, long.class, double.class));
            putAddress = trustedLookup.bind(theUnsafe, "putAddress", MethodType.methodType(void.class, long.class, long.class));

            allocateMemory = trustedLookup.bind(theUnsafe, "allocateMemory", MethodType.methodType(long.class, long.class));
            reallocateMemory = trustedLookup.bind(theUnsafe, "reallocateMemory", MethodType.methodType(long.class, long.class, long.class));
            setObjectMemory = trustedLookup.bind(theUnsafe, "setMemory", MethodType.methodType(void.class, Object.class, long.class, long.class, byte.class));
            setMemory = trustedLookup.bind(theUnsafe, "setMemory", MethodType.methodType(void.class, long.class, long.class, byte.class));
            copyObjectMemory = trustedLookup.bind(theUnsafe, "copyMemory", MethodType.methodType(void.class, Object.class, long.class, Object.class, long.class, long.class));
            copyMemory = trustedLookup.bind(theUnsafe, "copyMemory", MethodType.methodType(void.class, long.class, long.class, long.class));
            freeMemory = trustedLookup.bind(theUnsafe, "freeMemory", MethodType.methodType(void.class, long.class));
            objectFieldOffset = trustedLookup.bind(theUnsafe, "objectFieldOffset", MethodType.methodType(long.class, Field.class));
            staticFieldOffset = trustedLookup.bind(theUnsafe, "staticFieldOffset", MethodType.methodType(long.class, Field.class));
            staticFieldBase = trustedLookup.bind(theUnsafe, "staticFieldBase", MethodType.methodType(Object.class, Field.class));
            shouldBeInitialized = trustedLookup.bind(theUnsafe, "shouldBeInitialized", MethodType.methodType(boolean.class, Class.class));
            ensureClassInitialized = trustedLookup.bind(theUnsafe, "ensureClassInitialized", MethodType.methodType(void.class, Class.class));
            arrayBaseOffset = trustedLookup.bind(theUnsafe, "arrayBaseOffset", MethodType.methodType(int.class, Class.class));
            arrayIndexScale = trustedLookup.bind(theUnsafe, "arrayIndexScale", MethodType.methodType(int.class, Class.class));
            addressSize = trustedLookup.bind(theUnsafe, "addressSize", MethodType.methodType(int.class));
            pageSize = trustedLookup.bind(theUnsafe, "pageSize", MethodType.methodType(int.class));
            defineClass = trustedLookup.bind(theUnsafe, "defineClass", MethodType.methodType(Class.class, String.class, byte[].class, int.class, int.class, ClassLoader.class, ProtectionDomain.class));
            defineAnonymousClass = trustedLookup.bind(theUnsafe, "defineAnonymousClass", MethodType.methodType(Class.class, Class.class, byte[].class, Object[].class));
            allocateInstance = trustedLookup.bind(theUnsafe, "allocateInstance", MethodType.methodType(Object.class, Class.class));
            throwException = trustedLookup.bind(theUnsafe, "throwException", MethodType.methodType(void.class, Throwable.class));

            if (java9) {
                compareAndSwapObject = trustedLookup.bind(theUnsafe, "compareAndSetObject", MethodType.methodType(boolean.class, Object.class, long.class, Object.class, Object.class));
                compareAndSwapInt = trustedLookup.bind(theUnsafe, "compareAndSetInt", MethodType.methodType(boolean.class, Object.class, long.class, int.class, int.class));
                compareAndSwapLong = trustedLookup.bind(theUnsafe, "compareAndSetLong", MethodType.methodType(boolean.class, Object.class, long.class, long.class, long.class));
            } else {
                compareAndSwapObject = trustedLookup.bind(theUnsafe, "compareAndSwapObject", MethodType.methodType(boolean.class, Object.class, long.class, Object.class, Object.class));
                compareAndSwapInt = trustedLookup.bind(theUnsafe, "compareAndSwapInt", MethodType.methodType(boolean.class, Object.class, long.class, int.class, int.class));
                compareAndSwapLong = trustedLookup.bind(theUnsafe, "compareAndSwapLong", MethodType.methodType(boolean.class, Object.class, long.class, long.class, long.class));
            }

            getObjectVolatile = trustedLookup.bind(theUnsafe, "getObjectVolatile", MethodType.methodType(Object.class, Object.class, long.class));
            getIntVolatile = trustedLookup.bind(theUnsafe, "getIntVolatile", MethodType.methodType(int.class, Object.class, long.class));
            getBooleanVolatile = trustedLookup.bind(theUnsafe, "getBooleanVolatile", MethodType.methodType(boolean.class, Object.class, long.class));
            getByteVolatile = trustedLookup.bind(theUnsafe, "getByteVolatile", MethodType.methodType(byte.class, Object.class, long.class));
            getShortVolatile = trustedLookup.bind(theUnsafe, "getShortVolatile", MethodType.methodType(short.class, Object.class, long.class));
            getCharVolatile = trustedLookup.bind(theUnsafe, "getCharVolatile", MethodType.methodType(char.class, Object.class, long.class));
            getLongVolatile = trustedLookup.bind(theUnsafe, "getLongVolatile", MethodType.methodType(long.class, Object.class, long.class));
            getFloatVolatile = trustedLookup.bind(theUnsafe, "getFloatVolatile", MethodType.methodType(float.class, Object.class, long.class));
            getDoubleVolatile = trustedLookup.bind(theUnsafe, "getDoubleVolatile", MethodType.methodType(double.class, Object.class, long.class));

            putObjectVolatile = trustedLookup.bind(theUnsafe, "putObjectVolatile", MethodType.methodType(void.class, Object.class, long.class, Object.class));
            putIntVolatile = trustedLookup.bind(theUnsafe, "putIntVolatile", MethodType.methodType(void.class, Object.class, long.class, int.class));
            putBooleanVolatile = trustedLookup.bind(theUnsafe, "putBooleanVolatile", MethodType.methodType(void.class, Object.class, long.class, boolean.class));
            putByteVolatile = trustedLookup.bind(theUnsafe, "putByteVolatile", MethodType.methodType(void.class, Object.class, long.class, byte.class));
            putShortVolatile = trustedLookup.bind(theUnsafe, "putShortVolatile", MethodType.methodType(void.class, Object.class, long.class, short.class));
            putCharVolatile = trustedLookup.bind(theUnsafe, "putCharVolatile", MethodType.methodType(void.class, Object.class, long.class, char.class));
            putLongVolatile = trustedLookup.bind(theUnsafe, "putLongVolatile", MethodType.methodType(void.class, Object.class, long.class, long.class));
            putFloatVolatile = trustedLookup.bind(theUnsafe, "putFloatVolatile", MethodType.methodType(void.class, Object.class, long.class, float.class));
            putDoubleVolatile = trustedLookup.bind(theUnsafe, "putDoubleVolatile", MethodType.methodType(void.class, Object.class, long.class, double.class));

            if (java9) {
                putOrderedObject = trustedLookup.bind(theUnsafe, "putReferenceRelease", MethodType.methodType(void.class, Object.class, long.class, Object.class));
                putOrderedInt = trustedLookup.bind(theUnsafe, "putIntRelease", MethodType.methodType(void.class, Object.class, long.class, int.class));
                putOrderedLong = trustedLookup.bind(theUnsafe, "putLongRelease", MethodType.methodType(void.class, Object.class, long.class, long.class));
            } else {
                putOrderedObject = trustedLookup.bind(theUnsafe, "putOrderedObject", MethodType.methodType(void.class, Object.class, long.class, Object.class));
                putOrderedInt = trustedLookup.bind(theUnsafe, "putOrderedInt", MethodType.methodType(void.class, Object.class, long.class, int.class));
                putOrderedLong = trustedLookup.bind(theUnsafe, "putOrderedLong", MethodType.methodType(void.class, Object.class, long.class, long.class));
            }

            unpark = trustedLookup.bind(theUnsafe, "unpark", MethodType.methodType(void.class, Object.class));
            park = trustedLookup.bind(theUnsafe, "park", MethodType.methodType(void.class, boolean.class, long.class));
            getLoadAverage = trustedLookup.bind(theUnsafe, "getLoadAverage", MethodType.methodType(int.class, double[].class, int.class));

            getAndAddInt = trustedLookup.bind(theUnsafe, "getAndAddInt", MethodType.methodType(int.class, Object.class, long.class, int.class));
            getAndAddLong = trustedLookup.bind(theUnsafe, "getAndAddLong", MethodType.methodType(long.class, Object.class, long.class, long.class));
            getAndSetInt = trustedLookup.bind(theUnsafe, "getAndSetInt", MethodType.methodType(int.class, Object.class, long.class, int.class));
            getAndSetLong = trustedLookup.bind(theUnsafe, "getAndSetLong", MethodType.methodType(long.class, Object.class, long.class, long.class));
            getAndSetObject = trustedLookup.bind(theUnsafe, "getAndSetObject", MethodType.methodType(Object.class, Object.class, long.class, Object.class));

            loadFence = trustedLookup.bind(theUnsafe, "loadFence", MethodType.methodType(void.class));
            storeFence = trustedLookup.bind(theUnsafe, "storeFence", MethodType.methodType(void.class));
            fullFence = trustedLookup.bind(theUnsafe, "fullFence", MethodType.methodType(void.class));

            invokeCleaner = java9 ? trustedLookup.bind(theUnsafe, "invokeCleaner", MethodType.methodType(void.class, ByteBuffer.class)) : null;

            ARRAY_BOOLEAN_BASE_OFFSET = arrayBaseOffset(boolean[].class);
            ARRAY_BYTE_BASE_OFFSET = arrayBaseOffset(byte[].class);
            ARRAY_SHORT_BASE_OFFSET = arrayBaseOffset(short[].class);
            ARRAY_CHAR_BASE_OFFSET = arrayBaseOffset(char[].class);
            ARRAY_INT_BASE_OFFSET = arrayBaseOffset(int[].class);
            ARRAY_LONG_BASE_OFFSET = arrayBaseOffset(long[].class);
            ARRAY_FLOAT_BASE_OFFSET = arrayBaseOffset(float[].class);
            ARRAY_DOUBLE_BASE_OFFSET = arrayBaseOffset(double[].class);
            ARRAY_OBJECT_BASE_OFFSET = arrayBaseOffset(Object[].class);

            ARRAY_BOOLEAN_INDEX_SCALE = arrayIndexScale(boolean[].class);
            ARRAY_BYTE_INDEX_SCALE = arrayIndexScale(byte[].class);
            ARRAY_SHORT_INDEX_SCALE = arrayIndexScale(short[].class);
            ARRAY_CHAR_INDEX_SCALE = arrayIndexScale(char[].class);
            ARRAY_INT_INDEX_SCALE = arrayIndexScale(int[].class);
            ARRAY_LONG_INDEX_SCALE = arrayIndexScale(long[].class);
            ARRAY_FLOAT_INDEX_SCALE = arrayIndexScale(float[].class);
            ARRAY_DOUBLE_INDEX_SCALE = arrayIndexScale(double[].class);
            ARRAY_OBJECT_INDEX_SCALE = arrayIndexScale(Object[].class);

            ADDRESS_SIZE = addressSize();
        } catch (final Throwable throwable) {
            throw new RuntimeException("Failed to set up Unsafe", throwable);
        }
    }
}
