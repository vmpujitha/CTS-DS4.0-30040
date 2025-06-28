public class MyService {
    private final ExternalApi externalApi;

    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    public String fetchData() {
        return externalApi.getData();
    }

    public String fetchDataWithParam(String param) {
        return externalApi.getDataWithParam(param);
    }

    public void storeData(String data) {
        externalApi.saveData(data);
    }

    public void processAndStore(String data) throws Exception {
        externalApi.processData(data);
        externalApi.saveData(data);
    }
}