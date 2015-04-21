
* SimpleTest23: Jettyの@WebSocketを使用したWebSocket ServerEndpointサンプル
* SimpleTest23_Client: SimpleTest23用クライアント
* SimpleTest23_1:JettyのWebSocketAdapterを使用したWebSocket ServerEndpointのサンプル
* SimpleTest23_2： javax.websocket.Endpointを拡張したWebSocketのサンプル
* SimpleTest24： WebSocketUpgradeHandlerWrapper利用版（スタンドアローン版）
* SimpleTest24_1: SimpleTest24のWAR版。org.eclipse.jetty.server.RequestがWebアプリケーションから見えないため、以下の設定をコンテキストXML（webappsディレクトリに配置するXMLファイル）に記述する
  <Call name="prependServerClass">
    <Arg>-org.eclipse.jetty.server.Request</Arg>
  </Call>


 
