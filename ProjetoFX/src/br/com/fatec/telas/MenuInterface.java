package br.com.fatec.telas;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import projetofx.ProjetoFX;

/**
 * FXML Controller class
 *
 * @author Bruno Pequeno FATEC Carapicuíba
 * @version 1.1
 *
 */
public class MenuInterface implements Initializable {

    // ===== COLPDC =====
    @FXML
    private MenuItem inserirColPdc;
    @FXML
    private MenuItem alterarColPdc;
    @FXML
    private MenuItem buscarColPdc;
    @FXML
    private MenuItem excluirColPdc;
    @FXML
    private MenuItem listarColPdc;

// ===== COLABORADOR =====
    @FXML
    private MenuItem inserirColaborador;
    @FXML
    private MenuItem alterarColaborador;
    @FXML
    private MenuItem buscarColaborador;
    @FXML
    private MenuItem excluirColaborador;
    @FXML
    private MenuItem listarColaborador;

// ===== LOGRADOURO =====
    @FXML
    private MenuItem inserirLogradouro;
    @FXML
    private MenuItem alterarLogradouro;
    @FXML
    private MenuItem buscarLogradouro;
    @FXML
    private MenuItem excluirLogradouro;
    @FXML
    private MenuItem listarLogradouro;
    @FXML
    private MenuItem buscarCep;

// ===== MATERIAL =====
    @FXML
    private MenuItem inserirMaterial;
    @FXML
    private MenuItem alterarMaterial;
    @FXML
    private MenuItem buscarMaterial;
    @FXML
    private MenuItem excluirMaterial;
    @FXML
    private MenuItem listarMaterial;

// ===== PDRCOL =====
    @FXML
    private MenuItem inserirPDRCOL;
    @FXML
    private MenuItem alterarPDRCOL;
    @FXML
    private MenuItem buscarPDRCOL;
    @FXML
    private MenuItem excluirPDRCOL;
    @FXML
    private MenuItem listarPDRCOL;

// ===== PEF_PDC =====
    @FXML
    private MenuItem inserirPEF_PDC;
    @FXML
    private MenuItem alterarPEF_PDC;
    @FXML
    private MenuItem buscarPEF_PDC;
    @FXML
    private MenuItem excluirPEF_PDC;
    @FXML
    private MenuItem listarPEF_PDC;

// ===== PESSOA =====
    @FXML
    private MenuItem inserirPessoa;
    @FXML
    private MenuItem buscarPessoa;
    @FXML
    private MenuItem listarPessoa;

// ===== PESSOAFISICA =====
    @FXML
    private MenuItem inserirPessoaFisica;
    @FXML
    private MenuItem alterarPessoaFisica;
    @FXML
    private MenuItem buscarPessoaFisica;
    @FXML
    private MenuItem excluirPessoaFisica;
    @FXML
    private MenuItem listarPessoaFisica;

// ===== PESSOAJURIDICA =====
    @FXML
    private MenuItem inserirPessoaJuridica;
    @FXML
    private MenuItem alterarPessoaJuridica;
    @FXML
    private MenuItem buscarPessoaJuridica;
    @FXML
    private MenuItem excluirPessoaJuridica;
    @FXML
    private MenuItem listarPessoaJuridica;

// ===== PONTOCOLETA =====
    @FXML
    private MenuItem inserirPontoColeta;
    @FXML
    private MenuItem alterarPontoColeta;
    @FXML
    private MenuItem buscarPontoColeta;
    @FXML
    private MenuItem excluirPontoColeta;
    @FXML
    private MenuItem listarPontoColeta;

// ===== PONTORECICLAGEM =====
    @FXML
    private MenuItem inserirPontoReciclagem;
    @FXML
    private MenuItem alterarPontoReciclagem;
    @FXML
    private MenuItem buscarPontoReciclagem;
    @FXML
    private MenuItem excluirPontoReciclagem;
    @FXML
    private MenuItem listarPontoReciclagem;

// ===== SISTEMA =====
    @FXML
    private MenuItem inserirSistema;
    @FXML
    private MenuItem alterarSistema;
    @FXML
    private MenuItem buscarSistema;
    @FXML
    private MenuItem excluirSistema;
    @FXML
    private MenuItem listarSistema;

// ===== USUARIO =====
    @FXML
    private MenuItem inserirUsuario;
    @FXML
    private MenuItem buscarUsuario;

