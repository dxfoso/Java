public enum Kartenfarbe {	
	    Karo((byte)0 , "Karo"),  Herz((byte)1, "Herz"),  Pik((byte)2, "Pik"),  Kreuz((byte)3, "Kreuz");
	    //fur jede farbe hat ( value =0 .... , name = Karo ....) 
	    //private variable
	    private final byte value;
	    private final String name;
	    private Kartenfarbe(byte Value , String Name) {
	        this.value = Value;
	        this.name = Name;
	    }
	    public byte getValue() {
	        return value;
	    }
	    @Override
	    public String toString() { 
	        return name; 
	    } 
	    
}