package pdf.kit;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.exception.ExceptionUtils;
import pdf.kit.component.PDFHeaderFooter;
import pdf.kit.component.PDFKit;
import pdf.kit.component.chart.Line;
import pdf.kit.component.chart.impl.DefaultLineChart;

import java.util.ArrayList;
import java.util.HashMap;
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
            kit.setSaveFilePath("/home/huang/pdf/authorization_template.pdf");
            String saveFilePath=kit.exportToFile(fileName,data);
            return  saveFilePath;
        } catch (Exception e) {
            log.error("PDF生成失败{}", ExceptionUtils.getFullStackTrace(e));
            return null;
        }

    }

    public static void main(String[] args) {

//        ReportKit360 kit=new ReportKit360();
//
//        TemplateBO templateBO=new TemplateBO();
//        templateBO.setTemplateName("个人信息查询使用授权文件_510502197106131116");
//        templateBO.setFreeMarkerUrl("黄卫东");
//        templateBO.setITEXTUrl("哈哈哈哈哈哈哈哈哈哈哈哈哈哈");
//        templateBO.setJFreeChartUrl("http://www.yiibai.com/jfreechart/jfreechart_referenced_apis.html");
//        templateBO.setImageUrl("http://mss.vip.sankuai.com/v1/mss_74e5b6ab17f44f799a524fa86b6faebf/360report/logo_1.png");
//
//        List<String> scores=new ArrayList<String>();
//        scores.add("90");
//        scores.add("95");
//        scores.add("98");
//        templateBO.setScores(scores);
//
////        List<Line> lineList=getTemperatureLineList();
////
////        DefaultLineChart lineChart=new DefaultLineChart();
////        lineChart.setHeight(500);
////        lineChart.setWidth(300);
////
////        String picUrl=lineChart.draw(lineList,0);
////
//        templateBO.setPicUrl("");
//
//        String path= kit.createPDF(templateBO,"hello.pdf");
//        System.out.println(path);

        ReportKit360 kit=new ReportKit360();

        AuthorizationTemplate authorizationTemplate = new AuthorizationTemplate();
        authorizationTemplate.setTitle("个人信息查询使用授权文件_510502197106131116");
        authorizationTemplate.setService(new HashMap<String, String>(){{
            put("身份认证（三元认证）", "姓名：胡友兵\n" +
                    "身份证号：510502197106131116\n" +
                    "银行卡号：6222022304004716530\n" +
                    "认证时间：2017/6/28 17:20:16");
        }});
        authorizationTemplate.setAuthorizationDate("授权时间：2017/6/28 17:20:16");
        authorizationTemplate.setAuthorizationContentTile("个人信息查询使用授权书");
        authorizationTemplate.setAuthorizationContent("本人不可撤销地同意并授权四川锦程消费金融有限责任公司（以下简称“公\n" +
                "司”）向“中国人民银行金融信用信息基础数据库”查询并获取本人个人信用报\n" +
                "告，向芝麻信用等合法征信机构以及其他任何可能的来源查询并获取本人个人\n" +
                "相关信息。查询事由包括审核本人贷款申请、审核本人作为担保人、进行贷后\n" +
                "管理及处理本人异议等。\n" +
                "本人不可撤销地同意并授权“公司”将包括本人的个人基本信息、信贷交易\n" +
                "信息等相关信息（包括不良信息），向中国人民银行金融信用信息基础数据库以\n" +
                "及其他合法的征信机构报送。本人理解并同意， 这些信息对本人的信用评级\n" +
                "（评分）、信用报告等结果可能产生的正面及负面影响。\n" +
                "本人亦不可撤销地同意并授权“公司”及其合作的征信机构及其他合法设\n" +
                "立机构基于贷前审查、信用评估、贷后管理、违约追究等风险控制业务需求以\n" +
                "及提供征信服务的目的，依法查询、采集、保存、整理、加工、使用本人个人\n" +
                "相关信息。本人知晓被采集的信息中包括收入、存款、有价证券、商业保险、\n" +
                "不动产的信息和纳税数额信息， 且提供上述信息可能会给本人带来财产或信用\n" +
                "损失，以及其他可能的不利后果，包括但不限于：采集这些信息对本人的信用\n" +
                "评级（评分）、信用报告等结果可能产生的不利影响，以及该等信息被信息使\n" +
                "用者依法提供给第三方后被他人不当利用的风险，但本人仍然同意授权前述机\n" +
                "构采集这些信息。\n" +
                "授权期限：自本人签署本授权书之日起，至本人与“公司”信贷关系终结\n" +
                "之日止。\n" +
                "本人不可撤销地同意“公司”在本人放弃贷款申请或贷款申请被“公司”拒绝\n" +
                "时， 继续保留此授权书及本人提交的身份证件复印件等所有贷款申请材料。\n" +
                "授权人声明已知悉并同意上述条款所载内容。授权人理解并认可上述条款\n" +
                "的涵义及其法律后果，并不持任何异议。\n" +
                "授权人（签名）：____________________\n" +
                "证件号码：____________________________\n" +
                "证件类型：□身份证 □临时身份证 □其他____________________\n" +
                "授权日期： 年 月 日");

        String path= kit.createPDF(authorizationTemplate,"authorization_template.pdf");
//        System.out.println(path);

    }






}
