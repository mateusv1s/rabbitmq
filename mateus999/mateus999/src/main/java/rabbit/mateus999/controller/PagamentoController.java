package rabbit.mateus999.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import rabbit.mateus999.dto.request.PagamentoRequest;
import rabbit.mateus999.dto.response.PagamentoResponse;
import rabbit.mateus999.service.PagamentoService;

@RestController
@RequestMapping("/pagamentos")
public class PagamentoController {

    private final PagamentoService pagamentoService;

    public PagamentoController(PagamentoService pagamentoService) {
        this.pagamentoService = pagamentoService;
    }

    @PostMapping
    public ResponseEntity <PagamentoResponse> criarPagamento (@RequestBody PagamentoRequest pagamentoRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(pagamentoService.criarPagamento(pagamentoRequest));
    }

}
