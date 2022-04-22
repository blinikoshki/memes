package com.giphy.sdk.tracking;

import com.giphy.sdk.analytics.models.enums.EventType;
import com.giphy.sdk.core.models.BottleData;
import com.giphy.sdk.core.models.Media;
import com.giphy.sdk.core.models.Meta;
import com.giphy.sdk.core.models.Pagination;
import com.giphy.sdk.core.network.api.CompletionHandler;
import com.giphy.sdk.core.network.response.ListMediaResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, mo26107d2 = {"com/giphy/sdk/tracking/CompletionHandlerExtensionKt$completionHandlerWithUserDictionary$2", "Lcom/giphy/sdk/core/network/api/CompletionHandler;", "Lcom/giphy/sdk/core/network/response/ListMediaResponse;", "onComplete", "", "result", "e", "", "giphy-sdk_release"}, mo26108k = 1, mo26109mv = {1, 1, 13})
/* renamed from: com.giphy.sdk.tracking.CompletionHandlerExtensionKt$completionHandlerWithUserDictionary$2 */
/* compiled from: CompletionHandlerExtension.kt */
public final class C1799x3a509539 implements CompletionHandler<ListMediaResponse> {
    final /* synthetic */ EventType $eventType;
    final /* synthetic */ boolean $isEmoji;
    final /* synthetic */ boolean $isText;
    final /* synthetic */ C1798x3a509538 $superComplete$1;

    C1799x3a509539(EventType eventType, boolean z, boolean z2, C1798x3a509538 completionHandlerExtensionKt$completionHandlerWithUserDictionary$1) {
        this.$eventType = eventType;
        this.$isEmoji = z;
        this.$isText = z2;
        this.$superComplete$1 = completionHandlerExtensionKt$completionHandlerWithUserDictionary$1;
    }

    public void onComplete(ListMediaResponse listMediaResponse, Throwable th) {
        List<Media> data;
        Integer offset;
        if (!((listMediaResponse != null ? listMediaResponse.getData() : null) == null || listMediaResponse.getMeta() == null)) {
            List<Media> data2 = listMediaResponse.getData();
            if (data2 == null) {
                Intrinsics.throwNpe();
            }
            int i = 0;
            for (Object next : data2) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Media media = (Media) next;
                Meta meta = listMediaResponse.getMeta();
                if (meta == null) {
                    Intrinsics.throwNpe();
                }
                MediaExtensionKt.setResponseId(media, meta.getResponseId());
                MediaExtensionKt.setEventType(media, this.$eventType);
                if (this.$isEmoji) {
                    MediaExtensionKt.setEmoji(media, true);
                }
                if (this.$isText) {
                    MediaExtensionKt.setText(media, true);
                }
                Pagination pagination = listMediaResponse.getPagination();
                MediaExtensionKt.setPosition(media, Integer.valueOf(i + ((pagination == null || (offset = pagination.getOffset()) == null) ? 0 : offset.intValue())));
                i = i2;
            }
        }
        if (!(listMediaResponse == null || (data = listMediaResponse.getData()) == null)) {
            Collection arrayList = new ArrayList();
            for (Object next2 : data) {
                BottleData bottleData = ((Media) next2).getBottleData();
                CharSequence tid = bottleData != null ? bottleData.getTid() : null;
                if (!(tid == null || tid.length() == 0)) {
                    arrayList.add(next2);
                }
            }
            for (Media createAdSession : (List) arrayList) {
                MediaExtensionKt.createAdSession(createAdSession);
            }
        }
        this.$superComplete$1.invoke(listMediaResponse, th);
    }
}
