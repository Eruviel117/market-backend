package mx.edu.tecdesoftware.market_backend.domain;

import java.time.LocalDateTime;
import java.util.List;

public class Purchase {

    private Integer purchaseId;
    private String clientId;
    private LocalDateTime fecha;
    private String medioPago;
    private String comentario;
    private String estado;
    private List<PurchaseItem> items;

    public Purchase() {
    }

    public Purchase(Integer purchaseId, String clientId, LocalDateTime fecha,
                    String medioPago, String comentario, String estado,
                    List<PurchaseItem> items) {
        this.purchaseId = purchaseId;
        this.clientId = clientId;
        this.fecha = fecha;
        this.medioPago = medioPago;
        this.comentario = comentario;
        this.estado = estado;
        this.items = items;
    }

    public Integer getPurchaseId() {
        return purchaseId;
    }

    public void setPurchaseId(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(String medioPago) {
        this.medioPago = medioPago;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<PurchaseItem> getItems() {
        return items;
    }

    public void setItems(List<PurchaseItem> items) {
        this.items = items;
    }
}