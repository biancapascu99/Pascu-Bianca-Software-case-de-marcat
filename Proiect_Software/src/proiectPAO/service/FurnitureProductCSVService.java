package proiectPAO.service;

import proiectPAO.model.products.FurnitureProduct;
import proiectPAO.model.products.Product;
import proiectPAO.model.readWriteFile.CSVService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FurnitureProductCSVService implements CSVService {

    private static FurnitureProductCSVService instance = new FurnitureProductCSVService();
    ProductService productService = ProductService.getInstance();

    private FurnitureProductCSVService() {
    }

    public static FurnitureProductCSVService getInstance() {
        return instance;
    }
    @Override
    public void readData() {

        Path path = Paths.get("furnitureProduct.csv");
        try (var input = Files.newBufferedReader(path)) {
            String line;
            while ((line = input.readLine()) != null) {
                String[] value = line.split(",");
                FurnitureProduct furnitureProduct = new FurnitureProduct(value[0], Double.parseDouble(value[1]), Integer.parseInt(value[2]),Double.parseDouble(value[3]),Boolean.parseBoolean(value[4]),Double.parseDouble(value[5]));
                productService.addProduct(furnitureProduct);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void writeData() {

        Path path = Paths.get("furnitureProduct.csv");
        try (var output = Files.newBufferedWriter(path)) {
            for (Product product : productService.getProducts()) {
                if(product instanceof FurnitureProduct){
                    output.write(product.getName());
                    output.write(",");
                    output.write(Double.toString(product.getPrice()));
                    output.write(",");
                    output.write(Integer.toString(product.getQuantity()));
                    output.write(",");
                    output.write(Double.toString(product.getDiscount()));
                    output.write(",");
                    output.write(Boolean.toString(((FurnitureProduct) product).isHasGuarantee()));
                    output.write(",");
                    output.write(Double.toString(((FurnitureProduct) product).getPriceTransport()));
                    output.newLine();
                    output.flush();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
