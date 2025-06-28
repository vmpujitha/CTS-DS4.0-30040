public interface ExternalApi {
    String getData();
    String getDataWithParam(String param);
    void saveData(String data);
    void processData(String data) throws Exception;
}