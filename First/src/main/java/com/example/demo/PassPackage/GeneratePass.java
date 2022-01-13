package com.example.demo.PassPackage;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Random;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class GeneratePass {
	  private static final Random RANDOM = new SecureRandom();
	  private static final int ITERATIONS = 10000;
	  private static final int KEY_LENGTH = 256;
	  
//	generating salt
	  
	  public static byte[] getNextSalt() {
	    byte[] salt = new byte[16];
	    RANDOM.nextBytes(salt);
	    return salt;
	  }
	//generating salted password
	  public static byte[] hash(char[] password, byte[] salt) {
		    PBEKeySpec spec = new PBEKeySpec(password, salt, ITERATIONS, KEY_LENGTH);
		    Arrays.fill(password, Character.MIN_VALUE);
		    try {
		      SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		      return skf.generateSecret(spec).getEncoded();
		    } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
		      throw new AssertionError("Error while hashing a password: " + e.getMessage(), e);
		    } finally {
		      spec.clearPassword();
		    }
		  }
}