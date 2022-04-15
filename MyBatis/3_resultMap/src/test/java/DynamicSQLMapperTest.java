import com.mybais.mapper.DynamicSQLMapper;
import com.mybais.pojo.Emp;
import com.mybais.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class DynamicSQLMapperTest {

    /**
     * 动态SQL
     *  1.if：根据标签中test属性所对应的表达式决定标签中的内容是否需要拼接到 SQL中
     *  2.where：当where标签中有内容时，会自动生成where关键字，并且将内容前多余的and 或 or 去掉
     *           当where标签中无内容，此时where标签没有任何效果
     *   注意：where标签不能将其中内容后面多余的and 或 ar 去掉
     *  3.trim：
     *      若标签中有内容：
     *           prefix/suffix：将trim标签中的内容前面或后面添加指定内容
     *           suffixOverrides/prefixOverrides：将trim标签中内容前面或后面去掉指定内容
     *      若标签中没有内容时，trim标签也没有任何效果
     *   4.choosee、when、otherwise、相当于if...else if...else
     *      when至少只要有一个，otherwise最多只能有一个
     *   5.foreach
     *      collection：设置需要循环的数组或集合
     *      item：表示数组或集合中的每一个数据
     *      separator：循环体之间的分隔符
     *      open：foreach标签所循环的所有内容的开始符
     *      close：foreach标签所循环的所有内容的结束符
     *   6.sql标签
     *      设置SQL片段：<sql id="empColums">eid, emp_name, age, sex, email</sql>
     *      引用SQL片段：<include refid="empColums">
     *
     */

    @Test
    public void testGetEmpByCondition(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        //当其中一个条件不匹配时，输出[]无内容  当其中条件为空或者null时，就会匹配除null和空 其他匹配的内容
        List<Emp> empList = mapper.getEmpByCondition(new Emp(null, "小优", null, "女孩子", "123@"));
        System.out.println(empList);
    }

    @Test
    public void testGetEmpByChoose(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        //其中有一个条件匹配，后面的内容就不会匹配，直接输出
        List<Emp> empList1 = mapper.getEmpByChoose(new Emp(null, "", null, "女", ""));
        List<Emp> empList2 = mapper.getEmpByChoose(new Emp(null, "小优", null, "女孩子", "123@"));
        System.out.println(empList2);
    }

    @Test
    public void testDeleteMoreArr(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        int result = mapper.deleteMoreByArr(new Integer[]{6, 7});
        System.out.println(result);
    }

    @Test
    public void testInsertMoreByList(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        DynamicSQLMapper mapper = sqlSession.getMapper(DynamicSQLMapper.class);
        Emp e1 = new Emp(null, "卡萝", 15, "女", "23@");
        Emp e2 = new Emp(null, "奈乐", 17, "女", "23@");
        List<Emp> emps = Arrays.asList(e1, e2);
        System.out.println(mapper.insertMoreByList(emps));
    }

}
