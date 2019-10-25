package cn.kunter.common.generator.make;

import cn.kunter.common.generator.config.PropertyHolder;
import cn.kunter.common.generator.entity.Table;
import cn.kunter.common.generator.type.JavaVisibility;
import cn.kunter.common.generator.util.DateUtil;
import cn.kunter.common.generator.util.FileUtil;
import cn.kunter.common.generator.util.JavaBeansUtil;
import cn.kunter.common.generator.util.OutputUtilities;

/**
 * @Author: tan shuai
 * @Date: 2019/7/16 13:46
 * @Version 1.0
 */
public class MakeIService {

    public static void makerIService(Table table) throws Exception {
        StringBuilder builder = new StringBuilder();
        String entityPackages = PropertyHolder.getConfigProperty("package")+".service";
        builder.append(JavaBeansUtil.getPackages(entityPackages));
        builder.append(JavaBeansUtil.getImports(PropertyHolder.getConfigProperty("package")+".model."+ table.getJavaName(), false, true));
        builder.append(JavaBeansUtil.getImports(PropertyHolder.getConfigProperty("packageBaseIService"), false, false));
        OutputUtilities.newLine(builder);
        builder.append("/**");
        OutputUtilities.newLine(builder);
        builder.append(" * @author lhm");
        OutputUtilities.newLine(builder);
        builder.append(" * @version 1.0 " + DateUtil.getSysDate());
        OutputUtilities.newLine(builder);
        builder.append(" */");

        // 类开始
        builder.append(JavaBeansUtil.getJavaBeansStart(JavaVisibility.PUBLIC.getValue(), false, false, false, true,
                false, "IBaseService<"+table.getJavaName()+">", null, "I"+table.getJavaName()+"Service", table.getRemarks()));

        OutputUtilities.newLine(builder);
        // 类结束
        builder.append(JavaBeansUtil.getJavaBeansEnd());

        // 输出文件
        FileUtil.writeFile(PropertyHolder.getConfigProperty("target") + entityPackages.replaceAll("\\.", "/") + "/"
                + "I" + table.getJavaName()+"Service.java", builder.toString());


    }
}
