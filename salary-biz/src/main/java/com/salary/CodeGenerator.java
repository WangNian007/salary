package com.salary;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;

import java.nio.file.Paths;
import java.util.Collections;

public class CodeGenerator {
    public static void main(String[] args) {

        String username = args[0];

        String password = args[1];

        System.out.println(Paths.get(System.getProperty("user.dir")) + "/salary-biz/src/main/java");
        FastAutoGenerator.create("jdbc:mysql://192.168.1.110:3306/salary", username, password)
                .globalConfig(builder -> builder
                        .author("wangnian")
                        .outputDir(Paths.get(System.getProperty("user.dir")) + "/salary-biz/src/main/java")
                        .commentDate("yyyy-MM-dd")
                )
                .packageConfig(builder -> builder
                        .parent("com.salary")
                        .entity("entity")
                        .mapper("mapper")
                        .service("service")
                        .serviceImpl("service.impl")
                        .pathInfo(Collections.singletonMap(OutputFile.xml, Paths.get(System.getProperty("user.dir")) + "/salary-biz/src/main/resources/mapper")) // 设置mapperXml生成路径

                )
                .strategyConfig(builder -> builder
                        .entityBuilder()
                        .enableLombok()
                )
                .execute();


    }
}
