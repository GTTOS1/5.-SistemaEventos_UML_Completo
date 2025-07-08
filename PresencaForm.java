import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class PresencaForm extends JFrame {
    private JTextField nomeField, dataField, horarioField;
    private JCheckBox presenteBox;
    private static final String FILE_NAME = "presencas.dat";

    public PresencaForm() {
        setTitle("Registro de Presença");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 2));

        nomeField = new JTextField();
        //dataField = new JTextField("dd/MM/yyyy");
        //horarioField = new JTextField("HH:mm");
        presenteBox = new JCheckBox("Presente");

        add(new JLabel("Nome:")); add(nomeField);
        //add(new JLabel("Data:")); add(dataField);
        //add(new JLabel("Horário:")); add(horarioField);
        add(new JLabel("Presença:")); add(presenteBox);

        JButton salvarBtn = new JButton("Salvar");
        salvarBtn.addActionListener(e -> salvarPresenca());
        add(salvarBtn);

        JButton listarBtn = new JButton("Listar Presenças");
        listarBtn.addActionListener(e -> listarPresencas());
        add(listarBtn);
    }

    private void salvarPresenca() {
        try {
            String nome = nomeField.getText();
            Date agora = new Date(); // Pega data e horário atual
            boolean presente = presenteBox.isSelected();

            Pessoa pessoa = new Pessoa(nome, "", "", 0, "", "", "Aluno");
            Presenca p = new Presenca(pessoa, presente, agora, agora);

            ArrayList<Presenca> lista = carregarPresencas();
            lista.add(p);

            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
            out.writeObject(lista);
            out.close();

            JOptionPane.showMessageDialog(this, "Presença registrada com data e hora atual.");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao registrar presença: " + e.getMessage());
        }
    }


    private ArrayList<Presenca> carregarPresencas() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME));
            return (ArrayList<Presenca>) in.readObject();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }

    private void listarPresencas() {
        ArrayList<Presenca> lista = carregarPresencas();
        StringBuilder sb = new StringBuilder();
        for (Presenca p : lista) {
            sb.append(p.toString()).append("\n");
        }


        JOptionPane.showMessageDialog(this, sb.toString());
    }
}