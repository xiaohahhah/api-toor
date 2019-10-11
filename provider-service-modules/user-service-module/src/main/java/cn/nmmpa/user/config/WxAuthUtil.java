package cn.nmmpa.user.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @author lhm
 * @date 2019/10/11 11:47
 **/
public class WxAuthUtil {


    public static final String APPID="wx9b39273dce55dc2f";
    public static final String APPSECRET ="06f175852111045f81ebf62db28a44a0";
    private static final String TOKEN = "immco";


    public static JSONObject doGetJson(String url) throws Exception{
        JSONObject jsonObject =null;
        DefaultHttpClient client = new DefaultHttpClient();
        HttpGet httpGet =new HttpGet(url);
        HttpResponse response = client.execute(httpGet);
        HttpEntity entity = response.getEntity();
        if(entity!=null){
            //把返回的结果转换为JSON对象
        String result = EntityUtils.toString(entity, "UTF-8");
        jsonObject = JSON.parseObject(result);
        }
        return jsonObject;
    }
}
