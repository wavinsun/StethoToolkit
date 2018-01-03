package cn.mutils.app.stetho;

import android.util.Log;

import com.facebook.stetho.inspector.console.CLog;
import com.facebook.stetho.inspector.protocol.module.Console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wenhua.ywh on 2018/1/3.
 */

public class LogcatMonitor extends Thread {

    private static final String TAG = LogcatMonitor.class.getSimpleName();

    public LogcatMonitor() {
        super("LogcatMonitor");
    }

    @Override
    public void run() {
        while (true) {
            Log.d(TAG, "Logcat Monitor start ... ...");
            Process process = null;
            BufferedReader br = null;
            try {
                process = Runtime.getRuntime().exec(new String[]{
                        "logcat", "-v", "time", "-T",
                        new SimpleDateFormat("MM-dd HH:mm:ss.SSS").format(new Date())});
                br = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String line = null;
                while ((line = br.readLine()) != null) {
                    CLog.writeToConsole(Console.MessageLevel.LOG, Console.MessageSource.JAVASCRIPT,
                            line);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (br != null) {
                    try {
                        br.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (process != null) {
                    process.destroy();
                }
            }
            Log.d(TAG, "Logcat Monitor stop.");
        }
    }

}
