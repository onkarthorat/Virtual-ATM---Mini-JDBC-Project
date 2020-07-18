package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class seq{

	/*public static void main(String[] args) throws Exception {
		//	First f = new First();
		//	f.First();
		creatable();
		//post();
		get();
	}*/
	public static void post() throws Exception
	{
		final int cardno = 7001;
		final int p1 = 4589;
		final String var1 = "Rachel";
		final float b = 21000;
		try {
			Connection con = getConnection();
			PreparedStatement posted = con.prepareStatement("INSERT INTO customerinfo VALUES ('"+cardno+"','"+p1+"', '"+var1+"','"+b+"' )");
			posted.executeUpdate();
			//PreparedStatement posted = con.prepareStatement("INSERT INTO customer(card)VALUES ('"+v1+"')");
			//posted.executeUpdate();
		}catch(Exception e) {System.out.println(e);}
		finally {System.out.println("Insert done");}
	}
	public static void creatable() throws Exception
	{
		try {
			Connection con = getConnection();
			PreparedStatement create = con.prepareStatement("CREATE TABLE IF NOT EXISTS customerinfo(cards int , pin int, name varchar(20) , balance decimal(7,2), PRIMARY KEY(cards))");
			create.executeUpdate();
		}catch(Exception e) {System.out.println(e);}
		finally{System.out.println("function complete");}
	}
		public static Connection getConnection() throws Exception
		{
			try
			{
				String driver = "com.mysql.jdbc.Driver";
				String url = "jdbc:mysql://localhost:3306/onkar";
				String username = "root";
				String password = "onkar24";
				Class.forName(driver);
				
				Connection conn = DriverManager.getConnection(url,username,password);
				System.out.println("Connected");
				return conn;
			} catch(Exception e) {System.out.println(e);}
			
			
			
			return null;
		}
		
		public static ArrayList<String> get() throws Exception
		{
			try {
				Connection con = getConnection();
	PreparedStatement statement = con.prepareStatement("SELECT cards FROM customerinfo");
				ResultSet result = statement.executeQuery();
				ArrayList<String> array = new ArrayList<String>();
				while(result.next()) {
					System.out.println(result.getString("cards"));
					
				array.add(result.getString("cards"));
					
				}
				System.out.println("All records selected");
				return array;
			}
			catch(Exception e) {System.out.println(e);}
			return null;
		}
		public static boolean getpin(String cd, String p) throws Exception
		{
	
			String us1 = "";
			String us2 = "";
			
			
			try {
				Connection con = getConnection();
				PreparedStatement sta = con.prepareStatement("SELECT * FROM customerinfo WHERE cards='"+cd+"'&& pin= '"+p+"'" );
				ResultSet results = sta.executeQuery();
				while(results.next())
				{
					us1 = results.getString("cards");
					us2 = results.getString("pin");
				}

			
				if(cd.equals(us1) && p.equals(us2))
				{
					return true;
				}
			}catch(Exception e) {System.out.println(e);}
			finally{System.out.println("function complete");}
			return false;
		}
		
		public static boolean getbal(String cd, String pro) throws Exception
		{
	
			String u1 = "";
			float u2 = 0;
			System.out.println(cd);
			System.out.println(pro);
			
			
			
			try {
				Connection con = getConnection();
				PreparedStatement stac = con.prepareStatement("SELECT * FROM customerinfo WHERE cards='"+cd+"'" );
				ResultSet resul = stac.executeQuery();
				System.out.println(stac);
				while(resul.next())
				{
					u1 = resul.getString("cards");
					u2 = resul.getFloat("balance");
					System.out.println(u2);
					System.out.println(u1);
				}
		
			float gpro = Float.parseFloat(pro);
		
				if( u2 >= gpro)
				{
					return true;
				}
			}catch(Exception e) {System.out.println(e);}
			finally{System.out.println("function complete");}
			return false;
		
		}
		public static float getb(String cd) throws Exception
		{
			float b = 0;
			try {
				Connection con = getConnection();
				PreparedStatement statement = con.prepareStatement("SELECT * FROM customerinfo WHERE cards = '"+cd+"'");
				ResultSet result = statement.executeQuery();
				
				while(result.next()) {
					b = result.getFloat("balance");
					
				}
				System.out.println(b);
			
				return b;
			}
			catch(Exception e) {System.out.println(e);}
			return 0;
		
		}
		public static void update(String cd, float bal) throws Exception
		{
		
			try {
				Connection con = getConnection();
				PreparedStatement statement = con.prepareStatement("UPDATE customerinfo SET balance = '"+bal+"' WHERE cards='"+cd+"'");
				int result = statement.executeUpdate();
				
				
 
			}
			catch(Exception e) {System.out.println(e);}
		}

		public static String getn(String cd) throws Exception
		{
			String n="";
			System.out.println(cd);
			
			try {
				Connection con = getConnection();
				PreparedStatement statement = con.prepareStatement("SELECT * FROM customerinfo WHERE cards = '"+cd+"'");
				ResultSet result = statement.executeQuery();
				
				while(result.next()) {
					n = result.getString("name");
					
				}
				System.out.println(n);
			
				return n;
			}
			catch(Exception e) {System.out.println(e);}
			return null;
		
		
		
		}
		public static boolean getpinw(String cd, String po) throws Exception
		{
	
			String u1 = "";
		
					
			try {
				Connection con = getConnection();
				PreparedStatement stac = con.prepareStatement("SELECT * FROM customerinfo WHERE cards='"+cd+"'" );
				ResultSet resul = stac.executeQuery();
				System.out.println(stac);
				while(resul.next())
				{
					u1 = resul.getString("pin");
				
				}
		
				if(u1.contentEquals(po))
				{
					return true;
				}
			}catch(Exception e) {System.out.println(e);}
			finally{System.out.println("function complete");}
			return false;
		
		}
		public static void updatep(String cd, String pi) throws Exception
		{
		
			try {
				Connection con = getConnection();
				PreparedStatement statement = con.prepareStatement("UPDATE customerinfo SET pin = '"+pi+"' WHERE cards='"+cd+"'");
				int result = statement.executeUpdate();
				
				
 
			}
			catch(Exception e) {System.out.println(e);}
		}
		public static void updatet() throws Exception
		{
		
			try {
				Connection con = getConnection();
				PreparedStatement statement = con.prepareStatement("ALTER TABLE customerinfo ADD acc_no int");
				int result = statement.executeUpdate();
				
				
 
			}
			catch(Exception e) {System.out.println(e);}
		}
		public static void posta() throws Exception
		{
			//final int cardno = 7001;
			//final int p1 = 4589;
			//final String var1 = "Rachel";
			//final float b = 21000;
			final int acc = 6756;
			try {
				Connection con = getConnection();
				PreparedStatement posted = con.prepareStatement("UPDATE customerinfo SET acc_no='"+acc+"' WHERE cards = 7001");
				posted.executeUpdate();
				//PreparedStatement posted = con.prepareStatement("INSERT INTO customer(card)VALUES ('"+v1+"')");
				//posted.executeUpdate();
			}catch(Exception e) {System.out.println(e);}
			finally {System.out.println("Insert done");}
		
		}
		public static float getbb(String cd) throws Exception
		{
			float b = 0;
			try {
				Connection con = getConnection();
				PreparedStatement statement = con.prepareStatement("SELECT * FROM customerinfo WHERE acc_no = '"+cd+"'");
				ResultSet result = statement.executeQuery();
				
				while(result.next()) {
					b = result.getFloat("balance");
					
				}
				System.out.println(b);
			
				return b;
			}
			catch(Exception e) {System.out.println(e);}
			return 0;
		
		}
		public static void updateu(String cd, float bal) throws Exception
		{
		
			try {
				Connection con = getConnection();
				PreparedStatement statement = con.prepareStatement("UPDATE customerinfo SET balance = '"+bal+"' WHERE acc_no='"+cd+"'");
				int result = statement.executeUpdate();
				
				
 
			}
			catch(Exception e) {System.out.println(e);}
		}
		public static String getnwa(String cd) throws Exception
		{
			String n="";
			System.out.println(cd);
			
			try {
				Connection con = getConnection();
				PreparedStatement statement = con.prepareStatement("SELECT * FROM customerinfo WHERE acc_no = '"+cd+"'");
				ResultSet result = statement.executeQuery();
				
				while(result.next()) {
					n = result.getString("name");
					
				}
				System.out.println(n);
			
				return n;
			}
			catch(Exception e) {System.out.println(e);}
			return null;}}
