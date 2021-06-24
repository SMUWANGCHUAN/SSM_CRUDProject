package com.wangchuan.Controller;

import com.wangchuan.Bean.Department;
import com.wangchuan.Bean.Msg;
import com.wangchuan.Service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 处理和部门有关的请求
 * @author wangchuan
 * @creat 2021-06-11-22:04
 */
@Controller
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;
    @RequestMapping("/depts")
    @ResponseBody
    public Msg getDepts(){
        List<Department> depts = departmentService.getDepts();
        return Msg.success().add("depts", depts);
    }
}
