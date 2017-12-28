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
public class ParameterTest {
    @Test
    public void testGetFormattedContent() throws Exception {
        Parameter parameter = new Parameter(new JavaTypeInfo(Integer.class.getName()), "age");
        String str = parameter.getFormattedContent();
        assertEquals(str, "Integer age");
    }

}