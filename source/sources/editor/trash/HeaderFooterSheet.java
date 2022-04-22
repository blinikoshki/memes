package editor.trash;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.memes.editor.C4175R;
import editor.common.sheetfooter.CancelDoneFooter;
import editor.common.sheetheader.TitleWithResetHeader;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0014\u001a\u00020\bJ\u0006\u0010\u0015\u001a\u00020\u0010J\b\u0010\u0016\u001a\u00020\u0017H\u0014J\u001f\u0010\u0018\u001a\u00020\u00172\u0017\u0010\u0019\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00170\u001a¢\u0006\u0002\b\u001bJ\u001f\u0010\u001c\u001a\u00020\u00172\u0017\u0010\u0019\u001a\u0013\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00170\u001a¢\u0006\u0002\b\u001bR\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u000f\u001a\u00020\u00108BX\u0002¢\u0006\f\n\u0004\b\u0013\u0010\f\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001d"}, mo26107d2 = {"Leditor/trash/HeaderFooterSheet;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "cancelDoneFooter", "Leditor/common/sheetfooter/CancelDoneFooter;", "getCancelDoneFooter", "()Leditor/common/sheetfooter/CancelDoneFooter;", "cancelDoneFooter$delegate", "Lkotlin/Lazy;", "title", "", "titleWithBackHeader", "Leditor/common/sheetheader/TitleWithResetHeader;", "getTitleWithBackHeader", "()Leditor/common/sheetheader/TitleWithResetHeader;", "titleWithBackHeader$delegate", "getFooter", "getHeader", "onFinishInflate", "", "updateFooter", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "updateHeader", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: HeaderFooterSheet.kt */
public class HeaderFooterSheet extends LinearLayout {
    private final Lazy cancelDoneFooter$delegate;
    /* access modifiers changed from: private */
    public String title = "Title";
    private final Lazy titleWithBackHeader$delegate;

    private final CancelDoneFooter getCancelDoneFooter() {
        return (CancelDoneFooter) this.cancelDoneFooter$delegate.getValue();
    }

    private final TitleWithResetHeader getTitleWithBackHeader() {
        return (TitleWithResetHeader) this.titleWithBackHeader$delegate.getValue();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HeaderFooterSheet(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        this.titleWithBackHeader$delegate = LazyKt.lazy(new HeaderFooterSheet$titleWithBackHeader$2(this, context));
        this.cancelDoneFooter$delegate = LazyKt.lazy(new HeaderFooterSheet$cancelDoneFooter$2(context));
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C4175R.styleable.HeaderFooterSheet, 0, 0);
            try {
                String string = obtainStyledAttributes.getString(C4175R.styleable.HeaderFooterSheet_hfs_title);
                if (string == null) {
                    string = this.title;
                }
                this.title = string;
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        setOrientation(1);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        addView(getTitleWithBackHeader(), 0);
        addView(getCancelDoneFooter(), getChildCount());
    }

    public final TitleWithResetHeader getHeader() {
        return getTitleWithBackHeader();
    }

    public final CancelDoneFooter getFooter() {
        return getCancelDoneFooter();
    }

    public final void updateHeader(Function1<? super TitleWithResetHeader, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        function1.invoke(getTitleWithBackHeader());
    }

    public final void updateFooter(Function1<? super CancelDoneFooter, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        function1.invoke(getCancelDoneFooter());
    }
}
