package cn.kunter.common.generator.make;

import cn.kunter.common.generator.config.PropertyHolder;
import cn.kunter.common.generator.entity.Table;
import cn.kunter.common.generator.type.JavaVisibility;
import cn.kunter.common.generator.util.*;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: tan shuai
 * @Date: 2019/7/16 13:54
 * @Version 1.0
 */
public class MakeIServiceImpl {

    public static void makerIServiceImpl(Table table) throws Exception {
        StringBuilder builder = new StringBuilder();
        String entityPackages = PropertyHolder.getConfigProperty("package")+".service.impl";
        String mapper = table.getJavaName()+"Mapper";
        builder.append(JavaBeansUtil.getPackages(entityPackages));
        builder.append(JavaBeansUtil.getImports(PropertyHolder.getConfigProperty("package")+".model."+ table.getJavaName(), false, true));
        builder.append(JavaBeansUtil.getImports(PropertyHolder.getConfigProperty("package")+".service.I"+table.getJavaName()+"Service", false, false));
        builder.append(JavaBeansUtil.getImports(PropertyHolder.getConfigProperty("packageBaseIServiceImpl"), false, false));
        builder.append(JavaBeansUtil.getImports("org.springframework.stereotype.Service", false, false));
        builder.append(JavaBeansUtil.getImports("org.springframework.beans.factory.annotation.Autowired", false, false));
        builder.append(JavaBeansUtil.getImports(PropertyHolder.getConfigProperty("package")+".mapper."+table.getJavaName()+"Mapper", false, false));
        OutputUtilities.newLine(builder);
        builder.append("/**");
        OutputUtilities.newLine(builder);
        builder.append(" * @author TanShuai");
        OutputUtilities.newLine(builder);
        builder.append(" * @version 1.0 " + DateUtil.getSysDate());
        OutputUtilities.newLine(builder);
        builder.append(" */");
        OutputUtilities.newLine(builder);
        builder.append("@Service");

        // 类开始
        builder.append(JavaBeansUtil.getJavaBeansStart(JavaVisibility.PUBLIC.getValue(), false, false, false, false,
                true, "BaseServiceImpl<"+table.getJavaName()+"Mapper , "+table.getJavaName()+">", Arrays.asList(new String[]{"I" + table.getJavaName() + "Service"}), table.getJavaName()+"ServiceImpl", table.getRemarks()));

        OutputUtilities.newLine(builder);

        builder.append("    @Autowired");
        OutputUtilities.newLine(builder);
        builder.append("    private ")
                .append(mapper)
                .append(" ")
                .append(StringUtility.uncapitalize(mapper))
                .append(";");
        OutputUtilities.newLine(builder);
        OutputUtilities.newLine(builder);

        builder.append("    @Override");
        OutputUtilities.newLine(builder);
        builder.append("    public ")
                .append(mapper)
                .append(" getMapper()")
                .append("{ \n")
                .append("       return ")
                .append(StringUtility.uncapitalize(mapper))
                .append(";\n")
                .append("    }");

        OutputUtilities.newLine(builder);

        // 类结束
        builder.append(JavaBeansUtil.getJavaBeansEnd());

        // 输出文件
        FileUtil.writeFile(PropertyHolder.getConfigProperty("target") + entityPackages.replaceAll("\\.", "/") + "/"
                + table.getJavaName()+"ServiceImpl.java", builder.toString());


    }
}
