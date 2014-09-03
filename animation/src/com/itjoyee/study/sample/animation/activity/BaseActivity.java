package com.itjoyee.study.sample.animation.activity;


import android.app.Activity;

import com.itjoyee.study.sample.animation.R;

/**
 * @author itjoyee
 * www.itjoyee.com
 */
public class BaseActivity extends Activity {
	protected void startActivity_anim(int num) {
		switch (num) {
		case 0:// 淡入淡出效果
			overridePendingTransition(R.anim.fade, R.anim.hold);
			break;
		case 1:// 放大淡出效果
			overridePendingTransition(R.anim.my_scale_action, R.anim.my_alpha_action);
			break;
		case 2:// 转动淡出效果1
			overridePendingTransition(R.anim.scale_rotate, R.anim.my_alpha_action);
			break;
		case 3:// 转动淡出效果2
			overridePendingTransition(R.anim.scale_translate_rotate, R.anim.my_alpha_action);
			break;
		case 4:// 左上角展开淡出效果
			overridePendingTransition(R.anim.scale_translate, R.anim.my_alpha_action);
			break;
		case 5:// 压缩变小淡出效果
			overridePendingTransition(R.anim.hyperspace_in, R.anim.hyperspace_out);
			break;
		case 6:// 右往左推出效果
			overridePendingTransition(R.anim.push_left_in, R.anim.push_left_out);
			break;
		case 7:// 下往上推出效果
			overridePendingTransition(R.anim.push_up_in, R.anim.push_up_out);
			break;
		case 8:// 左右交叉效果
			overridePendingTransition(R.anim.slide_left, R.anim.slide_right);
			break;
		case 9:// 放大淡出效果
			overridePendingTransition(R.anim.wave_scale, R.anim.my_alpha_action);
			break;
		case 10:// 缩小效果
			overridePendingTransition(R.anim.zoom_enter, R.anim.zoom_exit);
			break;
		case 11:// 上下交错效果
			overridePendingTransition(R.anim.slide_up_in, R.anim.slide_down_out);
			break;
		}
	}
}
