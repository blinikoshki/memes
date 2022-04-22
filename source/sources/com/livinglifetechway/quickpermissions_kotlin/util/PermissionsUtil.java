package com.livinglifetechway.quickpermissions_kotlin.util;

import android.content.Context;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.Fragment;
import com.facebook.internal.NativeProtocol;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J'\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ/\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u000b\u001a\u00020\f2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\rJ#\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, mo26107d2 = {"Lcom/livinglifetechway/quickpermissions_kotlin/util/PermissionsUtil;", "", "()V", "getDeniedPermissions", "", "", "permissions", "grantResults", "", "([Ljava/lang/String;[I)[Ljava/lang/String;", "getPermanentlyDeniedPermissions", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroid/support/v4/app/Fragment;[Ljava/lang/String;[I)[Ljava/lang/String;", "hasSelfPermission", "", "activity", "Landroid/content/Context;", "(Landroid/content/Context;[Ljava/lang/String;)Z", "quickpermissions-kotlin_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* compiled from: PermissionsUtil.kt */
public final class PermissionsUtil {
    public static final PermissionsUtil INSTANCE = new PermissionsUtil();

    private PermissionsUtil() {
    }

    public final boolean hasSelfPermission(Context context, String[] strArr) {
        Intrinsics.checkParameterIsNotNull(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        if (context == null) {
            return true;
        }
        for (String checkSelfPermission : strArr) {
            if (ActivityCompat.checkSelfPermission(context, checkSelfPermission) != 0) {
                return false;
            }
        }
        return true;
    }

    public final String[] getDeniedPermissions(String[] strArr, int[] iArr) {
        Intrinsics.checkParameterIsNotNull(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        Intrinsics.checkParameterIsNotNull(iArr, "grantResults");
        Collection arrayList = new ArrayList();
        int length = strArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            String str = strArr[i];
            int i3 = i2 + 1;
            if (iArr[i2] == -1) {
                arrayList.add(str);
            }
            i++;
            i2 = i3;
        }
        Object[] array = ((List) arrayList).toArray(new String[0]);
        if (array != null) {
            return (String[]) array;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public final String[] getPermanentlyDeniedPermissions(Fragment fragment, String[] strArr, int[] iArr) {
        Intrinsics.checkParameterIsNotNull(fragment, "fragment");
        Intrinsics.checkParameterIsNotNull(strArr, NativeProtocol.RESULT_ARGS_PERMISSIONS);
        Intrinsics.checkParameterIsNotNull(iArr, "grantResults");
        Collection arrayList = new ArrayList();
        int length = strArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            String str = strArr[i];
            int i3 = i2 + 1;
            if (iArr[i2] == -1 && !fragment.shouldShowRequestPermissionRationale(str)) {
                arrayList.add(str);
            }
            i++;
            i2 = i3;
        }
        Object[] array = ((List) arrayList).toArray(new String[0]);
        if (array != null) {
            return (String[]) array;
        }
        throw new TypeCastException("null cannot be cast to non-null type kotlin.Array<T>");
    }
}
