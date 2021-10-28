package com.example.abnerlucss.msvembarque.DTO;

public class MediaEmbarquesDTO {
    private Integer domingo;
    private Integer segundaFeira;
    private Integer tercaFeira;
    private Integer quartaFeira;
    private Integer quintaFeira;
    private Integer sextaFeira;
    private Integer sabado;

    public MediaEmbarquesDTO(Integer domingo, Integer segundaFeira, Integer tercaFeira, Integer quartaFeira, Integer quintaFeira, Integer sextaFeira, Integer sabado) {
        this.domingo = domingo;
        this.segundaFeira = segundaFeira;
        this.tercaFeira = tercaFeira;
        this.quartaFeira = quartaFeira;
        this.quintaFeira = quintaFeira;
        this.sextaFeira = sextaFeira;
        this.sabado = sabado;
    }

    public Integer getDomingo() {
        return domingo;
    }

    public void setDomingo(Integer domingo) {
        this.domingo = domingo;
    }

    public Integer getSegundaFeira() {
        return segundaFeira;
    }

    public void setSegundaFeira(Integer segundaFeira) {
        this.segundaFeira = segundaFeira;
    }

    public Integer getTercaFeira() {
        return tercaFeira;
    }

    public void setTercaFeira(Integer tercaFeira) {
        this.tercaFeira = tercaFeira;
    }

    public Integer getQuartaFeira() {
        return quartaFeira;
    }

    public void setQuartaFeira(Integer quartaFeira) {
        this.quartaFeira = quartaFeira;
    }

    public Integer getQuintaFeira() {
        return quintaFeira;
    }

    public void setQuintaFeira(Integer quintaFeira) {
        this.quintaFeira = quintaFeira;
    }

    public Integer getSextaFeira() {
        return sextaFeira;
    }

    public void setSextaFeira(Integer sextaFeira) {
        this.sextaFeira = sextaFeira;
    }

    public Integer getSabado() {
        return sabado;
    }

    public void setSabado(Integer sabado) {
        this.sabado = sabado;
    }
}
