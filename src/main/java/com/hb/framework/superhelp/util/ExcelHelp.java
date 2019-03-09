package com.hb.framework.superhelp.util;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;

import org.apache.poi.hssf.usermodel.HSSFFormulaEvaluator;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.hb.framework.superhelp.base.ExcelAnnotation;

/**
 * ExcelAnnotation类主要用于excel导出
 * @author
 * @since 1.0
 * @version 1.0
 */
public class ExcelHelp<T> {
    private static String SET="set";
    private static String GET="get";
	Class<T> clazz;
	public ExcelHelp(Class<T> clazz) {
		this.clazz = clazz;
	}
    /**
     * 导出Excel
     * @param title 文件名称
     * @param dataset 数据集合
     * @param out 导出流
     */
	public void exportExcel(String title, Collection<T> dataset,ServletOutputStream out) throws Exception{
			// 首先检查数据看是否是正确的
			Iterator<T> iterator = dataset.iterator();
			if (dataset == null || !iterator.hasNext() || title == null || out == null) {
				if(out!=null){
					  out.close();
					  out=null;
	      		}
				throw new Exception("传入的数据不对！");
			}
			// 创建一个workbook 对应一个excel应用文件 
			HSSFWorkbook workBook = new HSSFWorkbook();  
	        // 在workbook中添加一个sheet,对应Excel文件中的sheet
	    	HSSFSheet sheet=workBook.createSheet(title);
			// 设置表格默认列宽度为20个字节
			sheet.setDefaultColumnWidth(20);
			// 导出的字段的get方法
			Map<String, Method> fieldMap =getFieldOnAnnotion(GET);
			// 产生表格标题行
			Row row = sheet.createRow(0);
			List<String> exportfieldtile = new ArrayList<String>(fieldMap.keySet());
			for (int i = 0; i < exportfieldtile.size(); i++) {
				Cell cell = row.createCell(i);
				cell.setCellValue(exportfieldtile.get(i));
			}

			// 循环整个集合
			int index = 0;
			iterator = dataset.iterator();
			while (iterator.hasNext()) {
				// 从第二行开始写，第一行是标题
				index++;
				row = sheet.createRow(index);
				T t = iterator.next();
				for (int k = 0; k < exportfieldtile.size(); k++) {
					Cell cell = row.createCell(k);
					Method getMethod = fieldMap.get(exportfieldtile.get(k));
					Object value = getMethod.invoke(t);
					String textValue = null;
					if (value == null) {
					   textValue="";
					}else if (value instanceof Boolean) {
						   textValue = "是";
						if (!(Boolean)value) {
							textValue = "否";
						}
					}else if (value instanceof Date) {
						textValue = Common.fromDateToH((Date) value);
					}else {
						textValue = value.toString();
					}
					cell.setCellValue(textValue);
				}
			}
			workBook.write(out);
			out.flush();
			if(out!=null){
				  out.close();
				  out=null;
      		}
	}
	//判断文件类型
    public Workbook createWorkBook(InputStream is,String fileName) throws IOException{
        if(fileName.endsWith("xls")){
            return new HSSFWorkbook(is);
        }else if(fileName.endsWith("xlsx")){
            return new XSSFWorkbook(is);
        }else {return null;}
    }
	
