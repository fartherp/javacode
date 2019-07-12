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
