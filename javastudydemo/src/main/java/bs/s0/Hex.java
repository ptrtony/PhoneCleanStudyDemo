//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package bs.s0;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.DecoderException;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.nio.LongBuffer;
import java.nio.ShortBuffer;

public final class Hex {
    public static byte[] a(String var0, int var1) {
        return b(var0.getBytes(), var1);
    }

    public static byte[] b(byte[] var0, int var1) {
        return c(var0, 0, var0.length, var1);
    }

    private static byte[] c(byte[] var0, int var1, int var2, int var3) {
        Hex.c var4 = new Hex.c(var3, new byte[var2 * 3 / 4]);
        if (var4.a(var0, var1, var2, true)) {
            var1 = var4.b;
            var0 = var4.a;
            if (var1 == var0.length) {
                return var0;
            } else {
                byte[] var5 = new byte[var1];
                System.arraycopy(var0, 0, var5, 0, var1);
                return var5;
            }
        } else {
            throw new IllegalArgumentException("bad base-64");
        }
    }

    abstract static class b {
        byte[] a;
        int b;

        b() {
        }
    }

    private static class c extends Hex.b {
        private static final int[] f = $d2j$hex$e7feb586$decode_I("ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff3e000000ffffffffffffffffffffffff3f0000003400000035000000360000003700000038000000390000003a0000003b0000003c0000003d000000fffffffffffffffffffffffffeffffffffffffffffffffffffffffff000000000100000002000000030000000400000005000000060000000700000008000000090000000a0000000b0000000c0000000d0000000e0000000f00000010000000110000001200000013000000140000001500000016000000170000001800000019000000ffffffffffffffffffffffffffffffffffffffffffffffff1a0000001b0000001c0000001d0000001e0000001f000000200000002100000022000000230000002400000025000000260000002700000028000000290000002a0000002b0000002c0000002d0000002e0000002f00000030000000310000003200000033000000ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff");
        private static final int[] g = $d2j$hex$e7feb586$decode_I("ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff3e000000ffffffffffffffff3400000035000000360000003700000038000000390000003a0000003b0000003c0000003d000000fffffffffffffffffffffffffeffffffffffffffffffffffffffffff000000000100000002000000030000000400000005000000060000000700000008000000090000000a0000000b0000000c0000000d0000000e0000000f00000010000000110000001200000013000000140000001500000016000000170000001800000019000000ffffffffffffffffffffffffffffffff3f000000ffffffff1a0000001b0000001c0000001d0000001e0000001f000000200000002100000022000000230000002400000025000000260000002700000028000000290000002a0000002b0000002c0000002d0000002e0000002f00000030000000310000003200000033000000ffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff");
        private int c;
        private int d;
        private final int[] e;

        private c(int var1, byte[] var2) {
            super.a = var2;
            int[] var3;
            if ((var1 & 8) == 0) {
                var3 = f;
            } else {
                var3 = g;
            }

            this.e = var3;
            this.c = 0;
            this.d = 0;
        }

