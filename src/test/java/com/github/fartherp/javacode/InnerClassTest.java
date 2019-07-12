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
 * Created by IntelliJ IDEA.
 *
 * @author: CK
 * @date: 2017/12/28
 */
public class InnerClassTest {
    @Test
    public void testDefaultGetFormattedContent() throws Exception {
        InnerClass innerClass = new InnerClass(new JavaTypeInfo("com.Test"));
        String str = innerClass.getFormattedContent(0);
        assertNotNull(str);
    }

	@Test
	public void testInterfaceGetFormattedContent() throws Exception {
		InnerClass innerClass = new InnerClass(new JavaTypeInfo("com.Test"));
		innerClass.setIfInterface(true);
		String str = innerClass.getFormattedContent(0);
		assertNotNull(str);
	}

	@Test
	public void testAbstractGetFormattedContent() throws Exception {
		InnerClass innerClass = new InnerClass(new JavaTypeInfo("com.Test"));
		innerClass.setIfAbstract(true);
		String str = innerClass.getFormattedContent(0);
		assertNotNull(str);
	}

	@Test
	public void testStaticGetFormattedContent() throws Exception {
		InnerClass innerClass = new InnerClass(new JavaTypeInfo("com.Test"));
		innerClass.setIfStatic(true);
		String str = innerClass.getFormattedContent(0);
		assertNotNull(str);
	}

	@Test
	public void testFinalGetFormattedContent() throws Exception {
		InnerClass innerClass = new InnerClass(new JavaTypeInfo("com.Test"));
		innerClass.setIfFinal(true);
		String str = innerClass.getFormattedContent(0);
		assertNotNull(str);
	}

	@Test
	public void testSuperClassGetFormattedContent() throws Exception {
		InnerClass innerClass = new InnerClass(new JavaTypeInfo("com.Test"));
		innerClass.setSuperClass("java.lang.Exception");
		String str = innerClass.getFormattedContent(0);
		assertNotNull(str);
	}

	@Test
	public void testSuperInterfaceGetFormattedContent() throws Exception {
		InnerClass innerClass = new InnerClass(new JavaTypeInfo("com.Test"));
		innerClass.addSuperInterface("java.util.Collection");
		innerClass.addSuperInterface("java.util.List");
		String str = innerClass.getFormattedContent(0);
		assertNotNull(str);
	}

	@Test
	public void testSuperInterfacesGetFormattedContent() throws Exception {
		InnerClass innerClass = new InnerClass(new JavaTypeInfo("com.Test"));
		Set<JavaTypeInfo> superInterfaceTypes = new HashSet<>();
		superInterfaceTypes.add(new JavaTypeInfo("java.util.Collection"));
		superInterfaceTypes.add(new JavaTypeInfo("java.util.List"));
		innerClass.addSuperInterfaces(superInterfaceTypes);
		String str = innerClass.getFormattedContent(0);
		assertNotNull(str);
	}

	@Test
	public void testFieldGetFormattedContent() throws Exception {
		InnerClass innerClass = new InnerClass(new JavaTypeInfo("com.Test"));
		innerClass.addField(new Field("age", new JavaTypeInfo("java.lang.Integer")));
		innerClass.addField(new Field("name", new JavaTypeInfo("java.lang.String")));
		String str = innerClass.getFormattedContent(0);
		assertNotNull(str);
	}

	@Test
	public void testFieldsGetFormattedContent() throws Exception {
		InnerClass innerClass = new InnerClass(new JavaTypeInfo("com.Test"));
		List<Field> fields = new ArrayList<>();
		fields.add(new Field("age", new JavaTypeInfo("java.lang.Integer")));
		fields.add(new Field("name", new JavaTypeInfo("java.lang.String")));
		innerClass.addFields(fields);
		String str = innerClass.getFormattedContent(0);
		assertNotNull(str);
		assertEquals(innerClass.getFields().size(), 2);
	}

