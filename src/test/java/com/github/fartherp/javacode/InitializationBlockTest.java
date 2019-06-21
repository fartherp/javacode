/*
 * Copyright (c) 2017. CK. All rights reserved.
 */

package com.github.fartherp.javacode;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

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
    public void testAddLineGetFormattedContent() throws Exception {
        InitializationBlock initializationBlock = new InitializationBlock();
        initializationBlock.addBodyLine("int age = 27;");
        initializationBlock.addJavaDocLine("/**");
        initializationBlock.addJavaDocLine(" * this age");
        initializationBlock.addJavaDocLine(" */");
        String str = initializationBlock.getFormattedContent(0);
        assertNotNull(str);
    }

	@Test
	public void testAddJavaDocLinesGetFormattedContent() throws Exception {
		InitializationBlock initializationBlock = new InitializationBlock();
		initializationBlock.addBodyLine("int age = 27;");
		List<String> javaDocLines = new ArrayList<>();
		javaDocLines.add("/**");
		javaDocLines.add(" * this age");
		javaDocLines.add(" */");
		initializationBlock.addJavaDocLines(javaDocLines);
		String str = initializationBlock.getFormattedContent(0);
		assertNotNull(str);
	}

	@Test
	public void testAddBodyLinesGetFormattedContent() throws Exception {
		InitializationBlock initializationBlock = new InitializationBlock();
		List<String> bodyLines = new ArrayList<>();
		bodyLines.add("int age = 27;");
		bodyLines.add("String name = \"zhangsan\";");
		initializationBlock.addBodyLines(bodyLines);
		String str = initializationBlock.getFormattedContent(0);
		assertNotNull(str);
	}
}
