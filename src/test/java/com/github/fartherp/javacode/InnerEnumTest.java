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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.testng.Assert.*;

/**
 * 内部类单侧
 * Author: CK
 * Date: 2015/6/7
 */
public class InnerEnumTest {

	@Test
	public void testSuperInterfaceGetFormattedContent() {
		InnerEnum innerEnum = new InnerEnum(new JavaTypeInfo("com.FlyType"));
		innerEnum.setJavaScope(JavaKeywords.PUBLIC);
		innerEnum.addSuperInterface(new JavaTypeInfo("com.FlyAble"));
		innerEnum.addSuperInterface(new JavaTypeInfo("com.NameAble"));
		String str = innerEnum.getFormattedContent(0);
		assertNotNull(str);
	}

	@Test
	public void testSuperInterfacesGetFormattedContent() {
		InnerEnum innerEnum = new InnerEnum(new JavaTypeInfo("com.FlyType"));
		innerEnum.setJavaScope(JavaKeywords.PUBLIC);
		Set<JavaTypeInfo> superInterfaceTypes = new HashSet<>();
		superInterfaceTypes.add(new JavaTypeInfo("com.FlyAble"));
		superInterfaceTypes.add(new JavaTypeInfo("com.NameAble"));
		innerEnum.addSuperInterfaces(superInterfaceTypes);
		String str = innerEnum.getFormattedContent(0);
		assertNotNull(str);
		assertEquals(innerEnum.getSuperInterfaceTypes().size(), 2);
	}

	@Test
	public void testEnumConstantGetFormattedContent() {
		InnerEnum innerEnum = new InnerEnum(new JavaTypeInfo("com.FlyType"));
		innerEnum.setJavaScope(JavaKeywords.PUBLIC);
		innerEnum.addEnumConstant("Bird(\"鸟\")");
		innerEnum.addEnumConstant("Plane(\"飞机\")");
		String str = innerEnum.getFormattedContent(0);
		assertNotNull(str);
	}

	@Test
	public void testEnumConstantsGetFormattedContent() {
		InnerEnum innerEnum = new InnerEnum(new JavaTypeInfo("com.FlyType"));
		innerEnum.setJavaScope(JavaKeywords.PUBLIC);
		List<String> enumConstants = new ArrayList<>();
		enumConstants.add("Bird(\"鸟\")");
		enumConstants.add("Plane(\"飞机\")");
		innerEnum.addEnumConstants(enumConstants);
		String str = innerEnum.getFormattedContent(0);
		assertNotNull(str);
		assertEquals(innerEnum.getEnumConstants().size(), 2);
	}

	@Test
	public void testFieldGetFormattedContent() {
		InnerEnum innerEnum = new InnerEnum(new JavaTypeInfo("com.FlyType"));
		innerEnum.setJavaScope(JavaKeywords.PUBLIC);
		Field field1 = new Field("age", new JavaTypeInfo("java.lang.Integer"));
		innerEnum.addField(field1);
		Field field2 = new Field("name", new JavaTypeInfo("java.lang.String"));
		innerEnum.addField(field2);
		String str = innerEnum.getFormattedContent(0);
		assertNotNull(str);
	}

	@Test
	public void testFieldsGetFormattedContent() {
		InnerEnum innerEnum = new InnerEnum(new JavaTypeInfo("com.FlyType"));
		innerEnum.setJavaScope(JavaKeywords.PUBLIC);
		List<Field> fields = new ArrayList<>();
		Field field1 = new Field("age", new JavaTypeInfo("java.lang.Integer"));
		fields.add(field1);
		Field field2 = new Field("name", new JavaTypeInfo("java.lang.String"));
		fields.add(field2);
		innerEnum.addFields(fields);
		String str = innerEnum.getFormattedContent(0);
		assertNotNull(str);
		assertEquals(innerEnum.getFields().size(), 2);
	}

