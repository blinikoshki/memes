package com.memes.eventtracker.specialevents;

import com.appsflyer.AFInAppEventParameterName;
import com.appsflyer.AFInAppEventType;
import com.facebook.appevents.AppEventsConstants;
import com.memes.eventtracker.tracking.TrackableEvent;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\n\u001a\u00020\bH\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo26107d2 = {"Lcom/memes/eventtracker/specialevents/SubscriptionEvent;", "Lcom/memes/eventtracker/specialevents/SpecialEvent;", "orderId", "", "price", "currency", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "appsFlyerEvent", "Lcom/memes/eventtracker/tracking/TrackableEvent;", "facebookEvent", "firebaseEvent", "eventtracker_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: SubscriptionEvent.kt */
public final class SubscriptionEvent extends SpecialEvent {
    private final String currency;
    private final String orderId;
    private final String price;

    public SubscriptionEvent() {
        this((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SubscriptionEvent(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
    }

    public SubscriptionEvent(String str, String str2, String str3) {
        this.orderId = str;
        this.price = str2;
        this.currency = str3;
    }

    public TrackableEvent appsFlyerEvent() {
        Map mapOf = MapsKt.mapOf(TuplesKt.m181to(AFInAppEventParameterName.REVENUE, this.price), TuplesKt.m181to(AFInAppEventParameterName.CURRENCY, this.currency));
        Map linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : mapOf.entrySet()) {
            if (entry.getValue() != null) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return new TrackableEvent(AFInAppEventType.SUBSCRIBE, linkedHashMap);
    }

    public TrackableEvent facebookEvent() {
        Map mapOf = MapsKt.mapOf(TuplesKt.m181to(AppEventsConstants.EVENT_PARAM_ORDER_ID, this.orderId), TuplesKt.m181to(SpecialEvent.FB_EVENT_PARAM_PRICE, this.price), TuplesKt.m181to(AppEventsConstants.EVENT_PARAM_CURRENCY, this.currency));
        Map linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : mapOf.entrySet()) {
            if (entry.getValue() != null) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        return new TrackableEvent(AppEventsConstants.EVENT_NAME_SUBSCRIBE, linkedHashMap);
    }

    public TrackableEvent firebaseEvent() {
        return TrackableEvent.Companion.getEMPTY();
    }
}
