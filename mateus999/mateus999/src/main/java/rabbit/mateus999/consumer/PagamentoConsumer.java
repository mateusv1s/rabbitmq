package rabbit.mateus999.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import rabbit.mateus999.dto.request.PagamentoRequest;
import rabbit.mateus999.service.PagamentoService;

@Component
public class PagamentoConsumer {

    private final PagamentoService pagamentoService;

    public PagamentoConsumer(PagamentoService pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    @RabbitListener(queues = "payment.queue")
    public void consumirPagamento (PagamentoRequest pagamento) {
        pagamentoService.processarMensagem(pagamento);
    }

}