	@Test
	public void testInitializationBlocksGetFormattedContent() throws Exception {
		InnerClass innerClass = new InnerClass(new JavaTypeInfo("com.Test"));
		innerClass.addInitializationBlock(new InitializationBlock());
		innerClass.addInitializationBlock(new InitializationBlock(true));
		String str = innerClass.getFormattedContent(0);
		assertNotNull(str);
	}

	@Test
	public void testInitializationsBlocksGetFormattedContent() throws Exception {
		InnerClass innerClass = new InnerClass("com.Test");
		List<InitializationBlock> initializationBlocks = new ArrayList<>();
		initializationBlocks.add(new InitializationBlock());
		initializationBlocks.add(new InitializationBlock(true));
		innerClass.addInitializationBlocks(initializationBlocks);
		String str = innerClass.getFormattedContent(0);
		assertNotNull(str);
		assertEquals(innerClass.getInitializationBlocks().size(), 2);
	}

	@Test
	public void testMethodBlocksGetFormattedContent() throws Exception {
		InnerClass innerClass = new InnerClass("com.Test");
		innerClass.addMethod(new Method("getAge"));
		innerClass.addMethod(new Method("getName"));
		String str = innerClass.getFormattedContent(0);
		assertNotNull(str);
	}

	@Test
	public void testMethodsBlocksGetFormattedContent() throws Exception {
		InnerClass innerClass = new InnerClass("com.Test");
		List<Method> methods = new ArrayList<>();
		methods.add(new Method("getAge"));
		methods.add(new Method("getName"));
		innerClass.addMethods(methods);
		String str = innerClass.getFormattedContent(0);
		assertNotNull(str);
		assertEquals(innerClass.getMethods().size(), 2);
	}

	@Test
	public void testInnerClassGetFormattedContent() {
		InnerClass innerClass = new InnerClass("com.Test");
		InnerClass innerClass1 = new InnerClass("com.FlyAble");
		innerClass.addInnerClass(innerClass1);
		InnerClass innerClass2 = new InnerClass("com.NameAble");
		innerClass.addInnerClass(innerClass2);
		String str = innerClass.getFormattedContent(0);
		assertNotNull(str);
	}

	@Test
	public void testInnerClassesGetFormattedContent() {
		InnerClass innerClass = new InnerClass("com.Test");
		List<InnerClass> innerClasses = new ArrayList<>();
		InnerClass innerClass1 = new InnerClass("com.FlyAble");
		innerClasses.add(innerClass1);
		InnerClass innerClass2 = new InnerClass("com.NameAble");
		innerClasses.add(innerClass2);
		innerClass.addInnerClasses(innerClasses);
		String str = innerClass.getFormattedContent(0);
		assertNotNull(str);
		assertEquals(innerClass.getInnerClasses().size(), 2);
	}

	@Test
	public void testInnerEnumGetFormattedContent() {
		InnerClass innerClass = new InnerClass("com.Test");
		InnerEnum innerEnum1 = new InnerEnum(new JavaTypeInfo("com.FlyAble"));
		innerClass.addInnerEnum(innerEnum1);
		InnerEnum innerEnum2 = new InnerEnum(new JavaTypeInfo("com.NameAble"));
		innerClass.addInnerEnum(innerEnum2);
		String str = innerClass.getFormattedContent(0);
		assertNotNull(str);
	}

	@Test
	public void testInnerEnumsGetFormattedContent() {
		InnerClass innerClass = new InnerClass("com.Test");
		List<InnerEnum> innerEnums = new ArrayList<>();
		InnerEnum innerEnum1 = new InnerEnum(new JavaTypeInfo("com.FlyAble"));
		innerEnums.add(innerEnum1);
		InnerEnum innerEnum2 = new InnerEnum(new JavaTypeInfo("com.NameAble"));
		innerEnums.add(innerEnum2);
		innerClass.addInnerEnums(innerEnums);
		String str = innerClass.getFormattedContent(0);
		assertNotNull(str);
		assertEquals(innerClass.getInnerEnums().size(), 2);
	}
}
