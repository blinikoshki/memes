package p015io.getstream.chat.android.livedata.repository.domain.user;

import androidx.collection.LruCache;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import p015io.getstream.chat.android.client.models.ContentUtils;
import p015io.getstream.chat.android.client.models.Mute;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 ,2\u00020\u0001:\u0001,B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0016\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fH\u0002J\u0019\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J\u0019\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0012J\u001f\u0010\u0014\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00050\u000fH@ø\u0001\u0000¢\u0006\u0002\u0010\u0015J'\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\u00172\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0007H@ø\u0001\u0000¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u001cJ\u001b\u0010\u001d\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001e\u001a\u00020\u000bH@ø\u0001\u0000¢\u0006\u0002\u0010\u001fJ+\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00050!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0017H@ø\u0001\u0000¢\u0006\u0002\u0010#J%\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00050\u00172\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0017H@ø\u0001\u0000¢\u0006\u0002\u0010#J/\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00050\u00172\u0006\u0010&\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u0007H@ø\u0001\u0000¢\u0006\u0002\u0010'J\u0010\u0010(\u001a\u00020)2\u0006\u0010\u0011\u001a\u00020\u0005H\u0002J\u0010\u0010*\u001a\u00020\u00052\u0006\u0010+\u001a\u00020)H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00050\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006-"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/repository/domain/user/UserRepositoryImpl;", "Lio/getstream/chat/android/livedata/repository/domain/user/UserRepository;", "userDao", "Lio/getstream/chat/android/livedata/repository/domain/user/UserDao;", "currentUser", "Lio/getstream/chat/android/client/models/User;", "cacheSize", "", "(Lio/getstream/chat/android/livedata/repository/domain/user/UserDao;Lio/getstream/chat/android/client/models/User;I)V", "userCache", "Landroidx/collection/LruCache;", "", "cacheUsers", "", "users", "", "insertCurrentUser", "user", "(Lio/getstream/chat/android/client/models/User;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertUser", "insertUsers", "(Ljava/util/Collection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectAllUsers", "", "limit", "offset", "(IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectCurrentUser", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectUser", "userId", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectUserMap", "", "userIds", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "selectUsers", "selectUsersLikeName", "searchString", "(Ljava/lang/String;IILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toEntity", "Lio/getstream/chat/android/livedata/repository/domain/user/UserEntity;", "toModel", "userEntity", "Companion", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: io.getstream.chat.android.livedata.repository.domain.user.UserRepositoryImpl */
/* compiled from: UserRepository.kt */
public final class UserRepositoryImpl implements UserRepository {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String ME_ID = "me";
    private final User currentUser;
    private final LruCache<String, User> userCache;
    private final UserDao userDao;

