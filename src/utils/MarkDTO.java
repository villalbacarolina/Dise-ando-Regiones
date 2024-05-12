package utils;

public class MarkDTO {
	String _name;
	Integer _id;
	
	public MarkDTO(String name, int id){
		_name = name;
		_id = id;
	}
	
	public String name() {
		return _name;
	}
	
	public int id() {
		return _id;
	}
}
