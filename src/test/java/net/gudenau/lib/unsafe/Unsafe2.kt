@file:Suppress("UNCHECKED_CAST", "unused")

package net.gudenau.lib.unsafe

import java.lang.invoke.MethodHandle
import java.lang.invoke.MethodHandles
import java.lang.invoke.MethodType
import java.lang.reflect.Field
import java.lang.reflect.Modifier
import java.nio.ByteBuffer
import java.security.ProtectionDomain
import java.util.logging.Logger

object Unsafe2 {
    val trustedLookup: MethodHandles.Lookup
    val SunUnsafe: Class<*> = Class.forName("sun.misc.Unsafe")
    val Unsafe: Class<*>
    val theSunUnsafe: Any
    val theUnsafe: Any

    const val INVALID_FIELD_OFFSET: Int = -1

    val ARRAY_BOOLEAN_BASE_OFFSET: Int
    val ARRAY_BYTE_BASE_OFFSET: Int
    val ARRAY_SHORT_BASE_OFFSET: Int
    val ARRAY_CHAR_BASE_OFFSET: Int
    val ARRAY_INT_BASE_OFFSET: Int
    val ARRAY_LONG_BASE_OFFSET: Int
    val ARRAY_FLOAT_BASE_OFFSET: Int
    val ARRAY_DOUBLE_BASE_OFFSET: Int
    val ARRAY_OBJECT_BASE_OFFSET: Int
    val ARRAY_BOOLEAN_INDEX_SCALE: Int
    val ARRAY_BYTE_INDEX_SCALE: Int
    val ARRAY_SHORT_INDEX_SCALE: Int
    val ARRAY_CHAR_INDEX_SCALE: Int
    val ARRAY_INT_INDEX_SCALE: Int
    val ARRAY_LONG_INDEX_SCALE: Int
    val ARRAY_FLOAT_INDEX_SCALE: Int
    val ARRAY_DOUBLE_INDEX_SCALE: Int
    val ARRAY_OBJECT_INDEX_SCALE: Int
    val ADDRESS_SIZE: Int

    private val getObjectInt: MethodHandle?
    private val putObjectInt: MethodHandle?
    private val getObjectObject: MethodHandle?
    private val putObjectObject: MethodHandle?
    private val getObjectBoolean: MethodHandle?
    private val putObjectBoolean: MethodHandle?
    private val getObjectByte: MethodHandle?
    private val putObjectByte: MethodHandle?
    private val getObjectShort: MethodHandle?
    private val putObjectShort: MethodHandle?
    private val getObjectChar: MethodHandle?
    private val putObjectChar: MethodHandle?
    private val getObjectLong: MethodHandle?
    private val putObjectLong: MethodHandle?
    private val getObjectFloat: MethodHandle?
    private val putObjectFloat: MethodHandle?
    private val getObjectDouble: MethodHandle?
    private val putObjectDouble: MethodHandle?
    private val getByte: MethodHandle?
    private val putByte: MethodHandle?
    private val getShort: MethodHandle?
    private val putShort: MethodHandle?
    private val getChar: MethodHandle?
    private val putChar: MethodHandle?
    private val getInt: MethodHandle?
    private val putInt: MethodHandle?
    private val getLong: MethodHandle?
    private val putLong: MethodHandle?
    private val getFloat: MethodHandle?
    private val putFloat: MethodHandle?
    private val getDouble: MethodHandle?
    private val putDouble: MethodHandle?
    private val getAddress: MethodHandle?
    private val putAddress: MethodHandle?
    private val allocateMemory: MethodHandle?
    private val reallocateMemory: MethodHandle?
    private val setObjectMemory: MethodHandle?
    private val setMemory: MethodHandle?
    private val copyObjectMemory: MethodHandle?
    private val copyMemory: MethodHandle?
    private val freeMemory: MethodHandle?
    private val objectFieldOffset: MethodHandle?
    private val staticFieldOffset: MethodHandle?
    private val staticFieldBase: MethodHandle?
    private val shouldBeInitialized: MethodHandle?
    private val ensureClassInitialized: MethodHandle?
    private val arrayBaseOffset: MethodHandle?
    private val arrayIndexScale: MethodHandle?
    private val addressSize: MethodHandle?
    private val pageSize: MethodHandle?
    private val defineClass: MethodHandle?
    private val defineAnonymousClass: MethodHandle?
    private val allocateInstance: MethodHandle?
    private val compareAndSwapObject: MethodHandle?
    private val compareAndSwapInt: MethodHandle?
    private val compareAndSwapLong: MethodHandle?
    private val getObjectVolatile: MethodHandle?
    private val putObjectVolatile: MethodHandle?
    private val getIntVolatile: MethodHandle?
    private val putIntVolatile: MethodHandle?
    private val getBooleanVolatile: MethodHandle?
    private val putBooleanVolatile: MethodHandle?
    private val getByteVolatile: MethodHandle?
    private val putByteVolatile: MethodHandle?
    private val getShortVolatile: MethodHandle?
    private val putShortVolatile: MethodHandle?
    private val getCharVolatile: MethodHandle?
    private val putCharVolatile: MethodHandle?
    private val getLongVolatile: MethodHandle?
    private val putLongVolatile: MethodHandle?
    private val getFloatVolatile: MethodHandle?
    private val putFloatVolatile: MethodHandle?
    private val getDoubleVolatile: MethodHandle?
    private val putDoubleVolatile: MethodHandle?
    private val putOrderedObject: MethodHandle?
    private val putOrderedInt: MethodHandle?
    private val putOrderedLong: MethodHandle?
    private val unpark: MethodHandle?
    private val park: MethodHandle?
    private val getLoadAverage: MethodHandle?
    private val getAndAddInt: MethodHandle?
    private val getAndAddLong: MethodHandle?
    private val getAndSetInt: MethodHandle?
    private val getAndSetLong: MethodHandle?
    private val getAndSetObject: MethodHandle?
    private val loadFence: MethodHandle?
    private val storeFence: MethodHandle?
    private val fullFence: MethodHandle?
    private val invokeCleaner: MethodHandle?

