package br.senai.sp.jandira.ui;

import br.senai.sp.jandira.ui.DialogMedico;
import br.senai.sp.jandira.dao.MedicoDAO;
import br.senai.sp.jandira.model.TipoOperacao;
import br.senai.sp.jandira.model.Medico;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class PanelMedico extends javax.swing.JPanel {

    int linha;
    
    public PanelMedico() {
        initComponents();
        criarTabelaMedico();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollMedico = new javax.swing.JScrollPane();
        tableMedico = new javax.swing.JTable();
        buttonExcluirMedico = new javax.swing.JButton();
        buttonEditarMedico = new javax.swing.JButton();
        buttonAdicionarMedico = new javax.swing.JButton();

        setBackground(new java.awt.Color(248, 248, 248));
        setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Médicos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Monospaced", 1, 18))); // NOI18N
        setLayout(null);

        tableMedico.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        tableMedico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableMedico.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_LAST_COLUMN);
        scrollMedico.setViewportView(tableMedico);

        add(scrollMedico);
        scrollMedico.setBounds(10, 30, 870, 290);

        buttonExcluirMedico.setBackground(new java.awt.Color(248, 248, 248));
        buttonExcluirMedico.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        buttonExcluirMedico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/senai/sp/jandira/img/excluir (2).png"))); // NOI18N
        buttonExcluirMedico.setToolTipText("deletar plano de saúde selecionado");
        buttonExcluirMedico.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonExcluirMedico.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        buttonExcluirMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonExcluirMedicoActionPerformed(evt);
            }
        });
        add(buttonExcluirMedico);
        buttonExcluirMedico.setBounds(660, 330, 60, 40);

        buttonEditarMedico.setBackground(new java.awt.Color(248, 248, 248));
        buttonEditarMedico.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        buttonEditarMedico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/senai/sp/jandira/img/editar-arquivo.png"))); // NOI18N
        buttonEditarMedico.setToolTipText("editar plano de saúde selecionado ");
        buttonEditarMedico.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonEditarMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditarMedicoActionPerformed(evt);
            }
        });
        add(buttonEditarMedico);
        buttonEditarMedico.setBounds(730, 330, 60, 40);

        buttonAdicionarMedico.setBackground(new java.awt.Color(248, 248, 248));
        buttonAdicionarMedico.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        buttonAdicionarMedico.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/senai/sp/jandira/img/adicionar-ficheiro.png"))); // NOI18N
        buttonAdicionarMedico.setToolTipText("adicionar plano de saúde");
        buttonAdicionarMedico.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        buttonAdicionarMedico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAdicionarMedicoActionPerformed(evt);
            }
        });
        add(buttonAdicionarMedico);
        buttonAdicionarMedico.setBounds(800, 330, 60, 40);
    }// </editor-fold>//GEN-END:initComponents

    private void buttonExcluirMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonExcluirMedicoActionPerformed

        //obtemos o índice da linha selecionada na tabela
        linha = tableMedico.getSelectedRow();

        //verificamos se a linha é diferente de -1
        //-1 significa que o usuario n selecionou nada
        if (linha != -1) {
            excluir();
        } else {
            JOptionPane.showMessageDialog(
                    this,
                    "Por favor, selecione a especialidade que você deseja excluir!",
                    "Especialidade",
                    JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_buttonExcluirMedicoActionPerformed

    private void buttonEditarMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditarMedicoActionPerformed

         linha = tableMedico.getSelectedRow();
        if (linha != -1) {
            editar();
        } else {
            JOptionPane.showMessageDialog(
                    this,
                    "Por favor, selecione um(a) medico(a) para alterar.",
                    "Especialidade",
                    JOptionPane.WARNING_MESSAGE);
        }

        criarTabelaMedico();
    }//GEN-LAST:event_buttonEditarMedicoActionPerformed

    private void buttonAdicionarMedicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAdicionarMedicoActionPerformed

        DialogMedico dialogMedico = new DialogMedico(null, true, TipoOperacao.ADICIONAR, null);
        dialogMedico.setVisible(true);

        criarTabelaMedico();
    }//GEN-LAST:event_buttonAdicionarMedicoActionPerformed
    
    private void editar() {

        Medico medico = MedicoDAO.getMedico(getCodigo());

        DialogMedico dialogMedico = new DialogMedico(null, true, TipoOperacao.ALTERAR, medico);
        dialogMedico.setVisible(true);
        criarTabelaMedico();
    }

    private void excluir() {

         int resposta = JOptionPane.showConfirmDialog(this,
                "Você confirma a exclusão do(a) medico(a) selecionado?",
                "Medico",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (resposta == 0) {
            MedicoDAO.excluir(getCodigo());
            criarTabelaMedico();
        }

    }

    private Integer getCodigo() {
        String codigoStr = tableMedico.getValueAt(linha, 0).toString();
        return Integer.valueOf(codigoStr);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAdicionarMedico;
    private javax.swing.JButton buttonEditarMedico;
    private javax.swing.JButton buttonExcluirMedico;
    private javax.swing.JScrollPane scrollMedico;
    private javax.swing.JTable tableMedico;
    // End of variables declaration//GEN-END:variables
    
    private void criarTabelaMedico() {
        tableMedico.setModel(MedicoDAO.getTableModel());

        // Desativar
        tableMedico.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        // Definir a largura de cada coluna
        tableMedico.getColumnModel().getColumn(0).setPreferredWidth(100);
        tableMedico.getColumnModel().getColumn(1).setPreferredWidth(400);
        tableMedico.getColumnModel().getColumn(2).setPreferredWidth(367);

        //impedir movimentação da coluna
        tableMedico.getTableHeader().setReorderingAllowed(false);

        //impedir edição das linhas
        tableMedico.setDefaultEditor(Object.class, null);

    }

}
