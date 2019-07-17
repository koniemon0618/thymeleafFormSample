package com.example.demo;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TlSampleController {
    private static final Logger log = LoggerFactory
            .getLogger(TlSampleController.class);
 
    @ModelAttribute("colorOptions")
    public List<String> ckBoxList() {
        List<String> list = new ArrayList<String>();
        list.add("red");
        list.add("green");
        list.add("blue");
        return list;
    }
 
    @RequestMapping("/tlSample")
    public String tlSample(@ModelAttribute("form") TlSampleForm form) {
        form.setMessage1("<h1>Thymeleaf サンプル</h1>");
        form.setMessage2("Thymeleafを使用したサンプルです。");
        form.setToday(Calendar.getInstance());
 
        log.info("#########");
        log.info("入力された氏名は "+form.getName());
        log.info("選択されたチェックボックスは ");
        for(String color: form.getCkColors()) {
            log.info("\t"+color);
        }
        log.info("選択されたラジオボタンは "+form.getRdColor());
        log.info("選択されたリストは "+form.getLsColor());
        log.info("入力されたテーブルデータは");
        for (TlSampleRow row : form.getRowDatas()) {
            log.info("\t"+row.getCol1()+", "+row.getCol2()+", "+row.getCol3());
        }
        log.info("#########");
 
        return "tlSample";
    }

}
