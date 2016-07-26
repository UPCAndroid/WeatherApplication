package com.example.administrator.weatherapplication.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.weatherapplication.R;
import com.example.administrator.weatherapplication.weather.Weather;

import java.util.concurrent.Exchanger;

/**
 * Created by w1210 on 2016/7/26.
 */
public class WeatherView {
    private View view;//天气界面
    private Weather weather;//要显示的天气信息
    public View getView() {
        return view;
    }
    public void imgchange(ImageView img,String weather){

        switch (weather){
            case "晴":
                img.setImageResource(R.mipmap.qingtian);
                break;
            case "小雨":
                img.setImageResource(R.mipmap.xiaoyu);
                break;
            case "中雪":
                img.setImageResource(R.mipmap.xue);
                break;
            case "中雨":
                img.setImageResource(R.mipmap.zhongyu);
                break;
            case "大雨":
                img.setImageResource(R.mipmap.dayu);
                break;
            case "暴雨":
                img.setImageResource(R.mipmap.baoyu);
                break;
            case "雷阵雨":
                img.setImageResource(R.mipmap.leizhenyu);
                break;
            case "大雪":
                img.setImageResource(R.mipmap.daxue);
                break;
            case "暴雪":
                img.setImageResource(R.mipmap.daxue);
                break;
            case "多云":
                img.setImageResource(R.mipmap.duoyun);
                break;
            case "阴":
                img.setImageResource(R.mipmap.yintian);
                break;
            case "雾":
                img.setImageResource(R.mipmap.wu);
                break;
            case "大雾":
                img.setImageResource(R.mipmap.wu);
                break;
            case "小雪":
                img.setImageResource(R.mipmap.xue);
                break;
            default:
                img.setImageResource(R.mipmap.duoyun);
        }
    }
    public void temchange(TextView tem, String maxtem,String mintem){
        tem.setText(mintem+"~"+maxtem+"°");
    }
    public void datechannge(TextView day, String date){
        day.setText(date);
    }
    public void bgchange(ImageView img,TextView nowCityWeather,String city, String weather){
        nowCityWeather.setText(city+"|"+weather);
        switch (weather){
            case "晴":
                img.setImageResource(R.mipmap.bg_sunny);
                break;
            case "小雨":
                img.setImageResource(R.mipmap.bg_rain);
                break;
            case "中雪":
                img.setImageResource(R.mipmap.bg_snow);
                break;
            case "中雨":
                img.setImageResource(R.mipmap.bg_rain);
                break;
            case "大雨":
                img.setImageResource(R.mipmap.bg_rain);
                break;
            case "暴雨":
                img.setImageResource(R.mipmap.bg_rain);
                break;
            case "雷阵雨":
                img.setImageResource(R.mipmap.bg_leiyu);
                break;
            case "大雪":
                img.setImageResource(R.mipmap.bg_snow);
                break;
            case "暴雪":
                img.setImageResource(R.mipmap.bg_snow);
                break;
            case "多云":
                img.setImageResource(R.mipmap.bg_cloud);
                break;
            case "阴":
                img.setImageResource(R.mipmap.bg_yin);
                break;
            case "雾":
                img.setImageResource(R.mipmap.bg_fog);
                break;
            case "大雾":
                img.setImageResource(R.mipmap.bg_fog);
                break;
            case "小雪":
                img.setImageResource(R.mipmap.bg_snow);
                break;
            default:
                img.setImageResource(R.mipmap.bg_cloud);
        }

    }


