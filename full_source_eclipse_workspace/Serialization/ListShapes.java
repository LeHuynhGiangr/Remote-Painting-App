import java.io.Serializable;
import java.util.List;

public class ListShapes implements Serializable{
	
	private List<Shape> shapes;
	public List<Shape> getShapes() {
		return shapes;
	}
	public void setShapes(List<Shape> shapes) {
		this.shapes = shapes;
	}
	
	private String str="";
	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}
	
}
