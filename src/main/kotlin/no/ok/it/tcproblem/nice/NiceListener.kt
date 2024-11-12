package no.ok.it.tcproblem.nice

import no.ok.it.tcproblem.util.QueueConstants.NICE_QUEUE
import org.slf4j.LoggerFactory
import org.springframework.jms.annotation.JmsListener
import org.springframework.stereotype.Component

@Component
class NiceListener() {
    private val logger = LoggerFactory.getLogger(javaClass)

    @JmsListener(destination = NICE_QUEUE)
    fun consumeMessage(niceMessage: String) {
        logger.info("Got nice message: $niceMessage")
    }
}
