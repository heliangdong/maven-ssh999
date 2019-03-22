package cn.itcast.crm.action;

import cn.itcast.crm.action.base.BaseAction;
import cn.itcast.crm.domain.Region;
import cn.itcast.crm.domain.Subarea;
import cn.itcast.crm.service.SubareaServer;
import cn.itcast.crm.utils.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletOutputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

@Controller
@Scope("prototype")
public class SubareaAction extends BaseAction<Subarea> {
    @Autowired
    private SubareaServer subareaServer;

    public String save(){
        subareaServer.save(model);
        return  "list";
    }

    public String pageQuery(){


        DetachedCriteria dc=pageBean.getDetachedCriteria();
        String addresskey = model.getAddresskey();
        if(addresskey!=null){
            dc.add(Restrictions.like("addresskey","%"+addresskey+"%"));
        }
        Region region = model.getRegion();
        if(region!=null){
            String province = region.getProvince();
            String city = region.getCity();
            String district = region.getDistrict();
            dc.createAlias("region","r");
            if(province!=null){
                dc.add(Restrictions.like("r.province","%"+province+"%"));
            }
            if(city!=null){
                dc.add(Restrictions.like("r.city","%"+city+"%"));
            }
            if(district!=null){
                dc.add(Restrictions.like("r.district","%"+district+"%"));
            }
        }

        subareaServer.pageQuery(pageBean);
        this.java2Json(pageBean,new String[]{"currentPage","detachedCriteria","pageSize",
                "decidedzone","subareas"});
        return null;
    }

    public String exportXls() throws IOException {
        List<Subarea> list=subareaServer.getall();
        //在内存中创建一个EXECL
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook();
        //创建一个标签页面
        HSSFSheet sheet = hssfWorkbook.createSheet("分区数据");
        //创建标题行
        HSSFRow row = sheet.createRow(0);
        row.createCell(0).setCellValue("分区编码");
        row.createCell(1).setCellValue("开始编码");
        row.createCell(2).setCellValue("结束编码");
        row.createCell(3).setCellValue("位置信息");
        row.createCell(4).setCellValue("省市区");

        for(Subarea subarea:list){
            HSSFRow dataRow = sheet.createRow(sheet.getLastRowNum() + 1);
            dataRow.createCell(0).setCellValue(subarea.getId());
            dataRow.createCell(1).setCellValue(subarea.getStartnum());
            dataRow.createCell(2).setCellValue(subarea.getEndnum());
            dataRow.createCell(3).setCellValue(subarea.getPosition());
            dataRow.createCell(4).setCellValue(subarea.getRegion().getName());

        }

        //第三部 使用流下载文件
        String filename="分区下载.xls";
        String contentType = ServletActionContext.getServletContext().getMimeType(filename);
        ServletOutputStream out = ServletActionContext.getResponse().getOutputStream();
        ServletActionContext.getResponse().setContentType(contentType);

        //获取客户端浏览器类型
        String agent = ServletActionContext.getRequest().getHeader("User-Agent");
        filename  = FileUtils.encodeDownloadFilename(filename, agent);
        ServletActionContext.getResponse().setHeader("content-disposition", "attachment;filename="+filename);
        hssfWorkbook.write(out);
        return  null;
    }

    public String listajax(){
        List<Subarea> list=subareaServer.findListNotAssociation();
        this.java2Json(list,new String[]{"decidedzone","region"});
        return  null;
    }

    //属性驱动，接收定区id
    private String decidedzoneId;

    public String findListByDecidedzoneId(){
        List<Subarea> list= subareaServer.findListByDecidedzoneId(decidedzoneId);
        this.java2Json(list,new String[]{"decidedzone","subareas"});
        return null;
    }

    public String getDecidedzoneId() {
        return decidedzoneId;
    }

    public void setDecidedzoneId(String decidedzoneId) {
        this.decidedzoneId = decidedzoneId;
    }
}
