package br.senai.sp.jandira.ui;

import br.senai.sp.jandira.dao.EspecialidadeDAO;
import br.senai.sp.jandira.dao.MedicoDAO;
import br.senai.sp.jandira.model.Especialidade;
import br.senai.sp.jandira.model.Medico;
import br.senai.sp.jandira.model.TipoOperacao;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;

public class DialogMedico extends javax.swing.JDialog {

    private TipoOperacao tipoOperacao;
    private Medico medico;
    
    private DefaultListModel<String> listaTodosModel = new DefaultListModel<>();
    private ArrayList<String> especialidades = new ArrayList<>();
    private ArrayList<Especialidade> EspecialidadesNaoSelecionados = EspecialidadeDAO.listarTodos();
    
    private DefaultListModel<String> listaDasEspecialidadesMedico = new DefaultListModel<>();
    private ArrayList<String> selecionados = new ArrayList<>();
    private ArrayList<Especialidade> selecionadosModel = new ArrayList<>();
    
    
     
    public DialogMedico(
            java.awt.Frame parent, 
            boolean modal,
            TipoOperacao tipoOperacao,
            Medico medico
            
    ) {
        super(parent, modal);
        initComponents();
        this.tipoOperacao = tipoOperacao;
        this.medico = medico;
        atualizarListasEspecialidades();
        // Preencher os campos, caso o tipo de operação for ALTERAR
        if (tipoOperacao == tipoOperacao.ALTERAR) {
            preencherFormulario();
            atualizarListasEspecialidades();
        }

    }
    
    private void preencherFormulario() {
        tituloLabelMedico.setText("Médico(a) - " + tipoOperacao);
        labelIconMedico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/senai/sp/jandira/img/Editar.png")));
        textFieldCodigoMedico.setText(medico.getCodigo().toString());
        textFieldCRM.setText(medico.getCrm());
        textFieldNomeDoMedico.setText(medico.getNome());
        textFieldTelefoneMedico.setText(medico.getTelefone());
        textFieldEmailMedico.setText(medico.getEmail());
        formattedtextFieldDataNascimento.setText(medico.getDataNascimentoComBarra());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        tituloLabelMedico = new javax.swing.JLabel();
        labelIconMedico = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabelCodigoMedico = new javax.swing.JLabel();
        jLabelCRM = new javax.swing.JLabel();
        jLabelNomeDoMedico = new javax.swing.JLabel();
        jLabelTelefone = new javax.swing.JLabel();
        jLabelEmail = new javax.swing.JLabel();
        jLabelDataNascimento = new javax.swing.JLabel();
        jLabelListaDeEspecialidades = new javax.swing.JLabel();
        jLabelEspecialidadesDoMedico = new javax.swing.JLabel();
        textFieldCodigoMedico = new javax.swing.JTextField();
        textFieldCRM = new javax.swing.JTextField();
        textFieldNomeDoMedico = new javax.swing.JTextField();
        textFieldTelefoneMedico = new javax.swing.JTextField();
        textFieldEmailMedico = new javax.swing.JTextField();
        formattedtextFieldDataNascimento = new javax.swing.JFormattedTextField();
        buttonAdicionarEspecialidadeAoMedico = new javax.swing.JButton();
        buttonRemoverEspecialidadeDoMedico = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jListEspecialidadesDoMedico = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jListTodasAsEspecialidades = new javax.swing.JList<>();
        buttonCancelarMedico = new javax.swing.JButton();
        buttonSalvarMedico = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(155, 155, 155));
        jPanel1.setLayout(null);

        tituloLabelMedico.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        tituloLabelMedico.setText("Médico - ADICIONAR");
        jPanel1.add(tituloLabelMedico);
        tituloLabelMedico.setBounds(100, 30, 660, 30);

