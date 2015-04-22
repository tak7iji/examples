Jetty用WebSocketサンプル

* SimpleTest23: Jettyの@WebSocketを使用したWebSocket ServerEndpointサンプル
* SimpleTest23_Client: SimpleTest23用クライアント
* SimpleTest23_1:JettyのWebSocketAdapterを使用したWebSocket ServerEndpointのサンプル
* SimpleTest23_2： javax.websocket.Endpointを拡張したWebSocketのサンプル
* SimpleTest24： WebSocketUpgradeHandlerWrapper利用版（スタンドアローン版）
* SimpleTest24_1: SimpleTest24のWAR版。org.eclipse.jetty.server.RequestがWebアプリケーションから見えないため、以下の設定をコンテキストXML（webappsディレクトリに配置するXMLファイル）に記述する
<pre>
    &lt;Call name="prependServerClass"&gt;
      &lt;Arg&gt;-org.eclipse.jetty.server.Request&lt;/Arg&gt;
    &lt;/Call&gt;
</pre>
* SimpleTest24_2: SimpleTest24の改良版。WebSocketCreator実装クラス内で無理矢理Request._handledをtrueにしないバージョン