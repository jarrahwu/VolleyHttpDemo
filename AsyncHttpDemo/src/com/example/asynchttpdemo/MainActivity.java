package com.example.asynchttpdemo;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

import android.net.Uri;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.jw.core.BaseActivity;
import com.jw.json.JacksonWrapper;
import com.jw.net.HttpCallBack;
import com.jw.util.L;
import com.koushikdutta.async.http.AsyncHttpClient;
import com.koushikdutta.async.http.AsyncHttpClient.JSONObjectCallback;
import com.koushikdutta.async.http.AsyncHttpGet;
import com.koushikdutta.async.http.AsyncHttpRequest;
import com.koushikdutta.async.http.AsyncHttpResponse;

public class MainActivity extends BaseActivity {
	Test1Entry entry;
	@Override
	protected void setupViews() {
		setContentView(R.layout.activity_main);
		testMyLib();

		// testVolley();
		// testAndroidAsync();

	}

	private void testMyLib() {
		String url = "http://admin.togoalad.com/user/broadcast";
		Http http = new Http();
		http.url(url)
		.cookie("accesstoken", "Q7a4wDUX_kEtqq32L08-G9yU0_fC")
		.get(new HttpCallBack() {
			@Override
			public void onResponse(JSONObject response) {
				System.out.println(response.toString());
				entry = JacksonWrapper.json2Bean(response, Test1Entry.class);
				System.out.println(entry);
				JSONObject obj = JacksonWrapper.bean2JSONObject(entry);
				L.red(obj);
			}
		});
	}

	private void testAndroidAsync() {
		final long start = System.currentTimeMillis();
		androidHttpAsyncGet("http://admin.togoalad.com/user/broadcast",
				new JSONObjectCallback() {

					@Override
					public void onCompleted(Exception e,
							AsyncHttpResponse source, JSONObject result) {
						long timeUsing = System.currentTimeMillis() - start;
						setUsingTime(R.id.asyncHttp, "Android AsyncHttp ",
								timeUsing, result.toString());
					}
				});
	}

	private void testVolley() {
		final long start = System.currentTimeMillis();
		String url = "http://admin.togoalad.com/user/broadcast";
		JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(url, null,
				new Listener<JSONObject>() {

					@Override
					public void onResponse(JSONObject response) {
						long timeUsing = System.currentTimeMillis() - start;
						setUsingTime(R.id.asyncHttp, "Android Volley ",
								timeUsing, response.toString());

						findView(R.id.volleyHttp, TextView.class).setText(
								"Lib :" + "Android Volley" + " timeUsing is :"
										+ timeUsing);
					}
				}, new ErrorListener() {

					@Override
					public void onErrorResponse(VolleyError error) {

					}
				}) {

			@Override
			public Map<String, String> getHeaders() throws AuthFailureError {
				HashMap<String, String> headers = new HashMap<String, String>();
				headers.put("accesstoken", "Q7a4wDUX_kEtqq32L08-G9yU0_fC");
				return headers;
			}
		};

		Volley.newRequestQueue(this).add(jsonObjectRequest);
	}

	protected void setUsingTime(int tvId, String string, long timeUsing,
			String detail) {
		Log.e("lib test", detail);
		Log.e("lib test", "Lib : " + string + " timeUsing is :" + timeUsing);
	}

	public void androidHttpAsyncGet(String url, JSONObjectCallback callback) {
		Uri uri = Uri.parse(url);
		String method = AsyncHttpGet.METHOD;
		AsyncHttpRequest req = new AsyncHttpRequest(uri, method, null);
		req.addHeader("accesstoken", "Q7a4wDUX_kEtqq32L08-G9yU0_fC");
		AsyncHttpClient.getDefaultInstance().executeJSONObject(req, callback);
	}

}
