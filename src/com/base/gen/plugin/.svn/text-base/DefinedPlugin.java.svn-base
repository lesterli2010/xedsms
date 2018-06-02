package com.base.gen.plugin;

import java.util.List;

import org.mybatis.generator.api.PluginAdapter;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.api.dom.java.Interface;
import org.mybatis.generator.api.dom.java.JavaVisibility;
import org.mybatis.generator.api.dom.java.TopLevelClass;

public class DefinedPlugin extends PluginAdapter {

    private FullyQualifiedJavaType entity;
    private FullyQualifiedJavaType example;
    private FullyQualifiedJavaType mapper;

    public DefinedPlugin() {
        super();
        entity = new FullyQualifiedJavaType("com.hxdq.xedsms.db.Entity"); 
        example = new FullyQualifiedJavaType("com.hxdq.xedsms.db.Example"); 
        mapper = new FullyQualifiedJavaType("com.hxdq.xedsms.db.Mapper"); 

    }

    public boolean validate(List<String> warnings) {
        // this plugin is always valid
        return true;
    }

    @Override
    public boolean modelBaseRecordClassGenerated(TopLevelClass topLevelClass,
            IntrospectedTable introspectedTable) {
    	addEntity(topLevelClass, introspectedTable);
        return true;
    }

    @Override
    public boolean modelPrimaryKeyClassGenerated(TopLevelClass topLevelClass,
            IntrospectedTable introspectedTable) {
    	addEntity(topLevelClass, introspectedTable);
        return true;
    }

    @Override
    public boolean modelRecordWithBLOBsClassGenerated(
            TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {
    	addEntity(topLevelClass, introspectedTable);
        return true;
    }
    
    @Override
    public boolean modelExampleClassGenerated(TopLevelClass topLevelClass,
            IntrospectedTable introspectedTable) {
    	addExample(topLevelClass, introspectedTable);
        return true;
    }
    
    @Override
    public boolean clientGenerated(Interface interfaze,
            TopLevelClass topLevelClass,
            IntrospectedTable introspectedTable) {
    	addMapper(interfaze, topLevelClass, introspectedTable);
        return true;
    }
    protected void addEntity(TopLevelClass topLevelClass,
            IntrospectedTable introspectedTable) {
        topLevelClass.addImportedType(entity);
        topLevelClass.setSuperClass(entity);
        
        Field field = new Field();
        field.setFinal(true);
        field.setInitializationString("1L"); //$NON-NLS-1$
        field.setName("serialVersionUID"); //$NON-NLS-1$
        field.setStatic(true);
        field.setType(new FullyQualifiedJavaType("long")); //$NON-NLS-1$
        field.setVisibility(JavaVisibility.PRIVATE);

        context.getCommentGenerator().addFieldComment(field, introspectedTable);

    }
    protected void addExample(TopLevelClass topLevelClass,
            IntrospectedTable introspectedTable) {
        topLevelClass.addImportedType(example);
        topLevelClass.setSuperClass(example);
    }
    protected void addMapper(Interface interfaze,
            TopLevelClass topLevelClass,
            IntrospectedTable introspectedTable) {
    	interfaze.addImportedType(mapper);
    	interfaze.addSuperInterface(mapper);
    }
}