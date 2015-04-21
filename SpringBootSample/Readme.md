* SimpleTest20: シンプルなサンプル
* SimpleTest20_1: SimpleTest7_3のSpringBoot版（Tomcat+Atomikos利用）
* SimpleTest20_1_1: 2PCテスト（DBアクセス後にメッセージ送信。メッセージ受信は非同期。/list/0 -> コミット。/list/1 -> ロールバック）
* SimpleTest20_2: SimpleTest20_1のWebService版
* SimpleTest20_3: JMSの送受信サンプル（Tomcat上でHornetQを利用）
* SimpleTest20_3_1: JMS送受信サンプル（Atomikos利用）
* SimpleTest20_3_2: JMS送受信サンプル（スタンドアローン版）
* SimpleTest20_3_2_1: JMS送受信サンプル（複数のCommandLineRunnerを実行）
* SimpleTest20_3_3: JMS送受信サンプル（スタンドアローン版。JBossEAP6.3のHornetQを利用）
⇒ JBossEAP6.3に以下の設定を行う
            <hornetq-server>
                <!-- 途中省略 -->
                <jms-destinations>
                    <!-- 途中省略 -->
                    <jms-queue name="testQueue">
                        <entry name="queue/test"/>
                        <entry name="java:jboss/exported/jms/queue/test"/>
                    </jms-queue>
                </jms-destinations>
            </hornetq-server>

    application-users.propertiesにjbossユーザを登録する
* SimpleTest20_4*: Spring-Securityのサンプル
* SimpleTest21: WebSocketのサンプル。テストコードがクライアントとして動作
* SimpleTest21_1： javax.websocket.Endpointを拡張したWebSocketのサンプル
* SimpleTest21_Client: SimpleTest21用のクライアント
* SimpleTest22: WebSocketのHandShake時にセッション情報を設定する