public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        String json = "{\"status\":2,\"data\":[{\"valid\":10,\"av_hashrate\":1383180.0140000001,\"rejected\":1,\"time\":22,\"id\":0,\"powerplan\":0,\"hwerrors\":44,\"fanspeed\":\"2100rpm/2160rpm/2160rpm/2160rpm\",\"accepted\":18,\"CPB_name\":\"NULL\",\"hwerr_ration\":0.048649,\"nonces\":876,\"hashrate\":1638441.6,\"temp\":\"44.9°C\",\"minerstatus\":0},{\"valid\":10,\"av_hashrate\":1342612.8380000001,\"rejected\":1,\"time\":22,\"id\":1,\"powerplan\":0,\"hwerrors\":17,\"fanspeed\":\"2100rpm/2160rpm/2160rpm/2160rpm\",\"accepted\":13,\"CPB_name\":\"NULL\",\"hwerr_ration\":0.021439,\"nonces\":824,\"hashrate\":1559699.9930000001,\"temp\":\"48.4°C\",\"minerstatus\":0},{\"valid\":10,\"av_hashrate\":1316651.1129999998,\"rejected\":2,\"time\":22,\"id\":2,\"powerplan\":0,\"hwerrors\":42,\"fanspeed\":\"2100rpm/2160rpm/2160rpm/2160rpm\",\"accepted\":17,\"CPB_name\":\"NULL\",\"hwerr_ration\":0.049449,\"nonces\":835,\"hashrate\":1352612.6719999999,\"temp\":\"46.3°C\",\"minerstatus\":0},{\"valid\":10,\"av_hashrate\":1361550.67,\"rejected\":2,\"time\":22,\"id\":3,\"powerplan\":0,\"hwerrors\":22,\"fanspeed\":\"2100rpm/2160rpm/2160rpm/2160rpm\",\"accepted\":18,\"CPB_name\":\"NULL\",\"hwerr_ration\":0.026412,\"nonces\":841,\"hashrate\":1801544.1780000001,\"temp\":\"44.7°C\",\"minerstatus\":0}]}";
        System.out.println((json));
        ObjectMapper mapper = new ObjectMapper();
        Datum data = mapper.readValue(jsonString, Library.class);
        
    }   
}