	@Test
	public void testMethodGetFormattedContent() {
		InnerEnum innerEnum = new InnerEnum(new JavaTypeInfo("com.FlyType"));
		innerEnum.setJavaScope(JavaKeywords.PUBLIC);
		Method method1 = new Method("getAge");
		innerEnum.addMethod(method1);
		Method method2 = new Method("getName");
		innerEnum.addMethod(method2);
		String str = innerEnum.getFormattedContent(0);
		assertNotNull(str);
	}

	@Test
	public void testMethodsGetFormattedContent() {
		InnerEnum innerEnum = new InnerEnum(new JavaTypeInfo("com.FlyType"));
		innerEnum.setJavaScope(JavaKeywords.PUBLIC);
		List<Method> methods = new ArrayList<>();
		Method method1 = new Method("getAge");
		methods.add(method1);
		Method method2 = new Method("getName");
		methods.add(method2);
		innerEnum.addMethods(methods);
		String str = innerEnum.getFormattedContent(0);
		assertNotNull(str);
		assertEquals(innerEnum.getMethods().size(), 2);
	}

	@Test
	public void testInnerClassGetFormattedContent() {
		InnerEnum innerEnum = new InnerEnum(new JavaTypeInfo("com.FlyType"));
		innerEnum.setJavaScope(JavaKeywords.PUBLIC);
		InnerClass innerClass1 = new InnerClass("com.FlyAble");
		innerEnum.addInnerClass(innerClass1);
		InnerClass innerClass2 = new InnerClass("com.NameAble");
		innerEnum.addInnerClass(innerClass2);
		String str = innerEnum.getFormattedContent(0);
		assertNotNull(str);
	}

	@Test
	public void testInnerClassesGetFormattedContent() {
		InnerEnum innerEnum = new InnerEnum(new JavaTypeInfo("com.FlyType"));
		innerEnum.setJavaScope(JavaKeywords.PUBLIC);
		List<InnerClass> innerClasses = new ArrayList<>();
		InnerClass innerClass1 = new InnerClass("com.FlyAble");
		innerClasses.add(innerClass1);
		InnerClass innerClass2 = new InnerClass("com.NameAble");
		innerClasses.add(innerClass2);
		innerEnum.addInnerClasses(innerClasses);
		String str = innerEnum.getFormattedContent(0);
		assertNotNull(str);
		assertEquals(innerEnum.getInnerClasses().size(), 2);
	}

	@Test
	public void testInnerEnumGetFormattedContent() {
		InnerEnum innerEnum = new InnerEnum(new JavaTypeInfo("com.FlyType"));
		innerEnum.setJavaScope(JavaKeywords.PUBLIC);
		InnerEnum innerEnum1 = new InnerEnum(new JavaTypeInfo("com.FlyAble"));
		innerEnum.addInnerEnum(innerEnum1);
		InnerEnum innerEnum2 = new InnerEnum(new JavaTypeInfo("com.NameAble"));
		innerEnum.addInnerEnum(innerEnum2);
		String str = innerEnum.getFormattedContent(0);
		assertNotNull(str);
	}

	@Test
	public void testInnerEnumsGetFormattedContent() {
		InnerEnum innerEnum = new InnerEnum(new JavaTypeInfo("com.FlyType"));
		innerEnum.setJavaScope(JavaKeywords.PUBLIC);
		List<InnerEnum> innerEnums = new ArrayList<>();
		InnerEnum innerEnum1 = new InnerEnum(new JavaTypeInfo("com.FlyAble"));
		innerEnums.add(innerEnum1);
		InnerEnum innerEnum2 = new InnerEnum(new JavaTypeInfo("com.NameAble"));
		innerEnums.add(innerEnum2);
		innerEnum.addInnerEnums(innerEnums);
		String str = innerEnum.getFormattedContent(0);
		assertNotNull(str);
		assertEquals(innerEnum.getInnerEnums().size(), 2);
	}
}
