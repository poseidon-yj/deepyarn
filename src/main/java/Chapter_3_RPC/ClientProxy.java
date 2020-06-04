package Chapter_3_RPC;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;

import java.io.IOException;
import java.net.InetSocketAddress;

public class ClientProxy {
    public static void main(String[] args) throws IOException {
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1",8899);
        ClientProtocol proxy = (ClientProtocol) RPC.getProxy(ClientProtocol.class,
                ClientProtocol.versionID, inetSocketAddress,new Configuration());
        int result = proxy.add(10, 23);
        System.out.println("10+23=" + result);
    }
}
