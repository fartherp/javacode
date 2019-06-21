package com.github.fartherp.javacode.formatter;

import com.github.fartherp.javacode.JavaKeywords;
import com.github.fartherp.javacode.JavaTypeInfo;
import com.github.fartherp.javacode.TopLevelClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: CK
 * @date: 2017/12/28
 */
public class DefaultJavaFormatterTest {

	@Test
	public void testGetFormattedContent() {
		JavaFormatter javaFormatter = new DefaultJavaFormatter();
		TopLevelClass topLevelClass = new TopLevelClass(new JavaTypeInfo(""));
		topLevelClass.setJavaScope(JavaKeywords.PUBLIC);
		String str = javaFormatter.getFormattedContent(topLevelClass);
		assertNotNull(str);
	}
}
