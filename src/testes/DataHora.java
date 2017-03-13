package testes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.TimeZone;

public class DataHora {
	
	// PROPRIEDADES
	Date date;

	// CONSTRUTORES
	public DataHora(){
		this.date = new Date();
	}

	// METODOS
	/**
	 * Atribui à propriedade de data uma nova data em qualquer formato passados como parametro  
	 * @param  sDate String com o valor da data 
	 * @param  sFormat String com o formato da data
	 */
	public void setWithFormat(String sDate, String sFormat) throws ParseException{
						
		this.date = new SimpleDateFormat(sFormat).parse(sDate);		
	}
	
	/**
	 * Atribui à propriedade de data uma nova data em qualquer formato e converte para o TimeZone passados como parametro
	 * <p>
	 * A data será convertida para o TimeZone relativo a data local
	 * @param  sDate String com o valor da data 
	 * @param  sFormat String com o formato da data
 	 * @param  idTimeZone String do ID do TimeZone (GMT-3, por exemplo)
	 */
	public void setWithFormat(String sDate, String sFormat, String idTimeZone) throws ParseException{
		
		SimpleDateFormat sdf = new SimpleDateFormat(sFormat); //yyyy-MM-dd'T'HH:mm:ss		
		sdf.setTimeZone(TimeZone.getTimeZone(idTimeZone));
		
		this.date = sdf.parse(sDate);	
	}
	
	/**
	 * Atribui à propriedade de data uma nova data em qualquer formato e converte para o TimeZone passados como parametro
	 * <p>
	 * A data será convertida para o TimeZone relativo a data global
	 * @param sDate String com o valor da data 
	 * @param sFormat String com o formato da data
 	 * @param idTimeZone String do ID do TimeZone (GMT-3, por exemplo)
 	 * @param isGlobalTime Boolean indicando se sDate é uma data global
	 */	
	public void setWithFormat(String sDate, String sFormat, String idTimeZone, boolean isGlobalTime) throws ParseException{
			
        LocalDateTime ldt = LocalDateTime.parse(sDate, DateTimeFormatter.ofPattern(sFormat));        
        ZonedDateTime globalZonedDateTime = ldt.atZone(ZoneId.of("GMT"));                
        ZonedDateTime nyDateTime = globalZonedDateTime.withZoneSameInstant(ZoneId.of(idTimeZone));
        
        this.date = Date.from(nyDateTime.toInstant());
	}
	
	/**
	 * Retorna a data em qualquer formato passado como paramatro
	 * @param sFormat String com o formato da data
 	 * @return String da data no formato passado como parametro
	 */	
	public String getDateWithFormat(String sFormat){
		
		return new SimpleDateFormat(sFormat).format(this.date);		
	}

	public void getAvailableIDsTimeZones (){
		for (String id : TimeZone.getAvailableIDs()) {
			System.out.println(id);
		}
	}
	
	// GETTERS & SETTERS
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
