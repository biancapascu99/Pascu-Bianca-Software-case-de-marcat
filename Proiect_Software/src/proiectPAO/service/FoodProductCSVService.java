package proiectPAO.service;

import proiectPAO.model.payment.Card;
import proiectPAO.model.products.FoodProduct;
import proiectPAO.model.products.Product;
import proiectPAO.model.readWriteFile.CSVService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FoodProductCSVService implements CSVService {

    private static FoodProductCSVService instance = new FoodProductCSVService();
    ProductService productService = ProductService.getInstance();

    private FoodProductCSVService() {
    }

    public static FoodProductCSVService getInstance() {
        return instance;
    }

    @Override
    public void readData() {

        Path path = Paths.get("foodProduct.csv");
        try (var input = Files.newBufferedReader(path)) {
            String line;
            int noLine = 0;
            while ((line = input.readLine()) != null) {
                String[] value = line.split(",");
                FoodProduct foodProduct = new FoodProduct(value[0], Double.parseDouble(value[1]), Integer.parseInt(value[2]),Double.parseDouble(value[3]),Boolean.parseBoolean(value[4]));
                productService.addProduct(foodProduct);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeData() {

        Path path = Paths.get("foodProduct.csv");
        try (var output = Files.newBufferedWriter(path)) {
            for (Product product : productService.getProducts()) {
                if (product instanceof FoodProduct) {
                    output.write(product.getName());
                    output.write(",");
                    output.write(Double.toString(product.getPrice()));
                    output.write(",");
                    output.write(Integer.toString(product.getQuantity()));
                    output.write(",");
                    output.write(Double.toString(product.getDiscount()));
                    output.write(",");
                    output.write(Boolean.toString(((FoodProduct) product).isExpired()));
                    output.newLine();
                    output.flush();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

