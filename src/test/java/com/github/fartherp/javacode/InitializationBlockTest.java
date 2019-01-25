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
public class InitializationBlockTest {
    @Test
    public void testGetFormattedContent() throws Exception {
        InitializationBlock initializationBlock = new InitializationBlock(true);
        String str = initializationBlock.getFormattedContent(0);
        assertNotNull(str);
    }

    @Test
    public void testGetFormattedContent1() throws Exception {
        InitializationBlock initializationBlock = new InitializationBlock();
        initializationBlock.addBodyLine("int age = 27;");
        initializationBlock.addJavaDocLine("/**");
        initializationBlock.addJavaDocLine(" * this age");
        initializationBlock.addJavaDocLine(" */");
        String str = initializationBlock.getFormattedContent(0);
        assertNotNull(str);
    }
}