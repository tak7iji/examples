package org.sample.mybatis;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface SqlMapper {
    // 仮パラメータ名とMapper XML中のパラメータ名が同じである必要は無い。
    // @Paramでパラメータ名を指定しない場合は、Mapper XMLファイル中のパラメータ名は、引数に指定された順にparam1, param2, param3, ...となる
    public List<TestTable> selectTestTables1(int p1, String p2, String p3);
    public List<TestTable> selectTestTables2(int param1, @Param("LIMIT_ID") String limitId, String param2);
    public List<TestTable> selectTestTables3(List<Object> params, List<Object> conditions);
    public List<TestTable> selectTestTables4(List<Object> params);
    public List<TestTable> selectTestTables5(Map<String, Object> params);
    public List<TestTable> selectTestTables6(Map<String, Object> params, Map<String, Object> conditions);
    public List<TestTable> selectTestTables7(Object[] params);

    public List<CustomerTable> selectTestTables8(int c_id);
    
    public int insertTestTable(int p1, String p2, String p3);

}
