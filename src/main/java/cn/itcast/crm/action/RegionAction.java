package cn.itcast.crm.action;

import cn.itcast.crm.action.base.BaseAction;
import cn.itcast.crm.domain.Region;
import cn.itcast.crm.service.RegionServer;
import cn.itcast.crm.utils.PinYin4jUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@Controller
@Scope("prototype")
public class RegionAction extends BaseAction<Region> {

    @Autowired
    private RegionServer regionServer;
    private File regionFile;

    //区域导入
    public String importXLS() throws IOException {
        List<Region> list=new ArrayList<Region>();
        //使用POI解析Excel文件
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(new FileInputStream(regionFile));
        //根据名称获取Sheet对象
        HSSFSheet sheet1 = hssfWorkbook.getSheet("sheet1");
        for(Row row:sheet1){
            int rowNum=row.getRowNum();
            if(rowNum==0){
                continue;
            }
            String id=row.getCell(0).getStringCellValue();
            String province=row.getCell(1).getStringCellValue();
            String city=row.getCell(2).getStringCellValue();
            String district = row.getCell(3).getStringCellValue();
            String postcode = row.getCell(4).getStringCellValue();
            //包装一个区域对象
            Region region = new Region(id, province, city, district, postcode, null, null, null);
            province=province.substring(0,province.length()-1);
            city = city.substring(0, city.length() - 1);
            district = district.substring(0, district.length() - 1);
            String info=province+city+district;
            String[] headByString = PinYin4jUtils.getHeadByString(info);
            String shortcode = StringUtils.join(headByString);
            //城市编码
            String citycode=PinYin4jUtils.hanziToPinyin(city,"");

            region.setShortcode(shortcode);
            region.setCitycode(citycode);
            list.add(region);
        }
            regionServer.saveBeth(list);

        return null;

    }
    //区域分页查询
    public String pageQuery(){
        System.out.println("pageBean"+pageBean);
        regionServer.pageQuery(pageBean);
        this.java2Json(pageBean,new String[]{"currentPage","detachedCriteria","pageSize","subareas"});
        return null;
    }

    //查询所有区域，返回JSON
    private  String q;
    public  String listajax(){
        List<Region> regionlist=null;
        if(q!=null){
            regionlist=regionServer.listajax(q);
        }else{
            regionlist=regionServer.listajax();
        }

        this.java2Json(regionlist,new String[]{"subareas"});
        return  null;
    }








    public File getRegionFile() {
        return regionFile;
    }

    public void setRegionFile(File regionFile) {
        this.regionFile = regionFile;
    }

    public String getQ() {
        return q;
    }
    public void setQ(String q) {
        this.q = q;
    }
}
