import com.mybatis.mapper.DeptMapper;
import com.mybatis.mapper.EmpMapper;
import com.mybatis.pojo.Dept;
import com.mybatis.pojo.Emp;
import com.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class ResultMapTest {

    /**
     * 解决字段名和属性名不一致的情况
     *      1.为字段名起别名，保持和属性名一致
     *      2.设置全局配置，将_自动映射为驼峰
     *          <setting name="mapUnderscoreToCamelCase" value="true"/>
     *      3.通过resultMap设置自定义映射关系
     *         <resultMap id="empResultMap" type="Emp">
     *           <id property="eid" column="eid"></id>
     *           <result property="empName" column="emp_name"></result>
     *           <result property="age" column="age"></result>
     *          <result property="sex" column="sex"></result>
     *          <result property="email" column="email"></result>
     *        </resultMap>
     *
     * 处理多对一的映射关系：
     *      1.级联属性赋值
     *      2.association
     *      3.分布查询
     *
     * 处理一对多的映射关系
     *      1.collection
     *      2.分布查询
     *
     */

    @Test
    public void testGetAllEmp(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        List<Emp> list = mapper.getAllEmp();
        list.forEach(emp -> System.out.println(emp));
    }

    @Test
    public void testGetEmpAndDept(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);
        Emp emp = mapper.getEmpAndDeptByStep_ONE(1);
        System.out.println(emp.getEmail());
        System.out.println("****");
        System.out.println(emp.getDept());
    }


    @Test
    public void testGetDeptAndEmp(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = mapper.getDeptAndEmp(1);
        System.out.println(dept);
    }

    @Test
    public void testGetDeptAndEmpGByStep(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DeptMapper mapper = sqlSession.getMapper(DeptMapper.class);
        Dept dept = mapper.getDeptAndEmpByStep_ONE(1);
        System.out.println(dept.getDeptName());
        System.out.println("****");
        System.out.println(dept.getEmps());
    }

}
