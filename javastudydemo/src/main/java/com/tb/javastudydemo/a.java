package com.tb.javastudydemo;

import java.io.UnsupportedEncodingException;

import bs.s0.Hex;

public final class a {
    public a() {
    }

    private static byte[] b(byte[] var0, String var1) {
        int var2 = var0.length;
        int var3 = var1.length();
        int var4 = 0;

        int var6;
        for(int var5 = 0; var4 < var2; var5 = var6 + 1) {
            var6 = var5;
            if (var5 >= var3) {
                var6 = 0;
            }

            var0[var4] = (byte)(var0[var4] ^ var1.charAt(var6));
            ++var4;
        }

        return var0;
    }

    public String a(String var1, String var2) {
        String var3;
        try {
            byte[] var4 = Hex.a(var1, 2);
            b(var4, var2);
            var3 = new String(var4, "UTF-8");
        } catch (UnsupportedEncodingException var5) {
            byte[] var6 = Hex.a(var1, 2);
            b(var6, var2);
            var1 = new String(var6);
            return var1;
        }

        var1 = var3;
        return var1;
    }
}