        public boolean a(byte[] var1, int var2, int var3, boolean var4) {
            int var5 = this.c;
            if (var5 == 6) {
                return false;
            } else {
                int var6 = var3 + var2;
                int var7 = this.d;
                byte[] var8 = super.a;
                int[] var9 = this.e;
                var3 = 0;
                int var10 = var2;
                var2 = var7;

                label142: {
                    int var11;
                    while(true) {
                        var11 = var2;
                        var7 = var3;
                        if (var10 >= var6) {
                            break;
                        }

                        int var12 = var10;
                        var7 = var2;
                        var11 = var3;
                        if (var5 == 0) {
                            while(true) {
                                var11 = var10 + 4;
                                if (var11 > var6) {
                                    break;
                                }

                                var7 = var9[var1[var10] & 255] << 18 | var9[var1[var10 + 1] & 255] << 12 | var9[var1[var10 + 2] & 255] << 6 | var9[var1[var10 + 3] & 255];
                                var2 = var7;
                                if (var7 < 0) {
                                    break;
                                }

                                var8[var3 + 2] = (byte)var7;
                                var8[var3 + 1] = (byte)(var7 >> 8);
                                var8[var3] = (byte)(var7 >> 16);
                                var3 += 3;
                                var10 = var11;
                                var2 = var7;
                            }

                            var12 = var10;
                            var7 = var2;
                            var11 = var3;
                            if (var10 >= var6) {
                                var11 = var2;
                                var7 = var3;
                                break;
                            }
                        }

                        label101: {
                            var10 = var9[var1[var12] & 255];
                            if (var5 != 0) {
                                if (var5 != 1) {
                                    if (var5 != 2) {
                                        if (var5 != 3) {
                                            if (var5 != 4) {
                                                if (var5 != 5) {
                                                    var2 = var5;
                                                    var3 = var11;
                                                } else {
                                                    var2 = var5;
                                                    var3 = var11;
                                                    if (var10 != -1) {
                                                        this.c = 6;
                                                        return false;
                                                    }
                                                }
                                            } else if (var10 == -2) {
                                                var2 = var5 + 1;
                                                var3 = var11;
                                            } else {
                                                var2 = var5;
                                                var3 = var11;
                                                if (var10 != -1) {
                                                    this.c = 6;
                                                    return false;
                                                }
                                            }
                                        } else if (var10 >= 0) {
                                            var7 = var10 | var7 << 6;
                                            var8[var11 + 2] = (byte)var7;
                                            var8[var11 + 1] = (byte)(var7 >> 8);
                                            var8[var11] = (byte)(var7 >> 16);
                                            var3 = var11 + 3;
                                            var2 = 0;
                                        } else if (var10 == -2) {
                                            var8[var11 + 1] = (byte)(var7 >> 2);
                                            var8[var11] = (byte)(var7 >> 10);
                                            var3 = var11 + 2;
                                            var2 = 5;
                                        } else {
                                            var2 = var5;
                                            var3 = var11;
                                            if (var10 != -1) {
                                                this.c = 6;
                                                return false;
                                            }
                                        }
                                        break label101;
                                    }

                                    if (var10 < 0) {
                                        if (var10 == -2) {
                                            var8[var11] = (byte)(var7 >> 4);
                                            var3 = var11 + 1;
                                            var2 = 4;
                                        } else {
                                            var2 = var5;
                                            var3 = var11;
                                            if (var10 != -1) {
                                                this.c = 6;
                                                return false;
                                            }
                                        }
                                        break label101;
                                    }
                                } else if (var10 < 0) {
                                    var2 = var5;
                                    var3 = var11;
                                    if (var10 != -1) {
                                        this.c = 6;
                                        return false;
                                    }
                                    break label101;
                                }

                                var2 = var10 | var7 << 6;
                            } else {
                                if (var10 < 0) {
                                    var2 = var5;
                                    var3 = var11;
                                    if (var10 != -1) {
                                        this.c = 6;
                                        return false;
                                    }
                                    break label101;
                                }

                                var2 = var10;
                            }

                            var3 = var5 + 1;
                            var7 = var2;
                            var2 = var3;
                            var3 = var11;
                        }

                        var10 = var12 + 1;
                        var5 = var2;
                        var2 = var7;
                    }

                    if (!var4) {
                        this.c = var5;
                        this.d = var11;
                        super.b = var7;
                        return true;
                    }

                    if (var5 != 1) {
                        if (var5 == 2) {
                            var8[var7] = (byte)(var11 >> 4);
                            ++var7;
                            break label142;
                        }

                        if (var5 == 3) {
                            var2 = var7 + 1;
                            var8[var7] = (byte)(var11 >> 10);
                            var7 = var2 + 1;
                            var8[var2] = (byte)(var11 >> 2);
                            break label142;
                        }

                        if (var5 != 4) {
                            break label142;
                        }

                        this.c = 6;
                    } else {
                        this.c = 6;
                    }

                    return false;
                }

                this.c = var5;
                super.b = var7;
                return true;
            }
        }

        private static long[] $d2j$hex$e7feb586$decode_J(String src) {
            byte[] d = new byte[0];
            try {
                d = com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.binary.Hex.decodeHex(src.toCharArray());
            } catch (DecoderException decoderException) {
                decoderException.printStackTrace();
            }
            ByteBuffer b = ByteBuffer.wrap(d);
            b.order(ByteOrder.LITTLE_ENDIAN);
            LongBuffer s = b.asLongBuffer();
            long[] data = new long[d.length / 8];
            s.get(data);
            return data;
        }

        private static int[] $d2j$hex$e7feb586$decode_I(String src) {
            byte[] d = new byte[0];
            try {
                d = com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.binary.Hex.decodeHex(src.toCharArray());
            } catch (DecoderException decoderException) {
                decoderException.printStackTrace();
            }
            ByteBuffer b = ByteBuffer.wrap(d);
            b.order(ByteOrder.LITTLE_ENDIAN);
            IntBuffer s = b.asIntBuffer();
            int[] data = new int[d.length / 4];
            s.get(data);
            return data;
        }

        private static short[] $d2j$hex$e7feb586$decode_S(String src) {
            byte[] d = new byte[0];
            try {
                d = com.google.firebase.crashlytics.buildtools.reloc.org.apache.commons.codec.binary.Hex.decodeHex(src.toCharArray());
            } catch (DecoderException decoderException) {
                decoderException.printStackTrace();
            }
            ByteBuffer b = ByteBuffer.wrap(d);
            b.order(ByteOrder.LITTLE_ENDIAN);
            ShortBuffer s = b.asShortBuffer();
            short[] data = new short[d.length / 2];
            s.get(data);
            return data;
        }

        private static byte[] $d2j$hex$e7feb586$decode_B(String src) {
            char[] d = src.toCharArray();
            byte[] ret = new byte[src.length() / 2];

            for(int i = 0; i < ret.length; ++i) {
                char h = d[2 * i];
                char l = d[2 * i + 1];
//                int hh = false;
                int hh;
                if (h >= '0' && h <= '9') {
                    hh = h - 48;
                } else if (h >= 'a' && h <= 'f') {
                    hh = h - 97 + 10;
                } else {
                    if (h < 'A' || h > 'F') {
                        throw new RuntimeException();
                    }

                    hh = h - 65 + 10;
                }

//                int ll = false;
                int ll;
                if (l >= '0' && l <= '9') {
                    ll = h - 48;
                } else if (l >= 'a' && l <= 'f') {
                    ll = h - 97 + 10;
                } else {
                    if (l < 'A' || l > 'F') {
                        throw new RuntimeException();
                    }

                    ll = h - 65 + 10;
                }

                d[i] = (char)(hh << 4 | ll);
            }

            return ret;
        }
    }
}
