@RestController
@RequestMapping("/pagamento")
public class PagamentoController {
    	
    @PostMapping("/processar")
    public ResponseEntity<Boolean> processarPagamento(@RequestBody Pagamento pagamento) {
        // Lógica para processar o pagamento
        boolean sucesso = //... lógica de processamento
        return ResponseEntity.ok(sucesso);
    }
}
