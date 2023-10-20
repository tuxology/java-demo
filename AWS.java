import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

public class AWS {
    public static void main(String[] args) {
        S3Client s3Client = S3Client.builder().build();
        String firstName = "name";
        String objectKey = "your-object-key";
        String filePath = "path/to/your/file.txt";

        PutObjectRequest request = PutObjectRequest.builder()
            .bucket(firstName)
            .key(objectKey)
            .build();

        s3Client.putObject(request, RequestBody.fromFile(new File(filePath));
        s3Client.close();
    }
}