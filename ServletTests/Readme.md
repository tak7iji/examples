* SimpleTest10： 通常のServlet内でSpringBeanを取得する
* SimpleTest10_1： Servlet#initでSpringBeanを有効化
* SimpleTest10_2: ApplicationContextAwareを実装している（けど、ApplicationContextは設定されない） 
* SimpleTest10_3： WebApplicationInitializer内でServletをインスタンス化＆ServletにInject
* SimpleTest10_4: AspectJを用いたコンパイル時Weaving
* SimpleTest10_4_1: AspectJを用いたコンパイル時Weaving（DBAccessをリクエストスコープのBeanにする）
* SimpleTest10_5: AspectJを用いたLoad-Time Weaving（Servlet#doGet()内でインスタンス化したクラスに@Configurableを付加）
→Servlet本体に@Configurableを付けてもうまくWeavingされない
		
* SimpleTest9： WebApplicationContext経由でSpring Beanを取得（SpringMVCは使っている）
