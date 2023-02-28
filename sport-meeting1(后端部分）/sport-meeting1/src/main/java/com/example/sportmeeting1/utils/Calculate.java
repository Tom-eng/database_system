package com.example.sportmeeting1.utils;


import com.example.sportmeeting1.model.AthleteJoin;
import com.sun.org.apache.xpath.internal.objects.XObject;

import java.util.List;

//用来进行计算的工具类
public class Calculate {
    static public Integer average(List<AthleteJoin> list){
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i).getScore();
        }
        return sum / list.size();
    }
}
