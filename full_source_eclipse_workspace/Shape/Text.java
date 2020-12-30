import java.awt.Font;
import java.awt.Graphics2D;

public class Text extends Shape{
	private Font f = new Font("Dialog", Font.PLAIN, PropertiesBar.getStroke()*10);
	private String text=PropertiesBar.getText().getText();
	@Override
	public boolean IsOnThisShape(int x, int y) {
		// TODO Auto-generated method stub
		if(x<getxLocation()-20||x>getxLocation()+5*getStroke()*text.length())
			return false;
		if(y<getyLocation()-100||y>getyLocation()+5*getStroke())
			return false;
		
		return true;
	}
	
	@Override
	public void Draw(Graphics2D g) {
		// TODO Auto-generated method stub
		g.setFont(f);
		g.setColor(this.getColor());
		g.drawString(text, getxLocation(), getyLocation());
	}

}
