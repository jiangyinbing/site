package com.hb.framework.superhelp.base;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
 
/**
 * ExcelAnnotation类主要用于excel导出,导入
 * @author
 * @since 1.0
 * @version 1.0
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ExcelAnnotation {
     // excel导出时标题显示的名字，如果没有设置Annotation属性，将不会被导出和导入
    public String exportName();
}