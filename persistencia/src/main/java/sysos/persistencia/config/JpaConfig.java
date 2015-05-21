package sysos.persistencia.config;



public class JpaConfig {
	
	 private EnumJpaDialect dialect;
     
     private boolean formatSQL;
     
     private boolean showSQL;
     
     private boolean gerarDDL;
     
     private String [] pacoteRaizEntidades;
     
     private EnumAutoCreateJpa autoCreate;

     public String getDialect() {
             return dialect.getValor();
     }

     public void setDialect(EnumJpaDialect dialect) {
             this.dialect = dialect;
     }

     public boolean isFormatSQL() {
             return formatSQL;
     }

     public void setFormatSQL(boolean formatSQL) {
             this.formatSQL = formatSQL;
     }

     public boolean isShowSQL() {
             return showSQL;
     }

     public void setShowSQL(boolean showSQL) {
             this.showSQL = showSQL;
     }

     public String getAutoCreate() {
             return autoCreate.getValor();
     }

     public void setAutoCreate(EnumAutoCreateJpa enumAutoCreateJpa) {
             this.autoCreate = enumAutoCreateJpa;
     }

     public boolean isGerarDDL() {
             return gerarDDL;
     }

     public void setGerarDDL(boolean gerarDDL) {
             this.gerarDDL = gerarDDL;
     }

     public String [] getPacoteRaizEntidades() {
             return pacoteRaizEntidades;
     }

     public void setPacoteRaizEntidades(String ... pacoteRaizEntidades) {
             this.pacoteRaizEntidades = pacoteRaizEntidades;
     }

}
