package TP3.PART1;

public interface ProductApiClient {
    Product getProduct(String productId) throws ApiException;
}
