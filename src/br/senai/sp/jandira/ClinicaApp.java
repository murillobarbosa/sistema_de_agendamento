package br.senai.sp.jandira;

import br.senai.sp.jandira.ui.MainFrame;
import java.awt.Image;
import java.awt.Toolkit;

public class ClinicaApp {

    public static void main(String[] args) {

        MainFrame main = new MainFrame();
        main.setResizable(false);
        main.setVisible(true);
        Image icon = Toolkit.getDefaultToolkit().getImage("C:\\Users\\22282091\\SENAI\\DS1M-A\\Fundamentos-de-Programacao\\EclipseEOutros\\eclipse-workspace\\Sistema-Clinico\\SistemaAgendamento\\src\\br\\senai\\sp\\jandira\\img\\Agendar.png");    
        main.setIconImage(icon); 
    }


}
