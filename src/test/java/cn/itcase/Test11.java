package cn.itcase;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Test11 {

    @Test
    public void test1() throws IOException {
        String filepath="E:\\study\\实战源码\\11-物流BOS系统（ssh统合项目二第58-71天）\\BOS-day05\\BOS-day05\\资料\\区域导入测试数据.xls";
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(new FileInputStream(new File(filepath)));
        HSSFSheet sheetAt = hssfWorkbook.getSheetAt(0);
        for(Row row:sheetAt){
            for(Cell cell:row){
                String value = cell.getStringCellValue();
                System.out.println("value="+value);

            }
        }
    }


}
