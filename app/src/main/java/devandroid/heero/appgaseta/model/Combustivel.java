package devandroid.heero.appgaseta.model;

import java.util.Date;

public class Combustivel {

    private Integer id;
    private String nomeCombustivel;
    private Double precoCombustivel;
    private Date dataAtualizacao;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeCombustivel() {
        return nomeCombustivel;
    }

    public void setNomeCombustivel(String nomeCombustivel) {
        this.nomeCombustivel = nomeCombustivel;
    }

    public Double getPrecoCombustivel() {
        return precoCombustivel;
    }

    public void setPrecoCombustivel(Double precoCombustivel) {
        this.precoCombustivel = precoCombustivel;
    }

    public Date getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Date dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
}
