package com.wenkang.beanexample;

import com.wenkang.beanexample.bean.Message;
import com.wenkang.beanexample.dao.MessageDAO;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Created by wenka on 2017/4/7.
 */
public class BeanMain
{
    public static void main(String[] args) {
        MessageDAO messageDAO = new MessageDAO();
        List<Message> messageList = messageDAO.queryMessageList();
//        for(Message m: messageList)
//        {
//            System.out.println("username:"+m.getUsername()+" outgo:"+m.getOutgo()+" price:"+m.getPrice());
//        }

        Map map = new HashMap();
        String filePath = "./src/resource/jasper/BeanReport.jasper";
        JRBeanCollectionDataSource beanDataSource =
                new JRBeanCollectionDataSource(messageList);
        JasperPrint jasperPrint = null;
        //模版数据填充
        try {
            jasperPrint = JasperFillManager.fillReport(filePath,map,beanDataSource);
        } catch (JRException e) {
            e.printStackTrace();
            System.out.println("fillReport错误");
        }

        //输出HTML
        String htmlFilePath="./src/resource/resout/beanreport.html";
        try {
            JasperExportManager.exportReportToHtmlFile(jasperPrint,htmlFilePath);
        } catch (JRException e) {
            System.out.println("html导出失败");
        }

        //输出pdf
        String pdfFilePath="./src/resource/resout/beanreport.pdf";
        try {
            JasperExportManager.exportReportToPdfFile(jasperPrint,pdfFilePath);
        } catch (JRException e) {
            System.out.println("pdf导出失败");
        }

        //输出Excel
        String xlsFilePath="./src/resource/resout/beanreport.xls";
        JRXlsxExporter exporter = new JRXlsxExporter();
        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        File xlsOutputFile = new File(xlsFilePath);
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(xlsOutputFile));
        try {
            exporter.exportReport();
        } catch (JRException e) {
            System.out.println("xls导出失败");
        }

        //输出word
        String docxFilePath="./src/resource/resout/beanreport.docx";
        JRDocxExporter jrDocxExporter = new JRDocxExporter();
        jrDocxExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        File docxOutputFile = new File(docxFilePath);
        jrDocxExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(docxOutputFile));
        try {
            jrDocxExporter.exportReport();
        } catch (JRException e) {
            System.out.println("docx导出失败");
        }
    }
}
