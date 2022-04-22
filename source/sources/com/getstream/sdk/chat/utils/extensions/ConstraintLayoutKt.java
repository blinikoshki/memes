package com.getstream.sdk.chat.utils.extensions;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.core.internal.InternalStreamChatApi;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0007\u001a\u001c\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0007\u001a\u001c\u0010\u0007\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\nH\u0007\u001a%\u0010\u000b\u001a\u00020\u0001*\u00020\u00022\u0012\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\r\"\u00020\u0004H\u0007¢\u0006\u0002\u0010\u000e\u001a%\u0010\u000f\u001a\u00020\u0001*\u00020\u00102\u0017\u0010\u0011\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00010\u0012¢\u0006\u0002\b\u0013H\u0007\u001a%\u0010\u0014\u001a\u00020\u0001*\u00020\u00022\u0012\u0010\f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\r\"\u00020\u0004H\u0007¢\u0006\u0002\u0010\u000e¨\u0006\u0015"}, mo26107d2 = {"constrainViewEndToEndOfView", "", "Landroidx/constraintlayout/widget/ConstraintSet;", "startView", "Landroid/view/View;", "endView", "constrainViewStartToEndOfView", "constrainViewToParentBySide", "view", "side", "", "horizontalChainInParent", "views", "", "(Landroidx/constraintlayout/widget/ConstraintSet;[Landroid/view/View;)V", "updateConstraints", "Landroidx/constraintlayout/widget/ConstraintLayout;", "actions", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "verticalChainInParent", "stream-chat-android-ui-common_release"}, mo26108k = 2, mo26109mv = {1, 4, 2})
/* compiled from: ConstraintLayout.kt */
public final class ConstraintLayoutKt {
    @InternalStreamChatApi
    public static final void updateConstraints(ConstraintLayout constraintLayout, Function1<? super ConstraintSet, Unit> function1) {
        Intrinsics.checkNotNullParameter(constraintLayout, "$this$updateConstraints");
        Intrinsics.checkNotNullParameter(function1, "actions");
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(constraintLayout);
        function1.invoke(constraintSet);
        constraintSet.applyTo(constraintLayout);
    }

    @InternalStreamChatApi
    public static final void constrainViewToParentBySide(ConstraintSet constraintSet, View view, int i) {
        Intrinsics.checkNotNullParameter(constraintSet, "$this$constrainViewToParentBySide");
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        constraintSet.connect(view.getId(), i, 0, i);
    }

    @InternalStreamChatApi
    public static final void constrainViewStartToEndOfView(ConstraintSet constraintSet, View view, View view2) {
        Intrinsics.checkNotNullParameter(constraintSet, "$this$constrainViewStartToEndOfView");
        Intrinsics.checkNotNullParameter(view, "startView");
        Intrinsics.checkNotNullParameter(view2, "endView");
        constraintSet.connect(view.getId(), 6, view2.getId(), 7);
    }

    @InternalStreamChatApi
    public static final void constrainViewEndToEndOfView(ConstraintSet constraintSet, View view, View view2) {
        Intrinsics.checkNotNullParameter(constraintSet, "$this$constrainViewEndToEndOfView");
        Intrinsics.checkNotNullParameter(view, "startView");
        Intrinsics.checkNotNullParameter(view2, "endView");
        constraintSet.connect(view.getId(), 7, view2.getId(), 7);
    }

    @InternalStreamChatApi
    public static final void horizontalChainInParent(ConstraintSet constraintSet, View... viewArr) {
        Intrinsics.checkNotNullParameter(constraintSet, "$this$horizontalChainInParent");
        Intrinsics.checkNotNullParameter(viewArr, "views");
        Collection arrayList = new ArrayList(viewArr.length);
        for (View id : viewArr) {
            arrayList.add(Integer.valueOf(id.getId()));
        }
        constraintSet.createHorizontalChain(0, 1, 0, 2, CollectionsKt.toIntArray((List) arrayList), (float[]) null, 0);
    }

    @InternalStreamChatApi
    public static final void verticalChainInParent(ConstraintSet constraintSet, View... viewArr) {
        Intrinsics.checkNotNullParameter(constraintSet, "$this$verticalChainInParent");
        Intrinsics.checkNotNullParameter(viewArr, "views");
        Collection arrayList = new ArrayList(viewArr.length);
        for (View id : viewArr) {
            arrayList.add(Integer.valueOf(id.getId()));
        }
        constraintSet.createVerticalChain(0, 3, 0, 4, CollectionsKt.toIntArray((List) arrayList), (float[]) null, 0);
    }
}
