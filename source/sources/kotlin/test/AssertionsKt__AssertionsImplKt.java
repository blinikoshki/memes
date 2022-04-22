package kotlin.test;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a \u0010\u0000\u001a\u00060\u0001j\u0002`\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0000\u001a\u001b\u0010\u0007\u001a\u00020\u00062\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0007¢\u0006\u0002\b\u000b\u001a%\u0010\u0007\u001a\u00020\u00062\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0007¢\u0006\u0002\b\u000b\u001a5\u0010\f\u001a\u0002H\r\"\b\b\u0000\u0010\r*\u00020\u00062\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\r0\u000f2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001a?\u0010\f\u001a\u0002H\r\"\b\b\u0000\u0010\r*\u00020\u00062\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\r0\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0007¢\u0006\u0004\b\u0010\u0010\u0012\u001a@\u0010\u0013\u001a\u0002H\r\"\b\b\u0000\u0010\r*\u00020\u00062\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\r0\u000f2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00042\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\n0\u0015H\u0001ø\u0001\u0000¢\u0006\u0002\u0010\u0016\u001a4\u0010\u0017\u001a(\u0012\f\u0012\n \u001a*\u0004\u0018\u00010\u00190\u0019 \u001a*\u0014\u0012\u000e\b\u0001\u0012\n \u001a*\u0004\u0018\u00010\u00190\u0019\u0018\u00010\u00180\u0018H\b¢\u0006\u0002\u0010\u001b\u001a\u001a\u0010\u001c\u001a\u00020\n2\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\bø\u0001\u0001\u0002\u000b\n\u0002\b\u0019\n\u0005\b20\u0001¨\u0006\u001d"}, mo26107d2 = {"AssertionErrorWithCause", "Ljava/lang/AssertionError;", "Lkotlin/AssertionError;", "message", "", "cause", "", "assertFailsNoInline", "block", "Lkotlin/Function0;", "", "assertFails", "assertFailsWithNoInline", "T", "exceptionClass", "Lkotlin/reflect/KClass;", "assertFailsWith", "(Lkotlin/reflect/KClass;Lkotlin/jvm/functions/Function0;)Ljava/lang/Throwable;", "(Lkotlin/reflect/KClass;Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Throwable;", "checkResultIsFailure", "blockResult", "Lkotlin/Result;", "(Lkotlin/reflect/KClass;Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Throwable;", "currentStackTrace", "", "Ljava/lang/StackTraceElement;", "kotlin.jvm.PlatformType", "()[Ljava/lang/StackTraceElement;", "todo", "kotlin-test"}, mo26108k = 5, mo26109mv = {1, 4, 1}, mo26112xs = "kotlin/test/AssertionsKt")
/* compiled from: AssertionsImpl.kt */
final /* synthetic */ class AssertionsKt__AssertionsImplKt {
    public static final <T extends Throwable> T checkResultIsFailure(KClass<T> kClass, String str, Object obj) {
        Intrinsics.checkNotNullParameter(kClass, "exceptionClass");
        T r0 = Result.m1032exceptionOrNullimpl(obj);
        if (r0 == null) {
            Unit unit = (Unit) obj;
            String messagePrefix = UtilsKt.messagePrefix(str);
            Asserter asserter = AssertionsKt.getAsserter();
            asserter.fail(messagePrefix + "Expected an exception of " + JvmClassMappingKt.getJavaClass(kClass) + " to be thrown, but was completed successfully.");
            throw new KotlinNothingValueException();
        } else if (JvmClassMappingKt.getJavaClass(kClass).isInstance(r0)) {
            return r0;
        } else {
            Asserter asserter2 = AssertionsKt.getAsserter();
            asserter2.fail(UtilsKt.messagePrefix(str) + "Expected an exception of " + JvmClassMappingKt.getJavaClass(kClass) + " to be thrown, but was " + r0, r0);
            throw new KotlinNothingValueException();
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Provided for binary compatibility")
    public static final /* synthetic */ Throwable assertFails(Function0<Unit> function0) {
        Object obj;
        Intrinsics.checkNotNullParameter(function0, "block");
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m1029constructorimpl(function0.invoke());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m1029constructorimpl(ResultKt.createFailure(th));
        }
        return AssertionsKt.checkResultIsFailure((String) null, obj);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Provided for binary compatibility")
    public static final /* synthetic */ Throwable assertFails(String str, Function0<Unit> function0) {
        Object obj;
        Intrinsics.checkNotNullParameter(function0, "block");
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m1029constructorimpl(function0.invoke());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m1029constructorimpl(ResultKt.createFailure(th));
        }
        return AssertionsKt.checkResultIsFailure(str, obj);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Provided for binary compatibility")
    public static final /* synthetic */ <T extends Throwable> T assertFailsWith(KClass<T> kClass, Function0<Unit> function0) {
        Object obj;
        Intrinsics.checkNotNullParameter(kClass, "exceptionClass");
        Intrinsics.checkNotNullParameter(function0, "block");
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m1029constructorimpl(function0.invoke());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m1029constructorimpl(ResultKt.createFailure(th));
        }
        return AssertionsKt.checkResultIsFailure(kClass, (String) null, obj);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Provided for binary compatibility")
    public static final /* synthetic */ <T extends Throwable> T assertFailsWith(KClass<T> kClass, String str, Function0<Unit> function0) {
        Object obj;
        Intrinsics.checkNotNullParameter(kClass, "exceptionClass");
        Intrinsics.checkNotNullParameter(function0, "block");
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m1029constructorimpl(function0.invoke());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m1029constructorimpl(ResultKt.createFailure(th));
        }
        return AssertionsKt.checkResultIsFailure(kClass, str, obj);
    }

    private static final void todo(Function0<Unit> function0) {
        System.out.println("TODO at " + new Exception().getStackTrace()[0]);
    }

    private static final StackTraceElement[] currentStackTrace() {
        return new Exception().getStackTrace();
    }

    public static final AssertionError AssertionErrorWithCause(String str, Throwable th) {
        AssertionError assertionError = str == null ? new AssertionError() : new AssertionError(str);
        assertionError.initCause(th);
        return assertionError;
    }
}
