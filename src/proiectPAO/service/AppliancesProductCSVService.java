package proiectPAO.service;

import proiectPAO.model.products.AppliancesProduct;
import proiectPAO.model.products.Product;
import proiectPAO.model.readWriteFile.CSVService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AppliancesProductCSVService implements CSVService {


    private static AppliancesProductCSVService instance = new AppliancesProductCSVService();
    ProductService productService = ProductService.getInstance();

    private AppliancesProductCSVService() {
    }

    public static AppliancesProductCSVService getInstance() {
        return instance;
    }

    @Override
    public void readData() {

        Path path = Paths.get("appliancesProduct.csv");
        try (var input = Files.newBufferedReader(path)) {
            String line;
            while ((line = input.readLine()) != null) {
                String[] value = line.split(",");
                AppliancesProduct appliancesProduct = new AppliancesProduct(value[0], Double.parseDouble(value[1]), Integer.parseInt(value[2]), Double.parseDouble(value[3]), Boolean.parseBoolean(value[4]), Double.parseDouble(value[5]));
                productService.addProduct(appliancesProduct);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void writeData() {

        Path path = Paths.get("appliancesProduct.csv");
        try (var output = Files.newBufferedWriter(path)) {
            for (Product product : productService.getProducts()) {
                if (product instanceof AppliancesProduct) {
                    output.write(product.getName());
                    output.write(",");
                    output.write(Double.toString(product.getPrice()));
                    output.write(",");
                    output.write(Integer.toString(product.getQuantity()));
                    output.write(",");
                    output.write(Double.toString(product.getDiscount()));
                    output.write(",");
                    output.write(Boolean.toString(((AppliancesProduct) product).isHasGuarantee()));
                    output.write(",");
                    output.write(Double.toString(((AppliancesProduct) product).getPriceTransport()));
                    output.newLine();
                    output.flush();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


