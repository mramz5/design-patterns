package patterns.structutral.decorator.io;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class LowerCaseInputStream extends FilterInputStream {
    public LowerCaseInputStream(InputStream in){
        super(in);
    }

    public int read() throws IOException {
        int r=in.read();
        return r==-1 ? r : Character.toLowerCase(r);
    }

    public int read(byte[] b,int offset,int length) throws IOException {
        int result=in.read(b,offset,length);
        for (int i=offset;i<offset+result;i++) {
            b[i]=(byte) Character.toLowerCase((char)b[i]);
        }
        return result;
    }
}
