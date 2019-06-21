/*
 * Copyright (c) 2017. CK. All rights reserved.
 */

package com.github.fartherp.javacode;

import com.github.fartherp.javacode.utils.OutputUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * JAVA元素(类/字段)公共信息
 * 1: 注释, 2: 注解, 3: 作用域, 4: final, 5: static
 * Author: CK.
 * Date: 2015/6/6.
 */
public abstract class JavaElement {

    /** JAVA注释 */
    private List<String> javaDocLines;

    /** JAVA作用域 */
    private String javaScope = JavaKeywords.DEFAULT;

    /** static */
    private boolean ifStatic;

    /** final */
    private boolean ifFinal;

    /** JAVA注解 */
    private List<String> annotations;

    public JavaElement() {
        super();
        this.javaDocLines = new ArrayList<>();
		this.annotations = new ArrayList<>();
    }

    public JavaElement(JavaElement original) {
        this();
        this.addAnnotations(original.getAnnotations());
        this.setIfFinal(original.isIfFinal());
        this.setIfStatic(original.isIfStatic());
        this.addJavaDocLines(original.getJavaDocLines());
        this.setJavaScope(original.getJavaScope());
    }

    public List<String> getJavaDocLines() {
        return javaDocLines;
    }

    public void addJavaDocLine(String javaDocLine) {
        javaDocLines.add(javaDocLine);
    }

    public void addJavaDocLines(Collection<String> javaDocLine) {
        if (javaDocLine != null && javaDocLine.size() > 0) {
            javaDocLines.addAll(javaDocLine);
        }
    }

    protected void addFormattedJavadoc(StringBuilder sb, int indentLevel) {
        for (String javaDocLine : javaDocLines) {
            OutputUtil.javaIndent(sb, indentLevel);
            sb.append(javaDocLine);
            OutputUtil.newLine(sb);
        }
    }

    public List<String> getAnnotations() {
        return annotations;
    }

    public void addAnnotation(String annotation) {
        annotations.add(annotation);
    }

    public void addAnnotations(Collection<String> collection) {
        if (collection != null && collection.size() > 0) {
            annotations.addAll(collection);
        }
    }

    public void addSuppressTypeWarningsAnnotation() {
        addAnnotation("@SuppressWarnings(\"unchecked\")"); 
    }

    protected void addFormattedAnnotations(StringBuilder sb, int indentLevel) {
        for (String annotation : annotations) {
            OutputUtil.javaIndent(sb, indentLevel);
            sb.append(annotation);
            OutputUtil.newLine(sb);
        }
    }

    public String getJavaScope() {
        return javaScope;
    }

    public void setJavaScope(String javaScope) {
        this.javaScope = javaScope;
    }

    public boolean isIfFinal() {
        return ifFinal;
    }

    public void setIfFinal(boolean isFinal) {
        this.ifFinal = isFinal;
    }

    public boolean isIfStatic() {
        return ifStatic;
    }

    public void setIfStatic(boolean isStatic) {
        this.ifStatic = isStatic;
    }

    protected void addCommonFormatted(StringBuilder sb, int indentLevel) {
        // JAVA类注释
        addFormattedJavadoc(sb, indentLevel);
        // JAVA类注解
        addFormattedAnnotations(sb, indentLevel);

        OutputUtil.javaIndent(sb, indentLevel);
    }
}