        labelIconMedico.setBackground(new java.awt.Color(0, 0, 0));
        labelIconMedico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/senai/sp/jandira/img/adicionar-ficheiro.png"))); // NOI18N
        jPanel1.add(labelIconMedico);
        labelIconMedico.setBounds(60, 20, 40, 40);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 880, 90);

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Detalhes do(a) Médico(a):", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI Light", 1, 18), new java.awt.Color(155, 155, 155))); // NOI18N
        jPanel2.setLayout(null);

        jLabelCodigoMedico.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelCodigoMedico.setText("Código:");
        jPanel2.add(jLabelCodigoMedico);
        jLabelCodigoMedico.setBounds(20, 40, 70, 20);

        jLabelCRM.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelCRM.setText("CRM:");
        jPanel2.add(jLabelCRM);
        jLabelCRM.setBounds(110, 40, 120, 20);

        jLabelNomeDoMedico.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelNomeDoMedico.setText("Nome do(a) Médico(a):");
        jPanel2.add(jLabelNomeDoMedico);
        jLabelNomeDoMedico.setBounds(240, 40, 190, 20);

        jLabelTelefone.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelTelefone.setText("Telefone:");
        jPanel2.add(jLabelTelefone);
        jLabelTelefone.setBounds(20, 100, 80, 20);

        jLabelEmail.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelEmail.setText("E-mail:");
        jPanel2.add(jLabelEmail);
        jLabelEmail.setBounds(240, 100, 70, 20);

        jLabelDataNascimento.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabelDataNascimento.setText("Data Nascimento:");
        jPanel2.add(jLabelDataNascimento);
        jLabelDataNascimento.setBounds(600, 100, 150, 20);

        jLabelListaDeEspecialidades.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabelListaDeEspecialidades.setText("Lista De Especialidades:");
        jPanel2.add(jLabelListaDeEspecialidades);
        jLabelListaDeEspecialidades.setBounds(20, 190, 220, 20);

        jLabelEspecialidadesDoMedico.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        jLabelEspecialidadesDoMedico.setText("Especialidades do Médico:");
        jPanel2.add(jLabelEspecialidadesDoMedico);
        jLabelEspecialidadesDoMedico.setBounds(340, 190, 220, 20);

        textFieldCodigoMedico.setEditable(false);
        jPanel2.add(textFieldCodigoMedico);
        textFieldCodigoMedico.setBounds(20, 70, 80, 20);
        jPanel2.add(textFieldCRM);
        textFieldCRM.setBounds(110, 70, 120, 20);
        jPanel2.add(textFieldNomeDoMedico);
        textFieldNomeDoMedico.setBounds(240, 70, 580, 20);
        jPanel2.add(textFieldTelefoneMedico);
        textFieldTelefoneMedico.setBounds(20, 120, 210, 20);
        jPanel2.add(textFieldEmailMedico);
        textFieldEmailMedico.setBounds(240, 120, 350, 20);

        try {
            formattedtextFieldDataNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        formattedtextFieldDataNascimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                formattedtextFieldDataNascimentoActionPerformed(evt);
            }
        });
        jPanel2.add(formattedtextFieldDataNascimento);
        formattedtextFieldDataNascimento.setBounds(600, 120, 220, 20);

        buttonAdicionarEspecialidadeAoMedico.setBackground(new java.awt.Color(102, 255, 0));
        buttonAdicionarEspecialidadeAoMedico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/senai/sp/jandira/img/seta-para-cima.png"))); // NOI18N
        buttonAdicionarEspecialidadeAoMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAdicionarEspecialidadeAoMedicoActionPerformed(evt);
            }
        });
        jPanel2.add(buttonAdicionarEspecialidadeAoMedico);
        buttonAdicionarEspecialidadeAoMedico.setBounds(240, 240, 60, 50);

        buttonRemoverEspecialidadeDoMedico.setBackground(new java.awt.Color(255, 0, 0));
        buttonRemoverEspecialidadeDoMedico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/senai/sp/jandira/img/seta (2).png"))); // NOI18N
        buttonRemoverEspecialidadeDoMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRemoverEspecialidadeDoMedicoActionPerformed(evt);
            }
        });
        jPanel2.add(buttonRemoverEspecialidadeDoMedico);
        buttonRemoverEspecialidadeDoMedico.setBounds(240, 300, 60, 50);

        jScrollPane1.setViewportView(jListEspecialidadesDoMedico);

        jPanel2.add(jScrollPane1);
        jScrollPane1.setBounds(340, 220, 180, 200);

        jScrollPane2.setViewportView(jListTodasAsEspecialidades);

        jPanel2.add(jScrollPane2);
        jScrollPane2.setBounds(20, 220, 180, 200);

        buttonCancelarMedico.setBackground(new java.awt.Color(248, 248, 248));
        buttonCancelarMedico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/senai/sp/jandira/img/cancelar_1.png"))); // NOI18N
        buttonCancelarMedico.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonCancelarMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarMedicoActionPerformed(evt);
            }
        });
        jPanel2.add(buttonCancelarMedico);
        buttonCancelarMedico.setBounds(710, 350, 90, 60);

        buttonSalvarMedico.setBackground(new java.awt.Color(248, 248, 248));
        buttonSalvarMedico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/senai/sp/jandira/img/salve-.png"))); // NOI18N
        buttonSalvarMedico.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonSalvarMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSalvarMedicoActionPerformed(evt);
            }
        });
        jPanel2.add(buttonSalvarMedico);
        buttonSalvarMedico.setBounds(710, 280, 90, 60);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(20, 110, 830, 440);

        setBounds(0, 0, 889, 598);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonAdicionarEspecialidadeAoMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAdicionarEspecialidadeAoMedicoActionPerformed
        List<String> especialidadesMedico = jListTodasAsEspecialidades.getSelectedValuesList();

        for (String e : especialidadesMedico){
            selecionados.add(e);
        }

        for(Especialidade e : EspecialidadesNaoSelecionados){
            if(especialidadesMedico.contains(e.getNome())){
                selecionadosModel.add(e);
                System.out.println(selecionadosModel.get(0).getNome());
            }
        }
        
        

        listaDasEspecialidadesMedico.clear();
        listaDasEspecialidadesMedico.addAll(selecionados);
        jListEspecialidadesDoMedico.setModel(listaDasEspecialidadesMedico);

        List<String> excluir = jListTodasAsEspecialidades.getSelectedValuesList();
        
        
        for(String e : excluir){
            listaTodosModel.removeElement(e);
            especialidades.remove(e);
        }

    }//GEN-LAST:event_buttonAdicionarEspecialidadeAoMedicoActionPerformed

    private void buttonRemoverEspecialidadeDoMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRemoverEspecialidadeDoMedicoActionPerformed
        List<String> removerEspecialidadesDoMedico = jListEspecialidadesDoMedico.getSelectedValuesList();

        for(String e : removerEspecialidadesDoMedico){
            especialidades.add(e);
        }
        for(Especialidade e : EspecialidadesNaoSelecionados){
            if(removerEspecialidadesDoMedico.contains(e.getNome())){
                selecionadosModel.remove(e);
            }
        }

        listaTodosModel.clear();
        listaTodosModel.addAll(especialidades);
        jListTodasAsEspecialidades.setModel(listaTodosModel);

        List<String> excluir = jListEspecialidadesDoMedico.getSelectedValuesList();
        
        for(String e : excluir){
            listaDasEspecialidadesMedico.removeElement(e);
            selecionados.remove(e);
        }
    }//GEN-LAST:event_buttonRemoverEspecialidadeDoMedicoActionPerformed

    private void buttonSalvarMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSalvarMedicoActionPerformed

        if (tipoOperacao == tipoOperacao.ADICIONAR) {
            gravar();
        } else {
            atualizar();
        }

    }//GEN-LAST:event_buttonSalvarMedicoActionPerformed

    private void buttonCancelarMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarMedicoActionPerformed

        dispose();

    }//GEN-LAST:event_buttonCancelarMedicoActionPerformed

    private void formattedtextFieldDataNascimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_formattedtextFieldDataNascimentoActionPerformed
        
