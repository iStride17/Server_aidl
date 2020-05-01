package com.example.app0423;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import androidx.annotation.Nullable;

import aidl.connect.DemoBean;
import aidl.connect.DemoSonBean;
import aidl.connect.IVideo;

public class TestService extends Service {
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return ibider;
    }


    private IBinder ibider = new IVideo.Stub() {
        @Override
        public void basicTypes(int anInt, String aString) throws RemoteException {
            //這是基本數據類型測試
            System.out.println("AIDL+++++"+"Service:"+"basicTypes"+aString);
        }

        @Override
        public void getDemoBean(DemoBean bean) throws RemoteException {
            //這是帶序列化對象的集合的序列化類型測試
            //這裏服務端的處理只是打印 如果需要數據處理後返回給客戶端 可以定義函數為帶返回值類型
            System.out.println("AIDL+++++"+"Service:"+"getDemoBean"+bean.getName()+":"+bean.getSons().get(0).getSonName());
        }

        @Override
        public void getDemoSonBean(DemoSonBean bean) throws RemoteException {
            //這是序列化數據類型測試
            System.out.println("AIDL+++++"+"Service:"+"getDemoSonBean"+bean.getSonName());
        }
    };



    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

}
