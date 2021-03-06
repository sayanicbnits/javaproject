package com.cbnits.CBNITS_TRADE.ServicePackage;

import java.util.List;

import java.util.Map;
import java.util.UUID;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.springframework.web.multipart.MultipartFile;

import com.cbnits.CBNITS_TRADE.UsersPackage.Users;

//import com.cbnits.CBNITS_TRADE.EntityPackage.EntityClass;

public interface ServiceInterface {
	public int result();
	public byte[] getNextSalt();	
	public byte[] hash(char[] password, byte[] salt);
	public String getMd5(String input);
	//public void update1(String user_id, String hashedpassst, String s);
	public Map<String, String> authenticate(String user, String pass);
	//public void update1(String user_id, byte[] hashedpass, byte[] salt);
	public void update1(String user_id, String md5pass, String salt);
//	public void update2(String pass, String hash_pass, String salt, String act_dir, int auth, String email,
//			String fname, String lname, String region);
//	public void update2(UUID user_id, String pass, String hash_pass, String valueOf, String act_dir, int auth,
//			String email, String fname, String lname, String region);
	public void insert(UUID salesorg,String fname, String lname, String email_id, String region, String active_directory, int authrole,String hash_pass ,String s);
//	public UUID insert1(String country, String currency, int plants, String bergu, String sales_organisation);
	public  Map <String,Object> fetch(UUID user_id,String password, UUID sales_orgs);
//	String check(String username, String password);
	public List<Users> userList();
	public void createCell(Row row, int columnCount, Object value, CellStyle style);
	public void save(MultipartFile file);
	public void insert1(UUID id, UUID sales_org, String fname, String lname, String email_id, String region,
			String active_directory, int authrole, String pass, String s);
	
	
}
