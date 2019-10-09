package cn.nmmpa.token.core;

import cn.nmmpa.common.util.RsaUtil;
import cn.nmmpa.token.vo.BaseBody;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: tan shuai
 * @Date: 2019/8/24 14:37
 * @Version 1.0
 */
@Slf4j
public class TokenService implements ITokenService{


    private String publicKey;

    private String privateKey;

    private String prefix = "TOKEN";


    @Override
    public String createToken(BaseBody body) throws Exception {
        String token = null;
        try {
            token = RsaUtil.encrypt(JSONObject.toJSONString(body) , publicKey);
        }catch (Exception e){
            log.error("创建token失败:{}" , e);
            throw e;
        }
        return token;
    }

    @Override
    public BaseBody getBody(String token) throws Exception {
        BaseBody tokenBody = null;
        try {
            String decrypt = RsaUtil.decrypt(token, privateKey);
            tokenBody = JSONObject.parseObject(decrypt , BaseBody.class);
        }catch (Exception e){
            log.info("body数据获取失败:{}" , e);
            throw e;
        }
        return tokenBody;
    }


    public TokenService setPublicKey(String publicKey) {
        this.publicKey = publicKey;
        return this;
    }

    public TokenService setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
        return this;
    }

    @Override
    public TokenService setPrefix(String prefix) {
        this.prefix = prefix;
        return this;
    }

    @Override
    public String getPrefix() {
        return this.prefix;
    }


}
