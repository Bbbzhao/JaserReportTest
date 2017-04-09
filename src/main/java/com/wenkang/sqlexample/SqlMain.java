package com.wenkang.sqlexample;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;

import java.io.File;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by wenka on 2017/4/9.
 */
public class SqlMain
{
    public static void main(String[] args) {
        String filepath = "./src/resource/jasper/SqlReport.jasper";
        Map map = new HashMap();
        //获取数据源connection
        Connection connection = MySQLConnection.getConnection();
        JasperPrint jasperPrint = null;
        try {
            //模版数据填充
            jasperPrint = JasperFillManager.fillReport(filepath, map, connection);
        } catch (JRException e) {
            System.out.println("fillReport错误");
        }finally {
            //关闭数据源
            MySQLConnection.closeConnection(connection);
        }

        //输出html
        String htmlFilePath = "./src/resource/resout/sqlreport.html";
        try {
            JasperExportManager.exportReportToHtmlFile(jasperPrint, htmlFilePath);
        } catch (JRException e) {
            System.out.println("html导出错误");
        }

        //输出pdf
        String pdfFilePath = "./src/resource/resout/sqlreport.pdf";
        try {
            JasperExportManager.exportReportToPdfFile(jasperPrint, pdfFilePath);
        } catch (JRException e) {
            System.out.println("pdf导出错误");
        }

        //输出Excel
        String xlsFilePath = "./src/resource/resout/sqlreport.xls";
        JRXlsxExporter exporter = new JRXlsxExporter();
        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        File xlsOutputFile = new File(xlsFilePath);
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(xlsOutputFile));
        try {
            exporter.exportReport();
        } catch (JRException e) {
            System.out.println("xls导出错误");
        }

        //输出word
        String docxFilePath = "./src/resource/resout/sqlreport.docx";
        JRDocxExporter jrDocxExporter = new JRDocxExporter();
        jrDocxExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        File docxOutputFile = new File(docxFilePath);
        jrDocxExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(docxOutputFile));
        try {
            jrDocxExporter.exportReport();
        } catch (JRException e) {
            System.out.println("docx导出错误");
        }
    }
}
