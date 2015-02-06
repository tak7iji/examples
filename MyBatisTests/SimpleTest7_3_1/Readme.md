### $CATALINA_HOME/libに配置  （Mavenのリポジトリから持ってくる）
- commons-loggin-api-1.1.jar  
- carol-interceptor-1.0.1.jar 
- carol-3.0.8.jar 
- jotm-core-2.2.3.jar 
- ow2-jta-1.1-spec-1.0.8.jar  
- jotm-datasource-2.2.3.jar   
- ow2-connector-1.6-spec-1.0.13.jar   
- xapool-1.6-beta.jar 
- jta-1.1.jar 
    
### JOTMのリカバリ設定 
- Tomcat起動時に、以下のオプションを付加 （setenv.shやsetenv.batでCATALINA_OPTSに設定する） 
 -Djotm.base=${CATALINA_HOME}
- ${CATALINA_HOME}/conf/jotm.propertiesを作成して、以下のプロパティを設定  
 jotm.recovery.Enabled=true
    
### JOTM関連ログ設定
下記の設定ではDEBUGレベルのログが出力されるので、開発時以外はSEVEREなどにしておく

logging.propertiesに以下を設定    
- 5transaction.org.apache.juli.AsyncFileHandler.level = FINEST    
- 5transaction.org.apache.juli.AsyncFileHandler.directory = ${catalina.base}/logs 
- 5transaction.org.apache.juli.AsyncFileHandler.prefix = transaction. 
- org.objectweb.jotm.level = FINEST   
- org.objectweb.jotm.handlers = 5transaction.org.apache.juli.AsyncFileHandler 

細かく区別する場合は、以下の3つのパッケージで分ける  
- org.objectweb.jotm  
- org.objectweb.jotm.jta  
- org.objectweb.jotm.recovery 
