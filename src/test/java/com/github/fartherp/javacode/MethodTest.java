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
public class MethodTest {
    @Test
    public void testDefaultGetFormattedContent() throws Exception {
        Method method = new Method("getAge");
        String str = method.getFormattedContent(0, true);
        assertEquals(str, "void getAge();");
    }

	@Test
	public void testStaticGetFormattedContent() throws Exception {
		Method method = new Method("setName");
		method.setIfStatic(true);
		Parameter parameter1 = new Parameter(new JavaTypeInfo("java.lang.String"), "name1");
		method.addParameter(parameter1);
		Parameter parameter2 = new Parameter(new JavaTypeInfo("java.lang.String"), "name2");
		method.addParameter(parameter2);

		method.addException(new JavaTypeInfo("java.lang.IllegalArgumentException"));
		method.addException(new JavaTypeInfo("java.lang.IllegalStateException"));
		String str = method.getFormattedContent(0, false);
		assertNotNull(str);
	}

	@Test
	public void testFinalGetFormattedContent() throws Exception {
		Method method = new Method("getAge");
		method.setIfFinal(true);
		String str = method.getFormattedContent(0, false);
		assertNotNull(str);
	}

	@Test
	public void testSynchronizedGetFormattedContent() throws Exception {
		Method method = new Method("getAge");
		method.setIfSynchronized(true);
		String str = method.getFormattedContent(0, false);
		assertNotNull(str);
	}

	@Test
	public void testNativeGetFormattedContent() throws Exception {
		Method method = new Method("getAge");
		method.setIfNative(true);
		String str = method.getFormattedContent(0, false);
		assertNotNull(str);
	}

	@Test
	public void testConstructorGetFormattedContent() throws Exception {
		Method method = new Method("getAge");
		method.setConstructor(true);
		String str = method.getFormattedContent(0, false);
		assertNotNull(str);
		assertTrue(method.isConstructor());
	}

	@Test
	public void testBodyLineGetFormattedContent() throws Exception {
		Method method = new Method("getAge");
		method.addBodyLine("// this is age");
		method.addBodyLine("return age;");
		String str = method.getFormattedContent(0, false);
		assertNotNull(str);
	}

	@Test
	public void testBodyLinesGetFormattedContent() throws Exception {
		Method method = new Method("getAge");
		List<String> bodyLines = new ArrayList<>();
		bodyLines.add("// this is age");
		bodyLines.add("return age;");
		method.addBodyLines(bodyLines);
		method.setReturnType(new JavaTypeInfo("java.lang.Integer"));
		String str = method.getFormattedContent(0, false);
		assertNotNull(str);
		assertEquals(method.getBodyLines().size(), 2);
	}

	@Test
	public void testParameterGetFormattedContent() throws Exception {
		Method method = new Method("getAge");
		Parameter parameter1 = new Parameter(new JavaTypeInfo("java.lang.Integer"), "age");
		method.addParameter(parameter1);
		Parameter parameter2 = new Parameter(new JavaTypeInfo("java.lang.String"), "name");
		method.addParameter(parameter2);
		String str = method.getFormattedContent(0, false);
		assertNotNull(str);
	}

	@Test
	public void testParametersGetFormattedContent() throws Exception {
		Method method = new Method("getAge");
		List<Parameter> parameters = new ArrayList<>();
		Parameter parameter1 = new Parameter(new JavaTypeInfo("java.lang.Integer"), "age");
		parameters.add(parameter1);
		Parameter parameter2 = new Parameter(new JavaTypeInfo("java.lang.String"), "name");
		parameters.add(parameter2);
		method.addParameters(parameters);
		String str = method.getFormattedContent(0, false);
		assertNotNull(str);
		assertEquals(method.getParameters().size(), 2);
	}

	@Test
	public void testExceptionGetFormattedContent() throws Exception {
		Method method = new Method("getAge");
		JavaTypeInfo exception1 = new JavaTypeInfo("java.lang.NullPointerException");
		method.addException(exception1);
		JavaTypeInfo exception2 = new JavaTypeInfo("java.lang.IllegalArgumentException");
		method.addException(exception2);
		String str = method.getFormattedContent(0, false);
		assertNotNull(str);
	}

	@Test
	public void testExceptionsGetFormattedContent() throws Exception {
		Method method = new Method("getAge");
		List<JavaTypeInfo> exceptions = new ArrayList<>();
		JavaTypeInfo exception1 = new JavaTypeInfo("java.lang.NullPointerException");
		exceptions.add(exception1);
		JavaTypeInfo exception2 = new JavaTypeInfo("java.lang.IllegalArgumentException");
		exceptions.add(exception2);
		method.addExceptions(exceptions);
		String str = method.getFormattedContent(0, false);
		assertNotNull(str);
		assertEquals(method.getExceptions().size(), 2);
	}

	@Test
	public void testConstructor1GetFormattedContent() throws Exception {
		Method method = new Method("getAge");
		Method newMethod = new Method(method);
		String str = method.getFormattedContent(0, true);
		String newStr = newMethod.getFormattedContent(0, true);
		assertEquals(str, newStr);
	}
}
