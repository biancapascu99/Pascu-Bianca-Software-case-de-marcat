package proiectPAO.service;

import proiectPAO.model.products.ClotheProduct;
import proiectPAO.model.products.Product;
import proiectPAO.model.readWriteFile.CSVService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ClotheProductCSVService implements CSVService {


    private static ClotheProductCSVService instance = new ClotheProductCSVService();
    ProductService productService = ProductService.getInstance();

    private ClotheProductCSVService() {
    }

    public static ClotheProductCSVService getInstance() {
        return instance;
    }

    @Override
    public void readData() {

        Path path = Paths.get("clotheProduct.csv");
        try (var input = Files.newBufferedReader(path)) {
            String line;
            while ((line = input.readLine()) != null) {
                String[] value = line.split(",");
                ClotheProduct clotheProduct = new ClotheProduct(value[0], Double.parseDouble(value[1]), Integer.parseInt(value[2]), Double.parseDouble(value[3]), Boolean.parseBoolean(value[4]), Double.parseDouble(value[5]));
                productService.addProduct(clotheProduct);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void writeData() {

        Path path = Paths.get("clotheProduct.csv");
        try (var output = Files.newBufferedWriter(path)) {
            for (Product product : productService.getProducts()) {
                if (product instanceof ClotheProduct) {
                    output.write(product.getName());
                    output.write(",");
                    output.write(Double.toString(product.getPrice()));
                    output.write(",");
                    output.write(Integer.toString(product.getQuantity()));
                    output.write(",");
                    output.write(Double.toString(product.getDiscount()));
                    output.write(",");
                    output.write(Boolean.toString(((ClotheProduct) product).isHasGuarantee()));
                    output.write(",");
                    output.write(Double.toString(((ClotheProduct) product).getPriceTransport()));
                    output.newLine();
                    output.flush();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




