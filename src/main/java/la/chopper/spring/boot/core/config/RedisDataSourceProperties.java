package la.chopper.spring.boot.core.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * redis参数配置类
 *
 * @author TonyTonyChopper
 * @version 1.0
 */
@ConfigurationProperties(prefix = "la.chopper.redis")
public class RedisDataSourceProperties implements InitializingBean {

    private int maxIdle;

    private int maxTotal;

    private long maxWaitMillis;

    private String hostName;

    private int port;

    private String password;

    @Override
    public void afterPropertiesSet() throws Exception {
        // do nothing
    }

    public int getMaxIdle() {
        return maxIdle;
    }

    public void setMaxIdle(int maxIdle) {
        this.maxIdle = maxIdle;
    }

    public int getMaxTotal() {
        return maxTotal;
    }

    public void setMaxTotal(int maxTotal) {
        this.maxTotal = maxTotal;
    }

    public long getMaxWaitMillis() {
        return maxWaitMillis;
    }

    public void setMaxWaitMillis(long maxWaitMillis) {
        this.maxWaitMillis = maxWaitMillis;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
