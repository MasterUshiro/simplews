package ua.com.simplews.example.FileReader;

import org.apache.commons.io.Charsets;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.LineIterator;
import org.apache.tomcat.util.http.fileupload.IOUtils;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FileReaderExample {


    private static final String __FILE_NAME = "text.txt";

    public static void main(String[] args) {

        new FileReaderExample().run();

    }

    void run() {


        System.out.println(readWithRules(__FILE_NAME, 2));

        System.out.println("------------");

        FileReader fr = runFileReader(FileReaderTypes.OLD);
        fr.getFileRows(__FILE_NAME);

        fr = runFileReader(FileReaderTypes.APACHE);
        fr.getFileRows(__FILE_NAME);

        fr = runFileReader(FileReaderTypes.APACHE_LIT);
        fr.getFileRows(__FILE_NAME);

        fr = runFileReader(FileReaderTypes.JAVA7);
        fr.getFileRows(__FILE_NAME);

        System.out.println("Stream");
        fr = runFileReader(FileReaderTypes.STREAM);
        fr.getFileRows(__FILE_NAME);

        System.out.println("Scanner");
        fr = runFileReader(FileReaderTypes.SCANNER);
        fr.getFileRows(__FILE_NAME);
    }


    FileReader runFileReader(FileReaderTypes fileReaderTypes) {
        if (fileReaderTypes == FileReaderTypes.OLD) {
            return new FileReaderOld();
        } else if (fileReaderTypes == FileReaderTypes.APACHE) {
            return new FileReaderApache();
        } else if (fileReaderTypes == FileReaderTypes.APACHE_LIT) {
            return new FileReaderApacheLit();
        } else if (fileReaderTypes == FileReaderTypes.JAVA7) {
            return new FileReaderJAVA7();
        } else if (fileReaderTypes == FileReaderTypes.STREAM) {
            return new FileReaderStream();
        }else if (fileReaderTypes == FileReaderTypes.SCANNER) {
            return new FileReaderScanner();
        }
        throw new NullPointerException("Exception: file Reader type for :" + fileReaderTypes + " not Exist!");
    }


    enum FileReaderTypes {
        OLD, APACHE, APACHE_LIT, JAVA7, STREAM, SCANNER;
    }

    interface FileReader {

        List<String> getFileRows(String fileName);

    }

    class FileReaderOld implements FileReader {

        @Override
        public List<String> getFileRows(String fileName) {
            List<String> res = new ArrayList<>();
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(
                        new InputStreamReader(
                                new FileInputStream(__FILE_NAME), Charset.forName("UTF-8")));
                String line;
                while ((line = reader.readLine()) != null) {
                    res.add(line);
                    System.out.println(line);
                }
            } catch (IOException e) {
                // log error
            } finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e) {
                        // log warning
                    }
                }
            }

            return res;
        }
    }

    class FileReaderApache implements FileReader {

        @Override
        public List<String> getFileRows(String fileName) {
            InputStreamReader in = null;
            List<String> res = new ArrayList<>();
            try {
                in = new InputStreamReader(new FileInputStream(new File(fileName)), Charsets.UTF_8);
                LineIterator it = new LineIterator(in);
                while (it.hasNext()) {
                    String line = it.nextLine();
                    System.out.println(line);
                    res.add(line);
                }
            } catch (IOException e) {
                // log error
            } finally {
                IOUtils.closeQuietly(in);
            }
            return res;
        }
    }


    class FileReaderApacheLit implements FileReader {

        @Override
        public List<String> getFileRows(String fileName) {
            LineIterator it = null;
            List<String> res = new ArrayList<>();
            try {
                it = FileUtils.lineIterator(new File(fileName), "UTF-8");
                while (it.hasNext()) {
                    String line = it.nextLine();
                    System.out.println(line);
                    res.add(line);
                }
            } catch (IOException e) {
                // log error
            } finally {
                if (it != null) {
                    it.close();
                }
            }
            return res;
        }
    }


    class FileReaderJAVA7 implements FileReader {

        @Override
        public List<String> getFileRows(String fileName) {
            List<String> res = new ArrayList<>();
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream(fileName), StandardCharsets.UTF_8))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                    res.add(line);
                }
            } catch (IOException e) {
                // log error
            }

            System.out.println("JAVA7 - 2");

            List<String> lines = null;
            try {
                lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
            } catch (IOException e) {
                e.printStackTrace();
            }
            for (String line : lines) {
                System.out.println(line);
            }


            return res;
        }
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

            for (String line : res) {

                System.out.println("Line = " + line);
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

                    if (sc.hasNext()==true) {

                        String line = sc.nextLine();

                        res.add(line);
                        System.out.println("line = "  + line);
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


    String  readWithRules(String fileName, int size) {
        RandomAccessFile raf = null;
        String result = "";
        try {
            raf = new RandomAccessFile(new File(fileName), "rw");

            byte [] buffer = new byte[size];
            try {
                System.out.println("raf " + raf.length());
                raf.seek(raf.length() - size);
                raf.read(buffer);
                result = new String(buffer,StandardCharsets.UTF_8);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }




        return result;
    }



}
