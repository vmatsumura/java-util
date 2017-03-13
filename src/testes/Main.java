package testes;
/**
 * @author tvm108436
 *
 */
class Main {
	
	public static void main (String[] args){
		try{		
			
			DataHora dataHora = new DataHora();			
			System.out.println(dataHora.getDate()); //NOW
			
			dataHora.setWithFormat("2017-03-07T16:08:00-02:00", "yyyy-MM-dd'T'HH:mm:ss");
			System.out.println(dataHora.getDate()); 
			
			dataHora.setWithFormat("2017-03-07T16:08:00-02:00", "yyyy-MM-dd'T'HH:mm:ss", "GMT-3");			
			System.out.println(dataHora.getDate());
			
			dataHora.setWithFormat("2017-03-07T16:08:00", "yyyy-MM-dd'T'HH:mm:ss", "GMT-3", true);			
			System.out.println(dataHora.getDate());
			
			System.out.println(dataHora.getDateWithFormat("dd/MM/yyyy HH:mm:ss"));
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
	}	
}