    public UserRepositoryImpl(UserDao userDao2, User user, int i) {
        Intrinsics.checkNotNullParameter(userDao2, "userDao");
        Intrinsics.checkNotNullParameter(user, "currentUser");
        this.userDao = userDao2;
        this.currentUser = user;
        this.userCache = new LruCache<>(i);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ UserRepositoryImpl(UserDao userDao2, User user, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(userDao2, user, (i2 & 4) != 0 ? 100 : i);
    }

    public Object insertUsers(Collection<User> collection, Continuation<? super Unit> continuation) {
        if (collection.isEmpty()) {
            return Unit.INSTANCE;
        }
        cacheUsers(collection);
        UserDao userDao2 = this.userDao;
        Iterable<User> iterable = collection;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (User entity : iterable) {
            arrayList.add(toEntity(entity));
        }
        Object insertMany = userDao2.insertMany((List) arrayList, continuation);
        if (insertMany == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return insertMany;
        }
        return Unit.INSTANCE;
    }

    private final void cacheUsers(Collection<User> collection) {
        for (User next : collection) {
            this.userCache.put(next.getId(), next);
        }
    }

    public Object insertUser(User user, Continuation<? super Unit> continuation) {
        Object insert = this.userDao.insert(toEntity(user), continuation);
        if (insert == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return insert;
        }
        return Unit.INSTANCE;
    }

    public Object insertCurrentUser(User user, Continuation<? super Unit> continuation) {
        Object insert = this.userDao.insert(UserEntity.copy$default(toEntity(user), ME_ID, (String) null, (String) null, (String) null, (Date) null, (Date) null, (Date) null, false, false, (List) null, (Map) null, 2046, (Object) null), continuation);
        if (insert == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return insert;
        }
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004d  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0054 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object selectCurrentUser(kotlin.coroutines.Continuation<? super p015io.getstream.chat.android.client.models.User> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof p015io.getstream.chat.android.livedata.repository.domain.user.UserRepositoryImpl$selectCurrentUser$1
            if (r0 == 0) goto L_0x0014
            r0 = r5
            io.getstream.chat.android.livedata.repository.domain.user.UserRepositoryImpl$selectCurrentUser$1 r0 = (p015io.getstream.chat.android.livedata.repository.domain.user.UserRepositoryImpl$selectCurrentUser$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L_0x0019
        L_0x0014:
            io.getstream.chat.android.livedata.repository.domain.user.UserRepositoryImpl$selectCurrentUser$1 r0 = new io.getstream.chat.android.livedata.repository.domain.user.UserRepositoryImpl$selectCurrentUser$1
            r0.<init>(r4, r5)
        L_0x0019:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r0 = r0.L$0
            io.getstream.chat.android.livedata.repository.domain.user.UserRepositoryImpl r0 = (p015io.getstream.chat.android.livedata.repository.domain.user.UserRepositoryImpl) r0
            kotlin.ResultKt.throwOnFailure(r5)
            goto L_0x0049
        L_0x002e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r5)
            io.getstream.chat.android.livedata.repository.domain.user.UserDao r5 = r4.userDao
            r0.L$0 = r4
            r0.label = r3
            java.lang.String r2 = "me"
            java.lang.Object r5 = r5.select((java.lang.String) r2, (kotlin.coroutines.Continuation<? super p015io.getstream.chat.android.livedata.repository.domain.user.UserEntity>) r0)
            if (r5 != r1) goto L_0x0048
            return r1
        L_0x0048:
            r0 = r4
        L_0x0049:
            io.getstream.chat.android.livedata.repository.domain.user.UserEntity r5 = (p015io.getstream.chat.android.livedata.repository.domain.user.UserEntity) r5
            if (r5 == 0) goto L_0x0054
            io.getstream.chat.android.livedata.repository.domain.user.UserRepositoryImpl r0 = (p015io.getstream.chat.android.livedata.repository.domain.user.UserRepositoryImpl) r0
            io.getstream.chat.android.client.models.User r5 = r0.toModel(r5)
            goto L_0x0055
        L_0x0054:
            r5 = 0
        L_0x0055:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.repository.domain.user.UserRepositoryImpl.selectCurrentUser(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0069 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object selectUser(java.lang.String r5, kotlin.coroutines.Continuation<? super p015io.getstream.chat.android.client.models.User> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof p015io.getstream.chat.android.livedata.repository.domain.user.UserRepositoryImpl$selectUser$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            io.getstream.chat.android.livedata.repository.domain.user.UserRepositoryImpl$selectUser$1 r0 = (p015io.getstream.chat.android.livedata.repository.domain.user.UserRepositoryImpl$selectUser$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            io.getstream.chat.android.livedata.repository.domain.user.UserRepositoryImpl$selectUser$1 r0 = new io.getstream.chat.android.livedata.repository.domain.user.UserRepositoryImpl$selectUser$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r5 = r0.L$0
            io.getstream.chat.android.livedata.repository.domain.user.UserRepositoryImpl r5 = (p015io.getstream.chat.android.livedata.repository.domain.user.UserRepositoryImpl) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0052
        L_0x002e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r6)
            androidx.collection.LruCache<java.lang.String, io.getstream.chat.android.client.models.User> r6 = r4.userCache
            java.lang.Object r6 = r6.get(r5)
            io.getstream.chat.android.client.models.User r6 = (p015io.getstream.chat.android.client.models.User) r6
            if (r6 == 0) goto L_0x0044
            goto L_0x006a
        L_0x0044:
            io.getstream.chat.android.livedata.repository.domain.user.UserDao r6 = r4.userDao
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r6 = r6.select((java.lang.String) r5, (kotlin.coroutines.Continuation<? super p015io.getstream.chat.android.livedata.repository.domain.user.UserEntity>) r0)
            if (r6 != r1) goto L_0x0051
            return r1
        L_0x0051:
            r5 = r4
        L_0x0052:
            io.getstream.chat.android.livedata.repository.domain.user.UserEntity r6 = (p015io.getstream.chat.android.livedata.repository.domain.user.UserEntity) r6
            if (r6 == 0) goto L_0x0069
            r0 = r5
            io.getstream.chat.android.livedata.repository.domain.user.UserRepositoryImpl r0 = (p015io.getstream.chat.android.livedata.repository.domain.user.UserRepositoryImpl) r0
            io.getstream.chat.android.client.models.User r6 = r0.toModel(r6)
            if (r6 == 0) goto L_0x0069
            java.util.List r0 = kotlin.collections.CollectionsKt.listOf(r6)
            java.util.Collection r0 = (java.util.Collection) r0
            r5.cacheUsers(r0)
            goto L_0x006a
        L_0x0069:
            r6 = 0
        L_0x006a:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.repository.domain.user.UserRepositoryImpl.selectUser(java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: java.util.List} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v11, resolved type: java.util.List} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00d1 A[LOOP:2: B:35:0x00cb->B:37:0x00d1, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object selectUsers(java.util.List<java.lang.String> r9, kotlin.coroutines.Continuation<? super java.util.List<p015io.getstream.chat.android.client.models.User>> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof p015io.getstream.chat.android.livedata.repository.domain.user.UserRepositoryImpl$selectUsers$1
            if (r0 == 0) goto L_0x0014
            r0 = r10
            io.getstream.chat.android.livedata.repository.domain.user.UserRepositoryImpl$selectUsers$1 r0 = (p015io.getstream.chat.android.livedata.repository.domain.user.UserRepositoryImpl$selectUsers$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r10 = r0.label
            int r10 = r10 - r2
            r0.label = r10
            goto L_0x0019
        L_0x0014:
            io.getstream.chat.android.livedata.repository.domain.user.UserRepositoryImpl$selectUsers$1 r0 = new io.getstream.chat.android.livedata.repository.domain.user.UserRepositoryImpl$selectUsers$1
            r0.<init>(r8, r10)
        L_0x0019:
            java.lang.Object r10 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003b
            if (r2 != r3) goto L_0x0033
            java.lang.Object r9 = r0.L$1
            java.util.List r9 = (java.util.List) r9
            java.lang.Object r0 = r0.L$0
            io.getstream.chat.android.livedata.repository.domain.user.UserRepositoryImpl r0 = (p015io.getstream.chat.android.livedata.repository.domain.user.UserRepositoryImpl) r0
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x00b8
        L_0x0033:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x003b:
            kotlin.ResultKt.throwOnFailure(r10)
            java.lang.Iterable r9 = (java.lang.Iterable) r9
            androidx.collection.LruCache<java.lang.String, io.getstream.chat.android.client.models.User> r10 = r8.userCache
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Iterator r4 = r9.iterator()
        L_0x004d:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x0065
            java.lang.Object r5 = r4.next()
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r5 = r10.get(r5)
            io.getstream.chat.android.client.models.User r5 = (p015io.getstream.chat.android.client.models.User) r5
            if (r5 == 0) goto L_0x004d
            r2.add(r5)
            goto L_0x004d
        L_0x0065:
            r10 = r2
            java.util.List r10 = (java.util.List) r10
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Collection r2 = (java.util.Collection) r2
            java.util.Iterator r9 = r9.iterator()
        L_0x0073:
            boolean r4 = r9.hasNext()
            if (r4 == 0) goto L_0x0099
            java.lang.Object r4 = r9.next()
            r5 = r4
            java.lang.String r5 = (java.lang.String) r5
            androidx.collection.LruCache<java.lang.String, io.getstream.chat.android.client.models.User> r6 = r8.userCache
            java.lang.Object r5 = r6.get(r5)
            if (r5 != 0) goto L_0x008a
            r5 = 1
            goto L_0x008b
        L_0x008a:
            r5 = 0
        L_0x008b:
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L_0x0073
            r2.add(r4)
            goto L_0x0073
        L_0x0099:
            java.util.List r2 = (java.util.List) r2
            r9 = r2
            java.util.Collection r9 = (java.util.Collection) r9
            boolean r9 = r9.isEmpty()
            r9 = r9 ^ r3
            if (r9 == 0) goto L_0x00ee
            io.getstream.chat.android.livedata.repository.domain.user.UserDao r9 = r8.userDao
            r0.L$0 = r8
            r0.L$1 = r10
            r0.label = r3
            java.lang.Object r9 = r9.select((java.util.List<java.lang.String>) r2, (kotlin.coroutines.Continuation<? super java.util.List<p015io.getstream.chat.android.livedata.repository.domain.user.UserEntity>>) r0)
            if (r9 != r1) goto L_0x00b4
            return r1
        L_0x00b4:
            r0 = r8
            r7 = r10
            r10 = r9
            r9 = r7
        L_0x00b8:
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.ArrayList r1 = new java.util.ArrayList
            r2 = 10
            int r2 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r10, r2)
            r1.<init>(r2)
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r10 = r10.iterator()
        L_0x00cb:
            boolean r2 = r10.hasNext()
            if (r2 == 0) goto L_0x00e2
            java.lang.Object r2 = r10.next()
            io.getstream.chat.android.livedata.repository.domain.user.UserEntity r2 = (p015io.getstream.chat.android.livedata.repository.domain.user.UserEntity) r2
            r3 = r0
            io.getstream.chat.android.livedata.repository.domain.user.UserRepositoryImpl r3 = (p015io.getstream.chat.android.livedata.repository.domain.user.UserRepositoryImpl) r3
            io.getstream.chat.android.client.models.User r2 = r3.toModel(r2)
            r1.add(r2)
            goto L_0x00cb
        L_0x00e2:
            java.util.List r1 = (java.util.List) r1
            r10 = r1
            java.util.Collection r10 = (java.util.Collection) r10
            io.getstream.chat.android.livedata.repository.domain.user.UserRepositoryImpl r0 = (p015io.getstream.chat.android.livedata.repository.domain.user.UserRepositoryImpl) r0
            r0.cacheUsers(r10)
            r10 = r9
            goto L_0x00f2
        L_0x00ee:
            java.util.List r1 = kotlin.collections.CollectionsKt.emptyList()
        L_0x00f2:
            java.util.Collection r1 = (java.util.Collection) r1
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.List r9 = kotlin.collections.CollectionsKt.plus(r1, r10)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.repository.domain.user.UserRepositoryImpl.selectUsers(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0068 A[LOOP:0: B:17:0x0062->B:19:0x0068, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object selectUserMap(java.util.List<java.lang.String> r5, kotlin.coroutines.Continuation<? super java.util.Map<java.lang.String, p015io.getstream.chat.android.client.models.User>> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof p015io.getstream.chat.android.livedata.repository.domain.user.UserRepositoryImpl$selectUserMap$1
            if (r0 == 0) goto L_0x0014
            r0 = r6
            io.getstream.chat.android.livedata.repository.domain.user.UserRepositoryImpl$selectUserMap$1 r0 = (p015io.getstream.chat.android.livedata.repository.domain.user.UserRepositoryImpl$selectUserMap$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L_0x0014
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L_0x0019
        L_0x0014:
            io.getstream.chat.android.livedata.repository.domain.user.UserRepositoryImpl$selectUserMap$1 r0 = new io.getstream.chat.android.livedata.repository.domain.user.UserRepositoryImpl$selectUserMap$1
            r0.<init>(r4, r6)
        L_0x0019:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r3) goto L_0x002e
            java.lang.Object r5 = r0.L$0
            io.getstream.chat.android.livedata.repository.domain.user.UserRepositoryImpl r5 = (p015io.getstream.chat.android.livedata.repository.domain.user.UserRepositoryImpl) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0045
        L_0x002e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0036:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r6 = r4.selectUsers(r5, r0)
            if (r6 != r1) goto L_0x0044
            return r1
        L_0x0044:
            r5 = r4
        L_0x0045:
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            r0 = 10
            int r0 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r6, r0)
            int r0 = kotlin.collections.MapsKt.mapCapacity(r0)
            r1 = 16
            int r0 = kotlin.ranges.RangesKt.coerceAtLeast((int) r0, (int) r1)
            java.util.LinkedHashMap r1 = new java.util.LinkedHashMap
            r1.<init>(r0)
            java.util.Map r1 = (java.util.Map) r1
            java.util.Iterator r6 = r6.iterator()
        L_0x0062:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L_0x0077
            java.lang.Object r0 = r6.next()
            r2 = r0
            io.getstream.chat.android.client.models.User r2 = (p015io.getstream.chat.android.client.models.User) r2
            java.lang.String r2 = r2.getId()
            r1.put(r2, r0)
            goto L_0x0062
        L_0x0077:
            io.getstream.chat.android.client.models.User r6 = r5.currentUser
            java.lang.String r6 = r6.getId()
            io.getstream.chat.android.client.models.User r5 = r5.currentUser
            kotlin.Pair r5 = kotlin.TuplesKt.m181to(r6, r5)
            java.util.Map r5 = kotlin.collections.MapsKt.plus(r1, r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: p015io.getstream.chat.android.livedata.repository.domain.user.UserRepositoryImpl.selectUserMap(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public Object selectAllUsers(int i, int i2, Continuation<? super List<User>> continuation) {
        Iterable<UserEntity> selectAllUser = this.userDao.selectAllUser(i, i2);
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(selectAllUser, 10));
        for (UserEntity model : selectAllUser) {
            arrayList.add(toModel(model));
        }
        return (List) arrayList;
    }

    public Object selectUsersLikeName(String str, int i, int i2, Continuation<? super List<User>> continuation) {
        UserDao userDao2 = this.userDao;
        Iterable<UserEntity> selectUsersLikeName = userDao2.selectUsersLikeName(str + '%', i, i2);
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(selectUsersLikeName, 10));
        for (UserEntity model : selectUsersLikeName) {
            arrayList.add(toModel(model));
        }
        return (List) arrayList;
    }

    private final UserEntity toEntity(User user) {
        String id = user.getId();
        String name = ContentUtils.getName(user);
        String id2 = user.getId();
        String role = user.getRole();
        Date createdAt = user.getCreatedAt();
        Date updatedAt = user.getUpdatedAt();
        Date lastActive = user.getLastActive();
        boolean invisible = user.getInvisible();
        boolean banned = user.getBanned();
        Map<String, Object> extraData = user.getExtraData();
        Iterable<Mute> mutes = user.getMutes();
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(mutes, 10));
        for (Mute target : mutes) {
            arrayList.add(target.getTarget().getId());
        }
        return new UserEntity(id, id2, name, role, createdAt, updatedAt, lastActive, invisible, banned, (List) arrayList, extraData);
    }

    private final User toModel(UserEntity userEntity) {
        User user = r0;
        User user2 = new User(userEntity.getOriginalId(), (String) null, false, false, (List) null, false, (Date) null, (Date) null, (Date) null, 0, 0, 0, (List) null, (List) null, (List) null, (Map) null, 65534, (DefaultConstructorMarker) null);
        User user3 = user;
        user3.setRole(userEntity.getRole());
        user3.setCreatedAt(userEntity.getCreatedAt());
        user3.setUpdatedAt(userEntity.getUpdatedAt());
        user3.setLastActive(userEntity.getLastActive());
        user3.setInvisible(userEntity.getInvisible());
        user3.setExtraData(MapsKt.toMutableMap(userEntity.getExtraData()));
        user3.setBanned(userEntity.getBanned());
        return user3;
    }

    @Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo26107d2 = {"Lio/getstream/chat/android/livedata/repository/domain/user/UserRepositoryImpl$Companion;", "", "()V", "ME_ID", "", "stream-chat-android-offline_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
    /* renamed from: io.getstream.chat.android.livedata.repository.domain.user.UserRepositoryImpl$Companion */
    /* compiled from: UserRepository.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }
}
