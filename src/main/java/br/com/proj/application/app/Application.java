package br.com.proj.application.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import java.util.Properties;

//@Configuration
//@EnableAutoConfiguration (exclude = DataSourceAutoConfiguration.class)
//(exclude = HibernateJpaAutoConfiguration.class)
//@EnableTransactionManagement
//@ComponentScan(basePackages = {"br.com.proj.application.*"})
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class, scanBasePackages = "br.com.proj.application.*")
        //(scanBasePackages = "br.com.proj.application.*")
public class Application {

    public static void main(String[] args) throws Exception {
        //Classe de configuração e argumentos.
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();

        factoryBean.setJpaVendorAdapter(vendorAdapter);

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUsername("root");
        dataSource.setPassword("q1w2e3r4");
        dataSource.setUrl("jdbc:mysql://localhost:3306/way");
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");

        factoryBean.setDataSource(dataSource);

        Properties props = new Properties();
        props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        props.setProperty("hibernate.show_sql", "true");
        props.setProperty("hibernate.hbm2ddl.auto", "update");

        factoryBean.setJpaProperties(props);

        factoryBean.setPackagesToScan("br.com.proj.application.*");

        return factoryBean;
    }

}
