
* SimpleTest12_3：SimpleTest12のJava Config利用版
* SimpleTest12_3_1：SimpleTest12_2のJava Config版
* SimpleTest12_3_2：FactoryBean実装クラスでMessageBeanをインスタンス化
	
* SimpleTest11_2_1：SimpleTest11_2のJavaConfig版
	
* SimpleTest12_2_3：SimpleTest12_2の@Autowired版

* SimpleTest17: CommonsPoolTargetSourceを利用したObjectPool版
* SimpleTest17_1: PrototypeTargetSource利用版
* SimpleTest17_2: ThreadLocalTargetSource利用版

* SimpleTest18: PrototypeのBeanを読み込み（ApplicationContext#getBean利用）
  →PrototypeのBeanのインスタンスは毎回違う
* SimpleTest18_1: BeanでPrototypeのBeanを読み込み（@Autowired利用）
  →PrototypeのBeanのインスタンスは毎回同じ
* SimpleTest18_2: PrototypeのBeanを読み込み（ContextLoader.getCurrentWebApplicationContext().getBean利用）
  →PrototypeのBeanのインスタンスは毎回違う
* SimpleTest18_3: PrototypeのBeanを読み込み（ほぼSimpleTest18と同じ）
  →PrototypeのBeanのインスタンスは毎回違う
