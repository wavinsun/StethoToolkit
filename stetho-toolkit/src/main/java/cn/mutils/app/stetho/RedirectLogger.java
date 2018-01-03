package cn.mutils.app.stetho;

import com.facebook.stetho.common.LogRedirector;

/**
 * Created by wenhua.ywh on 2018/1/3.
 */

public class RedirectLogger implements LogRedirector.Logger {

    @Override
    public boolean isLoggable(String tag, int priority) {
        return false;
    }

    @Override
    public void log(int priority, String tag, String message) {

    }

}
