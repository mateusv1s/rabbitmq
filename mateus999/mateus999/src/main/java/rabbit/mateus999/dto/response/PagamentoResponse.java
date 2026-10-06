package rabbit.mateus999.dto.response;

import rabbit.mateus999.entity.Pagamento;
import rabbit.mateus999.enums.StatusPagamento;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record PagamentoResponse (

        Long idPagamento,
        BigDecimal valor,
        StatusPagamento status,
        LocalDateTime criadoEm,
        LocalDateTime pagoEm

)

{

    public static PagamentoResponse dto (Pagamento pagamento) {
        return new PagamentoResponse (
                pagamento.getIdPagamento(),
                pagamento.getValor(),
                pagamento.getStatus(),
                pagamento.getCriadoEm(),
                pagamento.getPagoEm()
        );
    }

}
