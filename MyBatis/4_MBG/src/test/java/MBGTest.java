import com.mybatis.mapper.EmpMapper;
import com.mybatis.pojo.Emp;
import com.mybatis.pojo.EmpExample;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MBGTest {

    @Test
    public void testMBG_sel() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

        //查询所有数据，null没有，就是查询所有
//        List<Emp> list = mapper.selectByExample(null);
//        list.forEach(emp -> System.out.println(emp));

        //根据条件查询
        EmpExample empExample = new EmpExample();
        //创建一个条件，姓名为 小优，年龄 >= 20，  中间用or或分割，   或部门不为空的
        empExample.createCriteria().andEmpNameEqualTo("小优").andAgeGreaterThanOrEqualTo(20);
        empExample.or().andDidIsNotNull();
        List<Emp> list = mapper.selectByExample(empExample);
        list.forEach(emp -> System.out.println(emp));
    }

    @Test
    public void testMBG_upd() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

        //直接修改，若属性为null，则把字段改成null
//        mapper.updateByPrimaryKey(new Emp(3,"千姬", 20, null, "23@", 2));

        //选择性修改，若属性为null，就不会修改字段
        mapper.updateByPrimaryKeySelective(new Emp(3,"千姬", 20, null, "23@", 2));
    }
}
