package com.osproject.shell.client.utils;

import java.security.MessageDigest;

public class Hasher {

    public Hasher() {
    }

    public String hash(String clear) throws Exception {

        MessageDigest md = MessageDigest.getInstance("SHA256");
        md.reset();
        byte[] b = md.digest(clear.getBytes());

        int size = b.length;
        StringBuilder h = new StringBuilder(size);
        for (int i = 0; i < size; i++) {
            int u = b[i] & 255; // unsigned conversion
            if (u < 16) {
                h.append("0").append(Integer.toHexString(u));
            } else {
                h.append(Integer.toHexString(u));
            }
        }
        return h.toString();
    }

}