    public WeatherView(Weather weather,Activity activity) {
        this.weather = weather;

        view= LayoutInflater.from(activity).inflate(R.layout.weather_view,null);

        TextView nowtem=(TextView)view.findViewById(R.id.nowTem);
        TextView nowCityWeather=(TextView)view.findViewById(R.id.nowCityWeather);
        TextView header_shidu=(TextView) view.findViewById(R.id.header_shidu);
        TextView header_qiya=(TextView) view.findViewById(R.id.header_qiya);
        TextView header_fengixang=(TextView) view.findViewById(R.id.header_fengixang);

        TextView header_fengli=(TextView)view.findViewById(R.id.header_fengli);
        ImageView body_imgday1=(ImageView)view.findViewById(R.id.body_imgday1);
        ImageView body_imgday2=(ImageView)view.findViewById(R.id.body_imgday2);
        ImageView body_imgday3=(ImageView)view.findViewById(R.id.body_imgday3);
        ImageView body_imgday4=(ImageView)view.findViewById(R.id.body_imgday4);
        ImageView body_imgday5=(ImageView)view.findViewById(R.id.body_imgday5);
        ImageView body_imgday6=(ImageView)view.findViewById(R.id.body_imgday6);
        ImageView body_imgday7=(ImageView)view.findViewById(R.id.body_imgday7);

        TextView body_temday1=(TextView)view.findViewById(R.id.body_temday1);
        TextView body_temday2=(TextView)view.findViewById(R.id.body_temday2);
        TextView body_temday3=(TextView)view.findViewById(R.id.body_temday3);
        TextView body_temday4=(TextView)view.findViewById(R.id.body_temday4);
        TextView body_temday5=(TextView)view.findViewById(R.id.body_temday5);
        TextView body_temday6=(TextView)view.findViewById(R.id.body_temday6);
        TextView body_temday7=(TextView)view.findViewById(R.id.body_temday7);

        TextView body_textday4=(TextView)view.findViewById(R.id.body_textday4);
        TextView body_textday5=(TextView)view.findViewById(R.id.body_textday5);
        TextView body_textday6=(TextView)view.findViewById(R.id.body_textday6);
        TextView body_textday7=(TextView)view.findViewById(R.id.body_textday7);

        TextView footer_bar_pm25=(TextView)view.findViewById(R.id.footer_bar_pm25);
        TextView footer_bar_no2=(TextView)view.findViewById(R.id.footer_bar_no2);
        TextView footer_bar_co=(TextView)view.findViewById(R.id.footer_bar_co);
        TextView footer_bar_pm10=(TextView)view.findViewById(R.id.footer_bar_PM10);
        TextView footer_bar_so2=(TextView)view.findViewById(R.id.footer_bar_so2);
        TextView footer_bar_o3=(TextView)view.findViewById(R.id.footer_bar_o3);
        TextView footer_ziwaixian=(TextView)view.findViewById(R.id.footer_ziwaixian);
        TextView footer_ziwaixianjianyi=(TextView)view.findViewById(R.id.footer_ziwaixianjianyi);

        TextView footer_lvyou=(TextView)view.findViewById(R.id.footer_lvyou);
        TextView footer_lnyoujianyi=(TextView)view.findViewById(R.id.footer_lnyoujianyi);

        TextView footer_chuanyi=(TextView)view.findViewById(R.id.footer_chuanyi);
        TextView footer_chuanyijianyi=(TextView)view.findViewById(R.id.footer_chuanyijianyi);

        TextView footer_yundong=(TextView)view.findViewById(R.id.footer_yundong);
        TextView footer_yundongjianyi=(TextView)view.findViewById(R.id.footer_yundongjianyi);
        TextView footer_xiche=(TextView)view.findViewById(R.id.footer_xiche);
        TextView footer_footer_xichejianyi=(TextView)view.findViewById(R.id.footer_xichejianyi);

        TextView footer_ganmao=(TextView)view.findViewById(R.id.footer_ganmao);
        TextView footer_ganmaojianyii=(TextView)view.findViewById(R.id.footer_ganmaojianyi);

        TextView footer_shenghuo=(TextView)view.findViewById(R.id.footer_shenghuo);
        TextView footer_shenghuojianyi=(TextView)view.findViewById(R.id.footer_shenghuojianyi);

        RelativeLayout header_bg=(RelativeLayout)view.findViewById(R.id.header_bg);





        }
    }


