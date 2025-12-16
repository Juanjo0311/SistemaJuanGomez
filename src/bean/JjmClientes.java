package bean;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name="jjm_clientes", catalog="db_juan_gomez")
public class JjmClientes implements java.io.Serializable {

    private int jjmIdCliente;
    private String jjmNome;
    private String jjmEmail;
    private String jjmSexo;
    private String jjmTelefone;
    private String jjmEndereco;
    private Date jjmDataNasc;
    private String jjmFormaPagamento;
    private String jjmRg;
    private String jjmTipoCliente;
    private String jjmCep;
    private String jjmEstado;
    private String jjmCidade;
    private Date jjmDataUltimaCompra;
    private String jjmBairro;
    private int jjmAtivo;

    public JjmClientes() {}

    public JjmClientes(String jjmNome, String jjmEmail, String jjmSexo, String jjmTelefone, 
                       String jjmEndereco, Date jjmDataNasc, String jjmFormaPagamento, 
                       String jjmRg, String jjmTipoCliente, String jjmCep, String jjmEstado, 
                       String jjmCidade, Date jjmDataUltimaCompra, String jjmBairro, int jjmAtivo) {
        this.jjmNome = jjmNome;
        this.jjmEmail = jjmEmail;
        this.jjmSexo = jjmSexo;
        this.jjmTelefone = jjmTelefone;
        this.jjmEndereco = jjmEndereco;
        this.jjmDataNasc = jjmDataNasc;
        this.jjmFormaPagamento = jjmFormaPagamento;
        this.jjmRg = jjmRg;
        this.jjmTipoCliente = jjmTipoCliente;
        this.jjmCep = jjmCep;
        this.jjmEstado = jjmEstado;
        this.jjmCidade = jjmCidade;
        this.jjmDataUltimaCompra = jjmDataUltimaCompra;
        this.jjmBairro = jjmBairro;
        this.jjmAtivo = jjmAtivo;
    }

    @Id 
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="jjm_id_cliente", unique=true, nullable=false)
    public Integer getJjmIdCliente() {
        return jjmIdCliente;
    }

    public void setJjmIdCliente(Integer jjmIdCliente) {
        this.jjmIdCliente = jjmIdCliente;
    }

    @Column(name="jjm_nome", length=150)
    public String getJjmNome() {
        return jjmNome;
    }

    public void setJjmNome(String jjmNome) {
        this.jjmNome = jjmNome;
    }

    @Column(name="jjm_email", length=150)
    public String getJjmEmail() {
        return jjmEmail;
    }

    public void setJjmEmail(String jjmEmail) {
        this.jjmEmail = jjmEmail;
    }

    @Column(name="jjm_sexo", length=1)
    public String getJjmSexo() {
        return jjmSexo;
    }

    public void setJjmSexo(String jjmSexo) {
        this.jjmSexo = jjmSexo;
    }

    @Column(name="jjm_telefone", length=16)
    public String getJjmTelefone() {
        return jjmTelefone;
    }

    public void setJjmTelefone(String jjmTelefone) {
        this.jjmTelefone = jjmTelefone;
    }

    @Column(name="jjm_endereco", length=150)
    public String getJjmEndereco() {
        return jjmEndereco;
    }

    public void setJjmEndereco(String jjmEndereco) {
        this.jjmEndereco = jjmEndereco;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="jjm_dataNasc", length=10)
    public Date getJjmDataNasc() {
        return jjmDataNasc;
    }

    public void setJjmDataNasc(Date jjmDataNasc) {
        this.jjmDataNasc = jjmDataNasc;
    }

    @Column(name="jjm_forma_pagamento", length=150)
    public String getJjmFormaPagamento() {
        return jjmFormaPagamento;
    }

    public void setJjmFormaPagamento(String jjmFormaPagamento) {
        this.jjmFormaPagamento = jjmFormaPagamento;
    }

    @Column(name="jjm_rg", length=11)
    public String getJjmRg() {
        return jjmRg;
    }

    public void setJjmRg(String jjmRg) {
        this.jjmRg = jjmRg;
    }

    @Column(name="jjm_tipo_cliente", length=150)
    public String getJjmTipoCliente() {
        return jjmTipoCliente;
    }

    public void setJjmTipoCliente(String jjmTipoCliente) {
        this.jjmTipoCliente = jjmTipoCliente;
    }

    @Column(name="jjm_cep", length=9)
    public String getJjmCep() {
        return jjmCep;
    }

    public void setJjmCep(String jjmCep) {
        this.jjmCep = jjmCep;
    }

    @Column(name="jjm_ativo", length=1)
    public int getJjmAtivo() {
        return jjmAtivo;
    }

    public void setJjmAtivo(int jjmAtivo) {
        this.jjmAtivo = jjmAtivo;
    }

    @Column(name="jjm_estado", length=2)
    public String getJjmEstado() {
        return jjmEstado;
    }

    public void setJjmEstado(String jjmEstado) {
        this.jjmEstado = jjmEstado;
    }

    @Column(name="jjm_cidade", length=150)
    public String getJjmCidade() {
        return jjmCidade;
    }

    public void setJjmCidade(String jjmCidade) {
        this.jjmCidade = jjmCidade;
    }

    @Temporal(TemporalType.DATE)
    @Column(name="jjm_data_ultima_compra", length=10)
    public Date getJjmDataUltimaCompra() {
        return jjmDataUltimaCompra;
    }

    public void setJjmDataUltimaCompra(Date jjmDataUltimaCompra) {
        this.jjmDataUltimaCompra = jjmDataUltimaCompra;
    }

    @Column(name="jjm_bairro", length=55)
    public String getJjmBairro() {
        return jjmBairro;
    }

    public void setJjmBairro(String jjmBairro) {
        this.jjmBairro = jjmBairro;
    }

    @Override
    public String toString() {
        return this.jjmNome;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof JjmClientes) {
            JjmClientes clientes = (JjmClientes) object;
            if (this.getJjmIdCliente() == clientes.getJjmIdCliente()) {
                return true;
            }
        }
        return false;
    }
}
