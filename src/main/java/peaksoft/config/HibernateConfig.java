package peaksoft.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Objects;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
public class HibernateConfig {
    private final Environment environment;

    @Autowired
    public HibernateConfig(Environment environment) {
        this.environment = environment;
    }


    @Bean
   public LocalContainerEntityManagerFactoryBean managerFactoryBean(){
        LocalContainerEntityManagerFactoryBean manager=
                new LocalContainerEntityManagerFactoryBean();
        return  manager;
   }

   @Bean
   public JpaVendorAdapter jpaVendorAdapter(){
         return new HibernateJpaVendorAdapter();
   }

   @Bean
   public DataSource dataSource(){
       BasicDataSource dataSource=new BasicDataSource();
       dataSource.setDriverClassName(environment.getProperty());
       dataSource.setUrl(environment.getProperty());
       dataSource.setUsername(environment.getProperty());
       dataSource.setPassword(environment.setProperty());
       return dataSource;
   }

   @Bean
   public PlatformTransactionManager transactionManager(){
        return new JpaTransactionManager(Objects.requireNonNull(managerFactoryBean().getObject()));
   }

   public Properties properties(){
        Properties properties=new Properties();
        properties.put("hibernate.dialect",environment.getProperty("hibernate.dialect"));
       properties.put("hibernate.show_sql",environment.getProperty("hibernate.show_sql"));
       properties.put("hibernate.hbm2ddl.auto",environment.getProperty("create"));
       return properties;
   }
}
