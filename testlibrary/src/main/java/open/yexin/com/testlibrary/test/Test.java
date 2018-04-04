package open.yexin.com.testlibrary.test;


import android.util.Log;

import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

import io.reactivex.BackpressureStrategy;
import io.reactivex.Flowable;
import io.reactivex.FlowableEmitter;
import io.reactivex.FlowableOnSubscribe;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Cancellable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by yexin on 2018/3/29.
 */

public class Test<T> {


    private T[] test;

    public <T> void create(T test1) {

        Observable<T> observable = Observable.create(new ObservableOnSubscribe<T>() {
            @Override
            public void subscribe(ObservableEmitter<T> emitter) throws Exception {
                emitter.onNext(test1);
                emitter.onComplete();
            }
        });


        Flowable<T> flowable = new Flowable<T>() {
            @Override
            protected void subscribeActual(Subscriber<? super T> s) {

            }
        };

        Observer<T> observer = new Observer<T>() {
            private Disposable mDisposable;

            @Override
            public void onSubscribe(Disposable d) {
                mDisposable = d;

            }

            @Override
            public void onNext(T t) {
                mDisposable.dispose();
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };


        observable.subscribe(observer);


        Observable.create(new ObservableOnSubscribe<T>() {
            @Override
            public void subscribe(ObservableEmitter<T> e) throws Exception {
            }
        }).subscribe(new Consumer<T>() {
            @Override
            public void accept(T t) throws Exception {

            }
        });

        Flowable.create(new FlowableOnSubscribe<T>() {
            @Override
            public void subscribe(FlowableEmitter<T> e) throws Exception {

            }
        }, BackpressureStrategy.LATEST).subscribe(new Subscriber<T>() {
            @Override
            public void onSubscribe(Subscription s) {
                s.request(100);
            }

            @Override
            public void onNext(T t) {

            }

            @Override
            public void onError(Throwable t) {

            }

            @Override
            public void onComplete() {

            }
        })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<T, String>() {
                    @Override
                    public String apply(T t) throws Exception {
                        if (t == null) {
                            return "null";
                        }
                        return "not null";
                    }
                }).flatMap(new Function<String, Publisher<Login>>() {
                    @Override
                    public Publisher<Login> apply(String s) throws Exception {
                        final List<Login> list = new ArrayList<>();
                        for (int i = 0; i < 3; i++) {
                            Login  log= new Login("yexin",s);
                            list.add(log);
                        }

                        return Flowable.fromIterable(list).delay(1, TimeUnit.SECONDS);
                    }
                }).concatMap(new Function<Login, Publisher<Login>>() {
                    @Override
                    public Publisher<Login> apply(Login login) throws Exception {
                        final List<Login> list = new ArrayList<>();
                        for (int i = 0; i < 3; i++) {
                            Login  log= new Login("yexin",login.getPassword());
                            list.add(log);
                        }

                        return Flowable.fromIterable(list).delay(1, TimeUnit.SECONDS);
                    }
                })
                .subscribe(new Consumer<Login>() {
                    @Override
                    public void accept(Login t) throws Exception {

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });

        Observable.just(1).observeOn(Schedulers.io()).subscribeOn(Schedulers.newThread()).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {

            }
        }, new Consumer<Throwable>() {
            @Override
            public void accept(Throwable throwable) throws Exception {

            }
        });

        RxJavaPlugins.setOnObservableSubscribe(new BiFunction<Observable, Observer, Observer>() {
            int s;

            {
                s = 22;
            }
            @Override
            public Observer apply(Observable observable, Observer observer) throws Exception {
                int li = s;
                return null;
            }
        });

    }

    class YxSubscriber extends Flowable<T> {

        @Override
        protected void subscribeActual(Subscriber<? super T> s) {

        }
    }

    static final class CreatetESTEmitter<T>
            extends AtomicReference<Disposable>
            implements ObservableEmitter<T>, Disposable {

        CreatetESTEmitter(){
            Log.i(this.getClass().getName(),""+get());
        }

        @Override
        public void setDisposable(Disposable d) {

        }

        @Override
        public void setCancellable(Cancellable c) {

        }

        @Override
        public void dispose() {

        }

        @Override
        public boolean isDisposed() {
            return false;
        }

        @Override
        public ObservableEmitter<T> serialize() {
            return null;
        }

        @Override
        public boolean tryOnError(Throwable t) {
            return false;
        }

        @Override
        public void onNext(T value) {

        }

        @Override
        public void onError(Throwable error) {

        }

        @Override
        public void onComplete() {

        }
    }

}
