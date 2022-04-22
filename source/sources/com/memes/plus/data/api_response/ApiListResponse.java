package com.memes.plus.data.api_response;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u0004\u0018\u00010\t8\u0006XD¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000b¨\u0006\r"}, mo26107d2 = {"Lcom/memes/plus/data/api_response/ApiListResponse;", "T", "Lcom/memes/plus/data/api_response/ApiMessageResponse;", "()V", "data", "", "getData", "()Ljava/util/List;", "totalPages", "", "getTotalPages", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: ApiListResponse.kt */
public class ApiListResponse<T> extends ApiMessageResponse {
    @SerializedName("data")
    @Expose
    private final List<T> data;
    @SerializedName("totalPages")
    @Expose
    private final Integer totalPages = 0;

    public final List<T> getData() {
        return this.data;
    }

    public final Integer getTotalPages() {
        return this.totalPages;
    }
}
