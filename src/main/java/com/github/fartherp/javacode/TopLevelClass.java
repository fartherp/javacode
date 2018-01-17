/*
 * Copyright (c) 2017. CK. All rights reserved.
 */

package com.github.fartherp.javacode;

import com.github.fartherp.framework.common.util.OutputUtils;
import org.apache.commons.lang.StringUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * 类包括的基本信息
 * 1: 包名注释, 2: 包名, 3: 导入的静态包, 4:导入的包, 5: 具体代码
 * Author: CK
 * Date: 2015/6/13
 */
public class TopLevelClass extends InnerClass implements CompilationUnit {

    /** import 类 */
    private Set<JavaTypeInfo> importedTypes;

    /** static import 类 */
    private Set<String> staticImports;

    /** 注释 */
    private List<String> fileCommentLines;

    /** 所属模块 **/
    private String module;

    public TopLevelClass(JavaTypeInfo type) {
        super(type);
        importedTypes = new TreeSet<JavaTypeInfo>();
        fileCommentLines = new ArrayList<String>();
        staticImports = new TreeSet<String>();
    }

    public TopLevelClass(String typeName) {
        this(new JavaTypeInfo(typeName));
    }

    public String getFormattedContent() {
        StringBuilder sb = new StringBuilder();

        // 文件注释
        for (String fileCommentLine : fileCommentLines) {
            sb.append(fileCommentLine);
            OutputUtils.newLine(sb);
        }

        // 包名
        if (StringUtils.isNotBlank(getType().getPackageName())) {
            sb.append(JavaKeywords.PACKAGE);
            sb.append(getType().getPackageName());
            sb.append(';');
            OutputUtils.newLine(sb);
            OutputUtils.newLine(sb);
        }

        // 静态包
        for (String staticImport : staticImports) {
            sb.append(JavaKeywords.IMPORT_STATIC);
            sb.append(staticImport);
            sb.append(';');
            OutputUtils.newLine(sb);
        }

        if (staticImports.size() > 0) {
            OutputUtils.newLine(sb);
        }

        // 导入包并去重
        Set<String> importStrings = calculateImports(importedTypes);
        for (String importString : importStrings) {
            sb.append(importString);
            OutputUtils.newLine(sb);
        }

        if (importStrings.size() > 0) {
            OutputUtils.newLine(sb);
        }

        // 具体代码生成
        sb.append(super.getFormattedContent(0));

        return sb.toString();
    }

    public Set<JavaTypeInfo> getImportedTypes() {
        return Collections.unmodifiableSet(importedTypes);
    }

    public void addImportedType(String importedType) {
        addImportedType(new JavaTypeInfo(importedType));
    }

    public void addImportedType(JavaTypeInfo importedType) {
        if (importedType != null && importedType.isExplicitlyImported()
                && !importedType.getPackageName().equals(getType().getPackageName())) {
            importedTypes.add(importedType);
        }
    }

    /**
     * 导入Set
     *
     * @param importedTypes 导入类型Set
     * @return 导入Set
     */
    private Set<String> calculateImports(Set<JavaTypeInfo> importedTypes) {
        StringBuilder sb = new StringBuilder();
        Set<String> importStrings = new TreeSet<String>();
        for (JavaTypeInfo info : importedTypes) {
            for (String importString : info.getImportList()) {
                sb.setLength(0);
                sb.append(JavaKeywords.IMPORT);
                sb.append(importString);
                sb.append(';');
                importStrings.add(sb.toString());
            }
        }

        return importStrings;
    }

    public boolean isJavaInterface() {
        return false;
    }

    public boolean isJavaEnumeration() {
        return false;
    }

    public void addFileCommentLine(String commentLine) {
        fileCommentLines.add(commentLine);
    }

    public void addFileCommentLines(Collection<String> commentLine) {
        if (commentLine != null && commentLine.size() > 0) {
            fileCommentLines.addAll(commentLine);
        }
    }

    public List<String> getFileCommentLines() {
        return fileCommentLines;
    }

    public void addImportedTypes(Set<JavaTypeInfo> importedTypes) {
        if (importedTypes != null && importedTypes.size() > 0) {
            this.importedTypes.addAll(importedTypes);
        }
    }

    public Set<String> getStaticImports() {
        return staticImports;
    }

    public void addStaticImport(String staticImport) {
        staticImports.add(staticImport);
    }

    public void addStaticImports(Set<String> staticImports) {
        if (staticImports != null && staticImports.size() > 0) {
            this.staticImports.addAll(staticImports);
        }
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }
}
