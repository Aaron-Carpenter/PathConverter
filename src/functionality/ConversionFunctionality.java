package functionality;


public class ConversionFunctionality {
    public static String convertPath(String path) {
        return path.replace("\\", "/").replace("\"", "");
    }
}