//        if (formattedtextFieldDataNascimento !== ) {
//            JOptionPane.showMessageDialog(
//                    this,
//                    "Por favor preencha a data de nascimeto com números!",
//                    "DataDeNascimento",
//                    JOptionPane.ERROR_MESSAGE);
//            formattedtextFieldDataNascimento.requestFocus();
//            
//        }
    }//GEN-LAST:event_formattedtextFieldDataNascimentoActionPerformed

    private void gravar() {
        // Criar um objeto plano de saúde
        Medico medico = new Medico();
        medico.setCrm(textFieldCRM.getText());
        medico.setNome(textFieldNomeDoMedico.getText());
        medico.setTelefone(textFieldTelefoneMedico.getText());
        medico.setEmail(textFieldEmailMedico.getText());
        medico.setDataNascimento(dataCorreta());
        medico.setEspecialidades(selecionadosModel);
    
        if (validarCadastro()) {
            MedicoDAO.gravar(medico);
            JOptionPane.showMessageDialog(
                    this,
                    "Médico(a) gravado com sucesso!",
                    "Médico(a)",
                    JOptionPane.INFORMATION_MESSAGE);
            dispose();
        }
    }
    
    private void atualizar(){
        if(validarCadastro()){
        medico.setCrm(textFieldCRM.getText());
        medico.setNome(textFieldNomeDoMedico.getText());
        medico.setTelefone(textFieldTelefoneMedico.getText());
        medico.setEmail(textFieldEmailMedico.getText());
        medico.setDataNascimento(dataCorreta());
        medico.setEspecialidades(selecionadosModel);
        
        MedicoDAO.atualizar(medico);
        JOptionPane.showMessageDialog(
                    this,
                    "Médico atualizado com sucesso!",
                    "Médico(a)",
                    JOptionPane.INFORMATION_MESSAGE);
        dispose();
        }
    }

    private boolean validarCadastro() {
        if (textFieldCRM.getText().isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Por favor preencha o crm do(a) médico(a)!",
                    "Médico(a)",
                    JOptionPane.ERROR_MESSAGE);
            textFieldCRM.requestFocus();
            return false;
        }
        if (textFieldNomeDoMedico.getText().isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Por favor preencha o nome do(a) médico(a)!",
                    "Médico(a)",
                    JOptionPane.ERROR_MESSAGE);
            textFieldNomeDoMedico.requestFocus();
            return false;
        }
        if (textFieldTelefoneMedico.getText().isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Por favor preencha o Telefone do(a) médico(a)!",
                    "Médico(a)",
                    JOptionPane.ERROR_MESSAGE);
            textFieldTelefoneMedico.requestFocus();
            return false;
        }
        if (textFieldEmailMedico.getText().isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Por favor preencha o E-mail do(a) médico(a)!",
                    "Médico(a)",
                    JOptionPane.ERROR_MESSAGE);
            textFieldEmailMedico.requestFocus();
            return false;
        }
        if (formattedtextFieldDataNascimento.getText().isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "Por favor preencha a data de nascimeto!",
                    "Medico(a)",
                    JOptionPane.ERROR_MESSAGE);
            formattedtextFieldDataNascimento.requestFocus();
            return false;
        }
        if (null == dataCorreta()) {
            JOptionPane.showMessageDialog(
                    this,
                    "A Data de Nascimento está invalida, Por favor preencha uma data Válida",
                    "Medico(a)",
                    JOptionPane.ERROR_MESSAGE);
            formattedtextFieldDataNascimento.requestFocus();
            return false;
        }
        return true;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAdicionarEspecialidadeAoMedico;
    private javax.swing.JButton buttonCancelarMedico;
    private javax.swing.JButton buttonRemoverEspecialidadeDoMedico;
    private javax.swing.JButton buttonSalvarMedico;
    private javax.swing.JFormattedTextField formattedtextFieldDataNascimento;
    private javax.swing.JLabel jLabelCRM;
    private javax.swing.JLabel jLabelCodigoMedico;
    private javax.swing.JLabel jLabelDataNascimento;
    private javax.swing.JLabel jLabelEmail;
    private javax.swing.JLabel jLabelEspecialidadesDoMedico;
    private javax.swing.JLabel jLabelListaDeEspecialidades;
    private javax.swing.JLabel jLabelNomeDoMedico;
    private javax.swing.JLabel jLabelTelefone;
    private javax.swing.JList<String> jListEspecialidadesDoMedico;
    private javax.swing.JList<String> jListTodasAsEspecialidades;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelIconMedico;
    private javax.swing.JTextField textFieldCRM;
    private javax.swing.JTextField textFieldCodigoMedico;
    private javax.swing.JTextField textFieldEmailMedico;
    private javax.swing.JTextField textFieldNomeDoMedico;
    private javax.swing.JTextField textFieldTelefoneMedico;
    private javax.swing.JLabel tituloLabelMedico;
    // End of variables declaration//GEN-END:variables


    private LocalDate dataCorreta() {
        String[] data = formattedtextFieldDataNascimento.getText().split("/");
    if(validarData()){
        return LocalDate.of(Integer.parseInt(data[2]), Integer.parseInt(data[1]), Integer.parseInt(data[0]));
    } return null;
        
}
    private boolean validarData(){
        String dateFormat = "dd/MM/uuuu";
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(dateFormat).withResolverStyle(ResolverStyle.SMART);
        
        try{
            LocalDate date = LocalDate.parse(formattedtextFieldDataNascimento.getText(), dateTimeFormatter);
            return true;
        }catch (DateTimeParseException e){
            return false;
        }
    }
    
    private void atualizarListasEspecialidades(){
        especialidades = EspecialidadeDAO.getListaDosNomes();
        listaTodosModel.addAll(especialidades);
        jListTodasAsEspecialidades.setModel(listaTodosModel);
        if(tipoOperacao == TipoOperacao.ADICIONAR){
            
        }else{
            selecionadosModel = medico.getEspecialidades();
            selecionados = medico.getListaDeEspecialidadesDoMedico();
            listaDasEspecialidadesMedico.clear();
            listaDasEspecialidadesMedico.addAll(selecionados);         
            jListEspecialidadesDoMedico.setModel(listaDasEspecialidadesMedico);

        int i = 0;
        for(String e : selecionados){
            if(especialidades.contains(e)){
                especialidades.remove(e);
            }
        }
        listaTodosModel.clear();
        listaTodosModel.addAll(especialidades);
            
            
        }

    }

}
