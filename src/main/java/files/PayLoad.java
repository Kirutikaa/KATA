package files;

public class PayLoad {
    public static  String postMessageRequest()
    {
        return "{\n" +
                "  \"name\": \"moni\",\n" +
                "  \"email\": \"moni@gmail.com\",\n" +
                "  \"phone\": \"123456789108\",\n" +
                "  \"subject\": \"booking room \",\n" +
                "  \"description\": \"booking room for two family\"\n" +
                "}";
    }


    public static  String postMessageIncorrectEmailRequest()
    {
        return "{\n" +
                "  \"name\": \"moni\",\n" +
                "  \"email\": \"moni\",\n" +
                "  \"phone\": \"123456789108\",\n" +
                "  \"subject\": \"booking room \",\n" +
                "  \"description\": \"booking room for two family\"\n" +
                "}";
    }
}
