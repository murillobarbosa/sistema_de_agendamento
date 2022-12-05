package br.senai.sp.jandira.dao;

import java.util.ArrayList;
import br.senai.sp.jandira.model.PlanosDeSaude;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class PlanoDeSaudeDAO {

    private PlanosDeSaude planoDeSaude;
    private static ArrayList<PlanosDeSaude> planos = new ArrayList<>();

    private static final String caminho = "C:\\Users\\22282112\\Documents\\SistemaClinico\\src\\arquivos\\plano_de_saude.txt";
    private static final String caminho_TEMP = "C:\\Users\\22282112\\Documents\\SistemaClinico\\src\\arquivos\\plano_de_saude_Temp.txt";
    private static final Path PATH = Paths.get(caminho);
    private static final Path PATH_TEMP = Paths.get(caminho_TEMP);
    public static BufferedWriter bw;

    public PlanoDeSaudeDAO(PlanosDeSaude planoDeSaude) {
        this.planoDeSaude = planoDeSaude;
    }

    public PlanoDeSaudeDAO() {

    }

    public static void gravar(PlanosDeSaude planoDeSaude) {
        try {

            bw = Files.newBufferedWriter(PATH, StandardOpenOption.APPEND, StandardOpenOption.WRITE);
            bw.write(planoDeSaude.getPlanoDeSaudeComPontoVirgula());
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(
                    null,
                    "Ocorreu um erro ao gravar.\n\nEntre em contato com o suporte.",
                    "ERRO",
                    JOptionPane.ERROR_MESSAGE);
        }

        planos.add(planoDeSaude);
    }

    public static boolean excluir(Integer codigo) {
        for (PlanosDeSaude ps : planos) {
            if (ps.getCodigo().equals(codigo)) {
                planos.remove(ps);
                break;
            }
        }
        atualizarArquivo();

        return false;
    }

    private static void atualizarArquivo() {
        // Reconstruir um arquivo atualizado, ou seja,
        // sem o plano que foi removido

        // PASSO 01 - Criar uma representação dos arquivos que serão manipulados
        File arquivoAtual = new File(caminho);
        File arquivoTemp = new File(caminho_TEMP);

        try {
            //boolean criou = arquivoTemp.createNewFile();
            arquivoTemp.createNewFile();

            BufferedWriter bwTemp = Files.newBufferedWriter(
                    PATH_TEMP,
                    StandardOpenOption.APPEND,
                    StandardOpenOption.WRITE);

            for (PlanosDeSaude p : planos) {
                bwTemp.write(p.getPlanoDeSaudeComPontoVirgula());
                bwTemp.newLine();
            }
            // Fechar o arquivo temporário
            bwTemp.close();

            // Excluir o arquivo atual - plano_de_saude.txt
            arquivoAtual.delete();

            // Renomear o arquivo temporário
            arquivoTemp.renameTo(arquivoAtual);

        } catch (IOException ex) {
            JOptionPane.showConfirmDialog(
                    null,
                    "Ocorreu um erro ao criar o arquivo",
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
        }
     }

    public static PlanosDeSaude getPlanoDeSaude(Integer codigo) {

        for (PlanosDeSaude ps : planos) {
            if (ps.getCodigo().equals(codigo)) {
                return ps;
            }
        }

        return null;
    }

    public static void atualizar(PlanosDeSaude planoDeSaude) {
        for (PlanosDeSaude ps : planos) {
            if (ps.getCodigo().equals(planoDeSaude.getCodigo())) {
                planos.set(planos.indexOf(ps), planoDeSaude);
                break;
            }
        }
        atualizarArquivo();
    }

    public static ArrayList<PlanosDeSaude> listarTodos() {
        return planos;
    }

    public static void criarPlanosTeste() {
        try {
            BufferedReader br = Files.newBufferedReader(PATH);
            String linha = "";
            linha = br.readLine();
            while (linha != null) {
                String[] linhavetor = linha.split(";");
                PlanosDeSaude e = new PlanosDeSaude(Integer.valueOf(linhavetor[0]), linhavetor[1], linhavetor[2]);
                planos.add(e);
                linha = br.readLine();
            }
            br.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "DEU MERDA!!!");
        }

    }

    public static void getListaPlanosDeSaude() {

        try {
            // Abrir o arquivo para leitura - LEITOR
            BufferedReader br = Files.newBufferedReader(PATH);

            String linha = br.readLine();

            while (linha != null && !linha.isEmpty()) {
                String[] linhaVetor = linha.split(";");
                PlanosDeSaude novoPlanoDeSaude = new PlanosDeSaude(
                        Integer.valueOf(linhaVetor[0]),
                        linhaVetor[1],
                        linhaVetor[2]);

                planos.add(novoPlanoDeSaude);
                linha = br.readLine();
            }

            br.close();

        } catch (IOException ex) {
            JOptionPane.showConfirmDialog(null, "Ocorreu um erro ao abrir o arquivo");
        }
    }

    public static DefaultTableModel getTableModel() {
        // Matriz receberá os planos de saúde
        //que serão usados na tabela (JTable)
        Object[][] dados = new Object[planos.size()][3];

        // For Each, para extrair cada objeto plano de saúde
        // arrayList planos e separar cada dado na matriz dados
        int i = 0;
        for (PlanosDeSaude p : planos) {
            dados[i][0] = p.getCodigo();
            dados[i][1] = p.getOperadora();
            dados[i][2] = p.getTipoDoPlano();
            i++;
        }
        // Definir o vetor com os nomes das tabelas
        String[] titulos = {"Código", "Nome da operadora", "Tipo do plano"};

        // Criar o modelo que será utilizado pelo JTabel
        // para exibir os dados dos planos
        DefaultTableModel tableModel = new DefaultTableModel(dados, titulos);
        return tableModel;

    }

}
