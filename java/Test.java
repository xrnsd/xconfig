import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.lang.Long;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;


import java.io.File;

public class Test{
    public static void main(String[] args){
        //String testVal = "24 52 43 46 53 20 31 2E 33 2C 31 2C 30 2C 39 39 39 5F 39 39 39 2C 35 30 2C 30 2C 30 5F 30 2C 31 30 30 2C 31 30 30";
        //System.out.println(byte2hex(checkSum(hex2Bytes(testVal))));
        
        // String testVal2 = "2";//01.12
        // byte[] val2 = str2Bcd(testVal2);
        // for (int i = 0; i < val2.length; i ++) {
        //     System.out.println(String.format("byte = %s , bits = %s",byte2hex(val2[i]),byteToBit(val2[i])));
        // }

        // val2 = str2Bcd_223("101.1");
        // for (int i = 0; i < val2.length; i ++) {
        //     System.out.println(String.format("byte222 = %s , bits = %s",byte2hex(val2[i]),byteToBit(val2[i])));
        // }


        // String strFilepath = "/test/ddd.txt";
        // File exitFile = new File(strFilepath);

        // System.out.println(exitFile.getParent());


    int mPlayerId;
    float mLatitude, mLongitude;
    String mDate = null, mTime = null;


    System.out.println(new StringBuilder().append("队员信息： ")
                .append("\n时间 = ").append(mDate + mTime)
                .toString());


    }

    public static byte[] str2Bcd_222(String s) {
        if(s.length() > 5){
            return null;
        }
        StringBuilder newVal = new StringBuilder();
        String[] items = s.split("\\.");
        String item;
        for (int i = items.length -1; i > -1; i--){
            item = items[i];
            if (item.length() % 2 != 0) {
                item = "0" + item;
            }
            newVal.append(item);
        }
        return str2Bcd(newVal.toString());
    }

    public static byte[] str2Bcd_223(String s) {
        if(s.length() > 5){
            return null;
        }
        String val = s.replaceAll("\\.","");
        StringBuilder newVal = new StringBuilder();
        newVal.append(val.substring(2,4));
        newVal.append(val.substring(0,2));
        return str2Bcd(newVal.toString());
    }

    public static byte[] str2Bcd_224(String s) {
        if(s.length() > 5){
            return null;
        }
        String val = s.replaceAll("\\.","");
        StringBuilder newVal = new StringBuilder();
        newVal.append(val.substring(2,4));
        newVal.append(val.substring(0,2));
        return str2Bcd(newVal.toString());
    }

    public static byte[] str2Bcd(String s) {
        if (s.length() % 2 != 0) {
            s = "0" + s;
        }
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        char[] cs = s.toCharArray();
        for (int i = 0; i < cs.length; i += 2) {
            int high = cs[i] - 48;
            int low = cs[i + 1] - 48;
            baos.write(high << 4 | low);
        }
        return baos.toByteArray();
    }

    public static String byteToBit(byte byteVal) {
        return new StringBuffer(20)
                .append((byteVal >> 7) & 0x1)
                .append((byteVal >> 6) & 0x1)
                .append((byteVal >> 5) & 0x1)
                .append((byteVal >> 4) & 0x1)
                .append((byteVal >> 3) & 0x1)
                .append((byteVal >> 2) & 0x1)
                .append((byteVal >> 1) & 0x1)
                .append((byteVal >> 0) & 0x1)
                .toString();
    }

    public static int[] byteToBitArray(byte byteVal) {
        int[] result = new int[8];
        result[0] = (byteVal >> 0) & 0x1;
        result[1] = (byteVal >> 1) & 0x1;
        result[2] = (byteVal >> 2) & 0x1;
        result[3] = (byteVal >> 3) & 0x1;
        result[4] = (byteVal >> 4) & 0x1;
        result[5] = (byteVal >> 5) & 0x1;
        result[6] = (byteVal >> 6) & 0x1;
        result[7] = (byteVal >> 7) & 0x1;
        return result;
    }

