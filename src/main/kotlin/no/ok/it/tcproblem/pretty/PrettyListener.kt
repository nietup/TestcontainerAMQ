package no.ok.it.tcproblem.pretty

import no.ok.it.tcproblem.util.QueueConstants.PRETTY_QUEUE
import org.slf4j.LoggerFactory
import org.springframework.jms.annotation.JmsListener
import org.springframework.stereotype.Service

@Service
class PrettyListener() {

    private val logger = LoggerFactory.getLogger(javaClass)

    @JmsListener(destination = PRETTY_QUEUE)
    fun updateAktor(prettyMessage: String) {
        logger.info("Got pretty message $prettyMessage")
    }
}
