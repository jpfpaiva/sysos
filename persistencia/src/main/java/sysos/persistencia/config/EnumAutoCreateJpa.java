package sysos.persistencia.config;

public enum EnumAutoCreateJpa {
	
    VALIDATE ("validate"),
    UPDATE ("update"),
    CREATE ("create"),
    CREATE_DROP ("create-drop");
    
    private EnumAutoCreateJpa(String descricao) {
            this.descricao = descricao;
    }

    private String descricao;
    
    public String getDescricao() {
            return descricao;
    }

}
