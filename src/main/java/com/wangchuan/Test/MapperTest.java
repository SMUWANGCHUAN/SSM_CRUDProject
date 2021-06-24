package com.wangchuan.Test;

import com.wangchuan.Bean.Department;
import com.wangchuan.Bean.Employee;
import com.wangchuan.Dao.DepartmentMapper;
import com.wangchuan.Dao.EmployeeMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;

/**
 * @author wangchuan
 * @creat 2021-06-09-20:35
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml","file:src/main/webapp/WEB-INF/applicationContext-mvc.xml"})
public class MapperTest {

    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    EmployeeMapper employeeMapper;

    @Autowired
    SqlSession sqlSession;
    /**
     * 测试department
     */
//    @Test
//    public void testCRUD(){
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        DepartmentMapper departmentMapper = context.getBean(DepartmentMapper.class);
//
//        System.out.println(departmentMapper);//插入部门
//        departmentMapper.insertSelective(new Department(null, "开发部"));
//        departmentMapper.insertSelective(new Department(null, "技术部"));
//        departmentMapper.insertSelective(new Department(null, "市场部"));
//    }

    @Test
    public void testCRUD(){
        departmentMapper.deleteByPrimaryKey(6);
        departmentMapper.deleteByPrimaryKey(7);
        departmentMapper.insertSelective(new Department(1, "技术部"));
        departmentMapper.insertSelective(new Department(2, "市场部"));
//   批量插入员工数据
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        for (int i = 0; i < 1000; i++){
            String uid = UUID.randomUUID().toString().substring(0, 5) + i;
            employeeMapper.insertSelective(new Employee(null, uid + "号", "男", uid + "@qq.com",1));
        }
    }

    @Test
    public void testSelect(){
        Employee employee = employeeMapper.selectByPrimaryKeyWithDept(2);
        System.out.println(employee);
    }
}
