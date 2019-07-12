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
import java.util.ListIterator;

/**
 * 初始块
 * <pre> For example:
 * static {
 *
 * }
 * </pre>
 * Author: CK
 * Date: 2015/7/8.
 */
public class InitializationBlock {
    /** 是否静态 */
    private boolean ifStatic;
    /** 具体内容list */
    private List<String> bodyLines;
    /** 注解list */
    private List<String> javaDocLines;

    public InitializationBlock() {
        this(false);
    }

    public InitializationBlock(boolean isStatic) {
        this.ifStatic = isStatic;
        this.bodyLines = new ArrayList<>();
		this.javaDocLines = new ArrayList<>();
    }

    public boolean isIfStatic() {
        return ifStatic;
    }

    public List<String> getBodyLines() {
        return bodyLines;
    }

    public void addBodyLine(String line) {
        bodyLines.add(line);
    }

    public void addBodyLines(Collection<String> lines) {
        if (lines != null && lines.size() > 0) {
            bodyLines.addAll(lines);
        }
    }

    public List<String> getJavaDocLines() {
        return javaDocLines;
    }

    public void addJavaDocLine(String javaDocLine) {
        javaDocLines.add(javaDocLine);
    }

    public void addJavaDocLines(Collection<String> lines) {
        if (lines != null && lines.size() > 0) {
            javaDocLines.addAll(lines);
        }
    }

    public String getFormattedContent(int indentLevel) {
        StringBuilder sb = new StringBuilder();

        // 注释
        for (String javaDocLine : getJavaDocLines()) {
            OutputUtil.javaIndent(sb, indentLevel);
            sb.append(javaDocLine);
            OutputUtil.newLine(sb);
        }

        OutputUtil.javaIndent(sb, indentLevel);

        if (isIfStatic()) {
            sb.append(JavaKeywords.STATIC);
        }

        sb.append('{');
        indentLevel++;

        ListIterator<String> listIter = getBodyLines().listIterator();
        while (listIter.hasNext()) {
            String line = listIter.next();
            if (line.startsWith("}")) { 
                indentLevel--;
            }

            OutputUtil.newLine(sb);
            OutputUtil.javaIndent(sb, indentLevel);
            sb.append(line);

            if ((line.endsWith("{") && !line.startsWith(JavaKeywords.SWITCH)) || line.endsWith(":")) {
                indentLevel++;
            }

            if (line.startsWith(JavaKeywords.BREAK)) {
                // if the next line is '}', then don't outdent
                if (listIter.hasNext()) {
                    String nextLine = listIter.next();
                    if (nextLine.startsWith("}")) { 
                        indentLevel++;
                    }

                    // set back to the previous element
                    listIter.previous();
                }
                indentLevel--;
            }
        }

        indentLevel--;
        OutputUtil.newLine(sb);
        OutputUtil.javaIndent(sb, indentLevel);
        sb.append('}');

        return sb.toString();
    }
}
