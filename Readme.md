# 生成java文件
[![Build Status](https://travis-ci.org/fartherp/javacode.svg?branch=master)](https://travis-ci.org/fartherp/javacode)
[![Coverage Status](https://coveralls.io/repos/github/fartherp/javacode/badge.svg?branch=master)](https://coveralls.io/github/fartherp/javacode?branch=master)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.fartherp/javacode/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.fartherp/javacode/)
[![Sonatype Nexus (Snapshots)](https://img.shields.io/nexus/s/https/oss.sonatype.org/com.github.fartherp/javacode.svg)](https://oss.sonatype.org/content/repositories/snapshots/com/github/fartherp/javacode)
[![GitHub release](https://img.shields.io/github/release/fartherp/javacode.svg)](https://github.com/fartherp/javacode/releases)
[![License](https://img.shields.io/badge/license-Apache%202-4EB1BA.svg)](https://www.apache.org/licenses/LICENSE-2.0.html)
[![Project Stats](https://www.openhub.net/p/fartherp-javacode/widgets/project_thin_badge.gif)](https://www.openhub.net/p/fartherp-javacode)

## java类型类
```
JavaTypeInfo javaTypeInfo = new JavaTypeInfo("java.lang.Integer");
```

## JavaElement
java公用信息
1. 注释: addJavaDocLine("This class corresponds to the database table `tb_alarm`");
2. 注解: addAnnotation("@Bean");
3. 作用域: setJavaScope(JavaKeywords.PUBLIC);
4. final: setFinal(boolean isFinal);
5. static: setStatic(boolean isStatic);

## Field(字段)
1. 实例: Field field = new Field("age", new JavaTypeInfo("java.lang.Integer"));
2. 初始值: setInitializationString(String initializationString);
3. transient: setTransient(boolean transient);
4. volatile: setVolatile(boolean volatile);
### Sample Code
```
JavaTypeInfo javaTypeInfo = new JavaTypeInfo("java.lang.Integer");
Field field = new Field("age", javaTypeInfo);
String fieldStr = field.getFormattedContent(1);
```
结果: Integer age;
```
JavaTypeInfo javaTypeInfo = new JavaTypeInfo("java.lang.Integer");
Field field = new Field("age", javaTypeInfo);
field.setInitializationString("new Integer(21)");
String fieldStr = field.getFormattedContent(1);
```
结果: Integer age = new Integer(21);

## InitializationBlock(初始模块)
1. 实例: InitializationBlock initializationBlock = new InitializationBlock();
2. 内容: addBodyLine("new Integer(21)");
3. 注释: addJavaDocLine("/**");
### Sample Code
```
InitializationBlock initializationBlock = new InitializationBlock(true);
String str = initializationBlock.getFormattedContent(0);
assertEquals(str, "static {\r\n}");
```
```
InitializationBlock initializationBlock = new InitializationBlock();
initializationBlock.addBodyLine("int age = 27;");
initializationBlock.addJavaDocLine("/**");
initializationBlock.addJavaDocLine(" * this age");
initializationBlock.addJavaDocLine(" */");
String str = initializationBlock.getFormattedContent(0);
assertEquals(str, "/**\r\n * this age\r\n */\r\n{\r\n    int age = 27;\r\n}");
```
## InnerClass(类/内部类)
1. 实例: InnerClass innerClass = new InnerClass(new JavaTypeInfo("com.Test"));

## Method(方法)
1. 实例: Method method = new Method("getAge");
2. isNative: setNative(boolean isNative);
3. isSynchronized: setTransient(boolean isSynchronized);
4. 内容: addBodyLine("Integer i = 1;");
5. 是否构造器: setConstructor(boolean constructor);
6. 参数: addParameter(Parameter parameter);
7. 返回类型: setReturnType(JavaTypeInfo returnType);
8. 抛出异常: addException(JavaTypeInfo exception);

## Parameter(参数)
1. 实例: Parameter parameter = new Parameter(new JavaTypeInfo(Integer.class.getName()), "age");
2. isVarargs: setVarargs(boolean isVarargs);
2. 注解: addAnnotation(String annotation);
