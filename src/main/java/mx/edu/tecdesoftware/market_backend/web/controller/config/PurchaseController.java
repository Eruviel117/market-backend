package mx.edu.tecdesoftware.market_backend.web.controller.config;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import mx.edu.tecdesoftware.market_backend.domain.Purchase;
import mx.edu.tecdesoftware.market_backend.domain.service.PurchaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchases")
@Tag(name = "Purchase", description = "Manage purchases in the store")
public class PurchaseController {

    private final PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @GetMapping("/all")
    @Operation(
            summary = "Get all purchases",
            description = "Return a list of all registered purchases"
    )
    @ApiResponse(responseCode = "200", description = "Successful retrieval of purchases")
    @ApiResponse(responseCode = "500", description = "Internal server error ")
    public ResponseEntity<List<Purchase>> getAll(){
        return new ResponseEntity<>(purchaseService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/client/{clientId}")
    @Operation(
            summary = "Get purchases by client ID",
            description = "Return all purchases made by a specific client"
    )
    @ApiResponse(responseCode = "200", description = "purchases found for the client")
    @ApiResponse(responseCode = "404", description = "no purchases found for the client")
    @ApiResponse(responseCode = "500", description = "Internal server error ")
    public ResponseEntity<List<Purchase>> getByClientId(
            @Parameter(description = "ID of the client", example = "3", required = true)
            @PathVariable String clientId){
        List<Purchase> purchases = purchaseService.getByClientId(clientId);
        if (purchases == null || purchases.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(purchases);
    }

    @PostMapping("/save")
    @Operation(
            summary = "Save a new purchase",
            description = "Register a new purchase and return the created purchase",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
                    required = true,
                    content = @Content(
                            examples = @ExampleObject(
                                    name = "Example purchase", value = """
                                    {
                                    "clientId" : "3",
                                    "fecha" : "2026-07-16T10:30:00",
                                    "medioPago" : "Efectivo",
                                    "comentario" : "Compra de prueba",
                                    "estado" : "Completada",
                                    "items" : [
                                        {
                                        "productId" : 5,
                                        "cantidad" : 2,
                                        "total" : 41.00,
                                        "estado" : true
                                        }
                                    ]
                                    }
                                    """
                            )
                    )
            )
    )
    @ApiResponse(responseCode = "201", description = "purchase created")
    @ApiResponse(responseCode = "500", description = "Internal server error ")
    public ResponseEntity<Purchase> save(@RequestBody Purchase purchase){
        return new ResponseEntity<>(purchaseService.save(purchase), HttpStatus.CREATED);
    }
}
