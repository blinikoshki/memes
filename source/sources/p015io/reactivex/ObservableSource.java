package p015io.reactivex;

/* renamed from: io.reactivex.ObservableSource */
public interface ObservableSource<T> {
    void subscribe(Observer<? super T> observer);
}
