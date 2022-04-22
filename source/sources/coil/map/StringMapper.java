package coil.map;

import android.net.Uri;
import coil.map.Mapper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, mo26107d2 = {"Lcoil/map/StringMapper;", "Lcoil/map/Mapper;", "", "Landroid/net/Uri;", "()V", "map", "data", "coil-base_release"}, mo26108k = 1, mo26109mv = {1, 4, 1})
/* compiled from: StringMapper.kt */
public final class StringMapper implements Mapper<String, Uri> {
    public boolean handles(String str) {
        Intrinsics.checkNotNullParameter(str, "data");
        return Mapper.DefaultImpls.handles(this, str);
    }

    public Uri map(String str) {
        Intrinsics.checkNotNullParameter(str, "data");
        Uri parse = Uri.parse(str);
        Intrinsics.checkExpressionValueIsNotNull(parse, "Uri.parse(this)");
        return parse;
    }
}
