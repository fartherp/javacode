/**
 *    Copyright (c) 2015-2019 CK.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
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
public class FieldTest {
    @Test
    public void testDefaultIntegerGetFormattedContent() throws Exception {
        JavaTypeInfo javaTypeInfo = new JavaTypeInfo("java.lang.Integer");
        Field field = new Field("age", javaTypeInfo);
        String fieldStr = field.getFormattedContent(1);
        assertNotNull(fieldStr);
    }

    @Test
    public void testOverrideIntegerGetFormattedContent() throws Exception {
        JavaTypeInfo javaTypeInfo = new JavaTypeInfo("java.lang.Integer");
        Field field = new Field("age", javaTypeInfo);
        field.setIfTransient(true).setIfVolatile(true).setInitializationString("new Integer(21)");
		field.setIfStatic(true);
		field.setIfFinal(true);
        String fieldStr = field.getFormattedContent(1);
        assertNotNull(fieldStr);
    }

	@Test
	public void testDefaultStringGetFormattedContent() throws Exception {
		JavaTypeInfo javaTypeInfo = new JavaTypeInfo("java.lang.String");
		Field field = new Field("name", javaTypeInfo);
		field.setInitializationString("test_value");
		String fieldStr = field.getFormattedContent(1);
		assertNotNull(fieldStr);
	}

	@Test
	public void testConstructorIntegerGetFormattedContent() throws Exception {
		JavaTypeInfo javaTypeInfo = new JavaTypeInfo("java.lang.Integer");
		Field field = new Field("age", javaTypeInfo);
		Field newField = new Field(field);
		String fieldStr = field.getFormattedContent(1);
		String newFieldStr = newField.getFormattedContent(1);
		assertEquals(fieldStr, newFieldStr);
	}

	@Test
	public void testJavaDocLineGetFormattedContent() throws Exception {
		JavaTypeInfo javaTypeInfo = new JavaTypeInfo("java.lang.Integer");
		Field field = new Field("age", javaTypeInfo);
		field.addJavaDocLine("/*");
		field.addJavaDocLine(" * this is age");
		field.addJavaDocLine(" */");
		String fieldStr = field.getFormattedContent(1);
		assertNotNull(fieldStr);
	}

	@Test
	public void testJavaDocLinesGetFormattedContent() throws Exception {
		JavaTypeInfo javaTypeInfo = new JavaTypeInfo("java.lang.Integer");
		Field field = new Field("age", javaTypeInfo);
		List<String> javaDocLines = new ArrayList<>();
		javaDocLines.add("/*");
		javaDocLines.add(" * this is age");
		javaDocLines.add(" */");
		field.addJavaDocLines(javaDocLines);
		field.addSuppressTypeWarningsAnnotation();
		String fieldStr = field.getFormattedContent(1);
		assertNotNull(fieldStr);
	}

	@Test
	public void testAnnotationsGetFormattedContent() throws Exception {
		JavaTypeInfo javaTypeInfo = new JavaTypeInfo("java.lang.Integer");
		Field field = new Field("age", javaTypeInfo);
		List<String> annotations = new ArrayList<>();
		annotations.add("@Value");
		annotations.add("@Auto");
		field.addAnnotations(annotations);
		String fieldStr = field.getFormattedContent(1);
		assertNotNull(fieldStr);
	}
}
