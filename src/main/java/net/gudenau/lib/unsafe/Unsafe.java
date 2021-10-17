package net.gudenau.lib.unsafe;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.security.ProtectionDomain;
import java.util.logging.Logger;

@SuppressWarnings({"unchecked", "unused", "RedundantSuppression", "ConstantConditions", "SameParameterValue"})
public class Unsafe {
    public static final MethodHandles.Lookup trustedLookup;
    public static final Class<?> SunUnsafe;
    public static final Class<?> Unsafe;
    public static final sun.misc.Unsafe theSunUnsafe;
    public static final Object theUnsafe;

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
    private static final MethodHandle getObjectAddress;
    private static final MethodHandle putAddress;
    private static final MethodHandle putObjectAddress;
    private static final MethodHandle getUncompressedObject;
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
    private static final MethodHandle allocateInstance;
    private static final MethodHandle compareAndSwapReference;
    private static final MethodHandle compareAndSwapInt;
    private static final MethodHandle compareAndSwapLong;
    private static final MethodHandle getReferenceVolatile;
    private static final MethodHandle putReferenceVolatile;
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
    private static final MethodHandle putOrderedReference;
    private static final MethodHandle putOrderedInt;
    private static final MethodHandle putOrderedLong;
    private static final MethodHandle getLoadAverage;
    private static final MethodHandle getAndAddInt;
    private static final MethodHandle getAndAddLong;
    private static final MethodHandle getAndSetInt;
    private static final MethodHandle getAndSetLong;
    private static final MethodHandle getAndSetReference;
    private static final MethodHandle loadFence;
    private static final MethodHandle storeFence;
    private static final MethodHandle fullFence;
    private static final MethodHandle invokeCleaner;