    fun getInt(o: Any?, offset: Long): Int {
        return getObjectInt!!.invokeExact(o, offset) as Int
    }

    fun putInt(o: Any?, offset: Long, x: Int) {
        putObjectInt!!.invokeExact(o, offset, x)
    }

    fun getObject(o: Any?, offset: Long): Any {
        return getObjectObject!!.invokeExact(o, offset)
    }

    fun putObject(o: Any?, offset: Long, x: Any?) {
        putObjectObject!!.invokeExact(o, offset, x)
    }

    fun getBoolean(o: Any?, offset: Long): Boolean {
        return getObjectBoolean!!.invokeExact(o, offset) as Boolean
    }

    fun putBoolean(o: Any?, offset: Long, x: Boolean) {
        putObjectBoolean!!.invokeExact(o, offset, x)
    }

    fun getByte(o: Any?, offset: Long): Byte {
        return getObjectByte!!.invokeExact(o, offset) as Byte
    }

    fun putByte(o: Any?, offset: Long, x: Byte) {
        putObjectByte!!.invokeExact(o, offset, x)
    }

    fun getShort(o: Any?, offset: Long): Short {
        return getObjectShort!!.invokeExact(o, offset) as Short
    }

    fun putShort(o: Any?, offset: Long, x: Short) {
        putObjectShort!!.invokeExact(o, offset, x)
    }

    fun getChar(o: Any?, offset: Long): Char {
        return getObjectChar!!.invokeExact(o, offset) as Char
    }

    fun putChar(o: Any?, offset: Long, x: Char) {
        putObjectChar!!.invokeExact(o, offset, x)
    }

    fun getLong(o: Any?, offset: Long): Long {
        return getObjectLong!!.invokeExact(o, offset) as Long
    }

    fun putLong(o: Any?, offset: Long, x: Long) {
        putObjectLong!!.invokeExact(o, offset, x)
    }

    fun getFloat(o: Any?, offset: Long): Float {
        return getObjectFloat!!.invokeExact(o, offset) as Float
    }

    fun putFloat(o: Any?, offset: Long, x: Float) {
        putObjectFloat!!.invokeExact(o, offset, x)
    }

