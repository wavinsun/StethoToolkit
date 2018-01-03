package cn.mutils.app.stethotoolkit;

import android.app.Application;

import cn.mutils.app.stetho.StethoClient;

/**
 * Created by wenhua.ywh on 2018/1/3.
 */

public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        new StethoClient(this).start();
    }
}