    public static byte checkSum256(byte[] msgBody, int start, int end) {
        byte val = msgBody[start];
        if (msgBody.length > 1) {
            for (int i = start + 1; i < end; i++) {
                val += msgBody[i];
            }
        }
        return val;
    }

    public static byte checkSum256(byte[] msgBody){
        byte val = msgBody[0];
        if(msgBody.length > 1){
            for(int i = 1;i < msgBody.length;i++){
                val += msgBody[i];
            }
        }
        return val;
    }


    protected static byte[] length2Bytes(int length) {
        return new byte[]{
                (byte) (length & 0xFF),
                (byte) ((length >> 8) & 0xFF)
        };
    }

    protected static int bytes2Length(byte[] value) {
        int temp0 = value[1] & 0xFF;
        int temp1 = value[0] & 0xFF;
        return ((temp0 << 8) + temp1);
    }

    /**
     * action: 时间戳转UTC时间 <br/>
     * System.currentTimeMillis()获取的为UTC时间戳
     */
    public static String formatUTCTimeByMilSecond(long milSecond, String pattern) {
        // Date date = new Date(milSecond);
        // SimpleDateFormat format = new SimpleDateFormat(pattern);
        // return format.format(date);


            Calendar.getInstance().setTimeInMillis(milSecond);
        return new SimpleDateFormat(pattern).format(Calendar.getInstance().getTime());
    }

    public static String bytes2hex(byte[] buffer) {
        StringBuilder hexStrBuffer = new StringBuilder(buffer.length);
        for (int i = 0, length = buffer.length; i < length; i++) {
            hexStrBuffer.append(byte2hex(buffer[i]));
            if (i < length - 1)
                hexStrBuffer.append(" ");
        }
        return hexStrBuffer.toString();
    }

    public static String byte2hex(byte buffer) {
        return String.format("%02x", new Object[]{buffer}).toUpperCase();
        //return Integer.toHexString(buffer & 0xFF).toUpperCase();
    }

    /**
     * 校验结果
     *
     * @param bytes
     * @param index 校验和结果所在的下标
     * @return 是否成功
     */
    public static boolean checkSum(byte[] bytes, int index) {
        if (index > bytes.length - 1) {
            return false;
        }
        byte right = bytes[index];
        int plus = 0;
        for (int i = 0; i < bytes.length; i++) {
            if (index != i) {
                plus += bytes[i];
            }
        }
        return int2Byte(plus) == right;
    }

    /**
     * 计算校验和
     *
     * @param bytes
     * @param length 计算检验和的数据长度
     * @return 是否成功
     */
    public static byte calculateCheckSum(byte[] bytes, int length) {
        return calculateCheckSum(bytes,0,length);
    }

    /**
     * 计算校验和
     *
     * @param bytes
     * @param length 计算检验和的数据长度
     * @return 是否成功
     */
    public static byte calculateCheckSum(byte[] bytes,int start, int length) {
        byte Xor = 0;
        if (length > bytes.length) {
            throw new RuntimeException("invalid bytes");
        }
        for (int i = start; i < length; i++) {
            Xor ^= bytes[i];
        }
        return Xor;
    }

    /**
     * 计算校验和
     *
     * @param bytes
     * @param length 计算检验和的数据长度
     * @return 是否成功
     */
    public static byte checkSum(byte[] bytes) {
        byte Xor = 0;
        for (int i = 0,length = bytes.length; i < length; i++) {
            Xor ^= bytes[i];
        }
        return Xor;
    }

    /**
     * 多个数组合并一个
     *
     * @return
     */
    public static byte[] byteMergerAll(byte[]... bytes) {
        int allLength = 0;
        for (byte[] b : bytes) {
            if (null == b)
                continue;
            allLength += b.length;
        }
        byte[] allByte = new byte[allLength];
        int countLength = 0;
        for (byte[] b : bytes) {
            if (null == b)
                continue;
            System.arraycopy(b, 0, allByte, countLength, b.length);
            countLength += b.length;
        }
        return allByte;
    }

