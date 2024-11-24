package cn.edu.ncut.cs.springboot.springbootmybatisplus.utils;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine;

import java.util.Collections;

public class MybatisPlusGenerator {
    public static void main(String[] args) {
        String projectPath = "F:/code/github/SpringBoot/spring-boot-mybatisplus";
        String databaseUrl = "jdbc:mysql://localhost:3306/mybatis-plus-test?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&serverTimezone=UTC";
        String username = "root";
        String password = "123456";
        String author = "ncut";
        String parentPackage = "cn.edu.ncut.cs.springboot.springbootmybatisplus";
        String[] tableNames = {"address", "order", "order_item"};

        // 使用 FastAutoGenerator 配置生成器
        FastAutoGenerator.create(databaseUrl, username, password)
                // 1. 全局配置
                .globalConfig(builder -> builder
                        .author(author) // 设置作者
                        .outputDir(projectPath + "/src/main/java") // 输出目录
                        .disableOpenDir() // 禁止打开输出目录
                        .commentDate("yyyy-MM-dd") // 注释中的日期格式
                )
                // 2. 包配置
                .packageConfig(builder -> builder
                        .parent(parentPackage) // 设置父包名
                        .pathInfo(Collections.singletonMap(OutputFile.xml,
                                projectPath + "/src/main/resources/mapper")) // 设置 XML 生成路径
                )
                // 3. 策略配置
                .strategyConfig(builder -> builder
                        .addInclude(tableNames) // 设置需要生成的表
                        .addTablePrefix("") // 表名前缀过滤（这里留空）
                        .entityBuilder() // 实体类配置
                        .naming(NamingStrategy.underline_to_camel) // 数据库表名映射到实体类采用驼峰命名
                        .columnNaming(NamingStrategy.underline_to_camel) // 数据库字段名映射到属性名采用驼峰命名
                        .enableLombok() // 开启 Lombok
                        .controllerBuilder() // Controller 配置
                        .enableRestStyle() // 开启 @RestController 注解
                        .mapperBuilder() // Mapper 配置
                        .enableBaseColumnList() // 生成 BaseColumnList
                        .enableBaseResultMap() // 生成 BaseResultMap
                )
                // 4. 模板引擎配置（默认 Velocity，可选 Freemarker 或 Beetl）
                .templateEngine(new VelocityTemplateEngine())
                .execute(); // 执行生成器
    }

}
