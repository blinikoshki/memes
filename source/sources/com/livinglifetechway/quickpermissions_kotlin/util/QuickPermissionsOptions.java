package com.livinglifetechway.quickpermissions_kotlin.util;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\"\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001Bu\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t\u0012\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t\u0012\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t¢\u0006\u0002\u0010\u000eJ\t\u0010#\u001a\u00020\u0003HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0005HÆ\u0003J\u0017\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tHÆ\u0003J\u0017\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tHÆ\u0003J\u0017\u0010)\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tHÆ\u0003Jy\u0010*\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00052\u0016\b\u0002\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t2\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\t2\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tHÆ\u0001J\u0013\u0010+\u001a\u00020\u00032\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020.HÖ\u0001J\t\u0010/\u001a\u00020\u0005HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R(\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0007\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR(\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001a\"\u0004\b \u0010\u001cR(\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0016\"\u0004\b\"\u0010\u0018¨\u00060"}, mo26107d2 = {"Lcom/livinglifetechway/quickpermissions_kotlin/util/QuickPermissionsOptions;", "", "handleRationale", "", "rationaleMessage", "", "handlePermanentlyDenied", "permanentlyDeniedMessage", "rationaleMethod", "Lkotlin/Function1;", "Lcom/livinglifetechway/quickpermissions_kotlin/util/QuickPermissionsRequest;", "", "permanentDeniedMethod", "permissionsDeniedMethod", "(ZLjava/lang/String;ZLjava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "getHandlePermanentlyDenied", "()Z", "setHandlePermanentlyDenied", "(Z)V", "getHandleRationale", "setHandleRationale", "getPermanentDeniedMethod", "()Lkotlin/jvm/functions/Function1;", "setPermanentDeniedMethod", "(Lkotlin/jvm/functions/Function1;)V", "getPermanentlyDeniedMessage", "()Ljava/lang/String;", "setPermanentlyDeniedMessage", "(Ljava/lang/String;)V", "getPermissionsDeniedMethod", "setPermissionsDeniedMethod", "getRationaleMessage", "setRationaleMessage", "getRationaleMethod", "setRationaleMethod", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "quickpermissions-kotlin_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* compiled from: QuickPermissionsOptions.kt */
public final class QuickPermissionsOptions {
    private boolean handlePermanentlyDenied;
    private boolean handleRationale;
    private Function1<? super QuickPermissionsRequest, Unit> permanentDeniedMethod;
    private String permanentlyDeniedMessage;
    private Function1<? super QuickPermissionsRequest, Unit> permissionsDeniedMethod;
    private String rationaleMessage;
    private Function1<? super QuickPermissionsRequest, Unit> rationaleMethod;

    public QuickPermissionsOptions() {
        this(false, (String) null, false, (String) null, (Function1) null, (Function1) null, (Function1) null, 127, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ QuickPermissionsOptions copy$default(QuickPermissionsOptions quickPermissionsOptions, boolean z, String str, boolean z2, String str2, Function1<? super QuickPermissionsRequest, Unit> function1, Function1<? super QuickPermissionsRequest, Unit> function12, Function1<? super QuickPermissionsRequest, Unit> function13, int i, Object obj) {
        if ((i & 1) != 0) {
            z = quickPermissionsOptions.handleRationale;
        }
        if ((i & 2) != 0) {
            str = quickPermissionsOptions.rationaleMessage;
        }
        String str3 = str;
        if ((i & 4) != 0) {
            z2 = quickPermissionsOptions.handlePermanentlyDenied;
        }
        boolean z3 = z2;
        if ((i & 8) != 0) {
            str2 = quickPermissionsOptions.permanentlyDeniedMessage;
        }
        String str4 = str2;
        if ((i & 16) != 0) {
            function1 = quickPermissionsOptions.rationaleMethod;
        }
        Function1<? super QuickPermissionsRequest, Unit> function14 = function1;
        if ((i & 32) != 0) {
            function12 = quickPermissionsOptions.permanentDeniedMethod;
        }
        Function1<? super QuickPermissionsRequest, Unit> function15 = function12;
        if ((i & 64) != 0) {
            function13 = quickPermissionsOptions.permissionsDeniedMethod;
        }
        return quickPermissionsOptions.copy(z, str3, z3, str4, function14, function15, function13);
    }

    public final boolean component1() {
        return this.handleRationale;
    }

    public final String component2() {
        return this.rationaleMessage;
    }

    public final boolean component3() {
        return this.handlePermanentlyDenied;
    }

    public final String component4() {
        return this.permanentlyDeniedMessage;
    }

    public final Function1<QuickPermissionsRequest, Unit> component5() {
        return this.rationaleMethod;
    }

    public final Function1<QuickPermissionsRequest, Unit> component6() {
        return this.permanentDeniedMethod;
    }

    public final Function1<QuickPermissionsRequest, Unit> component7() {
        return this.permissionsDeniedMethod;
    }

    public final QuickPermissionsOptions copy(boolean z, String str, boolean z2, String str2, Function1<? super QuickPermissionsRequest, Unit> function1, Function1<? super QuickPermissionsRequest, Unit> function12, Function1<? super QuickPermissionsRequest, Unit> function13) {
        Intrinsics.checkParameterIsNotNull(str, "rationaleMessage");
        Intrinsics.checkParameterIsNotNull(str2, "permanentlyDeniedMessage");
        return new QuickPermissionsOptions(z, str, z2, str2, function1, function12, function13);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof QuickPermissionsOptions) {
                QuickPermissionsOptions quickPermissionsOptions = (QuickPermissionsOptions) obj;
                if ((this.handleRationale == quickPermissionsOptions.handleRationale) && Intrinsics.areEqual((Object) this.rationaleMessage, (Object) quickPermissionsOptions.rationaleMessage)) {
                    if (!(this.handlePermanentlyDenied == quickPermissionsOptions.handlePermanentlyDenied) || !Intrinsics.areEqual((Object) this.permanentlyDeniedMessage, (Object) quickPermissionsOptions.permanentlyDeniedMessage) || !Intrinsics.areEqual((Object) this.rationaleMethod, (Object) quickPermissionsOptions.rationaleMethod) || !Intrinsics.areEqual((Object) this.permanentDeniedMethod, (Object) quickPermissionsOptions.permanentDeniedMethod) || !Intrinsics.areEqual((Object) this.permissionsDeniedMethod, (Object) quickPermissionsOptions.permissionsDeniedMethod)) {
                        return false;
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        boolean z = this.handleRationale;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i = (z ? 1 : 0) * true;
        String str = this.rationaleMessage;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        boolean z3 = this.handlePermanentlyDenied;
        if (!z3) {
            z2 = z3;
        }
        int i3 = (hashCode + (z2 ? 1 : 0)) * 31;
        String str2 = this.permanentlyDeniedMessage;
        int hashCode2 = (i3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Function1<? super QuickPermissionsRequest, Unit> function1 = this.rationaleMethod;
        int hashCode3 = (hashCode2 + (function1 != null ? function1.hashCode() : 0)) * 31;
        Function1<? super QuickPermissionsRequest, Unit> function12 = this.permanentDeniedMethod;
        int hashCode4 = (hashCode3 + (function12 != null ? function12.hashCode() : 0)) * 31;
        Function1<? super QuickPermissionsRequest, Unit> function13 = this.permissionsDeniedMethod;
        if (function13 != null) {
            i2 = function13.hashCode();
        }
        return hashCode4 + i2;
    }

    public String toString() {
        return "QuickPermissionsOptions(handleRationale=" + this.handleRationale + ", rationaleMessage=" + this.rationaleMessage + ", handlePermanentlyDenied=" + this.handlePermanentlyDenied + ", permanentlyDeniedMessage=" + this.permanentlyDeniedMessage + ", rationaleMethod=" + this.rationaleMethod + ", permanentDeniedMethod=" + this.permanentDeniedMethod + ", permissionsDeniedMethod=" + this.permissionsDeniedMethod + ")";
    }

    public QuickPermissionsOptions(boolean z, String str, boolean z2, String str2, Function1<? super QuickPermissionsRequest, Unit> function1, Function1<? super QuickPermissionsRequest, Unit> function12, Function1<? super QuickPermissionsRequest, Unit> function13) {
        Intrinsics.checkParameterIsNotNull(str, "rationaleMessage");
        Intrinsics.checkParameterIsNotNull(str2, "permanentlyDeniedMessage");
        this.handleRationale = z;
        this.rationaleMessage = str;
        this.handlePermanentlyDenied = z2;
        this.permanentlyDeniedMessage = str2;
        this.rationaleMethod = function1;
        this.permanentDeniedMethod = function12;
        this.permissionsDeniedMethod = function13;
    }

    public final boolean getHandleRationale() {
        return this.handleRationale;
    }

    public final void setHandleRationale(boolean z) {
        this.handleRationale = z;
    }

    public final String getRationaleMessage() {
        return this.rationaleMessage;
    }

    public final void setRationaleMessage(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.rationaleMessage = str;
    }

    public final boolean getHandlePermanentlyDenied() {
        return this.handlePermanentlyDenied;
    }

    public final void setHandlePermanentlyDenied(boolean z) {
        this.handlePermanentlyDenied = z;
    }

    public final String getPermanentlyDeniedMessage() {
        return this.permanentlyDeniedMessage;
    }

    public final void setPermanentlyDeniedMessage(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.permanentlyDeniedMessage = str;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ QuickPermissionsOptions(boolean r6, java.lang.String r7, boolean r8, java.lang.String r9, kotlin.jvm.functions.Function1 r10, kotlin.jvm.functions.Function1 r11, kotlin.jvm.functions.Function1 r12, int r13, kotlin.jvm.internal.DefaultConstructorMarker r14) {
        /*
            r5 = this;
            r14 = r13 & 1
            r0 = 1
            if (r14 == 0) goto L_0x0007
            r14 = 1
            goto L_0x0008
        L_0x0007:
            r14 = r6
        L_0x0008:
            r6 = r13 & 2
            java.lang.String r1 = ""
            if (r6 == 0) goto L_0x0010
            r2 = r1
            goto L_0x0011
        L_0x0010:
            r2 = r7
        L_0x0011:
            r6 = r13 & 4
            if (r6 == 0) goto L_0x0016
            goto L_0x0017
        L_0x0016:
            r0 = r8
        L_0x0017:
            r6 = r13 & 8
            if (r6 == 0) goto L_0x001c
            goto L_0x001d
        L_0x001c:
            r1 = r9
        L_0x001d:
            r6 = r13 & 16
            r7 = 0
            if (r6 == 0) goto L_0x0025
            r10 = r7
            kotlin.jvm.functions.Function1 r10 = (kotlin.jvm.functions.Function1) r10
        L_0x0025:
            r3 = r10
            r6 = r13 & 32
            if (r6 == 0) goto L_0x002d
            r11 = r7
            kotlin.jvm.functions.Function1 r11 = (kotlin.jvm.functions.Function1) r11
        L_0x002d:
            r4 = r11
            r6 = r13 & 64
            if (r6 == 0) goto L_0x0035
            r12 = r7
            kotlin.jvm.functions.Function1 r12 = (kotlin.jvm.functions.Function1) r12
        L_0x0035:
            r13 = r12
            r6 = r5
            r7 = r14
            r8 = r2
            r9 = r0
            r10 = r1
            r11 = r3
            r12 = r4
            r6.<init>(r7, r8, r9, r10, r11, r12, r13)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.livinglifetechway.quickpermissions_kotlin.util.QuickPermissionsOptions.<init>(boolean, java.lang.String, boolean, java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Function1<QuickPermissionsRequest, Unit> getRationaleMethod() {
        return this.rationaleMethod;
    }

    public final void setRationaleMethod(Function1<? super QuickPermissionsRequest, Unit> function1) {
        this.rationaleMethod = function1;
    }

    public final Function1<QuickPermissionsRequest, Unit> getPermanentDeniedMethod() {
        return this.permanentDeniedMethod;
    }

    public final void setPermanentDeniedMethod(Function1<? super QuickPermissionsRequest, Unit> function1) {
        this.permanentDeniedMethod = function1;
    }

    public final Function1<QuickPermissionsRequest, Unit> getPermissionsDeniedMethod() {
        return this.permissionsDeniedMethod;
    }

    public final void setPermissionsDeniedMethod(Function1<? super QuickPermissionsRequest, Unit> function1) {
        this.permissionsDeniedMethod = function1;
    }
}
