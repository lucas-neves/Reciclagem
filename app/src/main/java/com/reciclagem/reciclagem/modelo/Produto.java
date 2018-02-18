package com.reciclagem.reciclagem.modelo;

/**
 * Created by lucasn on 14/09/2016.
 */
public class Produto {

    private Integer Id_Produto;
    private String Descricao;
    private float Valor;
    private String Image_Path;

    public Produto(){

    }

    public Produto(int id_Produto, String descricao, float valor, String image_Path){
        this.Id_Produto = id_Produto;
        this.Descricao = descricao;
        this.Valor = valor;
        this.Image_Path = image_Path;
    }

    public Integer getId_Produto() {
        return Id_Produto;
    }

    public void setId_Produto(Integer id_Produto) {
        Id_Produto = id_Produto;
    }

    public String getDescricao() {
        return Descricao;
    }

    public void setDescricao(String descricao) {
        Descricao = descricao;
    }

    public float getValor() {
        return Valor;
    }

    public void setValor(float valor) {
        this.Valor = valor;
    }

    public String getImage_Path() {
        return Image_Path;
    }

    public void setImage_Path(String image_Path) {
        Image_Path = image_Path;
    }
}
