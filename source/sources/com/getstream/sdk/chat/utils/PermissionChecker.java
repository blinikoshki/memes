package com.getstream.sdk.chat.utils;

import android.content.Context;
import android.os.Build;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.listener.multi.DialogOnAnyDeniedMultiplePermissionsListener;
import com.karumi.dexter.listener.multi.SnackbarOnAnyDeniedMultiplePermissionsListener;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.core.internal.InternalStreamChatApi;
import p015io.getstream.chat.android.p016ui.common.C1891R;

@InternalStreamChatApi
@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\bJR\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u00102\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\bH\u0002J,\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\bJ \u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0002J\u000e\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0015J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\fH\u0002¨\u0006\u001b"}, mo26107d2 = {"Lcom/getstream/sdk/chat/utils/PermissionChecker;", "", "()V", "checkCameraPermissions", "", "view", "Landroid/view/View;", "onPermissionDenied", "Lkotlin/Function0;", "onPermissionGranted", "checkPermissions", "dialogTitle", "", "dialogMessage", "snackbarMessage", "permissions", "", "checkStoragePermissions", "dialogPermissionsListener", "Lcom/karumi/dexter/listener/multi/DialogOnAnyDeniedMultiplePermissionsListener;", "context", "Landroid/content/Context;", "isGrantedCameraPermissions", "", "isGrantedStoragePermissions", "snackbarPermissionsListener", "Lcom/karumi/dexter/listener/multi/SnackbarOnAnyDeniedMultiplePermissionsListener;", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: PermissionChecker.kt */
public final class PermissionChecker {
    public final boolean isGrantedStoragePermissions(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return Build.VERSION.SDK_INT < 23 || ContextCompat.checkSelfPermission(context, "android.permission.READ_EXTERNAL_STORAGE") == 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isGrantedCameraPermissions(android.content.Context r5) {
        /*
            r4 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 0
            r2 = 1
            r3 = 23
            if (r0 < r3) goto L_0x0048
            java.lang.String r0 = "android.permission.WRITE_EXTERNAL_STORAGE"
            java.lang.String r3 = "android.permission.CAMERA"
            java.lang.String[] r0 = new java.lang.String[]{r0, r3}
            java.util.List r0 = kotlin.collections.CollectionsKt.listOf(r0)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            boolean r3 = r0 instanceof java.util.Collection
            if (r3 == 0) goto L_0x002a
            r3 = r0
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L_0x002a
        L_0x0028:
            r5 = 1
            goto L_0x0046
        L_0x002a:
            java.util.Iterator r0 = r0.iterator()
        L_0x002e:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x0028
            java.lang.Object r3 = r0.next()
            java.lang.String r3 = (java.lang.String) r3
            int r3 = androidx.core.content.ContextCompat.checkSelfPermission(r5, r3)
            if (r3 != 0) goto L_0x0042
            r3 = 1
            goto L_0x0043
        L_0x0042:
            r3 = 0
        L_0x0043:
            if (r3 != 0) goto L_0x002e
            r5 = 0
        L_0x0046:
            if (r5 == 0) goto L_0x0049
        L_0x0048:
            r1 = 1
        L_0x0049:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.getstream.sdk.chat.utils.PermissionChecker.isGrantedCameraPermissions(android.content.Context):boolean");
    }

    public static /* synthetic */ void checkStoragePermissions$default(PermissionChecker permissionChecker, View view, Function0 function0, Function0 function02, int i, Object obj) {
        if ((i & 2) != 0) {
            function0 = PermissionChecker$checkStoragePermissions$1.INSTANCE;
        }
        permissionChecker.checkStoragePermissions(view, function0, function02);
    }

    public final void checkStoragePermissions(View view, Function0<Unit> function0, Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        Intrinsics.checkNotNullParameter(function0, "onPermissionDenied");
        Intrinsics.checkNotNullParameter(function02, "onPermissionGranted");
        String string = view.getContext().getString(C1891R.string.stream_permissions_storage_title);
        Intrinsics.checkNotNullExpressionValue(string, "view.context.getString(R…ermissions_storage_title)");
        String string2 = view.getContext().getString(C1891R.string.stream_permissions_storage_message);
        Intrinsics.checkNotNullExpressionValue(string2, "view.context.getString(R…missions_storage_message)");
        String string3 = view.getContext().getString(C1891R.string.stream_permissions_setting_message);
        Intrinsics.checkNotNullExpressionValue(string3, "view.context.getString(R…missions_setting_message)");
        checkPermissions(view, string, string2, string3, CollectionsKt.listOf("android.permission.READ_EXTERNAL_STORAGE"), function0, function02);
    }

    public static /* synthetic */ void checkCameraPermissions$default(PermissionChecker permissionChecker, View view, Function0 function0, Function0 function02, int i, Object obj) {
        if ((i & 2) != 0) {
            function0 = PermissionChecker$checkCameraPermissions$1.INSTANCE;
        }
        permissionChecker.checkCameraPermissions(view, function0, function02);
    }

    public final void checkCameraPermissions(View view, Function0<Unit> function0, Function0<Unit> function02) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        Intrinsics.checkNotNullParameter(function0, "onPermissionDenied");
        Intrinsics.checkNotNullParameter(function02, "onPermissionGranted");
        String string = view.getContext().getString(C1891R.string.stream_permissions_camera_title);
        Intrinsics.checkNotNullExpressionValue(string, "view.context.getString(R…permissions_camera_title)");
        String string2 = view.getContext().getString(C1891R.string.stream_permissions_camera_message);
        Intrinsics.checkNotNullExpressionValue(string2, "view.context.getString(R…rmissions_camera_message)");
        String string3 = view.getContext().getString(C1891R.string.stream_permissions_camera_message);
        Intrinsics.checkNotNullExpressionValue(string3, "view.context.getString(R…rmissions_camera_message)");
        checkPermissions(view, string, string2, string3, CollectionsKt.listOf("android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.CAMERA"), function0, function02);
    }

    private final void checkPermissions(View view, String str, String str2, String str3, List<String> list, Function0<Unit> function0, Function0<Unit> function02) {
        Dexter.withContext(view.getContext()).withPermissions((Collection<String>) list).withListener(new PermissionChecker$checkPermissions$permissionsListener$1(this, function02, view, str3, str, str2, function0)).check();
    }

    /* access modifiers changed from: private */
    public final SnackbarOnAnyDeniedMultiplePermissionsListener snackbarPermissionsListener(View view, String str) {
        SnackbarOnAnyDeniedMultiplePermissionsListener build = SnackbarOnAnyDeniedMultiplePermissionsListener.Builder.with(view, str).withOpenSettingsButton(C1891R.string.stream_permissions_setting_button).build();
        Intrinsics.checkNotNullExpressionValue(build, "SnackbarOnAnyDeniedMulti…ton)\n            .build()");
        return build;
    }

    /* access modifiers changed from: private */
    public final DialogOnAnyDeniedMultiplePermissionsListener dialogPermissionsListener(Context context, String str, String str2) {
        DialogOnAnyDeniedMultiplePermissionsListener build = DialogOnAnyDeniedMultiplePermissionsListener.Builder.withContext(context).withTitle(str).withMessage(str2).withButtonText(17039370).build();
        Intrinsics.checkNotNullExpressionValue(build, "DialogOnAnyDeniedMultipl….ok)\n            .build()");
        return build;
    }
}
