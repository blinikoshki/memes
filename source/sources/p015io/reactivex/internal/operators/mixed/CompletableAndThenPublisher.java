package p015io.reactivex.internal.operators.mixed;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import p015io.reactivex.CompletableObserver;
import p015io.reactivex.CompletableSource;
import p015io.reactivex.Flowable;
import p015io.reactivex.FlowableSubscriber;
import p015io.reactivex.disposables.Disposable;
import p015io.reactivex.internal.disposables.DisposableHelper;
import p015io.reactivex.internal.subscriptions.SubscriptionHelper;

/* renamed from: io.reactivex.internal.operators.mixed.CompletableAndThenPublisher */
public final class CompletableAndThenPublisher<R> extends Flowable<R> {
    final Publisher<? extends R> other;
    final CompletableSource source;

    public CompletableAndThenPublisher(CompletableSource completableSource, Publisher<? extends R> publisher) {
        this.source = completableSource;
        this.other = publisher;
    }

    /* access modifiers changed from: protected */
    public void subscribeActual(Subscriber<? super R> subscriber) {
        this.source.subscribe(new AndThenPublisherSubscriber(subscriber, this.other));
    }

    /* renamed from: io.reactivex.internal.operators.mixed.CompletableAndThenPublisher$AndThenPublisherSubscriber */
    static final class AndThenPublisherSubscriber<R> extends AtomicReference<Subscription> implements FlowableSubscriber<R>, CompletableObserver, Subscription {
        private static final long serialVersionUID = -8948264376121066672L;
        final Subscriber<? super R> downstream;
        Publisher<? extends R> other;
        final AtomicLong requested = new AtomicLong();
        Disposable upstream;

        AndThenPublisherSubscriber(Subscriber<? super R> subscriber, Publisher<? extends R> publisher) {
            this.downstream = subscriber;
            this.other = publisher;
        }

        public void onNext(R r) {
            this.downstream.onNext(r);
        }

        public void onError(Throwable th) {
            this.downstream.onError(th);
        }

        public void onComplete() {
            Publisher<? extends R> publisher = this.other;
            if (publisher == null) {
                this.downstream.onComplete();
                return;
            }
            this.other = null;
            publisher.subscribe(this);
        }

        public void request(long j) {
            SubscriptionHelper.deferredRequest(this, this.requested, j);
        }

        public void cancel() {
            this.upstream.dispose();
            SubscriptionHelper.cancel(this);
        }

        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.upstream, disposable)) {
                this.upstream = disposable;
                this.downstream.onSubscribe(this);
            }
        }

        public void onSubscribe(Subscription subscription) {
            SubscriptionHelper.deferredSetOnce(this, this.requested, subscription);
        }
    }
}
