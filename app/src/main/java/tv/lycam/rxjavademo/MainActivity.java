package tv.lycam.rxjavademo;

import android.os.Bundle;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {

    private String[] mNames;
    private StringBuilder mBuffer;
    private Button mbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mNames = getResources().getStringArray(R.array.ChannelNames);
        String[] urls = getResources().getStringArray(R.array.ChannelUrls);
        mBuffer = new StringBuilder();
        for (int i = 0; i < urls.length; i++) {
            String name = mNames[i];
            String url = urls[i];
            mBuffer.append('\n');
            mBuffer.append(name).append("\t").append(url);
        }

        EditText edit = (EditText) findViewById(R.id.edit);
        TextView text = (TextView) findViewById(R.id.text);
        mbtn = (Button) findViewById(R.id.btn);
//        RxTextView.textChanges(edit)
//                .debounce(500, TimeUnit.MILLISECONDS)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .filter(charSequence -> {
//                    return !TextUtils.isEmpty(charSequence.toString());
//                })
//                .observeOn(Schedulers.io())
//                .flatMap(charSequence -> {
//                    return Observable.just(charSequence.toString());
//                })
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(result -> {
//                    text.setText(result);
//                });

//        Observable.create(e -> {
//        })
//
//                .doOnTerminate(() -> {
//                    Log.d("MainActivity", "OnTerminate");
//                })
//                .subscribe(o -> {
//                    Log.d("MainActivity", "onNext");
//                }, throwable -> {
//                    Log.d("MainActivity", "onError");
//                }, () -> {
//                    Log.d("MainActivity", "onComplete");
//                });

//        Observable.interval(1, TimeUnit.SECONDS)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(times -> {
//                    Log.d("MainActivity", "times:" + times);
//                });
    }

    abstract class MyObserver implements Observer<Object> {
        @Override
        public void onSubscribe(@NonNull Disposable d) {

        }

        @Override
        public void onError(@NonNull Throwable e) {
            onComplete();
        }

        @Override
        public void onComplete() {

        }

        void handleError() {

        }
    }


    boolean isRecording = false;

    public void click(View v) {
//        getObservable()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(getObserver());
//        System.out.println(mBuffer.toString());

//        Observable<String> observable = Observable.just(1).map(String::valueOf);


//        Observable
//                .interval(1, TimeUnit.SECONDS)
//                .take(15)
//                .map(number -> {
//                    Log.d("MainActivity", "number:" + (number + 1));
//                    return number;
//                })
//                .filter(number -> (number + 1) % 5 == 0)
//                .filter(number -> !isRecording)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(number -> {
//                    Log.d("MainActivity", "number now:" + number);
//                    if (number == 9) {
//                        isRecording = true;
//                    }
//                });


//        Observable.just(getUserParam())
//                .flatMap(userParam -> {
//                    BaseResult result = new BaseResult();
//                    result.name = userParam.name;
//                    Log.d("MainActivity", "userParam.isMainThread():" + isMainThread());
//                    return Observable.just(result);
//                })
//                .flatMap(baseResult -> {
//                    Log.d("MainActivity", "baseResult.isMainThread():" + isMainThread());
//                    return Observable.just(new User(baseResult.name));
//                })
//                .subscribeOn(AndroidSchedulers.mainThread())
//                .observeOn(Schedulers.io())
//                .subscribe(user -> {
//                    Log.d("MainActivity", "user.isMainThread():" + isMainThread());
//                    Log.d("MainActivity", "user:" + user);
//                });

        List<User> list = new ArrayList<>();
        list.add(new User("ming"));
        list.add(new User("silly"));
        List<User> list2 = new ArrayList<>();
        list2.add(new User("ming1"));
        list2.add(new User("silly2"));
        Observable.just(list, list2)
                .distinct(users -> {
                    List<User> result = new ArrayList<User>();
                    for (User user : users) {
                        if (!result.contains(user)) {
                            result.add(user);
                        }
                    }
                    return result;
                })
                .subscribe(users -> {
                    for (User user : users) {
                        Log.d("MainActivity", "user:" + user);
                    }
                });

//        int count = 10;
//        Observable.interval(0, 1, TimeUnit.SECONDS)
//                .take(count + 1)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .doOnSubscribe(disposable -> {
//                    mbtn.setEnabled(false);
//                })
//                .map(time -> count - time)
//                .subscribe(new Observer<Long>() {
//                    @Override
//                    public void onSubscribe(@NonNull Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(@NonNull Long num) {
//                        Log.d("MainActivity", "time:" + num);
//                        mbtn.setText(String.valueOf(num));
//                    }
//
//                    @Override
//                    public void onError(@NonNull Throwable e) {
//
//                    }
//
//                    @Override
//                    public void onComplete() {
//                        mbtn.setEnabled(true);
//                        mbtn.setText("Hello, World");
//                    }
//                });

//        Observable<String> memory = Observable.create(e -> {
//            e.onNext(System.currentTimeMillis() % 2 == 0 ? "memory" : "");
//            e.onComplete();
//        });
//        Observable<String> file = Observable.create(e -> {
//            e.onNext(System.currentTimeMillis() % 3 == 0 ? "file" : "");
//            e.onComplete();
//        });
//        Observable<String> network = Observable.create(e -> {
//            e.onNext(System.currentTimeMillis() % 7 == 0 ? "network" : "");
//            e.onComplete();
//        });
//
//        Observable.concat(memory, file, network)
//                .filter(result -> !TextUtils.isEmpty(result))
//                .firstElement()
//                .subscribe(result -> {
//                    Log.d("MainActivity", "choose pic from " + result);
//                });
    }

    public boolean isMainThread() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    private UserParam getUserParam() {
        return new UserParam("Nick");
    }

    public Observable<List<User>> getObservable() {
//        return Observable.create(e -> {
//            e.onNext("Hello");
//            e.onNext("World");
//            e.onComplete();
//        });
//        return Observable.just("大家好", "我", "是", "Hello World!");
//        return Observable.fromCallable(() -> "Hello World");
//        return Observable.create(e -> {
//            OkHttpClient client = new OkHttpClient.Builder().build();
//            client.newCall(new Request.Builder().url("https://www.baidu.com").get().build()).execute().body();
//            User user = new User();
//            e.onNext(user);
//        });
//        return Observable.fromArray("大家好", "我", "是", "Hello World!");
        List<User> list = new ArrayList<>();
        list.add(new User("ming"));
        list.add(new User("silly"));

        return Observable.just(list);
    }

    public Observable<List<User>> getObservable2() {
        List<User> list = new ArrayList<>();
        list.add(new User("ming"));
        list.add(new User("ming2"));
        list.add(new User("silly2"));

        return Observable.just(list);
    }

    public Observer<String> getObserver() {
        return new Observer<String>() {
            Disposable mDisposable;

            @Override
            public void onSubscribe(@NonNull Disposable d) {
                mDisposable = d;
                Log.d("MainActivity", "onSubscribe");
            }

            @Override
            public void onNext(@NonNull String s) {
                Log.d("MainActivity", "onNext" + s);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d("MainActivity", "onError");
                e.printStackTrace();
            }

            @Override
            public void onComplete() {
                Log.d("MainActivity", "onComplete");
            }
        };
    }
}
