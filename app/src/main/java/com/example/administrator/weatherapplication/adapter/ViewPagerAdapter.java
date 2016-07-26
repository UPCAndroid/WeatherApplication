package com.example.administrator.weatherapplication.adapter;

/**
 * Created by w1210 on 2016/7/26.
 */

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;




/**
 * Created by Administrator on 2016/7/24.
 */
public class ViewPagerAdapter extends PagerAdapter {
    Context context;
    ArrayList<View> list;

    public ViewPagerAdapter(Context context, ArrayList<View> list) {
        this.context = context;
        this.list = list;
    }

    /**
     * 返回集合里边元素的个数
     * @return
     */
    @Override
    public int getCount() {
        return list.size();
    }

    /**
     * 返回当前视图的下标
     * @param object
     * @return
     */
    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }

    /**
     *
     * @param container
     * @param position
     * @return
     */
    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        //把集合里的布局添加到viewpager
        ((ViewPager)container).addView(list.get(position));
        //返回刚才添加的内容
        return list.get(position);
    }

    /**
     * 删除viewpager里边对应的某一页内容
     * @param container
     * @param position
     * @param object
     */
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        ((ViewPager)container).removeView((View)object);
    }

    /**
     * 判断内容是否来源于viewpager
     * @param view
     * @param object
     * @return
     */
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }
}

