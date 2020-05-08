package com.demovideo;


import com.facebook.react.uimanager.ViewManager;
import java.util.List;
import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;

import java.util.ArrayList;
import java.util.Collections;

public  class PIPManager implements ReactPackage{
    @Override
    public List<ViewManager> createViewManagers(ReactApplicationContext context){
        return  Collections.emptyList();
    }

    @Override
    public List<NativeModule> createNativeModules(ReactApplicationContext context){
        List<NativeModule> list= new ArrayList<>();
        list.add(new PIPdemo(context));
        return list;
    }
}