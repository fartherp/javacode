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
package com.github.fartherp.javacode.formatter;

import com.github.fartherp.javacode.JavaKeywords;
import com.github.fartherp.javacode.JavaTypeInfo;
import com.github.fartherp.javacode.TopLevelClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @author CK
 * @date 2017/12/28
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
