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

/**
 * JAVA字段
 * <pre>
 * 1: 注释 2: 注解 3: 作用域 4: final 5: static 6: transient 7: volatile 8: 初始值
 * </pre>
 * @author CK.
 * @date: 2015/6/6.
 */
public class Field extends BaseJavaElement {
    /** JAVA类型信息 */
    private JavaTypeInfo type;
    /** 字段名 */
    private String name;
    /** 初始值 */
    private String initializationString;
    /** transient */
    private boolean ifTransient;
    /** volatile */
    private boolean ifVolatile;

    public Field(String name, JavaTypeInfo type) {
        super();
        this.name = name;
        this.type = type;
    }

    public Field(Field field) {
        super(field);
        this.type = field.getType();
        this.name = field.getName();
        this.initializationString = field.getInitializationString();
        this.ifTransient = field.isIfTransient();
    }

    public String getName() {
        return name;
    }

    public JavaTypeInfo getType() {
        return type;
    }

    public String getInitializationString() {
        return initializationString;
    }

    public void setInitializationString(String initializationString) {
        this.initializationString = initializationString;
    }

    public String getFormattedContent(int indentLevel) {
        StringBuilder sb = new StringBuilder();

        addCommonFormatted(sb, indentLevel);

        sb.append(getJavaScope());

        if (isIfStatic()) {
            sb.append(JavaKeywords.STATIC);
        }

        if (isIfFinal()) {
            sb.append(JavaKeywords.FINAL);
        }

        if (isIfTransient()) {
            sb.append(JavaKeywords.TRANSIENT);
        }

        if (isIfVolatile()) {
            sb.append(JavaKeywords.VOLATILE);
        }

        sb.append(getType().getShortName());
        sb.append(' ');
        sb.append(getName());

        // 设置初始值
        if (isIfFinal() || getInitializationString() != null) {
            sb.append(" = ");
            if (String.class.getName().equals(getType().getFullyQualifiedName())) {
                sb.append('"');
                sb.append(getInitializationString());
                sb.append('"');
            } else {
                sb.append(getInitializationString());
            }
        }

        sb.append(';');

        return sb.toString();
    }

    public boolean isIfTransient() {
        return ifTransient;
    }

    public Field setIfTransient(boolean isTransient) {
        this.ifTransient = isTransient;
        return this;
    }

    public boolean isIfVolatile() {
        return ifVolatile;
    }

    public Field setIfVolatile(boolean isVolatile) {
        this.ifVolatile = isVolatile;
        return this;
    }
}
