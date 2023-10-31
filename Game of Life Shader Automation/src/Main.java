public class Main {

    public static String fileTemp = "#pragma kernel CSMain\n" +
            "\n" +
            "RWTexture2D<float4> Result;\n" +
            "\n" +
            "float xPos;\n" +
            "float yPos;\n" +
            "\n" +
            "[numthreads(1, 1, 1)]\n" +
            "void CSMain(uint3 id : SV_DispatchThreadID)\n" +
            "{";

    public static void main(String[] args) {
        System.out.println(fileTemp + "\n}");
    }
}