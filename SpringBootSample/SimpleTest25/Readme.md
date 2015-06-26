- 自前のSpring-Bootアプリケーションを作る
    ⇒そもそも、外部JARにこのようなものを追加して正しく動作するのか？

- META-INF/spring-configuration-metadata.jsonにプロパティを定義する
- プロパティを読み込むクラスを作成する（ex: ServerProperties）
- 自動設定クラスを作成する（ex: ServerPropertiesAutoConfiguration）
    ⇒ここにどんな事を書くのか？
    ⇒@Beanでプロパティを読み込むクラスを返すコードを書く
- 自動設定クラスをspring.factoriesに登録
    ⇒org.springframework.boot.autoconfigure.EnableAutoConfigurationに登録
    ⇒もしくは、@ComponentScanで読み込んであげればよい
 