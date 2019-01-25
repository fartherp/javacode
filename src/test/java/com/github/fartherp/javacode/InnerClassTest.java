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
public class InnerClassTest {
    @Test
    public void testGetFormattedContent() throws Exception {
        InnerClass innerClass = new InnerClass(new JavaTypeInfo("com.Test"));
        String str = innerClass.getFormattedContent(0);
        assertNotNull(str);
    }

}