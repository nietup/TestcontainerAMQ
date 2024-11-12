package no.ok.it.tcproblem.config

import jakarta.jms.ConnectionFactory
import org.apache.activemq.ActiveMQConnectionFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.jms.core.JmsTemplate

@Configuration
@Profile("test")
class TestJmsConfig(
    @Value("\${jms.activemq.brokerUrl}") private val brokerUrl: String
) {
    @Bean
    fun connectionFactory(): ConnectionFactory {
        return ActiveMQConnectionFactory().apply {
            brokerURL = brokerUrl
        }
    }

    @Bean
    fun jmsTemplate(connectionFactory: ConnectionFactory): JmsTemplate {
        return JmsTemplate(connectionFactory)
    }
}
