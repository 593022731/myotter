package com.binlog;

import java.io.File;
import java.io.IOException;

import com.github.shyiko.mysql.binlog.BinaryLogFileReader;
import com.github.shyiko.mysql.binlog.event.Event;
import com.github.shyiko.mysql.binlog.event.EventHeaderV4;
import com.github.shyiko.mysql.binlog.event.deserialization.ChecksumType;
import com.github.shyiko.mysql.binlog.event.deserialization.EventDeserializer;

public class ParseBinlog {
	public static void main(String[] args) throws IOException {
		String filePath = "D:\\mysql-bin.000358";
		File binlogFile = new File(filePath);
		EventDeserializer eventDeserializer = new EventDeserializer();
		eventDeserializer.setChecksumType(ChecksumType.CRC32);
		BinaryLogFileReader reader = new BinaryLogFileReader(binlogFile,
				eventDeserializer);
		try {
			for (Event event; (event = reader.readEvent()) != null;) {
				EventHeaderV4 header = event.getHeader();

				if (header.getPosition() == 25859080L) {
					System.out.println(event);
				}

				long timestamp = header.getTimestamp();
				if (timestamp == 1535272531000L
						&& header.getPosition() == 25859080L) {
					System.out.println(event);
				}
				System.out.println(event.toString());
			}
		} finally {
			reader.close();
		}

	}
}
