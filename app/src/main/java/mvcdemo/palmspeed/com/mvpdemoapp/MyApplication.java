package mvcdemo.palmspeed.com.mvpdemoapp;

import android.app.Activity;
import android.app.Application;
import android.content.res.Configuration;
import android.os.Bundle;

public class MyApplication extends Application implements Application.ActivityLifecycleCallbacks {

    private AppModel model;

    // Singleton instance
    private static MyApplication sInstance = null;

    public static MyApplication getInstance() {
        return sInstance ;
    }

   @Override
    public void onCreate() {
        super.onCreate();

       // Setup singleton instance
       sInstance = this;

        model = new AppModel(UserStatus.LOGGED_OUT);
        registerActivityLifecycleCallbacks(this);
   }

    public AppModel getModel() {
        return model;
    }

    public void setModel(AppModel model) {
        this.model = model;
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }

    @Override
    public void onActivityCreated(Activity activity, Bundle bundle) {
        System.out.println("Activity Created...!");
    }

    @Override
    public void onActivityStarted(Activity activity) {

    }

    @Override
    public void onActivityResumed(Activity activity) {

    }

    @Override
    public void onActivityPaused(Activity activity) {

    }

    @Override
    public void onActivityStopped(Activity activity) {

    }

    @Override
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

    }

    @Override
    public void onActivityDestroyed(Activity activity) {
        System.out.println("Activity Destroyed...!");
    }
}