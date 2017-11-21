package net.snailgame.importMysql.util;

public class EnvInitializerBean {
    private String log_properties = null;

    public EnvInitializerBean() {
    }

    public void init() {
        // org.apache.log4j.PropertyConfigurator.configure(log_properties);
        org.apache.log4j.xml.DOMConfigurator.configure(log_properties);
    }

    public String getLog_properties() {
        return log_properties;
    }

    public void setLog_properties(String log_properties) {
        if (System.getProperty("file.separator").equals("\\"))
            this.log_properties = "src/main/resources/" + log_properties;
        else {
            if (log_properties.indexOf("./") == -1)
                this.log_properties = "./" + log_properties;
            else {
                this.log_properties = log_properties;
            }
        }

    }

}
