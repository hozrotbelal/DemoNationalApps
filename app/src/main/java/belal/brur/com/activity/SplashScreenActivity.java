package belal.brur.com.activity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;


import belal.brur.com.R;



public class SplashScreenActivity extends AppCompatActivity {

    private TextView tvAppVersion;
    private SplashCountDownTimer splashCountDownTimer;
    private static final long splashTime = 4 * 1000;
    private static final long interval = 1 * 1000;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_splash_screen);

        initActivityViews();
        initActivityViewsData();
    }


    public void initActivityViews() {
        tvAppVersion = (TextView) findViewById(R.id.tv_app_version);
    }

    public void initActivityViewsData() {
        //Set app version


        tvAppVersion = (TextView) findViewById(R.id.tv_app_version);
        PackageInfo pInfo = null;
        try {
            pInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        tvAppVersion.setText("Vertion: "+pInfo.versionName);


        //Initialize splash timer
        splashCountDownTimer = new SplashCountDownTimer(splashTime, interval);
        splashCountDownTimer.start();
    }

    private class SplashCountDownTimer extends CountDownTimer {
        private SplashCountDownTimer(long startTime, long interval) {
            super(startTime, interval);
        }

        @Override
        public void onFinish() {
            //Navigate to the home screen
            Intent intent;
            intent = new Intent(SplashScreenActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        }

        @Override
        public void onTick(long millisUntilFinished) {
        }
    }

    public void onBackPressed() {
        super.onBackPressed();

        //Close countdown timer if it is running
        if (splashCountDownTimer != null) {
            splashCountDownTimer.cancel();
        }
    }
}
