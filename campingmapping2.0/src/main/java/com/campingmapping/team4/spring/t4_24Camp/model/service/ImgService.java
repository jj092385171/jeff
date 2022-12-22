package com.campingmapping.team4.spring.t4_24Camp.model.service;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;

import javax.sql.rowset.serial.SerialBlob;

public class ImgService {
	
	public static Blob fileToBlob(InputStream is, long size) throws IOException, SQLException {
		byte[] b = new byte[(int)size];
		SerialBlob sb = null;
		is.read(b);
		sb = new SerialBlob(b);
		return sb;
	}

}
