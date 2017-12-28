/*
 * Copyright (c) 2017. CK. All rights reserved.
 */

package com.github.fartherp.javacode;

import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: CK
 * @date: 2017/12/28
 */
public class CompilationUnitTest {
    @Test
    public void testGetFormattedContent() throws Exception {
        TopLevelClass topLevelClass = new TopLevelClass(new JavaTypeInfo(""));
        topLevelClass.setJavaScope(JavaKeywords.PUBLIC);
    }

}