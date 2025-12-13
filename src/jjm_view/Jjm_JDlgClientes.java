/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package jjm_view;

import bean.JjmClientes;
import dao.UsuariosDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import tools.Util;

/**
 *
 * @author user
 */
public class Jjm_JDlgClientes extends javax.swing.JDialog {

    /**
     * Creates new form Jjm_JDlgClientes
     */
        private boolean incluir; 
private MaskFormatter mascaraCpf, mascaraDataNasc;
     boolean pesquisando = false;
    public Jjm_JDlgClientes(java.awt.Frame parent, boolean modal) {
       super(parent, modal);
        initComponents();
        setTitle("Cadastro de Usuarios");
        setLocationRelativeTo(null);
 Util.habilitar(false, jjm_jTxtCodigo, jjm_jTxtNome, jjm_jFmtDatadenascimento,
                   jjm_jTxtCidade, jjm_jTxtFormadepagamento, jjm_jFmtDatadaultimacompra,
                   jjm_jTxtEmail, jjm_jTxtRg, jjm_jTxtBairro, jjm_jTxtSexo,
                   jjm_jTxtTipodecliente, jjm_jTxtCep, jjm_jTxtTelefone,
                   jjm_jTxtEndereco, jjm_jTxtEstado);

    // Deixa Confirmar e Cancelar desabilitados
    jjm_jBtnConfirmar.setEnabled(false);
    jjm_jBtnCancelar.setEnabled(false);

try {
            mascaraDataNasc = new MaskFormatter("##/##/####");
            jjm_jFmtDatadenascimento.setFormatterFactory(new DefaultFormatterFactory(mascaraDataNasc));
        } catch (ParseException ex) {
            Logger.getLogger(Jjm_JDlgClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
try {
            mascaraDataNasc = new MaskFormatter("##/##/####");
            jjm_jFmtDatadaultimacompra.setFormatterFactory(new DefaultFormatterFactory(mascaraDataNasc));
        } catch (ParseException ex) {
            Logger.getLogger(Jjm_JDlgClientes.class.getName()).log(Level.SEVERE, null, ex);
        }
Timer timer = new Timer(1000, new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        Date agora = new Date();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy - HH:mm:ss");
        jLabel1.setText(formato.format(agora));
    }
});
timer.start();

            }
    

    
    public JjmClientes viewBean() {
    JjmClientes jjmClientes = new JjmClientes();

    jjmClientes.setJjmIdCliente(Util.strToInt(jjm_jTxtCodigo.getText()));
    jjmClientes.setJjmNome(jjm_jTxtNome.getText());
SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                try {
                    Date dataNasc = formato.parse(jjm_jFmtDatadenascimento.getText());
                    jjmClientes.setJjmDataNasc(dataNasc);
                } catch (ParseException ex) {
                    Logger.getLogger(Jjm_JDlgClientes.class.getName()).log(Level.SEVERE, null, ex);
                }
    jjmClientes.setJjmCidade(jjm_jTxtCidade.getText());
    jjmClientes.setJjmFormaPagamento(jjm_jTxtFormadepagamento.getText());
   try {
                    Date dataNasc = formato.parse(jjm_jFmtDatadaultimacompra.getText());
                    jjmClientes.setJjmDataUltimaCompra(dataNasc);
                } catch (ParseException ex) {
                    Logger.getLogger(Jjm_JDlgClientes.class.getName()).log(Level.SEVERE, null, ex);
                }
    jjmClientes.setJjmEmail(jjm_jTxtEmail.getText());
    jjmClientes.setJjmRg(jjm_jTxtRg.getText());
    jjmClientes.setJjmBairro(jjm_jTxtBairro.getText());
    jjmClientes.setJjmSexo(jjm_jTxtSexo.getText());
    jjmClientes.setJjmTipoCliente(jjm_jTxtTipodecliente.getText());
    jjmClientes.setJjmCep(jjm_jTxtCep.getText());
    jjmClientes.setJjmTelefone(jjm_jTxtTelefone.getText());
    jjmClientes.setJjmEndereco(jjm_jTxtEndereco.getText());
    jjmClientes.setJjmEstado(jjm_jTxtEstado.getText());

    return jjmClientes;
}

public void beanView(JjmClientes jjmClientes) {
    jjm_jTxtCodigo.setText(Util.intToStr(jjmClientes.getJjmIdCliente()));
    jjm_jTxtNome.setText(jjmClientes.getJjmNome());
    jjm_jFmtDatadenascimento.setText(Util.dateToStr(jjmClientes.getJjmDataNasc()));
    jjm_jTxtCidade.setText(jjmClientes.getJjmCidade());
    jjm_jTxtFormadepagamento.setText(jjmClientes.getJjmFormaPagamento());
    jjm_jFmtDatadaultimacompra.setText(Util.dateToStr(jjmClientes.getJjmDataUltimaCompra()));
    jjm_jTxtEmail.setText(jjmClientes.getJjmEmail());
    jjm_jTxtRg.setText(jjmClientes.getJjmRg());
    jjm_jTxtBairro.setText(jjmClientes.getJjmBairro());
    jjm_jTxtSexo.setText(jjmClientes.getJjmSexo());
    jjm_jTxtTipodecliente.setText(jjmClientes.getJjmTipoCliente());
    jjm_jTxtCep.setText(jjmClientes.getJjmCep());
    jjm_jTxtTelefone.setText(jjmClientes.getJjmTelefone());
    jjm_jTxtEndereco.setText(jjmClientes.getJjmEndereco());
    jjm_jTxtEstado.setText(jjmClientes.getJjmEstado());
}


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jjm_jTxtTelefone = new javax.swing.JTextField();
        jLblEndereco = new javax.swing.JLabel();
        jjm_jTxtEndereco = new javax.swing.JTextField();
        jLblDatadenascimento = new javax.swing.JLabel();
        jjm_jFmtDatadenascimento = new javax.swing.JFormattedTextField();
        jLblFormadepagamento = new javax.swing.JLabel();
        jjm_jFmtDatadaultimacompra = new javax.swing.JFormattedTextField();
        jjm_jTxtFormadepagamento = new javax.swing.JTextField();
        JLblRg = new javax.swing.JLabel();
        jjm_jTxtRg = new javax.swing.JTextField();
        jLblTipodecliente = new javax.swing.JLabel();
        jjm_jTxtTipodecliente = new javax.swing.JTextField();
        jLblCep = new javax.swing.JLabel();
        jjm_jTxtCep = new javax.swing.JTextField();
        jLblEstado = new javax.swing.JLabel();
        jLblCodigo = new javax.swing.JLabel();
        jjm_jTxtEstado = new javax.swing.JTextField();
        jjm_jTxtCodigo = new javax.swing.JTextField();
        jLblCidade = new javax.swing.JLabel();
        jLblNome = new javax.swing.JLabel();
        jjm_jTxtCidade = new javax.swing.JTextField();
        jjm_jTxtNome = new javax.swing.JTextField();
        jLblDataDaUltimaCompra = new javax.swing.JLabel();
        jLblEmail = new javax.swing.JLabel();
        jLblBairro = new javax.swing.JLabel();
        jjm_jTxtEmail = new javax.swing.JTextField();
        jjm_jTxtBairro = new javax.swing.JTextField();
        jLblSexo = new javax.swing.JLabel();
        jjm_jTxtSexo = new javax.swing.JTextField();
        jLblTelefone = new javax.swing.JLabel();
        jjm_jBtnAlterar = new javax.swing.JButton();
        jjm_jBtnExcluir = new javax.swing.JButton();
        jjm_jBtnConfirmar = new javax.swing.JButton();
        jjm_jBtnCancelar = new javax.swing.JButton();
        jjm_jBtnPesquisar = new javax.swing.JButton();
        jjm_jBtnIncluir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jjm_jCBoxAtivo = new javax.swing.JCheckBox();
        jjm_jLblAtivo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jjm_jTxtTelefone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jjm_jTxtTelefoneActionPerformed(evt);
            }
        });

        jLblEndereco.setText("Endereco");

        jjm_jTxtEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jjm_jTxtEnderecoActionPerformed(evt);
            }
        });

        jLblDatadenascimento.setText("Data de Nascimento");

        jLblFormadepagamento.setText("Forma de Pagamento");

        jjm_jTxtFormadepagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jjm_jTxtFormadepagamentoActionPerformed(evt);
            }
        });

        JLblRg.setText("Rg:");

        jjm_jTxtRg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jjm_jTxtRgActionPerformed(evt);
            }
        });

        jLblTipodecliente.setText("Tipo De Cliente");

        jjm_jTxtTipodecliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jjm_jTxtTipodeclienteActionPerformed(evt);
            }
        });

        jLblCep.setText("Cep");

        jLblEstado.setText("Estado:");

        jLblCodigo.setText("Codigo");

        jjm_jTxtEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jjm_jTxtEstadoActionPerformed(evt);
            }
        });

        jjm_jTxtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jjm_jTxtCodigoActionPerformed(evt);
            }
        });

        jLblCidade.setText("Cidade");

        jLblNome.setText("Nome:");

        jjm_jTxtCidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jjm_jTxtCidadeActionPerformed(evt);
            }
        });

        jjm_jTxtNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jjm_jTxtNomeActionPerformed(evt);
            }
        });

        jLblDataDaUltimaCompra.setText("Data da Ultima Compra ");

        jLblEmail.setText("Email:");

        jLblBairro.setText("Bairro");

        jjm_jTxtEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jjm_jTxtEmailActionPerformed(evt);
            }
        });

        jjm_jTxtBairro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jjm_jTxtBairroActionPerformed(evt);
            }
        });

        jLblSexo.setText("Sexo:");

        jjm_jTxtSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jjm_jTxtSexoActionPerformed(evt);
            }
        });

        jLblTelefone.setText("Telefone:");

        jjm_jBtnAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/alterar.png"))); // NOI18N
        jjm_jBtnAlterar.setText("Alterar");
        jjm_jBtnAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jjm_jBtnAlterarActionPerformed(evt);
            }
        });

        jjm_jBtnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Excluir.png"))); // NOI18N
        jjm_jBtnExcluir.setText("Excluir");
        jjm_jBtnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jjm_jBtnExcluirActionPerformed(evt);
            }
        });

        jjm_jBtnConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ok.png"))); // NOI18N
        jjm_jBtnConfirmar.setText("Confirmar");
        jjm_jBtnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jjm_jBtnConfirmarActionPerformed(evt);
            }
        });

        jjm_jBtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancelar.png"))); // NOI18N
        jjm_jBtnCancelar.setText("Cancelar");
        jjm_jBtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jjm_jBtnCancelarActionPerformed(evt);
            }
        });

        jjm_jBtnPesquisar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pesquisar.png"))); // NOI18N
        jjm_jBtnPesquisar.setText("Pesquisar");
        jjm_jBtnPesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jjm_jBtnPesquisarActionPerformed(evt);
            }
        });

        jjm_jBtnIncluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/incluir.png"))); // NOI18N
        jjm_jBtnIncluir.setText("Incluir");
        jjm_jBtnIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jjm_jBtnIncluirActionPerformed(evt);
            }
        });

        jjm_jCBoxAtivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jjm_jCBoxAtivoActionPerformed(evt);
            }
        });

        jjm_jLblAtivo.setText("Ativo");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jjm_jTxtTipodecliente, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jjm_jTxtCep, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jjm_jTxtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jjm_jTxtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jjm_jTxtEstado, javax.swing.GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jjm_jTxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLblDatadenascimento))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jjm_jFmtDatadenascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLblCodigo))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jjm_jTxtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLblCidade))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLblNome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLblFormadepagamento))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jjm_jTxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jjm_jTxtFormadepagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jjm_jBtnIncluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jjm_jBtnConfirmar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jjm_jBtnAlterar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jjm_jBtnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jjm_jBtnExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jjm_jBtnPesquisar)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLblDataDaUltimaCompra)
                            .addComponent(jLblTipodecliente)
                            .addComponent(jjm_jFmtDatadaultimacompra, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLblCep)
                                .addGap(86, 86, 86)
                                .addComponent(jLblTelefone)
                                .addGap(72, 72, 72)
                                .addComponent(jLblEndereco)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLblEstado)
                                .addGap(47, 47, 47))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jjm_jTxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLblEmail))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(JLblRg)
                                    .addComponent(jjm_jTxtRg, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jjm_jTxtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLblBairro))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLblSexo)
                                    .addComponent(jjm_jTxtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jjm_jLblAtivo, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jjm_jCBoxAtivo)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblCodigo)
                    .addComponent(jLblDatadenascimento)
                    .addComponent(jLblCidade)
                    .addComponent(jLblNome)
                    .addComponent(jLblFormadepagamento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jjm_jTxtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jjm_jFmtDatadenascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jjm_jTxtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jjm_jTxtNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jjm_jTxtFormadepagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLblDataDaUltimaCompra)
                    .addComponent(jLblEmail)
                    .addComponent(JLblRg)
                    .addComponent(jLblBairro)
                    .addComponent(jLblSexo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jjm_jTxtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jjm_jTxtRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jjm_jTxtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jjm_jTxtSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jjm_jFmtDatadaultimacompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLblTipodecliente)
                            .addComponent(jLblCep))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jjm_jTxtTipodecliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jjm_jTxtCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jjm_jTxtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jjm_jTxtEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jjm_jTxtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLblTelefone)
                        .addComponent(jLblEndereco)
                        .addComponent(jLblEstado)))
                .addGap(5, 5, 5)
                .addComponent(jjm_jLblAtivo)
                .addGap(7, 7, 7)
                .addComponent(jjm_jCBoxAtivo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jjm_jBtnIncluir)
                    .addComponent(jjm_jBtnConfirmar)
                    .addComponent(jjm_jBtnAlterar)
                    .addComponent(jjm_jBtnCancelar)
                    .addComponent(jjm_jBtnExcluir)
                    .addComponent(jjm_jBtnPesquisar))
                .addGap(40, 40, 40))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jjm_jTxtTelefoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jjm_jTxtTelefoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jjm_jTxtTelefoneActionPerformed

    private void jjm_jTxtEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jjm_jTxtEnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jjm_jTxtEnderecoActionPerformed

    private void jjm_jTxtFormadepagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jjm_jTxtFormadepagamentoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jjm_jTxtFormadepagamentoActionPerformed

    private void jjm_jTxtRgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jjm_jTxtRgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jjm_jTxtRgActionPerformed

    private void jjm_jTxtTipodeclienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jjm_jTxtTipodeclienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jjm_jTxtTipodeclienteActionPerformed

    private void jjm_jTxtEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jjm_jTxtEstadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jjm_jTxtEstadoActionPerformed

    private void jjm_jTxtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jjm_jTxtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jjm_jTxtCodigoActionPerformed

    private void jjm_jTxtCidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jjm_jTxtCidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jjm_jTxtCidadeActionPerformed

    private void jjm_jTxtNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jjm_jTxtNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jjm_jTxtNomeActionPerformed

    private void jjm_jTxtEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jjm_jTxtEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jjm_jTxtEmailActionPerformed

    private void jjm_jTxtBairroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jjm_jTxtBairroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jjm_jTxtBairroActionPerformed

    private void jjm_jTxtSexoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jjm_jTxtSexoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jjm_jTxtSexoActionPerformed

    private void jjm_jBtnAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jjm_jBtnAlterarActionPerformed
       Util.habilitar(true,  jjm_jTxtNome, jjm_jFmtDatadenascimento, jjm_jTxtCidade, 
        jjm_jTxtFormadepagamento, jjm_jFmtDatadaultimacompra, jjm_jTxtEmail, 
        jjm_jTxtRg, jjm_jTxtBairro, jjm_jTxtSexo, jjm_jTxtTipodecliente, 
        jjm_jTxtCep, jjm_jTxtTelefone, jjm_jTxtEndereco, jjm_jTxtEstado,
        jjm_jBtnConfirmar, jjm_jBtnCancelar);
    Util.habilitar(false, jjm_jBtnAlterar, jjm_jBtnExcluir, jjm_jBtnPesquisar, jjm_jBtnIncluir);
    incluir=false;
    Util.limpar(jjm_jTxtNome, jjm_jFmtDatadenascimento, jjm_jTxtCidade, 
        jjm_jTxtFormadepagamento, jjm_jFmtDatadaultimacompra, jjm_jTxtEmail, 
        jjm_jTxtRg, jjm_jTxtBairro, jjm_jTxtSexo, jjm_jTxtTipodecliente, 
        jjm_jTxtCep, jjm_jTxtTelefone, jjm_jTxtEndereco, jjm_jTxtEstado);
    }//GEN-LAST:event_jjm_jBtnAlterarActionPerformed

    private void jjm_jBtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jjm_jBtnExcluirActionPerformed

  if (Util.perguntar("Deseja Excluir?") == true) {
            UsuariosDAO usuariosDAO = new UsuariosDAO();
            usuariosDAO.delete(viewBean());
                Util.limpar(  jjm_jTxtCodigo, jjm_jTxtNome, jjm_jFmtDatadenascimento, jjm_jTxtCidade, 
        jjm_jTxtFormadepagamento, jjm_jFmtDatadaultimacompra, jjm_jTxtEmail, 
        jjm_jTxtRg, jjm_jTxtBairro, jjm_jTxtSexo, jjm_jTxtTipodecliente, 
        jjm_jTxtCep, jjm_jTxtTelefone, jjm_jTxtEndereco, jjm_jTxtEstado);  
        } 
    }//GEN-LAST:event_jjm_jBtnExcluirActionPerformed

    private void jjm_jBtnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jjm_jBtnConfirmarActionPerformed
   UsuariosDAO usuariosDAO = new UsuariosDAO();
        if (incluir == true) {
            usuariosDAO.insert(viewBean());
        } else {
            usuariosDAO.update(viewBean());
        }
        Util.habilitar(false, 
        jjm_jTxtCodigo, jjm_jTxtNome, jjm_jFmtDatadenascimento, jjm_jTxtCidade, 
        jjm_jTxtFormadepagamento, jjm_jFmtDatadaultimacompra, jjm_jTxtEmail, 
        jjm_jTxtRg, jjm_jTxtBairro, jjm_jTxtSexo, jjm_jTxtTipodecliente, 
        jjm_jTxtCep, jjm_jTxtTelefone, jjm_jTxtEndereco, jjm_jTxtEstado,
        jjm_jBtnConfirmar, jjm_jBtnCancelar
    );
    Util.habilitar(true, jjm_jBtnAlterar, jjm_jBtnExcluir, jjm_jBtnPesquisar, jjm_jBtnIncluir);
          Util.limpar(  jjm_jTxtCodigo, jjm_jTxtNome, jjm_jFmtDatadenascimento, jjm_jTxtCidade, 
        jjm_jTxtFormadepagamento, jjm_jFmtDatadaultimacompra, jjm_jTxtEmail, 
        jjm_jTxtRg, jjm_jTxtBairro, jjm_jTxtSexo, jjm_jTxtTipodecliente, 
        jjm_jTxtCep, jjm_jTxtTelefone, jjm_jTxtEndereco, jjm_jTxtEstado);
    }//GEN-LAST:event_jjm_jBtnConfirmarActionPerformed

    private void jjm_jBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jjm_jBtnCancelarActionPerformed
        Util.habilitar(false, 
        jjm_jTxtCodigo, jjm_jTxtNome, jjm_jFmtDatadenascimento, jjm_jTxtCidade, 
        jjm_jTxtFormadepagamento, jjm_jFmtDatadaultimacompra, jjm_jTxtEmail, 
        jjm_jTxtRg, jjm_jTxtBairro, jjm_jTxtSexo, jjm_jTxtTipodecliente, 
        jjm_jTxtCep, jjm_jTxtTelefone, jjm_jTxtEndereco, jjm_jTxtEstado,
        jjm_jBtnConfirmar, jjm_jBtnCancelar
    );
    Util.habilitar(true, jjm_jBtnAlterar, jjm_jBtnExcluir, jjm_jBtnPesquisar, jjm_jBtnIncluir);
          
          Util.limpar(  jjm_jTxtCodigo, jjm_jTxtNome, jjm_jFmtDatadenascimento, jjm_jTxtCidade, 
        jjm_jTxtFormadepagamento, jjm_jFmtDatadaultimacompra, jjm_jTxtEmail, 
        jjm_jTxtRg, jjm_jTxtBairro, jjm_jTxtSexo, jjm_jTxtTipodecliente, 
        jjm_jTxtCep, jjm_jTxtTelefone, jjm_jTxtEndereco, jjm_jTxtEstado);
    }//GEN-LAST:event_jjm_jBtnCancelarActionPerformed

    private void jjm_jBtnPesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jjm_jBtnPesquisarActionPerformed
        // TODO add your handling code here:
        /* String id = JOptionPane.showInputDialog(null, "Entre com o código ?");
        int codigo = Integer.valueOf(id);
        Jjm_ClientesDAO clientesDAO = new Jjm_ClientesDAO();
        Jjm_Clientes clientes = (Jjm_Clientes) clientesDAO.list(codigo);
        if (clientes == null) {
            JOptionPane.showMessageDialog(null, "Codigo nao existente");
        } else {
            jjm_jTxtCodigo.setText(id);
            jjm_jTxtNome.setText(clientes.getjjm_Nome());
            jjm_jTxtEmail.setText(clientes.getjjm_Email());
            jjm_jTxtSexo.setText(clientes.getjjm_Sexo());
            jjm_jTxtTelefone.setText(clientes.getjjm_Telefone());
            jjm_jTxtEndereco.setText(clientes.getjjm_Endereco());
            jjm_jFmtDatadaultimacompra.setText(null);
            jjm_jTxtFormadepagamento.setText(clientes.getjjm_Formadepagamento());
            jjm_jTxtRg.setText(clientes.getjjm_Rg());
            jjm_jTxtTipodecliente.setText(clientes.getjjm_Tipocliente());
            jjm_jTxtCep.setText(clientes.getjjm_Cep());
            jjm_jTxtEstado.setText(clientes.getjjm_Estado());
            jjm_jTxtCidade.setText(clientes.getjjm_Cidade());
            jjm_jFmtDatadenascimento.setText(null);
            jjm_jTxtBairro.setText(clientes.getjjm_Bairro());
        }*/
        
        JDlgClientesPesquisar jDlgClientePesquisar = new JDlgClientesPesquisar(null, true);
        jDlgClientePesquisar.setTelaPai(this);
        jDlgClientePesquisar.setVisible(true);
        pesquisando = true;
    }//GEN-LAST:event_jjm_jBtnPesquisarActionPerformed

    private void jjm_jBtnIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jjm_jBtnIncluirActionPerformed
        // TODO add your handling code here:
        Util.habilitar(true, 
        jjm_jTxtCodigo, jjm_jTxtNome, jjm_jFmtDatadenascimento, jjm_jTxtCidade, 
        jjm_jTxtFormadepagamento, jjm_jFmtDatadaultimacompra, jjm_jTxtEmail, 
        jjm_jTxtRg, jjm_jTxtBairro, jjm_jTxtSexo, jjm_jTxtTipodecliente, 
        jjm_jTxtCep, jjm_jTxtTelefone, jjm_jTxtEndereco, jjm_jTxtEstado,
        jjm_jBtnConfirmar, jjm_jBtnCancelar
    );
    Util.habilitar(false, jjm_jBtnAlterar, jjm_jBtnExcluir, jjm_jBtnPesquisar, jjm_jBtnIncluir);
