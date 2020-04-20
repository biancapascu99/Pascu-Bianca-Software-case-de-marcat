package proiectPAO.service;


import proiectPAO.model.cashregisters.CashRegister;
import proiectPAO.model.readWriteFile.CSVService;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CashRegisterCSVService implements CSVService {


    private static CashRegisterCSVService instance = new CashRegisterCSVService();
    CashRegisterService cashRegisterService = CashRegisterService.getInstance();

    private CashRegisterCSVService() {
//        System.out.println("CashRegisterCSVService a fost creat");
    }

    public static CashRegisterCSVService getInstance() {
        return instance;
    }


    @Override
    public void readData() {

        Path path = Paths.get("cashRegisterData.csv");
        try (var input = Files.newBufferedReader(path)) {
            String line;
            int noLine = 0;
            while ((line = input.readLine()) != null) {
                String[] value = line.split(",");
                CashRegister cashRegister = new CashRegister(value[0], Integer.parseInt(value[1]));
//                System.out.println(cashRegister);
                cashRegisterService.addCashRegister(cashRegister);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void writeData() {

        Path path = Paths.get("cashRegisterData.csv");
        try (var output = Files.newBufferedWriter(path)) {
            for (CashRegister cashRegister : cashRegisterService.getCashRegister()) {
                output.write(cashRegister.getCashierName());
                output.write(",");
                output.write(Integer.toString(cashRegister.getNumberCashier()));
                output.newLine();
                output.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}




