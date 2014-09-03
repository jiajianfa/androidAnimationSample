Android框架本身就使用了大量的动画效果，比如Activity切换的动画效果，Dialog弹出和关闭时的渐变动画效果以及Toast显示信息时的淡入淡出效果等等。
Android系统框架为我们提供了一些动画类及其工具类，所以在Andorid应用中使用动画效果非常简单。
Android中可以在xml中定义Animation，也可以在java code中定义。
Android中动画的实现分两种方式，一种方式是补间动画 Tween Animation，就是说你定义一个开始和结束，中间的部分由android自身实现。
另一种叫逐帧动画 Frame Animation，就是说一帧一帧的连起来播放就变成了动画。

一、Tween Animation
    xml中实现：
    alpha	渐变透明度动画效果
    scale	渐变尺寸伸缩动画效果
    translate	画面转换位置移动动画效果
    rotate	画面转移旋转动画效果

    JavaCode中
    AlphaAnimation	渐变透明度动画效果
    ScaleAnimation	渐变尺寸伸缩动画效果
    TranslateAnimation	画面转换位置移动动画效果
    RotateAnimation	画面转移旋转动画效果

 使用XML文件定义Tween Animation时XML文件的根节点可以是<alpha>、<scale> <translate>、<rotate>或者是把它们都放入<set>节点中。
 如下：
<?xml version="1.0" encoding="utf-8"?>
< set xmlns:android="http://schemas.android.com/apk/res/android">
  <alpha/>
  <scale/>
  <translate/>
  <rotate/>
</set>

Java Code实现如下：
AlphaAnimation ：
AnimationSet animationSet = new AnimationSet(true);//创建一个AnimationSet对象  
AlphaAnimation alphaAnimation = new AlphaAnimation(1, 0);//创建一个AlphaAnimation对象           
alphaAnimation.setDuration(1000);//设置动画执行的时间（单位：毫秒）       
animationSet.addAnimation(alphaAnimation);//将AlphaAnimation对象添加到AnimationSet当中        
view.startAnimation(animationSet);//使用view的startAnimation方法开始执行动画   

RotateAnimation ：
AnimationSet animationSet = new AnimationSet(true);
/** 
* 前两个参数定义旋转的起始和结束的度数，后两个参数定义圆心的位置 
*/
RotateAnimation rotateAnimation = new RotateAnimation(0, 360,    
                    Animation.RELATIVE_TO_PARENT, 1f,    
                    Animation.RELATIVE_TO_PARENT, 0f);    
rotateAnimation.setDuration(5000);    
animationSet.addAnimation(rotateAnimation);    
imageView.startAnimation(animationSet); 

TranslateAnimation：
AnimationSet animationSet = new AnimationSet(true);    
/** 
* x和y轴的起始和结束位置 
*/
TranslateAnimation translateAnimation = new TranslateAnimation    
            (    
                    Animation.RELATIVE_TO_SELF, 0f,     
                    Animation.RELATIVE_TO_SELF,0.5f,     
                    Animation.RELATIVE_TO_SELF, 0f,    
                    Animation.RELATIVE_TO_SELF, 1.0f    
            );    
translateAnimation.setDuration(1000);    
animationSet.addAnimation(translateAnimation);    
view.startAnimation(animationSet);  

ScaleAnimation：
AnimationSet animationSet = new AnimationSet(true);    
/** 
* 围绕一个点伸缩 
*/
ScaleAnimation scaleAnimation = new ScaleAnimation(1, 0.1f, 1,    
                    0.1f, Animation.RELATIVE_TO_SELF, 0.5f,    
                    Animation.RELATIVE_TO_SELF, 0.5f);
animationSet.addAnimation(scaleAnimation);    
animationSet.setStartOffset(1000);    
animationSet.setFillAfter(true);    
animationSet.setFillBefore(false);    
animationSet.setDuration(2000);    
view.startAnimation(animationSet);


属性说明
尺寸伸缩动画（scale）
       属性：interpolator 指定一个动画的插入器
       常见动画插入器:
            accelerate_decelerate_interpolator  加速-减速 动画插入器
            accelerate_interpolator        加速-动画插入器
            decelerate_interpolator        减速- 动画插入器
            anticipate_interpolator	先回退一小步然后加速前进
            anticipate_overshoot_interpolator	在上一个基础上超出终点一小步再回到终点
            bounce_interpolator	最后阶段弹球效果
            cycle_interpolator	周期运动
            linear_interpolator	匀速
            overshoot_interpolator	快速到达终点并超出一小步最后回到终点
      浮点型值：
            fromXScale 属性为动画起始时 X坐标上的伸缩尺寸    
            toXScale   属性为动画结束时 X坐标上的伸缩尺寸              
            fromYScale 属性为动画起始时Y坐标上的伸缩尺寸    
            toYScale   属性为动画结束时Y坐标上的伸缩尺寸    
            说明:
                 以上四种属性值    
       0.0表示收缩到没有 
       1.0表示正常无伸缩     
                    值小于1.0表示收缩  
                    值大于1.0表示放大
       pivotX     属性为动画相对于物件的X坐标的开始位置
       pivotY     属性为动画相对于物件的Y坐标的开始位置
            说明:
                    以上两个属性值 从0%-100%中取值
       50%为物件的X或Y方向坐标上的中点位置        
        长整型值：
            duration  属性为动画持续时间
            说明:   时间以毫秒为单位
        布尔型值:
            fillAfter 属性 当设置为true ，该动画转化在动画结束后被应用
            
            
渐变动画（alpha）
         透明度控制动画效果 alpha
        浮点型值：
            fromAlpha 属性为动画起始时透明度
            toAlpha   属性为动画结束时透明度
            说明: 
                0.0表示完全透明
                1.0表示完全不透明
            以上值取0.0-1.0之间的float数据类型的数字
	长整型值：
            duration  属性为动画持续时间
            说明:     
                时间以毫秒为单位
        整型值:        
            repeatCount：重复次数
            说明：
            infinite：循环执行，
            具体正整数表示循环次数
             repeatMode：重复模式，
             说明：
                restart：重新从头开始执行
                reverse：反方向执行

平移动画（translate）
        整型值:
            fromXDelta 属性为动画起始时 X坐标上的位置    
            toXDelta   属性为动画结束时 X坐标上的位置
            fromYDelta 属性为动画起始时 Y坐标上的位置
            toYDelta   属性为动画结束时 Y坐标上的位置
            注意:
                     没有指定fromXType toXType fromYType toYType 时候，
                     默认是以自己为相对参照物  ，默认参考物最重要         
        长整型值：
            duration  属性为动画持续时间
            说明:   时间以毫秒为单位
            
            
            
startActivity、startActivityForResult和finish方法之后
添加overridePendingTransition(enterAnim, exitAnim)方法
Android已经内置了几种动画效果，可以见 android.R.anim 类

http://blog.csdn.net/menxu_work/article/details/10258787



 