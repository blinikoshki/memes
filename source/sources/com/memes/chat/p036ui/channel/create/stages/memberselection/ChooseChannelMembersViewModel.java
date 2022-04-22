package com.memes.chat.p036ui.channel.create.stages.memberselection;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelKt;
import com.memes.chat.p036ui.channel.create.stages.memberselection.ChannelMemberUpdate;
import com.memes.chat.p036ui.channel.create.stages.memberselection.ChosenChannelMembersAdapter;
import com.memes.chat.p036ui.channel.create.stages.memberselection.UserSearchResultsAdapter;
import com.memes.chat.util.usecases.CheckUserExistenceUseCase;
import com.memes.commons.contentlayout.ContentVisibilityAction;
import com.memes.commons.pagination.Paginator;
import com.memes.commons.recycleradapter.AdapterUpdate;
import com.memes.commons.util.SingleLiveEvent;
import com.memes.commons.viewmodel.BaseViewModel;
import com.memes.network.core.pagination.PageBasedPaginationInfo;
import com.memes.network.memes.api.MemesDataSource;
import com.memes.network.memes.source.remote.model.usersearch.UserSearchResult;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import p015io.getstream.chat.android.client.ChatClient;
import p015io.getstream.chat.android.client.models.User;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0014\u0010%\u001a\u00020&2\n\u0010'\u001a\u00060\u001bj\u0002`\u001cH\u0002J\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\r0)J\b\u0010*\u001a\u00020&H\u0002J\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000f0)J\b\u0010,\u001a\u00020&H\u0002J\b\u0010-\u001a\u00020&H\u0002J\u0014\u0010.\u001a\u00020&2\n\u0010/\u001a\u00060\u001bj\u0002`\u001cH\u0016J\u0010\u00100\u001a\u00020&2\u0006\u00101\u001a\u00020\u0013H\u0016J\u0006\u00102\u001a\u00020&J\u0014\u00103\u001a\u00020&2\n\u0010'\u001a\u00060\u001bj\u0002`\u001cH\u0002J\b\u00104\u001a\u00020&H\u0002J\u0010\u00105\u001a\u00020&2\b\u00106\u001a\u0004\u0018\u00010\"J\u0014\u00107\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00120)J\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u00170)R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\fX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0010\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u00120\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00170\u0011X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010\u0019\u001a\f\u0012\b\u0012\u00060\u001bj\u0002`\u001c0\u001aX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u00069"}, mo26107d2 = {"Lcom/memes/chat/ui/channel/create/stages/memberselection/ChooseChannelMembersViewModel;", "Lcom/memes/commons/viewmodel/BaseViewModel;", "Lcom/memes/chat/ui/channel/create/stages/memberselection/UserSearchResultsAdapter$OnUserSearchResultTappedListener;", "Lcom/memes/chat/ui/channel/create/stages/memberselection/ChosenChannelMembersAdapter$Callback;", "chatClient", "Lio/getstream/chat/android/client/ChatClient;", "memesDataSource", "Lcom/memes/network/memes/api/MemesDataSource;", "userSearchResultsPaginator", "Lcom/memes/commons/pagination/Paginator;", "(Lio/getstream/chat/android/client/ChatClient;Lcom/memes/network/memes/api/MemesDataSource;Lcom/memes/commons/pagination/Paginator;)V", "_channelMemberSelectionUpdated", "Landroidx/lifecycle/MutableLiveData;", "Lcom/memes/chat/ui/channel/create/stages/memberselection/ChannelMemberUpdate;", "_loadingNextSearchResults", "", "_userSearchResults", "Lcom/memes/commons/util/SingleLiveEvent;", "Lcom/memes/commons/recycleradapter/AdapterUpdate;", "Lcom/memes/network/memes/source/remote/model/usersearch/UserSearchResult;", "_userSearchResultsExceptionHandler", "Lkotlinx/coroutines/CoroutineExceptionHandler;", "_userSearchResultsState", "Lcom/memes/commons/contentlayout/ContentVisibilityAction;", "addChannelMemberExceptionHandler", "channelMembers", "", "Lio/getstream/chat/android/client/models/User;", "Lcom/memes/chat/ui/channel/create/stages/memberselection/ChannelMember;", "checkUserExistenceUseCase", "Lcom/memes/chat/util/usecases/CheckUserExistenceUseCase;", "searchUsersJob", "Lkotlinx/coroutines/Job;", "userSearchQueryInput", "", "userSearchResultsPagination", "Lcom/memes/network/core/pagination/PageBasedPaginationInfo;", "addChannelMember", "", "member", "channelMemberSelectionUpdated", "Landroidx/lifecycle/LiveData;", "loadNextSearchResults", "loadingNextSearchResults", "notifyPaginationLoadingStarted", "notifyPaginationLoadingStopped", "onChannelMemberRemoved", "channelMember", "onUserSearchResultTapped", "userSearchResult", "refreshSearchResults", "removeChannelMember", "resetPagination", "searchUsers", "query", "userSearchResults", "userSearchResultsState", "chat_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* renamed from: com.memes.chat.ui.channel.create.stages.memberselection.ChooseChannelMembersViewModel */
/* compiled from: ChooseChannelMembersViewModel.kt */
public final class ChooseChannelMembersViewModel extends BaseViewModel implements UserSearchResultsAdapter.OnUserSearchResultTappedListener, ChosenChannelMembersAdapter.Callback {
    private final MutableLiveData<ChannelMemberUpdate> _channelMemberSelectionUpdated;
    private final MutableLiveData<Boolean> _loadingNextSearchResults = new MutableLiveData<>();
    /* access modifiers changed from: private */
    public final SingleLiveEvent<AdapterUpdate<UserSearchResult>> _userSearchResults = new SingleLiveEvent<>();
    private final CoroutineExceptionHandler _userSearchResultsExceptionHandler = new C4091xf0295a65(CoroutineExceptionHandler.Key, this);
    /* access modifiers changed from: private */
    public final SingleLiveEvent<ContentVisibilityAction> _userSearchResultsState = new SingleLiveEvent<>();
    private final CoroutineExceptionHandler addChannelMemberExceptionHandler;
    /* access modifiers changed from: private */
    public final List<User> channelMembers = new ArrayList();
    /* access modifiers changed from: private */
    public final CheckUserExistenceUseCase checkUserExistenceUseCase;
    /* access modifiers changed from: private */
    public final MemesDataSource memesDataSource;
    private Job searchUsersJob;
    private String userSearchQueryInput;
    /* access modifiers changed from: private */
    public PageBasedPaginationInfo userSearchResultsPagination;
    private final Paginator userSearchResultsPaginator;

