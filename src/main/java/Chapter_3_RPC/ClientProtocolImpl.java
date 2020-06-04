package Chapter_3_RPC;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.ProtocolSignature;
import org.apache.hadoop.ipc.RPC;
import org.apache.hadoop.ipc.Server;

import java.io.IOException;

public class ClientProtocolImpl implements ClientProtocol{

    public long getProtocolVersion(String protocol, long clientVersion) {
        return ClientProtocol.versionID;
    }

    public ProtocolSignature getProtocolSignature(String protocol, long clientVersion,
                                                  int hashcode){
        return new ProtocolSignature(ClientProtocol.versionID,null);
    }
    public String echo(String value) throws IOException{
        return value;
    }
    public int add(int v1, int v2) throws IOException{
        System.out.println("我被调用了！");
        return v1 + v2;
    }

    public static void main(String[] args) throws IOException {
        Configuration conf = new Configuration();
        Server server = new RPC.Builder(conf).setProtocol(ClientProtocol.class)
                .setInstance(new ClientProtocolImpl()).setBindAddress("127.0.0.1").setPort(8899)
                .setNumHandlers(5).build();
        server.start();
        System.out.println("RPC server ready！");
    }
}