	/**
	 * 导入excle
	 * @param file 文件
	 * @return 返回对应的 Collection<T>
	 */
	public Collection<T> importExcel(InputStream file,String fileName,int tnum,int cnum) throws Exception{
		Collection<T> dist = new ArrayList<T>();
			Map<String, Method> fieldMap =getFieldOnAnnotion(SET);
			/**
			 * excel的解析开始
			 */
			// 将传入的File构造为FileInputStream;
			// 得到工作表
			Workbook book =createWorkBook(file,fileName);
			if(book==null){if(file!=null){file.close();file=null;}throw new Exception("导入文件格式不对");}
			//判断有几张活动的sheet表 
			int length = book.getNumberOfSheets();
			for(int k=0; k<length; k++){ 
				Sheet sheet = book.getSheetAt(k);
				// 得到第一面的所有行
				Iterator<Row> row = sheet.rowIterator();
				/**
				 * 标题解析
				 */
				
				//定位到标题也就是标题行
				for(int i=1;i<tnum;i++){
					row.next();
				}
				Row titleRow=row.next();
				// 得到第一行的所有列
				Iterator<Cell> cellTitle = titleRow.cellIterator();
				// 将标题的文字内容放入到一个map中
				Map<Integer, String> titleMap = new HashMap<Integer, String>();
				// 从标题第一列开始
				int i = 0;
				// 循环标题所有的列
				while (cellTitle.hasNext()){
					Cell cell = (Cell) cellTitle.next();
					String value = cell.getStringCellValue();
					if(value!=null && value!=""){
					  titleMap.put(i, value.trim());
					}
					i++;
				}
				//定位到内容
				for(int j=1;j<cnum-tnum;j++){
					row.next();
				}
				/**
				 * 解析内容行
				 */
				while (row.hasNext()) {
					
					Row rown =row.next();
					// 行的所有列
					Iterator<Cell> cellBody = rown.cellIterator();
					// 得到传入类的实例
					T tObject = clazz.newInstance();
					// 遍历一行的列
					int col = 0;
					while (cellBody.hasNext()) {
						Cell cell = (Cell) cellBody.next();
						// 这里得到此列的对应的标题
						String titleString = titleMap.get(col++);
						// 如果这一列的标题和类中的某一列的Annotation相同，那么则调用此类的的set方法，进行设值
						if (fieldMap.containsKey(titleString)) {
							//取得单元格值
							Object value=ConvertCellStr(cell,book);
							Method setMethod = fieldMap.get(titleString);
							// 得到setter方法的参数
							Class<?>[] clazz = setMethod.getParameterTypes();  
			                String xclass = clazz[0].getName();
							// 判断参数类型
							if ("java.lang.String".equals(xclass)) {
								setMethod.invoke(tObject, value.toString());
							} else if ("java.util.Date".equals(xclass)) {
								setMethod.invoke(tObject,(Date)value);
							} else if ("java.lang.Boolean".equals(xclass)) {
								Boolean boolName = true;
								if ("否".equals(value)) {
									boolName = false;
								}
								setMethod.invoke(tObject, boolName);
							} else if (xclass.toLowerCase().contains("int")) {
								setMethod.invoke(tObject,Integer.parseInt(value.toString()));
							} else if (xclass.toLowerCase().contains("long")) {
								setMethod.invoke(tObject, (Long)value);
							} else if (xclass.toLowerCase().contains("double")) {
								setMethod.invoke(tObject, Double.parseDouble(value.toString()));
							} else if (xclass.toLowerCase().contains("float")) {
								setMethod.invoke(tObject, (Float)value);
							}else {
								setMethod.invoke(tObject, value);
							}
						}
					}
					dist.add(tObject);
				}
			}
			if(file!=null){file.close();file=null;}
		return dist;
	}
	
	
	/**
	 * 得到操作对象中需要导入或导出的属性和方法
	 * @param type 导入则set导出为get
	 * @return 返回一个Map<String 导出或导入文件列的名称(即属性注解名称),Method 属性对应的set或get方法>
	 * @throws SecurityException
	 * @throws NoSuchMethodException
	 */
	public Map<String, Method> getFieldOnAnnotion(String type) throws SecurityException, NoSuchMethodException{
		// 得到目标目标类的所有的字段列表
		Field[] fields = clazz.getDeclaredFields();
		// 将所有标有Annotation的字段，也就是允许导入数据的字段,放入到一个map中
		Map<String, Method> fieldMap = new HashMap<String, Method>();
		// 循环读取所有字段
		for (Field field : fields) {
			// 得到单个字段上的Annotation
			ExcelAnnotation excelAnnotation = field.getAnnotation(ExcelAnnotation.class);
			// 如果标识了Annotationd
			if (excelAnnotation != null) {
				String fieldName = field.getName();
				// 构造设置了Annotation的字段的set或get方法
				String methodName = type+ fieldName.substring(0, 1).toUpperCase()+ fieldName.substring(1);
				// 构造调用的method
				Method method =null;
				if(GET.equals(type)){
				   method = clazz.getMethod(methodName);
				}else{
				   method = clazz.getMethod(methodName,field.getType());
				}
				// 将这个method以Annotaion的名字为key来存入
				fieldMap.put(excelAnnotation.exportName(), method);
			}
		}
		return fieldMap;
	}
	
    /** 
     * 把单元格内的类型转换至String类型 
     */  
	private Object ConvertCellStr(Cell cell, Workbook wb) {
		Object cellStr="";
		FormulaEvaluator eval = null;
		if (wb instanceof HSSFWorkbook)
			eval = new HSSFFormulaEvaluator((HSSFWorkbook) wb);
		else if (wb instanceof XSSFWorkbook)
			eval = new XSSFFormulaEvaluator((XSSFWorkbook) wb);
		CellValue cellValue = eval.evaluate(cell);
		if (cellValue == null) {
			return cellStr;
		}
		switch (cellValue.getCellType()) {
		case Cell.CELL_TYPE_BOOLEAN:
			cellStr = cellValue.getBooleanValue();
			break;
		case Cell.CELL_TYPE_NUMERIC:
			// 这里的日期类型会被转换为数字类型，需要判别后区分处理
			if (DateUtil.isCellDateFormatted(cell)) {
				cellStr = cell.getDateCellValue();
			} else {
				cellStr = cellValue.getNumberValue();
				
			}
			break;
		case Cell.CELL_TYPE_STRING:
			cellStr = cellValue.getStringValue();
			break;
		case Cell.CELL_TYPE_FORMULA:
			break;
		case Cell.CELL_TYPE_BLANK:
			break;
		case Cell.CELL_TYPE_ERROR:
			break;
		default:
			break;
		}
		return cellStr;
	}
}