    public ChooseChannelMembersViewModel(ChatClient chatClient, MemesDataSource memesDataSource2, Paginator paginator) {
        Intrinsics.checkNotNullParameter(chatClient, "chatClient");
        Intrinsics.checkNotNullParameter(memesDataSource2, "memesDataSource");
        Intrinsics.checkNotNullParameter(paginator, "userSearchResultsPaginator");
        this.memesDataSource = memesDataSource2;
        this.userSearchResultsPaginator = paginator;
        this.checkUserExistenceUseCase = new CheckUserExistenceUseCase(chatClient);
        this._channelMemberSelectionUpdated = new MutableLiveData<>();
        this.addChannelMemberExceptionHandler = new C4092xf0295a66(CoroutineExceptionHandler.Key, this);
        paginator.setOnLoadMoreListener(new Paginator.OnLoadMoreListener(this) {
            final /* synthetic */ ChooseChannelMembersViewModel this$0;

            {
                this.this$0 = r1;
            }

            public final void onLoadMore() {
                this.this$0.loadNextSearchResults();
            }
        });
    }

    public final LiveData<AdapterUpdate<UserSearchResult>> userSearchResults() {
        return this._userSearchResults;
    }

    public final LiveData<ContentVisibilityAction> userSearchResultsState() {
        return this._userSearchResultsState;
    }

    public final LiveData<Boolean> loadingNextSearchResults() {
        return this._loadingNextSearchResults;
    }

    public final LiveData<ChannelMemberUpdate> channelMemberSelectionUpdated() {
        return this._channelMemberSelectionUpdated;
    }

    public final void searchUsers(String str) {
        if (!Intrinsics.areEqual((Object) str, (Object) this.userSearchQueryInput)) {
            resetPagination();
        }
        this.userSearchQueryInput = str;
        if (str == null) {
            resetPagination();
            this._userSearchResults.setValue(null);
            showContent(this._userSearchResultsState);
            return;
        }
        PageBasedPaginationInfo pageBasedPaginationInfo = this.userSearchResultsPagination;
        if (pageBasedPaginationInfo == null || pageBasedPaginationInfo.canFetchNextPage()) {
            if (this.userSearchResultsPagination != null) {
                notifyPaginationLoadingStarted();
            }
            Job job = this.searchUsersJob;
            if (job != null) {
                Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
            }
            this.searchUsersJob = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this._userSearchResultsExceptionHandler, (CoroutineStart) null, new ChooseChannelMembersViewModel$searchUsers$1(this, str, (Continuation) null), 2, (Object) null);
            return;
        }
        notifyPaginationLoadingStopped();
    }

    public final void refreshSearchResults() {
        resetPagination();
        searchUsers(this.userSearchQueryInput);
    }

    /* access modifiers changed from: private */
    public final void loadNextSearchResults() {
        searchUsers(this.userSearchQueryInput);
    }

    private final void notifyPaginationLoadingStarted() {
        this._loadingNextSearchResults.setValue(true);
    }

    /* access modifiers changed from: private */
    public final void notifyPaginationLoadingStopped() {
        this._loadingNextSearchResults.setValue(false);
    }

    private final void resetPagination() {
        this.userSearchResultsPaginator.resetState();
        this.userSearchResultsPagination = null;
        notifyPaginationLoadingStopped();
    }

    public void onUserSearchResultTapped(UserSearchResult userSearchResult) {
        Intrinsics.checkNotNullParameter(userSearchResult, "userSearchResult");
        String chatUserId = userSearchResult.chatUserId();
        CharSequence charSequence = chatUserId;
        boolean z = false;
        if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
            CharSequence userName = userSearchResult.getUserName();
            if (userName == null || StringsKt.isBlank(userName)) {
                z = true;
            }
            if (!z) {
                if (this.channelMembers.size() >= 99) {
                    toast("Only 100 members can be selected at a time.");
                } else {
                    Job unused = BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), this.addChannelMemberExceptionHandler, (CoroutineStart) null, new ChooseChannelMembersViewModel$onUserSearchResultTapped$1(this, userSearchResult, chatUserId, (Continuation) null), 2, (Object) null);
                }
            }
        }
    }

    public void onChannelMemberRemoved(User user) {
        Intrinsics.checkNotNullParameter(user, "channelMember");
        removeChannelMember(user);
    }

    /* access modifiers changed from: private */
    public final void addChannelMember(User user) {
        this.channelMembers.add(user);
        this._channelMemberSelectionUpdated.setValue(new ChannelMemberUpdate(new ChannelMemberUpdate.Type.Added(user), this.channelMembers));
    }

    /* access modifiers changed from: private */
    public final void removeChannelMember(User user) {
        this.channelMembers.remove(user);
        this._channelMemberSelectionUpdated.setValue(new ChannelMemberUpdate(new ChannelMemberUpdate.Type.Removed(user), this.channelMembers));
    }
}
