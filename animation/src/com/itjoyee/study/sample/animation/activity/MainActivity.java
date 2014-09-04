package com.itjoyee.study.sample.animation.activity;

import java.util.ArrayList;
import java.util.List;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.CycleInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.itjoyee.study.sample.animation.R;
import com.itjoyee.study.sample.animation.utils.DensityUtil;
import com.ryanharter.viewpager.PagerAdapter;
import com.ryanharter.viewpager.ViewPager;

/**
 * @author itjoyee
 * www.itjoyee.com
 */
public class MainActivity extends FragmentActivity implements ViewPager.OnPageChangeListener {

	private Animation animationBottom;
	private Animation animationTop;

	private RelativeLayout centerLayout;

	private int fx1;
	private int fx2;
	private int fx3;
	private int fx4;

	private int fy1;
	private int fy2;
	private int fy3;
	private int fy4;

	private VerticalFragementPagerAdapter mAdapter;
	private ViewPager mPager;
	private List<View> pagers = new ArrayList();
	private int preIndex = 0;

	private ImageView t1_fixed;
	private ImageView t1_icon1;
	private AnimationDrawable t1_icon1_animationDrawable;
	private ImageView t1_icon2;
	private ImageView t1_next;
	private ImageView t2_fixed;
	private ImageView t2_icon1;
	private ImageView t2_next;
	private ImageView t3_fixed;
	private ImageView t3_icon2;
	private ImageView t3_icon3;
	private ImageView t3_icon4;
	private ImageView t3_icon5;
	private ImageView t3_icon6;
	private AnimationDrawable t3_icon6_animationDrawable;
	private ImageView t3_next;
	private ImageView t4_fixed;
	private ImageView t4_icon1;
	private int tx1;
	private int tx2;
	private int tx3;
	private int tx4;
	private int ty1;
	private int ty2;
	private int ty3;
	private int ty4;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		this.mPager = ((ViewPager) findViewById(R.id.pager));
		View localView1 = LayoutInflater.from(this).inflate(R.layout.layout_tutorial_1, null);
		this.t1_icon1 = ((ImageView) localView1.findViewById(R.id.t1_icon1));
		this.t1_icon2 = ((ImageView) localView1.findViewById(R.id.t1_icon2));
		this.t1_fixed = ((ImageView) localView1.findViewById(R.id.t1_fixed));
		this.t1_next = ((ImageView) localView1.findViewById(R.id.t1_next));
		this.pagers.add(localView1);

		View localView2 = LayoutInflater.from(this).inflate(R.layout.layout_tutorial_2, null);
		this.t2_icon1 = ((ImageView) localView2.findViewById(R.id.t2_icon1));
		this.t2_fixed = ((ImageView) localView2.findViewById(R.id.t2_fixed));
		this.t2_next = ((ImageView) localView2.findViewById(R.id.t2_next));
		this.pagers.add(localView2);

		View localView3 = LayoutInflater.from(this).inflate(R.layout.layout_tutorial_3, null);
		this.t3_icon2 = ((ImageView) localView3.findViewById(R.id.t3_icon2));
		this.t3_icon3 = ((ImageView) localView3.findViewById(R.id.t3_icon3));
		this.t3_icon4 = ((ImageView) localView3.findViewById(R.id.t3_icon4));
		this.t3_icon5 = ((ImageView) localView3.findViewById(R.id.t3_icon5));
		this.t3_icon6 = ((ImageView) localView3.findViewById(R.id.t3_icon6));
		this.t3_fixed = ((ImageView) localView3.findViewById(R.id.t3_fixed));
		this.t3_next = ((ImageView) localView3.findViewById(R.id.t3_next));
		this.centerLayout = ((RelativeLayout) localView3.findViewById(R.id.center_layout_3));
		this.pagers.add(localView3);

