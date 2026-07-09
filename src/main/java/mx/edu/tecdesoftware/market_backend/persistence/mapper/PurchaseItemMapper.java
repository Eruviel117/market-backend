package mx.edu.tecdesoftware.market_backend.persistence.mapper;

import mx.edu.tecdesoftware.market_backend.domain.PurchaseItem;
import mx.edu.tecdesoftware.market_backend.persistence.entity.CompraProducto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PurchaseItemMapper {

    @Mapping(source = "id.idProducto", target = "productId")
    PurchaseItem toPurchaseItem(CompraProducto compraProducto);

    List<PurchaseItem> toPurchaseItems(List<CompraProducto> compraProductos);

    @Mapping(target = "producto.idProducto", source = "productId")
    @Mapping(target = "compra", ignore = true)
    @Mapping(target = "id", ignore = true)
    CompraProducto toCompraProducto(PurchaseItem purchaseItem);

    List<CompraProducto> toCompraProductos(List<PurchaseItem> purchaseItems);
}