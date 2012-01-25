package org.conan;

import java.util.HashMap;
import java.util.List;

import org.conan.bank.model.BankDTO;
import org.conan.bank.service.BankService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringInitialize {

    private static ApplicationContext ctx = null;

    private SpringInitialize() {
    }

    public static ApplicationContext getContext() {
        if (ctx == null) {
            ctx = new ClassPathXmlApplicationContext("spring.xml");
        }
        return ctx;
    }
    
    public static void main(String[] args){
        BankService bankService = (BankService)SpringInitialize.getContext().getBean("bankService");
        List<BankDTO> list = bankService.getBanks(new HashMap<String,Object>());
        System.out.println(list);
    }

}
