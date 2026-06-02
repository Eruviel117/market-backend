package mx.edu.tecdesoftware.market_backend.persistence.crud;
import mx.edu.tecdesoftware.market_backend.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductoCrudRepository extends CrudRepository<Producto, Integer> {

// Query method
    /*
    obtener una lista de productos filtrafos por id de categoria y ordenado ascendentemente por nombre

    SELECT * FROM categoria
    WHERE id_categoria = ?
    ORDER BY nombre ASC
    */

    List<Producto > findByIdCategoriaOrderByNombreAsc(int idCategoria );

    //obtener los procesos
    Optional<List<Producto>> findCantidadStockLessThanAndEstado(int cantidad, boolean estado );
    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(Integer cantidadStock, Boolean estado);


}
