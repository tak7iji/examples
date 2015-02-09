package org.sample.mybatis;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MultiRecord {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        
        // 引数なしのopenSession()はauto-commitがfalse
        SqlSession session = sqlSessionFactory.openSession();
        System.out.println(session.getConfiguration().getDatabaseId());
        
        SqlMapper mapper = session.getMapper(SqlMapper.class);
        
        TestTable2 tt2 = new TestTable2();
        tt2.setName("a");
        tt2.setAddress("b");
        mapper.insertTestTable2(tt2);
        mapper.insertTestTable("a", "b");
        
        List<TestTable> list = mapper.selectTestTables(1, "true", "a");

        Params params = new Params();
        params.setId(1);
        params.setLimitId("true");
        params.setName("a");
        List<TestTable> list2 = mapper.selectTestTables2(params);
        
        List<TestTable> list3 = mapper.selectTestTables3(1, "true", "a");
        
        // 陽にcommitが必要
        session.commit();
        
        list.forEach(t -> System.out.println(t.getId()+", "+t.getName()+", "+t.getAddress()));
        System.out.println("-----");
        list2.forEach(t -> System.out.println(t.getId()+", "+t.getName()+", "+t.getAddress()));
        System.out.println("-----");
        list3.forEach(t -> System.out.println(t.getId()+", "+t.getName()+", "+t.getAddress()));
    }

}
