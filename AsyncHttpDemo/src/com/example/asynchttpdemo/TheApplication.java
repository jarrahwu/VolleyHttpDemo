package com.example.asynchttpdemo;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import android.app.Application;

public class TheApplication extends Application{
	
	public static TheApplication mInstance;
	
	private RequestQueue mQueue;
	
	
	@Override
	public void onCreate() {
		super.onCreate();
		mInstance = this;
		mQueue = Volley.newRequestQueue(this);
	}
	
	
	public static synchronized TheApplication getInstance() {
		return mInstance;
	}
	
	public RequestQueue getQueue() {
		return mQueue;
	}
	
}
