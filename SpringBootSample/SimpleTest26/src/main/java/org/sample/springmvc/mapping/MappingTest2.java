package org.sample.springmvc.mapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MappingTest2 {
    private static Logger logger = LoggerFactory.getLogger(MappingTest2.class);

    // @ModelAttributeを指定したメソッドを作っておくと、@RequestMappingをつけたメソッドが呼ばれるたびに、このメソッドが呼ばれる
    // Viewでは"message"の名前で使っているので、アノテーションに名前を指定しておく
    // 名前を指定しなかった場合は、Beanクラスの先頭を小文字にしたものが設定される
	@ModelAttribute("message")
	public TestFormBean setupForm() {
        logger.info("Setup TestFormBean");
		return new TestFormBean();
	}
	
    @RequestMapping(value = "/test2", method = RequestMethod.GET)
    public String execute(Model model) {
//        model.addAttribute("message", new TestFormBean());
        return "dispatchaction";
    }

    // Modelは無くても大丈夫。ModelにTestFormBean（名前は"message"）を入れなくても良い（加工しないなら）
    @RequestMapping(value = "/test2-dispatch", params = "execute=dispatch1", method = RequestMethod.POST)
    public String dispatch1(@ModelAttribute("message")TestFormBean message, Model model) {
        for(String key:model.asMap().keySet()) {
            logger.info("Key: {}", key);
        }
    	//model.addAttribute("message", message);
        return "dispatch1";
    }

    // 引数にModelがなくても、フォームBeanさえあれば良いらしい
    // Modelにあらためて設定しなくても、Modelには"message"はセットされているので、表示するViewにも渡される
    @RequestMapping(value = "/test2-dispatch", params = "execute=dispatch2", method = RequestMethod.POST)
    public String dispatch2(@ModelAttribute("message")TestFormBean message) {
//    	model.addAttribute("message", message);
        return "dispatch2";
    }

}
