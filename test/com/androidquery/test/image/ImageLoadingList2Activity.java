package com.androidquery.test.image;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.androidquery.AQuery;
import com.androidquery.R;
import com.androidquery.callback.AjaxStatus;
import com.androidquery.callback.BitmapAjaxCallback;
import com.androidquery.test.RunSourceActivity;
import com.androidquery.util.AQUtility;

public class ImageLoadingList2Activity extends RunSourceActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
	
		super.onCreate(savedInstanceState);		
	
		//AQUtility.cleanCacheAsync(this, 0, 0);
		//BitmapAjaxCallback.clearCache();
		
		render();
	}
	
	protected int getContainer(){
		return R.layout.image_list_activity2;
	}
	
	
	public void render() {
	
		List<String> items = new ArrayList<String>();
		
		items.add("http://farm4.static.flickr.com/3531/3769416703_b76406f9de.jpg");
		items.add("http://farm3.static.flickr.com/2490/3770244988_c9e93c3799.jpg");
		items.add("http://farm4.static.flickr.com/3008/2636284089_3a4383e9a4.jpg");
		items.add("http://farm3.static.flickr.com/2113/2263237656_e40b912b46.jpg");
		
		ArrayAdapter<String> aa = new ArrayAdapter<String>(this, R.layout.content_item_s, items){
			
			@Override
			public View getView(int position, View convertView, ViewGroup parent) {
				
				if(convertView == null){
					convertView = ((LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.content_item_s2, null);
				}
				
				String url = getItem(position);
				
				AQuery aq = new AQuery(convertView);
				
				ProgressBar pbar = aq.id(R.id.pbar).getProgressBar();
				
				BitmapAjaxCallback cb = new BitmapAjaxCallback();
				cb.url(url).ratio(1.5f).progress(pbar);				
				aq.id(R.id.tb).image(cb);
				
				return convertView;
				
				
				/*
				ImageView imageView = (ImageView) convertView ;
	            if( convertView == null )
	            {
	            	imageView = new ImageView(ImageLoadingList2Activity.this) ;
	            }
	            AQuery aq = new AQuery(imageView);
	            //String tb = "http://www.vikispot.com/z/images/vikispot/android-w.png";
	            String tb = getItem(position);
	            aq.image(tb, true, true, 0, 0, null, 0, 1.5f);
	            return imageView ;
	            */
			}
		};
		
		aq.id(R.id.list).adapter(aa);
		
	}
	
	
	@Override
	protected void runSource(){
		
		//AQUtility.invokeHandler(this, type, false, null);
	}
	
	
	
}
