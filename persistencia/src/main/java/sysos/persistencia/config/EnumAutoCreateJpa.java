package sysos.persistencia.config;

public enum EnumAutoCreateJpa {
	
    VALIDATE ("validate"),
    UPDATE ("update"),
    CREATE ("create"),
    CREATE_DROP ("create-drop");
    
    private EnumAutoCreateJpa(String valor) {
            this.valor = valor;
    }

    private String valor;
    
    public String getValor() {
    	return valor;
    }

}
