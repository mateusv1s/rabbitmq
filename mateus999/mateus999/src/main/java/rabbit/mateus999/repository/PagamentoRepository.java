package rabbit.mateus999.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rabbit.mateus999.entity.Pagamento;

@Repository
public interface PagamentoRepository extends JpaRepository <Pagamento, Long> {



}
