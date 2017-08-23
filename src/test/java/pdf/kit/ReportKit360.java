package pdf.kit;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.exception.ExceptionUtils;
import pdf.kit.component.PDFHeaderFooter;
import pdf.kit.component.PDFKit;
import pdf.kit.component.chart.Line;
import pdf.kit.component.chart.impl.DefaultLineChart;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fgm on 2017/4/17.
 * 360报告
 *
 */
@Slf4j
public class ReportKit360 {

    public static List<Line> getTemperatureLineList() {
        List<Line> list= Lists.newArrayList();
        for(int i=1;i<=7;i++){
            Line line=new Line();
            float random=Math.round(Math.random()*10);
            line.setXValue("星期"+i);
            line.setYValue(20+random);
            line.setGroupName("下周");
            list.add(line);
        }
        for(int i=1;i<=7;i++){
            Line line=new Line();
            float random=Math.round(Math.random()*10);
            line.setXValue("星期"+i);
            line.setYValue(20+random);
            line.setGroupName("这周");
            list.add(line);
        }
        return list;
    }

    public  String createPDF(Object data, String fileName){
        //pdf保存路径
        try {
            //设置自定义PDF页眉页脚工具类
            PDFHeaderFooter headerFooter=new PDFHeaderFooter();
            PDFKit kit=new PDFKit();
            kit.setHeaderFooterBuilder(headerFooter);
            //设置输出路径
            kit.setSaveFilePath("/home/huang/pdf/hello.pdf");
            String saveFilePath=kit.exportToFile(fileName,data);
            return  saveFilePath;
        } catch (Exception e) {
            log.error("PDF生成失败{}", ExceptionUtils.getFullStackTrace(e));
            return null;
        }

    }

    public static void main(String[] args) {

        ReportKit360 kit=new ReportKit360();

        TemplateBO templateBO=new TemplateBO();
        templateBO.setTemplateName("个人信息查询使用授权文件_510502197106131116");
        templateBO.setFreeMarkerUrl("黄卫东");
        templateBO.setITEXTUrl("哈哈哈哈哈哈哈哈哈哈哈哈哈哈");
        templateBO.setJFreeChartUrl("http://www.yiibai.com/jfreechart/jfreechart_referenced_apis.html");
        templateBO.setImageUrl("http://mss.vip.sankuai.com/v1/mss_74e5b6ab17f44f799a524fa86b6faebf/360report/logo_1.png");

        List<String> scores=new ArrayList<String>();
        scores.add("90");
        scores.add("95");
        scores.add("98");
        templateBO.setScores(scores);

//        List<Line> lineList=getTemperatureLineList();
//
//        DefaultLineChart lineChart=new DefaultLineChart();
//        lineChart.setHeight(500);
//        lineChart.setWidth(300);
//
//        String picUrl=lineChart.draw(lineList,0);
//
        templateBO.setPicUrl("");

        String path= kit.createPDF(templateBO,"hello.pdf");
        System.out.println(path);



    }






}
