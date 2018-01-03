package cn.mutils.app.stethotoolkit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.facebook.stetho.inspector.console.CLog;
import com.facebook.stetho.inspector.protocol.module.Console;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.console_log).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CLog.writeToConsole(Console.MessageLevel.ERROR, Console.MessageSource.JAVASCRIPT,
                        "Hello World!" + new Date().toLocaleString());
            }
        });

        findViewById(R.id.logcat).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Hello World!" + new Date().toLocaleString());
            }
        });
    }
}
