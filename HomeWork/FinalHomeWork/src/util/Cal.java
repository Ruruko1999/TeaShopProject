package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


import controller.AddMemberUI;

public class Cal {
	//切換到註冊業
	public static void gotoAddMember()
	{
		AddMemberUI a=new AddMemberUI();
		a.setVisible(true);
	}
	//存檔
	public static void SaveObject(Object o,String fileName)
	{
		
		try {
			FileOutputStream fos=new FileOutputStream(fileName);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(o);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//讀取檔案/
	public static Object ReadObject(String fileName)
	{
		Object o=null;
		try {
			FileInputStream fis=new FileInputStream(fileName);
			ObjectInputStream ois=new ObjectInputStream(fis);
			o=ois.readObject();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return o;
	}

}
