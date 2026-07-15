package mx.edu.tecdesoftware.market_backend.persistence.mapper;

import mx.edu.tecdesoftware.market_backend.domain.Purchase;
import mx.edu.tecdesoftware.market_backend.persistence.entity.Compra;
import mx.edu.tecdesoftware.market_backend.persistence.entity.CompraProducto;
import mx.edu.tecdesoftware.market_backend.persistence.entity.CompraProductoPK;
import org.mapstruct.AfterMapping;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PurchaseItemMapper.class})
public abstract class PurchaseMapper {

    @Mappings({
            @Mapping(source = "idCompra", target = "purchaseId"),
            @Mapping(source = "idCliente", target = "clientId"),
            @Mapping(source = "productos", target = "items")
    })
    public abstract Purchase toPurchase(Compra compra);

    public abstract List<Purchase> toPurchases(List<Compra> compras);

    @InheritInverseConfiguration
    public abstract Compra toCompra(Purchase purchase);

    @AfterMapping
    protected void linkProductos(@MappingTarget Compra compra) {
        if (compra.getProductos() == null) {
            return;
        }
        for (CompraProducto cp : compra.getProductos()) {
            CompraProductoPK pk = new CompraProductoPK();
            // idCompra queda en null: Hibernate lo completa vía @MapsId al persistir Compra
            pk.setIdProducto(cp.getProducto() != null ? cp.getProducto().getIdProducto() : null);
            cp.setId(pk);
            cp.setCompra(compra); // necesario para que @MapsId funcione en cascade
        }
    }
}