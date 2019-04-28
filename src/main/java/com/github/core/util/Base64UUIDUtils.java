package com.github.core.util;

import org.apache.tomcat.util.codec.binary.Base64;

import java.util.UUID;

/**
 * @author TonyTonyChopper
 */
public class Base64UUIDUtils {

    private static UUID bytes2UUID(byte[] byteArray) {
        long msb = 0;
        long lsb = 0;
        for (int i = 0; i < 8; i++) {
            msb = (msb << 8) | (byteArray[i] & 0xff);
        }
        for (int i = 8; i < 16; i++) {
            lsb = (lsb << 8) | (byteArray[i] & 0xff);
        }
        return new UUID(msb, lsb);
    }

    private static byte[] uuid2Bytes(UUID uuid) {
        long msb = uuid.getMostSignificantBits();
        long lsb = uuid.getLeastSignificantBits();
        byte[] buffer = new byte[16];

        for (int i = 0; i < 8; i++) {
            buffer[i] = (byte) (msb >>> 8 * (7 - i));
        }
        for (int i = 8; i < 16; i++) {
            buffer[i] = (byte) (lsb >>> 8 * (7 - i));
        }
        return buffer;
    }

    public static String encode(UUID uuid) {
        byte[] tmp = Base64.encodeBase64(uuid2Bytes(uuid));
        //cVQEY/ZoRWmofpnOl7nyZQ== 末尾==可以去掉
        return new String(tmp, 0, tmp.length - 2);
    }

    public static UUID decode(String base64uuid) {
        byte[] tmp = Base64.decodeBase64(base64uuid);
        return bytes2UUID(tmp);
    }

    public static String randomID() {
        return encode(UUID.randomUUID());
    }

}
