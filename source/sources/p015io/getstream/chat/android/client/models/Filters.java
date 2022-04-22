package p015io.getstream.chat.android.client.models;

import com.facebook.share.internal.ShareConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.api.models.QuerySort;
import p015io.getstream.chat.android.client.utils.FilterObject;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u000b\n\u0002\u0010\u0004\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J!\u0010\u0011\u001a\u00020\u00122\u0012\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u0014\"\u00020\u0012H\u0007¢\u0006\u0002\u0010\u0015J\u0018\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0004H\u0007J\u0010\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0001H\u0007J!\u0010\u0019\u001a\u00020\u00122\u0012\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u0014\"\u00020\u0012H\u0007¢\u0006\u0002\u0010\u0015J\u0018\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0001H\u0007J\u0010\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0001H\u0007J\u0018\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0001H\u0007J\u0018\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0001H\u0007J)\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00042\u0012\u0010\u001f\u001a\n\u0012\u0006\b\u0001\u0012\u00020 0\u0014\"\u00020 H\u0007¢\u0006\u0002\u0010!J)\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00042\u0012\u0010\u001f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0014\"\u00020\u0004H\u0007¢\u0006\u0002\u0010\"J\u001c\u0010\u001e\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00042\n\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030#H\u0007J\u0018\u0010$\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0001H\u0007J\u0018\u0010%\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0001H\u0007J\u0018\u0010&\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0001H\u0007J)\u0010'\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00042\u0012\u0010\u001f\u001a\n\u0012\u0006\b\u0001\u0012\u00020 0\u0014\"\u00020 H\u0007¢\u0006\u0002\u0010!J)\u0010'\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00042\u0012\u0010\u001f\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0014\"\u00020\u0004H\u0007¢\u0006\u0002\u0010\"J\u001c\u0010'\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00042\n\u0010\u001f\u001a\u0006\u0012\u0002\b\u00030#H\u0007J!\u0010(\u001a\u00020\u00122\u0012\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u0014\"\u00020\u0012H\u0007¢\u0006\u0002\u0010\u0015J!\u0010)\u001a\u00020\u00122\u0012\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00120\u0014\"\u00020\u0012H\u0007¢\u0006\u0002\u0010\u0015R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006*"}, mo26107d2 = {"Lio/getstream/chat/android/client/models/Filters;", "", "()V", "KEY_AND", "", "KEY_AUTOCOMPLETE", "KEY_CONTAINS", "KEY_EXIST", "KEY_GREATER_THAN", "KEY_GREATER_THAN_OR_EQUALS", "KEY_IN", "KEY_LESS_THAN", "KEY_LESS_THAN_OR_EQUALS", "KEY_NE", "KEY_NOR", "KEY_NOT_IN", "KEY_OR", "and", "Lio/getstream/chat/android/client/utils/FilterObject;", "filters", "", "([Lio/getstream/chat/android/client/utils/FilterObject;)Lio/getstream/chat/android/client/utils/FilterObject;", "autocomplete", "field", "value", "contains", "eq", "exists", "greaterThan", "greaterThanEquals", "in", "values", "", "(Ljava/lang/String;[Ljava/lang/Number;)Lio/getstream/chat/android/client/utils/FilterObject;", "(Ljava/lang/String;[Ljava/lang/String;)Lio/getstream/chat/android/client/utils/FilterObject;", "", "lessThan", "lessThanEquals", "ne", "nin", "nor", "or", "stream-chat-android-client_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.client.models.Filters */
/* compiled from: Filters.kt */
public final class Filters {
    public static final Filters INSTANCE = new Filters();
    public static final String KEY_AND = "$and";
    public static final String KEY_AUTOCOMPLETE = "$autocomplete";
    public static final String KEY_CONTAINS = "$contains";
    public static final String KEY_EXIST = "$exists";
    public static final String KEY_GREATER_THAN = "$gt";
    public static final String KEY_GREATER_THAN_OR_EQUALS = "$gte";
    public static final String KEY_IN = "$in";
    public static final String KEY_LESS_THAN = "$lt";
    public static final String KEY_LESS_THAN_OR_EQUALS = "$lte";
    public static final String KEY_NE = "$ne";
    public static final String KEY_NOR = "$nor";
    public static final String KEY_NOT_IN = "$nin";
    public static final String KEY_OR = "$or";

    private Filters() {
    }

    @JvmStatic
    public static final FilterObject exists(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "value");
        return new FilterObject(KEY_EXIST, obj);
    }

    @JvmStatic
    public static final FilterObject contains(Object obj) {
        Intrinsics.checkNotNullParameter(obj, "value");
        return new FilterObject(KEY_CONTAINS, obj);
    }

    @JvmStatic
    public static final FilterObject contains(FilterObject... filterObjectArr) {
        Intrinsics.checkNotNullParameter(filterObjectArr, ShareConstants.WEB_DIALOG_PARAM_FILTERS);
        return new FilterObject(KEY_CONTAINS, filterObjectArr);
    }

    @JvmStatic
    public static final FilterObject and(FilterObject... filterObjectArr) {
        Intrinsics.checkNotNullParameter(filterObjectArr, ShareConstants.WEB_DIALOG_PARAM_FILTERS);
        return new FilterObject(KEY_AND, filterObjectArr);
    }

    @JvmStatic
    /* renamed from: or */
    public static final FilterObject m1012or(FilterObject... filterObjectArr) {
        Intrinsics.checkNotNullParameter(filterObjectArr, ShareConstants.WEB_DIALOG_PARAM_FILTERS);
        return new FilterObject(KEY_OR, filterObjectArr);
    }

    @JvmStatic
    public static final FilterObject nor(FilterObject... filterObjectArr) {
        Intrinsics.checkNotNullParameter(filterObjectArr, ShareConstants.WEB_DIALOG_PARAM_FILTERS);
        return new FilterObject(KEY_NOR, filterObjectArr);
    }

    @JvmStatic
    /* renamed from: eq */
    public static final FilterObject m1007eq(String str, Object obj) {
        Intrinsics.checkNotNullParameter(str, QuerySort.KEY_FIELD_NAME);
        Intrinsics.checkNotNullParameter(obj, "value");
        return new FilterObject(str, obj);
    }

    @JvmStatic
    /* renamed from: ne */
    public static final FilterObject m1011ne(String str, Object obj) {
        Intrinsics.checkNotNullParameter(str, QuerySort.KEY_FIELD_NAME);
        Intrinsics.checkNotNullParameter(obj, "value");
        return new FilterObject(str, new FilterObject(KEY_NE, obj));
    }

    @JvmStatic
    public static final FilterObject greaterThan(String str, Object obj) {
        Intrinsics.checkNotNullParameter(str, QuerySort.KEY_FIELD_NAME);
        Intrinsics.checkNotNullParameter(obj, "value");
        return new FilterObject(str, new FilterObject(KEY_GREATER_THAN, obj));
    }

    @JvmStatic
    public static final FilterObject greaterThanEquals(String str, Object obj) {
        Intrinsics.checkNotNullParameter(str, QuerySort.KEY_FIELD_NAME);
        Intrinsics.checkNotNullParameter(obj, "value");
        return new FilterObject(str, new FilterObject(KEY_GREATER_THAN_OR_EQUALS, obj));
    }

    @JvmStatic
    public static final FilterObject lessThan(String str, Object obj) {
        Intrinsics.checkNotNullParameter(str, QuerySort.KEY_FIELD_NAME);
        Intrinsics.checkNotNullParameter(obj, "value");
        return new FilterObject(str, new FilterObject(KEY_LESS_THAN, obj));
    }

    @JvmStatic
    public static final FilterObject lessThanEquals(String str, Object obj) {
        Intrinsics.checkNotNullParameter(str, QuerySort.KEY_FIELD_NAME);
        Intrinsics.checkNotNullParameter(obj, "value");
        return new FilterObject(str, new FilterObject(KEY_LESS_THAN_OR_EQUALS, obj));
    }

    @JvmStatic
    /* renamed from: in */
    public static final FilterObject m1010in(String str, String... strArr) {
        Intrinsics.checkNotNullParameter(str, QuerySort.KEY_FIELD_NAME);
        Intrinsics.checkNotNullParameter(strArr, "values");
        return new FilterObject(str, new FilterObject(KEY_IN, strArr));
    }

    @JvmStatic
    /* renamed from: in */
    public static final FilterObject m1008in(String str, List<?> list) {
        Intrinsics.checkNotNullParameter(str, QuerySort.KEY_FIELD_NAME);
        Intrinsics.checkNotNullParameter(list, "values");
        return new FilterObject(str, new FilterObject(KEY_IN, list));
    }

    @JvmStatic
    /* renamed from: in */
    public static final FilterObject m1009in(String str, Number... numberArr) {
        Intrinsics.checkNotNullParameter(str, QuerySort.KEY_FIELD_NAME);
        Intrinsics.checkNotNullParameter(numberArr, "values");
        return new FilterObject(str, new FilterObject(KEY_IN, numberArr));
    }

    @JvmStatic
    public static final FilterObject nin(String str, String... strArr) {
        Intrinsics.checkNotNullParameter(str, QuerySort.KEY_FIELD_NAME);
        Intrinsics.checkNotNullParameter(strArr, "values");
        return new FilterObject(str, new FilterObject(KEY_NOT_IN, strArr));
    }

    @JvmStatic
    public static final FilterObject nin(String str, List<?> list) {
        Intrinsics.checkNotNullParameter(str, QuerySort.KEY_FIELD_NAME);
        Intrinsics.checkNotNullParameter(list, "values");
        return new FilterObject(str, new FilterObject(KEY_NOT_IN, list));
    }

    @JvmStatic
    public static final FilterObject nin(String str, Number... numberArr) {
        Intrinsics.checkNotNullParameter(str, QuerySort.KEY_FIELD_NAME);
        Intrinsics.checkNotNullParameter(numberArr, "values");
        return new FilterObject(str, new FilterObject(KEY_NOT_IN, numberArr));
    }

    @JvmStatic
    public static final FilterObject autocomplete(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, QuerySort.KEY_FIELD_NAME);
        Intrinsics.checkNotNullParameter(str2, "value");
        return new FilterObject(str, new FilterObject(KEY_AUTOCOMPLETE, str2));
    }
}
