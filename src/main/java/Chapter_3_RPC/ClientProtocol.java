package Chapter_3_RPC;

import java.io.IOException;

public interface ClientProtocol extends org.apache.hadoop.ipc.VersionedProtocol {
    public static final long versionID = 1L;
    String echo(String value) throws IOException;
    int add(int v1, int v2) throws IOException;
}
