package org.conan.tools.core.build;

import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

/**
 * 
 * @author Conan
 */
public class VelocityFactory {

    public final static String UTF8 = "UTF-8";
    // model
    public final static String MODEL_VM = "org/conan/tools/core/vm/model/model.vm";
    public final static String FORM_MODEL_VM = "org/conan/tools/core/vm/model/formModel.vm";
    // dao
    public final static String DAO_VM = "org/conan/tools/core/vm/dao/dao.vm";
    public final static String IBATIS_VM = "org/conan/tools/core/vm/dao/ibatisImpl.vm";
    public final static String IBATIS_SQL_VM = "org/conan/tools/core/vm/dao/ibatisSQL.vm";
    // service
    public final static String SERVICE_VM = "org/conan/tools/core/vm/service/service.vm";
    public final static String SERVICE_IMPL_VM = "org/conan/tools/core/vm/service/serviceImpl.vm";
    // sql
    public final static String SQL_CREATE_VM = "org/conan/tools/core/vm/sql/sqlCreate.vm";
    public final static String SQL_DROP_VM = "org/conan/tools/core/vm/sql/sqlDrop.vm";
    // test
    public final static String IBATIS_TEST_VM = "org/conan/tools/core/vm/test/ibatisImplTest.vm";
    public final static String SERIVCE_TEST_VM = "org/conan/tools/core/vm/test/serviceTest.vm";
    private String writer;

    public static void main(String[] args) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("model", "User");
        VelocityFactory vf = new VelocityFactory(MODEL_VM, map);
        vf.getWriter();
    }

    public VelocityFactory(String vm, Map<String, Object> map) {
        initVelocity();
        VelocityContext context = setContextAttribute(map);
        mergeTemplate(vm, context);
    }

    public VelocityContext setContextAttribute(Map<String, ?> map) {
        VelocityContext context = new VelocityContext(map);
        return context;
    }

    public void mergeTemplate(String vm, VelocityContext context) {
        StringWriter tmp = new StringWriter();
        try {
            Velocity.mergeTemplate(vm, UTF8, context, tmp);
            this.writer = tmp.toString();
            tmp.flush();
        } catch (Exception ex) {
            Logger.getLogger(VelocityFactory.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void initVelocity() {
        Properties props = propertisInstance();
        try {
            Velocity.init(props);
        } catch (Exception ex) {
            Logger.getLogger(VelocityFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private Properties propertisInstance() {
        Properties props = new Properties();
        props.setProperty(Velocity.INPUT_ENCODING, UTF8);
        props.setProperty(Velocity.OUTPUT_ENCODING, UTF8);
        props.setProperty("file.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        return props;
    }

    public String getWriter() {
        Logger.getLogger(VelocityFactory.class.getName()).log(Level.INFO, writer);
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }
}