		localView3.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
			public void onGlobalLayout() {
				int i = MainActivity.this.centerLayout.getTop();
				int j = MainActivity.this.centerLayout.getBottom();
				int k = new DensityUtil(MainActivity.this).getScreenWidth();

				MainActivity.this.fx1 = (MainActivity.this.t3_icon2.getTop() + MainActivity.this.t3_icon2.getHeight());
				MainActivity.this.fy1 = (-MainActivity.this.t3_icon2.getTop() - MainActivity.this.t3_icon2.getHeight());
				MainActivity.this.tx1 = (-MainActivity.this.t3_icon2.getWidth() - MainActivity.this.t3_icon2.getLeft());
				MainActivity.this.ty1 = (MainActivity.this.t3_icon2.getTop() + MainActivity.this.t3_icon2.getLeft() + MainActivity.this.t3_icon2
						.getWidth());
				MainActivity.this.fx2 = (MainActivity.this.t3_icon3.getTop() + MainActivity.this.t3_icon3.getHeight());
				MainActivity.this.fy2 = (-MainActivity.this.t3_icon3.getTop() - MainActivity.this.t3_icon3.getHeight());
				MainActivity.this.tx2 = (-MainActivity.this.t3_icon3.getWidth() - MainActivity.this.t3_icon3.getLeft());
				MainActivity.this.ty2 = (MainActivity.this.t3_icon3.getTop() + MainActivity.this.t3_icon3.getLeft() + MainActivity.this.t3_icon3
						.getWidth());
				MainActivity.this.fx3 = (k - MainActivity.this.t3_icon4.getLeft());
				MainActivity.this.fy3 = (-(k - MainActivity.this.t3_icon4.getLeft()));
				MainActivity.this.tx3 = (-(j - i - MainActivity.this.t3_icon4.getTop()));
				MainActivity.this.ty3 = (j - i - MainActivity.this.t3_icon4.getTop());
				MainActivity.this.fx4 = (k - MainActivity.this.t3_icon5.getLeft());
				MainActivity.this.fy4 = (-(k - MainActivity.this.t3_icon5.getLeft()));
				MainActivity.this.tx4 = (-(j - i - MainActivity.this.t3_icon5.getTop()));
				MainActivity.this.ty4 = (j - i - MainActivity.this.t3_icon5.getTop());
			}
		});

		View localView4 = LayoutInflater.from(this).inflate(R.layout.layout_tutorial_4, null);
		this.t4_icon1 = ((ImageView) localView4.findViewById(R.id.t4_icon1));
		this.t4_fixed = ((ImageView) localView4.findViewById(R.id.t4_fixed));
		this.pagers.add(localView4);
		this.mAdapter = new VerticalFragementPagerAdapter();
		this.mPager.setAdapter(this.mAdapter);
		this.mPager.setOnPageChangeListener(this);

		animal(0);
	}

	private class VerticalFragementPagerAdapter extends PagerAdapter {
		private VerticalFragementPagerAdapter() {
		}

		public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject) {
			paramViewGroup.removeView((View) paramObject);
		}

		public int getCount() {
			return MainActivity.this.pagers.size();
		}

		public Object instantiateItem(ViewGroup paramViewGroup, int paramInt) {
			paramViewGroup.addView((View) MainActivity.this.pagers.get(paramInt));
			return MainActivity.this.pagers.get(paramInt);
		}

		public boolean isViewFromObject(View paramView, Object paramObject) {
			return paramView == paramObject;
		}
	}

	@Override
	public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
	}

	@Override
	public void onPageSelected(int paramInt) {
		animal(paramInt);
	}

	@Override
	public void onPageScrollStateChanged(int state) {
	}

	private void animal(int paramInt) {
		switch (paramInt) {
		case 0:

			if (this.preIndex > paramInt) {
				if (this.t2_icon1.getAnimation() != null) {
					this.t2_icon1.getAnimation().cancel();
					this.t2_icon1.setVisibility(View.INVISIBLE);
				}
			}

			// 图片切换 帧帧动画
			this.t1_icon1.setImageResource(R.drawable.t1_frame_animation);
			this.t1_icon1_animationDrawable = ((AnimationDrawable) this.t1_icon1.getDrawable());
			this.t1_icon1_animationDrawable.start();

			Animation localAnimation2 = AnimationUtils.loadAnimation(this, R.anim.tutorail_rotate);
			localAnimation2.setInterpolator(new LinearInterpolator());
			this.t1_icon2.setVisibility(View.VISIBLE);
			this.t1_icon2.startAnimation(localAnimation2);

			// 渐变尺寸（scale）动画效果 
			this.animationTop = AnimationUtils.loadAnimation(this, R.anim.tutorail_scalate_top);
			// 平移动画效果和透明度控制动画
			this.animationBottom = AnimationUtils.loadAnimation(this, R.anim.tutorail_bottom);

			this.t1_fixed.startAnimation(this.animationTop);
			this.t1_next.startAnimation(this.animationBottom);

			break;
		case 1:
			if (preIndex > paramInt) {
				this.t3_icon2.getAnimation().cancel();
				this.t3_icon3.getAnimation().cancel();
				this.t3_icon4.getAnimation().cancel();
				this.t3_icon5.getAnimation().cancel();
				this.t3_icon2.setVisibility(View.INVISIBLE);
				this.t3_icon3.setVisibility(View.INVISIBLE);
				this.t3_icon4.setVisibility(View.INVISIBLE);
				this.t3_icon5.setVisibility(View.INVISIBLE);
				this.t3_icon6_animationDrawable.stop();
			} else {
				this.t1_icon1_animationDrawable.stop();

				this.t1_icon2.getAnimation().cancel();
				this.t1_icon2.setVisibility(View.INVISIBLE);
			}

			Animation localAnimation1 = AnimationUtils.loadAnimation(this, R.anim.tutorail_scalate);
			this.t2_icon1.setVisibility(View.VISIBLE);
			this.t2_icon1.startAnimation(localAnimation1);

			this.t2_fixed.startAnimation(this.animationTop);
			this.t2_next.startAnimation(this.animationBottom);
			break;
		case 2:

			this.t3_icon6.setImageResource(R.drawable.t3_frame_animation);
			this.t3_icon6_animationDrawable = ((AnimationDrawable) this.t3_icon6.getDrawable());
			final TranslateAnimation localTranslateAnimation1 = new TranslateAnimation(this.fx1, this.tx1, this.fy1,
					this.ty1);
			localTranslateAnimation1.setDuration(800L);
			localTranslateAnimation1.setRepeatCount(-1);
			localTranslateAnimation1.setRepeatMode(1);
			LinearInterpolator localLinearInterpolator = new LinearInterpolator();
			localTranslateAnimation1.setInterpolator(localLinearInterpolator);

			final TranslateAnimation localTranslateAnimation2 = new TranslateAnimation(this.fx2, this.tx2, this.fy2,
					this.ty2);
			localTranslateAnimation2.setDuration(1200L);
			localTranslateAnimation2.setRepeatCount(-1);
			localTranslateAnimation2.setRepeatMode(1);
			localTranslateAnimation2.setInterpolator(localLinearInterpolator);

			final TranslateAnimation localTranslateAnimation3 = new TranslateAnimation(this.fx3, this.tx3, this.fy3,
					this.ty3);
			localTranslateAnimation3.setDuration(1200L);
			localTranslateAnimation3.setRepeatCount(-1);
			localTranslateAnimation3.setRepeatMode(1);
			localTranslateAnimation3.setInterpolator(localLinearInterpolator);

			final TranslateAnimation localTranslateAnimation4 = new TranslateAnimation(this.fx4, this.tx4, this.fy4,
					this.ty4);
			localTranslateAnimation4.setDuration(800L);
			localTranslateAnimation4.setRepeatCount(-1);
			localTranslateAnimation4.setRepeatMode(1);
			localTranslateAnimation4.setInterpolator(localLinearInterpolator);

			new Handler() {
				public void handleMessage(Message paramAnonymousMessage) {
					if (paramAnonymousMessage.what == 1) {
						MainActivity.this.t3_icon2.setVisibility(View.VISIBLE);
						MainActivity.this.t3_icon3.setVisibility(View.VISIBLE);
						MainActivity.this.t3_icon4.setVisibility(View.VISIBLE);
						MainActivity.this.t3_icon5.setVisibility(View.VISIBLE);
						MainActivity.this.t3_icon2.startAnimation(localTranslateAnimation1);
						MainActivity.this.t3_icon3.startAnimation(localTranslateAnimation2);
						MainActivity.this.t3_icon4.startAnimation(localTranslateAnimation3);
						MainActivity.this.t3_icon5.startAnimation(localTranslateAnimation4);
						MainActivity.this.t3_icon6_animationDrawable.start();
					}
				}
			}.sendEmptyMessageDelayed(1, 1000L);

			this.t3_fixed.startAnimation(this.animationTop);
			this.t3_next.startAnimation(this.animationBottom);

			break;
		case 3:

			this.t3_icon2.getAnimation().cancel();
			this.t3_icon3.getAnimation().cancel();
			this.t3_icon4.getAnimation().cancel();
			this.t3_icon5.getAnimation().cancel();
			this.t3_icon2.setVisibility(View.INVISIBLE);
			this.t3_icon3.setVisibility(View.INVISIBLE);
			this.t3_icon4.setVisibility(View.INVISIBLE);
			this.t3_icon5.setVisibility(View.INVISIBLE);
			this.t3_icon6_animationDrawable.stop();

			CycleInterpolator localCycleInterpolator = new CycleInterpolator(3.0F);
			RotateAnimation localRotateAnimation = new RotateAnimation(0.0F, 10.0F, 1, 0.47F, 1, 0.05F);
			localRotateAnimation.setStartOffset(500L);
			localRotateAnimation.setDuration(3000L);
			localRotateAnimation.setRepeatCount(1);
			localRotateAnimation.setInterpolator(localCycleInterpolator);
			this.t4_icon1.startAnimation(localRotateAnimation);
			this.t4_fixed.startAnimation(this.animationTop);
			break;
		default:
			break;
		}
		preIndex = paramInt;
	}

}
