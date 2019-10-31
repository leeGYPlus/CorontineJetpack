package com.gylee.kotlincoroutines.zunusepackage;

import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Dashboard {
    private final OkHttpClient okHttpClient = new OkHttpClient();
    private final Request request = new Request.Builder().url("https://baidu.com").get().build();
    private final Handler handler = new Handler(Looper.getMainLooper());
    public void display(final TextView textView){
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {

            }

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                final String str = response.body().toString();
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText(str );
                    }
                });
            }
        });
    }
}
