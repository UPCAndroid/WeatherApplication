package com.example.administrator.weatherapplication.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.weatherapplication.R;
import com.example.administrator.weatherapplication.weather.Weather;

/**
 * Created by w1210 on 2016/7/26.
 */
public class WeatherView {
    private View view;//天气界面
    private Weather weather;//要显示的天气信息
    public View getView() {
        return view;
    }
    public void Imgchange(ImageView img,String weather){

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


    public void Bgchange(ImageView img, String weather){

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
            case "阵雨":
                img.setImageResource(R.mipmap.bg_rain);
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
    public String IfIsNull(String str){
        if(str==null){
            return "暂无数据";
        }else{
            return str;
        }
    }

    public WeatherView(Weather weather,Activity activity) {
        this.weather = weather;

        view= LayoutInflater.from(activity).inflate(R.layout.weather_view,null);

        TextView nowtem=(TextView)view.findViewById(R.id.nowTem);
        nowtem.setText(weather.results.get(0).now.tmp+"°");
        TextView nowCityWeather=(TextView)view.findViewById(R.id.nowCityWeather);
        nowCityWeather.setText(weather.results.get(0).basic.city+"|"+weather.results.get(0).now.cond.txt);
        TextView header_shidu=(TextView) view.findViewById(R.id.header_shidu);
        header_shidu.setText(weather.results.get(0).now.hum);
        TextView header_qiya=(TextView) view.findViewById(R.id.header_qiya);

        header_qiya.setText(weather.results.get(0).now.pres+"hpa");
        TextView header_fengixang=(TextView) view.findViewById(R.id.header_fengixang);
        header_fengixang.setText(weather.results.get(0).now.wind.dir);

        TextView header_fengli=(TextView)view.findViewById(R.id.header_fengli);
        header_fengli.setText(weather.results.get(0).now.wind.sc);
        ImageView body_imgday1=(ImageView)view.findViewById(R.id.body_imgday1);
        Imgchange(body_imgday1,weather.results.get(0).now.cond.txt);
        ImageView body_imgday2=(ImageView)view.findViewById(R.id.body_imgday2);
        Imgchange(body_imgday2,weather.results.get(0).daily_forecast.get(1).cond.txt_d);
        ImageView body_imgday3=(ImageView)view.findViewById(R.id.body_imgday3);
        Imgchange(body_imgday3,weather.results.get(0).daily_forecast.get(2).cond.txt_d);
        ImageView body_imgday4=(ImageView)view.findViewById(R.id.body_imgday4);
        Imgchange(body_imgday4,weather.results.get(0).daily_forecast.get(3).cond.txt_d);
        ImageView body_imgday5=(ImageView)view.findViewById(R.id.body_imgday5);
        Imgchange(body_imgday5,weather.results.get(0).daily_forecast.get(4).cond.txt_d);
        ImageView body_imgday6=(ImageView)view.findViewById(R.id.body_imgday6);
        Imgchange(body_imgday6,weather.results.get(0).daily_forecast.get(5).cond.txt_d);
        ImageView body_imgday7=(ImageView)view.findViewById(R.id.body_imgday7);
        Imgchange(body_imgday7,weather.results.get(0).daily_forecast.get(6).cond.txt_d);
        TextView body_temday1=(TextView)view.findViewById(R.id.body_temday1);
        body_temday1.setText(weather.results.get(0).daily_forecast.get(0).tmp.min+"~"+weather.results.get(0).daily_forecast.get(0).tmp.max+"°");
        TextView body_temday2=(TextView)view.findViewById(R.id.body_temday2);
        body_temday2.setText(weather.results.get(0).daily_forecast.get(1).tmp.min+"~"+weather.results.get(0).daily_forecast.get(1).tmp.max+"°");
        TextView body_temday3=(TextView)view.findViewById(R.id.body_temday3);
        body_temday3.setText(weather.results.get(0).daily_forecast.get(2).tmp.min+"~"+weather.results.get(0).daily_forecast.get(2).tmp.max+"°");
        TextView body_temday4=(TextView)view.findViewById(R.id.body_temday4);
        body_temday4.setText(weather.results.get(0).daily_forecast.get(3).tmp.min+"~"+weather.results.get(0).daily_forecast.get(3).tmp.max+"°");
        TextView body_temday5=(TextView)view.findViewById(R.id.body_temday5);
        body_temday5.setText(weather.results.get(0).daily_forecast.get(4).tmp.min+"~"+weather.results.get(0).daily_forecast.get(4).tmp.max+"°");
        TextView body_temday6=(TextView)view.findViewById(R.id.body_temday6);
        body_temday6.setText(weather.results.get(0).daily_forecast.get(5).tmp.min+"~"+weather.results.get(0).daily_forecast.get(5).tmp.max+"°");
        TextView body_temday7=(TextView)view.findViewById(R.id.body_temday7);
        body_temday7.setText(weather.results.get(0).daily_forecast.get(6).tmp.min+"~"+weather.results.get(0).daily_forecast.get(6).tmp.max+"°");
        TextView body_textday4=(TextView)view.findViewById(R.id.body_textday4);
        body_textday4.setText(weather.results.get(0).daily_forecast.get(3).date.replace("2016-","").replace("-","月")+"日");
        TextView body_textday5=(TextView)view.findViewById(R.id.body_textday5);
        body_textday5.setText(weather.results.get(0).daily_forecast.get(4).date.replace("2016-","").replace("-","月")+"日");
        TextView body_textday6=(TextView)view.findViewById(R.id.body_textday6);
        body_textday6.setText(weather.results.get(0).daily_forecast.get(5).date.replace("2016-","").replace("-","月")+"日");
        TextView body_textday7=(TextView)view.findViewById(R.id.body_textday7);
        body_textday7.setText(weather.results.get(0).daily_forecast.get(6).date.replace("2016-","").replace("-","月")+"日");

        /*body_bar_star*/
        TextView footer_bar_pm25=(TextView)view.findViewById(R.id.footer_bar_pm25);
        footer_bar_pm25.setText(  IfIsNull(weather.results.get(0).aqi.city.pm25 ) );

        TextView footer_bar_no2=(TextView)view.findViewById(R.id.footer_bar_no2);
        footer_bar_no2.setText( IfIsNull(  weather.results.get(0).aqi.city.no2) );

        TextView footer_bar_co=(TextView)view.findViewById(R.id.footer_bar_co);
        footer_bar_co.setText( IfIsNull(  weather.results.get(0).aqi.city.co ));

        TextView footer_bar_pm10=(TextView)view.findViewById(R.id.footer_bar_PM10);
        footer_bar_pm10.setText( IfIsNull( weather.results.get(0).aqi.city.pm10) );

        TextView footer_bar_so2=(TextView)view.findViewById(R.id.footer_bar_so2);
        footer_bar_so2.setText( IfIsNull( weather.results.get(0).aqi.city.so2) );

        TextView footer_bar_o3=(TextView)view.findViewById(R.id.footer_bar_o3);
        footer_bar_o3.setText( IfIsNull( weather.results.get(0).aqi.city.o3) );
        /*body_bar_end*/
        TextView footer_ziwaixian=(TextView)view.findViewById(R.id.footer_ziwaixian);
        footer_ziwaixian.setText(weather.results.get(0).suggestion.uv.brf);
        TextView footer_ziwaixianjianyi=(TextView)view.findViewById(R.id.footer_ziwaixianjianyi);
        footer_ziwaixianjianyi.setText(weather.results.get(0).suggestion.uv.txt);

        TextView footer_lvyou=(TextView)view.findViewById(R.id.footer_lvyou);
        footer_lvyou.setText(weather.results.get(0).suggestion.trav.brf);
        TextView footer_lnyoujianyi=(TextView)view.findViewById(R.id.footer_lnyoujianyi);
        footer_lnyoujianyi.setText(weather.results.get(0).suggestion.trav.txt);
        TextView footer_chuanyi=(TextView)view.findViewById(R.id.footer_chuanyi);
        footer_chuanyi.setText(weather.results.get(0).suggestion.drsg.brf);
        TextView footer_chuanyijianyi=(TextView)view.findViewById(R.id.footer_chuanyijianyi);
        footer_chuanyijianyi.setText(weather.results.get(0).suggestion.drsg.txt);

        TextView footer_yundong=(TextView)view.findViewById(R.id.footer_yundong);
        footer_yundong.setText(weather.results.get(0).suggestion.sport.brf);
        TextView footer_yundongjianyi=(TextView)view.findViewById(R.id.footer_yundongjianyi);
        footer_yundongjianyi.setText(weather.results.get(0).suggestion.sport.txt);
        TextView footer_xiche=(TextView)view.findViewById(R.id.footer_xiche);
        footer_xiche.setText(weather.results.get(0).suggestion.cw.brf);
        TextView footer_footer_xichejianyi=(TextView)view.findViewById(R.id.footer_xichejianyi);
        footer_footer_xichejianyi.setText(weather.results.get(0).suggestion.cw.txt);
        TextView footer_ganmao=(TextView)view.findViewById(R.id.footer_ganmao);
        footer_ganmao.setText(weather.results.get(0).suggestion.flu.brf);
        TextView footer_ganmaojianyii=(TextView)view.findViewById(R.id.footer_ganmaojianyi);
        footer_ganmaojianyii.setText(weather.results.get(0).suggestion.flu.txt);
        TextView footer_shenghuo=(TextView)view.findViewById(R.id.footer_shenghuo);
        footer_shenghuo.setText(weather.results.get(0).suggestion.comf.brf);
        TextView footer_shenghuojianyi=(TextView)view.findViewById(R.id.footer_shenghuojianyi);
        footer_shenghuojianyi.setText(weather.results.get(0).suggestion.comf.txt);
        ImageView header_bg=(ImageView)view.findViewById(R.id.header_bg);
        Bgchange(header_bg,weather.results.get(0).now.cond.txt);

        //weatherText.setText(weather.results.get(0).status);
        //cityText.setText(weather.getCity());

        /*switch (weather.getWeather()) {
            case "晴天":
                img.setImageResource(R.mipmap.qingtian);
                bg.setBackgroundResource(R.mipmap.);
                break;
            case "小雨":
                img.setImageResource(R.mipmap.wip_rain);
                bg.setBackgroundResource(R.mipmap.wip_bk_thunderstorm);
                break;
            case "中雪":
                img.setImageResource(R.mipmap.wip_snow);
                bg.setBackgroundResource(R.mipmap.wip_bk_storm_snow);
                break;
            case "多云":
                img.setImageResource(R.mipmap.wip_cloudy);
                bg.setBackgroundResource(R.mipmap.wip_bk_coludy);
                break;
        }*/
    }


}