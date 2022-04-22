package com.memes.plus.base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewbinding.ViewBinding;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.NativeProtocol;
import com.memes.commons.contentlayout.ContentLayout;
import com.memes.commons.util.ActivityStarter;
import com.memes.plus.base.upgrades.BindingAware;
import com.memes.plus.data.storage.InstantStorage;
import com.memes.plus.p040ui.auth.auth_prompt.AuthPromptActivity;
import com.memes.plus.util.RepositoryInjection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

@Metadata(mo26105bv = {1, 0, 3}, mo26106d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u00042\u00020\u0005B\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u001f\u0010\u0017\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH&¢\u0006\u0002\u0010\u001cJ\u000b\u0010\u001d\u001a\u00028\u0000¢\u0006\u0002\u0010\u001eJ\b\u0010\u001f\u001a\u00020\u0010H\u0016J\u0010\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\"H\u0016J\u0012\u0010#\u001a\u00020\u00162\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\u0018\u0010&\u001a\u00020\u00162\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020(H\u0017J&\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J\b\u0010,\u001a\u00020\u0016H\u0016J\b\u0010-\u001a\u00020\u0016H\u0016J\u001a\u0010.\u001a\u00020\u00162\u0006\u0010/\u001a\u00020+2\b\u0010$\u001a\u0004\u0018\u00010%H\u0016J/\u00100\u001a\u00020\u00162!\u00101\u001a\u001d\u0012\u0013\u0012\u001103¢\u0006\f\b4\u0012\b\b5\u0012\u0004\b\b(6\u0012\u0004\u0012\u00020\u001602H\bø\u0001\u0000J/\u00107\u001a\u00020\u00162!\u00101\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b4\u0012\b\b5\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u001602H\bø\u0001\u0000J/\u00108\u001a\u00020\u00162!\u00101\u001a\u001d\u0012\u0013\u0012\u00110\"¢\u0006\f\b4\u0012\b\b5\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u001602H\bø\u0001\u0000J\b\u00109\u001a\u00020\u0016H\u0002R\u001a\u0010\u0007\u001a\u00020\bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0012\u0010\r\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0004\n\u0002\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014\u0002\u0007\n\u0005\b20\u0001¨\u0006:"}, mo26107d2 = {"Lcom/memes/plus/base/BaseFragment;", "BINDING", "Landroidx/viewbinding/ViewBinding;", "Lcom/memes/plus/base/EventAwareFragment;", "Lcom/memes/plus/base/upgrades/BindingAware;", "Lcom/memes/commons/contentlayout/ContentLayout$Callback;", "()V", "activityHandle", "Lcom/memes/plus/base/ActivityHandle;", "getActivityHandle", "()Lcom/memes/plus/base/ActivityHandle;", "setActivityHandle", "(Lcom/memes/plus/base/ActivityHandle;)V", "binding", "Landroidx/viewbinding/ViewBinding;", "shouldDestroyBinding", "", "getShouldDestroyBinding", "()Z", "setShouldDestroyBinding", "(Z)V", "afterViewCreated", "", "createBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;)Landroidx/viewbinding/ViewBinding;", "getBinding", "()Landroidx/viewbinding/ViewBinding;", "hasBinding", "onAttach", "context", "Landroid/content/Context;", "onBindingComplete", "savedInstanceState", "Landroid/os/Bundle;", "onContentLayoutErrorResolutionButtonTapped", "who", "", "why", "onCreateView", "Landroid/view/View;", "onDestroy", "onObserversRequested", "onViewCreated", "view", "safeActivity", "action", "Lkotlin/Function1;", "Landroidx/fragment/app/FragmentActivity;", "Lkotlin/ParameterName;", "name", "activity", "safeBinding", "safeContext", "showAuthPrompt", "app_release"}, mo26108k = 1, mo26109mv = {1, 4, 2})
/* compiled from: BaseFragment.kt */
public abstract class BaseFragment<BINDING extends ViewBinding> extends EventAwareFragment implements BindingAware<BINDING>, ContentLayout.Callback {
    public ActivityHandle activityHandle;
    private BINDING binding;
    private boolean shouldDestroyBinding;

