package com.livinglifetechway.quickpermissions_kotlin.util;

import android.content.DialogInterface;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.anko.AlertBuilder;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n¢\u0006\u0002\b\u0004"}, mo26107d2 = {"<anonymous>", "", "Lorg/jetbrains/anko/AlertBuilder;", "Landroid/content/DialogInterface;", "invoke"}, mo26108k = 3, mo26109mv = {1, 1, 13})
/* compiled from: PermissionCheckerFragment.kt */
final class PermissionCheckerFragment$handlePermissionResult$5 extends Lambda implements Function1<AlertBuilder<? extends DialogInterface>, Unit> {
    final /* synthetic */ PermissionCheckerFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PermissionCheckerFragment$handlePermissionResult$5(PermissionCheckerFragment permissionCheckerFragment) {
        super(1);
        this.this$0 = permissionCheckerFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((AlertBuilder<? extends DialogInterface>) (AlertBuilder) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(AlertBuilder<? extends DialogInterface> alertBuilder) {
        Intrinsics.checkParameterIsNotNull(alertBuilder, "receiver$0");
        QuickPermissionsRequest access$getQuickPermissionsRequest$p = this.this$0.quickPermissionsRequest;
        String rationaleMessage = access$getQuickPermissionsRequest$p != null ? access$getQuickPermissionsRequest$p.getRationaleMessage() : null;
        if (rationaleMessage == null) {
            rationaleMessage = "";
        }
        alertBuilder.setMessage(rationaleMessage);
        alertBuilder.positiveButton("TRY AGAIN", (Function1<? super DialogInterface, Unit>) new Function1<DialogInterface, Unit>(this) {
            final /* synthetic */ PermissionCheckerFragment$handlePermissionResult$5 this$0;

            {
                this.this$0 = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((DialogInterface) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(DialogInterface dialogInterface) {
                Intrinsics.checkParameterIsNotNull(dialogInterface, "it");
                this.this$0.this$0.requestPermissionsFromUser();
            }
        });
        alertBuilder.negativeButton("CANCEL", (Function1<? super DialogInterface, Unit>) new Function1<DialogInterface, Unit>(this) {
            final /* synthetic */ PermissionCheckerFragment$handlePermissionResult$5 this$0;

            {
                this.this$0 = r1;
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((DialogInterface) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(DialogInterface dialogInterface) {
                Intrinsics.checkParameterIsNotNull(dialogInterface, "it");
                this.this$0.this$0.clean();
            }
        });
    }
}
