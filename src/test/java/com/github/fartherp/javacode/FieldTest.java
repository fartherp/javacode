/*
 * Copyright (c) 2017. CK. All rights reserved.
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
        assertNotNull(fieldStr);
    }

    @Test
    public void testGetFormattedContent1() throws Exception {
        JavaTypeInfo javaTypeInfo = new JavaTypeInfo("java.lang.Integer");
        Field field = new Field("age", javaTypeInfo);
        field.setIfTransient(true).setIfVolatile(true).setInitializationString("new Integer(21)");
        String fieldStr = field.getFormattedContent(1);
        assertNotNull(fieldStr);
    }

}
