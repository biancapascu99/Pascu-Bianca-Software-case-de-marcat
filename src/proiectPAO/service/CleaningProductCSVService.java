package proiectPAO.service;

import proiectPAO.model.products.CleaningProduct;
import proiectPAO.model.products.FoodProduct;
import proiectPAO.model.products.Product;
import proiectPAO.model.readWriteFile.CSVService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CleaningProductCSVService implements CSVService {


        private static CleaningProductCSVService instance = new CleaningProductCSVService();
        ProductService productService = ProductService.getInstance();

        private CleaningProductCSVService() {
        }

        public static CleaningProductCSVService getInstance() {
            return instance;
        }

        @Override
        public void readData() {

            Path path = Paths.get("cleaningProduct.csv");
            try (var input = Files.newBufferedReader(path)) {
                String line;
                int noLine = 0;
                while ((line = input.readLine()) != null) {
                    String[] value = line.split(",");
                    CleaningProduct cleaningProduct = new CleaningProduct(value[0], Double.parseDouble(value[1]), Integer.parseInt(value[2]),Boolean.parseBoolean(value[3]));
                    productService.addProduct(cleaningProduct);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void writeData() {

            Path path = Paths.get("cleaningProduct.csv");
            try (var output = Files.newBufferedWriter(path)) {
                for (Product product : productService.getProducts()) {
                    if(product instanceof CleaningProduct){
                        output.write(product.getName());
                        output.write(",");
                        output.write(Double.toString(product.getPrice()));
                        output.write(",");
                        output.write(Integer.toString(product.getQuantity()));
                        output.write(",");
                        output.write(Boolean.toString(((CleaningProduct) product).isExpired()));
                        output.newLine();
                        output.flush();
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }


        }
    }



