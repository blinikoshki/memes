package com.livinglifetechway.quickpermissions_kotlin.util;

import com.facebook.internal.NativeProtocol;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b6\n\u0002\u0010\b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B­\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\b\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006\u0012\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u0012\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u0012\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0013J\u0006\u00101\u001a\u00020\u000eJ\t\u00102\u001a\u00020\u0003HÂ\u0003J\u0014\u00103\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0014\u00104\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\u0014\u00105\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003¢\u0006\u0002\u0010\u0015J\t\u00106\u001a\u00020\bHÆ\u0003J\t\u00107\u001a\u00020\u0006HÆ\u0003J\t\u00108\u001a\u00020\bHÆ\u0003J\t\u00109\u001a\u00020\u0006HÆ\u0003J\u001c\u0010:\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rHÀ\u0003¢\u0006\u0002\b;J\u001c\u0010<\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rHÀ\u0003¢\u0006\u0002\b=J\u001c\u0010>\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rHÀ\u0003¢\u0006\u0002\b?J¸\u0001\u0010@\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\u00062\u0016\b\u0002\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0016\b\u0002\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u0016\b\u0002\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001¢\u0006\u0002\u0010AJ\u0013\u0010B\u001a\u00020\b2\b\u0010C\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010D\u001a\u00020EHÖ\u0001J\u0006\u0010F\u001a\u00020\u000eJ\u0006\u0010G\u001a\u00020\u000eJ\t\u0010H\u001a\u00020\u0006HÖ\u0001R\"\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\n\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001a\"\u0004\b\u001e\u0010\u001cR(\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001a\u0010\u000b\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\"\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b'\u0010\u0015\"\u0004\b(\u0010\u0017R\"\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u000e¢\u0006\u0010\n\u0002\u0010\u0018\u001a\u0004\b)\u0010\u0015\"\u0004\b*\u0010\u0017R(\u0010\u0010\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010 \"\u0004\b,\u0010\"R\u001a\u0010\t\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010$\"\u0004\b.\u0010&R(\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u000e\u0018\u00010\rX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010 \"\u0004\b0\u0010\"R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006I"}, mo26107d2 = {"Lcom/livinglifetechway/quickpermissions_kotlin/util/QuickPermissionsRequest;", "", "target", "Lcom/livinglifetechway/quickpermissions_kotlin/util/PermissionCheckerFragment;", "permissions", "", "", "handleRationale", "", "rationaleMessage", "handlePermanentlyDenied", "permanentlyDeniedMessage", "rationaleMethod", "Lkotlin/Function1;", "", "permanentDeniedMethod", "permissionsDeniedMethod", "deniedPermissions", "permanentlyDeniedPermissions", "(Lcom/livinglifetechway/quickpermissions_kotlin/util/PermissionCheckerFragment;[Ljava/lang/String;ZLjava/lang/String;ZLjava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;[Ljava/lang/String;[Ljava/lang/String;)V", "getDeniedPermissions", "()[Ljava/lang/String;", "setDeniedPermissions", "([Ljava/lang/String;)V", "[Ljava/lang/String;", "getHandlePermanentlyDenied", "()Z", "setHandlePermanentlyDenied", "(Z)V", "getHandleRationale", "setHandleRationale", "getPermanentDeniedMethod$quickpermissions_kotlin_release", "()Lkotlin/jvm/functions/Function1;", "setPermanentDeniedMethod$quickpermissions_kotlin_release", "(Lkotlin/jvm/functions/Function1;)V", "getPermanentlyDeniedMessage", "()Ljava/lang/String;", "setPermanentlyDeniedMessage", "(Ljava/lang/String;)V", "getPermanentlyDeniedPermissions", "setPermanentlyDeniedPermissions", "getPermissions", "setPermissions", "getPermissionsDeniedMethod$quickpermissions_kotlin_release", "setPermissionsDeniedMethod$quickpermissions_kotlin_release", "getRationaleMessage", "setRationaleMessage", "getRationaleMethod$quickpermissions_kotlin_release", "setRationaleMethod$quickpermissions_kotlin_release", "cancel", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component7$quickpermissions_kotlin_release", "component8", "component8$quickpermissions_kotlin_release", "component9", "component9$quickpermissions_kotlin_release", "copy", "(Lcom/livinglifetechway/quickpermissions_kotlin/util/PermissionCheckerFragment;[Ljava/lang/String;ZLjava/lang/String;ZLjava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;[Ljava/lang/String;[Ljava/lang/String;)Lcom/livinglifetechway/quickpermissions_kotlin/util/QuickPermissionsRequest;", "equals", "other", "hashCode", "", "openAppSettings", "proceed", "toString", "quickpermissions-kotlin_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* compiled from: QuickPermissionsRequest.kt */
public final class QuickPermissionsRequest {
    private String[] deniedPermissions;
    private boolean handlePermanentlyDenied;
    private boolean handleRationale;
    private Function1<? super QuickPermissionsRequest, Unit> permanentDeniedMethod;
    private String permanentlyDeniedMessage;
    private String[] permanentlyDeniedPermissions;
    private String[] permissions;
    private Function1<? super QuickPermissionsRequest, Unit> permissionsDeniedMethod;
    private String rationaleMessage;
    private Function1<? super QuickPermissionsRequest, Unit> rationaleMethod;
    private PermissionCheckerFragment target;

    private final PermissionCheckerFragment component1() {
        return this.target;
    }

    public static /* synthetic */ QuickPermissionsRequest copy$default(QuickPermissionsRequest quickPermissionsRequest, PermissionCheckerFragment permissionCheckerFragment, String[] strArr, boolean z, String str, boolean z2, String str2, Function1 function1, Function1 function12, Function1 function13, String[] strArr2, String[] strArr3, int i, Object obj) {
        QuickPermissionsRequest quickPermissionsRequest2 = quickPermissionsRequest;
        int i2 = i;
        return quickPermissionsRequest.copy((i2 & 1) != 0 ? quickPermissionsRequest2.target : permissionCheckerFragment, (i2 & 2) != 0 ? quickPermissionsRequest2.permissions : strArr, (i2 & 4) != 0 ? quickPermissionsRequest2.handleRationale : z, (i2 & 8) != 0 ? quickPermissionsRequest2.rationaleMessage : str, (i2 & 16) != 0 ? quickPermissionsRequest2.handlePermanentlyDenied : z2, (i2 & 32) != 0 ? quickPermissionsRequest2.permanentlyDeniedMessage : str2, (i2 & 64) != 0 ? quickPermissionsRequest2.rationaleMethod : function1, (i2 & 128) != 0 ? quickPermissionsRequest2.permanentDeniedMethod : function12, (i2 & 256) != 0 ? quickPermissionsRequest2.permissionsDeniedMethod : function13, (i2 & 512) != 0 ? quickPermissionsRequest2.deniedPermissions : strArr2, (i2 & 1024) != 0 ? quickPermissionsRequest2.permanentlyDeniedPermissions : strArr3);
    }

    public final String[] component10() {
        return this.deniedPermissions;
    }

    public final String[] component11() {
        return this.permanentlyDeniedPermissions;
    }

    public final String[] component2() {
        return this.permissions;
    }

    public final boolean component3() {
        return this.handleRationale;
    }

    public final String component4() {
        return this.rationaleMessage;
    }

    public final boolean component5() {
        return this.handlePermanentlyDenied;
    }

    public final String component6() {
        return this.permanentlyDeniedMessage;
    }

    public final Function1<QuickPermissionsRequest, Unit> component7$quickpermissions_kotlin_release() {
        return this.rationaleMethod;
    }

    public final Function1<QuickPermissionsRequest, Unit> component8$quickpermissions_kotlin_release() {
        return this.permanentDeniedMethod;
    }

    public final Function1<QuickPermissionsRequest, Unit> component9$quickpermissions_kotlin_release() {
        return this.permissionsDeniedMethod;
    }

    public final QuickPermissionsRequest copy(PermissionCheckerFragment permissionCheckerFragment, String[] strArr, boolean z, String str, boolean z2, String str2, Function1<? super QuickPermissionsRequest, Unit> function1, Function1<? super QuickPermissionsRequest, Unit> function12, Function1<? super QuickPermissionsRequest, Unit> function13, String[] strArr2, String[] strArr3) {
        Intrinsics.checkParameterIsNotNull(permissionCheckerFragment, "target");
        Intrinsics.checkParameterIsNotNull(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        String str3 = str;
        Intrinsics.checkParameterIsNotNull(str3, "rationaleMessage");
        String str4 = str2;
        Intrinsics.checkParameterIsNotNull(str4, "permanentlyDeniedMessage");
        String[] strArr4 = strArr2;
        Intrinsics.checkParameterIsNotNull(strArr4, "deniedPermissions");
        String[] strArr5 = strArr3;
        Intrinsics.checkParameterIsNotNull(strArr5, "permanentlyDeniedPermissions");
        return new QuickPermissionsRequest(permissionCheckerFragment, strArr, z, str3, z2, str4, function1, function12, function13, strArr4, strArr5);
    }

    public boolean equals(Object obj) {
        if (this != obj) {
            if (obj instanceof QuickPermissionsRequest) {
                QuickPermissionsRequest quickPermissionsRequest = (QuickPermissionsRequest) obj;
                if (Intrinsics.areEqual((Object) this.target, (Object) quickPermissionsRequest.target) && Intrinsics.areEqual((Object) this.permissions, (Object) quickPermissionsRequest.permissions)) {
                    if ((this.handleRationale == quickPermissionsRequest.handleRationale) && Intrinsics.areEqual((Object) this.rationaleMessage, (Object) quickPermissionsRequest.rationaleMessage)) {
                        if (!(this.handlePermanentlyDenied == quickPermissionsRequest.handlePermanentlyDenied) || !Intrinsics.areEqual((Object) this.permanentlyDeniedMessage, (Object) quickPermissionsRequest.permanentlyDeniedMessage) || !Intrinsics.areEqual((Object) this.rationaleMethod, (Object) quickPermissionsRequest.rationaleMethod) || !Intrinsics.areEqual((Object) this.permanentDeniedMethod, (Object) quickPermissionsRequest.permanentDeniedMethod) || !Intrinsics.areEqual((Object) this.permissionsDeniedMethod, (Object) quickPermissionsRequest.permissionsDeniedMethod) || !Intrinsics.areEqual((Object) this.deniedPermissions, (Object) quickPermissionsRequest.deniedPermissions) || !Intrinsics.areEqual((Object) this.permanentlyDeniedPermissions, (Object) quickPermissionsRequest.permanentlyDeniedPermissions)) {
                            return false;
                        }
                    }
                }
            }
            return false;
        }
        return true;
    }

    public int hashCode() {
        PermissionCheckerFragment permissionCheckerFragment = this.target;
        int i = 0;
        int hashCode = (permissionCheckerFragment != null ? permissionCheckerFragment.hashCode() : 0) * 31;
        String[] strArr = this.permissions;
        int hashCode2 = (hashCode + (strArr != null ? Arrays.hashCode(strArr) : 0)) * 31;
        boolean z = this.handleRationale;
        boolean z2 = true;
        if (z) {
            z = true;
        }
        int i2 = (hashCode2 + (z ? 1 : 0)) * 31;
        String str = this.rationaleMessage;
        int hashCode3 = (i2 + (str != null ? str.hashCode() : 0)) * 31;
        boolean z3 = this.handlePermanentlyDenied;
        if (!z3) {
            z2 = z3;
        }
        int i3 = (hashCode3 + (z2 ? 1 : 0)) * 31;
        String str2 = this.permanentlyDeniedMessage;
        int hashCode4 = (i3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        Function1<? super QuickPermissionsRequest, Unit> function1 = this.rationaleMethod;
        int hashCode5 = (hashCode4 + (function1 != null ? function1.hashCode() : 0)) * 31;
        Function1<? super QuickPermissionsRequest, Unit> function12 = this.permanentDeniedMethod;
        int hashCode6 = (hashCode5 + (function12 != null ? function12.hashCode() : 0)) * 31;
        Function1<? super QuickPermissionsRequest, Unit> function13 = this.permissionsDeniedMethod;
        int hashCode7 = (hashCode6 + (function13 != null ? function13.hashCode() : 0)) * 31;
        String[] strArr2 = this.deniedPermissions;
        int hashCode8 = (hashCode7 + (strArr2 != null ? Arrays.hashCode(strArr2) : 0)) * 31;
        String[] strArr3 = this.permanentlyDeniedPermissions;
        if (strArr3 != null) {
            i = Arrays.hashCode(strArr3);
        }
        return hashCode8 + i;
    }

    public String toString() {
        return "QuickPermissionsRequest(target=" + this.target + ", permissions=" + Arrays.toString(this.permissions) + ", handleRationale=" + this.handleRationale + ", rationaleMessage=" + this.rationaleMessage + ", handlePermanentlyDenied=" + this.handlePermanentlyDenied + ", permanentlyDeniedMessage=" + this.permanentlyDeniedMessage + ", rationaleMethod=" + this.rationaleMethod + ", permanentDeniedMethod=" + this.permanentDeniedMethod + ", permissionsDeniedMethod=" + this.permissionsDeniedMethod + ", deniedPermissions=" + Arrays.toString(this.deniedPermissions) + ", permanentlyDeniedPermissions=" + Arrays.toString(this.permanentlyDeniedPermissions) + ")";
    }

    public QuickPermissionsRequest(PermissionCheckerFragment permissionCheckerFragment, String[] strArr, boolean z, String str, boolean z2, String str2, Function1<? super QuickPermissionsRequest, Unit> function1, Function1<? super QuickPermissionsRequest, Unit> function12, Function1<? super QuickPermissionsRequest, Unit> function13, String[] strArr2, String[] strArr3) {
        Intrinsics.checkParameterIsNotNull(permissionCheckerFragment, "target");
        Intrinsics.checkParameterIsNotNull(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        Intrinsics.checkParameterIsNotNull(str, "rationaleMessage");
        Intrinsics.checkParameterIsNotNull(str2, "permanentlyDeniedMessage");
        Intrinsics.checkParameterIsNotNull(strArr2, "deniedPermissions");
        Intrinsics.checkParameterIsNotNull(strArr3, "permanentlyDeniedPermissions");
        this.target = permissionCheckerFragment;
        this.permissions = strArr;
        this.handleRationale = z;
        this.rationaleMessage = str;
        this.handlePermanentlyDenied = z2;
        this.permanentlyDeniedMessage = str2;
        this.rationaleMethod = function1;
        this.permanentDeniedMethod = function12;
        this.permissionsDeniedMethod = function13;
        this.deniedPermissions = strArr2;
        this.permanentlyDeniedPermissions = strArr3;
    }

    public final String[] getPermissions() {
        return this.permissions;
    }

    public final void setPermissions(String[] strArr) {
        Intrinsics.checkParameterIsNotNull(strArr, "<set-?>");
        this.permissions = strArr;
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
    public /* synthetic */ QuickPermissionsRequest(com.livinglifetechway.quickpermissions_kotlin.util.PermissionCheckerFragment r12, java.lang.String[] r13, boolean r14, java.lang.String r15, boolean r16, java.lang.String r17, kotlin.jvm.functions.Function1 r18, kotlin.jvm.functions.Function1 r19, kotlin.jvm.functions.Function1 r20, java.lang.String[] r21, java.lang.String[] r22, int r23, kotlin.jvm.internal.DefaultConstructorMarker r24) {
        /*
            r11 = this;
            r0 = r23
            r1 = r0 & 2
            r2 = 0
            if (r1 == 0) goto L_0x000a
            java.lang.String[] r1 = new java.lang.String[r2]
            goto L_0x000b
        L_0x000a:
            r1 = r13
        L_0x000b:
            r3 = r0 & 4
            r4 = 1
            if (r3 == 0) goto L_0x0012
            r3 = 1
            goto L_0x0013
        L_0x0012:
            r3 = r14
        L_0x0013:
            r5 = r0 & 8
            java.lang.String r6 = ""
            if (r5 == 0) goto L_0x001b
            r5 = r6
            goto L_0x001c
        L_0x001b:
            r5 = r15
        L_0x001c:
            r7 = r0 & 16
            if (r7 == 0) goto L_0x0021
            goto L_0x0023
        L_0x0021:
            r4 = r16
        L_0x0023:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0028
            goto L_0x002a
        L_0x0028:
            r6 = r17
        L_0x002a:
            r7 = r0 & 64
            r8 = 0
            if (r7 == 0) goto L_0x0033
            r7 = r8
            kotlin.jvm.functions.Function1 r7 = (kotlin.jvm.functions.Function1) r7
            goto L_0x0035
        L_0x0033:
            r7 = r18
        L_0x0035:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x003d
            r9 = r8
            kotlin.jvm.functions.Function1 r9 = (kotlin.jvm.functions.Function1) r9
            goto L_0x003f
        L_0x003d:
            r9 = r19
        L_0x003f:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0046
            kotlin.jvm.functions.Function1 r8 = (kotlin.jvm.functions.Function1) r8
            goto L_0x0048
        L_0x0046:
            r8 = r20
        L_0x0048:
            r10 = r0 & 512(0x200, float:7.175E-43)
            if (r10 == 0) goto L_0x004f
            java.lang.String[] r10 = new java.lang.String[r2]
            goto L_0x0051
        L_0x004f:
            r10 = r21
        L_0x0051:
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0058
            java.lang.String[] r0 = new java.lang.String[r2]
            goto L_0x005a
        L_0x0058:
            r0 = r22
        L_0x005a:
            r13 = r11
            r14 = r12
            r15 = r1
            r16 = r3
            r17 = r5
            r18 = r4
            r19 = r6
            r20 = r7
            r21 = r9
            r22 = r8
            r23 = r10
            r24 = r0
            r13.<init>(r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.livinglifetechway.quickpermissions_kotlin.util.QuickPermissionsRequest.<init>(com.livinglifetechway.quickpermissions_kotlin.util.PermissionCheckerFragment, java.lang.String[], boolean, java.lang.String, boolean, java.lang.String, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function1, java.lang.String[], java.lang.String[], int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final Function1<QuickPermissionsRequest, Unit> getRationaleMethod$quickpermissions_kotlin_release() {
        return this.rationaleMethod;
    }

    public final void setRationaleMethod$quickpermissions_kotlin_release(Function1<? super QuickPermissionsRequest, Unit> function1) {
        this.rationaleMethod = function1;
    }

    public final Function1<QuickPermissionsRequest, Unit> getPermanentDeniedMethod$quickpermissions_kotlin_release() {
        return this.permanentDeniedMethod;
    }

    public final void setPermanentDeniedMethod$quickpermissions_kotlin_release(Function1<? super QuickPermissionsRequest, Unit> function1) {
        this.permanentDeniedMethod = function1;
    }

    public final Function1<QuickPermissionsRequest, Unit> getPermissionsDeniedMethod$quickpermissions_kotlin_release() {
        return this.permissionsDeniedMethod;
    }

    public final void setPermissionsDeniedMethod$quickpermissions_kotlin_release(Function1<? super QuickPermissionsRequest, Unit> function1) {
        this.permissionsDeniedMethod = function1;
    }

    public final String[] getDeniedPermissions() {
        return this.deniedPermissions;
    }

    public final void setDeniedPermissions(String[] strArr) {
        Intrinsics.checkParameterIsNotNull(strArr, "<set-?>");
        this.deniedPermissions = strArr;
    }

    public final String[] getPermanentlyDeniedPermissions() {
        return this.permanentlyDeniedPermissions;
    }

    public final void setPermanentlyDeniedPermissions(String[] strArr) {
        Intrinsics.checkParameterIsNotNull(strArr, "<set-?>");
        this.permanentlyDeniedPermissions = strArr;
    }

    public final void proceed() {
        this.target.requestPermissionsFromUser();
    }

    public final void cancel() {
        this.target.clean();
    }

    public final void openAppSettings() {
        this.target.openAppSettings();
    }
}
