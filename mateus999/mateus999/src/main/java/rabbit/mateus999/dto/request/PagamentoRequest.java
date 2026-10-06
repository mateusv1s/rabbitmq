package rabbit.mateus999.dto.request;

import java.math.BigDecimal;

public record PagamentoRequest (

        String idempotencyKey,
        BigDecimal valor

)

{


}
