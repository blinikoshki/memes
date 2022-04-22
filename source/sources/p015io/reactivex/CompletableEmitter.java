package p015io.reactivex;

import p015io.reactivex.disposables.Disposable;
import p015io.reactivex.functions.Cancellable;

/* renamed from: io.reactivex.CompletableEmitter */
public interface CompletableEmitter {
    boolean isDisposed();

    void onComplete();

    void onError(Throwable th);

    void setCancellable(Cancellable cancellable);

    void setDisposable(Disposable disposable);

    boolean tryOnError(Throwable th);
}
