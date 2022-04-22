package p015io.getstream.chat.android.client.api.models;

import com.google.firebase.messaging.Constants;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.api.models.ChannelRequest;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u001b\u001a\u00020\u000eJ\u0006\u0010\u001c\u001a\u00020\u000eJ\u001c\u0010\u001d\u001a\u00020\u00002\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u001eH\u0016J\u0018\u0010\u001f\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!H\u0016J \u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u00052\u0006\u0010 \u001a\u00020!H\u0016J\u0010\u0010#\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!H\u0016J\u0018\u0010'\u001a\u00020\u00002\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!H\u0016R\u001d\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u001d\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0016\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001d\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\b¨\u0006("}, mo26107d2 = {"Lio/getstream/chat/android/client/api/models/QueryChannelRequest;", "Lio/getstream/chat/android/client/api/models/ChannelRequest;", "()V", "data", "", "", "", "getData", "()Ljava/util/Map;", "members", "getMembers", "messages", "getMessages", "presence", "", "getPresence", "()Z", "setPresence", "(Z)V", "state", "getState", "setState", "watch", "getWatch", "setWatch", "watchers", "getWatchers", "filteringOlderMessages", "isFilteringNewerMessages", "withData", "", "withMembers", "limit", "", "offset", "withMessages", "direction", "Lio/getstream/chat/android/client/api/models/Pagination;", "messageId", "withWatchers", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.api.models.QueryChannelRequest */
/* compiled from: QueryChannelRequest.kt */
public class QueryChannelRequest implements ChannelRequest<QueryChannelRequest> {
    private final Map<String, Object> data = new LinkedHashMap();
    private final Map<String, Object> members = new LinkedHashMap();
    private final Map<String, Object> messages = new LinkedHashMap();
    private boolean presence;
    private boolean state;
    private boolean watch;
    private final Map<String, Object> watchers = new LinkedHashMap();

    public QueryChannelRequest noPresence() {
        return (QueryChannelRequest) ChannelRequest.DefaultImpls.noPresence(this);
    }

    public QueryChannelRequest noState() {
        return (QueryChannelRequest) ChannelRequest.DefaultImpls.noState(this);
    }

    public QueryChannelRequest noWatch() {
        return (QueryChannelRequest) ChannelRequest.DefaultImpls.noWatch(this);
    }

    public QueryChannelRequest withPresence() {
        return (QueryChannelRequest) ChannelRequest.DefaultImpls.withPresence(this);
    }

    public QueryChannelRequest withState() {
        return (QueryChannelRequest) ChannelRequest.DefaultImpls.withState(this);
    }

    public QueryChannelRequest withWatch() {
        return (QueryChannelRequest) ChannelRequest.DefaultImpls.withWatch(this);
    }

    public boolean getState() {
        return this.state;
    }

    public void setState(boolean z) {
        this.state = z;
    }

    public boolean getWatch() {
        return this.watch;
    }

    public void setWatch(boolean z) {
        this.watch = z;
    }

    public boolean getPresence() {
        return this.presence;
    }

    public void setPresence(boolean z) {
        this.presence = z;
    }

    public final Map<String, Object> getMessages() {
        return this.messages;
    }

    public final Map<String, Object> getWatchers() {
        return this.watchers;
    }

    public final Map<String, Object> getMembers() {
        return this.members;
    }

    public final Map<String, Object> getData() {
        return this.data;
    }

    public QueryChannelRequest withData(Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(map, "data");
        this.data.putAll(map);
        return this;
    }

    public QueryChannelRequest withMembers(int i, int i2) {
        setState(true);
        Map hashMap = new HashMap();
        hashMap.put("limit", Integer.valueOf(i));
        hashMap.put("offset", Integer.valueOf(i2));
        this.members.putAll(hashMap);
        return this;
    }

    public QueryChannelRequest withWatchers(int i, int i2) {
        Map hashMap = new HashMap();
        hashMap.put("limit", Integer.valueOf(i));
        hashMap.put("offset", Integer.valueOf(i2));
        this.watchers.putAll(hashMap);
        return this;
    }

    public QueryChannelRequest withMessages(int i) {
        setState(true);
        Map hashMap = new HashMap();
        hashMap.put("limit", Integer.valueOf(i));
        this.messages.putAll(hashMap);
        return this;
    }

    public QueryChannelRequest withMessages(Pagination pagination, String str, int i) {
        Intrinsics.checkNotNullParameter(pagination, QuerySort.KEY_DIRECTION);
        Intrinsics.checkNotNullParameter(str, Constants.FirelogAnalytics.PARAM_MESSAGE_ID);
        setState(true);
        Map hashMap = new HashMap();
        hashMap.put("limit", Integer.valueOf(i));
        hashMap.put(pagination.toString(), str);
        this.messages.putAll(hashMap);
        return this;
    }

    public final boolean isFilteringNewerMessages() {
        if (this.messages.isEmpty()) {
            return false;
        }
        Set<String> keySet = this.messages.keySet();
        if (keySet.contains(Pagination.GREATER_THAN.toString()) || keySet.contains(Pagination.GREATER_THAN_OR_EQUAL.toString())) {
            return true;
        }
        return false;
    }

    public final boolean filteringOlderMessages() {
        if (this.messages.isEmpty()) {
            return false;
        }
        Set<String> keySet = this.messages.keySet();
        if (keySet.contains(Pagination.LESS_THAN.toString()) || keySet.contains(Pagination.LESS_THAN_OR_EQUAL.toString())) {
            return true;
        }
        return false;
    }
}
