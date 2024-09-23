package 奥特曼;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class ATMSystem {
    private static final String DATA_FILE = "atm_data.txt";
    private static final String CARD_FILE = "cards_data.txt";
    private static Map<String, String> cardData = new HashMap<>();
    private static double balance = 10000.0;
    private static String currentCardNumber;

    public static void main(String[] args) {
        loadCardData();

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("ATM System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));
        
        JButton loginButton = new JButton("登录");
        JButton registerButton = new JButton("注册");
        JButton exitButton = new JButton("退出");
        
        panel.add(loginButton);
        panel.add(registerButton);
        panel.add(exitButton);

        frame.getContentPane().add(panel);
        
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add login logic here
            }
        });

        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add register logic here
            }
        });

        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        frame.pack();
        frame.setVisible(true);
    }

    private static void loadCardData() {
        try (BufferedReader reader = new BufferedReader(new FileReader(CARD_FILE))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    cardData.put(parts[0], parts[1]);
                }
            }
        } catch (IOException e) {
            System.err.println("加载数据失败: " + e.getMessage());
        }
    }
}

