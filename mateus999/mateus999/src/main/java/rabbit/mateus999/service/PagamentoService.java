package rabbit.mateus999.service;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import rabbit.mateus999.dto.request.PagamentoRequest;
import rabbit.mateus999.dto.response.PagamentoResponse;
import rabbit.mateus999.entity.Pagamento;
import rabbit.mateus999.enums.StatusPagamento;
import rabbit.mateus999.repository.PagamentoRepository;

import java.time.LocalDateTime;

@Service
public class PagamentoService {

    private final PagamentoRepository pagamentoRepository;

    public PagamentoService(PagamentoRepository pagamentoRepository) {
        this.pagamentoRepository = pagamentoRepository;
    }

    @Transactional
    public PagamentoResponse criarPagamento(PagamentoRequest request) {

        Pagamento pagamento = new Pagamento();
        pagamento.setValor(request.valor());
        pagamento.setStatus(StatusPagamento.PENDENTE);
        pagamento.setCriadoEm(LocalDateTime.now());

        Pagamento pagamentoSalvo = pagamentoRepository.save(pagamento);

        return PagamentoResponse.dto(pagamentoSalvo);

    }

    @Transactional
    public void processarMensagem(PagamentoRequest request) {

        Pagamento pagamento = new Pagamento();
        pagamento.setValor(request.valor());
        pagamento.setStatus(StatusPagamento.CONFIRMADO);
        pagamento.setCriadoEm(LocalDateTime.now());
        pagamento.setPagoEm(LocalDateTime.now());

        pagamentoRepository.save(pagamento);

    }

}
