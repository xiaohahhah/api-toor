/**
 * 
 */
package cn.kunter.common.generator.make;

import java.util.List;

import cn.kunter.common.generator.config.PackageHolder;
import cn.kunter.common.generator.config.PropertyHolder;
import cn.kunter.common.generator.entity.Column;
import cn.kunter.common.generator.entity.Table;
import cn.kunter.common.generator.type.DBType;
import cn.kunter.common.generator.util.DaoMethodNameUtil;
import cn.kunter.common.generator.util.FileUtil;
import cn.kunter.common.generator.util.OutputUtilities;

/**
 * SQLMapper生成
 * @author yangziran
 * @version 1.0 2014年11月16日
 */
public class MakeBaseXml {

    private final static boolean LOGICAL = PropertyHolder.getBooleanVal("logical");
    private final static String DB_TYPE = DBType.valueOf(PropertyHolder.getJDBCProperty("DB")).getValue();

    public static void main(String[] args) throws Exception {

        List<Table> tables = GetTableConfig.getTableConfig();

        for (final Table table : tables) {

            Thread thread = new Thread(new Runnable() {

                @Override
                public void run() {
                    try {
                        MakeBaseXml.makerBaseXml(table);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
        }
    }

    /**
     * SQLMapper生成
     * @param table
     * @throws Exception
     * @author yangziran
     */
    public static void makerBaseXml(Table table) throws Exception {

        String daoPackages = PackageHolder.getDaoPackage(table.getTableName());
        String entityPackages = PackageHolder.getEntityPackage(table.getTableName());

        String namespace = daoPackages + "." + table.getJavaName() + "Mapper";
        String type = entityPackages + "." + table.getJavaName();
        //生成表头部信息
        StringBuilder builder = new StringBuilder();
        builder.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        OutputUtilities.newLine(builder);
        builder.append(
                "<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\">");
        OutputUtilities.newLine(builder);
        builder.append("<mapper namespace=\"" + namespace + "\">");

        /** ---------- resultMap Start ---------- */
        OutputUtilities.newLine(builder);
        OutputUtilities.javaIndent(builder, 1);
        builder.append("<resultMap id=\"BaseResultMap\" type=\"" + type + "\">");
        for (Column column : table.getCols()) {
            for (Column key : table.getPrimaryKey()) {
                if (column.getJavaName().equals(key.getJavaName())) {
                    OutputUtilities.newLine(builder);
                    OutputUtilities.javaIndent(builder, 2);
                    builder.append("<id column=\"" + column.getColumnName() + "\" jdbcType=\"" + column.getSqlType()
                            + "\" property=\"" + column.getJavaName() + "\" />");
                }
            }
        }
        for (Column column : table.getCols()) {
            String tmp = null;
            for (Column key : table.getPrimaryKey()) {
                if (column.getJavaName().equals(key.getJavaName())) {
                    tmp = "id";
                }
            }
            if (tmp == null) {
                OutputUtilities.newLine(builder);
                OutputUtilities.javaIndent(builder, 2);
                builder.append("<result column=\"" + column.getColumnName() + "\" jdbcType=\"" + column.getSqlType()
                        + "\" property=\"" + column.getJavaName() + "\" />");
            }
        }
        OutputUtilities.newLine(builder);
        OutputUtilities.javaIndent(builder, 1);
        builder.append("</resultMap>");

        OutputUtilities.newLine(builder);
        OutputUtilities.javaIndent(builder, 1);

        //生成sql 对应字段
        builder.append("<sql id=\"Base_Column_List\">");
        OutputUtilities.newLine(builder);
        OutputUtilities.javaIndent(builder, 2);
        for (int i = 0; i < table.getCols().size(); i++) {
            if (i != 0) {
                builder.append(",");
                OutputUtilities.newLine(builder);
                OutputUtilities.javaIndent(builder, 2);
            }
            Column column = table.getCols().get(i);
            // builder.append(table.getAlias()).append(".");
            builder.append(column.getColumnName());
        }
        OutputUtilities.newLine(builder);
        OutputUtilities.javaIndent(builder, 1);
        builder.append("</sql>");
        //insert 新增
        insert(builder , table , type);
        //批量新增
        insertBatch(builder , table , type);


        // 有主键
        if (table.getPrimaryKey() != null && table.getPrimaryKey().size() > 0) {
            selectById(builder , table , type);
            updateById(builder , table , type);
            deleteById(builder , table , type);
        }
        queryConditionsToObject(builder , table , type);
        queryConditionsToList(builder , table , type);
        OutputUtilities.newLine(builder);
        builder.append("</mapper>");

        String baseXmlPackages = PackageHolder.getBaseXmlPackage(table.getTableName());
        FileUtil.writeFile(PropertyHolder.getConfigProperty("target") + baseXmlPackages.replaceAll("\\.", "/") + "/"
                + table.getJavaName() + "Mapper.xml", builder.toString());
    }

    /**
     * insert 新增xml
     * @param builder
     * @param table
     * @param type
     */
    public static void insert(StringBuilder builder , Table table , String type){
        OutputUtilities.newLine(builder);
        OutputUtilities.javaIndent(builder, 1);
        builder.append("<!-- 往表中插入一条数据 字段为空不插入 系统字段需要输入 -->");
        OutputUtilities.newLine(builder);
        OutputUtilities.javaIndent(builder, 1);
        builder.append("<insert id=\"").append(DaoMethodNameUtil.getInsert(!LOGICAL))
                .append("\" parameterType=\"").append(type).append("\">");
        OutputUtilities.newLine(builder);
        OutputUtilities.javaIndent(builder, 2);
        builder.append("insert into");
        OutputUtilities.newLine(builder);
        OutputUtilities.javaIndent(builder, 3);
        builder.append(table.getTableName());
        OutputUtilities.newLine(builder);
        OutputUtilities.javaIndent(builder, 2);
        builder.append("<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\">");
        for (Column column : table.getCols()) {
            OutputUtilities.newLine(builder);
            OutputUtilities.javaIndent(builder, 3);
            builder.append("<if test=\"" + column.getJavaName() + " != null\">");
            OutputUtilities.newLine(builder);
            OutputUtilities.javaIndent(builder, 4);
            builder.append(column.getColumnName() + ",");
            OutputUtilities.newLine(builder);
            OutputUtilities.javaIndent(builder, 3);
            builder.append("</if>");
        }
        OutputUtilities.newLine(builder);
        OutputUtilities.javaIndent(builder, 2);
        builder.append("</trim>");
        OutputUtilities.newLine(builder);
        OutputUtilities.javaIndent(builder, 2);
        builder.append("<trim prefix=\"values (\" suffix=\")\" suffixOverrides=\",\">");
        for (Column column : table.getCols()) {
            OutputUtilities.newLine(builder);
            OutputUtilities.javaIndent(builder, 3);
            builder.append("<if test=\"" + column.getJavaName() + " != null\">");
            OutputUtilities.newLine(builder);
            OutputUtilities.javaIndent(builder, 4);
            builder.append("#{" + column.getJavaName() + ",jdbcType=" + column.getSqlType() + "},");
            OutputUtilities.newLine(builder);
            OutputUtilities.javaIndent(builder, 3);
            builder.append("</if>");
        }
        OutputUtilities.newLine(builder);
        OutputUtilities.javaIndent(builder, 2);
        builder.append("</trim>");
        OutputUtilities.newLine(builder);
        OutputUtilities.javaIndent(builder, 1);
        builder.append("</insert>");
    }

    /**
     * 批量新增
     * @param builder
     * @param table
     * @param type
     */
    public static void insertBatch(StringBuilder builder , Table table , String type){
        OutputUtilities.newLine(builder);
        OutputUtilities.javaIndent(builder, 1);
        builder.append("<!-- 往表中批量插入数据 系统字段需要输入 -->");
        OutputUtilities.newLine(builder);
        OutputUtilities.javaIndent(builder, 1);
        builder.append("<insert id=\"").append(DaoMethodNameUtil.getInsertBatch(!LOGICAL))
                .append("\" parameterType=\"java.util.List\">");
        OutputUtilities.newLine(builder);
        OutputUtilities.javaIndent(builder, 2);
        builder.append("insert into");
        OutputUtilities.newLine(builder);
        OutputUtilities.javaIndent(builder, 3);
        builder.append(table.getTableName());
        OutputUtilities.newLine(builder);
        OutputUtilities.javaIndent(builder, 2);
        builder.append("<trim prefix=\"(\" suffix=\")\" suffixOverrides=\",\">");
        for (Column column : table.getCols()) {
            OutputUtilities.newLine(builder);
            OutputUtilities.javaIndent(builder, 3);
            builder.append(column.getColumnName() + ",");
        }
        OutputUtilities.newLine(builder);
        OutputUtilities.javaIndent(builder, 2);
        builder.append("</trim>");
        OutputUtilities.newLine(builder);
        OutputUtilities.javaIndent(builder, 2);
        builder.append(
                "<foreach collection=\"list\" item=\"item\" open=\"values (\" close=\")\" separator=\" ), ( \">");
        OutputUtilities.newLine(builder);
        OutputUtilities.javaIndent(builder, 3);
        builder.append("<trim suffixOverrides=\",\">");
        for (Column column : table.getCols()) {
            OutputUtilities.newLine(builder);
            OutputUtilities.javaIndent(builder, 4);
            builder.append("#{item." + column.getJavaName() + ",jdbcType=" + column.getSqlType() + "},");
        }
        OutputUtilities.newLine(builder);
        OutputUtilities.javaIndent(builder, 3);
        builder.append("</trim>");
        OutputUtilities.newLine(builder);
        OutputUtilities.javaIndent(builder, 2);
        builder.append("</foreach>");
        OutputUtilities.newLine(builder);
        OutputUtilities.javaIndent(builder, 1);
        builder.append("</insert>");
    }

    /**
     * 按id查询
     * @param builder
     * @param table
     * @param type
     */
    public static void selectById(StringBuilder builder , Table table , String type){
        OutputUtilities.newLine(builder);
        OutputUtilities.javaIndent(builder, 1);
        builder.append("<!-- 根据主键查询数据 所有数据 -->");
        OutputUtilities.newLine(builder);
        OutputUtilities.javaIndent(builder, 1);
        builder.append("<select id=\"").append(DaoMethodNameUtil.getSelectById(!LOGICAL))
                .append("\" parameterType=\""+PropertyHolder.getConfigProperty("primary_key_type")+"\" resultMap=\"BaseResultMap\">");
        OutputUtilities.newLine(builder);
        OutputUtilities.javaIndent(builder, 2);
        builder.append("select");
        OutputUtilities.newLine(builder);
        OutputUtilities.javaIndent(builder, 3);
        builder.append("<include refid=\"Base_Column_List\" />");
        OutputUtilities.newLine(builder);
        OutputUtilities.javaIndent(builder, 2);
        builder.append("from");
        OutputUtilities.newLine(builder);
        OutputUtilities.javaIndent(builder, 3);
        builder.append(table.getTableName());
        // builder.append(" ").append(table.getAlias());
        OutputUtilities.newLine(builder);
        OutputUtilities.javaIndent(builder, 2);
        builder.append("where");
        OutputUtilities.newLine(builder);
        OutputUtilities.javaIndent(builder, 3);
        for (int i = 0; i < table.getPrimaryKey().size(); i++) {
            Column column = table.getPrimaryKey().get(i);
            // builder.append(table.getAlias()).append(".");
            builder.append(column.getColumnName()).append(" = #{").append(column.getJavaName()).append("}");
        }
        OutputUtilities.newLine(builder);
        OutputUtilities.javaIndent(builder, 1);
        builder.append("</select>");
    }

    public static void updateById(StringBuilder builder , Table table , String type){
        OutputUtilities.newLine(builder);
        OutputUtilities.javaIndent(builder, 1);
        builder.append("<!-- 根据主键修改数据 字段为空不修改 所有数据 -->");
        OutputUtilities.newLine(builder);
        OutputUtilities.javaIndent(builder, 1);
        builder.append("<update id=\"").append(DaoMethodNameUtil.getUpdateByPrimaryKeySelective(!LOGICAL))
                .append("\" parameterType=\"").append(type).append("\">");
        OutputUtilities.newLine(builder);
        OutputUtilities.javaIndent(builder, 2);
        builder.append("update");
        OutputUtilities.newLine(builder);
        OutputUtilities.javaIndent(builder, 3);
        builder.append(table.getTableName());
        // builder.append(" ").append(table.getAlias());
        OutputUtilities.newLine(builder);
        OutputUtilities.javaIndent(builder, 2);
        builder.append("<set>");
        for (Column column : table.getCols()) {
            if (!column.getColumnName().equals("create_date") && !column.getColumnName().equals("create_user_id")) {
                OutputUtilities.newLine(builder);
                OutputUtilities.javaIndent(builder, 3);
                if (column.getColumnName().equals("update_date")) {
                    // builder.append(table.getAlias()).append(".");
                    builder.append(column.getColumnName()).append(" = ");
                    if (DB_TYPE.equals(DBType.ORACLE.getValue())) {
                        builder.append("sysdate,");
                    }
                    else if (DB_TYPE.equals(DBType.MYSQL.getValue())) {
                        builder.append("sysdate(),");
                    }
                    else if (DB_TYPE.equals(DBType.POSTGRESQL.getValue())) {
                        builder.append("now(),");
                    }
                }
                else if (column.getColumnName().equals("update_user_id")) {
                    // builder.append(table.getAlias()).append(".");
                    builder.append(column.getColumnName() + " = #{" + column.getJavaName() + ",jdbcType="
                            + column.getSqlType() + "},");
                }
                else {
                    builder.append("<if test=\"" + column.getJavaName() + " != null\">");
                    OutputUtilities.newLine(builder);
                    OutputUtilities.javaIndent(builder, 4);
                    // builder.append(table.getAlias()).append(".");
                    builder.append(column.getColumnName() + " = #{" + column.getJavaName() + ",jdbcType="
                            + column.getSqlType() + "},");
                    OutputUtilities.newLine(builder);
                    OutputUtilities.javaIndent(builder, 3);
                    builder.append("</if>");
                }
            }
        }
        OutputUtilities.newLine(builder);
        OutputUtilities.javaIndent(builder, 2);
        builder.append("</set>");
        OutputUtilities.newLine(builder);
        OutputUtilities.javaIndent(builder, 2);
        builder.append("where");
        OutputUtilities.newLine(builder);
        OutputUtilities.javaIndent(builder, 3);
        for (int i = 0; i < table.getPrimaryKey().size(); i++) {
            Column column = table.getPrimaryKey().get(i);
            // builder.append(table.getAlias()).append(".");
            builder.append(column.getColumnName()).append(" = #{").append(column.getJavaName()).append(",jdbcType=")
                    .append(column.getSqlType()).append("}");
        }
        OutputUtilities.newLine(builder);
        OutputUtilities.javaIndent(builder, 1);
        builder.append("</update>");
    }

    public static void deleteById(StringBuilder builder , Table table , String type){
        OutputUtilities.newLine(builder);
        OutputUtilities.javaIndent(builder, 1);
        builder.append("<!-- 根据主键删除数据 物理删除 -->");
        OutputUtilities.newLine(builder);
        OutputUtilities.javaIndent(builder, 1);
        builder.append("<delete id=\"").append(DaoMethodNameUtil.getDeleteByPrimaryKey(!LOGICAL))
                .append("\" parameterType=\""+PropertyHolder.getConfigProperty("primary_key_type")+"\">");
        OutputUtilities.newLine(builder);
        OutputUtilities.javaIndent(builder, 2);
        builder.append("delete from");
        OutputUtilities.newLine(builder);
        OutputUtilities.javaIndent(builder, 3);
        builder.append(table.getTableName());
        OutputUtilities.newLine(builder);
        OutputUtilities.javaIndent(builder, 2);
        builder.append("where");
        OutputUtilities.newLine(builder);
        OutputUtilities.javaIndent(builder, 3);
        for (int i = 0; i < table.getPrimaryKey().size(); i++) {
            Column column = table.getPrimaryKey().get(i);
            builder.append(column.getColumnName()).append(" = #{").append(column.getJavaName()).append("}");
        }
        OutputUtilities.newLine(builder);
        OutputUtilities.javaIndent(builder, 1);
        builder.append("</delete>");
    }

    public static void queryConditionsToObject(StringBuilder builder , Table table , String type){
        OutputUtilities.newLine(builder);
        OutputUtilities.javaIndent(builder, 1);
        builder.append("<!-- 按条件查询 对象 -->");
        OutputUtilities.newLine(builder);
        OutputUtilities.javaIndent(builder, 1);
        builder.append("<select id=\"").append("queryConditionsToObject")
                .append("\" parameterType=\""+type+"\" resultMap=\"BaseResultMap\">");
        OutputUtilities.newLine(builder);
        OutputUtilities.javaIndent(builder, 2);
        builder.append("select");
        OutputUtilities.newLine(builder);
        OutputUtilities.javaIndent(builder, 3);
        builder.append("<include refid=\"Base_Column_List\" />");
        OutputUtilities.newLine(builder);
        OutputUtilities.javaIndent(builder, 2);
        builder.append("from");
        OutputUtilities.newLine(builder);
        OutputUtilities.javaIndent(builder, 3);
        builder.append(table.getTableName());
        // builder.append(" ").append(table.getAlias());
        OutputUtilities.newLine(builder);
        OutputUtilities.javaIndent(builder, 2);
        builder.append("<where>");
        for (Column column : table.getCols()) {
            if (!column.getColumnName().equals("create_date") && !column.getColumnName().equals("create_user_id")) {
                OutputUtilities.newLine(builder);
                OutputUtilities.javaIndent(builder, 3);
                if (column.getColumnName().equals("update_date")) {
                    // builder.append(table.getAlias()).append(".");
                    builder.append(column.getColumnName()).append(" = ");
                    if (DB_TYPE.equals(DBType.ORACLE.getValue())) {
                        builder.append("sysdate,");
                    }
                    else if (DB_TYPE.equals(DBType.MYSQL.getValue())) {
                        builder.append("sysdate(),");
                    }
                    else if (DB_TYPE.equals(DBType.POSTGRESQL.getValue())) {
                        builder.append("now(),");
                    }
                }
                else if (column.getColumnName().equals("update_user_id")) {
                    // builder.append(table.getAlias()).append(".");
                    builder.append(column.getColumnName() + " = #{" + column.getJavaName() + ",jdbcType="
                            + column.getSqlType() + "}");
                }
                else {
                    builder.append("<if test=\"" + column.getJavaName() + " != null\">");
                    OutputUtilities.newLine(builder);
                    OutputUtilities.javaIndent(builder, 4);
                    // builder.append(table.getAlias()).append(".");
                    builder.append(" AND ");
                    builder.append(column.getColumnName() + " = #{" + column.getJavaName() + ",jdbcType="
                            + column.getSqlType() + "}");
                    OutputUtilities.newLine(builder);
                    OutputUtilities.javaIndent(builder, 3);
                    builder.append("</if>");
                }
            }
        }
        OutputUtilities.newLine(builder);
        OutputUtilities.javaIndent(builder, 2);
        builder.append("</where>");
        OutputUtilities.newLine(builder);
        OutputUtilities.javaIndent(builder, 1);
        builder.append("</select>");
    }

    public static void queryConditionsToList(StringBuilder builder , Table table , String type){
        OutputUtilities.newLine(builder);
        OutputUtilities.javaIndent(builder, 1);
        builder.append("<!-- 按条件查询 对象 -->");
        OutputUtilities.newLine(builder);
        OutputUtilities.javaIndent(builder, 1);
        builder.append("<select id=\"").append("queryConditionsToList")
                .append("\" parameterType=\""+type+"\" resultMap=\"BaseResultMap\">");
        OutputUtilities.newLine(builder);
        OutputUtilities.javaIndent(builder, 2);
        builder.append("select");
        OutputUtilities.newLine(builder);
        OutputUtilities.javaIndent(builder, 3);
        builder.append("<include refid=\"Base_Column_List\" />");
        OutputUtilities.newLine(builder);
        OutputUtilities.javaIndent(builder, 2);
        builder.append("from");
        OutputUtilities.newLine(builder);
        OutputUtilities.javaIndent(builder, 3);
        builder.append(table.getTableName());
        // builder.append(" ").append(table.getAlias());
        OutputUtilities.newLine(builder);
        OutputUtilities.javaIndent(builder, 2);
        builder.append("<where>");
        for (Column column : table.getCols()) {
            if (!column.getColumnName().equals("create_date") && !column.getColumnName().equals("create_user_id")) {
                OutputUtilities.newLine(builder);
                OutputUtilities.javaIndent(builder, 3);
                if (column.getColumnName().equals("update_date")) {
                    // builder.append(table.getAlias()).append(".");
                    builder.append(column.getColumnName()).append(" = ");
                    if (DB_TYPE.equals(DBType.ORACLE.getValue())) {
                        builder.append("sysdate,");
                    }
                    else if (DB_TYPE.equals(DBType.MYSQL.getValue())) {
                        builder.append("sysdate(),");
                    }
                    else if (DB_TYPE.equals(DBType.POSTGRESQL.getValue())) {
                        builder.append("now(),");
                    }
                }
                else if (column.getColumnName().equals("update_user_id")) {
                    // builder.append(table.getAlias()).append(".");
                    builder.append(column.getColumnName() + " = #{" + column.getJavaName() + ",jdbcType="
                            + column.getSqlType() + "}");
                }
                else {
                    builder.append("<if test=\"" + column.getJavaName() + " != null\">");
                    OutputUtilities.newLine(builder);
                    OutputUtilities.javaIndent(builder, 4);
                    // builder.append(table.getAlias()).append(".");
                    builder.append(" AND ");
                    builder.append(column.getColumnName() + " = #{" + column.getJavaName() + ",jdbcType="
                            + column.getSqlType() + "}");
                    OutputUtilities.newLine(builder);
                    OutputUtilities.javaIndent(builder, 3);
                    builder.append("</if>");
                }
            }
        }
        OutputUtilities.newLine(builder);
        OutputUtilities.javaIndent(builder, 2);
        builder.append("</where>");
        OutputUtilities.newLine(builder);
        OutputUtilities.javaIndent(builder, 1);
        builder.append("</select>");
    }
}