    @FXML
    private MenuItem consultarUsuario;

// ===== USUARIOSISTEMA =====
    @FXML
    private MenuItem inserirUsuarioSistema;
    @FXML
    private MenuItem alterarUsuarioSistema;
    @FXML
    private MenuItem buscarUsuarioSistema;
    @FXML
    private MenuItem excluirUsuarioSistema;
    @FXML
    private MenuItem listarUsuarioSistema;

    private void initComponentes() {
        // ===== COLPDC =====

        /**
         * configurarAcao(inserirColPdc, "colpdc", "Inserir", "ColPdc");
         * configurarAcao(alterarColPdc, "colpdc", "Alterar", "ColPdc");
         * configurarAcao(buscarColPdc, "colpdc", "Buscar", "ColPdc");
         * configurarAcao(excluirColPdc, "colpdc", "Excluir", "ColPdc");
         * configurarAcao(listarColPdc, "colpdc", "Listar", "ColPdc");
         *
         *
         * // ===== COLABORADOR ===== configurarAcao(inserirColaborador,
         * "colaborador", "Inserir", "Colaborador");
         * configurarAcao(alterarColaborador, "colaborador", "Alterar",
         * "Colaborador"); configurarAcao(buscarColaborador, "colaborador",
         * "Buscar", "Colaborador"); configurarAcao(excluirColaborador,
         * "colaborador", "Excluir", "Colaborador");
         * configurarAcao(listarColaborador, "colaborador", "Listar",
         * "Colaborador");
         *
         *
         * // ===== MATERIAL ===== configurarAcao(inserirMaterial, "material",
         * "Inserir", "Material"); configurarAcao(alterarMaterial, "material",
         * "Alterar", "Material"); configurarAcao(buscarMaterial, "material",
         * "Buscar", "Material"); configurarAcao(excluirMaterial, "material",
         * "Excluir", "Material"); configurarAcao(listarMaterial, "material",
         * "Listar", "Material");
         *
         * // ===== PDRCOL ===== configurarAcao(inserirPDRCOL, "pdrcoll",
         * "Inserir", "PDRCOL"); configurarAcao(alterarPDRCOL, "pdrcoll",
         * "Alterar", "PDRCOL"); configurarAcao(buscarPDRCOL, "pdrcoll",
         * "Buscar", "PDRCOL"); configurarAcao(excluirPDRCOL, "pdrcoll",
         * "Excluir", "PDRCOL"); configurarAcao(listarPDRCOL, "pdrcoll",
         * "Listar", "PDRCOL");
         *
         * // ===== PEF_PDC ===== configurarAcao(inserirPEF_PDC, "pef_pdc",
         * "Inserir", "PEF_PDC"); configurarAcao(alterarPEF_PDC, "pef_pdc",
         * "Alterar", "PEF_PDC"); configurarAcao(buscarPEF_PDC, "pef_pdc",
         * "Buscar", "PEF_PDC"); configurarAcao(excluirPEF_PDC, "pef_pdc",
         * "Excluir", "PEF_PDC"); configurarAcao(listarPEF_PDC, "pef_pdc",
         * "Listar", "PEF_PDC");
         *
          // ===== PESSOA ===== 
         
         * // ===== PESSOAFISICA ===== configurarAcao(inserirPessoaFisica,
         * "pessoafisica", "Inserir", "PessoaFisica");
         * configurarAcao(alterarPessoaFisica, "pessoafisica", "Alterar",
         * "PessoaFisica"); configurarAcao(buscarPessoaFisica, "pessoafisica",
         * "Buscar", "PessoaFisica"); configurarAcao(excluirPessoaFisica,
         * "pessoafisica", "Excluir", "PessoaFisica");
         * configurarAcao(listarPessoaFisica, "pessoafisica", "Listar",
         * "PessoaFisica");
         *
         * // ===== PESSOAJURIDICA ===== configurarAcao(inserirPessoaJuridica,
         * "pessoajuridica", "Inserir", "PessoaJuridica");
         * configurarAcao(alterarPessoaJuridica, "pessoajuridica", "Alterar",
         * "PessoaJuridica"); configurarAcao(buscarPessoaJuridica,
         * "pessoajuridica", "Buscar", "PessoaJuridica");
         * configurarAcao(excluirPessoaJuridica, "pessoajuridica", "Excluir",
         * "PessoaJuridica"); configurarAcao(listarPessoaJuridica,
         * "pessoajuridica", "Listar", "PessoaJuridica");
         *
         * // ===== PONTORECICLAGEM =====
         * configurarAcao(inserirPontoReciclagem, "pontoreciclagem", "Inserir",
         * "PontoReciclagem"); configurarAcao(alterarPontoReciclagem,
         * "pontoreciclagem", "Alterar", "PontoReciclagem");
         * configurarAcao(buscarPontoReciclagem, "pontoreciclagem", "Buscar",
         * "PontoReciclagem"); configurarAcao(excluirPontoReciclagem,
         * "pontoreciclagem", "Excluir", "PontoReciclagem");
         * configurarAcao(listarPontoReciclagem, "pontoreciclagem", "Listar",
         * "PontoReciclagem");
         *
         * // ===== SISTEMA ===== configurarAcao(inserirSistema, "sistema",
         * "Inserir", "Sistema"); configurarAcao(alterarSistema, "sistema",
         * "Alterar", "Sistema"); configurarAcao(buscarSistema, "sistema",
         * "Buscar", "Sistema"); configurarAcao(excluirSistema, "sistema",
         * "Excluir", "Sistema"); configurarAcao(listarSistema, "sistema",
         * "Listar", "Sistema");
         */
        // ========= PESSOA ==========
        configurarAcao(inserirPessoa, "pessoa","Inserir", "Pessoa"); 
        configurarAcao(buscarPessoa, "pessoa","Buscar", "Pessoa"); 
        configurarAcao(listarPessoa, "pessoa","Consultar", "Pessoa");

        // ===== USUARIO =====
        configurarAcao(inserirUsuario, "usuario", "Inserir", "Usuario");
        //configurarAcao(buscarUsuario, "usuario", "Buscar", "Usuario");
        configurarAcao(consultarUsuario, "usuario", "Consultar", "Usuario");

        // ===== LOGRADOURO =====
        configurarAcao(inserirLogradouro, "logradouro", "Inserir", "Logradouro");
        configurarAcao(alterarLogradouro, "logradouro", "Alterar", "Logradouro");
        configurarAcao(buscarLogradouro, "logradouro", "Consultar", "Logradouro");
        configurarAcao(excluirLogradouro, "logradouro", "Excluir", "Logradouro");
        configurarAcao(listarLogradouro, "logradouro", "Listar", "Logradouro");
        configurarAcao(buscarCep, "logradouro", "Buscar", "Cep");

        // ===== PONTOCOLETA =====
        configurarAcao(inserirPontoColeta, "pdc", "Inserir", "PDC");
        configurarAcao(alterarPontoColeta, "pdc", "Alterar", "PDC");
        configurarAcao(buscarPontoColeta, "pdc", "Consultar", "PDC");
        configurarAcao(excluirPontoColeta, "pdc", "Excluir", "PDC");
        configurarAcao(listarPontoColeta, "pdc", "Listar", "PDC");
        
        // ===== COLABORADOR ===== 
        configurarAcao(inserirColaborador, "colaborador", "Inserir", "Colaborador");
        configurarAcao(alterarColaborador, "colaborador", "Alterar", "Colaborador");
        configurarAcao(buscarColaborador, "colaborador", "Consultar", "Colaborador");
        configurarAcao(excluirColaborador, "colaborador", "Excluir", "Colaborador");
        configurarAcao(listarColaborador, "colaborador", "Listar", "Colaborador");
        /**
         * // ===== USUARIOSISTEMA ===== configurarAcao(inserirUsuarioSistema,
         * "usuariosistema", "Inserir", "UsuarioSistema");
         * configurarAcao(alterarUsuarioSistema, "usuariosistema", "Alterar",
         * "UsuarioSistema"); configurarAcao(buscarUsuarioSistema,
         * "usuariosistema", "Buscar", "UsuarioSistema");
         * configurarAcao(excluirUsuarioSistema, "usuariosistema", "Excluir",
         * "UsuarioSistema"); configurarAcao(listarUsuarioSistema,
         * "usuariosistema", "Listar", "UsuarioSistema");
         *
         */
    }

    private void configurarAcao(MenuItem item, String pasta, String acao, String nomeBean) {
        item.setOnAction(event -> {
            try {
                // Exemplo: /br/com/fatec/xmls/usuarios/InserirUsuarioInterface.fxml
                String caminho = String.format("/br/com/fatec/xmls/%s/%s%sInterface.fxml",
                        pasta.toLowerCase(), acao, nomeBean);
                Parent novatela = FXMLLoader.load(ProjetoFX.class.getResource(caminho));
                Stage stg = ProjetoFX.getStage();
                stg.setScene(new Scene(novatela));
                stg.show();
            } catch (IOException ex) {
                Logger.getLogger(MenuInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        initComponentes();
    }

}
