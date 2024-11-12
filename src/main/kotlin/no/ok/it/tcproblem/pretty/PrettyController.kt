package no.ok.it.tcproblem.pretty

import no.ok.it.tcproblem.util.QueueConstants.PRETTY_QUEUE
import org.springframework.jms.core.JmsTemplate
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/pretty")
class PrettyController(
    private val jmsTemplate: JmsTemplate
) {
    @PutMapping("/send")
    fun changeAktorBySaksNumberAndVirksomhet() {
        jmsTemplate.convertAndSend(PRETTY_QUEUE, "pretty message")
    }
}
