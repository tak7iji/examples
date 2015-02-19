* SimpleTest15：WebService+JPA。SpringBeanは利用しない
* SimpleTest15_1：WebService+JPA。SpringBeanを利用（EntityManagerをInject）
* SimpleTest15_1_1：WebService+JPA。SpringBeanを利用（EntityManagereFactoryをInject）
* SimpleTest15_2：WebService+JPA。Spring Data JPA利用版

* SimpleTest15_3: SimpleTest7_4のJPA版
* SimpleTest15_3_1: SimpleTest15_3のSpring DATA JPA版（引数の値が1の場合はデフォルトのメソッド、引数の値が2の場合は命名規則に基づいたメソッド、それ以外の場合は@Queryが指定されたメソッドを実行）
* SimpleTest15_3_1_1: SimpleTest15_3_1のXML設定版

SimpleTest15_3/15_3_1/7_4で利用するテーブルの構造					
order_line			items		
id			        id		
qty			        name		
                    o_id（order_lineのidカラムと関連付け）		
					
					
サンプルデータ					
OrderLine			Items		
1	100		        1	aaa	1
2	200		        2	bbb	1
3	300		        3	ccc	1
4	400		        4	ddd	1
5	500		        5	eee	2
                    6	fff	2
                    7	ggg	3
                    8	hhh	3
                    9	iii	4
                    10	jjj	4
                    11	kkk	5
