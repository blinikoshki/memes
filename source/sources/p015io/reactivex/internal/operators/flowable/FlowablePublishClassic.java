package p015io.reactivex.internal.operators.flowable;

import org.reactivestreams.Publisher;

/* renamed from: io.reactivex.internal.operators.flowable.FlowablePublishClassic */
public interface FlowablePublishClassic<T> {
    int publishBufferSize();

    Publisher<T> publishSource();
}
