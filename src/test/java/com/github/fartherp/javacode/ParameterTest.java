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
public class ParameterTest {
    @Test
    public void testGetFormattedContent() throws Exception {
		JavaTypeInfo javaTypeInfo = new JavaTypeInfo(Integer.class.getName());
        Parameter parameter = new Parameter(javaTypeInfo, "age");
        String str = parameter.getFormattedContent();
        assertEquals(str, "Integer age");
        assertEquals(parameter.getName(), "age");
        assertEquals(parameter.getType(), javaTypeInfo);
    }

	@Test
	public void testArrayGetFormattedContent() throws Exception {
		JavaTypeInfo javaTypeInfo = new JavaTypeInfo(Integer.class.getName());
		Parameter parameter = new Parameter(javaTypeInfo, "ages");
		parameter.setIfVarargs(true);
		String str = parameter.getFormattedContent();
		assertNotNull(str);
	}

	@Test
	public void testAnnotationGetFormattedContent() throws Exception {
		JavaTypeInfo javaTypeInfo = new JavaTypeInfo(Integer.class.getName());
		Parameter parameter = new Parameter(javaTypeInfo, "ages");
		parameter.addAnnotation("@Value");
		parameter.setIfVarargs(true);
		String str = parameter.getFormattedContent();
		assertNotNull(str);
		assertEquals(parameter.getAnnotations().size(), 1);
		assertEquals(parameter.getAnnotations().get(0), "@Value");
	}

	@Test
	public void testAnnotationsGetFormattedContent() throws Exception {
		JavaTypeInfo javaTypeInfo = new JavaTypeInfo(Integer.class.getName());
		Parameter parameter = new Parameter(javaTypeInfo, "ages");
		List<String> annotations = new ArrayList<>();
		annotations.add("@Value");
		annotations.add("@Auto");
		parameter.addAnnotations(annotations);
		parameter.setIfVarargs(true);
		String str = parameter.getFormattedContent();
		assertNotNull(str);
		assertEquals(parameter.getAnnotations().size(), 2);
		assertEquals(parameter.getAnnotations().get(0), "@Value");
		assertEquals(parameter.getAnnotations().get(1), "@Auto");
	}

	@Test
	public void testToString() {
		JavaTypeInfo javaTypeInfo = new JavaTypeInfo(Integer.class.getName());
		Parameter parameter = new Parameter(javaTypeInfo, "ages");
		assertNotNull(parameter.toString());
	}
}
