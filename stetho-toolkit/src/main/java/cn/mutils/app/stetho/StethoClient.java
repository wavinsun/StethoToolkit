package cn.mutils.app.stetho;

import android.content.Context;

import com.facebook.stetho.Stetho;
import com.facebook.stetho.common.LogRedirector;

/**
 * Created by wenhua.ywh on 2018/1/3.
 */
public class StethoClient {

    private Context mContext;
    private boolean mStarted;

    public StethoClient(Context context) {
        mContext = context;
    }

    public void start() {
        if (mStarted) {
            return;
        }
        mStarted = true;
        LogRedirector.setLogger(new RedirectLogger());
        Stetho.initializeWithDefaults(mContext);
        new LogcatMonitor().start();
    }

}
