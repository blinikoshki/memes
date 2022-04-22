package editor.optionsui.text.textfont;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.Locale;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b \u0018\u00002\u00020\u0001B0\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\u0018\u0010\u0012\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\r\u001a\u00020\u000eH\u0016J \u0010\u0013\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u000eH\u0016J\u0010\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u000e\u0010\f\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R)\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\n0\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, mo26107d2 = {"Leditor/optionsui/text/textfont/TextFontsVisibilityScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "onFontCategoryChanged", "Lkotlin/Function1;", "Leditor/optionsui/text/textfont/TextFontCategory;", "Lkotlin/ParameterName;", "name", "category", "", "(Landroidx/recyclerview/widget/LinearLayoutManager;Lkotlin/jvm/functions/Function1;)V", "highlightedFontCategory", "scrollState", "", "lookupVisibleFont", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onScrollStateChanged", "onScrolled", "dx", "dy", "showSelectedFontCategory", "fontType", "", "editor_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: TextFontsVisibilityScrollListener.kt */
public abstract class TextFontsVisibilityScrollListener extends RecyclerView.OnScrollListener {
    private TextFontCategory highlightedFontCategory = TextFontCategory.RECENT;
    private final LinearLayoutManager layoutManager;
    private final Function1<TextFontCategory, Unit> onFontCategoryChanged;
    private int scrollState = -1;

    public TextFontsVisibilityScrollListener(LinearLayoutManager linearLayoutManager, Function1<? super TextFontCategory, Unit> function1) {
        Intrinsics.checkNotNullParameter(linearLayoutManager, "layoutManager");
        Intrinsics.checkNotNullParameter(function1, "onFontCategoryChanged");
        this.layoutManager = linearLayoutManager;
        this.onFontCategoryChanged = function1;
    }

    public void onScrolled(RecyclerView recyclerView, int i, int i2) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        if (this.scrollState != 2) {
            lookupVisibleFont(recyclerView);
        }
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        this.scrollState = i;
        if (i == 0) {
            lookupVisibleFont(recyclerView);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x007b A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void lookupVisibleFont(androidx.recyclerview.widget.RecyclerView r11) {
        /*
            r10 = this;
            androidx.recyclerview.widget.RecyclerView$Adapter r11 = r11.getAdapter()
            boolean r0 = r11 instanceof editor.optionsui.text.textfont.TextFontsAdapter
            if (r0 != 0) goto L_0x0009
            r11 = 0
        L_0x0009:
            editor.optionsui.text.textfont.TextFontsAdapter r11 = (editor.optionsui.text.textfont.TextFontsAdapter) r11
            if (r11 == 0) goto L_0x0137
            androidx.recyclerview.widget.LinearLayoutManager r0 = r10.layoutManager
            int r0 = r0.findFirstVisibleItemPosition()
            if (r0 <= 0) goto L_0x0029
            java.lang.Object r1 = r11.getItemAt(r0)
            editor.optionsui.text.textfont.FontItem r1 = (editor.optionsui.text.textfont.FontItem) r1
            boolean r2 = r1 instanceof editor.optionsui.text.textfont.FontItem.Divider
            if (r2 == 0) goto L_0x0029
            editor.optionsui.text.textfont.FontItem$Divider r1 = (editor.optionsui.text.textfont.FontItem.Divider) r1
            java.lang.String r11 = r1.getAfterFontType()
            r10.showSelectedFontCategory(r11)
            return
        L_0x0029:
            androidx.recyclerview.widget.LinearLayoutManager r1 = r10.layoutManager
            int r1 = r1.findLastVisibleItemPosition()
            if (r1 <= 0) goto L_0x0045
            java.lang.Object r2 = r11.getItemAt(r0)
            editor.optionsui.text.textfont.FontItem r2 = (editor.optionsui.text.textfont.FontItem) r2
            boolean r3 = r2 instanceof editor.optionsui.text.textfont.FontItem.Divider
            if (r3 == 0) goto L_0x0045
            editor.optionsui.text.textfont.FontItem$Divider r2 = (editor.optionsui.text.textfont.FontItem.Divider) r2
            java.lang.String r11 = r2.getBeforeFontType()
            r10.showSelectedFontCategory(r11)
            return
        L_0x0045:
            if (r0 < 0) goto L_0x0137
            if (r1 >= 0) goto L_0x004b
            goto L_0x0137
        L_0x004b:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            r4 = 2
            r5 = 0
            r6 = 1
            if (r0 > r1) goto L_0x00cb
        L_0x005a:
            java.lang.Object r7 = r11.getItemAt(r0)
            editor.optionsui.text.textfont.FontItem r7 = (editor.optionsui.text.textfont.FontItem) r7
            boolean r8 = r7 instanceof editor.optionsui.text.textfont.FontItem.Preview
            if (r8 == 0) goto L_0x00bb
            if (r0 < 0) goto L_0x0068
            if (r6 >= r0) goto L_0x0076
        L_0x0068:
            int r8 = r11.getItemCount()
            int r8 = r8 - r4
            int r9 = r11.getItemCount()
            if (r8 <= r0) goto L_0x0074
            goto L_0x0078
        L_0x0074:
            if (r9 < r0) goto L_0x0078
        L_0x0076:
            r8 = 1
            goto L_0x0079
        L_0x0078:
            r8 = 0
        L_0x0079:
            if (r8 == 0) goto L_0x008f
            r3.clear()
            r0 = r3
            java.util.Map r0 = (java.util.Map) r0
            editor.optionsui.text.textfont.FontItem$Preview r7 = (editor.optionsui.text.textfont.FontItem.Preview) r7
            java.lang.String r1 = r7.getFontType()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r6)
            r0.put(r1, r7)
            goto L_0x00cb
        L_0x008f:
            editor.optionsui.text.textfont.FontItem$Preview r7 = (editor.optionsui.text.textfont.FontItem.Preview) r7
            java.lang.String r8 = r7.getFontType()
            java.lang.Object r8 = r3.get(r8)
            java.lang.Integer r8 = (java.lang.Integer) r8
            if (r8 == 0) goto L_0x009e
            goto L_0x00a2
        L_0x009e:
            java.lang.Integer r8 = java.lang.Integer.valueOf(r5)
        L_0x00a2:
            java.lang.String r9 = "fontTypeCountMap[item.fontType] ?: 0"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r9)
            int r8 = r8.intValue()
            r9 = r3
            java.util.Map r9 = (java.util.Map) r9
            java.lang.String r7 = r7.getFontType()
            int r8 = r8 + r6
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r9.put(r7, r8)
            goto L_0x00c6
        L_0x00bb:
            boolean r7 = r7 instanceof editor.optionsui.text.textfont.FontItem.Divider
            if (r7 == 0) goto L_0x00c6
            java.lang.Integer r7 = java.lang.Integer.valueOf(r0)
            r2.add(r7)
        L_0x00c6:
            if (r0 == r1) goto L_0x00cb
            int r0 = r0 + 1
            goto L_0x005a
        L_0x00cb:
            int r0 = r2.size()
            if (r0 < r4) goto L_0x00f3
            java.lang.Object r0 = r2.get(r5)
            java.lang.String r1 = "dividerPositions[0]"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.Number r0 = (java.lang.Number) r0
            int r0 = r0.intValue()
            java.lang.Object r11 = r11.getItemAt(r0)
            java.lang.String r0 = "null cannot be cast to non-null type editor.optionsui.text.textfont.FontItem.Divider"
            java.util.Objects.requireNonNull(r11, r0)
            editor.optionsui.text.textfont.FontItem$Divider r11 = (editor.optionsui.text.textfont.FontItem.Divider) r11
            java.lang.String r11 = r11.getAfterFontType()
            r10.showSelectedFontCategory(r11)
            return
        L_0x00f3:
            java.util.Map r3 = (java.util.Map) r3
            java.util.Set r11 = r3.entrySet()
            java.util.Iterator r11 = r11.iterator()
            java.lang.String r0 = ""
        L_0x00ff:
            boolean r1 = r11.hasNext()
            if (r1 == 0) goto L_0x012a
            java.lang.Object r1 = r11.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getValue()
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            if (r2 <= r5) goto L_0x00ff
            java.lang.Object r0 = r1.getValue()
            java.lang.Number r0 = (java.lang.Number) r0
            int r0 = r0.intValue()
            java.lang.Object r1 = r1.getKey()
            java.lang.String r1 = (java.lang.String) r1
            r5 = r0
            r0 = r1
            goto L_0x00ff
        L_0x012a:
            r11 = r0
            java.lang.CharSequence r11 = (java.lang.CharSequence) r11
            boolean r11 = kotlin.text.StringsKt.isBlank(r11)
            r11 = r11 ^ r6
            if (r11 == 0) goto L_0x0137
            r10.showSelectedFontCategory(r0)
        L_0x0137:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: editor.optionsui.text.textfont.TextFontsVisibilityScrollListener.lookupVisibleFont(androidx.recyclerview.widget.RecyclerView):void");
    }

    private final void showSelectedFontCategory(String str) {
        Locale locale = Locale.ENGLISH;
        Intrinsics.checkNotNullExpressionValue(locale, "Locale.ENGLISH");
        Objects.requireNonNull(str, "null cannot be cast to non-null type java.lang.String");
        String upperCase = str.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "(this as java.lang.String).toUpperCase(locale)");
        if (!Intrinsics.areEqual((Object) this.highlightedFontCategory.name(), (Object) upperCase)) {
            TextFontCategory valueOf = TextFontCategory.valueOf(upperCase);
            this.highlightedFontCategory = valueOf;
            this.onFontCategoryChanged.invoke(valueOf);
        }
    }
}
