package kr.co.mlec.project.login.ui;

import javax.crypto.*;

import javax.crypto.spec.*;

import java.io.*;

import sun.misc.BASE64Decoder;

import sun.misc.BASE64Encoder;

 

public class SecretPassword{
	 String originalText = null;
	
	 
	 public String getOriginalText() {
		return originalText;
	}


	public void setOriginalText(String originalText) {
		this.originalText = originalText;
	}

 

    public static String Encrypt(String text) throws Exception {
    	 	 String key = "key";
             Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

             byte[] keyBytes= new byte[16];

             byte[] b= key.getBytes("UTF-8");

             int len= b.length;

             if (len > keyBytes.length) len = keyBytes.length;

             System.arraycopy(b, 0, keyBytes, 0, len);

             SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");

             IvParameterSpec ivSpec = new IvParameterSpec(keyBytes);

             cipher.init(Cipher.ENCRYPT_MODE,keySpec,ivSpec);

             byte[] results = cipher.doFinal(text.getBytes("UTF-8"));

             BASE64Encoder encoder = new BASE64Encoder();

             return encoder.encode(results);

           }

}

