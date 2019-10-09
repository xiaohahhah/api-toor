package cn.nmmpa.common.util;

import java.util.Random;
import java.util.UUID;

/**
 * @Author: tan shuai
 * @Date: 2019/9/19 9:25
 * @Version 1.0
 */
public class StringUtil {

    /**
     * 生成随机数字和字母
     * @param length
     * @return
     */
    public static String getStringRandom(int length) {

        String val = "";
        Random random = new Random();
        //length为几位密码
        for(int i = 0; i < length; i++) {
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            //输出字母还是数字
            if( "char".equalsIgnoreCase(charOrNum) ) {
                //输出是大写字母还是小写字母
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val += (char)(random.nextInt(26) + temp);
            } else if( "num".equalsIgnoreCase(charOrNum) ) {
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }

    /**
     * uuid 生成
     * @return
     */
    public static String uuid(){
        return UUID.randomUUID().toString()
                .replace("-" , "");
    }
}
