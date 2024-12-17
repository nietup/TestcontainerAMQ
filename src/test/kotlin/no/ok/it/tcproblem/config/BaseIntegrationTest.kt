package no.ok.it.tcproblem.config

import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.testcontainers.containers.GenericContainer
import org.testcontainers.containers.wait.strategy.Wait

@SpringBootTest
@ActiveProfiles("test")
abstract class BaseIntegrationTest {
    companion object {
        @JvmStatic
        val activeMQContainer: GenericContainer<*> = GenericContainer("rmohr/activemq:5.15.9")
            .withExposedPorts(61616)
            .waitingFor(Wait.forListeningPort())

        @JvmStatic
        @BeforeAll
        fun setup() {
            activeMQContainer.start()
            System.setProperty(
                "jms.activemq.brokerUrl",
                "tcp://${activeMQContainer.host}:${activeMQContainer.getMappedPort(61616)}"
            )
        }
    }
}
