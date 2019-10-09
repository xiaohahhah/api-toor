package cn.kunter.common.generator.make;

import cn.kunter.common.generator.config.PackageHolder;
import cn.kunter.common.generator.config.PropertyHolder;
import cn.kunter.common.generator.entity.Table;
import cn.kunter.common.generator.type.JavaVisibility;
import cn.kunter.common.generator.util.DateUtil;
import cn.kunter.common.generator.util.FileUtil;
import cn.kunter.common.generator.util.JavaBeansUtil;
import cn.kunter.common.generator.util.OutputUtilities;

/**
 * @Author: tan shuai
 * @Date: 2019/7/16 10:41
 * @Version 1.0
 */
public class MakeMapper {


    public static void makerMapper(Table table) throws Exception {
        StringBuilder builder = new StringBuilder();
        String entityPackages = PropertyHolder.getConfigProperty("package")+".mapper";
        builder.append(JavaBeansUtil.getPackages(entityPackages));
        builder.append(JavaBeansUtil.getImports(PropertyHolder.getConfigProperty("package")+".model."+ table.getJavaName(), false, true));
        builder.append(JavaBeansUtil.getImports("org.apache.ibatis.annotations.Mapper", false, false));
        builder.append(JavaBeansUtil.getImports("org.springframework.stereotype.Repository", false, false));
        builder.append(JavaBeansUtil.getImports(PropertyHolder.getConfigProperty("packageBaseMapper"), false, false));
        OutputUtilities.newLine(builder);
        builder.append("/**");
        OutputUtilities.newLine(builder);
        builder.append(" * @author TanShuai");
        OutputUtilities.newLine(builder);
        builder.append(" * @version 1.0 " + DateUtil.getSysDate());
        OutputUtilities.newLine(builder);
        builder.append(" */");
        OutputUtilities.newLine(builder);
        builder.append("@Repository");
        OutputUtilities.newLine(builder);
        builder.append("@Mapper");

        // 类开始
        builder.append(JavaBeansUtil.getJavaBeansStart(JavaVisibility.PUBLIC.getValue(), false, false, false, true,
                false, "BaseMapper<"+table.getJavaName()+">", null, table.getJavaName()+"Mapper", table.getRemarks()));

        OutputUtilities.newLine(builder);
        // 类结束
        builder.append(JavaBeansUtil.getJavaBeansEnd());

        // 输出文件
        FileUtil.writeFile(PropertyHolder.getConfigProperty("target") + entityPackages.replaceAll("\\.", "/") + "/"
                + table.getJavaName()+"Mapper.java", builder.toString());


    }
}
