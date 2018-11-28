package eu.dariah.has.ddrs;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.io.*;
import java.util.*;

public class SetupPassword {
    public static void main(String[] args) {
        System.out.println("Enter your admin password: ");
        Scanner scanner = new Scanner(System.in);
        String password = scanner.nextLine();

        final BCryptPasswordEncoder bcryptEncoder = new BCryptPasswordEncoder();
        String encodedPassword = bcryptEncoder.encode(password);
        saveProperties(loadProperties(), encodedPassword);
    }

    private static Properties loadProperties() {
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream("install-files/application.properties");
            prop.load(input);
            return prop;
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    private static void saveProperties(Properties properties, String encodedPassword) {
        if(properties == null) {
            System.out.println("Error, could not read the properties...");
            System.exit(-1);
        }
        OutputStream output = null;
        try {
            output = new FileOutputStream("install-files/application.properties");
            properties.setProperty("ddrs.admin.encoded.password", encodedPassword);
            properties.store(output, null);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
