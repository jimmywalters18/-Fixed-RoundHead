import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.Timer;

public class WalkingManFrame extends JFrame implements ActionListener
{
	int direction = 0; 
	int direction1 = 0;
	private Man man;
	private Man dog;
	private wall w;
	private ArrayList<Man> men = new ArrayList<Man>();
	public ArrayList<Projectile> mp = new ArrayList<Projectile>();
	public ArrayList<Projectile> dp = new ArrayList<Projectile>();
	private boolean gameState = true;
	public ArrayList<wall> wa = new ArrayList<wall>();
	public ArrayList<wall2> wa2 = new ArrayList<wall2>();
	private Map map;
	
	public WalkingManFrame()
	{
		setBounds(100, 100, 1200, 700);
		setLayout(null);
		man = new Man(0, 0, Color.RED);
		dog = new Man(0,0, Color.BLUE);
		men.add(man);
		men.add(dog);
		map = new Map(500,200,Color.BLACK);
		add(map);
		for (int i =0; i<men.size(); i++)
		{
			add(men.get(i));
		}
		setVisible(true);
		Timer timer = new Timer(10, this);
		timer.start();
		addKeyListener(new KeyListener()
				{
					public void keyPressed(KeyEvent e)
					{
						if(e.getKeyCode() == e.VK_W)
						{
							man.setDY(-2);
							direction = 1;
						}
						if(e.getKeyCode() == e.VK_A)
						{
							man.setDX(-2);
							direction = 2;
						}
						if(e.getKeyCode() == e.VK_S)
						{
							man.setDY(2);
							direction = 3;
						}
						if(e.getKeyCode() == e.VK_D)
						{
							man.setDX(2);
							direction = 4;
						}
						if(e.getKeyCode() == e.VK_SPACE)
						{
							switch (direction) 
							{
							case 1:
								
								Projectile bb = new Projectile(man.getX(), man.getY(), 0,-5, 5, "Pistol");
								mp.add(bb);
								add(bb);
								break;
							case 2: 
								Projectile bb1 = new Projectile(man.getX(), man.getY(), -5, 0, 5, "Pistol");
								mp.add(bb1);
								add(bb1);
								break;
							case 3:
						
								Projectile bb2 = new Projectile(man.getX(), man.getY(), 0, 5, 5, "Pistol");
								mp.add(bb2);
								add(bb2);
								break;
							case 4: 
								
								Projectile bb3 = new Projectile(man.getX(), man.getY(), 5, 0, 5, "Pistol");
								mp.add(bb3);
								add(bb3);
								break;
							}
						}
						if(e.getKeyCode() == e.VK_E)
						{
							switch (direction) 
							{
							case 1:
								
								wall2 bb = new wall2(man.getX()-15, man.getY()-20, Color.RED);
								wa2.add(bb);
								add(bb);
								break;
							case 2: 
							
								wall bb1 = new wall(man.getX()-20, man.getY()-15, Color.RED);
								wa.add(bb1);
								add(bb1);
								break;
							case 3:
						
								wall2 bb2 = new wall2(man.getX()-15, man.getY()+20, Color.RED);
								wa2.add(bb2);
								add(bb2);
								break;
							case 4: 
								wall bb3 = new wall(man.getX()+35, man.getY()-15, Color.RED);
								wa.add(bb3);
								add(bb3);
								break;
								
							
							}
						}
						if(e.getKeyCode() == e.VK_O)
						{
							switch (direction1) 
							{
							case 1:
								
								wall2 bb = new wall2(dog.getX()-15, dog.getY()-20, Color.BLUE);
								wa2.add(bb);
								add(bb);
								break;
							case 2: 
							
								wall bb1 = new wall(dog.getX()-20, dog.getY()-15, Color.BLUE);
								wa.add(bb1);
								add(bb1);
								break;
							case 3:
						
								wall2 bb2 = new wall2(dog.getX()-15, dog.getY()+20, Color.BLUE);
								wa2.add(bb2);
								add(bb2);
								break;
							case 4: 
								wall bb3 = new wall(dog.getX()+35, dog.getY()-15, Color.BLUE);
								wa.add(bb3);
								add(bb3);
								break;
								
							
							}
						}
					}
					public void keyReleased(KeyEvent e)
					{
						if(e.getKeyCode() == e.VK_W)
						{
							man.setDY(0);
							
						}
						if(e.getKeyCode() == e.VK_A)
						{
							man.setDX(0);
						}
						if(e.getKeyCode() == e.VK_S)
						{
							man.setDY(0);
						}
						if(e.getKeyCode() == e.VK_D)
						{
							man.setDX(0);
						}
					}
					public void keyTyped(KeyEvent e)
					{
					}
					
				});
	addKeyListener(new KeyListener()
		{
			public void keyPressed(KeyEvent r)
			{
				if(r.getKeyCode() == r.VK_I)
				{
					dog.setDY(-2);
					direction1 = 1;
				}
				if(r.getKeyCode() == r.VK_J)
				{
					dog.setDX(-2);
					direction1 = 2;
				}
				if(r.getKeyCode() == r.VK_K)
				{
					dog.setDY(2);
					direction1 = 3;
				}
				if(r.getKeyCode() == r.VK_L)
				{
					dog.setDX(2);
					direction1 = 4;
				}
				if(r.getKeyCode() == r.VK_M)
				{
					switch (direction1) 
					{
					case 1:
						
						Projectile bb = new Projectile(dog.getX(), dog.getY(), 0,-5, 5, "Pistol");
						dp.add(bb);
						add(bb);
						break;
					case 2: 
					
						Projectile bb1 = new Projectile(dog.getX(), dog.getY(), -5, 0, 5, "Pistol");
						dp.add(bb1);
						add(bb1);
						break;
					case 3:
						
						Projectile bb2 = new Projectile(dog.getX(), dog.getY(), 0, 5, 5, "Pistol");
						dp.add(bb2);
						add(bb2);
						break;
					case 4: 
						
						Projectile bb3 = new Projectile(dog.getX(), dog.getY(), 5, 0, 5, "Pistol");
						dp.add(bb3);
						add(bb3);
						break;
						
					
					}
				}
				
			}
			public void keyReleased(KeyEvent r)
			{
				if(r.getKeyCode() == r.VK_I)
				{
					dog.setDY(0);
					
				}
				if(r.getKeyCode() == r.VK_J)
				{
					dog.setDX(0);
				}
				if(r.getKeyCode() == r.VK_K)
				{
					dog.setDY(0);
				}
				if(r.getKeyCode() == r.VK_L)
				{
					dog.setDX(0);
				}
			}
			public void keyTyped(KeyEvent r)
			{
			}
			
		});
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e)
	{
		System.out.println("man: " + man.getHealth());
		System.out.println("dog: " + dog.getHealth());
		if (gameState) 
		{	
			for (int i = 0; i<men.size(); i++)
				{
					if (men.get(i).getX() + men.get(i).getDX() >= this.getWidth() || men.get(i).getX() + men.get(i).getDX() <= 0)
					{
						men.get(i).setDX(0);
					}
					if (men.get(i).getY() + men.get(i).getDY() >= this.getHeight() || men.get(i).getY() + men.get(i).getDY() <= 0)
					{
						men.get(i).setDY(0);
					}
					men.get(i).update();
				}
			for(int i = 0; i < dp.size(); i++)
			{
				dp.get(i).update();
				if (dp.get(i).getX() == man.getX() || dp.get(i).getY() == man.getY()) {
					man.setHealth(man.getHealth() - 5);
					this.remove(dp.get(i));
					dp.remove(i);
				}
				if (man.getHealth() == 0 || dog.getHealth() == 0) gameState = false;
				if (dp.size() != 0 && mp.size() < i && dp.get(i) != null) {
					if(dp.get(i).getX() > this.getWidth() || dp.get(i).getX() < 0 || dp.get(i).getY() < 0 || dp.get(i).getY() > this.getHeight())
						{
							if (dp.get(i) != null) {
								this.remove(dp.get(i));
								dp.remove(i);
							}
						}
				}
			}
			for (int j = 0; j< mp.size(); j++) 
			{
				if (mp.get(j).getX() > 500 && mp.get(j).getY() > 200 && mp.get(j).getX() < 575 && mp.get(j).getY() < 476)
				{
					mp.remove(j);
				}
			}
			
			for (int j = 0; j< dp.size(); j++) 
			{
				if (dp.get(j).getX() > 500 && dp.get(j).getY() > 200 && dp.get(j).getX() < 575 && dp.get(j).getY() < 476)
				{
					dp.remove(j);
				}
			}
		}
			for(int i = 0; i < mp.size(); i++)
			{
				mp.get(i).update();
				if (mp.get(i).getX() == dog.getX() || mp.get(i).getY() == dog.getY()) {
					dog.setHealth(dog.getHealth() - 5);
					this.remove(mp.get(i));
					mp.remove(i);
				}
				if (man.getHealth() == 0 || dog.getHealth() == 0) gameState = false;
				if (mp.size() != 0 && mp.size() < i && mp.get(i) != null) {	
					if(mp.get(i).getX() > this.getWidth() || mp.get(i).getX() < 0 || mp.get(i).getY() < 0 || mp.get(i).getY() > this.getHeight())
						{
							this.remove(mp.get(i));
							mp.remove(i);
						}
				}
			}
			repaint();
		}
	
	public static void main(String[] args)
	{
		new WalkingManFrame();
		
	}
}