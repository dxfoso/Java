public class Karte implements IKarte{
	private Kartenfarbe _farbe;
	private Kartenname _name;
	//Konstrukteur mit hashCode
	public Karte (int hashCode ) {
	   
		byte f =(byte)( hashCode /13);
		byte n = (byte)( hashCode %13)  ;

		_farbe =  Kartenfarbe.values()[f] ;
		 _name =  Kartenname.values()[n];
		  
	}
    //Konstrukteur mit Karten farbe und Karten name
	public Karte (Kartenfarbe f , Kartenname n ) {
		_farbe = f;
		_name = n;		
	}
	//karten farbe erhalten
	public Kartenfarbe farbe( ) {
		return _farbe;
	}
	//karten name erhalten
	public Kartenname name(){
		return _name;
	} 
	//hashCode erhalten
	public int hashCode() {
		return (_name.getValue() ) +  (_farbe.getValue() * 13 )  ;		
	}
    @Override
    public String toString() { 
        return String.format(_name.toString() +" " + _farbe.toString()); 
    } 
}
