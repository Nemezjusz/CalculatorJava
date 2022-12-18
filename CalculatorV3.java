import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class CalculatorV3 {

    public static int obliczanie(String operator,int pierwszy_argument,int drugi_argument){
        switch (operator) {
            case "+":
                pierwszy_argument += drugi_argument;
                break;
            case "-":
                pierwszy_argument -= drugi_argument;
                break;
            case "/":
                pierwszy_argument /= drugi_argument;
                break;
            case "*":
                pierwszy_argument *= drugi_argument;
                break;
        }

        return pierwszy_argument;
    }
    public static String polacz_w_liczbe(List<String> lista){
        String liczba = "";
        for (int j = 0; j<lista.size();j++){
            liczba += lista.get(j);}
        return liczba;
    }
    public static void createAndShowGUI() {
        JFrame jf = new JFrame("Calculator");
        jf.setLocationRelativeTo(null);
        jf.setPreferredSize(new Dimension(320, 200));
        jf.setResizable(false);
        jf.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        JTextField jb = new JTextField("");
        jb.setFont(new Font("Arial", Font.BOLD,13));
        jb.setHorizontalAlignment(SwingConstants.RIGHT);
        jb.setEnabled(false);
        jb.setText("0");
        jf.getContentPane().add(jb, gbc);

        gbc.gridwidth = 1;

        String cyfry_i_znaki[] = new String[]
                {"1", "2", "3", "+", "4", "5", "6", "-", "7", "8", "9", "*", "0", "=", "C", "/"};


        final boolean[] ktory_arg = {true};
        final String[] przedostani_wpis = {new String("0")};
        final String[] operator = {new String()};

        final List<String> pierwszy_argument_str = new ArrayList<>();
        final List<String> drugi_argument_str = new ArrayList<>();
        final Integer[] argumenty = {0,0,0};

        pierwszy_argument_str.add("0");
        drugi_argument_str.add("0");

        ActionListener myActionListener = new ActionListener() {

            public void actionPerformed(ActionEvent e) {

                String ostatni_wpis = e.getActionCommand();

                String rowna_sie = "=";
                String operatory = "+-/*";
                String cyfra = "0123456789";
                String Clear = "C";

                try {
                    //a
                    if (operatory.contains(przedostani_wpis[0]) && operatory.contains(ostatni_wpis)) {
                        operator[0] = ostatni_wpis;
                    }
                    //b
                    else if (operatory.contains(przedostani_wpis[0]) && cyfra.contains(ostatni_wpis)) {
                        drugi_argument_str.add(ostatni_wpis);
                        String liczba2 = polacz_w_liczbe(drugi_argument_str);
                        argumenty[1] = Integer.valueOf(liczba2);
                        jb.setText(String.valueOf(argumenty[1]));
                    }
                    //c
                    else if (operatory.contains(przedostani_wpis[0]) && rowna_sie.contains(ostatni_wpis)) {
                        argumenty[2] = obliczanie(operator[0], argumenty[0], argumenty[0]);
                        argumenty[1] = argumenty[0];
                        argumenty[0] = argumenty[2];
                        jb.setText(String.valueOf(argumenty[2]));
                    }
                    //d
                    else if (Clear.contains(ostatni_wpis)) {
                        pierwszy_argument_str.clear();
                        pierwszy_argument_str.add("0");
                        argumenty[0] = 0;
                        drugi_argument_str.clear();
                        drugi_argument_str.add("0");
                        argumenty[1] = 0;
                        operator[0] = "";
                        ktory_arg[0] = true;
                        argumenty[2] = 0;
                        ostatni_wpis = "0";
                        jb.setText("0");

                    }
                    //e
                    else if (cyfra.contains(przedostani_wpis[0]) && operatory.contains(ostatni_wpis)) {

                        argumenty[0] = obliczanie(operator[0], argumenty[0], argumenty[1]);
                        operator[0] = ostatni_wpis;
                        argumenty[1] = 0;
                        argumenty[2] = argumenty[0];

                        jb.setText(String.valueOf(argumenty[0]));

                        pierwszy_argument_str.clear();
                        drugi_argument_str.clear();

                        ktory_arg[0] = false;

                    }
                    //f
                    else if (cyfra.contains(przedostani_wpis[0]) && cyfra.contains(ostatni_wpis)) {
                        if (ktory_arg[0]) {
                            pierwszy_argument_str.add(ostatni_wpis);
                            String liczba = polacz_w_liczbe(pierwszy_argument_str);
                            argumenty[0] = Integer.valueOf(liczba);
                            jb.setText(String.valueOf(argumenty[0]));
                        } else {
                            drugi_argument_str.add(ostatni_wpis);
                            String liczba2 = polacz_w_liczbe(drugi_argument_str);
                            argumenty[1] = Integer.valueOf(liczba2);
                            jb.setText(String.valueOf(argumenty[1]));
                        }
                    }
                    //g
                    else if (cyfra.contains(przedostani_wpis[0]) && rowna_sie.contains(ostatni_wpis)) {
                        if (operatory.contains(operator[0])) {
                            argumenty[2] = obliczanie(operator[0], argumenty[0], argumenty[1]);
                        }
                        drugi_argument_str.clear();
                        jb.setText(String.valueOf(argumenty[2]));
                    }
                    //h
                    else if (rowna_sie.contains(przedostani_wpis[0]) && operatory.contains(ostatni_wpis)) {
                        argumenty[0] = argumenty[2];
                        operator[0] = ostatni_wpis;
                    }
                    //i
                    else if (rowna_sie.contains(przedostani_wpis[0]) && cyfra.contains(ostatni_wpis)) {
                        pierwszy_argument_str.clear();
                        pierwszy_argument_str.add(ostatni_wpis);
                        String liczba = polacz_w_liczbe(pierwszy_argument_str);
                        argumenty[0] = Integer.valueOf(liczba);
                        jb.setText(liczba);
                        drugi_argument_str.clear();
                        argumenty[1] = 0;
                        drugi_argument_str.add("0");

                        ktory_arg[0] = true;
                        operator[0] = "";
                        argumenty[2] = 0;
                    }
                    //j
                    else if (rowna_sie.contains(przedostani_wpis[0]) && rowna_sie.contains(ostatni_wpis)) {
                        argumenty[2] = obliczanie(operator[0], argumenty[2], argumenty[1]);
                        argumenty[0] = argumenty[2];
                        jb.setText(String.valueOf(argumenty[2]));
                    }

                    przedostani_wpis[0] = ostatni_wpis;
                }
                catch (ArithmeticException e1){
                    jb.setText("ERROR: Dzielenie przez 0");
                    pierwszy_argument_str.clear();
                    pierwszy_argument_str.add("0");
                    argumenty[0] = 0;
                    drugi_argument_str.clear();
                    drugi_argument_str.add("0");
                    argumenty[1] = 0;
                    operator[0] = "";
                    ktory_arg[0] = true;
                    argumenty[2] = 0;
                    ostatni_wpis = "0";
                }
            }
        };

        int a = 0;
        for (int i=1; i<5;i++){
            for (int j=0; j<4;j++){
                gbc.gridy = i;
                gbc.gridx = j;
                JButton jbu = new JButton(cyfry_i_znaki[a]);
                jbu.addActionListener(myActionListener);
                jf.getContentPane().add(jbu, gbc);
                a++;
            }
        }

        jf.pack();
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() { createAndShowGUI(); }
        });
    }

}