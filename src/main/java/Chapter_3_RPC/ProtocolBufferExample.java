package Chapter_3_RPC;

import com.poseidon.Chapter_3_RPC.PersonProtos.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ProtocolBufferExample {
    public static void main(String[] args) {

        Person person1 = Person.newBuilder()
                .setName("Poseidon")
                .setEmail("Poseidon_yj@163.com")
                .setId(12345678)
                .addPhone(Person.PhoneNumber.newBuilder()
                            .setNumber("18576464810")
                            .setType(0))
                .addPhone(Person.PhoneNumber.newBuilder()
                            .setNumber("85650328")
                            .setType(1)).build();

        try {
            FileOutputStream output = new FileOutputStream("example.txt");
            person1.writeTo(output);
            output.close();
        }catch (Exception e){
            System.out.println("Write error" + e);
        }
        try {
            FileInputStream input = new FileInputStream("example.txt");
            Person person2 = Person.parseFrom(input);
            System.out.println("person2: " + person2);
        }catch (Exception e){
            System.out.println("Read error" + e);
        }
    }
}
