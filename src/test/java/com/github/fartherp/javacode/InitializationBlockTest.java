/*
 * Copyright (c) 2017. juzhen.io. All rights reserved.
 */

package com.github.fartherp.javacode;

import com.github.fartherp.framework.common.util.OutputUtils;
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
        assertEquals(str, "static {\r\n}");
    }

    @Test
    public void testGetFormattedContent1() throws Exception {
        InitializationBlock initializationBlock = new InitializationBlock();
        initializationBlock.addBodyLine("int age = 27;");
        initializationBlock.addJavaDocLine("/**");
        initializationBlock.addJavaDocLine(" * this age");
        initializationBlock.addJavaDocLine(" */");
        String str = initializationBlock.getFormattedContent(0);
        assertEquals(str, "/**\r\n * this age\r\n */\r\n{\r\n    int age = 27;\r\n}");
    }
}