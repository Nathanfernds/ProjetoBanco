package Funtec.ProjetoBanco.model;

public enum ClienteSetor {
    TECNOLOGIA("tecnologia"), 
    RH("rh"), 
    DIRETORIA("diretoria");

    private String value;

    private ClienteSetor(String value) {
        this.value = value;
    }

    public String getSetor() {
        return value;
    }

}