    /**
     * 2字节bytes转int
     *
     * @param value
     * @return
     */
    public static int twoBytesToInteger(byte[] value) {
        int temp0 = value[0] & 0xFF;
        int temp1 = value[1] & 0xFF;
        return ((temp0 << 8) + temp1);
    }

    /**
     * 3字节bytes转int
     *
     * @param value
     * @return
     */
    public static int threeBytesToInteger(byte[] value) {
        int temp0 = value[0] & 0xFF;
        int temp1 = value[1] & 0xFF;
        int temp2 = value[2] & 0xFF;
        return ((temp0 << 16) + (temp1 << 8) + temp2);
    }

    /**
     * 4字节bytes转int
     *
     * @param value
     * @return
     */
    public static int fourBytesToInteger(byte[] value) {
        int temp0 = value[0] & 0xFF;
        int temp1 = value[1] & 0xFF;
        int temp2 = value[2] & 0xFF;
        int temp3 = value[3] & 0xFF;
        return ((temp0 << 24) + (temp1 << 16) + (temp2 << 8) + temp3);
    }

    /**
     * 4字节bytes转int
     *
     * @return
     */
    public static int fourBytes2Int(byte[] bytes) {
        int mask = 0xff;
        int temp;
        int n = 0;
        for (byte b : bytes) {
            n <<= 8;
            temp = b & mask;
            n |= temp;
        }
        return n;
    }

    /**
     * int转byte
     *
     * @param value int数字
     * @return byte 字节
     */
    public static byte int2Byte(int value) {
        return (byte) value;
    }

    /**
     * byte 转int
     *
     * @param value int数字
     * @return byte 字节
     */
    public static int byte2Int(byte value) {
        return value & 0xFF;
    }


    public static int bytes2Int(byte[] value) {
        if (null == value)
            return -1;
        switch (value.length) {
            case 1:
                return byte2Int(value[0]);
            case 2:
                return twoBytesToInteger(value);
            case 3:
                return threeBytesToInteger(value);
            case 4:
                return fourBytesToInteger(value);
            default:
                return -1;
        }
    }

    /**
     * int 转 2 byte数组
     *
     * @param a int数字
     * @return 2 byte 数组
     */
    public static byte[] int16ToBytes(int a) {
        return new byte[]{
                (byte) ((a >> 8) & 0xFF),
                (byte) (a & 0xFF)
        };
    }

    /**
     * int 转 3 byte数组
     *
     * @param a int数字
     * @return 4 byte 数组
     */
    public static byte[] int24ToBytes(int a) {
        return new byte[]{
                (byte) ((a >> 16) & 0xFF),
                (byte) ((a >> 8) & 0xFF),
                (byte) (a & 0xFF)
        };
    }

    /**
     * int 转 4 byte数组
     *
     * @param a int数字
     * @return 4 byte 数组
     */
    public static byte[] int32ToBytes(int a) {
        return new byte[]{
                (byte) ((a >> 24) & 0xFF),
                (byte) ((a >> 16) & 0xFF),
                (byte) ((a >> 8) & 0xFF),
                (byte) (a & 0xFF)
        };
    }

    /**
     * byte字节转Bit
     * bit位（0～8位）是从右往左数的 eg:10000011 (位0：1，位2：1，位3：0)
     *
     * @param b        字节
     * @param bitIndex 获取bit位的下标
     * @return bit
     */
    public static byte byteToBit(byte b, int bitIndex) {
        byte[] array = new byte[8];
        for (int i = 7; i >= 0; i--) {
            array[i] = (byte) (b & 1);
            b = (byte) (b >> 1);
        }
        //倒序取
        return array[8 - 1 - bitIndex];
    }

    public static byte[] hex2Bytes(String str) {
        if (str == null || str.trim().equals("")) {
            return new byte[0];
        }
       str=str.replaceAll(" ","");
        byte[] bytes = new byte[str.length() / 2];
        for (int i = 0; i < str.length() / 2; i++) {
            String subStr = str.substring(i * 2, i * 2 + 2);
            bytes[i] = (byte) Integer.parseInt(subStr, 16);
        }
        return bytes;
    }
}
