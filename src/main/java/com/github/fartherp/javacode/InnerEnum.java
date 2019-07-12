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
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * 枚举
 * Author: CK
 * Date: 2015/6/7
 */
public class InnerEnum extends JavaElement {

    /** 字段 */
    private List<Field> fields;

    /** 内部类 */
    private List<InnerClass> innerClasses;

    /** 内部枚举 */
    private List<InnerEnum> innerEnums;

    /** JAVA类型 */
    private JavaTypeInfo type;

    /** 父接口 */
    private Set<JavaTypeInfo> superInterfaceTypes;

    /** 方法列表 */
    private List<Method> methods;

    /** 枚举常量 */
    private List<String> enumConstants;

    public InnerEnum(JavaTypeInfo type) {
        super();
        this.type = type;
		this.fields = new ArrayList<>();
		this.innerClasses = new ArrayList<>();
		this.innerEnums = new ArrayList<>();
		this.superInterfaceTypes = new HashSet<>();
		this.methods = new ArrayList<>();
		this.enumConstants = new ArrayList<>();
    }

    public List<Field> getFields() {
        return fields;
    }

    public void addField(Field field) {
        fields.add(field);
    }

    public void addFields(Collection<Field> collection) {
        if (collection != null && collection.size() > 0) {
            fields.addAll(collection);
        }
    }

    public List<InnerClass> getInnerClasses() {
        return innerClasses;
    }

    public void addInnerClass(InnerClass innerClass) {
        innerClasses.add(innerClass);
    }

    public void addInnerClasses(Collection<InnerClass> collection) {
        if (collection != null && collection.size() > 0) {
            innerClasses.addAll(collection);
        }
    }

    public List<InnerEnum> getInnerEnums() {
        return innerEnums;
    }

    public void addInnerEnum(InnerEnum innerEnum) {
        innerEnums.add(innerEnum);
    }

    public void addInnerEnums(Collection<InnerEnum> collection) {
        if (collection != null && collection.size() > 0) {
            innerEnums.addAll(collection);
        }
    }

    public List<String> getEnumConstants() {
        return enumConstants;
    }

    public void addEnumConstant(String enumConstant) {
        enumConstants.add(enumConstant);
    }

    public void addEnumConstants(Collection<String> collection) {
        if (collection != null && collection.size() > 0) {
            enumConstants.addAll(collection);
        }
    }

    public String getFormattedContent(int indentLevel) {
        StringBuilder sb = new StringBuilder();

        addCommonFormatted(sb, indentLevel);

        if (JavaKeywords.PUBLIC.equals(getJavaScope())) {
            sb.append(getJavaScope());
        }

        sb.append(JavaKeywords.ENUM);
        sb.append(getType().getShortName());

        if (superInterfaceTypes.size() > 0) {
            sb.append(JavaKeywords.IMPLEMENTS);

            boolean comma = false;
            for (JavaTypeInfo fqjt : superInterfaceTypes) {
                if (comma) {
                    sb.append(", "); 
                } else {
                    comma = true;
                }

                sb.append(fqjt.getShortName());
            }
        }

        sb.append(" {"); 
        indentLevel++;

        Iterator<String> strIter = enumConstants.iterator();
        while (strIter.hasNext()) {
            OutputUtil.newLine(sb);
            OutputUtil.javaIndent(sb, indentLevel);
            String enumConstant = strIter.next();
            sb.append(enumConstant);

            if (strIter.hasNext()) {
                sb.append(',');
            } else {
                sb.append(';');
            }
        }

        if (fields.size() > 0) {
            OutputUtil.newLine(sb);
        }

        Iterator<Field> fldIter = fields.iterator();
        while (fldIter.hasNext()) {
            OutputUtil.newLine(sb);
            Field field = fldIter.next();
            sb.append(field.getFormattedContent(indentLevel));
            if (fldIter.hasNext()) {
                OutputUtil.newLine(sb);
            }
        }

        if (methods.size() > 0) {
            OutputUtil.newLine(sb);
        }

        Iterator<Method> mtdIter = methods.iterator();
        while (mtdIter.hasNext()) {
            OutputUtil.newLine(sb);
            Method method = mtdIter.next();
            sb.append(method.getFormattedContent(indentLevel, false));
            if (mtdIter.hasNext()) {
                OutputUtil.newLine(sb);
            }
        }

        if (innerClasses.size() > 0) {
            OutputUtil.newLine(sb);
        }

        Iterator<InnerClass> icIter = innerClasses.iterator();
        while (icIter.hasNext()) {
            OutputUtil.newLine(sb);
            InnerClass innerClass = icIter.next();
            sb.append(innerClass.getFormattedContent(indentLevel));
            if (icIter.hasNext()) {
                OutputUtil.newLine(sb);
            }
        }

        if (innerEnums.size() > 0) {
            OutputUtil.newLine(sb);
        }

        Iterator<InnerEnum> ieIter = innerEnums.iterator();
        while (ieIter.hasNext()) {
            OutputUtil.newLine(sb);
            InnerEnum innerEnum = ieIter.next();
            sb.append(innerEnum.getFormattedContent(indentLevel));
            if (ieIter.hasNext()) {
                OutputUtil.newLine(sb);
            }
        }

        indentLevel--;
        OutputUtil.newLine(sb);
        OutputUtil.javaIndent(sb, indentLevel);
        sb.append('}');

        return sb.toString();
    }

    public Set<JavaTypeInfo> getSuperInterfaceTypes() {
        return superInterfaceTypes;
    }

    public void addSuperInterface(JavaTypeInfo superInterface) {
        superInterfaceTypes.add(superInterface);
    }

    public void addSuperInterfaces(Collection<JavaTypeInfo> collection) {
        if (collection != null && collection.size() > 0) {
            superInterfaceTypes.addAll(collection);
        }
    }

    public List<Method> getMethods() {
        return methods;
    }

    public void addMethod(Method method) {
        methods.add(method);
    }

    public void addMethods(Collection<Method> collection) {
        if (collection != null && collection.size() > 0) {
            methods.addAll(collection);
        }
    }

    public JavaTypeInfo getType() {
        return type;
    }
}