    fun getDouble(o: Any?, offset: Long): Double {
        return getObjectDouble!!.invokeExact(o, offset) as Double
    }

    fun putDouble(o: Any?, offset: Long, x: Double) {
        putObjectDouble!!.invokeExact(o, offset, x)
    }

    fun getByte(address: Long): Byte {
        return getByte!!.invokeExact(address) as Byte
    }

    fun putByte(address: Long, x: Byte) {
        putByte!!.invokeExact(address, x)
    }

    fun getShort(address: Long): Short {
        return getShort!!.invokeExact(address) as Short
    }

    fun putShort(address: Long, x: Short) {
        putShort!!.invokeExact(address, x)
    }

    fun getChar(address: Long): Char {
        return getChar!!.invokeExact(address) as Char
    }

    fun putChar(address: Long, x: Char) {
        putChar!!.invokeExact(address, x)
    }

    fun getInt(address: Long): Int {
        return getInt!!.invokeExact(address) as Int
    }

    fun putInt(address: Long, x: Int) {
        putInt!!.invokeExact(address, x)
    }

    fun getLong(address: Long): Long {
        return getLong!!.invokeExact(address) as Long
    }

    fun putLong(address: Long, x: Long) {
        putLong!!.invokeExact(address, x)
    }

    fun getFloat(address: Long): Float {
        return getFloat!!.invokeExact(address) as Float
    }

    fun putFloat(address: Long, x: Float) {
        putFloat!!.invokeExact(address, x)
    }

    fun getDouble(address: Long): Double {
        return getDouble!!.invokeExact(address) as Double
    }

    fun putDouble(address: Long, x: Double) {
        putDouble!!.invokeExact(address, x)
    }

    fun getAddress(address: Long): Long {
        return getAddress!!.invokeExact(address) as Long
    }

    fun putAddress(address: Long, x: Long) {
        putAddress!!.invokeExact(address, x)
    }

    fun allocateMemory(bytes: Long): Long {
        return allocateMemory!!.invokeExact(bytes) as Long
    }

    fun reallocateMemory(address: Long, bytes: Long): Long {
        return reallocateMemory!!.invokeExact(address, bytes) as Long
    }

    fun setMemory(o: Any?, offset: Long, bytes: Long, value: Byte) {
        setObjectMemory!!.invokeExact(o, offset, bytes, value)
    }

    fun setMemory(address: Long, bytes: Long, value: Byte) {
        setMemory!!.invokeExact(address, bytes, value)
    }

    fun copyMemory(srcBase: Any?, srcOffset: Long, destBase: Any?, destOffset: Long, bytes: Long) {
        copyObjectMemory!!.invokeExact(srcBase, srcOffset, destBase, destOffset, bytes)
    }

    fun copyMemory(srcAddress: Long, destAddress: Long, bytes: Long) {
        copyMemory!!.invokeExact(srcAddress, destAddress, bytes)
    }

    fun freeMemory(address: Long) {
        freeMemory!!.invokeExact(address)
    }

    fun objectFieldOffset(f: Field?): Long {
        return objectFieldOffset!!.invokeExact(f) as Long
    }

    fun staticFieldOffset(f: Field?): Long {
        return staticFieldOffset!!.invokeExact(f) as Long
    }

    fun staticFieldBase(f: Field?): Any {
        return staticFieldBase!!.invokeExact(f) as Any
    }

    fun shouldBeInitialized(klass: Class<*>?): Boolean {
        return shouldBeInitialized!!.invokeExact(klass) as Boolean
    }

    fun ensureClassInitialized(klass: Class<*>?) {
        ensureClassInitialized!!.invokeExact(klass)
    }

    fun arrayBaseOffset(arrayClass: Class<*>?): Int {
        return arrayBaseOffset!!.invokeExact(arrayClass) as Int
    }

    fun <T> arrayIndexScale(arrayClass: Class<T>?): Int {
        return arrayIndexScale!!.invokeExact(arrayClass) as Int
    }

    fun addressSize(): Int {
        return addressSize!!.invokeExact() as Int
    }

