package proiectPAO.service;

import proiectPAO.model.payment.Card;
import proiectPAO.model.readWriteFile.CSVService;
import proiectPAO.repository.CardRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CardCSVService implements CSVService {

    private static CardCSVService instance = new CardCSVService();
    CardService cardService = CardService.getInstance();

    private CardCSVService() {

//        System.out.println("CardCSVService a fost creat");
    }

    public static CardCSVService getInstance() {
        return instance;
    }


    @Override
    public void readData() {

        Path path = Paths.get("cardData.csv");
        try (var input = Files.newBufferedReader(path)) {
            String line;
            int noLine = 0;
            while ((line = input.readLine()) != null) {
                String[] value = line.split(",");
                Card card = new Card(value[0], Integer.parseInt(value[1]));
//                System.out.println(card);
                cardService.addCard(card);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void writeData() {

        Path path = Paths.get("cardData.csv");
        try (var output = Files.newBufferedWriter(path)) {
            for (Card card : cardService.getCard()) {
                output.write(card.getName());
                output.write(",");
                output.write(Integer.toString(card.getNumberCard()));
                output.newLine();
                output.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}


