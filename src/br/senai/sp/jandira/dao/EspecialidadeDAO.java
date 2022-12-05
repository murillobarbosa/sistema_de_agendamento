package br.senai.sp.jandira.dao;

import br.senai.sp.jandira.model.Especialidade;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class EspecialidadeDAO {

    private Especialidade especialidade;
    private static ArrayList<Especialidade> especialidades = new ArrayList();
    
    private static final String caminho ="C:\\Users\\22282112\\Documents\\SistemaClinico\\src\\arquivos\\especialidade.txt";
    private static final String caminho_TEMP = "C:\\Users\\22282112\\Documents\\SistemaClinico\\src\\arquivos\\especialidade_Temp.txt";
    private static final Path PATH = Paths.get(caminho) ;
    private static final Path PATH_TEMP = Paths.get(caminho_TEMP);
    public static BufferedWriter bw;
   

    public EspecialidadeDAO(Especialidade especialidade) {
        this.especialidade = especialidade;
    }

    public EspecialidadeDAO() {

    }

    public static void gravar(Especialidade especialidade) {
        try {
            
            bw = Files.newBufferedWriter(PATH,StandardOpenOption.APPEND, StandardOpenOption.WRITE);
            bw.write(especialidade.getEspecialidadeComPontoVirgula());
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(
                    null, 
                    "Ocorreu um erro ao gravar.\n\nEntre em contato com o suporte.", 
                    "ERRO", 
                    JOptionPane.ERROR_MESSAGE);
        }
        
        especialidades.add(especialidade);
    }

    public static boolean excluir(Integer codigo) {
        for (Especialidade e : especialidades) {
            if (e.getCodigo().equals(codigo)) {
                especialidades.remove(e);
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

            for (Especialidade e : especialidades) {
                bwTemp.write(e.getEspecialidadeComPontoVirgula());
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

    public static void atualizar(Especialidade especialidade) {
        for (Especialidade e : especialidades) {
            if (e.getCodigo().equals(especialidade.getCodigo())) {
                especialidades.set(especialidades.indexOf(e), especialidade);
                break;
            }

        }
        atualizarArquivo();
        
    }
    

    public static Especialidade getEspecialidade(Integer codigo) {
        for (Especialidade e : especialidades) {
            if (e.getCodigo().equals(codigo)) {
                return e;
            }
        }
        return null;
    }
    
    public static ArrayList<Especialidade> listarTodos(){
        return especialidades;
    }

    
    public static void criarEspecialidadesTeste(){
        try {     
            BufferedReader br = Files.newBufferedReader(PATH);
            String linha = "";
            linha = br.readLine();
            while(linha != null){
                String[] linhavetor = linha.split(";");
                Especialidade e = new Especialidade(Integer.valueOf(linhavetor[0]),linhavetor[1], linhavetor[2]);
                especialidades.add(e);
                linha = br.readLine();  
            }
            br.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "DEU MERDA!!!");
        }
       
    }
    
    public static void getListaEspecialidades() {

        try {
            // Abrir o arquivo para leitura - LEITOR
            BufferedReader br = Files.newBufferedReader(PATH);

            String linha = br.readLine();

            while (linha != null && !linha.isEmpty()) {
                String[] linhaVetor = linha.split(";");
                Especialidade novaEspecialidade = new Especialidade(
                        Integer.valueOf(linhaVetor[0]),
                        linhaVetor[1],
                        linhaVetor[2]);

                especialidades.add(novaEspecialidade);
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
        Object[][] dados = new Object[especialidades.size()][3];

        // For Each, para extrair cada objeto plano de saúde
        // arrayList planos e separar cada dado na matriz dados
        int i = 0;
        for (Especialidade e : especialidades) {
            dados[i][0] = e.getCodigo();
            dados[i][1] = e.getNome();
            dados[i][2] = e.getDescricao();
            i++;
        }
        // Definir o vetor com os nomes das tabelas
        String[] titulos = {"Código", "Nome da especialidade", "Descrição"};

        // Criar o modelo que será utilizado pelo JTabel
        // para exibir os dados dos planos
        DefaultTableModel tableModel = new DefaultTableModel(dados, titulos);
        return tableModel;

    }
 
        public static ArrayList<String> getListaDosNomes() {
        ArrayList<String> dadosGerais =  new  ArrayList<>();
     
        for(Especialidade e : especialidades){
        dadosGerais.add(e.getNome());
        }
        
        DefaultListModel<String> ListaModel = new DefaultListModel<>();
        ListaModel.addAll(dadosGerais);
    
        return dadosGerais;
    
    }
        
}
