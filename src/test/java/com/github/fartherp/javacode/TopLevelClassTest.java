package com.github.fartherp.javacode;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import static org.testng.Assert.*;

/**
 * <pre>
 *  @author: cuiyuqiang
 *  @email: cuiyuqiang@ddjf.com.cn
 *  @date: 2019/6/21 11:42
 *  @project: risk-control-parent
 * </pre>
 */
public class TopLevelClassTest {

	@Test
	public void testDefaultGetFormattedContent() {
		TopLevelClass topLevelClass = new TopLevelClass("com.Test");
		topLevelClass.setModule("dao");
		String str = topLevelClass.getFormattedContent();
		assertNotNull(str);
		assertEquals(topLevelClass.getModule(), "dao");
		assertFalse(topLevelClass.isJavaInterface());
		assertFalse(topLevelClass.isJavaEnumeration());
	}

	@Test
	public void testImportedTypeGetFormattedContent() {
		TopLevelClass topLevelClass = new TopLevelClass("com.Test");
		topLevelClass.addImportedType("java.utils.List");
		topLevelClass.addImportedType("java.utils.Set");
		String str = topLevelClass.getFormattedContent();
		assertNotNull(str);
	}

	@Test
	public void testImportedTypesGetFormattedContent() {
		TopLevelClass topLevelClass = new TopLevelClass("com.Test");
		Set<JavaTypeInfo> importedTypes = new TreeSet<>();
		importedTypes.add(new JavaTypeInfo("java.utils.List"));
		importedTypes.add(new JavaTypeInfo("java.utils.Set"));
		topLevelClass.addImportedTypes(importedTypes);
		String str = topLevelClass.getFormattedContent();
		assertNotNull(str);
		assertEquals(topLevelClass.getImportedTypes().size(), 2);
	}

	@Test
	public void testStaticImportTypeGetFormattedContent() {
		TopLevelClass topLevelClass = new TopLevelClass("com.Test");
		topLevelClass.addStaticImport("java.utils.List");
		topLevelClass.addStaticImport("java.utils.Set");
		String str = topLevelClass.getFormattedContent();
		assertNotNull(str);
	}

	@Test
	public void testStaticImportsTypeGetFormattedContent() {
		TopLevelClass topLevelClass = new TopLevelClass("com.Test");
		Set<String> staticImports = new TreeSet<>();
		staticImports.add("java.utils.List");
		staticImports.add("java.utils.Set");
		topLevelClass.addStaticImports(staticImports);
		String str = topLevelClass.getFormattedContent();
		assertNotNull(str);
		assertEquals(topLevelClass.getStaticImports().size(), 2);
	}

	@Test
	public void testFileCommentLineTypeGetFormattedContent() {
		TopLevelClass topLevelClass = new TopLevelClass("com.Test");
		topLevelClass.addFileCommentLine("/*");
		topLevelClass.addFileCommentLine(" * this is test class.");
		topLevelClass.addFileCommentLine(" */");
		String str = topLevelClass.getFormattedContent();
		assertNotNull(str);
	}

	@Test
	public void testFileCommentLinesTypeGetFormattedContent() {
		TopLevelClass topLevelClass = new TopLevelClass("com.Test");
		List<String> fileCommentLines = new ArrayList<>();
		fileCommentLines.add("/*");
		fileCommentLines.add(" * this is test class.");
		fileCommentLines.add(" */");
		topLevelClass.addFileCommentLines(fileCommentLines);
		String str = topLevelClass.getFormattedContent();
		assertNotNull(str);
		assertEquals(topLevelClass.getFileCommentLines().size(), 3);
	}
}
