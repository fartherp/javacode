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

import java.util.Set;
import java.util.TreeSet;

import static org.testng.Assert.*;

/**
 * Created by IntelliJ IDEA.
 *
 * @author: CK
 * @date: 2018/1/2
 */
public class JavaTypeInfoTest {
    @Test
    public void testJavaType() {
        JavaTypeInfo javaTypeInfo = new JavaTypeInfo("java.lang.String");
        assertFalse(javaTypeInfo.isExplicitlyImported());
        assertEquals("String", javaTypeInfo.getShortName());
        assertEquals("java.lang.String", javaTypeInfo.getFullyQualifiedName());
        assertEquals("java.lang", javaTypeInfo.getPackageName());
        assertEquals(0, javaTypeInfo.getImportList().size());
    }

    @Test
    public void testSimpleType() {
        JavaTypeInfo javaTypeInfo = new JavaTypeInfo("com.foo.Bar");
        assertTrue(javaTypeInfo.isExplicitlyImported());
        assertEquals("Bar", javaTypeInfo.getShortName());
        assertEquals("com.foo.Bar", javaTypeInfo.getFullyQualifiedName());
        assertEquals("com.foo", javaTypeInfo.getPackageName());
        assertEquals(1, javaTypeInfo.getImportList().size());
        assertEquals("com.foo.Bar", javaTypeInfo.getImportList().get(0));
    }

    @Test
    public void testSimpleType2() {
        JavaTypeInfo javaTypeInfo = new JavaTypeInfo("com.foo.bar");
        assertTrue(javaTypeInfo.isExplicitlyImported());
        assertEquals("bar", javaTypeInfo.getShortName());
        assertEquals("com.foo.bar", javaTypeInfo.getFullyQualifiedName());
        assertEquals("com.foo", javaTypeInfo.getPackageName());
        assertEquals(1, javaTypeInfo.getImportList().size());
        assertEquals("com.foo.bar", javaTypeInfo.getImportList().get(0));
    }

    @Test
    public void testSimpleType3() {
        JavaTypeInfo javaTypeInfo = new JavaTypeInfo("int");
        assertFalse(javaTypeInfo.isExplicitlyImported());
        assertEquals("int", javaTypeInfo.getShortName());
        assertEquals("int", javaTypeInfo.getFullyQualifiedName());
        assertEquals("", javaTypeInfo.getPackageName());
        assertEquals(0, javaTypeInfo.getImportList().size());
    }

    @Test
    public void testGenericType1() {
        JavaTypeInfo javaTypeInfo = new JavaTypeInfo("java.util.List<java.lang.String>");
        assertTrue(javaTypeInfo.isExplicitlyImported());
        assertEquals("List<String>", javaTypeInfo.getShortName());
        assertEquals("java.util.List<java.lang.String>", javaTypeInfo.getFullyQualifiedName());
        assertEquals("java.util", javaTypeInfo.getPackageName());
        assertEquals(1, javaTypeInfo.getImportList().size());
        assertEquals("java.util.List", javaTypeInfo.getImportList().get(0));
        assertEquals("java.util.List", javaTypeInfo.getFullyQualifiedNameWithoutTypeParameters());
    }

    @Test
    public void testGenericType2() {
        JavaTypeInfo javaTypeInfo = new JavaTypeInfo("java.util.Map<java.lang.String, java.util.List<java.lang.String>>");
        assertTrue(javaTypeInfo.isExplicitlyImported());
        assertEquals("Map<String, List<String>>", javaTypeInfo.getShortName());
        assertEquals("java.util.Map<java.lang.String, java.util.List<java.lang.String>>", javaTypeInfo.getFullyQualifiedName());
        assertEquals("java.util", javaTypeInfo.getPackageName());
        assertEquals(2, javaTypeInfo.getImportList().size());
        assertEquals("java.util.Map", javaTypeInfo.getFullyQualifiedNameWithoutTypeParameters());
    }

    @Test
    public void testGenericType3() {
        JavaTypeInfo listOfStrings = new JavaTypeInfo("java.util.List");
        listOfStrings.addTypeArgument(new JavaTypeInfo("java.lang.String"));

        JavaTypeInfo map = new JavaTypeInfo("java.util.Map");
        map.addTypeArgument(new JavaTypeInfo("java.lang.String"));
        map.addTypeArgument(listOfStrings);

        assertTrue(map.isExplicitlyImported());
        assertEquals("Map<String, List<String>>", map.getShortName());
        assertEquals("java.util.Map<java.lang.String, java.util.List<java.lang.String>>", map.getFullyQualifiedName());
        assertEquals("java.util", map.getPackageName());
        assertEquals(2, map.getImportList().size());
        assertEquals("java.util.Map", map.getFullyQualifiedNameWithoutTypeParameters());
    }

