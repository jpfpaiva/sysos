package sysos.persistencia.config;

public enum EnumJpaDialect {
	
	POSTGRESQL("org.hibernate.dialect.PostgreSQLDialect"),
	ORACLE("org.hibernate.dialect.Oracle10gDialect"),
	MYSQL("com.mysql.jdbc.Driver");
	
	private EnumJpaDialect(String valor) {
		this.valor = valor;
	}
	
	private String valor;

	public String getValor() {
		return valor;
	}

}
