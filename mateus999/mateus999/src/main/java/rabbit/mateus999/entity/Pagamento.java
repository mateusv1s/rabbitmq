package rabbit.mateus999.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import rabbit.mateus999.enums.StatusPagamento;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
public class Pagamento {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long idPagamento;

    private String idempotencyKey;

    private BigDecimal valor;

    private StatusPagamento status;

    private LocalDateTime criadoEm;

    private LocalDateTime pagoEm;

}
