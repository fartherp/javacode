/*
 * Copyright (c) 2017. juzhen.io. All rights reserved.
 */

package com.github.fartherp.javacode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: CK
 * @date: 2017/12/28
 */
public class FieldTest {
    @Test
    public void testGetFormattedContent() throws Exception {
        JavaTypeInfo javaTypeInfo = new JavaTypeInfo("java.lang.Integer");
        Field field = new Field("age", javaTypeInfo);
        String fieldStr = field.getFormattedContent(1);
        assertEquals(fieldStr, "    Integer age;");
    }

    @Test
    public void testGetFormattedContent1() throws Exception {
        JavaTypeInfo javaTypeInfo = new JavaTypeInfo("java.lang.Integer");
        Field field = new Field("age", javaTypeInfo);
        field.setTransient(true).setVolatile(true).setInitializationString("new Integer(21)");
        String fieldStr = field.getFormattedContent(1);
        assertEquals(fieldStr, "    transient volatile Integer age = new Integer(21);");
    }

}