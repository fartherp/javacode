/*
 * Copyright (c) 2017. CK. All rights reserved.
 */

package com.github.fartherp.javacode;

/**
 * JAVA字段
 * <pre>
 * 1: 注释 2: 注解 3: 作用域 4: final 5: static 6: transient 7: volatile 8: 初始值
 * </pre>
 * Author: CK.
 * Date: 2015/6/6.
 */
public class Field extends JavaElement {
    /** JAVA类型信息 */
    private JavaTypeInfo type;
    /** 字段名 */
    private String name;
    /** 初始值 */
    private String initializationString;
    /** transient */
    private boolean isTransient;
    /** volatile */
    private boolean isVolatile;

    public Field(String name, JavaTypeInfo type) {
        super();
        this.name = name;
        this.type = type;
    }

    public Field(Field field) {
        super(field);
        this.type = field.type;
        this.name = field.name;
        this.initializationString = field.initializationString;
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

        if (isStatic()) {
            sb.append(JavaKeywords.STATIC);
        }

        if (isFinal()) {
            sb.append(JavaKeywords.FINAL);
        }

        if (isTransient()) {
            sb.append(JavaKeywords.TRANSIENT);
        }

        if (isVolatile()) {
            sb.append(JavaKeywords.VOLATILE);
        }

        sb.append(getType().getShortName());
        sb.append(' ');
        sb.append(getName());

        // 设置初始值
        if (isFinal() || getInitializationString() != null) {
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

    public boolean isTransient() {
        return isTransient;
    }

    public Field setTransient(boolean isTransient) {
        this.isTransient = isTransient;
        return this;
    }

    public boolean isVolatile() {
        return isVolatile;
    }

    public Field setVolatile(boolean isVolatile) {
        this.isVolatile = isVolatile;
        return this;
    }
}
