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
public class MethodTest {
    @Test
    public void testGetFormattedContent() throws Exception {
        Method method = new Method("getAge");
        String str = method.getFormattedContent(0, true);
        assertEquals(str, "void getAge();");
    }

}