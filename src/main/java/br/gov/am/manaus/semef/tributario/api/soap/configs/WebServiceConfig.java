package br.gov.am.manaus.semef.tributario.api.soap.configs;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurerAdapter {

    public static final String NAMESPACE_URI = "http://api.tributario.semef.manaus.am.gov.br/soap/ws";

    // Loading schemas
    @Bean
    public XsdSchema articlesSchema() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/articles.xsd"));
    }

    @Bean
    public XsdSchema iptuDebitosSchema() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/iptuDebitos.xsd"));
    }

    // Servlets registration
    @Bean
    public ServletRegistrationBean<MessageDispatcherServlet> messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean<>(servlet, "/ws/*");
    }

    @Bean(name = "articles")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema articlesSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("ArticlesPort");
        wsdl11Definition.setLocationUri("/ws/art");
        wsdl11Definition.setTargetNamespace(NAMESPACE_URI);
        wsdl11Definition.setSchema(articlesSchema);
        return wsdl11Definition;
    }

    @Bean(name = "iptuDebitos")
    public DefaultWsdl11Definition IPTUDebitoWsdl11Definition(XsdSchema iptuDebitosSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("IPTUDebitosPort");
        wsdl11Definition.setLocationUri("/ws/debitos");
        wsdl11Definition.setTargetNamespace(NAMESPACE_URI);
        wsdl11Definition.setSchema(iptuDebitosSchema);
        return wsdl11Definition;
    }

}
