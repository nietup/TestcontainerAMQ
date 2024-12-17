package no.ok.it.tcproblem.config

import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.testcontainers.activemq.ActiveMQContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers

@Testcontainers
@SpringBootTest
@ActiveProfiles("test")
abstract class BaseIntegrationTest {
    companion object {
        @Container
        @JvmStatic
        val activeMQContainer: ActiveMQContainer = ActiveMQContainer("apache/activemq-classic:5.18.3")

        @DynamicPropertySource
        @JvmStatic
        fun amqProperties(registry: DynamicPropertyRegistry) {
            registry.add("jms.activemq.brokerUrl") { activeMQContainer.brokerUrl }
        }
    }
}