jjm_jTxtCodigo.grabFocus();
        incluir = true;

      
          Util.limpar(  jjm_jTxtCodigo, jjm_jTxtNome, jjm_jFmtDatadenascimento, jjm_jTxtCidade, 
        jjm_jTxtFormadepagamento, jjm_jFmtDatadaultimacompra, jjm_jTxtEmail, 
        jjm_jTxtRg, jjm_jTxtBairro, jjm_jTxtSexo, jjm_jTxtTipodecliente, 
        jjm_jTxtCep, jjm_jTxtTelefone, jjm_jTxtEndereco, jjm_jTxtEstado);
       
    }//GEN-LAST:event_jjm_jBtnIncluirActionPerformed

    private void jjm_jCBoxAtivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jjm_jCBoxAtivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jjm_jCBoxAtivoActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Jjm_JDlgClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Jjm_JDlgClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Jjm_JDlgClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Jjm_JDlgClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Jjm_JDlgClientes dialog = new Jjm_JDlgClientes(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLblRg;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLblBairro;
    private javax.swing.JLabel jLblCep;
    private javax.swing.JLabel jLblCidade;
    private javax.swing.JLabel jLblCodigo;
    private javax.swing.JLabel jLblDataDaUltimaCompra;
    private javax.swing.JLabel jLblDatadenascimento;
    private javax.swing.JLabel jLblEmail;
    private javax.swing.JLabel jLblEndereco;
    private javax.swing.JLabel jLblEstado;
    private javax.swing.JLabel jLblFormadepagamento;
    private javax.swing.JLabel jLblNome;
    private javax.swing.JLabel jLblSexo;
    private javax.swing.JLabel jLblTelefone;
    private javax.swing.JLabel jLblTipodecliente;
    private javax.swing.JButton jjm_jBtnAlterar;
    private javax.swing.JButton jjm_jBtnCancelar;
    private javax.swing.JButton jjm_jBtnConfirmar;
    private javax.swing.JButton jjm_jBtnExcluir;
    private javax.swing.JButton jjm_jBtnIncluir;
    private javax.swing.JButton jjm_jBtnPesquisar;
    private javax.swing.JCheckBox jjm_jCBoxAtivo;
    private javax.swing.JFormattedTextField jjm_jFmtDatadaultimacompra;
    private javax.swing.JFormattedTextField jjm_jFmtDatadenascimento;
    private javax.swing.JLabel jjm_jLblAtivo;
    private javax.swing.JTextField jjm_jTxtBairro;
    private javax.swing.JTextField jjm_jTxtCep;
    private javax.swing.JTextField jjm_jTxtCidade;
    private javax.swing.JTextField jjm_jTxtCodigo;
    private javax.swing.JTextField jjm_jTxtEmail;
    private javax.swing.JTextField jjm_jTxtEndereco;
    private javax.swing.JTextField jjm_jTxtEstado;
    private javax.swing.JTextField jjm_jTxtFormadepagamento;
    private javax.swing.JTextField jjm_jTxtNome;
    private javax.swing.JTextField jjm_jTxtRg;
    private javax.swing.JTextField jjm_jTxtSexo;
    private javax.swing.JTextField jjm_jTxtTelefone;
    private javax.swing.JTextField jjm_jTxtTipodecliente;
    // End of variables declaration//GEN-END:variables
}
