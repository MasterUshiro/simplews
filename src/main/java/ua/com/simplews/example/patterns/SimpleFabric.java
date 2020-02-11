package ua.com.simplews.example.patterns;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class SimpleFabric {

    private static final String __FILE_NAME = "text.txt";

    public enum FileReaderTypes {
        OLD, APACHE, APACHE_LIT, JAVA7, STREAM, SCANNER;
    }

    interface FileReader {
        List<String> getFileRows(String fileName);
    }

    class FileReaderStream implements FileReader {

        @Override
        public List<String> getFileRows(String fileName) {
            List<String> res = new ArrayList<>();
            try {
                res = Files.lines(Paths.get(fileName), StandardCharsets.UTF_8).collect(Collectors.toList());
            } catch (IOException e) {
                e.printStackTrace();
            }

            return res;
        }
    }


    class FileReaderScanner implements FileReader {

        @Override
        public List<String> getFileRows(String fileName) {
            List<String> res = new ArrayList<>();
            try {
                Scanner sc = new Scanner(new File(fileName));
                while (true) {
                    if (sc.hasNext() == true) {
                        String line = sc.nextLine();
                        res.add(line);
                    } else {
                        break;
                    }
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

            return res;
        }
    }


    abstract class FieReaderMain {

        void printFileData() {
            List<String> data = readDataGeneral().getFileRows(__FILE_NAME);
            if (data != null) {
                data.forEach(x -> System.out.println("line: " + x));
            }
        }

        public abstract FileReader readDataGeneral();

    }

    class ReadByStream extends FieReaderMain {

        @Override
        public FileReader readDataGeneral() {
            System.out.println("ReadByStream");
            return new FileReaderStream();
        }
    }

    class ReadByScanner extends FieReaderMain {

        @Override
        public FileReader readDataGeneral() {
            return new FileReaderScanner();
        }
    }


    public static void main(String[] args) {

        new SimpleFabric().applyReader(FileReaderTypes.SCANNER).printFileData();

    }

    FieReaderMain applyReader(FileReaderTypes anEnum) {
        System.out.println("anEnum = " + anEnum.toString());
        switch (anEnum) {
            case STREAM:
                return new ReadByStream();
            case SCANNER:
                System.out.println("IN SCANNER");
                return new ReadByScanner();
        }
        return null;
    }


}

interface Pizza {
    void createPizza();
}

class DodoPizza implements Pizza {
    @Override
    public void createPizza() {
        System.out.println(">> " + this.getClass().getName());
    }
}

class FanPizza implements Pizza {
    @Override
    public void createPizza() {
        System.out.println(">> " + this.getClass().getName());
    }
}

class CreatePizza {
    @Test
    void doPizza() {
        Pizza pi = fabricusPizza("dodo");
        pi.createPizza();
    }

    Pizza fabricusPizza(String type) {
        if (type.equals("fan")) {
            System.out.println("FFf");
            return new FanPizza();
        } else if (type.equals("dodo")) {
            return new DodoPizza();
        }
        return null;
    }
}


interface District {
    void getDistrict();
}

interface PizailoFactory {
    District createDistrict();
    List<Pizza> createPizza();
}

class BorschagaPizza implements PizailoFactory {

    @Override
    public District createDistrict() {
        return new BorschagaDistrict();
    }

    @Override
    public List<Pizza> createPizza() {
        List<Pizza> listPi = new ArrayList<>();
        listPi.add(new DodoPizza());
        listPi.add(new FanPizza());
        return listPi;
    }


}

class BorschagaDistrict implements District {

    @Override
    public void getDistrict() {
        System.out.println("Борщаговка");
    }
}

class OtradniyDistrict implements District {

    @Override
    public void getDistrict() {
        System.out.println("Отрадный");
    }
}