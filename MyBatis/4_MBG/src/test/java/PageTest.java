import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mybatis.mapper.EmpMapper;
import com.mybatis.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class PageTest {

    /**
     *  根据查询信息实现分页
     *  limit  index,Size
     *      index：当前页的起始索引
     *      Size：每页显示的条数
     *      pageNum：当前页的页码
     *      	select 查询列表
     *      	from 表
     *     index  =  limit (pageNum-1)*size,size;
     *
     *   使用MyBatis分页插件实现分页功能
     *   1.需要在查询功能之前开启分页
     *      PageHelper.startPage(int pageNum, int pageSize);
     *   2.在查询功能之后获取分页相关信息
     *      PageInfo<Emp> page = new PageInfo<>(list, 5)
     *      list：表示分页数据
     *      5：表示当前导航分页的数量
     */

    @Test
    public void PageHelperTest() throws IOException {
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        EmpMapper mapper = sqlSession.getMapper(EmpMapper.class);

        //开启分页功能
        //pageNUm当前页为1，每页显示 2条数据
        //使用Page对象，可以获取部分分页的数据：当前页、下一页、上一页。。。
//        Page<Object> page =  PageHelper.startPage(1,2);
        PageHelper.startPage(1,2);

        //查询所有数据，null没有，就是查询所有
        List<Emp> list = mapper.selectByExample(null);

        //使用PageInfo对象：可以获取导航分页的所有数据       navigatePages：导航分页的页码数
        PageInfo<Emp> page = new PageInfo<>(list, 5);

//        list.forEach(emp -> System.out.println(emp));
        System.out.println(page);
    }
}
