package com.example.asynchttpdemo;

import com.android.volley.RequestQueue;
import com.jw.net.AbstractHttp;

public class Http extends AbstractHttp<Http>{

	@Override
	public RequestQueue getQueue() {
		return TheApplication.getInstance().getQueue();
	}

}
