package br.senai.sp.jandira.dao;

import br.senai.sp.jandira.model.Especialidade;
import br.senai.sp.jandira.model.Medico;
import br.senai.sp.jandira.dao.EspecialidadeDAO;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MedicoDAO {
    
    private Medico medico;
    private static ArrayList<Medico> medicos = new ArrayList();
    

    private static final String caminho ="C:\\Users\\22282112\\Documents\\SistemaClinico\\src\\arquivos\\medico.txt";
    private static final String caminho_TEMP = "C:\\Users\\22282112\\Documents\\SistemaClinico\\src\\arquivos\\medico_temp.txt";
    private static final Path PATH = Paths.get(caminho) ;
    private static final Path PATH_TEMP = Paths.get(caminho_TEMP);
    public static BufferedWriter bw;
   

    public MedicoDAO(Medico medico) {
        this.medico = medico;
    }

    public MedicoDAO() {
        
    }
    
    
    
    public static void gravar(Medico medico) {
        try {
            
            bw = Files.newBufferedWriter(PATH,StandardOpenOption.APPEND, StandardOpenOption.WRITE);
            bw.write(medico.getMedicoComPontoVirgula());
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(
                    null, 
                    "Ocorreu um erro ao gravar.\n\nEntre em contato com o suporte.", 
                    "ERRO", 
                    JOptionPane.ERROR_MESSAGE);
        }
        
        medicos.add(medico);
    }
    
    public static boolean excluir(Integer codigo) {
        for (Medico m : medicos) {
            if (m.getCodigo().equals(codigo)) {
                medicos.remove(m);
                break;
            }
        }
        atualizarArquivo();

        return false;
    }

    public static void atualizar(Medico medico) {
        for (Medico m : medicos) {
            if (m.getCodigo().equals(medico.getCodigo())) {
                medicos.set(medicos.indexOf(m), medico);
                break;
            }

        }
        atualizarArquivo();
        
    }
    

    public static Medico getMedico(Integer codigo) {
        for (Medico m : medicos) {
            if (m.getCodigo().equals(codigo)) {
                return m;
            }
        }
        return null;
    }
    
    public static ArrayList<Medico> listarTodos(){
        return medicos;
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

            for (Medico m : medicos) {
                bwTemp.write(m.getMedicoComPontoVirgula());
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
   
    public static void getListaMedicos() {

        try {
            // Abrir o arquivo para leitura - LEITOR
            BufferedReader br = Files.newBufferedReader(PATH);
            String linha = br.readLine();
            while (linha != null && !linha.isEmpty()) {
                String[] linhaVetor = linha.split(";");
                
                int i = 0;
                ArrayList<Especialidade> especialidades = new ArrayList<>();
                System.out.println(linhaVetor.length);
                while(linhaVetor.length > i +6) {
                    especialidades.add(EspecialidadeDAO.getEspecialidade(Integer.valueOf(linhaVetor[6+i])));
                    i++;
                }
                System.out.println(especialidades.get(0));
                String[] data = linhaVetor[5].split("/");
                int ano = Integer.parseInt(data[2]);
                int mes = Integer.parseInt(data[1]);
                int dia = Integer.parseInt(data[0]);  
                LocalDate dataNascimento = LocalDate.of(ano,mes, dia);

                
                Medico m = new Medico(
                        Integer.valueOf(linhaVetor[0]),
                        linhaVetor[1],
                        linhaVetor[2],
                        linhaVetor[3],
                        linhaVetor[4],
                        dataNascimento,
                        especialidades);

                medicos.add(m);
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
        Object[][] dados = new Object[medicos.size()][4];

        // For Each, para extrair cada objeto plano de saúde
        // arrayList planos e separar cada dado na matriz dados
        int i = 0;
        for (Medico m : medicos) {
            dados[i][0] = m.getCodigo();
            dados[i][1] = m.getCrm();
            dados[i][2] = m.getNome();
            i++;
        }
        // Definir o vetor com os nomes das tabelas
        String[] titulos = {"Código", "Crm", "Nome do(a) Médico(a)"};

        // Criar o modelo que será utilizado pelo JTabel
        // para exibir os dados dos planos
        DefaultTableModel tableModel = new DefaultTableModel(dados, titulos);
        return tableModel;

    }
        
}
