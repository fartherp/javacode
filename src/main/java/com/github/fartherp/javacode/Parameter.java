/*
 * Copyright (c) 2017. juzhen.io. All rights reserved.
 */

package com.github.fartherp.javacode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 参数
 * Author: CK.
 * Date: 2015/6/6.
 */
public class Parameter {
    /** 参数名 */
    private String name;
    /** JAVA类型信息 */
    private JavaTypeInfo type;
    /** 是否数组 */
    private boolean isVarargs;
    /** 注解列表 */
    private List<String> annotations;

    public Parameter(JavaTypeInfo type, String name) {
        this.name = name;
        this.type = type;
        annotations = new ArrayList<String>();
    }

    public String getFormattedContent() {
        StringBuilder sb = new StringBuilder();

        for (String annotation : annotations) {
            sb.append(annotation);
            sb.append(' ');
        }

        sb.append(type.getShortName());
        sb.append(' ');
        if (isVarargs()) {
            sb.append(JavaKeywords.ARRAYS);
        }
        sb.append(name);

        return sb.toString();
    }

    public String getName() {
        return name;
    }

    public JavaTypeInfo getType() {
        return type;
    }

    public List<String> getAnnotations() {
        return annotations;
    }

    public void addAnnotation(String annotation) {
        annotations.add(annotation);
    }

    public void addAnnotations(Collection<String> lines) {
        if (lines != null && lines.size() > 0) {
            annotations.addAll(lines);
        }
    }

    public boolean isVarargs() {
        return isVarargs;
    }

    public void setVarargs(boolean varargs) {
        isVarargs = varargs;
    }

    public String toString() {
        return getFormattedContent();
    }
}
