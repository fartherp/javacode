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

import com.github.fartherp.javacode.utils.OutputUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * JAVA元素(类/字段)公共信息
 * 1: 注释, 2: 注解, 3: 作用域, 4: final, 5: static
 * @author CK.
 * @date 2015/6/6.
 */
public abstract class BaseJavaElement {

    /** JAVA注释 */
    private List<String> javaDocLines;

    /** JAVA作用域 */
    private String javaScope = JavaKeywords.DEFAULT;

    /** static */
    private boolean ifStatic;

    /** final */
    private boolean ifFinal;

    /** JAVA注解 */
    private List<String> annotations;

    public BaseJavaElement() {
        super();
        this.javaDocLines = new ArrayList<>();
		this.annotations = new ArrayList<>();
    }

    public BaseJavaElement(BaseJavaElement original) {
        this();
        this.addAnnotations(original.getAnnotations());
        this.setIfFinal(original.isIfFinal());
        this.setIfStatic(original.isIfStatic());
        this.addJavaDocLines(original.getJavaDocLines());
        this.setJavaScope(original.getJavaScope());
    }

    public List<String> getJavaDocLines() {
        return javaDocLines;
    }

    public void addJavaDocLine(String javaDocLine) {
        javaDocLines.add(javaDocLine);
    }

    public void addJavaDocLines(Collection<String> javaDocLine) {
        if (javaDocLine != null && javaDocLine.size() > 0) {
            javaDocLines.addAll(javaDocLine);
        }
    }

    protected void addFormattedJavadoc(StringBuilder sb, int indentLevel) {
        for (String javaDocLine : javaDocLines) {
            OutputUtil.javaIndent(sb, indentLevel);
            sb.append(javaDocLine);
            OutputUtil.newLine(sb);
        }
    }

    public List<String> getAnnotations() {
        return annotations;
    }

    public void addAnnotation(String annotation) {
        annotations.add(annotation);
    }

    public void addAnnotations(Collection<String> collection) {
        if (collection != null && collection.size() > 0) {
            annotations.addAll(collection);
        }
    }

    public void addSuppressTypeWarningsAnnotation() {
        addAnnotation("@SuppressWarnings(\"unchecked\")"); 
    }

    protected void addFormattedAnnotations(StringBuilder sb, int indentLevel) {
        for (String annotation : annotations) {
            OutputUtil.javaIndent(sb, indentLevel);
            sb.append(annotation);
            OutputUtil.newLine(sb);
        }
    }

    public String getJavaScope() {
        return javaScope;
    }

    public void setJavaScope(String javaScope) {
        this.javaScope = javaScope;
    }

    public boolean isIfFinal() {
        return ifFinal;
    }

    public void setIfFinal(boolean isFinal) {
        this.ifFinal = isFinal;
    }

    public boolean isIfStatic() {
        return ifStatic;
    }

    public void setIfStatic(boolean isStatic) {
        this.ifStatic = isStatic;
    }

    protected void addCommonFormatted(StringBuilder sb, int indentLevel) {
        // JAVA类注释
        addFormattedJavadoc(sb, indentLevel);
        // JAVA类注解
        addFormattedAnnotations(sb, indentLevel);

        OutputUtil.javaIndent(sb, indentLevel);
    }
}
