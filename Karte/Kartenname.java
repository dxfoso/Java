//enum fur Kartenname 
public enum Kartenname {	
	 zwei((byte)0,"zwei") ,  drei((byte)1,"drei") , vier((byte)2,"vier") , fünf((byte)3,"fünf") , 	
    sechs((byte)4,"sechs") ,  sieben((byte)5,"sieben"), acht ((byte)6,"acht"),neun((byte)7,"neun"),zehn((byte)8,"zehn") ,
    Bube((byte)9,"Bube"), Dame((byte)10,"Dame"), König((byte)11,"König"), Ass((byte)12,"Ass") ;
	
	//private variable
    private final byte value;
    private final String name;
    
    //Konstrukteur
    private Kartenname(byte Value, String Name) {
        this.value = Value;
        this.name= Name;
    }
    //Kartennummer erhalten
    public byte getValue() {
        return value;
    }
    @Override
    public String toString() { 
        return name; 
    } 
}