    @Test
    public void testGenericType4() {
        JavaTypeInfo javaTypeInfo = new JavaTypeInfo("java.util.List<java.util.Map<java.lang.String, java.lang.Object>>");
        assertTrue(javaTypeInfo.isExplicitlyImported());
        assertEquals("List<Map<String, Object>>", javaTypeInfo.getShortName());
        assertEquals("java.util.List<java.util.Map<java.lang.String, java.lang.Object>>", javaTypeInfo.getFullyQualifiedName());
        assertEquals("java.util", javaTypeInfo.getPackageName());
        assertEquals(2, javaTypeInfo.getImportList().size());
        assertEquals("java.util.List", javaTypeInfo.getFullyQualifiedNameWithoutTypeParameters());
    }

    @Test
    public void testWildcardType1() {
        JavaTypeInfo javaTypeInfo = new JavaTypeInfo("java.util.Map<java.lang.String, ? extends com.foo.Bar>");
        assertTrue(javaTypeInfo.isExplicitlyImported());
        assertEquals("Map<String, ? extends Bar>", javaTypeInfo.getShortName());
        assertEquals("java.util.Map<java.lang.String, ? extends com.foo.Bar>", javaTypeInfo.getFullyQualifiedName());
        assertEquals("java.util", javaTypeInfo.getPackageName());
        assertEquals(2, javaTypeInfo.getImportList().size());
        assertEquals("java.util.Map", javaTypeInfo.getFullyQualifiedNameWithoutTypeParameters());
    }

    @Test
    public void testWildcardType2() {
        JavaTypeInfo javaTypeInfo = new JavaTypeInfo("java.util.Map<java.lang.String, ?>");
        assertTrue(javaTypeInfo.isExplicitlyImported());
        assertEquals("Map<String, ?>", javaTypeInfo.getShortName());
        assertEquals("java.util.Map<java.lang.String, ?>", javaTypeInfo.getFullyQualifiedName());
        assertEquals("java.util", javaTypeInfo.getPackageName());
        assertEquals(1, javaTypeInfo.getImportList().size());
        assertEquals("java.util.Map", javaTypeInfo.getImportList().get(0));
        assertEquals("java.util.Map", javaTypeInfo.getFullyQualifiedNameWithoutTypeParameters());
    }

    @Test
    public void testWildcardType3() {
        JavaTypeInfo javaTypeInfo = new JavaTypeInfo("java.util.Map<? extends java.util.List<?>, ?>");
        assertTrue(javaTypeInfo.isExplicitlyImported());
        assertEquals("Map<? extends List<?>, ?>", javaTypeInfo.getShortName());
        assertEquals("java.util.Map<? extends java.util.List<?>, ?>", javaTypeInfo.getFullyQualifiedName());
        assertEquals("java.util", javaTypeInfo.getPackageName());
        assertEquals(2, javaTypeInfo.getImportList().size());
        assertEquals("java.util.Map", javaTypeInfo.getFullyQualifiedNameWithoutTypeParameters());
    }

    @Test
    public void testWildcardType4() {
        JavaTypeInfo javaTypeInfo = new JavaTypeInfo("java.util.Map<?, ?>");
        assertTrue(javaTypeInfo.isExplicitlyImported());
        assertEquals("Map<?, ?>", javaTypeInfo.getShortName());
        assertEquals("java.util.Map<?, ?>", javaTypeInfo.getFullyQualifiedName());
        assertEquals("java.util", javaTypeInfo.getPackageName());
        assertEquals(1, javaTypeInfo.getImportList().size());
        assertEquals("java.util.Map", javaTypeInfo.getImportList().get(0));
        assertEquals("java.util.Map", javaTypeInfo.getFullyQualifiedNameWithoutTypeParameters());
    }

    @Test
    public void testWildcardType5() {
        JavaTypeInfo javaTypeInfo = new JavaTypeInfo("java.util.List<? extends java.util.Map<? super java.lang.Object, ?>>");
        assertTrue(javaTypeInfo.isExplicitlyImported());
        assertEquals("List<? extends Map<? super Object, ?>>", javaTypeInfo.getShortName());
        assertEquals("java.util.List<? extends java.util.Map<? super java.lang.Object, ?>>", javaTypeInfo.getFullyQualifiedName());
        assertEquals("java.util", javaTypeInfo.getPackageName());
        assertEquals(2, javaTypeInfo.getImportList().size());
        assertEquals("java.util.List", javaTypeInfo.getFullyQualifiedNameWithoutTypeParameters());
    }

