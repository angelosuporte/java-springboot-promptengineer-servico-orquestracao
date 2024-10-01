//Serviço de Orquestração

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/criar")
    public ResponseEntity<String> criarPedido(@RequestBody Pedido pedido) {
        // Verificar a disponibilidade do produto
        ResponseEntity<Boolean> estoqueResponse = restTemplate.getForEntity("http://estoque/verificar/" + pedido.getProdutoId(), Boolean.class);
        
        if (!estoqueResponse.getBody()) {
               return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Produto não disponível em estoque.");
        }
// Criar o pedido
        ResponseEntity<Pedido> pedidoResponse = restTemplate.postForEntity("http://pedido/criar", pedido, Pedido.class);
        
        if (pedidoResponse.getStatusCode() == HttpStatus.CREATED) {
            return ResponseEntity.status(HttpStatus.CREATED).body(pedidoResponse.getBody());
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao criar o pedido.");
        }
    }
}
