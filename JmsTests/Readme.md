### トランザクション制御なし					
* SimpleTest14：Servlet+JMS			メッセージ送信して、すぐに受信。JavaEEのお作法で送信
* SimpleTest14_1：WebService+Spring+JMS。ListenerはMDP。メッセージ送信はJavaEEのお作法通り
* SimpleTest!4_2：WebService+Spring+JMS。ListenerはMDP。メッセージ送信はJmsTemplate
* SimpleTest14_1_1。WebService+Spring+JMS。ConnectionFactoryとしてjava:/JmsXAを指定。下記URLを参照
        http://d.hatena.ne.jp/ryoasai/20101212/1292148814					
* SimpleTest14_2_1：SimpleTest14_2のListenerをPOJOに変更			

### トランザクション制御あり					
* SimpleTest14_3：Servlet+JMS+JTA。メッセージ送信して、すぐに受信。トランザクション制御はUserTransaction
* SimpleTest14_3_1：WebService+Spring+JMS。ListenerはMDP。宣言的トランザクションを利用。メッセージ送信はJavaEEのお作法通り＋宣言的トランザクションを利用
* SimpleTest14_3_1_1：SimpleTest14_3_1のJavaConfig版
* SimpleTest14_3_2：WebService+Spring+JMS。ListenerはMDP。宣言的トランザクションを利用。メッセージ送信はJavaEEのお作法通り＋TransactionTemplate利用。receiveTimeoutが-1（無限）だと、JBossがシャットダウンができなくなる。0以上であれば大丈夫そう
