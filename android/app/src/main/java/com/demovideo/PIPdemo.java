package com.demovideo;

import android.app.Activity;
import android.app.PictureInPictureParams;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.util.Rational;
import android.view.Display;
import android.view.View;
import android.widget.Button;

import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import java.util.HashMap;
import java.util.Map;

public class PIPdemo extends ReactContextBaseJavaModule{

    private static ReactApplicationContext reactContext;
    public Configuration configuration;
   public boolean isInPictureInPictureMode= false;
    public PIPdemo(ReactApplicationContext context){

        super(context);
        this.reactContext=context;
    }

    @Override
    public String getName(){
        return "PIP";
    }

    @ReactMethod
    public void enterPIP(){
        final Activity activity = getCurrentActivity();
        if(hasSystemFeature(PackageManager.FEATURE_PICTURE_IN_PICTURE)){

            Rational aspectRation = new Rational(220,392);
            PictureInPictureParams.Builder mPictureInPictureParamsBuilder= new PictureInPictureParams.Builder();
            mPictureInPictureParamsBuilder.setAspectRatio(aspectRation).build();

            activity.enterPictureInPictureMode(mPictureInPictureParamsBuilder.build());
            isInPictureInPictureMode=true;
            return;
        }
    }

    @Override
    public Map<String,Object> getConstants(){
       final Map<String, Object> constants= new HashMap<>();
//        constants.put()
                return constants;
    }

    @ReactMethod
    public void disableControls(Callback success){
        if(isInPictureInPictureMode){
            boolean val=false;
            success.invoke(val);
            return;
        }else {
            boolean val=true;
            success.invoke(val);
            return;
        }
    }

    @ReactMethod
    public void onPause(Callback success){
        if(isInPictureInPictureMode){
            boolean val=false;
            success.invoke(val);
            return;
        }else {
            boolean val=true;
            success.invoke(val);
            return;
        }

    }

    public boolean hasSystemFeature (String featureName){
        return true;
    }
//

}
