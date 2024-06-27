package com.example.Bai1.RequestRespone;

public class PurchaseRequest {
    //private Integer productDetailID;
    private Integer propertyDetailID;
    private Integer quantity;
    private Integer[] props;

    public PurchaseRequest() {

    }

    public PurchaseRequest(Integer propertyDetailID, Integer quantity, Integer[] props) {
        this.propertyDetailID = propertyDetailID;
        this.quantity = quantity;
        this.props = props;
    }

    public Integer getPropertyDetailID() {
        return propertyDetailID;
    }

    public void setPropertyDetailID(Integer propertyDetailID) {
        this.propertyDetailID = propertyDetailID;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer[] getProps() {
        return props;
    }

    public void setProps(Integer[] props) {
        this.props = props;
    }
}
