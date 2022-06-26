package ecp.aula;

import javax.swing.*;
import java.awt.*;

public class Gui extends JFrame {
    private final JTextField textNome;
    private final JTextField textIdade;
    private final JTextField textTelefone;
    private final JTextField textEmail;
    public Gui(String title){
        setTitle(title);
        setLayout(new FlowLayout());

        JPanel panelNome = new JPanel();
        JPanel panelIdade = new JPanel();
        JPanel panelTelefone = new JPanel();
        JPanel panelEmail = new JPanel();
        JPanel panelButton = new JPanel();

        panelNome.add(new Label("Nome:"));
        textNome = new JTextField(15);
        panelNome.add(textNome);
        add(panelNome);

        panelIdade.add(new Label("Idade:"));
        textIdade = new JTextField(15);
        panelIdade.add(textIdade);
        add(panelIdade);

        panelTelefone.add(new Label("Telefone:"));
        textTelefone = new JTextField(15);
        panelTelefone.add(textTelefone);
        add(panelTelefone);

        panelEmail.add(new Label("email:"));
        textEmail = new JTextField(15);
        panelEmail.add(textEmail);
        add(panelEmail);

        JButton buttonCadastrar = new JButton("Cadastrar");
        buttonCadastrar.addActionListener((e)->cadastrar());
        JButton buttonFechar = new JButton("Fechar");

        buttonFechar.addActionListener((e) ->System.exit(0));


        panelButton.add(buttonCadastrar);
        panelButton.add(buttonFechar);
        add(panelButton);
        setSize(400, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    private void cadastrar(){
        System.out.println("Cadastrando");
        Contato c = new Contato(textNome.getText(),
                Integer.parseInt(textIdade.getText()),textTelefone.getText(),textEmail.getText());
        ContatoDAO dao = new ContatoDAO();
        dao.inserir(c);
    }

}
