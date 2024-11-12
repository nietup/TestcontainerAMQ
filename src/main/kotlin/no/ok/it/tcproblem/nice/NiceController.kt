package no.ok.it.tcproblem.nice

import no.ok.it.tcproblem.util.QueueConstants
import org.springframework.jms.core.JmsTemplate
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/nice")
class NiceController(
    private val jmsTemplate: JmsTemplate
) {

    @PostMapping("/send")
    fun opprettHendelse() {
        jmsTemplate.convertAndSend(QueueConstants.NICE_QUEUE, "nice message")
    }
}
