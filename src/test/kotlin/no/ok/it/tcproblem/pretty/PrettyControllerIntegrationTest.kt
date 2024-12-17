package no.ok.it.tcproblem.pretty

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.DynamicPropertyRegistry
import org.springframework.test.context.DynamicPropertySource
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.testcontainers.activemq.ActiveMQContainer
import org.testcontainers.junit.jupiter.Container
import org.testcontainers.junit.jupiter.Testcontainers

@Testcontainers
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class PrettyControllerIntegrationTest {

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

    @Autowired
    lateinit var mockMvc: MockMvc

    @Test
    fun `send pretty message `() {
        mockMvc.perform(MockMvcRequestBuilders.put("/v1/pretty/send"))
    }
}
