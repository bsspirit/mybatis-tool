package org.conan.tools.core.parser;

import java.util.ArrayList;
import java.util.List;

public class SpringBean {

    private List<String> daos = new ArrayList<String>();

    public SpringBean(List<DaoBean> list) {
        setDAOBean(list);
    }

    public void setDAOBean(List<DaoBean> list) {
        for (DaoBean bean : list) {
            StringBuilder sb = new StringBuilder();
            sb.append("\t<bean id=\"" + bean.getId() + "\" class=\"org.mybatis.spring.mapper.MapperFactoryBean\">\n");
            sb.append("\t\t<property name=\"sqlSessionFactory\" ref=\"sqlSessionFactory\"/>\n");
            sb.append("\t\t<property name=\"mapperInterface\" value=\"" + bean.getValue() + "\"/>\n");
            sb.append("\t</bean>\n");
            daos.add(sb.toString());
        }
    }

    public List<String> getDAOBean() {
        return daos;
    }

}
