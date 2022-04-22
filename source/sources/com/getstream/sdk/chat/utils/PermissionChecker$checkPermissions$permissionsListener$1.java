package com.getstream.sdk.chat.utils;

import android.content.Context;
import android.view.View;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.listener.multi.BaseMultiplePermissionsListener;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo26107d2 = {"com/getstream/sdk/chat/utils/PermissionChecker$checkPermissions$permissionsListener$1", "Lcom/karumi/dexter/listener/multi/BaseMultiplePermissionsListener;", "onPermissionsChecked", "", "mumultiplePermissionsReport", "Lcom/karumi/dexter/MultiplePermissionsReport;", "stream-chat-android-ui-common_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: PermissionChecker.kt */
public final class PermissionChecker$checkPermissions$permissionsListener$1 extends BaseMultiplePermissionsListener {
    final /* synthetic */ String $dialogMessage;
    final /* synthetic */ String $dialogTitle;
    final /* synthetic */ Function0 $onPermissionDenied;
    final /* synthetic */ Function0 $onPermissionGranted;
    final /* synthetic */ String $snackbarMessage;
    final /* synthetic */ View $view;
    final /* synthetic */ PermissionChecker this$0;

    PermissionChecker$checkPermissions$permissionsListener$1(PermissionChecker permissionChecker, Function0 function0, View view, String str, String str2, String str3, Function0 function02) {
        this.this$0 = permissionChecker;
        this.$onPermissionGranted = function0;
        this.$view = view;
        this.$snackbarMessage = str;
        this.$dialogTitle = str2;
        this.$dialogMessage = str3;
        this.$onPermissionDenied = function02;
    }

    public void onPermissionsChecked(MultiplePermissionsReport multiplePermissionsReport) {
        Intrinsics.checkNotNullParameter(multiplePermissionsReport, "mumultiplePermissionsReport");
        if (multiplePermissionsReport.areAllPermissionsGranted()) {
            this.$onPermissionGranted.invoke();
            return;
        }
        if (multiplePermissionsReport.isAnyPermissionPermanentlyDenied()) {
            this.this$0.snackbarPermissionsListener(this.$view, this.$snackbarMessage).onPermissionsChecked(multiplePermissionsReport);
        } else {
            PermissionChecker permissionChecker = this.this$0;
            Context context = this.$view.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "view.context");
            permissionChecker.dialogPermissionsListener(context, this.$dialogTitle, this.$dialogMessage).onPermissionsChecked(multiplePermissionsReport);
        }
        this.$onPermissionDenied.invoke();
    }
}
