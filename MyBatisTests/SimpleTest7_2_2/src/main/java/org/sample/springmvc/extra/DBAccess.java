package org.sample.springmvc.extra;

import java.util.List;

import org.sample.mybatis.TableMapper;
import org.sample.mybatis.TestTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;

@Repository
// rollbackForでExceptionを指定すると、指定したExceptionが発生した場合にロールバックが行われる
// @Transactional(rollbackFor=Exception.class)
// @Transactionalが指定されている場合、transactionManagerを使用した明示的なトランザクション制御はできない。どちらかだけ使う
// @Transactional
public class DBAccess {
    @Autowired private TableMapper sqlMapper;
    @Autowired private PlatformTransactionManager transactionManager;
    
    // TransactionTemplate版
    // 一つのメソッド内で一つのトランザクションしか使わないのであれば、@Transactionをメソッドにつけるだけで良いが、
    // 複数のトランザクションに分けたい場合などは、TransactionManagerを使うか、
    // 以下のようにTransactionTemplateを使って明示的にトランザクション区間を区切る
    public List<TestTable> dbAccess() {
        // TransactionCallbackは一つのメソッドを持つインタフェースなので、以下のように関数型インタフェースとして扱うことができる
        return new TransactionTemplate(transactionManager).execute(status -> {
            System.out.println("From Autowired: "+sqlMapper);
            sqlMapper.insertTestTable(1, "name", "address");
            
            List<TestTable> list = sqlMapper.selectTestTables(1, "false", "a");
            status.setRollbackOnly();
            return list;
        });
    }
    
    // 戻り値が無かった場合の実装サンプル
    public void dbAccess2() {
        new TransactionTemplate(transactionManager).execute(
            new TransactionCallbackWithoutResult() {
                // TransactionCallbackWithoutResultはTransactionCallbackの実装クラスなので、関数型インフェースのようには扱えない
                // もしくは、TransactionCallback#doInTransactionでnullを返せばよいと思われる
                @Override
                protected void doInTransactionWithoutResult(TransactionStatus status) {
                    System.out.println("From Autowired: "+sqlMapper);
                    sqlMapper.insertTestTable(1, "name", "address");
                    
                    List<TestTable> list = sqlMapper.selectTestTables(1, "false", "a");
                    status.setRollbackOnly();
                }
            }
        );
    }

}