    fun pageSize(): Int {
        return pageSize!!.invokeExact() as Int
    }

    fun <A> defineAnonymousClass(hostClass: Class<*>?, data: ByteArray?, cpPatches: Array<Any?>?): Class<A> {
        return defineAnonymousClass!!.invokeExact(hostClass, data, cpPatches) as Class<A>
    }

    fun <T> defineClass(name: String?, bytecode: ByteArray?, offset: Int, length: Int, classLoader: ClassLoader?, protectionDomain: ProtectionDomain?): Class<T> {
        return defineClass!!.invokeExact(name, bytecode, offset, length, classLoader, protectionDomain) as Class<T>
    }

    fun <T> allocateInstance(klass: Class<T>?): T {
        return allocateInstance!!.invokeExact(klass) as T
    }

    fun throwException(throwable: Throwable?): RuntimeException {
        throw throwable!!
    }

    fun compareAndSwapObject(o: Any?, offset: Long, expected: Any?, x: Any?): Boolean {
        return compareAndSwapObject!!.invokeExact(o, offset, expected, x) as Boolean
    }

    fun compareAndSwapInt(o: Any?, offset: Long, expected: Int, x: Int): Boolean {
        return compareAndSwapInt!!.invokeExact(o, offset, expected, x) as Boolean
    }

    fun compareAndSwapLong(o: Any?, offset: Long, expected: Long, x: Long): Boolean {
        return compareAndSwapLong!!.invokeExact(o, offset, expected, x) as Boolean
    }

    fun getObjectVolatile(o: Any?, offset: Long): Any {
        return getObjectVolatile!!.invokeExact(o, offset) as Any
    }

    fun putObjectVolatile(o: Any?, offset: Long, x: Any?) {
        putObjectVolatile!!.invokeExact(o, offset, x)
    }

    fun getIntVolatile(o: Any?, offset: Long): Int {
        return getIntVolatile!!.invokeExact(o, offset) as Int
    }

    fun putIntVolatile(o: Any?, offset: Long, x: Int) {
        putIntVolatile!!.invokeExact(o, offset, x)
    }

    fun getBooleanVolatile(o: Any?, offset: Long): Boolean {
        return getBooleanVolatile!!.invokeExact(o, offset) as Boolean
    }

    fun putBooleanVolatile(o: Any?, offset: Long, x: Boolean) {
        putBooleanVolatile!!.invokeExact(o, offset, x)
    }

    fun getByteVolatile(o: Any?, offset: Long): Byte {
        return getByteVolatile!!.invokeExact(o, offset) as Byte
    }

    fun putByteVolatile(o: Any?, offset: Long, x: Byte) {
        putByteVolatile!!.invokeExact(o, offset, x)
    }

    fun getShortVolatile(o: Any?, offset: Long): Short {
        return getShortVolatile!!.invokeExact(o, offset) as Short
    }

    fun putShortVolatile(o: Any?, offset: Long, x: Short) {
        putShortVolatile!!.invokeExact(o, offset, x)
    }

    fun getCharVolatile(o: Any?, offset: Long): Char {
        return getCharVolatile!!.invokeExact(o, offset) as Char
    }

    fun putCharVolatile(o: Any?, offset: Long, x: Char) {
        putCharVolatile!!.invokeExact(o, offset, x)
    }

    fun getLongVolatile(o: Any?, offset: Long): Long {
        return getLongVolatile!!.invokeExact(o, offset) as Long
    }

    fun putLongVolatile(o: Any?, offset: Long, x: Long) {
        putLongVolatile!!.invokeExact(o, offset, x)
    }

    fun getFloatVolatile(o: Any?, offset: Long): Float {
        return getFloatVolatile!!.invokeExact(o, offset) as Float
    }

    fun putFloatVolatile(o: Any?, offset: Long, x: Float) {
        putFloatVolatile!!.invokeExact(o, offset, x)
    }

    fun getDoubleVolatile(o: Any?, offset: Long): Double {
        return getDoubleVolatile!!.invokeExact(o, offset) as Double
    }

    fun putDoubleVolatile(o: Any?, offset: Long, x: Double) {
        putDoubleVolatile!!.invokeExact(o, offset, x)
    }

