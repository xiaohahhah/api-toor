/**
 * 
 */
package cn.kunter.common.generator.main;

import java.util.List;

import cn.kunter.common.generator.entity.Table;
import cn.kunter.common.generator.make.*;

/**
 * @author yangziran
 * @version 1.0 2014年10月20日
 */
public class GeneratorService {

    public static void main(String[] args) throws Exception {

        List<Table> tables = GetTableConfig.getTableConfig();

        for (final Table table : tables) {
            Thread thread = new Thread(new Runnable() {

                @Override
                public void run() {
                    try {
                        MakeEntity.makerEntity(table);
                        MakeBaseXml.makerBaseXml(table);
                        MakeMapper.makerMapper(table);
                        MakeIService.makerIService(table);
                        MakeIServiceImpl.makerIServiceImpl(table);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
            thread.start();
        }
        MakeMyBatisConfig.makerMyBatisConfig(tables);
    }
}