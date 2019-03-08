package com.adtech.rts.util;

import com.adtech.rts.annotation.ConvertProperty;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * 数据转换util
 * 暂时只支持String类型
 */
@Component
public class EntityConvertUtil {


    /**
     * 判断字段
     *
     * @param filedName
     * @param names
     * @return
     */
    public boolean hasFiled(String filedName, Field[] names) {
        for (Field f : names) {
            if (f.getName().equals(filedName)) return true;
        }
        return false;
    }

    /**
     * 传入list
     * 转成对应clazz List
     *
     * @param list
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> List<T> convertForEntity(List list, Class<T> clazz) {
        List<T> list1 = new ArrayList<>();
        if (list1 == null) return list;
        try {
            for (int i = 0; i < list.size(); i++) {
                list1.add(canverted(list.get(i), clazz.newInstance()));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list1;
    }

    private <T> T getNewInstance(Class<T> clazz) {
        T t1 = null;
        try {
            t1 = clazz.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return t1;
    }


    /**
     * obj 转换成 t1
     *
     * @param t1
     * @param <T>
     * @return
     */
    private <T> T canverted(Object obj, T t1) throws Exception {
        Field[] T2fields = t1.getClass().getDeclaredFields();
        for (Field f : T2fields) {
            ConvertProperty property = f.getAnnotation(ConvertProperty.class);
            if (property != null) {
                if (StringUtils.isEmpty(property.columnName()))
                    InvokeUtil.invokeSet(f.getName(), InvokeUtil.invokeGet(property.columnName(), obj)
                            , t1.getClass().getDeclaredField(f.getName()), t1);
            }
        }
        return t1;
    }
}