    public void afterViewCreated() {
    }

    public abstract BINDING createBinding(LayoutInflater layoutInflater, ViewGroup viewGroup);

    public void onBindingComplete(Bundle bundle) {
    }

    public void onObserversRequested() {
    }

    public final ActivityHandle getActivityHandle() {
        ActivityHandle activityHandle2 = this.activityHandle;
        if (activityHandle2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("activityHandle");
        }
        return activityHandle2;
    }

    public final void setActivityHandle(ActivityHandle activityHandle2) {
        Intrinsics.checkNotNullParameter(activityHandle2, "<set-?>");
        this.activityHandle = activityHandle2;
    }

    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (context instanceof ActivityHandle) {
            this.activityHandle = (ActivityHandle) context;
            super.onAttach(context);
            return;
        }
        throw new RuntimeException("This fragment's activity doesn't have an Activity Handle");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        ViewGroup viewGroup2 = null;
        if (hasBinding()) {
            View root = getBinding().getRoot();
            Intrinsics.checkNotNullExpressionValue(root, "getBinding().root");
            Timber.m300d("onCreateView: Already has binding; root-parent=" + root.getParent(), new Object[0]);
            ViewParent parent = root.getParent();
            if (parent instanceof ViewGroup) {
                viewGroup2 = parent;
            }
            ViewGroup viewGroup3 = viewGroup2;
            if (viewGroup3 != null) {
                viewGroup3.removeView(root);
                Timber.m300d("onCreateView: Already had binding; removed-parent; root-parent=" + root.getParent(), new Object[0]);
            }
            return root;
        }
        this.binding = createBinding(layoutInflater, viewGroup);
        onBindingComplete(bundle);
        BINDING binding2 = this.binding;
        if (binding2 != null) {
            return binding2.getRoot();
        }
        return null;
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        onObserversRequested();
        afterViewCreated();
    }

    private final void showAuthPrompt() {
        Context context = getContext();
        if (context != null) {
            InstantStorage instantStorage = InstantStorage.INSTANCE;
            RepositoryInjection repositoryInjection = RepositoryInjection.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(context, "context");
            instantStorage.clearSession(repositoryInjection.storageRepository(context));
            ActivityStarter.Companion.mo57312of(AuthPromptActivity.Companion.getStartIntent(context)).startFrom((Fragment) this);
        }
    }

    public final void safeContext(Function1<? super Context, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, NativeProtocol.WEB_DIALOG_ACTION);
        Context context = getContext();
        if (context != null) {
            function1.invoke(context);
        } else {
            Timber.m303e("safeContext() prevented a null-context call.", new Object[0]);
        }
    }

    public final void safeActivity(Function1<? super FragmentActivity, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, NativeProtocol.WEB_DIALOG_ACTION);
        FragmentActivity activity = getActivity();
        if (activity != null) {
            function1.invoke(activity);
        } else {
            Timber.m303e("safeActivity() prevented a null-activity call.", new Object[0]);
        }
    }

    public final void safeBinding(Function1<? super BINDING, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, NativeProtocol.WEB_DIALOG_ACTION);
        if (hasBinding()) {
            function1.invoke(getBinding());
        } else {
            Timber.m303e("safeBinding() prevented a null-binding call.", new Object[0]);
        }
    }

    public boolean getShouldDestroyBinding() {
        return this.shouldDestroyBinding;
    }

    public void setShouldDestroyBinding(boolean z) {
        this.shouldDestroyBinding = z;
    }

    public boolean hasBinding() {
        return this.binding != null;
    }

    public final BINDING getBinding() {
        BINDING binding2 = this.binding;
        if (binding2 != null) {
            return binding2;
        }
        throw new NullPointerException("Binding is null.");
    }

    public void onContentLayoutErrorResolutionButtonTapped(int i, int i2) {
        if (i2 == 1212) {
            showAuthPrompt();
        }
    }

    public void onDestroy() {
        if (getShouldDestroyBinding()) {
            this.binding = (ViewBinding) null;
        }
        super.onDestroy();
    }
}
