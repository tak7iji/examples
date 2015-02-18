* SimpleTest7：SpringMVC+MyBatis
* SimpleTest7_1：SpringMVC+MyBatis。TransactionTemplate利用版。TransactionManagerはSpringのDataSourceTransactionManager
* SimpleTest7_2：SpringMVC+MyBatis+MyBatis-Spring利用版
* SimpleTest7_2_1：SpringMVC+MyBatis+MyBatis-Spring利用版。SqlSessionTemplate利用。SqlSessionをBeanとして返す
* SimpleTest7_2_2：SpringMVC+MyBatis+MyBatis-Spring利用版。SqlSessionTemplate利用。MapperをBeanとして返す
* SimpleTest7_2_3：SimpleTest7_2_2のXMLベース版

* SimpleTest7_3：JOTM利用版。TransactionTemplate利用
* SimpleTest7_3_1：JOTM利用版。UserTransactionを直接利用
* SimpleTest7_3_2：JBoss版。XMLベース
* SimpleTest7_3_2_1：SimpleTest7_3_2のJavaConfig版

* SimpleTest7_4: WebService+MyBatis-Spring。複数テーブルのJOIN
* SimpleTest7_4_1: SimpleTest7_4のResultMapを自動マッピング化

* SimpleTest7_5： CamelCaseのテスト（カラム名＝プロパティ名）
* SimpleTest7_5_1： CamelCaseのテスト（プロパティ名がカラム名のCamelCase）
* SimpleTest7_5_2： JPAのアノテーションが入りっぱなしでも悪影響を及ぼさないかテスト 
* SimpleTest7_5_3： Mapper XMLファイルに記載したSQL文がすべて大文字でもCamelCaseに影響しないかテスト
