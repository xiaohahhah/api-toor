package cn.nmmpa.common.util;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * Created by TS on 2019/8/27.
 */
public class MapToBeanUtil {

    /**
     * map转bean
     * @param source   map属性
     * @param instance 要转换成的备案
     * @return 该bean
     */
    public static <T> T map2Bean(Map<String, Object> source, Class<T> instance) {
        try {
            T object = instance.newInstance();
            Field[] fields = object.getClass().getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                field.set(object,source.get(field.getName()));
            }
            return object;
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
