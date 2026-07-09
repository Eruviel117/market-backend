package mx.edu.tecdesoftware.market_backend.domain;

public class PurchaseItem {

    private Integer productId;
    private Integer cantidad;
    private Double total;
    private Boolean estado;

    public PurchaseItem() {
    }

    public PurchaseItem(Integer productId, Integer cantidad, Double total, Boolean estado) {
        this.productId = productId;
        this.cantidad = cantidad;
        this.total = total;
        this.estado = estado;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}