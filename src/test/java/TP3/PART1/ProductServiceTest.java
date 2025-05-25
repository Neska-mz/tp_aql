package TP3.PART1;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class ProductServiceTest {

    @Test
    void testGetProductSuccess() throws ApiException {
        // Arrange
        ProductApiClient apiClient = mock(ProductApiClient.class);
        ProductService productService = new ProductService(apiClient);
        String productId = "P123";
        Product expectedProduct = new Product(productId, "Laptop");
        when(apiClient.getProduct(productId)).thenReturn(expectedProduct);

        // Act
        Product actualProduct = productService.getProduct(productId);

        // Assert
        assertEquals(expectedProduct, actualProduct);
        verify(apiClient).getProduct(productId);
    }

    @Test
    void testGetProductApiFailure() throws ApiException {
        // Arrange
        ProductApiClient apiClient = mock(ProductApiClient.class);
        ProductService productService = new ProductService(apiClient);
        String productId = "P123";
        when(apiClient.getProduct(productId)).thenThrow(new ApiException("API failure"));

        // Act & Assert
        assertThrows(ApiException.class, () -> productService.getProduct(productId));
        verify(apiClient).getProduct(productId);
    }

    @Test
    void testGetProductInvalidDataFormat() throws ApiException {
        // Arrange
        ProductApiClient apiClient = mock(ProductApiClient.class);
        ProductService productService = new ProductService(apiClient);
        String productId = "P123";
        when(apiClient.getProduct(productId)).thenReturn(null); // Simule un format de données incompatible

        // Act
        Product result = productService.getProduct(productId);

        // Assert
        assertNull(result);
        verify(apiClient).getProduct(productId);
    }
}
