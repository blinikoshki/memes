package org.jetbrains.anko;

import android.view.View;
import android.view.ViewGroup;
import com.facebook.internal.NativeProtocol;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

@Metadata(mo26105bv = {1, 0, 1}, mo26106d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\u001a\u0010\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0002\u001a\u0010\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0002\u001a!\u0010\u0004\u001a\u00020\u0002*\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007H\b\u001a#\u0010\t\u001a\u0004\u0018\u00010\u0002*\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\b0\u0007H\b\u001a!\u0010\n\u001a\u00020\u000b*\u00020\u00052\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\u0007H\b\u001a'\u0010\r\u001a\u00020\u000b*\u00020\u00052\u0018\u0010\f\u001a\u0014\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b0\u000eH\b¨\u0006\u0010"}, mo26107d2 = {"childrenRecursiveSequence", "Lkotlin/sequences/Sequence;", "Landroid/view/View;", "childrenSequence", "firstChild", "Landroid/view/ViewGroup;", "predicate", "Lkotlin/Function1;", "", "firstChildOrNull", "forEachChild", "", "action", "forEachChildWithIndex", "Lkotlin/Function2;", "", "commons_release"}, mo26108k = 2, mo26109mv = {1, 1, 5})
/* compiled from: viewChildrenSequences.kt */
public final class ViewChildrenSequencesKt {
    public static final void forEachChild(ViewGroup viewGroup, Function1<? super View, Unit> function1) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, NativeProtocol.WEB_DIALOG_ACTION);
        int childCount = viewGroup.getChildCount() - 1;
        if (childCount >= 0) {
            int i = 0;
            while (true) {
                View childAt = viewGroup.getChildAt(i);
                Intrinsics.checkExpressionValueIsNotNull(childAt, "getChildAt(i)");
                function1.invoke(childAt);
                if (i != childCount) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public static final void forEachChildWithIndex(ViewGroup viewGroup, Function2<? super Integer, ? super View, Unit> function2) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "$receiver");
        Intrinsics.checkParameterIsNotNull(function2, NativeProtocol.WEB_DIALOG_ACTION);
        int childCount = viewGroup.getChildCount() - 1;
        if (childCount >= 0) {
            int i = 0;
            while (true) {
                Integer valueOf = Integer.valueOf(i);
                View childAt = viewGroup.getChildAt(i);
                Intrinsics.checkExpressionValueIsNotNull(childAt, "getChildAt(i)");
                function2.invoke(valueOf, childAt);
                if (i != childCount) {
                    i++;
                } else {
                    return;
                }
            }
        }
    }

    public static final View firstChild(ViewGroup viewGroup, Function1<? super View, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        int childCount = viewGroup.getChildCount() - 1;
        if (childCount >= 0) {
            int i = 0;
            while (true) {
                View childAt = viewGroup.getChildAt(i);
                Intrinsics.checkExpressionValueIsNotNull(childAt, "child");
                if (!function1.invoke(childAt).booleanValue()) {
                    if (i == childCount) {
                        break;
                    }
                    i++;
                } else {
                    Intrinsics.checkExpressionValueIsNotNull(childAt, "child");
                    return childAt;
                }
            }
        }
        throw new NoSuchElementException("No element matching predicate was found.");
    }

    public static final View firstChildOrNull(ViewGroup viewGroup, Function1<? super View, Boolean> function1) {
        Intrinsics.checkParameterIsNotNull(viewGroup, "$receiver");
        Intrinsics.checkParameterIsNotNull(function1, "predicate");
        int childCount = viewGroup.getChildCount() - 1;
        if (childCount < 0) {
            return null;
        }
        int i = 0;
        while (true) {
            View childAt = viewGroup.getChildAt(i);
            Intrinsics.checkExpressionValueIsNotNull(childAt, "child");
            if (function1.invoke(childAt).booleanValue()) {
                return childAt;
            }
            if (i == childCount) {
                return null;
            }
            i++;
        }
    }

    public static final Sequence<View> childrenSequence(View view) {
        Intrinsics.checkParameterIsNotNull(view, "$receiver");
        return new ViewChildrenSequence(view);
    }

    public static final Sequence<View> childrenRecursiveSequence(View view) {
        Intrinsics.checkParameterIsNotNull(view, "$receiver");
        return new ViewChildrenRecursiveSequence(view);
    }
}
