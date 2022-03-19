import com.mybatis.mapper.CacheMapper;
import com.mybatis.pojo.Emp;
import com.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class CacheMapperTest {
    /**
     * 使一级缓存失效的四种情况：
     * 1) 不同的SqlSession对应不同的一级缓存
     * 2) 同一个SqlSession但是查询条件不同
     * 3) 同一个SqlSession两次查询期间执行了任何一次增删改操作
     * 4) 同一个SqlSession两次查询期间手动清空了缓存
     */

    @Test
    public void testCache_ONE(){
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        CacheMapper mapper = sqlSession.getMapper(CacheMapper.class);
        Emp emp1 = mapper.getEmpByEid(1);
        System.out.println(emp1);

        //清空缓存，只对一级缓存有效
        sqlSession.clearCache();

        Emp emp2 = mapper.getEmpByEid(1);
        System.out.println(emp2);
    }

    /**
     * 二级缓存开启的条件：
     * a>在核心配置文件中，设置全局配置属性cacheEnabled="true"，默认为true，不需要设置
     * b>在映射文件中设置标签<cache />
     * c>二级缓存必须在SqlSession关闭或提交之后有效
     * d>查询的数据所转换的实体类类型必须实现序列化的接口
     * 使二级缓存失效的情况：
     * 两次查询之间执行了任意的增删改，会使一级和二级缓存同时失效
     */
    @Test
    public void testCache_TWO(){
        try {
            InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);


            SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
            CacheMapper mapper1 = sqlSession1.getMapper(CacheMapper.class);
            System.out.println(mapper1.getEmpByEid(1));
            sqlSession1.close();

            SqlSession sqlSession2 = sqlSessionFactory.openSession(true);
            CacheMapper mapper2 = sqlSession2.getMapper(CacheMapper.class);
            System.out.println(mapper2.getEmpByEid(1));
            sqlSession2.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
