package com.zhuoqitech.timetravel.gaea.web.mpgenerator;

/**
 * @Author: renzhengbin
 * @Date: 19/6/12 18:43
 * @Version 1.0
 */
public class BingGenerator {

    public static void main(String[] args) {
        //作者
        String author = "jianbingbing";
        //文件目录
        final String dir = "blacklist";
        //本地项目路径
        String project_url = System.getProperty("user.dir");
        System.out.println(project_url);
        //前缀
        String tablePrefix = "";
        //表名
        String[] table_names = new String[]{"blacklist"};
        boolean isNeedController = false;
        boolean isNeedService = false;

        for (String table_name : table_names) {
            Generator.doGenerator(author, dir, project_url, tablePrefix, table_name, isNeedController, isNeedService);
        }

    }

}
