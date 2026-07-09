package mx.edu.tecdesoftware.market_backend.persistence;

import mx.edu.tecdesoftware.market_backend.domain.Purchase;
import mx.edu.tecdesoftware.market_backend.domain.repository.PurchaseRepository;
import mx.edu.tecdesoftware.market_backend.persistence.crud.CompraCrudRepository;
import mx.edu.tecdesoftware.market_backend.persistence.entity.Compra;
import mx.edu.tecdesoftware.market_backend.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PurchaseRepositoryImpl implements PurchaseRepository {

    @Autowired
    private CompraCrudRepository compraCrudRepository;

    @Autowired
    private PurchaseMapper purchaseMapper;

    // select * from compras
    public List<Purchase> getAll(){
        List<Compra> compras = (List<Compra>) compraCrudRepository.findAll();
        return purchaseMapper.toPurchases(compras);
    }

    // select * from compras where id_cliente = ?
    public List<Purchase> getByClientId(String clientId){
        List<Compra> compras = compraCrudRepository.findByIdCliente(clientId);
        return purchaseMapper.toPurchases(compras);
    }

    public Purchase save(Purchase purchase){
        Compra compra = purchaseMapper.toCompra(purchase);

        // Paso crítico: cada CompraProducto debe apuntar de vuelta a su Compra padre
        compra.getProductos().forEach(producto -> producto.setCompra(compra));

        return purchaseMapper.toPurchase(compraCrudRepository.save(compra));
    }
}