import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;

public class AWS {
    public static void main(String[] args) {
        S3Client s3Client = S3Client.builder().build();
        String objectKey = "your-object-key";
        String filePath = "path/to/your/file.txt";

        PutObjectRequest request = PutObjectRequest.builder()
            .bucket("my-write-bucket")
            .key(objectKey)
            .build();

        GetObjectRequest request2 = GetObjectRequest.builder()
                .key(objectKey)
                .bucket("my-read-bucket")
                .build();


        GetObjectRequest request3 = GetObjectRequest.builder()
                .key(objectKey)
                .bucket("another-read-bucket")
                .build();

        ResponseBytes<GetObjectResponse> objectBytes = s3Client.getObjectAsBytes(request2);
            byte[] data = objectBytes.asByteArray();

            // Write the data to a local file.
            File myFile = new File(filePath);
            OutputStream os = new FileOutputStream(myFile);
            os.write(data);
            System.out.println("Successfully obtained bytes from an S3 object");
            os.close();

        s3Client.putObject(request, RequestBody.fromFile(new File(filePath));
        s3Client.close();
    }
}