    fun putOrderedObject(o: Any?, offset: Long, x: Any?) {
        putOrderedObject!!.invokeExact(o, offset, x)
    }

    fun putOrderedInt(o: Any?, offset: Long, x: Int) {
        putOrderedInt!!.invokeExact(o, offset, x)
    }

    fun putOrderedLong(o: Any?, offset: Long, x: Long) {
        putOrderedLong!!.invokeExact(o, offset, x)
    }

    fun unpark(thread: Any?) {
        unpark!!.invokeExact(thread)
    }

    fun park(isAbsolute: Boolean, time: Long) {
        park!!.invokeExact(isAbsolute, time)
    }

    fun getLoadAverage(loadavg: DoubleArray?, nelems: Int): Int {
        return getLoadAverage!!.invokeExact(loadavg, nelems) as Int
    }

    fun getAndAddInt(o: Any?, offset: Long, delta: Int): Int {
        return getAndAddInt!!.invokeExact(o, offset, delta) as Int
    }

    fun getAndAddLong(o: Any?, offset: Long, delta: Long): Long {
        return getAndAddLong!!.invokeExact(o, offset, delta) as Long
    }

    fun getAndSetInt(o: Any?, offset: Long, newValue: Int): Int {
        return getAndSetInt!!.invokeExact(o, offset, newValue) as Int
    }

    fun getAndSetLong(o: Any?, offset: Long, newValue: Long): Long {
        return getAndSetLong!!.invokeExact(o, offset, newValue) as Long
    }

    fun <T> getAndSetObject(o: Any?, offset: Long, newValue: T): T {
        return getAndSetObject!!.invokeExact(o, offset, newValue as Any) as Any as T
    }

    fun loadFence() {
        loadFence!!.invokeExact()
    }

    fun storeFence() {
        storeFence!!.invokeExact()
    }

    fun fullFence() {
        fullFence!!.invokeExact()
    }

    fun invokeCleaner(directBuffer: ByteBuffer?) {
        invokeCleaner!!.invokeExact(directBuffer)
    }

    private fun bindSilent(method: String, returnType: Class<*>, vararg parameterTypes: Class<*>): MethodHandle? {
        return try {
            trustedLookup.bind(theUnsafe, method, MethodType.methodType(returnType, parameterTypes))
        } catch (exception: NoSuchMethodException) {
            try {
                trustedLookup.bind(theUnsafe, method, MethodType.methodType(returnType, parameterTypes))
            } catch (failed: NoSuchMethodException) {
                null
            }
        }
    }

    private fun bind(method: String, returnType: Class<*>?, vararg parameterTypes: Class<*>): MethodHandle? {
        val feedback: Throwable = try {
            return try {
                trustedLookup.bind(theUnsafe, method, MethodType.methodType(returnType, parameterTypes))
            } catch (exception: NoSuchMethodException) {
                trustedLookup.bind(theSunUnsafe, method, MethodType.methodType(returnType, parameterTypes))
            }
        } catch (failed: Throwable) {
            failed
        }

        val logger = Logger.getLogger("Unsafe")
        val parameterString = parameterTypes.contentToString()
        logger.warning(String.format("Unable to access Unsafe method %s%s\n%s.", method, '('.toString() + parameterString.substring(1, parameterString.length - 1) + ')', feedback))

        return null
    }

