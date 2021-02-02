package com.xuesran.datasource.masterslave.config;

import com.xuesran.datasource.masterslave.annotation.ReadOnlyRepository;
import com.xuesran.datasource.masterslave.constants.datasource.DataSourceConstants;
import org.apache.tomcat.jdbc.pool.PoolProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * The type Read only data source configuration.
 *
 * @author xueshun
 */
@Configuration
@EnableJpaRepositories(
        basePackages = DataSourceConstants.BASE_PACKAGES,
        includeFilters = @ComponentScan.Filter(ReadOnlyRepository.class),
        entityManagerFactoryRef = "readOnlyEntityManagerFactory"
)
public class ReadOnlyDataSourceConfiguration {

    private String url;
    private String username;
    private String password;
    private String driverClassName;
    private Integer tomcatMaxActiveConnections;
    private Integer tomcatMaxIdleConnections;
    private Integer tomcatTimeBetweenEvictionRunsInMillis;
    private Integer tomcatMinTimeForEvictionEligibilityInMillis;
    private Boolean tomcatRemoveAbandonedConnections;
    private Boolean showSQL;

    /**
     * Instantiates a new Read only data source configuration.
     *
     * @param url                                         the url
     * @param username                                    the username
     * @param password                                    the password
     * @param driverClassName                             the driver class name
     * @param tomcatMaxActiveConnections                  the tomcat max active connections
     * @param tomcatMaxIdleConnections                    the tomcat max idle connections
     * @param tomcatTimeBetweenEvictionRunsInMillis       the tomcat time between eviction runs in millis
     * @param tomcatMinTimeForEvictionEligibilityInMillis the tomcat min time for eviction eligibility in millis
     * @param tomcatRemoveAbandonedConnections            the tomcat remove abandoned connections
     * @param showSQL                                     the show sql
     */
    @Autowired
    public ReadOnlyDataSourceConfiguration(@Value("${spring.datasource.read_url}") String url,
                                           @Value("${spring.datasource.read_username}") String username,
                                           @Value("${spring.datasource.read_password}") String password,
                                           @Value("${spring.datasource.driver-class-name}") String driverClassName,
                                           @Value("${spring.datasource.tomcat.max-active}") Integer tomcatMaxActiveConnections,
                                           @Value("${spring.datasource.tomcat.max-idle}") Integer tomcatMaxIdleConnections,
                                           @Value("${spring.datasource.tomcat.time-between-eviction-runs-millis}") Integer tomcatTimeBetweenEvictionRunsInMillis,
                                           @Value("${spring.datasource.tomcat.min-evictable-idle-time-millis}") Integer tomcatMinTimeForEvictionEligibilityInMillis,
                                           @Value("${spring.datasource.tomcat.remove-abandoned}") Boolean tomcatRemoveAbandonedConnections,
                                           @Value("${spring.jpa.show-sql}") Boolean showSQL) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.driverClassName = driverClassName;
        this.tomcatMaxActiveConnections = tomcatMaxActiveConnections;
        this.tomcatMaxIdleConnections = tomcatMaxIdleConnections;
        this.tomcatTimeBetweenEvictionRunsInMillis = tomcatTimeBetweenEvictionRunsInMillis;
        this.tomcatMinTimeForEvictionEligibilityInMillis = tomcatMinTimeForEvictionEligibilityInMillis;
        this.tomcatRemoveAbandonedConnections = tomcatRemoveAbandonedConnections;
        this.showSQL = showSQL;
    }

    /**
     * Read data source data source.
     *
     * @return the data source
     */
    @Bean
    public DataSource readDataSource() {
        PoolProperties poolProperties = new PoolProperties();
        poolProperties.setUrl(url);
        poolProperties.setUsername(username);
        poolProperties.setPassword(password);
        poolProperties.setDriverClassName(driverClassName);
        poolProperties.setMaxActive(tomcatMaxActiveConnections);
        poolProperties.setMaxIdle(tomcatMaxIdleConnections);
        poolProperties.setTimeBetweenEvictionRunsMillis(tomcatTimeBetweenEvictionRunsInMillis);
        poolProperties.setMinEvictableIdleTimeMillis(tomcatMinTimeForEvictionEligibilityInMillis);
        poolProperties.setRemoveAbandoned(tomcatRemoveAbandonedConnections);

        org.apache.tomcat.jdbc.pool.DataSource readDataSource = new org.apache.tomcat.jdbc.pool.DataSource();
        readDataSource.setPoolProperties(poolProperties);
        return readDataSource;
    }

    /**
     * Read only entity manager factory local container entity manager factory bean.
     *
     * @return the local container entity manager factory bean
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean readOnlyEntityManagerFactory() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(false);
        Map<String, String> properties = new HashMap<>();
        properties.put(DataSourceConstants.HIBERNATE_IMPLICIT_NAMING_STRATEGY, DataSourceConstants.HIBERNATE_IMPLICIT_NAMING_STRATEGY_VALUE);
        properties.put(DataSourceConstants.HIBERNATE_PHYSICAL_NAMING_STRATEGY, DataSourceConstants.HIBERNATE_PHYSICAL_NAMING_STRATEGY_VALUE);
        properties.put(DataSourceConstants.HIBERNATE_SHOW_SQL, String.valueOf(showSQL));
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        factoryBean.setDataSource(readDataSource());
        factoryBean.setPackagesToScan(DataSourceConstants.BASE_PACKAGES);
        factoryBean.setJpaVendorAdapter(vendorAdapter);
        factoryBean.getJpaPropertyMap().putAll(properties);
        return factoryBean;
    }
}