    public static int getInt(Object o, long offset) {
        try {
            return (int) getObjectInt.invokeExact(o, offset);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static void putInt(Object o, long offset, int x) {
        try {
            putObjectInt.invokeExact(o, offset, x);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static <T> T getObject(Object o, long offset) {
        try {
            return (T) getObjectObject.invokeExact(o, offset);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static void putObject(Object o, long offset, Object x) {
        try {
            putObjectObject.invokeExact(o, offset, x);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static boolean getBoolean(Object o, long offset) {
        try {
            return (boolean) getObjectBoolean.invokeExact(o, offset);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static void putBoolean(Object o, long offset, boolean x) {
        try {
            putObjectBoolean.invokeExact(o, offset, x);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static byte getByte(Object o, long offset) {
        try {
            return (byte) getObjectByte.invokeExact(o, offset);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static void putByte(Object o, long offset, byte x) {
        try {
            putObjectByte.invokeExact(o, offset, x);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static short getShort(Object o, long offset) {
        try {
            return (short) getObjectShort.invokeExact(o, offset);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static void putShort(Object o, long offset, short x) {
        try {
            putObjectShort.invokeExact(o, offset, x);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static char getChar(Object o, long offset) {
        try {
            return (char) getObjectChar.invokeExact(o, offset);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static void putChar(Object o, long offset, char x) {
        try {
            putObjectChar.invokeExact(o, offset, x);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static long getLong(Object o, long offset) {
        try {
            return (long) getObjectLong.invokeExact(o, offset);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static void putLong(Object o, long offset, long x) {
        try {
            putObjectLong.invokeExact(o, offset, x);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static float getFloat(Object o, long offset) {
        try {
            return (float) getObjectFloat.invokeExact(o, offset);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static void putFloat(Object o, long offset, float x) {
        try {
            putObjectFloat.invokeExact(o, offset, x);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static double getDouble(Object o, long offset) {
        try {
            return (double) getObjectDouble.invokeExact(o, offset);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static void putDouble(Object o, long offset, double x) {
        try {
            putObjectDouble.invokeExact(o, offset, x);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static byte getByte(long address) {
        try {
            return (byte) getByte.invokeExact(address);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static void putByte(long address, byte x) {
        try {
            putByte.invokeExact(address, x);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static short getShort(long address) {
        try {
            return (short) getShort.invokeExact(address);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static void putShort(long address, short x) {
        try {
            putShort.invokeExact(address, x);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static char getChar(long address) {
        try {
            return (char) getChar.invokeExact(address);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static void putChar(long address, char x) {
        try {
            putChar.invokeExact(address, x);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static int getInt(long address) {
        try {
            return (int) getInt.invokeExact(address);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static void putInt(long address, int x) {
        try {
            putInt.invokeExact(address, x);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static long getLong(long address) {
        try {
            return (long) getLong.invokeExact(address);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static void putLong(long address, long x) {
        try {
            putLong.invokeExact(address, x);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static float getFloat(long address) {
        try {
            return (float) getFloat.invokeExact(address);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static void putFloat(long address, float x) {
        try {
            putFloat.invokeExact(address, x);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static double getDouble(long address) {
        try {
            return (double) getDouble.invokeExact(address);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static void putDouble(long address, double x) {
        try {
            putDouble.invokeExact(address, x);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static long getAddress(long address) {
        try {
            return (long) getAddress.invokeExact(address);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static long getAddress(Object object, long address) {
        try {
            return (long) getAddress.invokeExact(object, address);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static void putAddress(long address, long x) {
        try {
            putAddress.invokeExact(address, x);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static <T> T getUncompressedObject(long address) {
        try {
            return (T) getUncompressedObject.invokeExact(address);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static long allocateMemory(long bytes) {
        try {
            return (long) allocateMemory.invokeExact(bytes);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static long reallocateMemory(long address, long bytes) {
        try {
            return (long) reallocateMemory.invokeExact(address, bytes);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static void setMemory(Object o, long offset, long bytes, byte value) {
        try {
            setObjectMemory.invokeExact(o, offset, bytes, value);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static void setMemory(long address, long bytes, byte value) {
        try {
            setMemory.invokeExact(address, bytes, value);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static void copyMemory(Object srcBase, long srcOffset, Object destBase, long destOffset, long bytes) {
        try {
            copyObjectMemory.invokeExact(srcBase, srcOffset, destBase, destOffset, bytes);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static void copyMemory(long srcAddress, long destAddress, long bytes) {
        try {
            copyMemory.invokeExact(srcAddress, destAddress, bytes);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static void freeMemory(long address) {
        try {
            freeMemory.invokeExact(address);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static long objectFieldOffset(Field field) {
        try {
            return (long) objectFieldOffset.invokeExact(field);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static long staticFieldOffset(Field field) {
        try {
            return (long) staticFieldOffset.invokeExact(field);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static Object staticFieldBase(Field field) {
        try {
            return (Object) staticFieldBase.invokeExact(field);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static boolean shouldBeInitialized(Class<?> klass) {
        try {
            return (boolean) shouldBeInitialized.invokeExact(klass);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static void ensureClassInitialized(Class<?> c) {
        try {
            ensureClassInitialized.invokeExact(c);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static int arrayBaseOffset(Class<?> arrayClass) {
        try {
            return (int) arrayBaseOffset.invokeExact(arrayClass);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static <T> int arrayIndexScale(Class<T> arrayClass) {
        try {
            return (int) arrayIndexScale.invokeExact(arrayClass);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static int addressSize() {
        try {
            return (int) addressSize.invokeExact();
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static int pageSize() {
        try {
            return (int) pageSize.invokeExact();
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static <T> Class<T> defineClass(String name, byte[] bytecode, int offset, int length, ClassLoader classLoader, ProtectionDomain protectionDomain) {
        try {
            return (Class<T>) defineClass.invokeExact(name, bytecode, offset, length, classLoader, protectionDomain);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static <T> T allocateInstance(Class<T> cls) {
        try {
            return (T) allocateInstance.invokeExact(cls);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static RuntimeException throwException(Throwable throwable) {
        return throw0(throwable);
    }

    private static <T extends Throwable> T throw0(Throwable throwable) throws T {
        throw (T) throwable;
    }

    public static boolean compareAndSwapObject(Object o, long offset, Object expected, Object x) {
        try {
            return (boolean) compareAndSwapReference.invokeExact(o, offset, expected, x);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static boolean compareAndSwapInt(Object o, long offset, int expected, int x) {
        try {
            return (boolean) compareAndSwapInt.invokeExact(o, offset, expected, x);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static boolean compareAndSwapLong(Object object, long offset, long expected, long x) {
        try {
            return (boolean) compareAndSwapLong.invokeExact(object, offset, expected, x);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static <T> T getObjectVolatile(Object object, long offset) {
        try {
            return (T) getReferenceVolatile.invokeExact(object, offset);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static void putObjectVolatile(Object o, long offset, Object x) {
        try {
            putReferenceVolatile.invokeExact(o, offset, x);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static int getIntVolatile(Object o, long offset) {
        try {
            return (int) getIntVolatile.invokeExact(o, offset);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static void putIntVolatile(Object o, long offset, int x) {
        try {
            putIntVolatile.invokeExact(o, offset, x);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static boolean getBooleanVolatile(Object o, long offset) {
        try {
            return (boolean) getBooleanVolatile.invokeExact(o, offset);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static void putBooleanVolatile(Object o, long offset, boolean x) {
        try {
            putBooleanVolatile.invokeExact(o, offset, x);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static byte getByteVolatile(Object o, long offset) {
        try {
            return (byte) getByteVolatile.invokeExact(o, offset);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static void putByteVolatile(Object o, long offset, byte x) {
        try {
            putByteVolatile.invokeExact(o, offset, x);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static short getShortVolatile(Object o, long offset) {
        try {
            return (short) getShortVolatile.invokeExact(o, offset);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static void putShortVolatile(Object o, long offset, short x) {
        try {
            putShortVolatile.invokeExact(o, offset, x);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static char getCharVolatile(Object o, long offset) {
        try {
            return (char) getCharVolatile.invokeExact(o, offset);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static void putCharVolatile(Object o, long offset, char x) {
        try {
            putCharVolatile.invokeExact(o, offset, x);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static long getLongVolatile(Object o, long offset) {
        try {
            return (long) getLongVolatile.invokeExact(o, offset);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static void putLongVolatile(Object o, long offset, long x) {
        try {
            putLongVolatile.invokeExact(o, offset, x);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static float getFloatVolatile(Object o, long offset) {
        try {
            return (float) getFloatVolatile.invokeExact(o, offset);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static void putFloatVolatile(Object o, long offset, float x) {
        try {
            putFloatVolatile.invokeExact(o, offset, x);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static double getDoubleVolatile(Object o, long offset) {
        try {
            return (double) getDoubleVolatile.invokeExact(o, offset);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static void putDoubleVolatile(Object o, long offset, double x) {
        try {
            putDoubleVolatile.invokeExact(o, offset, x);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static void putOrderedObject(Object o, long offset, Object x) {
        try {
            putOrderedReference.invokeExact(o, offset, x);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static void putOrderedInt(Object o, long offset, int x) {
        try {
            putOrderedInt.invokeExact(o, offset, x);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static void putOrderedLong(Object o, long offset, long x) {
        try {
            putOrderedLong.invokeExact(o, offset, x);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }
    public static int getLoadAverage(double[] loadavg, int nelems) {
        try {
            return (int) getLoadAverage.invokeExact(loadavg, nelems);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static int getAndAddInt(Object o, long offset, int delta) {
        try {
            return (int) getAndAddInt.invokeExact(o, offset, delta);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static long getAndAddLong(Object o, long offset, long delta) {
        try {
            return (long) getAndAddLong.invokeExact(o, offset, delta);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static int getAndSetInt(Object o, long offset, int newValue) {
        try {
            return (int) getAndSetInt.invokeExact(o, offset, newValue);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static long getAndSetLong(Object o, long offset, long newValue) {
        try {
            return (long) getAndSetLong.invokeExact(o, offset, newValue);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static <T> T getAndSetObject(Object o, long offset, T newValue) {
        try {
            return (T) getAndSetReference.invokeExact(o, offset, (Object) newValue);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static void loadFence() {
        try {
            loadFence.invokeExact();
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static void storeFence() {
        try {
            storeFence.invokeExact();
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static void fullFence() {
        try {
            fullFence.invokeExact();
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    public static void invokeCleaner(ByteBuffer directBuffer) {
        try {
            invokeCleaner.invokeExact(directBuffer);
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }

    private static MethodHandle bind(String method, String alternative, Class<?> returnType, Class<?>... parameterTypes) {
        try {
            try {
                return trustedLookup.bind(theUnsafe, method, MethodType.methodType(returnType, parameterTypes));
            } catch (NoSuchMethodException exception) {
                return trustedLookup.bind(theSunUnsafe, method, MethodType.methodType(returnType, parameterTypes));
            }
        } catch (Throwable throwable) {
            if (alternative == null) {
                Logger.getLogger("Unsafe").warning("Unable to access Unsafe method %s%s.%n".formatted(method, MethodType.methodType(returnType, parameterTypes)));
                throwable.printStackTrace();

                return null;
            }

            return bind(method, null, returnType, parameterTypes);
        }
    }

    private static MethodHandle bind(String method, Class<?> returnType, Class<?>... parameterTypes) {
        return bind(method, null, returnType, parameterTypes);
    }

    static {
        try {
            SunUnsafe = sun.misc.Unsafe.class;
            var field = SunUnsafe.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            theSunUnsafe = (sun.misc.Unsafe) field.get(null);
            trustedLookup = (MethodHandles.Lookup) theSunUnsafe.getObject(MethodHandles.Lookup.class, theSunUnsafe.staticFieldOffset(MethodHandles.Lookup.class.getDeclaredField("IMPL_LOOKUP")));

            Unsafe = Class.forName("jdk.internal.misc.Unsafe");
            theUnsafe = trustedLookup.findStatic(Unsafe, "getUnsafe", MethodType.methodType(Unsafe)).invoke();

            getObjectInt = bind("getInt", int.class, Object.class, long.class);
            getObjectObject = bind("getReference", Object.class, Object.class, long.class);
            getObjectBoolean = bind("getBoolean", boolean.class, Object.class, long.class);
            getObjectByte = bind("getByte", byte.class, Object.class, long.class);
            getObjectShort = bind("getShort", short.class, Object.class, long.class);
            getObjectChar = bind("getChar", char.class, Object.class, long.class);
            getObjectLong = bind("getLong", long.class, Object.class, long.class);
            getObjectFloat = bind("getFloat", float.class, Object.class, long.class);
            getObjectDouble = bind("getDouble", double.class, Object.class, long.class);

            putObjectInt = bind("putInt", void.class, Object.class, long.class, int.class);
            putObjectObject = bind("putReference", void.class, Object.class, long.class, Object.class);
            putObjectBoolean = bind("putBoolean", void.class, Object.class, long.class, boolean.class);
            putObjectByte = bind("putByte", void.class, Object.class, long.class, byte.class);
            putObjectShort = bind("putShort", void.class, Object.class, long.class, short.class);
            putObjectChar = bind("putChar", void.class, Object.class, long.class, char.class);
            putObjectLong = bind("putLong", void.class, Object.class, long.class, long.class);
            putObjectFloat = bind("putFloat", void.class, Object.class, long.class, float.class);
            putObjectDouble = bind("putDouble", void.class, Object.class, long.class, double.class);

            getByte = bind("getByte", byte.class, long.class);
            getShort = bind("getShort", short.class, long.class);
            getChar = bind("getChar", char.class, long.class);
            getInt = bind("getInt", int.class, long.class);
            getLong = bind("getLong", long.class, long.class);
            getFloat = bind("getFloat", float.class, long.class);
            getDouble = bind("getDouble", double.class, long.class);
            getAddress = bind("getAddress", long.class, long.class);
            getObjectAddress = bind("getAddress", long.class, Object.class, long.class);

            putByte = bind("putByte", void.class, long.class, byte.class);
            putShort = bind("putShort", void.class, long.class, short.class);
            putChar = bind("putChar", void.class, long.class, char.class);
            putInt = bind("putInt", void.class, long.class, int.class);
            putLong = bind("putLong", void.class, long.class, long.class);
            putFloat = bind("putFloat", void.class, long.class, float.class);
            putDouble = bind("putDouble", void.class, long.class, double.class);
            putAddress = bind("putAddress", void.class, long.class, long.class);
            putObjectAddress = bind("putAddress", void.class, Object.class, long.class, long.class);

            getUncompressedObject = bind("getUncompressedObject", Object.class, long.class);
            allocateMemory = bind("allocateMemory", long.class, long.class);
            reallocateMemory = bind("reallocateMemory", long.class, long.class, long.class);
            setObjectMemory = bind("setMemory", void.class, Object.class, long.class, long.class, byte.class);
            setMemory = bind("setMemory", void.class, long.class, long.class, byte.class);
            copyObjectMemory = bind("copyMemory", void.class, Object.class, long.class, Object.class, long.class, long.class);
            copyMemory = bind("copyMemory", void.class, long.class, long.class, long.class);
            freeMemory = bind("freeMemory", void.class, long.class);
            objectFieldOffset = bind("objectFieldOffset", long.class, Field.class);
            staticFieldOffset = bind("staticFieldOffset", long.class, Field.class);
            staticFieldBase = bind("staticFieldBase", Object.class, Field.class);
            shouldBeInitialized = bind("shouldBeInitialized", boolean.class, Class.class);
            ensureClassInitialized = bind("ensureClassInitialized", void.class, Class.class);
            arrayBaseOffset = bind("arrayBaseOffset", int.class, Class.class);
            arrayIndexScale = bind("arrayIndexScale", int.class, Class.class);
            addressSize = bind("addressSize", int.class);
            pageSize = bind("pageSize", int.class);
            defineClass = bind("defineClass", Class.class, String.class, byte[].class, int.class, int.class, ClassLoader.class, ProtectionDomain.class);
            allocateInstance = bind("allocateInstance", Object.class, Class.class);

            getReferenceVolatile = bind("getReferenceVolatile", Object.class, Object.class, long.class);
            getIntVolatile = bind("getIntVolatile", int.class, Object.class, long.class);
            getBooleanVolatile = bind("getBooleanVolatile", boolean.class, Object.class, long.class);
            getByteVolatile = bind("getByteVolatile", byte.class, Object.class, long.class);
            getShortVolatile = bind("getShortVolatile", short.class, Object.class, long.class);
            getCharVolatile = bind("getCharVolatile", char.class, Object.class, long.class);
            getLongVolatile = bind("getLongVolatile", long.class, Object.class, long.class);
            getFloatVolatile = bind("getFloatVolatile", float.class, Object.class, long.class);
            getDoubleVolatile = bind("getDoubleVolatile", double.class, Object.class, long.class);

            putReferenceVolatile = bind("putReferenceVolatile", void.class, Object.class, long.class, Object.class);
            putIntVolatile = bind("putIntVolatile", void.class, Object.class, long.class, int.class);
            putBooleanVolatile = bind("putBooleanVolatile", void.class, Object.class, long.class, boolean.class);
            putByteVolatile = bind("putByteVolatile", void.class, Object.class, long.class, byte.class);
            putShortVolatile = bind("putShortVolatile", void.class, Object.class, long.class, short.class);
            putCharVolatile = bind("putCharVolatile", void.class, Object.class, long.class, char.class);
            putLongVolatile = bind("putLongVolatile", void.class, Object.class, long.class, long.class);
            putFloatVolatile = bind("putFloatVolatile", void.class, Object.class, long.class, float.class);
            putDoubleVolatile = bind("putDoubleVolatile", void.class, Object.class, long.class, double.class);

            compareAndSwapReference = bind("compareAndSetReference", boolean.class, Object.class, long.class, Object.class, Object.class);
            compareAndSwapInt = bind("compareAndSetInt", boolean.class, Object.class, long.class, int.class, int.class);
            compareAndSwapLong = bind("compareAndSetLong", boolean.class, Object.class, long.class, long.class, long.class);

            putOrderedReference = bind("putReferenceRelease", void.class, Object.class, long.class, Object.class);
            putOrderedInt = bind("putIntRelease", void.class, Object.class, long.class, int.class);
            putOrderedLong = bind("putLongRelease", void.class, Object.class, long.class, long.class);

            getLoadAverage = bind("getLoadAverage", int.class, double[].class, int.class);
            getAndAddInt = bind("getAndAddInt", int.class, Object.class, long.class, int.class);
            getAndAddLong = bind("getAndAddLong", long.class, Object.class, long.class, long.class);
            getAndSetInt = bind("getAndSetInt", int.class, Object.class, long.class, int.class);
            getAndSetLong = bind("getAndSetLong", long.class, Object.class, long.class, long.class);
            getAndSetReference = bind("getAndSetReference", Object.class, Object.class, long.class, Object.class);

            loadFence = bind("loadFence", void.class);
            storeFence = bind("storeFence", void.class);
            fullFence = bind("fullFence", void.class);

            invokeCleaner = bind("invokeCleaner", void.class, ByteBuffer.class);

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
        } catch (Throwable throwable) {
            throw throwException(throwable);
        }
    }
}
