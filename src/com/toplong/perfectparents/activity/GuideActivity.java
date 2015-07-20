package com.toplong.perfectparents.activity;

import java.util.ArrayList;
import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import com.toplong.perfectparents.R;



public class GuideActivity extends BaseActivity {
	
	private ViewPager guidepager;
	private Button guidestartBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.guideactivity);
		guidepager = (ViewPager)findViewById(R.id.guidepager);
		guidepager.setAdapter(new GuidePagerAdapter());
		guidepager.setOnPageChangeListener(new OnPageChangeListener() {
			
			@Override
			public void onPageSelected(int arg0) {
				if(arg0==2){
					guidestartBtn.setVisibility(View.VISIBLE);
				}else{
					guidestartBtn.setVisibility(View.INVISIBLE);
				}
			}
			
			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
			}
			
			@Override
			public void onPageScrollStateChanged(int arg0) {
			}
		});
		guidestartBtn = (Button) findViewById(R.id.guidestartBtn);
		guidestartBtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(GuideActivity.this, LoginActivity.class);
				startActivity(intent);
				finish();
			}
		});
		
	}
	
	private class GuidePagerAdapter extends PagerAdapter {
		
		List<ImageView> ivList = new ArrayList<ImageView>();
		
		public GuidePagerAdapter() {
			int[] ivIds = new int[] { R.drawable.guideactivity_guideone,R.drawable.guideactivity_guidetwo, R.drawable.guideactivity_guidethree };
			for(int i=0;i<ivIds.length;i++){
				ImageView image = new ImageView(GuideActivity.this);
				image.setBackgroundResource(ivIds[i]);
				ivList.add(image);
			}
		}

		@Override
		public int getCount() {
			return ivList.size();
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return arg0 == arg1;
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			container.addView(ivList.get(position));
			return ivList.get(position);
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView((View) object);
		}

	}

}
