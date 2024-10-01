@RestController
@RequestMapping("/estoque")
public class EstoqueController {
    
    @GetMapping("/verificar/{produtoId}")
    public ResponseEntity<Boolean> verificarDisponibilidade(@PathVariable String produtoId) {
        // Lógica para verificar se o produto está disponível
        boolean disponivel = //... lógica de verificação
        return ResponseEntity.ok(disponivel);
    }
}
