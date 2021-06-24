package com.wangchuan.Service;

import com.wangchuan.Bean.Department;
import com.wangchuan.Dao.DepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wangchuan
 * @creat 2021-06-11-22:05
 */
@Service
public class DepartmentService {

    @Autowired
    DepartmentMapper departmentMapper;
    //查出所有的部门信息
    public List<Department> getDepts(){
        List<Department> departments = departmentMapper.selectByExample(null);
        return departments;
    }
}
