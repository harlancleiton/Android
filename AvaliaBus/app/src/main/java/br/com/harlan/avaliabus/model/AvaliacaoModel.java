package br.com.harlan.avaliabus.model;

import com.google.firebase.database.DatabaseReference;

import br.com.harlan.avaliabus.database.FirebaseSingleton;

public class AvaliacaoModel {

    private String id;
    private String idUsuario;
    private String dataHora;
    private String observacoes;
    private int numeroOnibus;
    private int numeroLinha;
    //Ratingbar
    private float notaOnibus;
    private float notaMotorista;
    private float notaSeguranca;
    private float notaLinha;
    //Checkbox
    private boolean onibusSujo;
    private boolean janelaDanificada;
    private boolean assentoQuebrado;
    private boolean lampadaNaoAcende;
    private boolean motoristaNaoParou;
    private boolean motoristaCelular;
    private boolean motoristaFreouBruscamente;
    private boolean motoristaVelocidade;
    private boolean onibusAssaltado;
    private boolean atosVandalismo;
    private boolean brigasOnibus;
    private boolean onibusQuebrou;
    private boolean percursoLongo;
    private boolean areasAriscadas;
    private boolean onibusLinhaAssaltados;

    public AvaliacaoModel(){}

    public int getNumeroOnibus() {
        return numeroOnibus;
    }

    public void setNumeroOnibus(int numeroOnibus) {
        this.numeroOnibus = numeroOnibus;
    }

    public int getNumeroLinha() {
        return numeroLinha;
    }

    public void setNumeroLinha(int numeroLinha) {
        this.numeroLinha = numeroLinha;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getDataHora() {
        return dataHora;
    }

    public void setDataHora(String dataHora) {
        this.dataHora = dataHora;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public float getNotaOnibus() {
        return notaOnibus;
    }

    public void setNotaOnibus(float notaOnibus) {
        this.notaOnibus = notaOnibus;
    }

    public float getNotaMotorista() {
        return notaMotorista;
    }

    public void setNotaMotorista(float notaMotorista) {
        this.notaMotorista = notaMotorista;
    }

    public float getNotaSeguranca() {
        return notaSeguranca;
    }

    public void setNotaSeguranca(float notaSeguranca) {
        this.notaSeguranca = notaSeguranca;
    }

    public float getNotaLinha() {
        return notaLinha;
    }

    public void setNotaLinha(float notaLinha) {
        this.notaLinha = notaLinha;
    }

    public boolean isOnibusSujo() {
        return onibusSujo;
    }

    public void setOnibusSujo(boolean onibusSujo) {
        this.onibusSujo = onibusSujo;
    }

    public boolean isJanelaDanificada() {
        return janelaDanificada;
    }

    public void setJanelaDanificada(boolean janelaDanificada) {
        this.janelaDanificada = janelaDanificada;
    }

    public boolean isAssentoQuebrado() {
        return assentoQuebrado;
    }

    public void setAssentoQuebrado(boolean assentoQuebrado) {
        this.assentoQuebrado = assentoQuebrado;
    }

    public boolean isLampadaNaoAcende() {
        return lampadaNaoAcende;
    }

    public void setLampadaNaoAcende(boolean lampadaNaoAcende) {
        this.lampadaNaoAcende = lampadaNaoAcende;
    }

    public boolean isMotoristaNaoParou() {
        return motoristaNaoParou;
    }

    public void setMotoristaNaoParou(boolean motoristaNaoParou) {
        this.motoristaNaoParou = motoristaNaoParou;
    }

    public boolean isMotoristaCelular() {
        return motoristaCelular;
    }

    public void setMotoristaCelular(boolean motoristaCelular) {
        this.motoristaCelular = motoristaCelular;
    }

    public boolean isMotoristaFreouBruscamente() {
        return motoristaFreouBruscamente;
    }

    public void setMotoristaFreouBruscamente(boolean motoristaFreouBruscamente) {
        this.motoristaFreouBruscamente = motoristaFreouBruscamente;
    }

    public boolean isMotoristaVelocidade() {
        return motoristaVelocidade;
    }

    public void setMotoristaVelocidade(boolean motoristaVelocidade) {
        this.motoristaVelocidade = motoristaVelocidade;
    }

    public boolean isOnibusAssaltado() {
        return onibusAssaltado;
    }

    public void setOnibusAssaltado(boolean onibusAssaltado) {
        this.onibusAssaltado = onibusAssaltado;
    }

    public boolean isAtosVandalismo() {
        return atosVandalismo;
    }

    public void setAtosVandalismo(boolean atosVandalismo) {
        this.atosVandalismo = atosVandalismo;
    }

    public boolean isBrigasOnibus() {
        return brigasOnibus;
    }

    public void setBrigasOnibus(boolean brigasOnibus) {
        this.brigasOnibus = brigasOnibus;
    }

    public boolean isOnibusQuebrou() {
        return onibusQuebrou;
    }

    public void setOnibusQuebrou(boolean onibusQuebrou) {
        this.onibusQuebrou = onibusQuebrou;
    }

    public boolean isPercursoLongo() {
        return percursoLongo;
    }

    public void setPercursoLongo(boolean percursoLongo) {
        this.percursoLongo = percursoLongo;
    }

    public boolean isAreasAriscadas() {
        return areasAriscadas;
    }

    public void setAreasAriscadas(boolean areasAriscadas) {
        this.areasAriscadas = areasAriscadas;
    }

    public boolean isOnibusLinhaAssaltados() {
        return onibusLinhaAssaltados;
    }

    public void setOnibusLinhaAssaltados(boolean onibusLinhaAssaltados) {
        this.onibusLinhaAssaltados = onibusLinhaAssaltados;
    }

    public void salvarAvaliacaoFirebase() {
        DatabaseReference databaseReference = FirebaseSingleton.getDatabaseReference();
        databaseReference.child("avaliacoes").child(getIdUsuario()).child(getId()).setValue(this);
    }
}
