/**
 *    Copyright (c) 2015-2019 CK.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.github.fartherp.javacode;

import java.util.List;
import java.util.Set;

/**
 * JAVA类接口
 * Author: CK
 * Date: 2015/6/7
 */
public interface CompilationUnit {

    /**
     * 获取格式化内容
     *
     * @return 格式化内容
     */
    String getFormattedContent();

    /**
     * 获取import类
     *
     * @return import类
     */
    Set<JavaTypeInfo> getImportedTypes();

    /**
     * 获取import static类
     *
     * @return import static类
     */
    Set<String> getStaticImports();

    /**
     * 获取父类类型信息
     *
     * @return 父类类型信息
     */
    JavaTypeInfo getSuperClass();

    /**
     * 是否JAVA接口
     *
     * @return true：是,false：否
     */
    boolean isJavaInterface();

    /**
     * 是否JAVA枚举
     *
     * @return true：是,false：否
     */
    boolean isJavaEnumeration();

    /**
     * 获取实现的接口类型
     *
     * @return 实现接口类型
     */
    Set<JavaTypeInfo> getSuperInterfaceTypes();

    /**
     * 获取当前JAVA类型
     *
     * @return 当前JAVA类型
     */
    JavaTypeInfo getType();

    /**
     * 添加import类
     *
     * @param importedType import类
     */
    void addImportedType(JavaTypeInfo importedType);

    /**
     * 添加JAVA类型
     *
     * @param importedTypes JAVA类型
     */
    void addImportedTypes(Set<JavaTypeInfo> importedTypes);

    /**
     * 添加import static类
     *
     * @param staticImport 导入static类
     */
    void addStaticImport(String staticImport);

    /**
     * 添加import static类
     *
     * @param staticImports static类
     */
    void addStaticImports(Set<String> staticImports);

    /**
     * 添加行注解
     *
     * @param commentLine 行注解
     */
    void addFileCommentLine(String commentLine);

    /**
     * 获取文件注解
     *
     * @return 文件注解
     */
    List<String> getFileCommentLines();

    /**
     * 获取文件所属模块
     * @return 所属模块
     */
    String getModule();
}
