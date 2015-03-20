* SimpleTest20: シンプルなサンプル
* SimpleTest20_1: SimpleTest7_3のSpringBoot版（Tomcat+Atomikos利用）
* SimpleTest20_1_1: 2PCテスト（DBアクセス後にメッセージ送信。メッセージ受信は非同期。/list/0 -> コミット。/list/1 -> ロールバック）
* SimpleTest20_2: SimpleTest20_1のWebService版
* SimpleTest20_3: JMSの送受信サンプル（Tomcat上でHornetQを利用）
* SimpleTest20_3_1: JMS送受信サンプル（Atomikos利用）
* SimpleTest20_3_2: JMS送受信サンプル（スタンドアローン版）
* SimpleTest20_3_2_1: JMS送受信サンプル（複数のCommandLineRunnerを実行）
* SimpleTest20_3_3: JMS送受信サンプル（スタンドアローン版。外部のHornetQ（Standalone）を利用）
⇒ hornetq-jms.xmlに以下の項目を追加して、HornetQをスタンドアローンで起動
   <queue name="queue/messageQueue">
      <entry name="/queue/messageQueue"/>
   </queue>

* SimpleTest20_4*: Spring-Securityのサンプル