* SimpleTest20: シンプルなサンプル
* SimpleTest20_1: SimpleTest7_3のSpringBoot版（Tomcat+Atomikos利用）
* SimpleTest20_1_1: 2PCテスト（DBアクセス後にメッセージ送信。メッセージ受信は非同期。/list/0 -&gt; コミット。/list/1 -&gt; ロールバック）
* SimpleTest20_2: SimpleTest20_1のWebService版
* SimpleTest20_3: JMSの送受信サンプル（Tomcat上でHornetQを利用）
* SimpleTest20_3_1: JMS送受信サンプル（Atomikos利用）
* SimpleTest20_3_2: JMS送受信サンプル（スタンドアローン版）
* SimpleTest20_3_2_1: JMS送受信サンプル（複数のCommandLineRunnerを実行）
* SimpleTest20_3_3: JMS送受信サンプル（スタンドアローン版。JBossEAP6.3のHornetQを利用）
    ⇒ JBossEAP6.3に以下の設定を行う
            &lt;hornetq-server&gt;
                &lt;!-- 途中省略 --&gt;
                &lt;jms-destinations&gt;
                    &lt;!-- 途中省略 --&gt;
                    &lt;jms-queue name="testQueue"&gt;
                        &lt;entry name="queue/test"/&gt;
                        &lt;entry name="java:jboss/exported/jms/queue/test"/&gt;
                    &lt;/jms-queue&gt;
                &lt;/jms-destinations&gt;
            &lt;/hornetq-server&gt;

    application-users.propertiesにjbossユーザを登録する
* SimpleTest20_4*: Spring-Securityのサンプル
* SimpleTest21: WebSocketのサンプル。テストコードがクライアントとして動作（Tomcat8、Jetty9、Undertowで動作。pom.xmlでAPサーバ切り替え）
* SimpleTest21_1： javax.websocket.Endpointを拡張したWebSocketのサンプル（Tomcat8、Jetty9、Undertowで動作。pom.xmlでAPサーバ切り替え）
* SimpleTest21_Client: SimpleTest21/21_1用のクライアント
* SimpleTest22: WebSocketのHandShake時にセッション情報を設定する（Tomcat8、Jetty9、Undertowで動作。pom.xmlでAPサーバ切り替え）
