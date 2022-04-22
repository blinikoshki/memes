package com.memes.plus.data.mapped_response;

import com.facebook.share.internal.ShareConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B?\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00018\u0000\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\b\u0010(\u001a\u00020\u001bH\u0002J\u0006\u0010)\u001a\u00020\u001bJ\u0006\u0010*\u001a\u00020\u001bJ\u0006\u0010+\u001a\u00020\u001bJ\u0006\u0010,\u001a\u00020\u001bJ\u0006\u0010-\u001a\u00020\u001bJ\u0006\u0010.\u001a\u00020\u001bJ\u000b\u0010/\u001a\u00028\u0000¢\u0006\u0002\u0010\u0012J\f\u00100\u001a\b\u0012\u0004\u0012\u00028\u00000\tJ\u0006\u0010\u001e\u001a\u000201R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001e\u0010\u0007\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u00062"}, mo26107d2 = {"Lcom/memes/plus/data/mapped_response/UniversalResult;", "ITEM", "", "code", "", "message", "", "item", "items", "", "pagination", "Lcom/memes/plus/data/mapped_response/PaginationInfo;", "(ILjava/lang/String;Ljava/lang/Object;Ljava/util/List;Lcom/memes/plus/data/mapped_response/PaginationInfo;)V", "getCode", "()I", "setCode", "(I)V", "getItem", "()Ljava/lang/Object;", "setItem", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "manualError", "", "getManualError", "()Z", "setManualError", "(Z)V", "getMessage", "()Ljava/lang/String;", "setMessage", "(Ljava/lang/String;)V", "getPagination", "()Lcom/memes/plus/data/mapped_response/PaginationInfo;", "setPagination", "(Lcom/memes/plus/data/mapped_response/PaginationInfo;)V", "hasItem", "hasItems", "hasNoItem", "hasNoItems", "isError", "isSessionExpired", "isSuccess", "requireItem", "requireItems", "", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: UniversalResult.kt */
public final class UniversalResult<ITEM> {
    private int code;
    private ITEM item;
    private List<? extends ITEM> items;
    private boolean manualError;
    private String message;
    private PaginationInfo pagination;

    public UniversalResult(int i, String str, ITEM item2, List<? extends ITEM> list, PaginationInfo paginationInfo) {
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        this.code = i;
        this.message = str;
        this.item = item2;
        this.items = list;
        this.pagination = paginationInfo;
    }

    public final int getCode() {
        return this.code;
    }

    public final void setCode(int i) {
        this.code = i;
    }

    public final String getMessage() {
        return this.message;
    }

    public final void setMessage(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.message = str;
    }

    public final ITEM getItem() {
        return this.item;
    }

    public final void setItem(ITEM item2) {
        this.item = item2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UniversalResult(int i, String str, Object obj, List list, PaginationInfo paginationInfo, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, str, (i2 & 4) != 0 ? null : obj, (i2 & 8) != 0 ? null : list, (i2 & 16) != 0 ? null : paginationInfo);
    }

    public final List<ITEM> getItems() {
        return this.items;
    }

    public final void setItems(List<? extends ITEM> list) {
        this.items = list;
    }

    public final PaginationInfo getPagination() {
        return this.pagination;
    }

    public final void setPagination(PaginationInfo paginationInfo) {
        this.pagination = paginationInfo;
    }

    public final boolean getManualError() {
        return this.manualError;
    }

    public final void setManualError(boolean z) {
        this.manualError = z;
    }

    public final boolean isSuccess() {
        int i = this.code;
        return 200 <= i && 299 >= i;
    }

    public final boolean isError() {
        int i = this.code;
        return i < 200 || i >= 300 || this.manualError;
    }

    public final boolean isSessionExpired() {
        return this.code == 401;
    }

    public final void setManualError() {
        this.manualError = true;
    }

    private final boolean hasItem() {
        return this.item != null;
    }

    public final boolean hasNoItem() {
        return !hasItem();
    }

    public final boolean hasItems() {
        List<? extends ITEM> list = this.items;
        return list != null && !list.isEmpty();
    }

    public final boolean hasNoItems() {
        return !hasItems();
    }

    public final ITEM requireItem() {
        ITEM item2 = this.item;
        if (item2 != null) {
            return item2;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final List<ITEM> requireItems() {
        List<? extends ITEM> list = this.items;
        if (list != null) {
            return list;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }
}
