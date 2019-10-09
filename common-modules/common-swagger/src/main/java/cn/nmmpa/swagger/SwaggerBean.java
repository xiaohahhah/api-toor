package cn.nmmpa.swagger;

/**
 * @Author: tan shuai
 * @Date: 2019/9/18 15:58
 * @Version 1.0
 */
public class SwaggerBean {

    /**
     *标题
     */
    private String title;
    /**
     * 版本
     */
    private String version;

    /**
     * 是否需要token（默认在header头）
     */
    private boolean isToken;

    /**
     * 包扫描路径
     */
    private String basePackage;



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public boolean getIsToken() {
        return isToken;
    }

    public void setIsToken(boolean isToken) {
        this.isToken = isToken;
    }

    public String getBasePackage() {
        return basePackage;
    }

    public void setBasePackage(String basePackage) {
        this.basePackage = basePackage;
    }
}
