package org.sample.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface SqlMapper {
    // メソッド名と同じid属性値を持つsql-mapping.xmlのSQL設定が利用される
    public List<TestTable> selectTestTables(@Param("id") int id, @Param("LIMIT_ID") String limitId, @Param("name") String name);
    public int insertTestTable(@Param("name") String name, @Param("address") String address);

    public List<TestTable> selectTestTables2(Params params);

    public List<TestTable> selectTestTables3(int param1, String param2, String param3);
    public int insertTestTable2(TestTable2 testtable2);

}