    init {
        var temporaryUnsafe: Any? = null

        for (field in SunUnsafe.declaredFields) {
            if (field.modifiers == Modifier.PRIVATE or Modifier.STATIC or Modifier.FINAL && field.type == SunUnsafe) {
                field.isAccessible = true
                temporaryUnsafe = field[null]

                if (temporaryUnsafe != null) {
                    break
                }
            }
        }

        val char = Char::class.javaPrimitiveType!!
        val int = Int::class.javaPrimitiveType!!
        val long = Long::class.javaPrimitiveType!!
        val float = Float::class.javaPrimitiveType!!
        val double = Double::class.javaPrimitiveType!!
        val Object = Any::class.java
        val byteArray = ByteArray::class.java
        val objectArray = Array::class.java
        val ClassClass = Class::class.java
        val Field = Field::class.java
        val Lookup = MethodHandles.Lookup::class.java

        theSunUnsafe = temporaryUnsafe!!
        val lookup = MethodHandles.lookup()
        trustedLookup = lookup
                .bind(temporaryUnsafe, "getObject", MethodType.methodType(Object, Object, long))
                .invokeExact(Lookup, lookup.bind(temporaryUnsafe, "staticFieldOffset", MethodType.methodType(long, Field))
                        .invokeExact(Lookup.getDeclaredField("IMPL_LOOKUP")) as Long) as MethodHandles.Lookup
        val version = System.getProperty("java.version")
        val java9 = version.indexOf('.') != 1 || version[2] == '9'

        if (java9) {
            Unsafe = Class.forName("jdk.internal.misc.Unsafe")
            temporaryUnsafe = trustedLookup.findStatic(Unsafe, "getUnsafe", MethodType.methodType(Unsafe)).invoke()
        } else {
            Unsafe = SunUnsafe
        }

        theUnsafe = temporaryUnsafe ?: theSunUnsafe
        getObjectInt = bind("getInt", int, Object, long)
        getObjectObject = bind("getObject", Object, Object, long)
        getObjectBoolean = bind("getBoolean", Boolean::class.javaPrimitiveType, Object, long)
        getObjectByte = bind("getByte", Byte::class.javaPrimitiveType, Object, long)
        getObjectShort = bind("getShort", Short::class.javaPrimitiveType!!, Object, long)
        getObjectChar = bind("getChar", char, Object, long)
        getObjectLong = bind("getLong", long, Object, long)
        getObjectFloat = bind("getFloat", float, Object, long)
        getObjectDouble = bind("getDouble", double, Object, long)
        putObjectInt = bind("putInt", Void::class.javaPrimitiveType, Object, long, int)
        putObjectObject = bind("putObject", Void::class.javaPrimitiveType, Object, long, Object)
        putObjectBoolean = bind("putBoolean", Void::class.javaPrimitiveType, Object, long, Boolean::class.javaPrimitiveType!!)
        putObjectByte = bind("putByte", Void::class.javaPrimitiveType, Object, long, Byte::class.javaPrimitiveType!!)
        putObjectShort = bind("putShort", Void::class.javaPrimitiveType, Object, long, Short::class.javaPrimitiveType!!)
        putObjectChar = bind("putChar", Void::class.javaPrimitiveType, Object, long, char)
        putObjectLong = bind("putLong", Void::class.javaPrimitiveType, Object, long, long)
        putObjectFloat = bind("putFloat", Void::class.javaPrimitiveType, Object, long, float)
        putObjectDouble = bind("putDouble", Void::class.javaPrimitiveType, Object, long, double)
        getByte = bind("getByte", Byte::class.javaPrimitiveType, long)
        getShort = bind("getShort", Short::class.javaPrimitiveType!!, long)
        getChar = bind("getChar", char, long)
        getInt = bind("getInt", int, long)
        getLong = bind("getLong", long, long)
        getFloat = bind("getFloat", float, long)
        getDouble = bind("getDouble", double, long)
        getAddress = bind("getAddress", long, long)
        putByte = bind("putByte", Void::class.javaPrimitiveType, long, Byte::class.javaPrimitiveType!!)
        putShort = bind("putShort", Void::class.javaPrimitiveType, long, Short::class.javaPrimitiveType!!)
        putChar = bind("putChar", Void::class.javaPrimitiveType, long, char)
        putInt = bind("putInt", Void::class.javaPrimitiveType, long, int)
        putLong = bind("putLong", Void::class.javaPrimitiveType, long, long)
        putFloat = bind("putFloat", Void::class.javaPrimitiveType, long, float)
        putDouble = bind("putDouble", Void::class.javaPrimitiveType, long, double)
        putAddress = bind("putAddress", Void::class.javaPrimitiveType, long, long)
        allocateMemory = bind("allocateMemory", long, long)
        reallocateMemory = bind("reallocateMemory", long, long, long)
        setObjectMemory = bind("setMemory", Void::class.javaPrimitiveType, Object, long, long, Byte::class.javaPrimitiveType!!)
        setMemory = bind("setMemory", Void::class.javaPrimitiveType, long, long, Byte::class.javaPrimitiveType!!)
        copyObjectMemory = bind("copyMemory", Void::class.javaPrimitiveType, Object, long, Object, long, long)
        copyMemory = bind("copyMemory", Void::class.javaPrimitiveType, long, long, long)
        freeMemory = bind("freeMemory", Void::class.javaPrimitiveType, long)
        objectFieldOffset = bind("objectFieldOffset", long, Field)
        staticFieldOffset = bind("staticFieldOffset", long, Field)
        staticFieldBase = bind("staticFieldBase", Object, Field)
        shouldBeInitialized = bind("shouldBeInitialized", Boolean::class.javaPrimitiveType, ClassClass)
        ensureClassInitialized = bind("ensureClassInitialized", Void::class.javaPrimitiveType, ClassClass)
        arrayBaseOffset = bind("arrayBaseOffset", int, ClassClass)
        arrayIndexScale = bind("arrayIndexScale", int, ClassClass)
        addressSize = bind("addressSize", int)
        pageSize = bind("pageSize", int)
        defineClass = bind("defineClass", ClassClass, String::class.java, byteArray, int, int, ClassLoader::class.java, ProtectionDomain::class.java)
        defineAnonymousClass = bind("defineAnonymousClass", ClassClass, ClassClass, byteArray, objectArray)
        allocateInstance = bind("allocateInstance", Object, ClassClass)
        getObjectVolatile = bind("getObjectVolatile", Object, Object, long)
        getIntVolatile = bind("getIntVolatile", int, Object, long)
        getBooleanVolatile = bind("getBooleanVolatile", Boolean::class.javaPrimitiveType, Object, long)
        getByteVolatile = bind("getByteVolatile", Byte::class.javaPrimitiveType, Object, long)
        getShortVolatile = bind("getShortVolatile", Short::class.javaPrimitiveType!!, Object, long)
        getCharVolatile = bind("getCharVolatile", char, Object, long)
        getLongVolatile = bind("getLongVolatile", long, Object, long)
        getFloatVolatile = bind("getFloatVolatile", float, Object, long)
        getDoubleVolatile = bind("getDoubleVolatile", double, Object, long)
        putObjectVolatile = bind("putObjectVolatile", Void::class.javaPrimitiveType, Object, long, Object)
        putIntVolatile = bind("putIntVolatile", Void::class.javaPrimitiveType, Object, long, int)
        putBooleanVolatile = bind("putBooleanVolatile", Void::class.javaPrimitiveType, Object, long, Boolean::class.javaPrimitiveType!!)
        putByteVolatile = bind("putByteVolatile", Void::class.javaPrimitiveType, Object, long, Byte::class.javaPrimitiveType!!)
        putShortVolatile = bind("putShortVolatile", Void::class.javaPrimitiveType, Object, long, Short::class.javaPrimitiveType!!)
        putCharVolatile = bind("putCharVolatile", Void::class.javaPrimitiveType, Object, long, char)
        putLongVolatile = bind("putLongVolatile", Void::class.javaPrimitiveType, Object, long, long)
        putFloatVolatile = bind("putFloatVolatile", Void::class.javaPrimitiveType, Object, long, float)
        putDoubleVolatile = bind("putDoubleVolatile", Void::class.javaPrimitiveType, Object, long, double)
        unpark = bind("unpark", Void::class.javaPrimitiveType, Object)
        park = bind("park", Void::class.javaPrimitiveType, Boolean::class.javaPrimitiveType!!, long)
        getLoadAverage = bind("getLoadAverage", int, DoubleArray::class.java, int)
        getAndAddInt = bind("getAndAddInt", int, Object, long, int)
        getAndAddLong = bind("getAndAddLong", long, Object, long, long)
        getAndSetInt = bind("getAndSetInt", int, Object, long, int)
        getAndSetLong = bind("getAndSetLong", long, Object, long, long)
        getAndSetObject = bind("getAndSetObject", Object, Object, long, Object)
        loadFence = bind("loadFence", Void::class.javaPrimitiveType)
        storeFence = bind("storeFence", Void::class.javaPrimitiveType)
        fullFence = bind("fullFence", Void::class.javaPrimitiveType)
        invokeCleaner = bindSilent("invokeCleaner", Void::class.javaPrimitiveType!!, ByteBuffer::class.java)

        if (java9) {
            compareAndSwapObject = bind("compareAndSetObject", Boolean::class.javaPrimitiveType, Object, long, Object, Object)
            compareAndSwapInt = bind("compareAndSetInt", Boolean::class.javaPrimitiveType, Object, long, int, int)
            compareAndSwapLong = bind("compareAndSetLong", Boolean::class.javaPrimitiveType, Object, long, long, long)
            putOrderedObject = bindSilent("putReferenceRelease", Void::class.javaPrimitiveType!!, Object, long, Object)
                    ?: bind("putObjectRelease", Void::class.javaPrimitiveType, Object, long, Object)
            putOrderedInt = bind("putIntRelease", Void::class.javaPrimitiveType, Object, long, int)
            putOrderedLong = bind("putLongRelease", Void::class.javaPrimitiveType, Object, long, long)
        } else {
            compareAndSwapObject = bind("compareAndSwapObject", Boolean::class.javaPrimitiveType, Object, long, Object, Object)
            compareAndSwapInt = bind("compareAndSwapInt", Boolean::class.javaPrimitiveType, Object, long, int, int)
            compareAndSwapLong = bind("compareAndSwapLong", Boolean::class.javaPrimitiveType, Object, long, long, long)
            putOrderedObject = trustedLookup.bind(theUnsafe, "putOrderedObject", MethodType.methodType(Void::class.javaPrimitiveType, Object, long, Object))
            putOrderedInt = trustedLookup.bind(theUnsafe, "putOrderedInt", MethodType.methodType(Void::class.javaPrimitiveType, Object, long, int))
            putOrderedLong = trustedLookup.bind(theUnsafe, "putOrderedLong", MethodType.methodType(Void::class.javaPrimitiveType, Object, long, long))
        }

        ARRAY_BOOLEAN_BASE_OFFSET = arrayBaseOffset(BooleanArray::class.java)
        ARRAY_BYTE_BASE_OFFSET = arrayBaseOffset(byteArray)
        ARRAY_SHORT_BASE_OFFSET = arrayBaseOffset(ShortArray::class.java)
        ARRAY_CHAR_BASE_OFFSET = arrayBaseOffset(CharArray::class.java)
        ARRAY_INT_BASE_OFFSET = arrayBaseOffset(IntArray::class.java)
        ARRAY_LONG_BASE_OFFSET = arrayBaseOffset(LongArray::class.java)
        ARRAY_FLOAT_BASE_OFFSET = arrayBaseOffset(FloatArray::class.java)
        ARRAY_DOUBLE_BASE_OFFSET = arrayBaseOffset(DoubleArray::class.java)
        ARRAY_OBJECT_BASE_OFFSET = arrayBaseOffset(objectArray)
        ARRAY_BOOLEAN_INDEX_SCALE = arrayIndexScale(BooleanArray::class.java)
        ARRAY_BYTE_INDEX_SCALE = arrayIndexScale(byteArray)
        ARRAY_SHORT_INDEX_SCALE = arrayIndexScale(ShortArray::class.java)
        ARRAY_CHAR_INDEX_SCALE = arrayIndexScale(CharArray::class.java)
        ARRAY_INT_INDEX_SCALE = arrayIndexScale(IntArray::class.java)
        ARRAY_LONG_INDEX_SCALE = arrayIndexScale(LongArray::class.java)
        ARRAY_FLOAT_INDEX_SCALE = arrayIndexScale(FloatArray::class.java)
        ARRAY_DOUBLE_INDEX_SCALE = arrayIndexScale(DoubleArray::class.java)
        ARRAY_OBJECT_INDEX_SCALE = arrayIndexScale(objectArray)
        ADDRESS_SIZE = addressSize()
    }
}