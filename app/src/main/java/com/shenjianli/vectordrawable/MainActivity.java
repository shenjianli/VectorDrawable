package com.shenjianli.vectordrawable;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {


    ImageView mImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mImg = (ImageView)findViewById(R.id.image);
        Animation operatingAnim = AnimationUtils.loadAnimation(this, R.anim.rotate_anim);
        mImg.startAnimation(operatingAnim);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}


/**
 * VectorDrawable

 在处理Android开发布局适配的时候，我们会经常遇到图片图标因为缩放引起的模糊等问题。
 虽然能够通过多套图片来解决这个问题，但是这种方法带来的一个弊端就是应用的体积会变得很大。
 提到缩放而不失真我们可能会很快想到了矢量图这个词，
 从Android5.0开始（API21)Google提供了对于矢量图片的支持——VectorDrawable。
 使用VectorDrawable能够在Android中使用矢量图，推荐针对于简单的图形来进行使用，特别是图标一类的简单图像。
 VectorDrawable能够带来哪些方便：
 - 不会因为不同分辨率出现模糊等失真的情况。
 - 替换png图片能够在一定程度上减小应用程序的体积。
 - 配合使用属性动画能够做出一些比较绚丽的动画效果。
 使用中一些不方便的地方：因为矢量图形主要数据部分是一些“轨迹”命令，VectorDrawable只能支持部分。编写起来要费尽一些。不过一些简单的内容就能够帮我们解决一些问题，所以对于开发的帮助还是非常有帮助的。

 常用的绘制指令

 M：moveto 移动，用法Mx,y移动到x,y

 L：line to，绘制直线，用法Lx,y直线连到x,y，起点为上一步的结尾点或者是（0,0），还有简化命令H(x) 水平连接、V(y)垂直连接 参数为线的结束点的x/y坐标

 Z：没有参数，连接起点和终点

 C：三次贝塞尔曲线，用法C(x1 y1 x2 y2 x y)控制点x1,y1 x2,y2，终点x,y

 Q：二次贝塞尔曲线，用法Q(x1 y1 x y)，控制点x1,y1，终点x,y

 A：椭圆圆弧，用法A(rx ry x-axis-rotation large-arc-flag sweep-flag x y) ，X轴半径rx，Y轴半径ry， x-axis-rotation为X轴偏角， large-arc-flag为0取小弧度，1取大弧度，sweep-flag为0逆时针，1顺时针，终点x,y

 关于贝塞尔曲线的深入理解可以参考：http://www.zhangxinxu.com/wordpress/2014/06/deep-understand-svg-path-bezier-curves-command/

 关于圆弧的参数的更深入理解：http://blog.csdn.net/xu_fu/article/details/44004841

 */
