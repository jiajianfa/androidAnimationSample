package com.itjoyee.study.sample.animation.utils;

import android.content.Context;
import android.util.DisplayMetrics;

/**
 * @author itjoyee
 *  www.itjoyee.com
 */
public class DensityUtil {
	private final String TAG = DensityUtil.class.getSimpleName();
	private DisplayMetrics dm = new DisplayMetrics();
	private float dmDensityDpi = 0.0F;
	private float scale = 0.0F;

	public DensityUtil(Context paramContext) {
		this.dm = paramContext.getApplicationContext().getResources().getDisplayMetrics();
		this.dmDensityDpi = this.dm.densityDpi;
		this.scale = (getDmDensityDpi() / 160.0F);
	}

	public int dip2px(float paramFloat) {
		return (int) (0.5F + paramFloat * this.scale);
	}

	public float getDmDensityDpi() {
		return this.dmDensityDpi;
	}

	public int getScreenHeight() {
		return this.dm.heightPixels;
	}

	public int getScreenWidth() {
		return this.dm.widthPixels;
	}

	public int px2dip(float paramFloat) {
		return (int) (0.5F + paramFloat / this.scale);
	}

	public String toString() {
		return " dmDensityDpi:" + this.dmDensityDpi;
	}
}