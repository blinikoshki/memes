package com.memes.eventtracker.specialevents;

import com.appsflyer.AFInAppEventParameterName;
import com.appsflyer.AFInAppEventType;
import com.facebook.appevents.AppEventsConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.memes.eventtracker.tracking.TrackableEvent;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001BU\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\b\u0010\u000f\u001a\u00020\rH\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo26107d2 = {"Lcom/memes/eventtracker/specialevents/PurchaseEvent;", "Lcom/memes/eventtracker/specialevents/SpecialEvent;", "revenue", "", "contentType", "contentId", "content", "price", "quantity", "currency", "orderId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "appsFlyerEvent", "Lcom/memes/eventtracker/tracking/TrackableEvent;", "facebookEvent", "firebaseEvent", "eventtracker_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: PurchaseEvent.kt */
public final class PurchaseEvent extends SpecialEvent {
    private final String content;
    private final String contentId;
    private final String contentType;
    private final String currency;
    private final String orderId;
    private final String price;
    private final String quantity;
    private final String revenue;

    public PurchaseEvent(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8) {
        this.revenue = str;
        this.contentType = str2;
        this.contentId = str3;
        this.content = str4;
        this.price = str5;
        this.quantity = str6;
        this.currency = str7;
        this.orderId = str8;
    }

    public TrackableEvent appsFlyerEvent() {
        Map mapOf = MapsKt.mapOf(TuplesKt.m181to(AFInAppEventParameterName.REVENUE, this.revenue), TuplesKt.m181to(AFInAppEventParameterName.CONTENT_TYPE, this.contentType), TuplesKt.m181to(AFInAppEventParameterName.CONTENT_ID, this.contentId), TuplesKt.m181to(AFInAppEventParameterName.CONTENT, this.content), TuplesKt.m181to(AFInAppEventParameterName.PRICE, this.price), TuplesKt.m181to(AFInAppEventParameterName.QUANTITY, this.quantity), TuplesKt.m181to(AFInAppEventParameterName.CURRENCY, this.currency), TuplesKt.m181to("af_order_id", this.orderId));
        Map linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : mapOf.entrySet()) {
            if (entry.getValue() != null) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return new TrackableEvent(AFInAppEventType.PURCHASE, linkedHashMap);
    }

    public TrackableEvent facebookEvent() {
        Map mapOf = MapsKt.mapOf(TuplesKt.m181to(AppEventsConstants.EVENT_PARAM_ORDER_ID, this.orderId), TuplesKt.m181to(SpecialEvent.FB_EVENT_PARAM_PRICE, this.price), TuplesKt.m181to(AppEventsConstants.EVENT_PARAM_CURRENCY, this.currency));
        Map linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : mapOf.entrySet()) {
            if (entry.getValue() != null) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return new TrackableEvent(SpecialEvent.FB_EVENT_PURCHASE, linkedHashMap);
    }

    public TrackableEvent firebaseEvent() {
        Pair[] pairArr = new Pair[8];
        pairArr[0] = TuplesKt.m181to(FirebaseAnalytics.Param.AFFILIATION, null);
        pairArr[1] = TuplesKt.m181to(FirebaseAnalytics.Param.COUPON, null);
        pairArr[2] = TuplesKt.m181to(FirebaseAnalytics.Param.CURRENCY, this.currency);
        String str = this.content;
        if (str == null) {
            str = this.contentId;
        }
        if (str == null) {
            str = this.contentType;
        }
        pairArr[3] = TuplesKt.m181to(FirebaseAnalytics.Param.ITEMS, str);
        pairArr[4] = TuplesKt.m181to(FirebaseAnalytics.Param.TRANSACTION_ID, this.orderId);
        pairArr[5] = TuplesKt.m181to(FirebaseAnalytics.Param.SHIPPING, null);
        pairArr[6] = TuplesKt.m181to(FirebaseAnalytics.Param.TAX, null);
        pairArr[7] = TuplesKt.m181to("value", this.price);
        Map mapOf = MapsKt.mapOf(pairArr);
        Map linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : mapOf.entrySet()) {
            if (entry.getValue() != null) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return new TrackableEvent(FirebaseAnalytics.Event.PURCHASE, linkedHashMap);
    }
}