    @Test
    public void testUppercasePackage1() {
        JavaTypeInfo javaTypeInfo = new JavaTypeInfo("org.foo.Bar.Inner");
        assertTrue(javaTypeInfo.isExplicitlyImported());
        assertEquals("Inner", javaTypeInfo.getShortName());
        assertEquals("org.foo.Bar.Inner", javaTypeInfo.getFullyQualifiedName());
        assertEquals("org.foo.Bar", javaTypeInfo.getPackageName());
        assertEquals(1, javaTypeInfo.getImportList().size());
        assertEquals("org.foo.Bar.Inner", javaTypeInfo.getImportList().get(0));
    }

    @Test
    public void testUppercasePackage2() {
        JavaTypeInfo javaTypeInfo = new JavaTypeInfo("org.foo.Bar.Inner.Inner");
        assertTrue(javaTypeInfo.isExplicitlyImported());
        assertEquals("Inner", javaTypeInfo.getShortName());
        assertEquals("org.foo.Bar.Inner.Inner", javaTypeInfo.getFullyQualifiedName());
        assertEquals("org.foo.Bar.Inner", javaTypeInfo.getPackageName());
        assertEquals(1, javaTypeInfo.getImportList().size());
        assertEquals("org.foo.Bar.Inner.Inner", javaTypeInfo.getImportList().get(0));
    }

    @Test
    public void testUppercasePackage3() {
        JavaTypeInfo javaTypeInfo = new JavaTypeInfo("java.util.List<org.foo.Bar.Inner>");
        assertTrue(javaTypeInfo.isExplicitlyImported());
        assertEquals("List<Inner>", javaTypeInfo.getShortName());
        assertEquals("java.util.List<org.foo.Bar.Inner>", javaTypeInfo.getFullyQualifiedName());
        assertEquals("java.util", javaTypeInfo.getPackageName());
        assertEquals(2, javaTypeInfo.getImportList().size());
        assertTrue(javaTypeInfo.getImportList().contains("java.util.List"));
        assertTrue(javaTypeInfo.getImportList().contains("org.foo.Bar.Inner"));
    }

    @Test
    public void testImportList() {
        Set<JavaTypeInfo> types = new TreeSet<JavaTypeInfo>();

        types.add(new JavaTypeInfo("foo.bar.Example"));
        types.add(new JavaTypeInfo("foo.bar.Example.Criteria"));
        types.add(new JavaTypeInfo("foo.bar.Example.Criterion"));
        assertEquals(3, types.size());

//        Set<String> imports = OutputUtilities.calculateImports(types);
//        assertEquals(3, imports.size());
    }

    @Test
    public void testByteArray1() {
        JavaTypeInfo javaTypeInfo = new JavaTypeInfo("byte[]");
        assertFalse(javaTypeInfo.isPrimitive());
        assertTrue(javaTypeInfo.isArray());
    }

    @Test
    public void testByteArray2() {
        JavaTypeInfo javaTypeInfo = new JavaTypeInfo("byte[ ]");
        assertFalse(javaTypeInfo.isPrimitive());
        assertTrue(javaTypeInfo.isArray());
    }

    @Test
    public void testStringArray() {
        JavaTypeInfo javaTypeInfo = new JavaTypeInfo("java.lang.String[]");
        assertFalse(javaTypeInfo.isPrimitive());
        assertTrue(javaTypeInfo.isArray());
    }

    @Test
    public void testComplexArray() {
        JavaTypeInfo javaTypeInfo = new JavaTypeInfo("java.util.List<String>[]");
        assertFalse(javaTypeInfo.isPrimitive());
        assertTrue(javaTypeInfo.isArray());
    }

    @Test
    public void testComplexArrayWithoutGenerics() {
        JavaTypeInfo javaTypeInfo = new JavaTypeInfo("java.util.List[]");
        assertFalse(javaTypeInfo.isPrimitive());
        assertTrue(javaTypeInfo.isArray());
        assertTrue(javaTypeInfo.getImportList().contains("java.util.List"));
        assertFalse(javaTypeInfo.getImportList().contains("java.util.List[]"));
    }

    @Test
    public void testPrimitiveJavaType() {
        JavaTypeInfo javaTypeInfo = new JavaTypeInfo("java.lang.Boolean");
        assertTrue(javaTypeInfo.isPrimitive());
    }
}