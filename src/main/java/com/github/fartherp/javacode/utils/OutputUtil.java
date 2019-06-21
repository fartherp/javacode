/*
 * Copyright (c) 2017. CK. All rights reserved.
 */

package com.github.fartherp.javacode.utils;

/**
 * Created by IntelliJ IDEA.
 * Author: CK
 * Date: 2015/8/15
 */
public class OutputUtil {

    /** 行分割符 */
    private static final String lineSeparator;

    static {
        String ls = System.getProperty("line.separator");
        if (ls == null) {
            ls = "\n";
        }
        lineSeparator = ls;
    }

    /**
     * 对于前个级别的JAVA自增四个空格
     *
     * @param sb a StringBuilder to append to
     * @param indentLevel the required indent level
     */
    public static void javaIndent(StringBuilder sb, int indentLevel) {
        for (int i = 0; i < indentLevel; i++) {
            sb.append("    ");
        }
    }

    /**
     * 换行
     *
     * @param sb a StringBuilder to append to
     */
    public static void newLine(StringBuilder sb) {
        sb.append(lineSeparator);
    }
}
