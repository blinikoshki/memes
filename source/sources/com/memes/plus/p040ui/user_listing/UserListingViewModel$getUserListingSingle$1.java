package com.memes.plus.p040ui.user_listing;

import com.memes.plus.data.mapped_response.UniversalResult;
import com.memes.plus.p040ui.suggestions.SuggestedProfile;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import p015io.reactivex.functions.Function;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0016\u0012\u0004\u0012\u00020\u0002 \u0003*\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00010\u00012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00050\u0001H\n¢\u0006\u0002\b\u0006"}, mo26107d2 = {"<anonymous>", "Lcom/memes/plus/data/mapped_response/UniversalResult;", "Lcom/memes/plus/ui/user_listing/ListedUser;", "kotlin.jvm.PlatformType", "result", "Lcom/memes/plus/ui/suggestions/SuggestedProfile;", "apply"}, mo26108k = 3, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.plus.ui.user_listing.UserListingViewModel$getUserListingSingle$1 */
/* compiled from: UserListingViewModel.kt */
final class UserListingViewModel$getUserListingSingle$1<T, R> implements Function<UniversalResult<SuggestedProfile>, UniversalResult<ListedUser>> {
    public static final UserListingViewModel$getUserListingSingle$1 INSTANCE = new UserListingViewModel$getUserListingSingle$1();

    UserListingViewModel$getUserListingSingle$1() {
    }

    public final UniversalResult<ListedUser> apply(UniversalResult<SuggestedProfile> universalResult) {
        List list;
        Intrinsics.checkNotNullParameter(universalResult, "result");
        int code = universalResult.getCode();
        String message = universalResult.getMessage();
        List<SuggestedProfile> items = universalResult.getItems();
        if (items != null) {
            Iterable<SuggestedProfile> iterable = items;
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
            for (SuggestedProfile listUser : iterable) {
                arrayList.add(listUser.toListUser());
            }
            list = (List) arrayList;
        } else {
            list = null;
        }
        return new UniversalResult(code, message, null, list, universalResult.getPagination());
    }
}
